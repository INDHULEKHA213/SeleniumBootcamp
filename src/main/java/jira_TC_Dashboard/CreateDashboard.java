package jira_TC_Dashboard;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateDashboard extends BaseClass{
	
	@Test
	public void createdashboard() throws InterruptedException, IOException {
	    
	
	    driver.findElement(By.xpath("//div[text()='New Dashboard']")).click();
	    
	    WebElement dbframe = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dbframe);
		
		driver.findElement(By.id("dashboardNameInput")).sendKeys("Salesforce Automation By Indhulekha");
	  
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		WebElement dbframe2 = driver.findElement(By.xpath("//iframe[@title='dashboard']"));
		driver.switchTo().frame(dbframe2);
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[text()='Save']")).click();

	    driver.switchTo().defaultContent();
	   String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		
		
		Thread.sleep(3000);

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps_Dashboard/createDashboard.png");
		FileUtils.copyFile(source, dest);
		
		if(text.contains("saved")) {
			System.out.println("Dashboard is created Successfully");
		} else {
			System.out.println("Dashboard is not created Successfully");
		}
	
	}

}
