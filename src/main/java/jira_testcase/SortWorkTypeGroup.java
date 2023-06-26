package jira_testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SortWorkTypeGroup extends BaseClass{
	
	@Test
	public void sortworktype() throws InterruptedException {
		
		
		
		WebElement element = driver.findElement(By.xpath("//a[@role='button']/span[text()='Sort']/following-sibling::span[text()='Work Type Group Name']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[@role='button']/span[text()='Sort']/following-sibling::span[text()='Work Type Group Name']")).click();
	
	Thread.sleep(3000);
	String text1 = driver.findElement(By.xpath("//span[text()='Work Type Group Name']/following::span[@class='slds-assistive-text']")).getText();
	System.out.println(text1);	
		
	 if(text1.contains("Ascending")) {
		System.out.println("Work Type Group is displayed in ascending order by Work Type Group Name");
	} else {
		System.out.println("Work Type Group is not displayed in ascending order by Work Type Group Name");
	}

	}
	

}
