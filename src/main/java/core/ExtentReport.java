package core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	public static void reports(String TestCaseName) {
	
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/Reports/TestCase/TestReport.html");
		
	report.flush();
	
	}

}
