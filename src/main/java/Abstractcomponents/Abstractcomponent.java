package Abstractcomponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.CartPage;
import pageobjects.OrderPage;
import pageobjects.ProductCatalogue;

public class Abstractcomponent {
	WebDriver driver;
	public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	@FindBy(css="[routerlink*='myorders']")
	WebElement order;
	public void waitforelementoappear(By findby)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitforwebelementoappear(WebElement findby)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	public void waitforelementodisappear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(1000);
		/*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.invisibilityOf(ele));*/
	}
	public void gotocartpage()
	{
		cart.click();
		
		
	}
	public OrderPage gotoorderpage()
	{
		order.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
		
	}
	
}
