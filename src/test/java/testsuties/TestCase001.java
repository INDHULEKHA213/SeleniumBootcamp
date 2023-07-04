package testsuties;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testdata.TestDataProvider;


public class TestCase001 extends TestDataProvider{
	

	@BeforeTest
	public void setValues() {
		excelFileName="Register";
	}

	@Test(dataProvider="sendData")
	public void testCase1(String fName,String lName,String email,String	tPhone,String pWord,String confirmPword) throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		driver.findElement(By.name("firstname")).click();
		driver.findElement(By.name("firstname")).sendKeys(fName);
		driver.findElement(By.name("lastname")).click();
		driver.findElement(By.name("lastname")).sendKeys(lName);
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("email")).click();
		driver.findElement(By.name("telephone")).click();
		driver.findElement(By.name("telephone")).sendKeys(tPhone);
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys(pWord);
		driver.findElement(By.name("confirm")).click();
		driver.findElement(By.name("confirm")).sendKeys(confirmPword);
		
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Thread.sleep(3000);
	}
		    

		    @AfterMethod
			public void afterMethod(ITestResult result) throws IOException
			{
				if(!result.isSuccess()) {
		       File source = driver.getScreenshotAs(OutputType.FILE);
		       int ranNum=(int)(Math.random()*999999+1000000);
		       File dest = new File("./snaps/passimg"+ranNum+".png");
		       FileUtils.copyFile(source,dest);
		       
			}
				driver.close();
			}
		
	}


