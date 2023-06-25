package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class EditWorkType extends BaseClass{
	
	@Test
	public void editworktype() throws InterruptedException
	{
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
		    WebElement element = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		     Actions builder = new Actions(driver); 
		    builder.moveToElement(element).perform();
		    
		    driver.findElement(By.xpath("//p[text()='Work Type Groups']")).click();
		    
		    Thread.sleep(3000);
		
		
	}

}
