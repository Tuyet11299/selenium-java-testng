package webdriver;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.WebDriver.Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_05_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		// gán biến driver bằng cái new browser mà mình dùng
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
// tương tác với browser sẽ thông qua biến driver
	// tương tác với element thông qua biến Webelement
	// Khi sử dụng 1 hàm, nhìn gợi ý sẽ biết được hàm trả lại gì (void: không trả lạ gì, webelemnet: trả lại 1 element,..). 
	// Nhìn gợi ý biết được cần truyền vào trong hàm 1 argument như thế nào (By:    , string.... xem lại bài data type)
	@Test
	public void TC_01 {
		// java document (Cách sử dụng hàm này như thế nào)
		// Close khi >=2 tab sẽ chỉ đóng tab mà nó đang đứng
		driver.close();
		// quit đóng hết, đóng luôn trình duyệt
		driver.quit();
		// Có thể lưu nó thành biến nếu sử dụng nhiều lần
		driver.findElement(By.xpath(""));
		// Lưu biến: kiểu dữ liệu, tên biến, giá trị của biến
		WebElement emailTextbox = driver.findElement(By.xpath("//input[@id='email']"));
		
		// findElements là tìm nhiều element, sẽ trả về 1 list elements nên khai báo là "list<WebElement>"
		List<WebElement> checkboxs = FindElements(By.xpath(""));
		
		// Mở ra 1 url nào đó. Hàm này có thể trả về void: chỉ đi đến url hoặc get(string url) thì sẽ trả về string
		driver.get(projectPath);
		
		// Trả về url của page hiện tại
		Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com");
		
		// Trả về source code
		//Verify tương đối
		driver.getPageSource();
		Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn."));
		
		// trả về title của page hiện tại
		Assert.assertEquals(driver.getTitle(),"Facebook - Đăng nhập hoặc đăng ký");
		
		// Lấy ra được ID của windown/tab mà driver đang đứng (Active)
		String loginWindownId = driver.getWindowHandle();
		
		// lấy ra ID của tất cả windown,tab mà ko quan tâm đang đứng đâu
		// Dùng set khi cần lưu 1 tập các biến cùng kieru, giá trị các biến đôi một khác nhau
		Set<String> allIDs = driver.getWindowHandles();
		Options opt = driver.manage();
		//opt.
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		// Login Page title
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "Facebook – log in or sign up");
	}

	private List<WebElement> FindElements(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void TC_03_LoginFormDisplayed() {
		// Login form displayed
		Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}