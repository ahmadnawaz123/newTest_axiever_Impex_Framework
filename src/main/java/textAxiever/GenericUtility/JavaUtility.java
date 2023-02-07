package textAxiever.GenericUtility;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class JavaUtility {

	
	/**
	 * This method will generate a random number
	 * @return
	 */
	public int getRandomNumber() {
		
			Random r = new Random();
			int ran =r.nextInt(1000);
			return ran;
		}
	
	/**
	 * This method will return the current system date
	 * @return
	 */
	public String getSystemDate()
	{
	Date d = new Date();
	String date = d.toString();
	return date;
	}
	
	/**
	 * This method will provide the date and time in a specific format
	 * @return
	 */
	public String getSystemDateInFormat()
	{
		Date d= new Date();
		String[] dArr = d.toString().split(" ");
		String date =dArr[2];
		String month =dArr[1];
		String year =dArr[5];
		String time =dArr[3].replace(":", "-");
		String currentDateAndTime = date+" "+month+" "+year+" "+time;
		return currentDateAndTime;
	}
	
	/**
	 * This method will match the name to be selected from drop-down options and click on it
	 * @param alldropDownOptions
	 * @param optionToBeSelected
	 */
	public void selectOption2(List<WebElement> alldropDownOptions, String optionToBeSelected) {
        System.out.println("Total options in list --> " + alldropDownOptions.size());

		for (int i=0;i<=alldropDownOptions.size();i++) {
			
			if (alldropDownOptions.get(i).getText().equals(optionToBeSelected))
			System.out.println("passed selected");
			{
				alldropDownOptions.get(i).click();
				
				break;
			}
		}
		}
	
}
