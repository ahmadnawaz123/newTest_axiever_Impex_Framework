package testAxiever.ObjectRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import textAxiever.GenericUtility.WebDriverUtility;

public class newCustomer extends WebDriverUtility {
	//Declaration
	@FindBy(name = "customer_name")
	private WebElement customerNameTextField;
	
	@FindBy(id = "address_line1")
	private WebElement addressTextField;
	
	@FindBy(xpath = "(//span[.='Select Country'])[1]")
	private WebElement countryDropdown;
	
	@FindBy(xpath = "(//div[@class='dropdown-menu open'])[2]/ul/li")
	private List<WebElement> allCountry;
	
	@FindBy(xpath = "(//span[.='Select State'])[1]")
	private WebElement stateDropdown;
	
	@FindBy(xpath = "//span[text()='Jharkhand']/ancestor::ul/li")
	private List<WebElement> allState;
	
	@FindBy(xpath = "(//span[.='Select City:'])[1]")
	private WebElement CityDropdown;
	
	@FindBy(xpath = "(//li[@class='selected active'])[3]/following-sibling::li")
	private List<WebElement> allCity;

	@FindBy(id = "phone_no")
	private WebElement phoneNoTextField;
	
	@FindBy(xpath ="(//span[.='Select Region'])[1]")
	private WebElement regionDropdown;
	
	@FindBy(xpath ="(//span[.='Asia'])[1]/ancestor::ul/li")
	private List<WebElement> allRegion;

	@FindBy(xpath ="(//span[text()='Select Time Zone'])[1]")
	private WebElement timeZoneDropddown;
	
	@FindBy(xpath ="//span[text()='Asia/Kabul (+04:30)']")
	private WebElement selectTimeZone;
	
	@FindBy(id ="customer_since")
	private WebElement customerSinceCalender;
	
	@FindBy(id ="submit_action")
	private WebElement submitBtn;
	
	@FindBy(xpath ="//h3[text()='New Customer']")
	private WebElement newCustomerHeader;
	
	
	//Initialization
	public newCustomer(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Utilization - getters & Business Library
	public WebElement getCustomerNameTextField() {
		return customerNameTextField;
	}

	public WebElement getAddressTextField() {
		return addressTextField;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public List<WebElement> getallCountry() {
		return allCountry;
	}

	public WebElement getStateDropdown() {
		return stateDropdown;
	}

	public List<WebElement> getAllState() {
		return allState;
	}
	
	public WebElement getCityDropdown() {
		return CityDropdown;
	}

	public List<WebElement> getSelectCity() {
		return allCity;
	}

	public WebElement getPhoneNoTextField() {
		return phoneNoTextField;
	}

	public WebElement getRegionDropdown() {
		return regionDropdown;
	}

	public List<WebElement> getSelectRegion() {
		return allRegion;
	}

	public WebElement getTimeZoneDropddown() {
		return timeZoneDropddown;
	}

	public WebElement getSelectTimeZone() {
		return selectTimeZone;
	}

	public WebElement getCustomerSinceCalender() {
		return customerSinceCalender;
	}
	
	public WebElement getsubmitBtn() {
		return submitBtn;
	}
	public WebElement getnewCustomerHeader() {
		return newCustomerHeader;
	}
	
	//Business Library

	public void enterCustomerName(String cusname) {
		customerNameTextField.sendKeys(cusname);
	}

	public void enterAddress(String cusaddress) {
		addressTextField.sendKeys(cusaddress);
	}
	
	public void selectCountry(String selectCountry) {
		countryDropdown.click();
		selectOption(allCountry, selectCountry);
	}
	
	public void selectState(String selectState) {
		stateDropdown.click();
		selectOption(allState, selectState);
	}
	
	public void selectCity(String selectCity) {
		CityDropdown.click();
		selectOption(allCity, selectCity);
	}
//	public void waitForCountry(WebDriver driver) {
//		waitForElementToBeClickable(driver, countryDropdown);
//	}
//	
//	public void waitForState(WebDriver driver) {
//		waitForElementToBeClickable(driver, stateDropdown);
//	}
//	
//	public void waitForCity(WebDriver driver) {
//		waitForElementToBeClickable(driver, CityDropdown);
//	}
	
	public void enterPhoneNo(String number) {
		phoneNoTextField.sendKeys(number);
	}
	
	public void selectRegion(String selectRegion) {
		regionDropdown.click();
		selectOption(allRegion,selectRegion);
	}
	
	public void customerDate(String date) {
		customerSinceCalender.clear();
		customerSinceCalender.sendKeys(date);
	}
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	public String newCustomerHeader() {
		String customerHeader = newCustomerHeader.getText();
		return customerHeader;
	}
	
	public String newCustomerAdded() {
		String CustomerAdded= customerNameTextField.getAttribute("value");
		return CustomerAdded;
	}
	
}
