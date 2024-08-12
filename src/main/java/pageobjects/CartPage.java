package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class CartPage  extends Abstractcomponent {
	public boolean match=false;
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> mycartproducts;
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	public boolean verifyproductdisplay(String productname)
	{
		for(WebElement mycartproduct:mycartproducts)
		{
			if(mycartproduct.getText().equalsIgnoreCase(productname))
			{
				match=true;
				break;
			}
		}
		return match;
	}
	public void gotocheckout()
	{
		checkoutbutton.click();
		
	}

}
