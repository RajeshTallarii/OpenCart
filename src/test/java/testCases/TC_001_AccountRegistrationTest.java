package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	
	@Test
	public void verify_account_registration() throws InterruptedException {
		//here we are passing driver, because in homepage constructor is there,constructor is trying to invoke at runtime
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickRegister();

		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);

		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString() + "@gmail.com");// randomly generated the email
		//regpage.setTelephone(randomeNumber());

		String password = randomAlphaNumeric();

		regpage.setPassword(password);
		//regpage.setConfirmPassword(password);
		//Thread.sleep(5000);
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();

		String confmsg = regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");

	}

}
