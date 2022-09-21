package Resources;

import org.testng.annotations.DataProvider;
import configs.Path;
import utils.ExcelUtilities;

public class DataProviderClass {
	
	@DataProvider(name="FP01")
	public static Object[][] FP01() {
		
	Object[][] obj = ExcelUtilities.testData(Path.HomeSearch);
	return obj;
	}

	@DataProvider(name="FP02")
	public static Object[][] FP02() {
		
	Object[][] obj = ExcelUtilities.testData(Path.text);
	return obj;
	}
	
	@DataProvider(name="FP03")
	public static Object[][] FP03() {
		
	Object[][] obj = ExcelUtilities.testData(Path.print);
	return obj;
	}
}
