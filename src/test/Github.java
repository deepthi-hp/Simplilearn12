package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Github {
	public static void main(String[] args) {
	
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","/home/deepthihptecnot/Downloads/chromedriver");

		// System.setProperty("webdriver.gecko.driver","/home/deepthihptecnot/Downloads/geckodriver");
	        driver=new ChromeDriver();
	        driver.get("https://github.com/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);
	        
	        WebElement create=driver.findElement(By.xpath("//a[@class=\"HeaderMenu-link no-underline mr-3\"]"));
	        create.click();
	        
	        WebElement email1=driver.findElement(By.xpath("//input[@class=\"form-control input-block\"]"));
		       email1.sendKeys("Deepthi-HP");
		       
		       WebElement newpsw=driver.findElement(By.xpath("//input[@id=\"password\"]"));
		       newpsw.sendKeys("Gayathrisk$#123");
		       
		       WebElement signin=driver.findElement(By.xpath("//input[@class=\"btn btn-primary btn-block\"]"));
		       signin.click();
}
}
