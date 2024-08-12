package Testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageobjects.Pageobjectmanager;

public class TextContextSetup {

	public WebDriver driver;
	public BaseTest basetest;
	public Pageobjectmanager pageobjectmanager;
	public TextContextSetup() throws IOException
	{
		basetest=new BaseTest();
		pageobjectmanager=new Pageobjectmanager(basetest.initializeDriver());
	}
}
