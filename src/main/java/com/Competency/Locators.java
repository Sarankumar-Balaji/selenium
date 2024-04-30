package com.Competency;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.get("https://www.shoppersstack.com/");
	driver.manage().window().maximize();
	
	String title = driver.getTitle();
	System.out.println("Title of the site: "+ title);
	Thread.sleep(10000);

	driver.findElement(By.id("men")).click();
	System.out.println("Men category element found by ID");
	Thread.sleep(5000);
	driver.findElement(By.name("women")).click();
	System.out.println("Women category element found by name");
	
	
	
	
	}

}
