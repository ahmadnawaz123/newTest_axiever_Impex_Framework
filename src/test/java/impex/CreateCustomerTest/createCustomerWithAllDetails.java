package impex.CreateCustomerTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testAxiever.ObjectRepository.HomePage;
import testAxiever.ObjectRepository.customerLogisticsContact;
import testAxiever.ObjectRepository.customerPurchaseContact;
import testAxiever.ObjectRepository.newCustomer;
import textAxiever.GenericUtility.BaseClass;

public class createCustomerWithAllDetails extends BaseClass {
	
	@Test
	public void Test1() throws IOException, InterruptedException {
		//read all the data required for the test script
		String NEWCUSNAME = pUtil.readDataFromCustomerPFile("customerName")+jUtil.getRandomNumber();
		String ADDRESS = pUtil.readDataFromCustomerPFile("customerAddress");
		String COUNTRY = pUtil.readDataFromCustomerPFile("countryName");
		String STATE = pUtil.readDataFromCustomerPFile("stateName");
		String CITY = pUtil.readDataFromCustomerPFile("cityName");
		
		String PHONE = pUtil.readDataFromCustomerPFile("phoneNo")+jUtil.getRandomNumber();
		String CUSDATE = pUtil.readDataFromCustomerPFile("customerDate");
		String CUSTOMERHEADER = pUtil.readDataFromCustomerPFile("newCustomerHeader");
		String REGION = pUtil.readDataFromCustomerPFile("regionName");
		String PURTITLE = pUtil.readDataFromCustomerPFile("purchaseTitle");
		String PURFNAME= pUtil.readDataFromCustomerPFile("purchaseFirstName");
		String PURLNAME = pUtil.readDataFromCustomerPFile("purchaseLastName")+jUtil.getRandomNumber();
		String PUREMAIL = pUtil.readDataFromCustomerPFile("purchaseEmail")+jUtil.getRandomNumber()+pUtil.readDataFromCustomerPFile("gmail");
		String PURPHONE = pUtil.readDataFromCustomerPFile("purchasePhone")+jUtil.getRandomNumber();
		String LOGTITLE = pUtil.readDataFromCustomerPFile("logisticsTitle");
		String LOGFNAME = pUtil.readDataFromCustomerPFile("logisticsFirstName");
		String LOGLNAME = pUtil.readDataFromCustomerPFile("logisticsLastName")+jUtil.getRandomNumber();
		String LOGEMAIL = pUtil.readDataFromCustomerPFile("logisticspurchaseEmail")+jUtil.getRandomNumber()+pUtil.readDataFromCustomerPFile("yahoo");
		String LOGPHONE = pUtil.readDataFromCustomerPFile("logisticspurchasePhone")+jUtil.getRandomNumber();;

		HomePage hp = new HomePage(driver);
		
		//navigate to new customer page
		hp.clickOnCustomerMaster(driver);
		hp.clickOnNewCustomer(driver);
		
		//new customer page validation
		newCustomer nc= new newCustomer(driver);
	System.out.println(CUSTOMERHEADER);
	System.out.println(nc.newCustomerHeader());
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
		System.out.println(NEWCUSNAME);
		System.out.println(nc.newCustomerAdded());
		
		Assert.assertEquals(nc.newCustomerAdded().equals(NEWCUSNAME), true);
		Reporter.log("--New Customer created and saved successfully");
		
		//purchase Contact
		customerPurchaseContact cpc=new customerPurchaseContact(driver);
		cpc.clickOnPurchaseContact();
		Reporter.log("--Purchase Contacts page opens--",true);
		cpc.selectPurchaseTitledd(PURTITLE);
		cpc.purchaseFirstName(PURFNAME);
		cpc.purchaseLastName(PURLNAME);
		cpc.purchaseEmail(PUREMAIL);
		cpc.purchasePhone(PURPHONE);
		cpc.purchaseAddbtn();
		Reporter.log("--Purchase contact added successfully--",true);
				
		//Logistics Contact
		customerLogisticsContact clc= new customerLogisticsContact(driver);
		clc.clickOnLogisticsContact();
		Reporter.log("--Logistics contact page opens--",true);
		clc.selectLogisticsTitledd(LOGTITLE);
		clc.logisticsFirstName(LOGFNAME);
		clc.logisticsLastName(LOGLNAME);
		clc.logisticsEmail(LOGEMAIL);
		clc.logisticsPhone(LOGPHONE);
		clc.logisticsAddbtn();
		Reporter.log("--Logistics contact added successfully--",true);
		
		System.out.println(pUtil.readtwoDataFromPFile("end","and"));
		
}
}

