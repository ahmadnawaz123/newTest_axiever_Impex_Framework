package loginTestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testAxiever.ObjectRepository.LoginPage;
import textAxiever.GenericUtility.PropertyFileUtility;
import textAxiever.GenericUtility.WebDriverUtility;

public class LoginTestCases1 {

	public  WebDriver driver;
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	
	
	@BeforeMethod
	public void setup() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String URL = pUtil.readDataFromPFile("url");
		String USERNAME = pUtil.readDataFromPFile("validUsername");
		System.out.println(USERNAME);
		String PASSWORD = pUtil.readDataFromPFile("validPassword");
		System.out.println(PASSWORD);
		String INVALIDPASS = pUtil.readDataFromPFile("invalidPassword");
		System.out.println(INVALIDPASS);
		driver.get(URL);
		wUtil.waitForDOMLoad(driver);
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredentials() throws IOException {
		
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername(pUtil.readDataFromPFile("username");
		lp.enterPassword(pUtil.readDataFromPFile("password"));
		lp.clickOnLoginButton();
//		driver.findElement(By.name("email")).sendKeys("ahmad@axiever.com");
//		driver.findElement(By.name("password")).sendKeys("Ahmad@12Nawaz");
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h4[@class='page-title']")).isDisplayed(),"Login failed");
	}
	
	@Test(priority=2)
	public void verifyLoginWithInValidCredentials() throws IOException{
		
		LoginPage lp= new LoginPage(driver);
		lp.enterUsername(pUtil.readDataFromPFile("username"));
		lp.enterPassword(pUtil.readDataFromPFile("invalidPassword"));
		lp.clickOnLoginButton();
		String actualWarningMessage = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
		String expectedWarningMessage = "Password you entered is not correct. Please try again !";
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage,"expected warning message is not displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
