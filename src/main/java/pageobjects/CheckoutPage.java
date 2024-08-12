package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Abstractcomponents.Abstractcomponent;

public class CheckoutPage extends Abstractcomponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	@FindBy(css=".ta-results button:last-of-type")
	WebElement selectcountry;
	@FindBy(css=".action__submit")
	WebElement placeorderbutton;
	By loadingcountry=By.cssSelector(".ta-results");
	


	public void selectcountry(String countryname)
	{
		Actions act=new Actions(driver);
		act.sendKeys(country,countryname).build().perform();
		waitforelementoappear(loadingcountry);
		selectcountry.click();
	}
	public void placeorder()
	{
		placeorderbutton.click();
		
	}
}
