package Testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Testcase3 {
	public static WebDriver driver;
	   static Properties config;
	   static Properties OR;
		
  @Test
  public void f() throws Exception {
	  WebDriver driver=new ChromeDriver();
		driver.get(config.getProperty("imgurURL"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		WebElement newpost=	driver.findElement(By.xpath(OR.getProperty("newpost")));
	newpost.click();
	Thread.sleep(3000);
	WebElement choosefile=driver.findElement(By.xpath(OR.getProperty("choosefile")));
	Thread.sleep(3000);
	choosefile.click();
	Thread.sleep(3000);
  StringSelection ss = new StringSelection(config.getProperty("imagepath"));
  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
  Robot robot = new Robot();
  robot.delay(250);
  robot.keyPress(KeyEvent.VK_ENTER);
  robot.keyRelease(KeyEvent.VK_ENTER);
  robot.keyPress(KeyEvent.VK_CONTROL);
  robot.keyPress(KeyEvent.VK_V);
  robot.keyRelease(KeyEvent.VK_V);
  robot.keyRelease(KeyEvent.VK_CONTROL);
  robot.keyPress(KeyEvent.VK_ENTER);
  robot.delay(90);
  robot.keyRelease(KeyEvent.VK_ENTER);
  System.out.println("file upload sucessfully");

	  
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
  }

}
