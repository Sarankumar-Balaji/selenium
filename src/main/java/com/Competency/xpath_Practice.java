package com.Competency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath_Practice {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.get("http://leaftaps.com/opentaps/control/main");
	
	WebElement Username = driver.findElement(By.xpath("//input[@id='username']"));
	WebElement Password= driver.findElement(By.xpath("//input[@id='password']"));
	WebElement Login= driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
	
	Username.sendKeys("Demosalesmanager");
	Password.sendKeys("crmsfa");
	Login.click();
	
	WebElement crm = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
	crm.click();
	driver.navigate().back();
	Thread.sleep(20000);
	
	WebElement logout= driver.findElement(By.xpath("//input[@value='Logout']"));
	logout.click();
	System.out.println("Logged out sucessfully....");
	

	}

}
