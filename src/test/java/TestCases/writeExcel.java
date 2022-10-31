package TestCases;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ResourceBundle.Control;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.beust.jcommander.converters.BaseConverter;
import com.google.common.collect.Table.Cell;

public class writeExcel {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();		

	driver.get("https://teamhealthphaseii.heisenberg2.net/Login.aspx");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("orgadmin");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Victory@123");
	driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
	Thread.sleep(3000);
	driver.get("https://teamhealthphaseii.heisenberg2.net/DataManagement/WrvusAdjustmentImport.aspx");
	WebElement ddl=driver.findElement(By.xpath("//select[@id='BodyContentHolder_ddlImportFunctions']"));
	Select ss=new Select(ddl);
	ss.selectByIndex(0);
	Thread.sleep(4000);
	driver.findElement(By.xpath("//a[@id='BodyContentHolder_lnkDownLoadTemplate']")).click();
	Thread.sleep(7000);		
	//String filepath = "E:\\git\\QA Automation- Adjustment Import\\ExportedFiles\\wRVUs_tRVUs Adjustments Import.xlsx";
	String filepath = "C:\\Users\\CIPL1017\\Downloads\\wRVUs_tRVUs Adjustments Import.xlsx";

	int colNum=0;
	int rownum=1;		
	File file = new File(filepath);
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook workBook = new XSSFWorkbook(fis);
	XSSFSheet workSheet = workBook.getSheetAt(0);
	int rowHeader=workSheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println(rowHeader);
	Row row  = workSheet.createRow(rownum);	
	//System.out.println(row);
	for(int i=0;i<rowHeader;i++) {
		row.createCell(i);
	}
	row.getCell(colNum).setCellValue("33225566");
	row.getCell(colNum+1).setCellValue("Adjustment, Import");
	row.getCell(colNum+2).setCellValue("343243243432432");
	row.getCell(colNum+3).setCellValue("10/11/2022");
	row.getCell(colNum+4).setCellValue("11");
	row.getCell(colNum+5).setCellValue("11");

	//row.createCell(colNum, Cell.CELL_TYPE_STRING).setCellValue(value4)
	System.out.println(row.getCell(0).getStringCellValue());
	System.out.println(row.getCell(1).getStringCellValue());
	System.out.println(row.getCell(2).getStringCellValue());
	System.out.println(row.getCell(3).getStringCellValue());
	System.out.println(row.getCell(4).getStringCellValue());
	System.out.println(row.getCell(5).getStringCellValue());
	System.out.println(row.getCell(10).getStringCellValue());
		
	FileOutputStream fileOut = new FileOutputStream(filepath);
	workBook.write(fileOut);
	workBook.close();
	fileOut.flush();
	fileOut.close();

	driver.findElement(By.xpath("//input[@id='BodyContentHolder_fileupdWrvusAdjustment']")).sendKeys(filepath);
	driver.findElement(By.xpath("//input[@id='BodyContentHolder_btnupload']")).click();
	Thread.sleep(5000);
	System.out.println(driver.findElement(By.xpath("//div[@class='error']")).getText());
	
	String header=driver.findElement(By.xpath("//div[@class='box-header']/h2")).getText();
	System.out.println(header);
	Assert.assertEquals(header, "ADJUSTMENT IMPORT","Header matched");
	driver.quit();
	

	}

	}


