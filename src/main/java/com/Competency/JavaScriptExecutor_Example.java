package com.Competency;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.implementation.Implementation.Context.FrameGeneration;

public class JavaScriptExecutor_Example {

	static WebDriver driver;
	static JavascriptExecutor js;
	public static void launch()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
	}
	
	public static void flash(WebElement element, WebDriver driver, WebElement element1)
	{
		String bgcolor=element.getCssValue("background-color");
		String body=element1.getCssValue("background-color");
//		System.out.println(bgcolor);
		for (int i = 0; i < 10; i++) {	
			changeColor("#fe0541",element,driver);
			changeColor(bgcolor, element, driver);
//			changeColor("#b3ff4a",element1,driver);
//			changeColor(bgcolor, element1, driver);
		}		
	}

	public static void changeColor(String color, WebElement element,WebDriver driver) 
	{
		js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		//js.executeScript("arguments[0].style.backgroundColor ='"+color+"'", element);
		
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {}
				
	}	
	
	public static void border(WebElement element) 
	{
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String title()
	{
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	public static void jsclick()
	{
		WebElement Username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement Password= driver.findElement(By.xpath("//input[@id='password']"));
		WebElement Login= driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		
		Username.sendKeys("Demosalesmanager");
		Password.sendKeys("crmsfa");
		
		js.executeScript("arguments[0].click();", Login);
		
		WebElement crm = driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]"));
		crm.click();
	
		System.out.println("Element clicked");
	}
	public static void generateAlert(String message) throws InterruptedException
	{
		js.executeScript("alert('"+message+"')");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
	}
	
	public static void refresh() 
	{
		js.executeScript("history.go(0)");
	}
	public static void scrollToElement()
	{
		WebElement sub= driver.findElement(By.xpath("//tr[@class='listTableHeader']"));
		js.executeScript("arguments[0].scrollIntoView(true)", sub);
	}
	
	public static void scrollPagedown() 
	{
	 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");	
	}
	
	//main() method
	public static void main(String[] args) throws InterruptedException {
		launch();
		//WebElement joinbutton = driver.findElement(By.xpath("//a[@class='btn green']//child::span[contains(text(),'Join now for free')]"));
	
		WebElement loginbutton = driver.findElement(By.className("decorativeSubmit"));
		WebElement body = driver.findElement(By.id("container"));
		//flashing an element
		flash(loginbutton, driver,body);
		//border for an element
		border(loginbutton);
		//title for the page
		System.out.println("Title of the page: "+title());
		
		//click method using js
		jsclick();
		 
		//generating an alert
		generateAlert("User generated alert: Login success");
		
		//refresh 
//		refresh();
		
		scrollToElement();

//		scrollPagedown();
		
	}
}
