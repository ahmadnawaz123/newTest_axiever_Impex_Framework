package textAxiever.GenericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

	/**
	 * This class will contact all the generic methods related web driver actions
	 * @param driver
	 */

	public class WebDriverUtility{
		
		/**
		 * This method will maximize the window
		 * @param driver
		 */

		public void maximizeWindow(WebDriver driver)
		{
			driver.manage().window().maximize();
		}
		
		/**
		 * This method will wait for 20 seconds for the entire DOM to load
		 * @param driver
		 */
		
		public void waitForDOMLoad(WebDriver driver)
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		/**
		 * This method will wait for an element to be visible
		 * @param driver
		 */
		public void waitForElementToBeVisible(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(element));	
		}
		
		/**
		 * This method will wait for an element to be clickable
		 * @param driver
		 * @param element
		 */
		public void waitForElementToBeClickable(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * This method is a custom where it will wait for the particular element
		 * @param element
		 * @throws InterruptedException 
		 */
		public void waitAndClickOnElement(WebElement element) throws InterruptedException
		{
			int count = 0;
			while(count < 10)
			{
				try
				{
			element.click();
			break;
				}
				catch (Exception e) {
				// TODO: handle exception
					Thread.sleep(1000);
					count++;
				}
			}
		}
		
		/**This method will handle drop down using select class based on index
		 * this 
		 * @param element
		 */
		public void handleDropdown(WebElement element, int index)
		{
			Select s = new Select(element);
			s.selectByIndex(index);
		}
		
		/**
		 * This method will handle drop down using select class based on Visible text
		 * @param element
		 * @param visibleText
		 */
		public void handleDropdown(WebElement element, String visibleText)
		{
		Select s = new Select(element);
		s.selectByVisibleText(visibleText);	
		}
		
		/**
		 * This method will handle drop down using select class based on value
		 * @param value
		 * @param element
		 */
		public void handleDropdown(String value, WebElement element)
		{
		Select s = new Select(element);
		s.selectByValue(value);	
		}
		
		/**
		 * This method will perform mouse hover action on a particular element
		 * @param driver
		 * @param element
		 */
		public void mouseHover(WebDriver driver, WebElement element)
		{
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * This method will double click on the page
		 * @param driver
		 * @param element
		 */
		public void doubleClickOn(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.doubleClick().perform();
		}
		
		/**
		 * This method will perform double click on a particular element
		 * @param driver
		 * @param element
		 */
		public void doubleClickOn(WebDriver driver, WebElement element)
		{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		}
		
		/**
		 * This method will perform right click on the page
		 * @param driver
		 */
		public void rightClickOn(WebDriver driver)
		{
			Actions act = new Actions(driver);
			act.contextClick().perform();
		}
		
		/**
		 * This method will perform right click on a particular element
		 * @param driver
		 * @param element
		 */
		public void rightClickOn(WebDriver driver, WebElement srcElement,  WebElement element)
		{
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * This method will perform drag and drop from source element location
		 * to the target element location
		 * @param driver
		 * @param element
		 * @param srcElement
		 * @param targetElement
		 */
		public void dragAndDrop(WebDriver driver, WebElement element, WebElement srcElement,  WebElement targetElement)
		{
			Actions act = new Actions(driver);
			act.dragAndDrop(srcElement, targetElement).perform();		
		}
		
		/**
		 * This method will press the Enter key and release
		 * @throws AWTException 
		 */
		public void pressEnter() throws AWTException
		{
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyPress(KeyEvent.VK_ENTER);
		}
		
		/**
		 * This method will accept the alert pop up
		 * @param driver
		 */
		public void acceptAlert(WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		/**
		 * This method will cancel the alert pop up
		 * @param driver
		 */
		public void dismissAlert(WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * This method will get the text of pop up
		 * @param driver
		 * @return
		 */
		public String getextOfAlert(WebDriver driver)
		{
			String text = driver.switchTo().alert().getText();
			return text;
		}
		
		/**
		 * This method will handle frame based on index
		 * @param driver
		 * @param index
		 */
		public void handleFrame(WebDriver driver, int index)
		{
			driver.switchTo().frame(index);
		}
		
		/**
		 * This method will handle frame based on name or id
		 * @param driver
		 */
		public void handleFrame(WebDriver driver, String nameOrId)
		{
			driver.switchTo().frame(nameOrId);
		}
		
		/**
		 * This method will handle frame based on frame element
		 * @param driver
		 * @param element
		 */
		public void handleFrame(WebDriver driver, WebElement element)
		{
			driver.switchTo().frame(element);
		}
		
		/**
		 * This method will switch the control back to immediate parent
		 * @param driver
		 */
		public void toParentFrame(WebDriver driver)
		{
			driver.switchTo().parentFrame();
		}
		
		/**
		 * This method will come out of all the frames
		 * @param driver
		 */
		public void toDefaultWindow(WebDriver driver)
		{
			driver.switchTo().defaultContent();
		}
		
		/**
		 * This method will switch from  window to any child window or from
		 * any child window to parent window
		 *  based on the partial window title
		 * @param driver
		 */
		public void switchToWindow(WebDriver driver, String partialWinTitle)
		{
			//Step 1: Get all the window id's
			Set<String> windowIds = driver.getWindowHandles();
		
			//Step 2: Iterate through all the window id's
			Iterator<String> it = windowIds.iterator();
			
			//Step 3: Navigate to each window and check the title
			while(it.hasNext())
			{
				//step 4: Capturing the individual window id
				String winId = it.next();
				
				//Step 5: Switch to that window and capture the title
				String currentTitle = driver.switchTo().window(winId).getTitle();
				
				//Step 6: Compare current title with partial title
				if(currentTitle.contains(partialWinTitle))	
				{
					break;
				}
			}
		}
		
		/**
		 * This method will take screenshot and	save it in Screenshots folder
		 * @param driver
		 * @param screenShotName
		 * @return
		 * @throws IOException
		 */
			public String takeScreenshot(WebDriver driver, String screenShotName) throws IOException
				{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				String path = ".\\Screenshots\\"+screenShotName+".png";
				File dst = new File(path);
				FileUtils.copyFile(src, dst);
					
				return dst.getAbsolutePath(); //used for reporting
				}
			
			/**
			 * This method will scroll down for 500 units
			 * @param driver
			 */
			public void scrollAction(WebDriver driver) 
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,500)", "");
			}
			
			public void scrollAction(WebDriver driver, WebElement element)
			{
				JavascriptExecutor js = (JavascriptExecutor)driver;
				//js.executeScript("arguments[0].scrollIntoView()", element);
			int	y = element.getLocation().getY();
			js.executeScript("window.scrollBy(0,"+y+")", element);
			}

			// Handling web-push notification
			// creating ChromeOptions object
		
			/**
			 * This method will match the name to be selected from drop-down options and click on it
			 * @param alldropDownOptions
			 * @param optionToBeSelected
			 */
			public void selectOption(List<WebElement> alldropDownOptions, String optionToBeSelected) {
				boolean isFound = false;
				for (WebElement option : alldropDownOptions) {
						if (option.getText().equals(optionToBeSelected)) {
						System.out.println(option.getText()+ " is selected from dropdown successfully--");
						option.click();
						isFound = true;
						break;
					}
		 
				}
				if (!isFound)
					System.out.println("No matching option found.");
			}
			
			ChromeOptions op = new ChromeOptions();
			
	}
	

