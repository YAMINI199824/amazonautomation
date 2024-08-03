package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	
	@BeforeTest
	public void setup() throws IOException
	{
		if(driver == null) {
			try {
				
				FileReader reader1 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/config.properties");
				FileReader reader2 = new FileReader(System.getProperty("user.dir")+"/src/test/resources/configfiles/locator.properties");
				prop.load(reader1);
				loc.load(reader2);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(prop.getProperty("url"));
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(prop.getProperty("url"));
		}
	}
	
	@AfterTest
	public void closeBowser()
	{
		driver.close();
		System.out.println("Bowser Close successfully");
	}
	

}
