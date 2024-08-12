package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class ProductCatalogue extends Abstractcomponent{
	
	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3 b")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productsby=By.cssSelector(".mb-3");
	@FindBy(css=".card-body button:last-of-type")
	WebElement addtocart;
	By toastmessage=By.cssSelector("#toast-container");
	public List<WebElement> getproductbylist()
	{
		waitforelementoappear(productsby);
		return products;
		
	}
	public void addproducttocart(String productname) throws InterruptedException
	{
		for(WebElement prod:getproductbylist())
		{
			if(prod.getText().equalsIgnoreCase(productname))
			{
				addtocart.click();
				break;
				
			}
		}
		waitforelementoappear(toastmessage);
		waitforelementodisappear(spinner);
		
	}
	
	
}
