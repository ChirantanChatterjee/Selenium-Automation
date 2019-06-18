package selenium.webdiver.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookPost {
  @Test
  public void f() {
	 
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C://WebDrivers//chromedriver.exe/");
	  WebDriver g = new ChromeDriver();
	  g.get("https://www.facebook.com/");
	  g.manage().window().maximize();
	  g.findElement(By.id("email")).sendKeys("abc");
  }

  @AfterTest	
  public void afterClass() {
	  
  }

}
