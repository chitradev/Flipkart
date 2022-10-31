package TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import PageLocators.PageName;
import core.BaseSteps;

public class clickToCellText {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CIPL1017\\Downloads\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
			

	driver.get("https://einstein2.us/VMSQAAutomation/Account/login.aspx?");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//input[@id='MainContent_Email']")).sendKeys("agency@yopmail.com");
	driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Hallmark@123");
	driver.findElement(By.xpath("//input[@id='MainContent_btnlogin']")).click();
	Thread.sleep(2000);
	Actions act=new Actions(driver);
	WebElement ele=driver.findElement(By.xpath("//a[text()='Candidate']"));
	act.moveToElement(ele).build().perform();
	driver.findElement(By.xpath("//a[text()='TimeSheet']")).click();
	Thread.sleep(2000);

	BaseSteps.clickCellTableText("tableEin", "1", "Time In", PageName.Header);

	

	}

}
