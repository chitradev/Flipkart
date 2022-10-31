package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.beust.jcommander.Strings;

import configs.Path;
import utils.PlatformUtil;

public class ElementFactory {
	
	public static WebDriver driver;
	
	public ElementFactory() {
		
	PageFactory.initElements(driver, this);	
	}
	
	public static String locator(String controlName, String pageName) throws IOException {

	Properties prop = new Properties();
	prop.load(BaseSteps.File(pageName));
	return prop.getProperty(controlName);
				
}

	

}
