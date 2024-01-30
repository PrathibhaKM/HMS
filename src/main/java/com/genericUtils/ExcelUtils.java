package com.genericUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	/**
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath) ;
		
		Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetName);
	String value = sh.getRow(rowNo).getCell(cellNo).getStringCellValue();
	return value;
		
	}
	public Object[][] readMultipleData(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IpathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		int lastrownum = sh.getLastRowNum();
		short lastcellnum = sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastrownum+1][lastcellnum];
		for(int i=0;i<=lastrownum;i++)
		{
			for(int j=0;j<lastcellnum;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
		}

	
	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public int getLastRowNum(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath) ;	
	Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetName);
	int rowCount = sh.getLastRowNum();
	 return rowCount;
}


/**
 * 
 * @param sheetName
 * @param cell
 * @return
 * @throws IOException 
 * @throws EncryptedDocumentException 
 */
public HashMap<String, String> hashMapData(String sheetName,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath) ;	
	Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetName);
	 int lastRow = sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();  //empty
	for(int i=0;i<=lastRow;i++)
	{
	String key=	sh.getRow(i).getCell(cell).getStringCellValue();
		String value=sh.getRow(i).getCell(cell+1).getStringCellValue();
		map.put(key, value);
	}
return map;
}
/**
 * 
 * @param sheetName
 * @param row
 * @param cell
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String sheetName,int row,int cell,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IpathConstants.ExcelPath) ;	
	Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet(sheetName);
	 sh.createRow(row).createCell(cell).setCellValue(data);
	 FileOutputStream fout=new FileOutputStream(IpathConstants.ExcelPath);
	 wb.write(fout);
	 wb.close();
}
}
