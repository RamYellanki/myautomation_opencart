package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
//import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickSignin();
						
			//hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			
			//lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			lp.setEmail(Extemail()); // valid email, get it from properties file
			//lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			lp.setPassword(ExtPassword()); // valid password, get it from properties file
			lp.clickLogin();
			String confmsg=lp.getConfirmationMsg();
			logger.info("Validating expected message");
			Assert.assertEquals(confmsg,"My Account");
		}
		catch(Exception e)
		{
			logger.error("test failed");
			Assert.fail();
		}
		
		logger.info(" Finished TC_002_LoginTest");
		
	}
	
	
}


