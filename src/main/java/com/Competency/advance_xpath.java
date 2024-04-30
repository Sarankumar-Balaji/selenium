package com.Competency;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class advance_xpath {

	public static void main(String[] args) {
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
	
	WebElement leads=driver.findElement(By.xpath("//a[text()='Leads']"));
	leads.click();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	WebElement fele=driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
	String firstid = fele.getText();

//	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
//	wait.until(ExpectedConditions.elementToBeClickable(fele));

	Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);
	WebElement profile=wait.until(new Function<WebDriver, WebElement>(){
		public WebElement apply(WebDriver driver)
		{
			return driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
			
		}
	});
	String text = profile.getText();
	
	System.out.println(text);
	 	
	}

}
