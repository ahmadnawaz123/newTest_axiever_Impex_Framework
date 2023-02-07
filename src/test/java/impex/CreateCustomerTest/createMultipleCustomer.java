package impex.CreateCustomerTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testAxiever.ObjectRepository.HomePage;
import testAxiever.ObjectRepository.newCustomer;
import textAxiever.GenericUtility.BaseClass;
import textAxiever.GenericUtility.ExcelFileUtility;
import textAxiever.GenericUtility.JavaUtility;
import textAxiever.GenericUtility.PropertyFileUtility;
import textAxiever.GenericUtility.WebDriverUtility;

public class createMultipleCustomer extends BaseClass {

	
@Test(dataProvider = "supplyMultipleCustomer")
public void createNewCustomer(String customerName, String customerAddress) throws IOException {
	
	//read all the data required for the test script
	String NEWCUSNAME = customerName+jUtil.getRandomNumber();
	String COUNTRY = pUtil.readDataFromPFile("countryName");
	String STATE = pUtil.readDataFromPFile("stateName");
	String CITY = pUtil.readDataFromPFile("cityName");
	
	String PHONE = pUtil.readDataFromPFile("phoneNo")+jUtil.getRandomNumber();
	String CUSDATE = pUtil.readDataFromPFile("customerDate");
	String CUSTOMERHEADER = pUtil.readDataFromPFile("newCustomerHeader");
	String REGION = pUtil.readDataFromPFile("regionName");
	HomePage hp = new HomePage(driver);
	
	//navigate to new customer page
	hp.clickOnCustomerMaster(driver);
	hp.clickOnNewCustomer(driver);
	
	//new customer page validation
	newCustomer nc= new newCustomer(driver);
	Assert.assertTrue(nc.newCustomerHeader().equals(CUSTOMERHEADER),"Customer page open failed");
	Reporter.log("--New Customer Page OPens successfully",true);
	
	nc.enterCustomerName(NEWCUSNAME);	
	nc.enterAddress(customerAddress);
	nc.selectCountry(COUNTRY);
	nc.selectState(STATE);
	nc.selectCity(CITY);
	nc.enterPhoneNo(PHONE);
	nc.selectRegion(REGION);
	nc.customerDate(CUSDATE);
	nc.clickOnSubmitBtn();
	Reporter.log("--New Customer created and saved successfully");
	
	
}
	@DataProvider(name = "supplyMultipleCustomer")
	
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtil.readMultipleDataFromExcel("multipleCustomer");
		
	}

}
