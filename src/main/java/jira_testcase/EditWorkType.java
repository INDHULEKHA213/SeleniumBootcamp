package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class EditWorkType extends BaseClass{
	
	@Test
	public void editworktype() throws InterruptedException
	{
		
		    driver.findElement(By.xpath("//div[@part='input-container']/input")).click();
		    driver.findElement(By.xpath("//div[@part='input-container']/input")).sendKeys("Salesforce Automation by Indhulekha");
		    driver.findElement(By.xpath("//div[@part='input-container']/input")).sendKeys(Keys.ENTER);
		    
		    driver.findElement(By.xpath("//div[@class='slds-popover__body']")).click();
		    
		    Thread.sleep(2000);
		    driver.findElement(By.xpath("//span[text()='Show Actions']/parent::span")).click();
		    driver.findElement(By.xpath("//a[@title='Edit']")).click();
		    
		    driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).click();
		    driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Automation");
		    
		    driver.findElement(By.xpath("//label[text()='Group Type']/following-sibling::div/lightning-base-combobox")).click();
		    driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		    driver.findElement(By.xpath("//button[text()='Save']")).click();
		    
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//a[text()='Salesforce Automation by Indhulekha']")).click();
		    String text = driver.findElement(By.xpath("(//span[text()='Description'])[2]/following::span/slot/lightning-formatted-text")).getText();
	        System.out.println(text);
	        
	    
			
	        if(text.contains("Automation")) {
				System.out.println("The Work Type Group is edited Successfully");
			} else {
				System.out.println("The Work Type Group is not edited Successfully");
			}
		
		}

	
	}


