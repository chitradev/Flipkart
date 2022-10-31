package TestCases;
import java.io.IOException;
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

public class FPHomePage extends BaseSteps{
	
	private static final String txtUserName = "txtUserName";
	private static final String txtPwd="txtPwd";
	private static final String btnlogin="btnlogin";
	private static final String txtSearch="txtSearch";	
	private static final String btnSearch="btnSearch";
	private static final String addItem="addItem";
	
	
	@BeforeMethod	
	public static void Log() throws IOException, InterruptedException
	{
		driver();
		BaseSteps.launchUrl("URL","GlobalVariable");
		BaseSteps.setTextToControl(txtUserName,ElementFactory.locator("UserName", "GlobalVariable"),PageName.Login);		
		BaseSteps.setTextToControl(txtPwd,ElementFactory.locator("Password", "GlobalVariable"), PageName.Login);
		BaseSteps.clickToControl(btnlogin, PageName.Login);	
		Thread.sleep(3000);		
	}

	@AfterMethod		
	public static void Logout() throws IOException, InterruptedException
	{
		BaseSteps.waitForControlDisplay(40, btnSearch, PageName.Home);
		driver.quit();
		
	}	
	
	@Test(dataProvider="FP01", dataProviderClass=DataProviderClass.class, priority=1)
	public static void FP01(String key, String print) throws IOException, InterruptedException {							
		BaseSteps.setTextToControl(txtSearch, key, PageName.Home);			
		BaseSteps.clickToControl(btnSearch, PageName.Home);	
		Thread.sleep(3000);				
		BaseSteps.clickToControl(addItem, PageName.Home);
		Assert.assertTrue(key.equals("0"), "Test case failed");
		System.out.println(print);
		}
	
	
	@Test(dataProvider="FP02", dataProviderClass=DataProviderClass.class, priority=2)
	public static void FP02(String text) throws IOException, InterruptedException {	
		BaseSteps.clickToControl(btnSearch, PageName.Home);	
		System.out.println(text);	
		}
	
	
	@Test(dataProvider="FP03", dataProviderClass=DataProviderClass.class, priority=3)
	public static void FP03(String print, String age, String name) throws IOException, InterruptedException {							
		System.out.println(print);	
		System.out.println(age);
		System.out.println(name);
		}

	
	
}
