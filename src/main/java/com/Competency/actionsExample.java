package com.Competency;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class actionsExample {

	static WebDriver driver;
	static Actions action;
	public static void launch()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	public static void get(String a)
	{
		driver.get(a);
	}
	
	public static void mouseHover()
	{
		WebElement men = driver.findElement(By.xpath("//a[text()='Men']"));
		action.moveToElement(men).perform();
		System.out.println("Mouse Hover perfomed.");
	}
	public static void rightClick()
	{
		WebElement men1 = driver.findElement(By.xpath("//i[@class='pi pi-search']"));
		action.contextClick(men1).perform();
		System.out.println("Right click perfomed.");
	}	
	public static void doubleclick()
	{
		WebElement men2 = driver.findElement(By.xpath("//a[text()='Men']"));
		action.doubleClick(men2).perform();
		System.out.println("Double click perfomed.");
	}
	
	
	public static void dragdrop()
	{
		WebElement sourceElement = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement DestinationElement = driver.findElement(By.xpath("//div[@id='form:drop']"));
		action.dragAndDrop(sourceElement, DestinationElement).build().perform();
		System.out.println("Element draged and droped.");
	}
	
	public static void draggable()
	{
		WebElement draggableElement = driver.findElement(By.xpath("//div[@id='form:conpnl']"));
		action.dragAndDropBy(draggableElement, 340, 0).build().perform();
		System.out.println("Element moved.");
	}
	
	public static void main(String[] args) {
		
		launch();
		get("https://www.myntra.com/");

		action=new Actions(driver); 
		mouseHover();
//		get("https://www.leafground.com/table.xhtml");
//		rightClick();
		doubleclick();
		
		get("https://www.leafground.com/drag.xhtml");
		dragdrop();
		
		draggable();
		action.sendKeys(Keys.F12).perform();
		
		
		
	}

}
