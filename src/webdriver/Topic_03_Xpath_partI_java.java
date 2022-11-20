package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_Xpath_partI_java {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	//@Test
	public void TC_01_ValidateCurrentUrl() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login");
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		driver.get("http://live.techpanda.org/index.php/customer/account/login");
		System.out.println(driver.findElement(By.xpath("//li[@class='error-msg']//span[text()='Invalid login or password']")).getText());
		
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}