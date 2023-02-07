package textAxiever.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


	/**
	 * This class contains all the generic methods related to property file
	 * @author DELL
	 *
	 */

	public class PropertyFileUtility {
		
		/**
		 * This method will read the key from property file and return the value
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public String readDataFromPFile(String key) throws IOException
			{
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
}
		public String readtwoDataFromPFile(String key,String key2) throws IOException
		{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key,key2);
		
		return value;
}
}