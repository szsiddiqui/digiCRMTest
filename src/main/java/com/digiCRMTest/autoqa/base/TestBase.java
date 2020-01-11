package com.digiCRMTest.autoqa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.digiCRMTest.autoqa.Util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	
	public static Properties prop;
	
	public static EventFiringWebDriver e_driver;
	
	public static WebDriverEventListener eventListener;
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			
			FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/digiCRMTest/autoqa/config/config.properties");	
			
			prop.load(ip);
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
			public static void initialization()
			{
				String browserName = prop.getProperty("browser");
				if(browserName.equals("chrome"))
				{
					String path=System.getProperty("user.dir");
					System.setProperty("webdriver.chrome.driver", path+"\\Drivers\\chromedriver.exe");
					driver=new ChromeDriver();
				}else if(browserName.equals("Firefox"))
				{
					System.setProperty("webdriver.gecko.driver", "/Selenium-3.141.59/geckodriver.exe");
					driver=new FirefoxDriver();
				}
				
				/*e_driver=new EventFiringWebDriver(driver);
				eventListener=new WebEventListener;
				e_driver.register(eventListener);
				driver=e_driver;
				*/
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
				
				driver.get(prop.getProperty("url"));
			}
		
	}

