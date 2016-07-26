package selenium;

import javax.xml.stream.events.StartDocument;

import org.openqa.selenium.By;
import org.testng.Assert;
import static org.junit.Assert.*;

public class AccountCreate extends BaseClass
{
		// Final variables 
		final private static String EMAIL_PREFIX = "selenium.test.";
		private static String EMAIL_ID = null;
		final private static String FIRST_NAME = "Takipi";
		final private static String LAST_NAME = "Selenium";
		final private static String COMPANY = "SeleniumComp";
		final private static String PHON_NUM = "-";
		final private static String PASSOWRD = "Aa123456";
		final private static String SIGNUP_URL = "https://app.takipi.com/account.html";
		final private static String SIGNIN_URL = "https://app.takipi.com/login.html";
		final private static String TAKIPI_COM_URL = "https://www.takipi.com" ;
		
		final private static int RUN_SIGNUP_ACCOUNT = 1; 
		final private static int RUN_SIGNUP_COM = 2;
		
		/** - 
		 * This class creates new account at Takipi and login into https://app.takipi.com/ website
		 * @throws InterruptedException 
		 */
		public static void main(String[] args) throws InterruptedException 
		{
			run(RUN_SIGNUP_ACCOUNT);
			System.err.println("111");
			run(RUN_SIGNUP_COM);
			System.err.println("222");
		}
		
		/**
		 * This method generate an email address , create a new Firefox driver and call   
		 * @param x The option 
		 * @throws InterruptedException
		 */
		private static void run(int x) throws InterruptedException 
		{
			try
			{
				//Get email ID
				EMAIL_ID = getEmailId(EMAIL_PREFIX);
				//Get Selenium driver instance
				driver = getDriver();
				Boolean created = false; 	
	
				//Create a new Takipi account
				if (x == RUN_SIGNUP_ACCOUNT)
				{
					 created = createTakipiAccount();	//Create an account by https://app.takipi.com/account.html
				}
				else if (x == RUN_SIGNUP_COM)  
				{
					 created = takipiCom();    //Create an account by https://www.takipi.com
				}
				
				//Login if account creation is success
				if (created)
				{
					loginToTakipiAccount();
				}
				
			}					
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			} 
			 
			finally
			{
				close(driver);
			}	
		}
		
	
		/**
		 *  set values of fields - except the email field . 
		 */
		private static void setUserDetails() 
		{
				driver.findElement(By.cssSelector("input.firstName")).clear();
			    driver.findElement(By.cssSelector("input.firstName")).sendKeys(FIRST_NAME);
			    
			    driver.findElement(By.cssSelector("input.lastName")).clear();
			    driver.findElement(By.cssSelector("input.lastName")).sendKeys(LAST_NAME);

			    driver.findElement(By.cssSelector("input.company")).clear();
			    driver.findElement(By.cssSelector("input.company")).sendKeys(COMPANY);				

			    driver.findElement(By.cssSelector("input.phone")).clear();
			    driver.findElement(By.cssSelector("input.phone")).sendKeys(PHON_NUM);				
   
			    driver.findElement(By.cssSelector("input.password")).clear();
			    driver.findElement(By.cssSelector("input.password")).sendKeys(PASSOWRD);
			    
			    driver.findElement(By.cssSelector("input.confirmPassword")).clear();
			    driver.findElement(By.cssSelector("input.confirmPassword")).sendKeys(PASSOWRD);
			    
			    //CLick on Create Account
			    driver.findElement(By.cssSelector("a.createAccountBtn")).click();
		}
		
		/**
		 * Trying creating a new account at Takipi .
		 * @return True if it's success . 
		 */
		private static boolean createTakipiAccount()
		{
			Boolean createdFlag = false;
				try
				{
					//Open the Signup link
					driver.get(SIGNUP_URL);
					waitForElement(driver, By.id("googleSigninBtn"));

					//Start filling form
					// Email 
					driver.findElement(By.cssSelector("input.email")).clear();
				    driver.findElement(By.cssSelector("input.email")).sendKeys(EMAIL_ID);
				    // The rest fields 
				    setUserDetails();  
				    
				   createdFlag = checkAccountCreation();
				    
				}
				catch (Exception e) 
				{
					createdFlag = false;
					e.printStackTrace();
					throw new RuntimeException("There is an issue in creating Takipi Account! "+e.getMessage());
				}
			
			return createdFlag;
		}
		
		/**
		 * Checks if the account created successfully  
		 * @return True if creation success and false is not. 
		 * @throws InterruptedException
		 */
		private static boolean checkAccountCreation() throws InterruptedException 
		{
   		
			sleep(20);
		    String currentUrl = driver.getCurrentUrl();	
	        System.err.println(currentUrl); 
		    if ((currentUrl.equals("https://app.takipi.com/account-success.html")) || (currentUrl.equals("https://app.takipi.com/index.html")))
		    {
		    	System.out.println("Created successfully!!");
		    	return true;  
		    }
		    else
		    {
			    System.out.println("Failed Created");
		    	return false;
		    }
		}
			
		/**
		 *  Trying creating a new account at takipi.com  . 
		 * @return True if the account created successfully 
		 */
		private static Boolean takipiCom() 
		{
			Boolean createdFlag = false;

			try
			{
				driver.get(TAKIPI_COM_URL);
				waitForElement(driver, By.id("blueSiteIndexMain"));
				driver.findElement(By.cssSelector("input.text.emailInput")).clear();
			    driver.findElement(By.cssSelector("input.text")).sendKeys(EMAIL_ID);
			    driver.findElement(By.cssSelector("input.btn-submit")).click();		
			    sleep(15);
			    
			    String currentUrl = driver.getCurrentUrl();
			    String comUrl = "index" ;
			    System.err.println(currentUrl);
			    
			    if (currentUrl.contains(comUrl))
			    {
			    	waitForElement(driver, By.id("createAccountForm"));		
					setUserDetails();
					createdFlag = checkAccountCreation() ;
			    }
			    else
			    {
			    	throw new RuntimeException ("There is an issue in creating Takipi Account (app.takipi.com)");
			    }		
			}
			catch (Exception e) 
			{
				throw new RuntimeException("There is an issue in login into Takipi Account through takipi.com! "+e.getMessage());
			}
			return createdFlag;
		}

		/**
		 * Sing in www.Takipi.com
		 */
		private static void loginToTakipiAccount()
		{
			try
			{
					//Open the Sigin link
					driver.get(SIGNIN_URL);
					
					waitForElement(driver, By.className("loginEmailInput"));
					//Enter user email id
					driver.findElement(By.cssSelector("input.loginEmailInput")).clear();
				    driver.findElement(By.cssSelector("input.loginEmailInput")).sendKeys(EMAIL_ID);
				    //Enter password
				    driver.findElement(By.cssSelector("input.loginPasswordInput")).clear();
				    driver.findElement(By.cssSelector("input.loginPasswordInput")).sendKeys(PASSOWRD);
				    //Click on Login
				    driver.findElement(By.cssSelector("a.loginBtn")).click();
				    
				    //Checks if the user logged in successfully 
				    sleep(20);
				    Assert.assertEquals(driver.getTitle().trim(),"Takipi - Inbox");
				    Assert.assertEquals(driver.getCurrentUrl().trim(),"https://app.takipi.com/index.html");
				    System.out.println("Login success!");
				    
			}
			catch(Exception e)
			{
					throw new RuntimeException("There is an issue in login into Takipi Account! "+e.getMessage());
			}
		}
		
}
