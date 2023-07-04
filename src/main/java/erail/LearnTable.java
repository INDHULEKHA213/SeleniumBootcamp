package erail;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnTable {
	public static void main(String[] args) {
	
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	options.addArguments("--disable-notifications-");
	ChromeDriver driver = new ChromeDriver(options);
	
	driver.get("https://erail.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
	driver.findElement(By.id("txtStationFrom")).click();
	driver.findElement(By.id("txtStationFrom")).sendKeys("MS");
	driver.findElement(By.id("txtStationFrom")).sendKeys(Keys.TAB);
	
	driver.findElement(By.id("txtStationTo")).click();
	driver.findElement(By.id("txtStationTo")).sendKeys("SBC");
	driver.findElement(By.id("txtStationTo")).sendKeys(Keys.TAB);
	
	driver.findElement(By.id("chkSelectDateOnly")).click();
	
	List<WebElement> allrows = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr"));
     int rowsize = allrows.size();
     //System.out.println(rowsize);
    
    for(int i=2; i<=rowsize; i++)
    {
    	List<WebElement> allcells = driver.findElements(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr["+i+"]/td"));
        int cellscount = allcells.size();
	
        for(int j=1 ; j<= cellscount ; j++)
        {
	String text = driver.findElement(By.xpath("//table[contains(@class,'DataTable TrainList')]//tr["+i+"]/td["+j+"]")).getText();
    System.out.println(text);
	}
}
}
}
