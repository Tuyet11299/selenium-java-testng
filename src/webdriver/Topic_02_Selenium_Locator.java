package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_Locator {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	driver.get("https://demo.nopcommerce.com/register");
	}
	// HTML của firtname textbox 
	// <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
	// thành phần của html:
	// tên thẻ (tagname): input 
	// tên thuộc tính (Atributename):type,ata-val, data-val-required, id, name
	// giá trị của thuộc tính (Atribute value): text, true, First name is required, FirstNam, FirstName
	//@Test
	public void TC_01_ID() {
		driver.findElement(By.id("FirstName")).sendKeys("Automation");
		// "Driver." tức là thao tác với trình duyêt
		// Muốn thao tác với element nào thì đầu tiên phải tìm đc element đó, dùng hàm findElement
		// Find theo cái gì: id, class, name, css.... (điền cái đó sau "By.")
		// Find thấy element rồi thì action lên element đó: click, sendKey (Gửi chuỗi vào element đấy )
		// Giá trị của "id" phải là duy nhất thì mới tìm thấy còn giá trị của class thì nhiều. 
		//cách kiểm tra xem có phải duy nhất ko: ctrl F" input id="firtname"". nếu thấy kết quả chỉ ra 1 thì ok
		
		
	}

	//@Test
	public void TC_02_ID1() {
		driver.findElement(By.id("LastName")).sendKeys("Testing");
	}

	//@Test
	public void TC_02_ID2() {
		driver.findElement(By.id("Email")).sendKeys("tuyetvt@tokyotechlab.com");
	}
	
	//@Test
	public void TC_03_name() {
		driver.get("https://www.google.com.vn/");
		driver.findElement(By.name("q")).sendKeys("hello");
		
	}

	//@Test
	public void TC_loginFacebookAccount_() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("AllThatGlitters100@yahoo.com");
		driver.findElement(By.id("pass")).sendKeys("");
		driver.findElement(By.name("login")).click();
		driver.quit();
	}

	@Test
	public void TC_04_TagName() {
		//"System.out" để hệ thống lấy ra output nào đó ".println" để in ra và xuống dòng, "getSize" để đếm
		driver.get("https://demo.nopcommerce.com/register");
		System.out.println(driver.findElement(By.tagName("input")).getSize());
	}

	//@Test
	public void TC_05_LinkText() {
		//click vào đường link addresses. Phải truyền vào đường link chính xác đầy đủ
		driver.get("https://demo.nopcommerce.com/register");
		driver.findElement(By.linkText("Addresses")).click();
		
	}
	//@Test
	public void TC_06_PartialLinkText() {
		//click vào đường link addresses. không phải truyefn vào đường link đầy đủ, chạy châm hơn linktext
		driver.findElement(By.partialLinkText("vendor account")).click();
		
	}
	@Test
	public void TC_07_Css() {
		//mở lại trang register
		//driver.get("https://demo.nopcommerce.com/register");
		// Cách viết số 1: 
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("selenium");
		// Cách viết số 2
		driver.findElement(By.cssSelector("input[id='LastName']")).sendKeys("locator");
		// Cách viết số 2
		driver.findElement(By.cssSelector("input[name='Email']")).sendKeys("tuyetvt@tokyotechlab.com");
		
	}

	//@Test
	public void TC_08_xpath() {
		//mở lại trang register
		driver.get("https://demo.nopcommerce.com/register");
		// Cách viết số 1: 
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("selenium");
		// Cách viết số 2
		driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("locator");
		// Cách viết số 2
		driver.findElement(By.xpath("//label[text()='Email:']/following-sibling::input")).sendKeys("tuyetvt@tokyotechlab.com");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}