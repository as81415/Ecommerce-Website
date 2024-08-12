package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pageobjectmanager {
	
	public WebDriver driver;
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public CartPage cartpage;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	
	
	public Pageobjectmanager (WebDriver driver)
	{
		this.driver=driver;
	}
	public LandingPage getlandingpage()
	{
		landingpage=new LandingPage(driver);
		return landingpage;
	}
	public ProductCatalogue productcataloguepage()
	{
		productcatalogue=new ProductCatalogue(driver);
		return productcatalogue;
	}
	public CartPage getcartpage()
	{
		cartpage=new CartPage(driver);
		return cartpage;
	}
	public CheckoutPage getcheckoutpage()
	{
		checkoutpage=new CheckoutPage(driver);
		return checkoutpage;
	}
	public ConfirmationPage getconfirmationpage()
	{
		confirmationpage=new ConfirmationPage(driver);
		return confirmationpage;
	}

}
