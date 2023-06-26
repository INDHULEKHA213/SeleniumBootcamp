package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CreateWorkTypeWithoutMandatoryFields extends BaseClass{

	@Test
    public void worktypewithoutmandatoryfields() {
		
		 driver.findElement(By.xpath("//one-app-nav-bar-item-root/a/span[contains(text(),'Work Type Groups')]/following::one-app-nav-bar-item-dropdown/div/one-app-nav-bar-menu-button")).click();
		    
		    WebElement element2 = driver.findElement(By.xpath("//span[text()='New Work Type Group']"));
		    driver.executeScript("arguments[0].click()",element2);
		    
		    driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).click();
		    driver.findElement(By.xpath("//label[text()='Description']/following::textarea")).sendKeys("Automation");
		    
		    driver.findElement(By.xpath("//label[text()='Group Type']/following-sibling::div/lightning-base-combobox")).click();
		    driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		    driver.findElement(By.xpath("//button[text()='Save']")).click();
	
		    String text = driver.findElement(By.xpath("//div[@role='alert']")).getText();
		    
			if(text.contains("Complete")) {
				System.out.println("Alert message : Complete this field message is displayed for Work Type Group Name field");
			} else {
				System.out.println("Alert message : Complete this field message is not displayed for Work Type Group Name field");
			}
	
	}
	}

