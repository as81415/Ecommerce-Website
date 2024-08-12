package Tests;
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

public class StandAloneTest {
	public static void main(String[] args)
	{
	Boolean match=false;
	String productname="ZARA COAT 3";
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
	driver.findElement(By.id("userEmail")).sendKeys("aakashsinha@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Kohli*9079");
	driver.findElement(By.id("login")).click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3 b"));
	for(WebElement prod:products)
	{
		if(prod.getText().equalsIgnoreCase(productname))
		{
			driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();
			break;
		}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	List<WebElement> mycartproducts=driver.findElements(By.cssSelector(".cartSection h3"));
	for(WebElement mycartproduct:mycartproducts)
	{
		if(mycartproduct.getText().equalsIgnoreCase(productname))
		{
			match=true;
		}
	}
	//System.out.println(match);
	Assert.assertTrue(match);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	Actions act=new Actions(driver);
	act.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"india").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	driver.findElement(By.cssSelector(".ta-results button:last-of-type")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	String confirmationmessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(confirmationmessage);
	Assert.assertTrue(confirmationmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	driver.close();

}
}
