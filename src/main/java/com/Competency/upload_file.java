package com.Competency;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class upload_file {
	
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
	public static void launch()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/file.xhtml");
	}
	public static void fileupload_Sendkeys(String path)
	{
		WebElement upload = driver.findElement(By.xpath("//h5[text()='Basic Upload']//following-sibling::form//span/input"));
		upload.sendKeys(path);
	}
	
	public static void fileupload_robotclass(String filePath) throws AWTException 
	{
		
		WebElement advanceupload = driver.findElement(By.xpath("//h5[contains(text(),'Advanced Upload')]//following-sibling::form//span/span"));
		advanceupload.click();
		
		Robot rb=new Robot();
		rb.delay(3000);
		StringSelection ss=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement uploadbtn=driver.findElement(By.xpath("//h5[contains(text(),'Advanced Upload')]//following-sibling::form//button//span[contains(text(),'Upload')]//parent::button"));
				
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click;", uploadbtn);
	}
	
	public static void ScreenshotUsingRobotclass() throws AWTException, IOException 
	{
		Date date=new Date();
		String filename = date.toString().replace(" ","").replace(":","");
		Robot rb1=new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect=new Rectangle(screenSize);
		BufferedImage bufferImage = rb1.createScreenCapture(rect);
		File destination=new File("./images/Images"+filename+".png");
		ImageIO.write(bufferImage, "png", destination);
	}
	
	
	public static void main(String[] args) throws IOException, AWTException {
		launch();
		String screenshot = screenshot();
		fileupload_Sendkeys(screenshot);
	//	fileupload_robotclass(screenshot);
		
		ScreenshotUsingRobotclass();
		
		driver.quit();
	}

}
