package Tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Testcomponents.BaseTest;
import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.ConfirmationPage;
import pageobjects.LandingPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalogue;

public class SubmitOrderTest{
		
		public static void main(String[] args) throws IOException, InterruptedException
		{
		// TODO Auto-generated method stub
		String productname="ZARA COAT 3";
			
		Boolean match=false;
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		LandingPage landingpage=new LandingPage(driver);
		landingpage.openurl();
		landingpage.loginApplication("aakashsinha@gmail.com","Kohli*9079");
		//ProductCatalogue productcatalogue=landingpage.loginApplication("aakashsinha@gmail.com","Kohli*9079");
		ProductCatalogue productcatalogue=new ProductCatalogue(driver);
		List<WebElement> product=productcatalogue.getproductbylist();
		productcatalogue.addproducttocart(productname);
		CartPage cartpage=new CartPage(driver);
		productcatalogue.gotocartpage();
		match=cartpage.verifyproductdisplay(productname);
		System.out.println(match);
		Assert.assertTrue(match);
		cartpage.gotocheckout();
		CheckoutPage checkoutpage=new CheckoutPage(driver);
		checkoutpage.selectcountry("india");
		checkoutpage.placeorder();
		ConfirmationPage confirmationpage=new ConfirmationPage(driver);
		String confirmationmessage=confirmationpage.getconfirmationMessage();
		System.out.println(confirmationmessage);
		Assert.assertTrue(confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();
	

	}
	
}
