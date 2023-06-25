package salesforce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SF_CreateAccount extends SF_BaseClass{

	@Test
	public void createaccount() throws InterruptedException  {
		
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		Thread.sleep(3000);
		WebElement element= driver.findElement(By.xpath("//span[text()='Accounts']"));
		driver.executeScript("arguments[0].click()",element);
	     
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div")).click();
		driver.findElement(By.xpath("//label[text()='Account Name']/following-sibling::div")).sendKeys("Indhulekha J");
		
		
		driver.findElement(By.xpath("//label[text()='Ownership']/following-sibling::div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		
		Thread.sleep(3000);
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


