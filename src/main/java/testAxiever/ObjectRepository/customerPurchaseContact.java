package testAxiever.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import textAxiever.GenericUtility.WebDriverUtility;

public class customerPurchaseContact extends WebDriverUtility{

	//Purchase Contacts
		@FindBy(xpath ="//span[text()='Purchase Contacts']")
		private WebElement purchaseContactTab;
		
		@FindBy(xpath = "//button[@data-id='purchase_title']")
		private WebElement purchaseTitledd;
		
		@FindBy (xpath ="//button[@data-id='purchase_title']/following-sibling::div/ul/li")
		private List<WebElement> purchaseAllTitle;
		
		@FindBy(name ="purchase_fname")
		private WebElement purchaseFirstName;
		
		@FindBy(name ="purchase_lname")
		private WebElement purchaseLastName;
		
		@FindBy(name ="purchase_wemail")
		private WebElement purchaseEmailId;
		
		@FindBy(name ="purchase_wphone")
		private WebElement purchasePhoneNo;
		
		
		@FindBy(id ="populate_contacts")
		private WebElement purchaseCheckBox;
		
		@FindBy(id ="add_purchase_btn")
		private WebElement purchaseAddBtn;
		
		//Initialization
		public customerPurchaseContact(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//Utilization - getters & Business Library
		
		public WebElement getPurchaseContactTab() {
			return purchaseContactTab;
		}

		public WebElement getPurchaseTitledd() {
			return purchaseTitledd;
		}

		public WebElement getPurchaseFirstName() {
			return purchaseFirstName;
		}

		public List<WebElement> getPurchaseAllTitle() {
			return purchaseAllTitle;
		}

		public WebElement getPurchaseLastName() {
			return purchaseLastName;
		}

		public WebElement getPurchaseEmailId() {
			return purchaseEmailId;
		}

		public WebElement getPurchasePhoneNo() {
			return purchasePhoneNo;
		}

		public WebElement getPurchaseCheckBox() {
			return purchaseCheckBox;
		}

		public WebElement getPurchaseAddBtn() {
			return purchaseAddBtn;
		}
		//Business Library
		public void clickOnPurchaseContact() {
			purchaseContactTab.click();
		}
		
		public void selectPurchaseTitledd(String title) {
			purchaseTitledd.click();
			selectOption(purchaseAllTitle, title);
		}
		public void purchaseFirstName(String firstname) {
			purchaseFirstName.sendKeys(firstname);
		}
		
		public void purchaseLastName(String lastname) {
			purchaseLastName.sendKeys(lastname);
		}
		
		public void purchaseEmail(String email) {
			purchaseEmailId.sendKeys(email);
		}
		
		public void purchasePhone(String phone) {
			purchasePhoneNo.sendKeys(phone);
		}
		
		public void purchaseAddbtn() {
			purchaseAddBtn.click();
		}
		
}
