package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
WebDriver driver;

//****** web elements*********//

@FindBy(linkText="Log in")
WebElement lnkLogin;

@FindBy(linkText="user_login")
WebElement user_login;

@FindBy(linkText="user_pwd")
WebElement editPwd;

@FindBy(linkText="rememberMe")
WebElement chkBox;

@FindBy(linkText="btn_login")
WebElement btwPwd;


public LoginPage(WebDriver testdriver) {
	this.driver=testdriver;
	PageFactory.initElements(driver,this);
}//*********Methods*******//


public void login(String Username, String Password) {

lnkLogin.click();
user_login.sendKeys(Username);

editPwd.sendKeys(Password);

chkBox.click();

btwPwd.click();
}
}