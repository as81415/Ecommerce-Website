package Stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Testcomponents.BaseTest;
import Testcomponents.TextContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.ProductCatalogue;



public class stepdefination extends BaseTest{
	public WebDriver driver;
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public CheckoutPage checkoutpage;
	public ConfirmationPage confirmationpage;
	TextContextSetup textcontextsetup;
	
	public stepdefination(TextContextSetup textcontextsetup)
	{
		this.textcontextsetup=textcontextsetup;
		landingpage=textcontextsetup.pageobjectmanager.getlandingpage();
		productcatalogue=textcontextsetup.pageobjectmanager.productcataloguepage();
		
	}
	

	@Given("I landed on Ecommerce page")
	public void i_landed_on_ecommerce_page() {
		Assert.assertTrue(landingpage.gettitlelandingpage().contains("Shop"));
	    
	}
	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_with_username_name_and_password_password(String usernname,String password ) {
	    
		landingpage.loginApplication(usernname,password);
	}
	@When("^I add product (.+) to cart$")
	public void i_add_product_product_name_to_cart(String productname) throws InterruptedException {
	    
		
		List<WebElement> product=productcatalogue.getproductbylist();
		productcatalogue.addproducttocart(productname);
	}
	@When("^Checkout (.+) and submit the order$")
	public void checkout_product_name_and_submit_the_order(String productname) {
	   
		CartPage cartpage=textcontextsetup.pageobjectmanager.getcartpage();
		productcatalogue.gotocartpage();
		Boolean match=cartpage.verifyproductdisplay(productname);
		System.out.println(match);
		Assert.assertTrue(match);
		cartpage.gotocheckout();
	}
	@When("^Select (.+) and place the order$")
	public void select_country_name_and_place_the_order(String countryname) {
	    
		checkoutpage=textcontextsetup.pageobjectmanager.getcheckoutpage();
		checkoutpage.selectcountry(countryname);
		checkoutpage.placeorder();
	}
	@Then("{string} is displayed on the screen")
	public void is_displayed_on_the_screen(String string) {
		
		confirmationpage=textcontextsetup.pageobjectmanager.getconfirmationpage();
		String confirmationmessage=confirmationpage.getconfirmationMessage();
		System.out.println(confirmationmessage);
		Assert.assertTrue(confirmationmessage.equalsIgnoreCase(string));
		//driver.close();
		
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    Assert.assertEquals(string,landingpage.geterrormessage());
	}



}
