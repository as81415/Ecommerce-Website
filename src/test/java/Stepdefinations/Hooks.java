package Stepdefinations;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import Testcomponents.TextContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {
	TextContextSetup textcontextsetup;
	public Hooks(TextContextSetup textcontextsetup)
	{
		this.textcontextsetup=textcontextsetup;
	}
	@After
	public void closebrowser() throws IOException
	{
		textcontextsetup.basetest.initializeDriver().quit();
	}
	@AfterStep
	public void addscreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver=textcontextsetup.basetest.initializeDriver();
		if(scenario.isFailed())
		{
			File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] filecontent=FileUtils.readFileToByteArray(srcfile);
			scenario.attach(filecontent, "image/png", "image");
		}
	}
}
