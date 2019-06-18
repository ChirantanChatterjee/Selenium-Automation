package selenium.webdiver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	WebDriver driver;
	
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","C://WebDrivers//chromedriver.exe/");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.youtube.com");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.close();
	}

	public static void main(String[] args) {
		
		Test1 newObj = new Test1();
		newObj.OpenBrowser();

	}

}
