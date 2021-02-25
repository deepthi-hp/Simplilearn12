package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class CrossBrowser {

	WebDriver chromeDriver;
	WebDriver firefoxDriver;
	
	@Test
	public void LaunchChrome() {

    	System.setProperty("webdriver.chrome.driver","/home/deepthihptecnot/Downloads/chromedriver");
       chromeDriver=new ChromeDriver();
       chromeDriver.get("https://www.simplilearn.com/");
       chromeDriver.manage().window().maximize();
		chromeDriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);   
	}
	
	@Test(dependsOnMethods="LaunchChrome")
	public void testcase1() {
		WebElement lnklogin=chromeDriver.findElement(By.linkText("Log  in"));
		lnklogin.click();
	}
	
	@Test
	public void LaunchFirefox() {
		System.setProperty("webdriver.gecko.driver","/home/deepthihptecnot/Downloads/geckodriver");
		firefoxDriver = new FirefoxDriver();
		
		firefoxdriver.manage().window().maximize();
		firefoxdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS); 
	}
	
	@Test(dependsOnMethods="LaunchFireFox"))
	public void testcase2() {
		WebElement lnklogin=chromeDriver.findElement(By.linkText("Log  in"));
		lnklogin.click();
	}
}
