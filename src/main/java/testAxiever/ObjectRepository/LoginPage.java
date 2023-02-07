package testAxiever.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import textAxiever.GenericUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	
	//Declaration
	@FindBy(name = "email")
	private WebElement UserEmail;
	
	@FindBy(name = "password")
	private WebElement UserPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement SubmitButton;
	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization - getters & Business Library
	public WebElement getUserEmail() {
		return UserEmail;
	}

	public WebElement getUserPassword() {
		return UserPassword;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	//Business Libray
	/**
	 * this method will login to application
	 * @param username
	 * @param password
	 */
	public void enterUsername(String username) {
		UserEmail.sendKeys(username);
	}
	public void enterPassword(String password) {
		UserPassword.sendKeys(password);

	}
	public void clickOnLoginButton() {
		SubmitButton.click();

	}
}
