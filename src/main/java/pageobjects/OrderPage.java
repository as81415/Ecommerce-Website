package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Abstractcomponents.Abstractcomponent;

public class OrderPage extends Abstractcomponent {
	public boolean match=false;
	WebDriver driver;
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderlist;
	
	public boolean verifyorderdisplay(String productname)
	{
		for(WebElement myorder:orderlist)
		{
			if(myorder.getText().equalsIgnoreCase(productname))
			{
				match=true;
				break;
			}
		}
		return match;
	}
}
