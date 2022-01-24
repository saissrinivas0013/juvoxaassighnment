package Testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Testcase2 {
	public static WebDriver driver;
	   static Properties config;
	   static Properties OR;
  @Test(priority = 0)
  public void f() {
	  driver.get(config.getProperty("TestsiteURL"));
	  String title=  driver.getTitle();
	  System.out.println(title);
	  driver.manage().window().maximize();
  }
  @Test(priority = 1)
  public void wristwatches() throws Exception {
	   WebElement serachbar=	driver.findElement(By.id(OR.getProperty("searchbar")));
	    serachbar.sendKeys("Wrist Watches");
	    serachbar.submit();
	    Thread.sleep(5000);
	    WebElement seemore=driver.findElement(By.xpath(OR.getProperty("seemore")));
	    seemore.click();
		WebElement titan=driver.findElement(By.cssSelector(OR.getProperty("titancheckbox")));
		Thread.sleep(3000);
		titan.click();
		Thread.sleep(5000);
		WebElement leather=driver.findElement(By.cssSelector(OR.getProperty("leatherbox")));
		leather.click();
		Thread.sleep(5000);
		WebElement analogue=driver.findElement(By.cssSelector(OR.getProperty("analouge")));
		analogue.click();
		Thread.sleep(5000);
		WebElement offer=driver.findElement(By.cssSelector(OR.getProperty("offerlink")));
		offer.click();
		Thread.sleep(5000);
	WebElement fifth=	driver.findElement(By.cssSelector(OR.getProperty("fifthsearch")));
	fifth.click();
    String fifthtext=  fifth.getText();
	     System.out.println(fifthtext);
			fifth.click();
		Thread.sleep(5000);
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath(OR.getProperty("addtocartbutton"))).click();
		Thread.sleep(3000);
		driver.findElement(By.id("nav-cart")).click();
	String cartresult=	driver.findElement(By.xpath("//span[@class='a-truncate-cut']")).getText();
		if(fifthtext.equals(cartresult)) {  
			System.out.println("result verified sucessfully");
		}else {
			System.out.println("results not verified");
		}
		

  }
  
  
  
  @BeforeClass
  public void beforeClass() throws Exception {
	  config= new Properties();
	  FileInputStream fis = new FileInputStream("D:\\project\\com.e-comerce.amazon\\src\\main\\java\\com\\ecomerce\\properties\\config.properties");
	  config.load(fis);
	  OR= new Properties();
	  FileInputStream fiss=new FileInputStream("D:\\project\\com.e-comerce.amazon\\src\\main\\java\\com\\ecomerce\\properties\\OR.properties");
	  OR.load(fiss);
	  if(config.getProperty("browser").equals("chrome")) {
		driver=new ChromeDriver();
	  }
	  else {
		  System.out.println("unable to launch the browser");
	  }
	  
	
	  
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  
  }

}
