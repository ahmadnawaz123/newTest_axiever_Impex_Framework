package impex.CreateCustomerTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testAxiever.ObjectRepository.HomePage;
import testAxiever.ObjectRepository.customerPurchaseContact;
import testAxiever.ObjectRepository.newCustomer;
import textAxiever.GenericUtility.BaseClass;

public class createCustomerWithAllDetails extends BaseClass {
	
	@Test
	public void Test1() throws IOException, InterruptedException {
		//read all the data required for the test script
		String NEWCUSNAME = pUtil.readDataFromPFile("customerName")+jUtil.getRandomNumber();
		String ADDRESS = pUtil.readDataFromPFile("customerAddress");
		String COUNTRY = pUtil.readDataFromPFile("countryName");
		String STATE = pUtil.readDataFromPFile("stateName");
		String CITY = pUtil.readDataFromPFile("cityName");
		
		String PHONE = pUtil.readDataFromPFile("phoneNo")+jUtil.getRandomNumber();
		String CUSDATE = pUtil.readDataFromPFile("customerDate");
		String CUSTOMERHEADER = pUtil.readDataFromPFile("newCustomerHeader");
		String REGION = pUtil.readDataFromPFile("regionName");
		String PURTITLE = pUtil.readDataFromPFile("purchaseTitle");
		String PURFNAME= pUtil.readDataFromPFile("purchasefirstName");
		String PURLNAME = pUtil.readDataFromPFile("purchaselastName")+jUtil.getRandomNumber();
		String PUREMAIL = pUtil.readDataFromPFile(jUtil.getRandomNumber()+"purchaseEmail");
		String PURPHONE = pUtil.readDataFromPFile("purchasePhone")+jUtil.getRandomNumber();
		
		HomePage hp = new HomePage(driver);
		
		//navigate to new customer page
		hp.clickOnCustomerMaster(driver);
		hp.clickOnNewCustomer(driver);
		
		//new customer page validation
		newCustomer nc= new newCustomer(driver);
	
		Assert.assertTrue(nc.newCustomerHeader().equals(CUSTOMERHEADER),"Customer page open failed");
		Reporter.log("--New Customer Page OPens successfully",true);
		
		nc.enterCustomerName(NEWCUSNAME);	
		nc.enterAddress(ADDRESS);
		nc.selectCountry(COUNTRY);
		nc.selectState(STATE);
		nc.selectCity(CITY);
		nc.enterPhoneNo(PHONE);
		nc.selectRegion(REGION);
		nc.customerDate(CUSDATE);
		nc.clickOnSubmitBtn();
		Reporter.log("--New Customer created and saved successfully");
		
		//purchase contact
		customerPurchaseContact cpc=new customerPurchaseContact(driver);
		cpc.clickOnPurchaseContact();
		Reporter.log("--Purchase Contacts page opens--");
		cpc.selectPurchaseTitledd(PURTITLE);
		cpc.purchaseFirstName(PURFNAME);
		cpc.purchaseLastName(PURLNAME);
		cpc.purchaseEmail(PUREMAIL);
		cpc.purchasePhone(PURPHONE);
		cpc.purchaseAddbtn();
		Reporter.log("--Purchase contact added successfully--");
		
		Assert.assertTrue(cpc.getPurchaseContactTab().isSelected());
		
		//Logistics Contact
		Reporter.log("--Logistics contact page opens--");
		
		
}
}

