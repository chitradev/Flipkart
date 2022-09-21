package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	
		String link=driver.findElement(By.xpath("//li[@class='nav_first']/a")).getAttribute("href");
		System.out.println(link);
		Set<String> windows = driver.getWindowHandles();		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(link);	
		Iterator<String> win1=windows.iterator();
		String w=win1.next();
		//String w2=win1.next();
		driver.switchTo().window(w);
	}

}
