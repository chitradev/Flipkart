package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {

	public static WebDriver driver;	
	
	
	@SuppressWarnings("deprecation")
	public static WebDriver initiateWebDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\CIPL1017\\eclipse-workspace\\Flipkart\\GlobalVariable.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
	if(browserName.equals("chrome")) {
		
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	else if(browserName.equals("firefox")) {
		
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\geckodriver.exe");
		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	else if(browserName.equals("edge")) {
		
		//System.setProperty("webdriver.edge.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\msedgedriver.exe");
		//driver=new EdgeDriver();
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	return driver;	
	
		
	}	
	
	
	
	
}
