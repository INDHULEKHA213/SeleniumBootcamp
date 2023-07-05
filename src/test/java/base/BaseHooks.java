package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseHooks {
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	
	@BeforeMethod
	public void beforeMethod(String url,String userName,String passWord) {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver=new ChromeDriver(options);
	
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("username")).sendKeys(userName);
		
		driver.findElement(By.id("password")).sendKeys(passWord);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM")).click();
	
	
	}
	
}