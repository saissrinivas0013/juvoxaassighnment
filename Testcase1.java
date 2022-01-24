package Testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Testcase1 {
public static WebDriver driver;
   static Properties config;
   static Properties OR;
	
  @Test(priority = 0)
  public  void f() {
	  driver.get(config.getProperty("TestsiteURL"));
	  String title=  driver.getTitle();
	  System.out.println(title);
	  driver.manage().timeouts().implicitlyWait(3000,TimeUnit.SECONDS);
	  driver.manage().window().maximize();

  }
  @Test(priority = 1)
  public void login() throws Exception {
	WebElement  sighin=driver.findElement(By.xpath(OR.getProperty("signin")));
	sighin.click();
	WebElement login=driver.findElement(By.id(OR.getProperty("loginid")));
	login.sendKeys("6281881648");
    driver.findElement(By.id(OR.getProperty("continuebutton"))).click();
    WebElement password=driver.findElement(By.id(OR.getProperty("password")));
    password.sendKeys("vasubabu");
    driver.findElement(By.id(OR.getProperty("sighinbutton"))).click();
    Thread.sleep(3000);
    
			  
  }
  @Test(priority=3)
public void smartphones() throws Exception {
		WebElement searchbar=driver.findElement(By.id(OR.getProperty("searchbar")));
		searchbar.sendKeys("smartphones");
		Thread.sleep(3000);
		WebElement searchbutton= driver.findElement(By.id(OR.getProperty("serachbutton")));
		searchbutton.click();
	    Thread.sleep(3000);
		WebElement oppocheckbox=driver.findElement(By.xpath(OR.getProperty("oppocheckbox")));
		oppocheckbox.click();
		Thread.sleep(3000);
		List<WebElement>  oppo= driver.findElements(By.xpath(OR.getProperty("oppolist")));
		 System.out.println(oppo.size());
		 for(int i=0;i<oppo.size();i++) {
			String resulttetxs= (oppo.get(i).getText());
			 System.out.println(resulttetxs);
		 
		 if(resulttetxs.contains("OPPO")) {
			 System.out.println("results are sucessfully verified");
		 }else if (resulttetxs.contains("Oppo"))
		 {
			System.out.println("results are sucessfully verified");
		 }else {
			 System.out.println("results are not matched");
			 
		 }
		 }
	  
  }
@BeforeClass
  public void beforeClass() throws IOException  {
	  
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
