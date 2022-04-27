package main;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	
	public AndroidDriver<MobileElement> driver;
	@BeforeSuite
	public void setupDriver() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		URL appiumURL = new URL("http://127.0.0.1:4723/wd/hub/");
		
		cap.setCapability("appium:deviceName", "Samsung Galaxy S8 Plus");
		cap.setCapability("platformName", "Android");
		cap.setCapability("appium:platformVersion", "7.0");
		cap.setCapability("appium:app", "bs://74a1b6dee487bf6d9f2510394a2deafc82ec0682");
		cap.setCapability("appium:device", "Samsung Galaxy S8 Plus");
		cap.setCapability("appium:ensureWebviewsHavePages", true);
		cap.setCapability("appium:nativeWebScreenshot", true);
		//cap.setCapability("bstack:options", {"source":"appiumdesktop"});
		cap.setCapability("appium:newCommandTimeout", 3600);
		cap.setCapability("appium:connectHardwareKeyboard", true);

		
		
		String userName = "shaileshgohel_kR4gyt";
		  String accessKey = 
		
		
		
		/*
		 * cap.setCapability("platformName", "Android");
		 * cap.setCapability("appium:deviceName", "Android SDK built for x86");
		 * cap.setCapability("appium:platformVersion", "11");
		 * cap.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
		 * cap.setCapability("appium:appPackage","io.appium.android.apis");
		 */
		
		/*
		 * cap.setCapability("platformName", "Android");
		 * cap.setCapability("platformVersion", "10");
		 * cap.setCapability("deviceName","motorola one power");
		 * cap.setCapability("app",
		 * "C:/Users/shailesh.gohel/Downloads/ApiDemos-debug.apk");
		 */
		
		//driver = new AndroidDriver<MobileElement>(appiumURL, cap);
		  driver = new AndroidDriver<MobileElement>(new URL
				  ("https://"+userName+":"+accessKey+"@hub-cloud.browserstack.com/wd/hub"), cap);
	}
	
	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}
	

}
