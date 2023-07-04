package jira_TC_WorkType;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

	public class BaseClass {
		ChromeDriver driver;
	
		
		
		@Parameters({"url","username","password"})
		
		@BeforeMethod
		public void preCondition(String url,String uname,String pword) throws InterruptedException
		{
		
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
			
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.findElement(By.id("username")).sendKeys(uname);
			driver.findElement(By.id("password")).sendKeys(pword);
			driver.findElement(By.id("Login")).click();
			
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
		  
		    WebElement element = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		     Actions builder = new Actions(driver); 
		    builder.moveToElement(element).perform();
		    
		    driver.findElement(By.xpath("//p[text()='Work Type Groups']")).click();
		    
		    Thread.sleep(3000);
		}
	  
		@AfterMethod
		public void postCondition()
		{
			driver.close();
		}
		
	}



