package methods;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MethodClass {

	public void scrollViaCordinates(int longX, int longY, int moveX, int moveY, AndroidDriver driver) {
		
		TouchAction action = new TouchAction(driver);
		action.longPress(LongPressOptions.longPressOptions().withPosition(new PointOption().
				withCoordinates(longX, longY)))
				.moveTo(new PointOption().withCoordinates(moveX, moveY)).release().perform();
	}
}
