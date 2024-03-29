package selenium;

//import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

/**
 * Takipi Selenium tester
 * Base Class .
 * @author Hodaya Gamliel 
 * @version 1.0
 *
 */

public class BaseClass
{
	private static int TIME_OUT_IN_SEC = 40;
	private static int TIME_BEFORE_CLOSE_IN_SEC = 20;
	protected static WebDriver driver = null;
	
	/**
	 *
	 * @return The driver - chrome driver , max size . 
	 */
	protected static WebDriver getDriver()
	{	
		driver = new FirefoxDriver();	
		driver.manage().timeouts().implicitlyWait(0,TimeUnit.SECONDS );
		driver.manage().window().maximize();
		
		return driver;
	}
	
	/**
	 * wait for response from by 
	 * @param driver
	 * @param by
	 * @return 
	 */
	protected static WebElement waitForElement(WebDriver driver, By by)
	{
		WebDriverWait wait = new WebDriverWait(driver, TIME_OUT_IN_SEC);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	/**
	 * create an email in pattern prefix+date@takipi.com . 
	 * @param prefix
	 * @return email
	 */
	protected static String getEmailId(String prefix)
	{
		Date date= new Date();
		String email = prefix+date.getTime()+"@takipi.com";
		System.out.println("Email id - "+email);
		
		return email;	
	}
	/**
	 * Sleep in seconds
	 * @param x
	 * @throws InterruptedException
	 */
	protected static void sleep(int x) throws InterruptedException 
	{
		Thread.sleep(1000 * x);
	}
	
	/**
	 * close - sleep 20 seconds and close the driver 
	 * @param driver
	 * @throws InterruptedException
	 */
	protected static void close(WebDriver driver) throws InterruptedException 
	{
		sleep(TIME_BEFORE_CLOSE_IN_SEC);
		driver.close();
		driver.quit();
	}
}
