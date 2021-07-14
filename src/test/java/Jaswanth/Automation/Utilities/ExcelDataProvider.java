package Jaswanth.Automation.Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;
	public static XSSFRow row;
	public static FileOutputStream ExcelOutFile;
	public static FileInputStream ExcelFile;
	public static String fileLocation;
	public static int totalRows;
	
	/*Read Data From Excel
	@param Filepath
	@param SheetName
	@return
	@throws Exception*/
	
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception 
	{   
	String[][] tabArray = null;

		   try {

			   FileInputStream ExcelFile = new FileInputStream(FilePath);

			   // Access the required test data sheet

			   ExcelWBook = new XSSFWorkbook(ExcelFile);

			   ExcelWSheet = ExcelWBook.getSheet(SheetName);

			   int startRow = 1;

			   int startCol = 0;

			   int ci,cj;

			   totalRows = ExcelWSheet.getLastRowNum();

			   // you can write a function as well to get Column count

			   int totalCols = ExcelWSheet.getRow(startRow).getLastCellNum();

			   tabArray=new String[totalRows][totalCols];

			   ci=0;

			   for (int i=startRow;i<=totalRows;i++, ci++) 
			   {           	   

				  cj=0;

				   for (int j=startCol;j<totalCols;j++, cj++)
				   {

					   tabArray[ci][cj]=getCellData(i,j);

					   System.out.println(tabArray[ci][cj]);  

						}

					}

				}

			catch (FileNotFoundException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			catch (IOException e){

				System.out.println("Could not read the Excel sheet");

				e.printStackTrace();

				}

			return(tabArray);

			}

		public static String getCellData(int RowNum, int ColNum) throws Exception 
		{

			try{

				Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

				CellType dataType = Cell.getCellTypeEnum();

				if  (dataType == CellType.NUMERIC) 
				{

					return "";

				}
				else
				{

					String CellData = Cell.getStringCellValue();

					return CellData;

				}
			}catch (Exception e){

				//System.out.println(e.getClass().getName()+"-"+e.getMessage());

				//throw (e);

				}
			return null;

			}
		
		
		
		/*Write Data From Excel
		@param Filepath
		@param SheetName
		@return
		@throws Exception*/
		
		public static void setTableArray(String Filepath,String[] value) throws IOException
		{
			String sheetName = "output";
			try
			{
				//Access the required test data sheet
				XSSFSheet ExcelWSheetw = ExcelWBook.getSheet(sheetName);
				int col_Num = 1;
				int totalCols = 1;
				int cj = 0;
				
				ExcelWSheetw.createRow(Login.Iterate).createCell(0).setCellValue("TC_"+Login.Iterate);
				for(int j = col_Num; j <= totalCols; j++,cj++)
				{
					ExcelWSheetw.getRow(Login.Iterate).createCell(j).setCellValue(value[cj]);
				}
				ExcelOutFile = new FileOutputStream(Filepath);
				ExcelWBook.write(ExcelOutFile);
				ExcelOutFile.close();
				
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			
			
			
		}
		

	}

 
