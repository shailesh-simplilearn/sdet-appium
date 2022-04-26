package main;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constants;
import io.appium.java_client.MobileElement;
import lombok.SneakyThrows;
import methods.MethodClass;
import page.LoginPage;

public class FirstAppiumClass extends Base {
	@Test
	public void firstAPpiumMethod() throws MalformedURLException, InterruptedException {

		/*
		 * MobileElement viewLink = driver.findElement(By.xpath(
		 * "//android.widget.TextView[@content-desc='Views']")); viewLink.click();
		 */
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clicknViewLink();
		
		Thread.sleep(3000);

	}

	@Test
	public void addTestButton() {
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Text");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("LogTextBox");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Add");
		el3.click();
		MobileElement text = (MobileElement) driver.findElement(By.id("io.appium.android.apis:id/text"));
		System.out.println("******" + text.getText());
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(text.getText(), "This is a test");
	}

	@Test
	public void scrollToElment() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
		el1.click();

		MethodClass methods = new MethodClass();
		methods.scrollViaCordinates(Constants.longX, Constants.longY, Constants.moveX, 
				Constants.moveY, driver);
		methods.scrollViaCordinates(Constants.longX, Constants.longY, Constants.moveX, 
				Constants.moveY, driver);
				
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("TextFields");
		el2.click();
		
		Thread.sleep(3000);
		MobileElement textBox1 = (MobileElement) driver.findElement
				(By.id("io.appium.android.apis:id/edit"));
		textBox1.clear();
		textBox1.sendKeys("This is Test");

	}
	@Test
	@SneakyThrows
	public void checkBox() throws InterruptedException {
		MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Views");
		el1.click();
		driver.findElementByAccessibilityId("Controls").click();
		driver.findElementByAccessibilityId("1. Light Theme").click();
		driver.findElementById("io.appium.android.apis:id/check1").click();
		driver.findElementById("io.appium.android.apis:id/check2").click();
		driver.findElementById("io.appium.android.apis:id/radio1").click();
		driver.findElementById("io.appium.android.apis:id/radio2").click();
		Thread.sleep(3000);
		
	}

	@AfterSuite
	public void closeDriver() {
		driver.quit();
	}

}
