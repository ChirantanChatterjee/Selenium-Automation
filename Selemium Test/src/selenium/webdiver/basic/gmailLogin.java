package selenium.webdiver.basic;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class gmailLogin {
  
	WebDriver c;
	Robot r;
	
@Test
  public void f() { 
	 c.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 c.findElement(By.id("identifierId")).sendKeys("27.chirantan@gmail.com");
     c.findElement(By.id("identifierNext")).click();
   //c.findElement(By.xpath("//*[@id=\'identifierNext\']/span/span")).click();
   //c.findElement(By.linkText("More ways to sign in")).click();
   //c.findElement(By.xpath("//*[@id=\'view_container\']/form/div[2]/div/div/div/ul/li[2]/div/div[2]")).click();
     c.findElement(By.name("password")).sendKeys("********");
   //Due to not clickable error on the button position can not use the below with Chrome Driver  
  // c.findElement(By.xpath("//*[@id=\'passwordNext\']/span/span")).click();
     r.keyPress(KeyEvent.VK_ENTER);
  }
  @BeforeTest
  public void beforeTest() throws AWTException {
	  
	  System.setProperty("webdriver.chrome.driver","C://WebDrivers//chromedriver.exe/");
	  c = new ChromeDriver();
	  r = new Robot();
	  c.get("https://www.gmail.com/");
	  //c.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  c.quit();
  }

}
