package core;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport {
	
	public static void reports(String TestCaseName) {
	
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")+"/Reports/TestCase/TestReport.html");
	ExtentTest test = report.startTest(TestCaseName, "Test Case Started");
	test.addScreenCapture(System.getProperty("user.dir")+"/Reports/TestCase/TestReport.html");
	
	report.endTest(test);
	test.log(LogStatus.PASS,"Test Passed");
	test.log(LogStatus.FAIL,"Test Failed");
	test.log(LogStatus.SKIP,"Test Skipped");
	test.log(LogStatus.INFO,"Test Info");
	report.flush();
	
	}

}
