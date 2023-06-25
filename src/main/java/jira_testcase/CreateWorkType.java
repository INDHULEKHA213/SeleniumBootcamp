package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CreateWorkType extends BaseClass{
	
	@Test
	public void createworktype() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
	  
	    WebElement element = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
	     Actions builder = new Actions(driver); 
	    builder.moveToElement(element).perform();
	    
	    driver.findElement(By.xpath("//p[text()='Work Type Groups']")).click();
	    
	    Thread.sleep(3000);
	    
	    //To find uniqueness in clicking drop-down icon
	    driver.findElement(By.xpath("//one-app-nav-bar-item-root/a/span[contains(text(),'Work Type Groups')]/following::one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button")).click();
	    
	    WebElement element2 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
	    driver.executeScript("arguments[0].click()",element2);
	
	   driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div")).click();
	   driver.findElement(By.xpath("//label[text()='Work Type Group Name']/following-sibling::div")).sendKeys("Salesforce Automation by Indhulekha");
	  
	   driver.findElement(By.xpath("//button[text()='Save']")).click();

	   String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println(text);
		
		if(text.contains("created")) {
			System.out.println("Account was successfully created");
		} else {
			System.out.println("Account was not successfully created");
		}
	
	}

}
