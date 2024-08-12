package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class LandingPage extends Abstractcomponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")
	WebElement useremail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void loginApplication(String email,String password)
	{
		useremail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		
		
	}
	public void openurl()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String geterrormessage()
	{
		waitforwebelementoappear(errorMessage);
		return errorMessage.getText();
	}
	public String gettitlelandingpage()
	{
		return driver.getTitle();
	}

}
