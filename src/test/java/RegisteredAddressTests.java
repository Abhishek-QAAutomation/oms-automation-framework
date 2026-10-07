import org.testng.annotations.Test;

import com.vensysco.oms.base.BaseTest;
import com.vensysco.oms.pages.LoginPage;
import com.vensysco.oms.pages.ProfileDashboardPage;
import com.vensysco.oms.pages.RegisteredAddressPage;
import com.vensysco.oms.utilities.RandomDataGenerator;

public class RegisteredAddressTests extends BaseTest {
	
	//@Test
	public void verifyStateDropdownSelection() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickRegisteredAddressBtn();
		
		RegisteredAddressPage registeredAddressPage = new RegisteredAddressPage(driver);
		
	}
	
	@Test(priority = 2)
	public void verifySaveAndContinue() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmail(properties.getProperty("email"));
		loginPage.enterPassword(properties.getProperty("password"));
		loginPage.clickLoginBtn();
		
		ProfileDashboardPage profileDashboardPage = new ProfileDashboardPage(driver);
		profileDashboardPage.clickRegisteredAddressBtn();
		
		RegisteredAddressPage registeredAddressPage = new RegisteredAddressPage(driver);
		registeredAddressPage.enterResidentialAddressLine1(properties.getProperty("residentialAddress"));
		registeredAddressPage.selectResidentialState(properties.getProperty("state"));
		registeredAddressPage.selectResidentialCity(properties.getProperty("city"));
		registeredAddressPage.enterResidentialPinCode(properties.getProperty("pinCode"));
		registeredAddressPage.checkSameAsResidentialAddressCheckbox();
		
		
	}
	
	
}