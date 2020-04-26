package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class is for Base page
 * 
 * @author Abhinav_Kumar19
 *
 */
public class BasePage {

	WebDriver driver;
	Properties prop;

	/**
	 * This method returns driver
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public WebDriver driverInitialization() {
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("PLease select browser between Chrome and Firefox");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}

	/**
	 * This method reads properties from configuration file.
	 * 
	 * @return
	 */
	public Properties propertiesRead() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"D:\\OneDrive - Infosys Limited\\Eclipse_Workspace\\SeleniumPOMFramework\\src\\main\\java\\com\\qa\\config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
