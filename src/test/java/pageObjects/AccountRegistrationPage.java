package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// Elements
		@FindBy(id = "firstname")
		WebElement txtFirstname;

		@FindBy(id = "lastname")
		WebElement txtLasttname;

		@FindBy(id = "email_address")
		WebElement txtEmail;

		//@FindBy(id = "userNumber")
		//WebElement txtTelephone;

		//@FindBy(css = "label[for='gender-radio-1']")
		//WebElement Gender;

		@FindBy(name = "password")
		WebElement txtPassword;

		@FindBy(name = "password_confirmation")
		WebElement txtConfirmPassword;

		@FindBy(xpath = "//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
		WebElement btnContinue;

		@FindBy(xpath = "//span[@class='base']")
		WebElement msgConfirmation;

		public void setFirstName(String fname) {
			txtFirstname.sendKeys(fname);

		}

		public void setLastName(String lname) {
			txtLasttname.sendKeys(lname);

		}

		public void setEmail(String email) {
			txtEmail.sendKeys(email);

		}

		//public void setTelephone(String tel) {
		//	txtTelephone.sendKeys(tel);

		//}

		//public void setGender() {
		//	Gender.click();

		//}

	public void setConfirmPassword(String pwd) {
			txtPassword.sendKeys(pwd);

		}
	
	public void setPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);

	}


	/*public void setPrivacyPolicy(String pwd) {
			chkdPolicy.sendKeys(pwd);

		}*/

		public void clickContinue() {
			//sol1 
			btnContinue.click();
			
			//sol2 
			//btnContinue.submit();
			
			//sol3
			//Actions act=new Actions(driver);
			//act.moveToElement(btnContinue).click().perform();
						
			//sol4
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			//js.executeScript("arguments[0].click();", btnContinue);
			
			//Sol 5
			//btnContinue.sendKeys(Keys.RETURN);
			
			//Sol6  
			//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//mywait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
			
		}

		public String getConfirmationMsg() {
			
		return (msgConfirmation.getText());
			 
				
			
		}
}