package utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import configs.Path;


public class ExcelUtilities {
	
	
	public static String[][] testData(String fileName) {

		String[][] data=null;
        try {           

            @SuppressWarnings("resource")
          
			XSSFWorkbook workbook = new XSSFWorkbook(fileName);
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getLastCellNum();

             data= new String[rowCount-1][colCount];

            for (int i = 1; i < rowCount; i++) {               
                for (int j = 0; j < colCount; j++) {
                DataFormatter format=new DataFormatter(); 
                data[i-1][j]=format.formatCellValue(sheet.getRow(i).getCell(j));     
                //System.out.println(data[i][j]);
                    
                }
            }
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return data;
    }
	}

