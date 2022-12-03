package webdriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Topic_02_Data_Type {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// có 2 kiểu dữ liệu nguyên thủy và tham chiếu
		// Kiểu nguyên thủy (primitive):
			// Số nguyên: byte (1 byte = 8 bit, có giá trị từ -128 đến 127, khi lưu số 1 thì sẽ chiếm 1 byte, lưu 127 cũng chiếm 1 byte bộ nhớ, 1 bit là 1 kí tự 0 hoặc 1), short (2 byte), int (4 byte), long (8 byte) (ko có phần thập phân: 10, 14, )
			byte bNumber=127;
			
			short sNumber= 32000;
			
			int iNumber= 420000000;
			
			long lNumber= 82394 ;
			
			// Số thực: Float, double (có phần thập phân: 12.12, 10.34, ), khi khai báo có kí hiệu d,f sau giá trị 
			float studentPoint = 9.5f;
			double employeesalary = 35.6d ;
			// Logic: boolean (giá trị chỉ có true hoặc false)
			boolean status= true; //nam
			status = false; //nữ
			// Kí tự: Char (ít dùng)
			char a= 'A'; 
		// Kiểu dữ liệu tham chiếu (Reference)
				// Class, ctrl + shift + o để tự import
			FirefoxDriver driver = new FirefoxDriver();
				// interface, ctrl + shift + o để tự import
			WebElement firtNameTextbox;
				// string 
			String firstName = "Automation Testing "; // string cũng là 1 lớp
				// object 
			Object people;
				// array 
			String[] studentName = {"nguễn văn a","lê văn b","hà văn c"};
				// collection: list/set/queue 
			List<WebElement> checkboxs = driver.findElements(By.cssSelector(""));
				// map
			Map<String, Integer > student = new HashMap<>();
			// sự khác nhau giữa nguyên thủy và tham chiếu
			// Nguyên thủy (primitive): 
				// int a = 5; , tạo 1 vùng nhớ M1 có giá trị bằng 5
				// int b = a; , tạo vùng nhớ M2 có giá trị bằng M1 = 5
				// int a = 7; , thay đổi giá trị tại vùng nhớ M1, còn M2 ko bị ảnh hưởng. 
				// lúc này a= 7, b vẫn = 5. 
			// Tham chiếu (reference):
				// class student1 = "NVA";
				// class student2 = student1;
				// class student1 = "LVB" 
				// Lúc này student1= "LVB", student2= "LVB". giá trị của student2 tham chiếu tới giá trị của student1, khi student1 thay đổi thì student2 cũng thay đổi theo
				// Hiểu là: 2 biến cùng khác tên nhưng bản chất cùng là 1 biến, 1 biến thay đổi giá thị thì biến còn lại cũng thay đổi (tham chiếu cả 2 chiều)

	}
}
