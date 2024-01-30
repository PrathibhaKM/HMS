package Patient;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.genericUtils.ExcelUtils;
import com.genericUtils.FileUtils;
import com.genericUtils.JavaUtils;
import com.genericUtils.WebDriverUtils;

public class WriteTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
	
	FileUtils fu = new FileUtils();
	ExcelUtils eu = new ExcelUtils();
	JavaUtils ju = new JavaUtils();
	WebDriverUtils wu = new WebDriverUtils();

	FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TextFieldAttValueAndPassValue.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
       for(int i=0;i<7;i++)
       {
    	   for(int j=0;j<3;j++)
    	   {
    		   wb.getSheet("Sheet3").getRow(i).getCell(j).setCellValue("Testyantra");
    		   wb.getSheet("Sheet3").getRow(i).getCell(j+1).setCellValue("Bangalore");
    		   
    	   }
       }
       FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TextFieldAttValueAndPassValue.xlsx");
       wb.write(fos);
	
}
}