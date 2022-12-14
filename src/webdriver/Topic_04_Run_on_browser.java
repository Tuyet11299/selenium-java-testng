package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_Run_on_browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/");
	}

	//@Test
	public void TC_01_Empty_Data() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		//driver.findElement(By.id("txtFirstname-error"));
		// các hàm verify 
		//Assert.assertTrue => kiểm tra một điều kiện trả về là đúng
		//Assert.assertFalse => kiểm tra một điều kiện trả về là sai
		//Assert.assertequals => kiểm tra thực tế và mong đợi là như nhau
		// vì data type: web elemnet và string là 2 kiểu khác nhau nên phải get text
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}

	//@Test
	public void TC_02_Invalid_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Jonh Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("Jonh Wick@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Jonh1Wick@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Aaaaaabbb1");
		driver.findElement(By.id("txtCPassword")).sendKeys("Aaaaaabbb1");
		driver.findElement(By.id("txtPhone")).sendKeys("0986232541");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-errorr")).getText(), "Email nhập lại không đúng");

	}

	//@Test
	public void TC_03_Incorrect_Email() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Jonh Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("Jonh1Wick@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Aaaaaabbb1");
		driver.findElement(By.id("txtCPassword")).sendKeys("Aaaaaabbb1");
		driver.findElement(By.id("txtPhone")).sendKeys("0986232541");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-errorr")).getText(), "Email nhập lại không đúng");
	}
	
	//@Test
	public void TC_04_Invalid_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Jonh Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Aaa");
		driver.findElement(By.id("txtCPassword")).sendKeys("Aaa");
		driver.findElement(By.id("txtPhone")).sendKeys("0986232541");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");

	}
	
	//@Test
	public void TC_05_Incorrect_Password() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		driver.findElement(By.id("txtFirstname")).sendKeys("Jonh Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Aaabbbbb");
		driver.findElement(By.id("txtCPassword")).sendKeys("Aaabbbbc");
		driver.findElement(By.id("txtPhone")).sendKeys("0986232541");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");	
		
	}
	
	@Test
	public void TC_06_Invalid_Phone() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		//Action 1
		driver.findElement(By.id("txtFirstname")).sendKeys("Jonh Wick");
		driver.findElement(By.id("txtEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtCEmail")).sendKeys("JonhWick@gmail.com");
		driver.findElement(By.id("txtPassword")).sendKeys("Aaabbb");
		driver.findElement(By.id("txtCPassword")).sendKeys("Aaabbb");
		driver.findElement(By.id("txtPhone")).sendKeys("1023432541");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
		//Action 2
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("098765432111");
		driver.findElement(By.xpath("//form[@id='frmLogin']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số. ");
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}