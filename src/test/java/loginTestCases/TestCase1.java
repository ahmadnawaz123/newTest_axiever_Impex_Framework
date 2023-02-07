package loginTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testAxiever.ObjectRepository.LoginPage;
import textAxiever.GenericUtility.ExcelFileUtility;
import textAxiever.GenericUtility.PropertyFileUtility;

public class TestCase1 {
	WebDriver driver;
	PropertyFileUtility pUtil = new PropertyFileUtility();
	ExcelFileUtility eUtil = new ExcelFileUtility();

	@Test(dataProvider="LoginCredentialsSupplier")
	public void verifyLoginWithValidvalidCredentials(String username, String password) throws IOException{
		
		//login To App
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);
		
		
	}
	
	@DataProvider(name="LoginCredentialsSupplier")
	public Object[][] supplyTestData() throws EncryptedDocumentException, IOException{
		return eUtil.readMultipleDataFromExcel("Login");
	
	}
	
	//logout
//			HomePage hp= new HomePage(driver);
//			hp.logout();
//			System.out.println("log-out successfully");
}