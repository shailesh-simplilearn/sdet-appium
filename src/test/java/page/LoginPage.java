package page;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import methods.MethodClass;

public class LoginPage {
	
	public LoginPage(AndroidDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(5)), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='Views']")
	private AndroidElement viewLink;
	@AndroidFindBy(accessibility = "Text")
	private AndroidElement el1;
	@AndroidFindBy(accessibility = "LogTextBox")
	private AndroidElement el2;
	@AndroidFindBy(accessibility = "Add")
	private AndroidElement el3;

	public void addButtonSteps() {
		MethodClass methods = new MethodClass();
		methods.cickOnElement(el1);
		methods.cickOnElement(el2);
		methods.cickOnElement(el3);
	}
	
	public void clicknViewLink() {
		viewLink.click();
	}

}
