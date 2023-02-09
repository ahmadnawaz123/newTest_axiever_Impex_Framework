package textAxiever.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import textAxiever.GenericUtility.IConstantUtility.IConstantsUtility;


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
			FileInputStream fis = new FileInputStream(IConstantsUtility.propertyfilepathcommondata);
			Properties pObj = new Properties();
			pObj.load(fis);
			String value = pObj.getProperty(key);
			return value;
}
		/**
		 * This method will read the key from property file and return the value
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public String readDataFromCustomerPFile(String key) throws IOException
		{
		FileInputStream fis = new FileInputStream(IConstantsUtility.propertyfilepathcustomerdata);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
		}
		
		public String readtwoDataFromPFile(String key1,String key2) throws IOException
		{
		FileInputStream fis = new FileInputStream(IConstantsUtility.propertyfilepathcustomerdata);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key1,key2);
		
		return value;
}
}