package textAxiever.GenericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import textAxiever.GenericUtility.IConstantUtility.IConstantsUtility;



	public class ExcelFileUtility {
		/**
		 * This method will read the data from excel sheet with sheet name
		 * @param sheet
		 * @param row
		 * @param cel
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public String readDataFromExcel(String sheet, int row, int cel) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(IConstantsUtility.Excelfilepath);
			Workbook wb = WorkbookFactory.create(fis);
			 Sheet s = wb.getSheet(sheet);
			 Row r = s.getRow(row);
			 Cell c = r.getCell(cel);
			 String value = c.getStringCellValue();
			 wb.close();
			 return value;
		}
		/**
		 * This method will return the total number of rows in the sheet
		 * @param sheet
		 * @return
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */

		public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(IConstantsUtility.Excelfilepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			int data = s.getLastRowNum();
			wb.close();
			return data;
		}
		/**
		 * This method will write data into excel sheet
		 * @param sheet
		 * @param row
		 * @param cel
		 * @param value
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		
		public void writeDataIntoExcel(String sheet, int row,  int cel, String value ) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis = new FileInputStream(IConstantsUtility.Excelfilepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.createCell(cel);
			c.setCellValue(value);
			
			FileOutputStream fos = new FileOutputStream(IConstantsUtility.Excelfilepath);
			wb.write(fos);
			wb.close();
		}
			
			/**
			 * This method is used to execute a test script with multiple set of data.
			 * Hence it will return 2 dimensional object[][] so that it can be direct used in 
			   data-provider
			 * @param sheetName
			 * @return
			 * @throws EncryptedDocumentException
			 * @throws IOException
			 */
			public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
			{
				FileInputStream fis = new FileInputStream(IConstantsUtility.Excelfilepath);
				Workbook wb = WorkbookFactory.create(fis);
				Sheet sh = wb.getSheet(sheetName);
				int lastRow = sh.getLastRowNum();
				int lastCell = sh.getRow(0).getLastCellNum();
				
				Object[][] data = new Object[lastRow][lastCell];
				
				for(int i=0;i<lastRow;i++)
				{ 
					for(int j=0;j<lastCell;j++)
					{
						data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
					}
				}
					return data;
			}
				
				public static Object[][] readAllTypeDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException{
					FileInputStream fis = new FileInputStream(IConstantsUtility.Excelfilepath);
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheet(sheetName);
					int lastRow = sh.getLastRowNum();
					int lastCell = sh.getRow(0).getLastCellNum();
					
					Object[][] data = new Object[lastRow][lastCell];
					
					for(int i=0;i<lastRow;i++)
					{ 
						Row row = sh.getRow(i+1);
					
						for(int j=0;j<lastCell;j++)
						{
							Cell cell = row.getCell(j);
							CellType cellType = cell.getCellType();
									
									switch(cellType)  {
									
									case STRING:
										data[i][j] = cell.getStringCellValue();
										break;
									case NUMERIC:
										data[i][j] = Integer.toString((int)cell.getNumericCellValue());
										break;
									case BOOLEAN:
										data[i][j] =cell.getBooleanCellValue();
										break;
									}
									}
									
					}
					return data;
					}

	}

