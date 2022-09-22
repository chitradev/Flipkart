package core;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class WebEventListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result){		
	try {
				
	Browser.takeScreenshot(result.getName());
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentReport.reports(context.getName());
	}
	
	
		
	}
	
	

