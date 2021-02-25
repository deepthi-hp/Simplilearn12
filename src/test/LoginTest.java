package test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest {
	SoftAssert assertobj =new SoftAssert();
	ExtentReports extent;
	ExtentTest test;
WebDriver driver;
    
    @BeforeMethod
    public void setup() {

 
    	System.setProperty("webdriver.chrome.driver","/home/deepthihptecnot/Downloads/chromedriver");

		 System.setProperty("webdriver.gecko.driver","/home/deepthihptecnot/Downloads/geckodriver");
        extent=new ExtentReports("ExtentReport.html",true);
        driver = new ChromeDriver();
        driver.get("https://www.simplilearn.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
}
    @Test
    public void testcase1() {
    	 test=extent.startTest("Deepthi");
        WebElement lnklogin = driver.findElement(By.linkText("Log in"));
        lnklogin.click();
        test.log(LogStatus.PASS,"log in button is clicked");
        WebElement editUsername = driver.findElement(By.name("user_login"));
        editUsername.sendKeys("Varshini.Hebbar@tecnotree.com");
        test.log(LogStatus.PASS,"user name is entered");
        WebElement editPwd = driver.findElement(By.name("user_pwd"));
        editPwd.sendKeys("123455666");
        test.log(LogStatus.PASS," password entered");
        WebElement chkBox = driver.findElement(By.className("rememberMe"));
        chkBox.click();
        test.log(LogStatus.PASS,"Remember me is clicked");
        WebElement btnPwd = driver.findElement(By.name("btn_login"));
        btnPwd.click();
        test.log(LogStatus.PASS,"login is clicked");
WebElement error = driver.findElement(By.id("msg_box"));
        
        String ActError = error.getText();
        
        String ExpError = "The email or password you have entered is invalid";
        
        Assert.assertEquals(ActError, ExpError);
        
        assertobj.assertEquals(ActError, ExpError);
        
        System.out.println("After Failiure");
        
 }

    @AfterMethod
      public void teardown() {
        driver.quit();
       extent.endTest(test);
       extent.flush();
       extent.close();
       
 }
}
