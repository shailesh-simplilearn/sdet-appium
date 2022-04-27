package main;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constants;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import methods.MethodClass;

public class AppiumMethods extends Base{
	
	@Test
	public void checkAlerts() throws InterruptedException {
		
		driver.findElementByAccessibilityId("App").click();
		driver.findElementByAccessibilityId("Alert Dialogs").click();
		driver.findElementById("io.appium.android.apis:id/two_buttons").click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		driver.findElementById("io.appium.android.apis:id/two_buttons2").click();
		alert.accept();
		driver.findElementById("io.appium.android.apis:id/two_buttons2ultra").click();
		System.out.println(alert.getText());
		alert.dismiss();
		Thread.sleep(3000);
	}
	@Test
	public void dragAndDrop() {
		driver.findElementByAccessibilityId("Views").click();
		driver.findElementByAccessibilityId("Drag and Drop").click();
		MobileElement dragElement =   driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		MobileElement dropElement = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		
		MethodClass methods = new MethodClass();
		methods.dragAndDrop(dragElement, dropElement, driver);
		SoftAssert softAssert = new SoftAssert();
		String message = driver.findElementById("io.appium.android.apis:id/drag_result_text").getText();
		softAssert.assertEquals(message, "Dropped!");
	
	}
	
	@Test
	public void ratingBar() {
		driver.findElementByAccessibilityId("Views").click();
		MethodClass methods = new MethodClass();
		methods.scrollViaCordinates(Constants.longX, Constants.longY, Constants.moveX, 
				Constants.moveY, driver);
	
		driver.findElementByAccessibilityId("Rating Bar").click();
		WebElement threeStartRatingBar = driver.findElement(By.id("io.appium.android.apis:id/ratingbar2"));
		int startX = threeStartRatingBar.getLocation().getX();
		int endX = threeStartRatingBar.getSize().getWidth();
		System.out.println("StartX = "+startX+"and endX = "+endX);
		int tappingPoint = (int)(endX*0.90);
		int tapY = threeStartRatingBar.getLocation().getY();
		
		new TouchAction(driver).press(new PointOption().withCoordinates(tappingPoint, tapY)).perform();

	}
	

}
