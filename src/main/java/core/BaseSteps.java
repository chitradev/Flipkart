package core;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import PageLocators.*;
import configs.*;
import dev.failsafe.Timeout;
import utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseSteps  {
	
	 public static WebDriver driver;
	 protected WebElement element;
		protected Actions action;
		protected static WebDriverWait wait;
		protected Wait<WebDriver> fluentWait;
		public String xpath ="";
		//public static By by = null;
	 
	
	public static void driver() throws IOException{
		 
	driver= Browser.initiateWebDriver();
	  
	 } 
	public static void driverquit() {
		driver.quit();
	}
	 
	 public static FileInputStream File(String pageName) throws FileNotFoundException {
		 		 
		 if(pageName.equals("GlobalVariable"))
		 {		 
		FileInputStream page = new FileInputStream(Path.URL_PATH);
			 return page;
		 }
		 else {
			 FileInputStream page = new FileInputStream(Path.LOCATOR_PATH+"\\"+pageName+".properties");
			 return page;
		 }		 
		
	 }	 	
	
	public static String getTextFromControl(String controlName, String pageName) throws InterruptedException, IOException {        
		File(pageName);	
		
		WebElement getText = driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 String Text=getText.getText();		 
        return Text;
    }
	
	 public static void clickToControl(String controlName, String pageName) throws InterruptedException, IOException {
		 File(pageName);	
		 loadControl(controlName, pageName);
		WebElement clickElement = driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 clickElement.click();	 
	       
	    }
	 
	 public static void setTextToControl(String controlName, String text, String pageName) throws InterruptedException, IOException {
	    File(pageName);  
	    loadControl(controlName, pageName);
		WebElement setText = driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 setText.clear();		 
		 setText.sendKeys(text);		 		 
	    }
	 public static void setKeys(String controlName, String text, String pageName) throws IOException {
		 File(pageName);  
		loadControl(controlName, pageName);
		WebElement setkeys = driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName))); 
		setkeys.sendKeys(Keys.ENTER);		 
	 }
	 
	 public static void launchUrl(String controlName,String pageName) throws InterruptedException, IOException {
	     File(pageName); 	      
		 driver.get(ElementFactory.locator(controlName, pageName));		 
		 		       
		   }
	 
	 @SuppressWarnings("deprecation")
	public static void mouseHover(String controlName,String pageName) throws InterruptedException, IOException {
		 File(pageName);
		 loadControl(controlName, pageName);
		 WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	 }
	 
	 public static void loadControl(String controlName,String pageName){
			if(controlName!=null){
			waitForControlDisplay(10, controlName, pageName);				
				
			}
		}
	 
	 @SuppressWarnings("deprecation")
	public static void waitForControlDisplay(int timeoutInSeconds,String controlName,String pageName){
			try{
				wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
				
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementFactory.locator(controlName, pageName))));
	
			}catch(Throwable e){
				
				e.printStackTrace();
			}
	 }
			
	@SuppressWarnings("deprecation")
	public static void waitImplicitly() {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
	}
	
	public static void waitForControlClickable(int timeoutInSeconds,String controlName,String pageName) {
		
		try{
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
			WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));			
			wait.until(ExpectedConditions.elementToBeClickable(element));

		}catch(Throwable e){
			
			e.printStackTrace();
		}
		
	}	
	
	}


