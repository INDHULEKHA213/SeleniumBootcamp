package login_using_excel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Login {
	String excelFileName;
	
	@BeforeTest
	public void setValues()
	{
		excelFileName = "Login";
	}
	
	
	@Test(dataProvider = "sendData")
	public void preCondition(String url,String uname,String pword) throws InterruptedException
	{
	
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.id("Login")).click();
		
		Thread.sleep(3000);
		String url1 = driver.getCurrentUrl();
		System.out.println(url1);
		
		if(url1.contains("home"))
		{
		System.out.println("Login is successful");
		}  else {
			System.out.println("Login is not successful");
		}
}
	@DataProvider
	public String[][] sendData() throws IOException
	{
		return LearnExcel.excelintegration(excelFileName);
	}
}
