package main;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;

public class Base {
	
	public AndroidDriver<WebElement> driver;
	@BeforeSuite
	public void setupDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
		
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:deviceName", "Android SDK built for x86");
		cap.setCapability("appium:platformVersion", "11");
		cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		cap.setCapability("appium:appPackage","io.appium.android.apis");
		
		driver = new AndroidDriver<WebElement>(appiumURL, cap);
	}

}
