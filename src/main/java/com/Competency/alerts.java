package com.Competency;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

	
public class alerts {
	static WebDriver driver;
	public static String screenshot() throws IOException 
	{
		Date date=new Date();
		String filename = date.toString().replace(" ","").replace(":","");
	
		TakesScreenshot ss= (TakesScreenshot) driver;
		File source= ss.getScreenshotAs(OutputType.FILE);
		File destination=new File("./images/Images"+filename+".png");
		FileUtils.copyFile(source, destination);	
		
		return destination.getAbsolutePath();
	}

	public static void main(String[] args) throws IOException {
		driver=new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		
		WebElement Alert1= driver.findElement(By.xpath("//*[text()=' Alert (Simple Dialog)']/parent::div/child::button"));
		Alert1.click();
		driver.switchTo().alert().accept();
			
		alerts obj = new alerts();
		obj.screenshot();
		
		
		
	}
}
