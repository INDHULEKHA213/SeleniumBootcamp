package jira_TC_WorkType;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateWorkType extends BaseClass{
	
	@Test
	public void createworktype() throws InterruptedException, IOException {
	    
		driver.findElement(By.xpath("//one-app-nav-bar-item-root/a/span[contains(text(),'Work Type Groups')]/following::one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button")).click();
		    
		WebElement element2 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		driver.executeScript("arguments[0].click()",element2);
		
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div")).sendKeys("Salesforce Automation by Indhulekha");
		  
		driver.findElement(By.xpath("//button[text()='Save']")).click();

	    String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		
		Thread.sleep(3000);

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps_Dashboard/createDashboard.png");
		FileUtils.copyFile(source, dest);
		
		if(text.contains("created")) {
			System.out.println("The Work Type Group is created Successfully");
		} else {
			System.out.println("The Work Type Group is not created Successfully");
		}
	
	}

}
