package TestCases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import core.BaseSteps;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageLocators.PageName;
import core.Browser;
import core.ControlFactory;
import core.ElementFactory;
import core.GlobalVariable;
import utils.ExcelUtilities;

public class FPLoginPage extends Browser {
	
	private static final String txtUserName = "txtUserName";
	private static final String txtPwd="txtPwd";
	private static final String btnlogin="btnlogin";				
		
	
	public static void Log() throws IOException, InterruptedException
	{
	BaseSteps.driver();
	BaseSteps.launchUrl("URL","GlobalVariable");
	BaseSteps.setTextToControl(txtUserName,ElementFactory.locator("UserName", "GlobalVariable"),PageName.Login);		
	BaseSteps.setTextToControl(txtPwd,ElementFactory.locator("Password", "GlobalVariable"), PageName.Login);
	BaseSteps.clickToControl(btnlogin, PageName.Login);	
	}
	
	
	public static void Logout() throws IOException, InterruptedException
	{
		driver.quit();
		
	}	
			
		
	}	
				


	
	

