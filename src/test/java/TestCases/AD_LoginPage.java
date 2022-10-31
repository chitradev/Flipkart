package TestCases;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageLocators.PageName;
import Resources.DataProviderClass;
import core.BaseSteps;
import core.Browser;
import core.ElementFactory;
import utils.ExcelUtilities;

public class AD_LoginPage extends BaseSteps {
	
	private static final String txtUserName = "txtUserName";
	private static final String txtPwd="txtPwd";
	private static final String btnlogin="btnlogin";
	private static final String mnuProvider="mnuProvider";
	private static final String mnuProviderSetup="mnuProviderSetup";

	@BeforeMethod	
	public static void Log() throws IOException, InterruptedException
	{
		driver();
		/*BaseSteps.launchUrl("URL","GlobalVariable");
		BaseSteps.setTextToControl(txtUserName,ElementFactory.locator("UserName", "GlobalVariable"),PageName.Login);		
		BaseSteps.setTextToControl(txtPwd,ElementFactory.locator("Password", "GlobalVariable"), PageName.Login);
		BaseSteps.clickToControl(btnlogin, PageName.Login);	
		Thread.sleep(5000);	
		BaseSteps.mouseHover(mnuProvider, PageName.Login);
		BaseSteps.mouseHover(mnuProviderSetup, PageName.Login);
		Thread.sleep(5000);	*/
		driver.get("https://einstein2.us/VMSQAAutomation/Account/login.aspx?");
		driver.findElement(By.xpath("//input[@id='MainContent_Email']")).sendKeys("agency@yopmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Hallmark@123");
		driver.findElement(By.xpath("//input[@id='MainContent_btnlogin']")).click();
		Thread.sleep(3000);
	}

	@AfterMethod		
	public static void Logout() throws IOException, InterruptedException
	{
		driver.quit();
		
	}	
	
	@Test(priority=1)
	public static void AD01() throws InterruptedException, IOException {
		
		MenuNavigation.verifyNavigationToDashBoard();
		
	}
	
	
	@Test(priority=2)
	public static void AD02() throws IOException, InterruptedException {		
		
		MenuNavigation.verifyNavigationToListReport();
		
		}	
	
	@Test	
	public static void getceltex() throws InterruptedException, IOException {
		
		int count=BaseSteps.getRowTableCount("tableProvider", PageName.Header);
		System.out.println(count);
		for(int i=1;i<count;i++) {
		String tex=BaseSteps.getCellTableText("tableProvider", Integer.toString(i+1),"Region", PageName.Header);
		String tex2=BaseSteps.getCellTableText("tableProvider", Integer.toString(i+1),"Payroll ID", PageName.Header);
		System.out.println(tex);
		System.out.println(tex2);
		}
		
		BaseSteps.selectFirstOptionFromDropdown("ddlPageSize", PageName.Header);
		Thread.sleep(5000);
		BaseSteps.selectByVisibleTextFromDropdown("ddlPageSize","50" ,PageName.Header);
		Thread.sleep(5000);
		BaseSteps.selectByIndexFromDropdown("ddlPageSize", 4, PageName.Header);
		Thread.sleep(5000);
	}
	
	@Test	
	public static void td() throws IOException, InterruptedException {
						
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath("//a[text()='Candidate']"));
		act.moveToElement(ele).build().perform();
		driver.findElement(By.xpath("//a[text()='TimeSheet']")).click();
		Thread.sleep(3000);
		BaseSteps.clickCellTableText("tableEin", "1", "Time In", PageName.Header);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='txtTimeIn0']")).sendKeys("10:20");
	}

} 	
