package testBase;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;  // logging

public class BaseClass {

	public ResourceBundle rb;// to read config.properties
	public static WebDriver driver;
	public Logger logger; // for logging
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) throws InterruptedException
	{
		logger=LogManager.getLogger(this.getClass());  //logging
		
		rb = ResourceBundle.getBundle("config");// Load config.properties
		
		//WebDriverManager.chromedriver().setup();
		if(br.equals("edge"))
		{
				EdgeOptions options = new EdgeOptions();
				options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
				driver=new EdgeDriver(options);
				
		}
		else if(br.equals("firefox"))
		{
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("moz:firefoxOptions",new String[] {"enable-automation"});
			driver=new FirefoxDriver(options);
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("http://localhost/opencart/upload/index.php");
		//driver.get("https://demoqa.com/automation-practice-form");
		//driver.get("https://demoqa.com/");
		//driver.get("https://magento.softwaretestingboard.com/");
		driver.get(rb.getString("appURL"));
		driver.manage().window().maximize();
		//driver.wait(50000);
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{
		
		driver.quit();
	}
	
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public String Extemail() {
		String emailString = driver.findElement(By.xpath("//p[2]")).getText();
		String email=emailString.replaceAll("Email:", "");
		return (email);			
		
	}
	
	public String ExtPassword() {
		String PasswordString = driver.findElement(By.xpath("//p[3]")).getText();
		String Password=PasswordString.replaceAll("Email:", "");
		return (Password);			
		
	}
	
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
