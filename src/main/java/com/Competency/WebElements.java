package com.Competency;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElements {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.shoppersstack.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		//Login 
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//button[contains(@id,'loginB')]")).click();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("bsarankumarbalaji@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Shopperstack@12");
		driver.findElement(By.xpath("//button[@id='Login']")).click();
		
		
		// interacting with text box	
		driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Watches");

		// interacting with search button
		driver.findElement(By.id("searchBtn")).click();
		
		
		driver.navigate().to("https://rahulshettyacademy.com/loginpagePractise/");
		
		// interacting with text box
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		
		// interacting with radio button
		driver.findElement(By.xpath("//*[text()=' User']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
					
		WebElement element = driver.findElement(By.xpath("//button[@id='okayBtn']"));
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
		
		//interacting with check box
		driver.findElement(By.xpath("//input[@id='terms']")).click();
		
		//interacting with button
		driver.findElement(By.id("signInBtn")).click();
		
		//Navigates to the Check boxes page
		driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");
		List<WebElement> elements = driver.findElements(By.xpath("//form/input"));
		System.out.println("First check box is selected: "+elements.get(0).isSelected());
		System.out.println("Second check box is selected: "+elements.get(1).isSelected());
		
		elements.get(0).click();
		System.out.println("After click first check box is selected: "+elements.get(0).isSelected());
		elements.get(1).click();
		System.out.println("After click Second check box is selected: "+elements.get(1).isSelected());
		
		
		
	}

}
