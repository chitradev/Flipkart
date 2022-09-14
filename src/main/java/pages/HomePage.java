package pages;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import PageLocators.PageName;
import core.BaseSteps;
import core.Browser;
import core.ElementFactory;
import utils.ExcelUtilities;

public class HomePage extends BaseSteps{
	
	private static final String txtUserName = "txtUserName";
	private static final String txtPwd="txtPwd";
	private static final String btnlogin="btnlogin";
	private static final String txtSearch="txtSearch";	
	private static final String btnSearch="btnSearch";
	private static final String addItem="addItem";
	private static final String mnuprofile="mnuprofile";
	private static final String mnuprofileLogout="mnuprofileLogout";	
	
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
	
	@Test(dataProvider="testData", dataProviderClass=ExcelUtilities.class)
	public static void Home(String key) throws IOException, InterruptedException {							
		BaseSteps.setTextToControl(txtSearch, key, PageName.Home);			
		BaseSteps.clickToControl(btnSearch, PageName.Home);	
		Thread.sleep(3000);				
		BaseSteps.clickToControl(addItem, PageName.Home);
		
		}
}
