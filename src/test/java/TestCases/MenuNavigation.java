package TestCases;

import java.io.IOException;
import PageLocators.PageName;
import core.AssertSteps;
import core.BaseSteps;

public class MenuNavigation extends BaseSteps{
	
	public static boolean isPageHeaderDisplayed() throws IOException {
		return BaseSteps.WebElementDisplayed("pageHeader", PageName.Header);
	}
	
	public static boolean isPageHeader2Displayed() throws IOException {
		return BaseSteps.WebElementDisplayed("pageHeader2", PageName.Header);
	}
	
	
	public static String getPageHeader() throws InterruptedException, IOException {
		String AssertMsg="Page Header Display Validation after Navigating to Screen";
		AssertSteps.verifyActualResult(isPageHeaderDisplayed(), AssertMsg+" - PASS",AssertMsg+ " - FAIL");
		String Header = "";
		if(isPageHeaderDisplayed()) {
		Header=BaseSteps.getTextFromControl("pageHeader", PageName.Header);		
		}
		return Header;
	}
	
	public static String getPageHeader2() throws InterruptedException, IOException {
		String AssertMsg="Page Header Display Validation after Navigating to Screen";
		AssertSteps.verifyActualResult(isPageHeader2Displayed(), AssertMsg+" - PASS",AssertMsg+ " - FAIL");
		String Header = "";
		if(isPageHeaderDisplayed()) {
		Header=BaseSteps.getTextFromControl("pageHeader2", PageName.Header);		
		}
		return Header;
	}
	

	public static void verifyPageHeader(String expectedPageHeader) throws IOException, InterruptedException {
		String actualPageHeader=getPageHeader();
		String AssertMsg="Page Header Validation Expected : "+expectedPageHeader+" and Actual : "+actualPageHeader;
		AssertSteps.verifyActualResult(actualPageHeader.equals(expectedPageHeader), AssertMsg+" - PASS",AssertMsg+ " - FAIL");
	}
	
	public static void verifyPageHeader2(String expectedPageHeader) throws IOException, InterruptedException {
		String actualPageHeader=getPageHeader2();
		String AssertMsg="Page Header Validation Expected : "+expectedPageHeader+" and Actual : "+actualPageHeader;
		AssertSteps.verifyActualResult(actualPageHeader.equals(expectedPageHeader), AssertMsg+" - PASS",AssertMsg+ " - FAIL");
	}
			
	
	public static void gotoDashBoard() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuDashBoard", PageName.Header);
	}
	
	public static void verifyNavigationToDashBoard() throws InterruptedException, IOException {
		
	gotoDashBoard();
	verifyPageHeader(getPageHeader());	
	}
	
	public static void gotoManageSubMerchants() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuManageSubMerchants", PageName.Header);
	}
	
	
	public static void verifyNavigationToManageSubMerchants() throws InterruptedException, IOException {
		
		gotoManageSubMerchants();
		verifyPageHeader(getPageHeader());
		
		}
		
	public static void gotoManageCustomers() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuManageCustomers", PageName.Header);
	}
	
	
	public static void verifyNavigationToManageCustomers() throws InterruptedException, IOException {
		
		gotoManageCustomers();
		verifyPageHeader(getPageHeader());	
		
		}
	
	public static void gotoCreateGenerateInvoice() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuCreateGenerateInvoice", PageName.Header);
	}
	
	
	public static void verifyNavigationToCreateGenerateInvoice() throws InterruptedException, IOException {
		
		gotoCreateGenerateInvoice();
		verifyPageHeader2(getPageHeader2());	
		
		}
	
	public static void gotoRolesAndPermissions() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuCreateGenerateInvoice", PageName.Header);
	}
	
	
	public static void verifyNavigationToRolesAndPermissions() throws InterruptedException, IOException {
		
		gotoCreateGenerateInvoice();
		verifyPageHeader(getPageHeader());	
		
		}
	
	public static void gotoSubMenuTransactionsReport() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuReports", PageName.Header);
		BaseSteps.clickToControl("subMenuTransactionsReports", PageName.Header);
	}
	
	public static void verifyNavigationToSubMenuTransactionsReport() throws InterruptedException, IOException {
		
		gotoSubMenuTransactionsReport();
		verifyPageHeader(getPageHeader());	
		
		}
	
	public static void gotoSubMenuStatisticsReport() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuReports", PageName.Header);
		BaseSteps.clickToControl("subMenuStatisticsReports", PageName.Header);
	}
	
	public static void verifyNavigationToSubMenuStatisticsReport() throws InterruptedException, IOException {
		
		gotoSubMenuStatisticsReport();
		verifyPageHeader(getPageHeader());	
		
		}
	
	public static void gotoSubMenuListReport() throws InterruptedException, IOException {
		
		BaseSteps.clickToControl("mnuReports", PageName.Header);
		BaseSteps.scrollDown();
		Thread.sleep(1000);
		BaseSteps.clickToControl("subMenuListReports", PageName.Header);
		Thread.sleep(3000);
	}
	
	public static void verifyNavigationToListReport() throws InterruptedException, IOException {
		
		gotoSubMenuListReport();
		verifyPageHeader(getPageHeader());	
		
		}
	

	}
