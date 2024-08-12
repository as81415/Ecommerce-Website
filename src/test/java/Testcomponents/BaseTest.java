package Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pageobjects.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException
	{
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
    prop.load(fis);
    String url=prop.getProperty("url");
    String browser_properties=prop.getProperty("browser");
    String browser_maven=System.getProperty("browser");
    String browser=browser_maven!=null?browser_maven:browser_properties;
    if(driver==null)
    {
    if(browser.equalsIgnoreCase("chrome"))
    {
    	driver=new ChromeDriver();
		
    }
    
    else if (browser.equalsIgnoreCase("firefox")) 
    {
		driver = new FirefoxDriver();
    }
    else if(browser.equalsIgnoreCase("edge"))
    {
    	driver=new EdgeDriver();
		
    }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get(url);
    }
    return driver;
    }
	

	
	
}
