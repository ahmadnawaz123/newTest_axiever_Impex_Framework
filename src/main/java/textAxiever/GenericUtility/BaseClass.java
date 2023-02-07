package textAxiever.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import testAxiever.ObjectRepository.HomePage;
import testAxiever.ObjectRepository.LoginPage;

/**
 * This class contains basic configuration annotation for common 
 * functionalities like connection to database, launch the browser etc
 * @author Dell 
 *
 */
public class BaseClass {
	
	//public DatabaseUtility dUtil = new DatabaseUtility();
	public ExcelFileUtility eUtil = new ExcelFileUtility();
	public JavaUtility jUtil= new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public PropertyFileUtility pUtil = new PropertyFileUtility();
	public WebDriver driver ;
//	@BeforeSuite
//	public void bsConfig() throws SQLException
//	{
//		//dUtil.connectToDB();
//		Reporter.log("--Database Connection successful--",true);
//	}

	//@Parameters("BROWSER")
	//@BeforeTest
	
	@BeforeClass
	public void bcConfig(/*String BROWSER*/) throws IOException
	{
		String BROWSER = pUtil.readDataFromPFile("browser");
		String URL = pUtil.readDataFromPFile("url");
		
		
		if(BROWSER.equalsIgnoreCase("CHROME"))
		{
			driver = new ChromeDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
			Reporter.log("--Browser "+BROWSER+" launched successfully--",true);
		}
		else
		{
			System.out.println("invalid browser");
		}
		
		wUtil.maximizeWindow(driver);
		wUtil.waitForDOMLoad(driver);
		driver.get(URL);
	}
	
	@BeforeMethod
	public void bmConfig() throws IOException
	{
		String USERNAME = pUtil.readDataFromPFile("username");
		String PASSWORD = pUtil.readDataFromPFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.enterUsername(USERNAME);
		lp.enterPassword(PASSWORD); 
		lp.clickOnLoginButton();
		Reporter.log("--Login Successful--", true);
		Reporter.log("--Home-Page opens Successful--", true);
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp = new HomePage(driver);
		hp.logout();
		Reporter.log("--Signout successfull--", true);
	}
	
	//@AfterTest
	@AfterClass
	public void acConfig()
	{
		driver.close();
		Reporter.log("--browser closed successfull--", true);
	}
	
//	@AfterSuite
//	public void asConfig() throws SQLException
//	{
//		//dUtil.closeDB();
//		Reporter.log("--Database closed successfully--", true);
//	}
}
