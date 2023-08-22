package Com.Marcuri;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Marcuri_Registration_page {
 WebDriver driver;
	
 @BeforeSuite
 public void beforeSuite() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Seleniunm\\Chrome\\Chromenew\\chromedriver.exe");
		 driver =new ChromeDriver();
		 System.out.println("This is beforeSuite");
 }
 
 @BeforeClass
 public void beforeClass() {
	  driver.manage().window().maximize();
		 System.out.println("This is beforeclass");
 }
 
 @BeforeTest
 public void beforeTest() {
	  driver.get("https://demo.guru99.com/test/newtours/register.php");
		 System.out.println("This is beforeTest");
 }

 @BeforeMethod
 public void beforeMethod() {
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Set <Cookie> a=driver.manage().getCookies(); 
		 System.out.println("total cookies are "+a.size());
		 System.out.println("This is beforeMethod");
 }
 
 
	@Test(dataProvider="getdata")
  public void f(String firstname,String lastname,String phone,String email,String addr,String city,String state,String postalcode,String username,String password,String confirmPassword,String Countryy) 
  {
		 WebElement fn =driver.findElement(By.name("firstName"));
		  fn.sendKeys(firstname);
		  
		  WebElement ln =driver.findElement(By.name("lastName"));
		  ln.sendKeys(lastname);
		  
		  WebElement p =driver.findElement(By.name("phone"));
		  p.sendKeys(phone);
		  
		  WebElement E =driver.findElement(By.id("userName"));
		  E.sendKeys(email);
		  
		  WebElement AD =driver.findElement(By.name("address1"));
		  AD.sendKeys(addr);
		  
		  WebElement C =driver.findElement(By.name("city"));
		  C.sendKeys(city);
		  
		  WebElement S =driver.findElement(By.name("state"));
		  S.sendKeys(state);
		  
		  WebElement PC =driver.findElement(By.name("postalCode"));
		  PC.sendKeys(postalcode);
		  
		 
		  WebElement country =driver.findElement(By.xpath("//select[@name='country']"));
		  country.sendKeys(Countryy);
		  
		  
		  WebElement UN =driver.findElement(By.id("email"));
		  UN.sendKeys(username);
		  
		  WebElement P =driver.findElement(By.name("password"));
		  P.sendKeys(password);
		  
		  WebElement CP =driver.findElement(By.name("confirmPassword"));
		  CP.sendKeys(confirmPassword);
		   
		  WebElement sub =driver.findElement(By.name("submit"));
		  sub.click(); 
  }
	
	
	 @DataProvider
	  public Object[][] getdata() {
	    return new Object[][] {
	      new Object[] {"Saurabh","nagpure","8390666720","saurabhnagpure1013@gmail.com","arvinaka","Wardha","maharashtra","442001","sn1010","654321","654321","INDIA"},
	    };
	  }
	  
	      
	      
 

  @AfterMethod
  public void afterMethod() throws IOException {
	  File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFileToDirectory(src, new File("E:\\Testing\\SS of Mercury_registration_MavenProject\\"));
	  System.out.println("Aftermethod"); 
  }

  

  @AfterClass
  public void afterClass() {
	  System.out.println("afterClass"); 
	  driver.manage().deleteAllCookies();
  }

  

  @AfterTest
  public void afterTest() {
	  System.out.println("afterTest"); 
	  driver.close();
  }

  

  @AfterSuite
  public void afterSuite() {
	  System.out.println("afterSuite");   
  }

}
