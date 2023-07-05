package testsuties;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.TestDataProvider;


public class TestCase001 extends TestDataProvider{
	

	@BeforeTest
	public void setValues() {
		excelFileName="CreateLead";
	}

	@Test(dataProvider="sendData")
		public  void createLead(String cName,String fName,String lName,String dept,String desc,String email) throws InterruptedException {
			
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			driver.findElement(By.name("departmentName")).sendKeys(dept);
			driver.findElement(By.id("createLeadForm_description")).sendKeys(desc);
			driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
			
			WebElement source=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
			Select sec = new Select(source);
			sec.selectByVisibleText("New York");
			
			Thread.sleep(3000);
			driver.findElement(By.name("submitButton")).click();
			String title=driver.getTitle();
			System.out.println(title);
	}
		    

		    @AfterMethod
			public void afterMethod(ITestResult result) throws IOException
			{
				if(!result.isSuccess()) {
		       File source = driver.getScreenshotAs(OutputType.FILE);
		       int ranNum=(int)(Math.random()*999999+1000000);
		       File dest = new File("./snaps/img"+ranNum+".png");
		       FileUtils.copyFile(source,dest);
		       
			}
				driver.close();
			}
		
	}


