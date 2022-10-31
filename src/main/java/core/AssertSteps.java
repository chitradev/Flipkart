package core;

import java.io.IOException;

public class AssertSteps {
	
	public static void verifyActualResult(boolean actualResult,String successMessage,String failureMessage) throws IOException {
		if(actualResult) {
			System.out.println(String.format("Result: PASSED. %s on Page :  %s",successMessage,Browser.getCurrentURL()));
		}else {
			Browser.takeScreenshot("PageNavigationFailed");
			System.out.println(String.format("Result: Failed. %s on Page :  %s", failureMessage,Browser.getCurrentURL()));
		}
	}
}


