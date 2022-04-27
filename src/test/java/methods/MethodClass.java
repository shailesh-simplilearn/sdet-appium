package methods;

import java.time.Duration;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class MethodClass {

	public void scrollViaCordinates(int longX, int longY, int moveX, int moveY, AndroidDriver driver) {
		
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withPosition(new PointOption().
				withCoordinates(longX, longY)))
				.moveTo(new PointOption().withCoordinates(moveX, moveY)).release().perform();
	}
	
	public void dragAndDrop(MobileElement dragElement, MobileElement dropElement, AndroidDriver driver) {
		new AndroidTouchAction(driver).longPress(LongPressOptions.longPressOptions().withElement(
				ElementOption.element(dragElement)))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
		.moveTo(ElementOption.element(dropElement))
		.release()
		.perform();
	}
	
	public void cickOnElement(AndroidElement element) {
		element.click();
	}
}
