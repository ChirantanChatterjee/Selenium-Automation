package selenium.webdiver.basic;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
   
public class GoibiboTransaction {
	
	WebDriver c;
	Robot r;
  @Test
  public void f() throws InterruptedException {
	    c.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

		//Date Selection
		c.findElement(By.xpath("//*[@id=\'searchWidgetCommon\']/div[1]/div[1]/div[1]/div/div[5]/input")).click();
		Thread.sleep(2000);
	    String date = "21-June 2019";
	    String splitter[] = date.split("-");
	    String CheckIn_month_year = splitter[1];
	    String CheckIn_day = splitter[0];
	    
	    selectDate(CheckIn_month_year,CheckIn_day);
	    
		WebElement From_City = c.findElement(By.id("gosuggest_inputSrc"));
		From_City.sendKeys("Pune");
		Thread.sleep(2000);
		From_City.sendKeys(Keys.ARROW_DOWN);
		From_City.sendKeys(Keys.ENTER);
		
		WebElement To_City = c.findElement(By.id("gosuggest_inputDest"));
		To_City.sendKeys("Kolkata");
		Thread.sleep(2000);
		To_City.sendKeys(Keys.ARROW_DOWN);
		To_City.sendKeys(Keys.ENTER);
		
		c.findElement(By.id("gi_search_btn")).click();
		c.findElement(By.xpath("//*[@id=\'content\']/div/div[2]/div/div[4]/div/div[4]/div[2]/div[2]/div/div/span[1]/span/input")).click();
		
		Select Title = new Select(c.findElement(By.xpath("//*[@id=\'Adulttitle1\']")));
		Title.selectByVisibleText("Mr");
		
		c.findElement(By.id("AdultfirstName1")).sendKeys("Chirantan");
		c.findElement(By.id("AdultlastName1")).sendKeys("Chatterjee");
		
		Select Day = new Select(c.findElement(By.id("Adultdob_day1")));
		Day.selectByVisibleText("27");
		
		Select Month = new Select(c.findElement(By.id("Adultdob_month1")));
		Month.selectByVisibleText("Apr");
		
		Select Year = new Select(c.findElement(By.id("Adultdob_year1")));
		Year.selectByVisibleText("1994");
		
		c.findElement(By.id("email")).sendKeys("abc.def@gmail.com");
		c.findElement(By.id("mobile")).sendKeys("123456789");
		Thread.sleep(3000);
		c.findElement(By.xpath("//*[@id=\'travellerForm\']/div[2]/button")).click();
		
		
  }
  private void selectDate(String month_year, String day) throws InterruptedException {
	  List<WebElement> elements = c.findElements(By.xpath("//*[@id=\'searchWidgetCommon\']/div[1]/div[1]/div[1]/div/div[5]/div/div/div[2]/div[1]"));
			for(int i=0; i<elements.size(); i++) {
				System.out.println(elements.get(i).getText());
				if(elements.get(i).getText().equals(month_year)) {
					//selection of date
					System.out.println("Check");
					List<WebElement> days = c.findElements(By.className("calDate"));
					//List<WebElement> days = c.findElements(By.xpath("//*[@id=\'searchWidgetCommon\']/div[1]/div[1]/div[1]/div/div[5]/div/div/div[2]/div[3]"));
					for(WebElement d:days) {
						System.out.println(d.getText());
						if(d.getText().equalsIgnoreCase(day)) {							
							d.click();
							Thread.sleep(3000);
							return;
						}
					}
					
					
				}
			}
	
}
@BeforeTest
  public void beforeTest() throws AWTException {
	  System.setProperty("webdriver.chrome.driver","C://WebDrivers//chromedriver.exe/");
	  c = new ChromeDriver();
	  r = new Robot();
	  c.get("https://www.goibibo.com/");
	  c.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
