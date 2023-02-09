package testAxiever.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import textAxiever.GenericUtility.WebDriverUtility;

public class customerLogisticsContact extends WebDriverUtility {

	//Declaration
	@FindBy(xpath = "//span[normalize-space()='Logistics Contacts']")
	private WebElement logisticsTab;
	
	@FindBy(xpath = "//button[@data-id='logistic_title']")
	private WebElement logisticsTitledd;
	
	@FindBy(xpath = "//button[@data-id='logistic_title']/../div/ul/li")
	private List<WebElement> logisticsAllTitle;
	
	@FindBy(name = "logistic_fname")
	private WebElement logisticsFirstName;
	
	@FindBy(name = "logistic_lname")
	private WebElement logisticsLastName;
	
	@FindBy(name = "logistic_wemail")
	private WebElement logisticsEmailId;

	@FindBy(name = "logistic_wphone")
	private WebElement logisticsPhone;

	@FindBy(id = "add_logistic_btn")
	private WebElement logisticsAddBtn;
	
	@FindBy(xpath = "(//button[@class='btn-trash'])[2])")
	private WebElement logisticsDeleteBtn;
	
	@FindBy(xpath = "(//a[@class='btn-edit'])[2]")
	private WebElement logisticsEditBtn;
	
	@FindBy(xpath = "(//a[@class='btn-contactlink'])[2]")
	private WebElement logisticsSocialMediaLinkBtn;
	
	//initialization
	public customerLogisticsContact(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	
	//Utilization - getters & Business Library

	public WebElement getLogisticsTab() {
		return logisticsTab;
	}

	public WebElement getLogisticsTitledd() {
		return logisticsTitledd;
	}

	public List<WebElement> getLogisticsAllTitle() {
		return logisticsAllTitle;
	}

	public WebElement getLogisticsFirstName() {
		return logisticsFirstName;
	}

	public WebElement getLogisticsLastName() {
		return logisticsLastName;
	}

	public WebElement getLogisticsEmail() {
		return logisticsEmailId;
	}

	public WebElement getLogisticsPhone() {
		return logisticsPhone;
	}

	public WebElement getLogisticsAddBtn() {
		return logisticsAddBtn;
	}

	public WebElement getLogisticsDeleteBtn() {
		return logisticsDeleteBtn;
	}

	public WebElement getLogisticsEditBtn() {
		return logisticsEditBtn;
	}

	public WebElement getLogisticsSocialMediaLinkBtn() {
		return logisticsSocialMediaLinkBtn;
	}
	
	//Business Library
	public void clickOnLogisticsContact() {
		logisticsTab.click();
	}
	
	public void selectLogisticsTitledd(String title) {
		logisticsTitledd.click();
		selectOption(logisticsAllTitle, title);
	}
	
	public void logisticsFirstName(String firstname) {
		logisticsFirstName.sendKeys(firstname);
	}
	
	public void logisticsLastName(String lastname) {
		logisticsLastName.sendKeys(lastname);
	}
	
	public void logisticsEmail(String email) {
		logisticsEmailId.sendKeys(email);
	}
	
	public void logisticsPhone(String phone) {
		logisticsPhone.sendKeys(phone);
	}
	
	public void logisticsAddbtn() {
		logisticsAddBtn.click();
	}
	
}
