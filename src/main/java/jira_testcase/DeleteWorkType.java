package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class DeleteWorkType extends BaseClass {
	
	@Test
	public void deleteworktype() throws InterruptedException {
		 driver.findElement(By.xpath("//div[@part='input-container']/input")).click();
		    driver.findElement(By.xpath("//div[@part='input-container']/input")).sendKeys("Salesforce Automation by Indhulekha");
		    driver.findElement(By.xpath("//div[@part='input-container']/input")).sendKeys(Keys.ENTER);
		    
		    driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//span[text()='Show Actions']/parent::span")).click();
		
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		  
		String text = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
			System.out.println(text);
			
			if(text.contains("deleted")) {
				System.out.println("The Work Type Group is deleted Successfully");
			} else {
				System.out.println("The Work Type Group is not deleted Successfully");
			}
		
		}
	}


