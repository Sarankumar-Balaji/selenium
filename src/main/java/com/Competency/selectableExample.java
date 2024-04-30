package com.Competency;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class selectableExample {
	static WebDriver driver;
	static Actions action;
	public static void launch()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/list.xhtml");
	}

	public static void picklist()
	{
		WebElement element1 = driver.findElement(By.xpath("//div[text()='From']/following::li[1]"));
		WebElement element2 = driver.findElement(By.xpath("//div[text()='From']/following::li[2]"));
		WebElement element3 = driver.findElement(By.xpath("//div[text()='From']/following::li[3]"));
		WebElement element4 = driver.findElement(By.xpath("//div[text()='From']/following::li[4]"));
		action.keyDown(Keys.CONTROL).click(element1).click(element3).keyUp(Keys.CONTROL).build().perform();
		driver.findElement(By.xpath("//span[text()='Add']")).click();
		
		action.clickAndHold(element1).moveToElement(element3).release().build().perform();
	}
	
	public static void main(String[] args) {
	
		launch();
		action=new Actions(driver);	
		picklist();
		
	}

}
