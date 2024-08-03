package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class LoginClass extends BaseClass{
	
	@Test
	public static void LoginTest() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("sign_in"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("email"))).sendKeys("7310685833");
		driver.findElement(By.xpath(loc.getProperty("continue"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(loc.getProperty("password"))).sendKeys("Testing@1234");
		driver.findElement(By.xpath(loc.getProperty("submit"))).click();
	}

}
