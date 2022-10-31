package core;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WebEventListener implements ITestListener {
	
	ExtentReport report;
	ExtentTest test;

	
	@Override
	public void onStart(ITestContext context) {
		
		
		
	}
	
	@Override
	public void onTestFailure(ITestResult result){		
	try {
				
	Browser.takeScreenshot(result.getName());
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	

	@Override
	public void onTestSuccess(ITestResult result) {
		
	test.addScreenCapture(System.getProperty("user.dir")+"/Reports/TestCase/"+result.getName());			
		test.log(LogStatus.PASS,"Test Passed");		
			
	}


	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}




	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.reports(context.getName());
	}
	
	
		
	}
	
	

