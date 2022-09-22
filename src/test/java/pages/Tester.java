package pages;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Tester {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	
		WebElement link=driver.findElement(By.xpath("//li[@class='nav_first']/a"));
		//System.out.println(link);
		Actions a=new Actions(driver);
        // defective code start
        a.moveToElement(link).contextClick(link);
        Thread.sleep(1000);
        a.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        //a.sendKeys(Keys.ENTER).build().perform();
       driver.quit();
      
		/*Set<String> windows = driver.getWindowHandles();		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);	
		Iterator<String> win1=windows.iterator();
		String w=win1.next();
		//String w2=win1.next();
		driver.switchTo().window(w);*/
	}

}
