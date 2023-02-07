package testAxiever.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import textAxiever.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	//Declaration
	@FindBy(xpath = "//span[@class=' usertextnone']")
	private WebElement logoutDropdown;

	@FindBy(xpath = "//span[.='Logout']")
	private WebElement logoutbutton;

	@FindBy(xpath ="(//span[text()='Customer'])[1]")
	private WebElement customer;
	
	@FindBy(xpath = "//span[.='Customer Master']")
	private WebElement customerMaster;
	
	@FindBy(xpath = "//span[.='New Customer ']")
	private WebElement newCustomer;
	
	
	//Initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}

	//Utilization - getters & Business Library
	public WebElement getLogoutDropdown() {
		return logoutDropdown;
	}

	public WebElement getLogoututton() {
		return logoutbutton;
	}
	
	public WebElement getCustomerModule() {
		return customer;
	}

	public WebElement getCustomerMasterModule() {
		return customerMaster;
	}

	public WebElement getNewCustomerModule() {
		return newCustomer;
	}
	
	//Business Libray
	
	

	public void logout() {
		logoutDropdown.click();
		logoutbutton.click();
	}
	
	public void clickOnCustomerMaster(WebDriver driver) {
		mouseHover(driver, customer);
	}
	
	public void clickOnNewCustomer(WebDriver driver) {
		mouseHover(driver, customerMaster);
		newCustomer.click();
		
		
	}
}
