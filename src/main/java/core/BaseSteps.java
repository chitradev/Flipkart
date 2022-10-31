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
import controls.Table;
import dev.failsafe.Timeout;
import utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
		public static String xpath ="";
		public static By by = null;
	 
	
	public static WebDriver driver() throws IOException{
		 
	return driver= Browser.initiateWebDriver();
	  
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
	 
		public static void scrollDown() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}
		
		public void scrollToMiddle() {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 250)");
		}

		public void scrollUp() {
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		
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
		act.moveToElement(element).click().build().perform();
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
	
	public static boolean WebElementDisplayed(String controlName,String pageName) throws IOException {		
		 File(pageName);  
		loadControl(controlName, pageName);
		WebElement element = driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName))); 
		return element.isDisplayed();				
		
	}	
	
	public static String getCellTableText(String tableName, String rowIndex, String colName, String pageName) throws IOException{
		//waitForTableDataLoaded(tableName,pageName);
		String tableLocator=ElementFactory.locator(tableName, pageName);
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",tableLocator,rowIndex.trim(),tableLocator,colName.trim());
		return driver.findElement(By.xpath(cellLocator)).getText().trim().replaceAll("[\\t\\n\\r]+"," ");
		
	}
	
	public static void clickCellTableText(String tableName, String rowIndex, String colName, String pageName) throws IOException{
		//waitForTableDataLoaded(tableName,pageName);
		String tableLocator=ElementFactory.locator(tableName, pageName);
		String cellLocator = String.format("%s//tbody/tr[%s]/*[count(%s//tbody/tr[1]/*[descendant-or-self::node()[starts-with(normalize-space(),'%s')]]/preceding-sibling::*)+1]",tableLocator,rowIndex.trim(),tableLocator,colName.trim());
		driver.findElement(By.xpath(cellLocator)).click();
		
	}

	public static int getRowTableCount(String tableName,String pageName) throws IOException {
	
		String xpath=ElementFactory.locator(tableName, pageName);
		String rowLocator=String.format("%s//tbody/tr", xpath);		
		return driver.findElements(By.xpath(rowLocator)).size();		
		
	}
	
	public static void selectByVisibleTextFromDropdown(String controlName,String option,String pageName) throws InterruptedException, IOException {
		 File(pageName);
		 loadControl(controlName, pageName);
		 WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 Select ddl = new Select(element);
		ddl.selectByVisibleText(option);
	 }
	
	public static void selectFirstOptionFromDropdown(String controlName,String pageName) throws InterruptedException, IOException {
		 File(pageName);
		 loadControl(controlName, pageName);
		 WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 Select ddl = new Select(element);
		ddl.selectByIndex(0);
	 }
	
	public static void selectByIndexFromDropdown(String controlName,int index,String pageName) throws InterruptedException, IOException {
		 File(pageName);
		 loadControl(controlName, pageName);
		 WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));		
		 Select ddl = new Select(element);
		ddl.selectByIndex(index);
	 }
	
	public void clickLabelwithText(String controlName, String Text,String pageName) throws IOException{
		File(pageName);
		loadControl(controlName, pageName);			
		List<WebElement> Elements=driver.findElements(By.xpath(ElementFactory.locator(controlName, pageName)));
		for(WebElement Element:Elements)
		{
			if(Element.getText().equals(Text))
			{
				Element.click();
				break;
			}
		}
	}
	
	public void InactiveCheckBox(String controlName,String pageName) throws IOException {
		WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));
		if(element.isSelected()==true)
			element.click();
	}

	public void ActiveCheckBox(String controlName,String pageName) throws IOException {
		WebElement element=driver.findElement(By.xpath(ElementFactory.locator(controlName, pageName)));
		if(!element.isSelected()==false)
			element.click();
	}
	
	
}	

	
	