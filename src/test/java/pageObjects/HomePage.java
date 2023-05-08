package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	WebElement lnkForms;

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	WebElement loginlink;

	// Action Methods
	public void clickForms() throws InterruptedException {
		lnkForms.click();
		Thread.sleep(5000);
	}

	public void clickSignin() {
		loginlink.click();
	}
	
}
