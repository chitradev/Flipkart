package TestCases;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import PageLocators.PageName;
import core.ElementFactory;

public class Tester {		
	
	
	public static void main(String[] args) throws InterruptedException, IOException {		
		
		clickwithlabel();	
		
	}		
	
	public static WebDriver driver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://alain.colanonline.net/");
		//driver.manage().window().maximize();
		//driver.findElement(By.xpath("//input[@id='userid']")).sendKeys("sujimu1997@gmail.com");
		//driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password@123");
		//driver.findElement(By.xpath("//button[@class='font-18']")).click();
		return driver;
		
	}
	
	
	public  void amazonLinks() throws InterruptedException {
		WebDriver driver=driver();
		List<WebElement>links=driver.findElements(By.xpath("//div[@class='navFooterLinkCol navAccessibility'][3]//ul/li/a"));
		 
		 //Actions a=new Actions(driver);
		String title;
		String title1;
		String title2;
       
		for(WebElement link:links) {		       
		link.sendKeys(Keys.CONTROL, Keys.ENTER);		
	     Thread.sleep(3000);
		}
		
		ArrayList<String> list=new ArrayList<String>();		
		ArrayList<String> windows = new ArrayList<String> (driver.getWindowHandles());
		System.out.println(windows.size());		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		String a="chitra", b="chitra";
		Assert.assertEquals(a.equalsIgnoreCase(b), "true");
		System.out.println("Passed");
		}
		
	
	@SuppressWarnings({ "unlikely-arg-type", "unused" })
	public static String getTableText(String tableName,String colName) throws InterruptedException {		
		
		WebDriver driver=driver();	
		String cellData = null;
		Thread.sleep(3000);	
		driver.findElement(By.xpath("//ul[@class='menu-items']/li[6]/a")).click();	
		
		List<WebElement> header=driver.findElement(By.xpath(""+tableName+"")).findElements((By.xpath("//thead/tr/th/span[1]")));				
		for(int i=0;i<header.size();i++) {		
		System.out.println(header.get(i).getText());
		if (header.get(i).getText().equals(colName)) 			
		{
			//System.out.println(td.get(i).getText());			
			List<WebElement> data= header.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<data.size();j++) {
			cellData=data.get(j).getText().trim();
			System.out.println(cellData);
			break;
		}
		}			
		}
		
		driver.quit();
		return cellData;			
		
	}	
	
	public static void uu(String tableName, String pageName) throws IOException {
		WebDriver driver=driver();	
		WebElement element=driver.findElement(By.xpath(ElementFactory.locator(tableName, pageName))); 
		System.out.println(element);
	}
	
	public static void checkbox() throws InterruptedException {
		WebDriver driver=driver();	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).isSelected());
		
	}
	
	public static void clickwithlabel() throws InterruptedException {
		WebDriver driver=driver();	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']")).click();
		Thread.sleep(2000);
		List<WebElement> Elements=driver.findElements(By.xpath("//label[@class='guestlbl']"));
		for(WebElement Element:Elements){		
			
			if(Element.getText().endsWith("Child"));
			{
				System.out.println(Element.getText());
				Element.click();
				
			}
		}
	}

	
}


