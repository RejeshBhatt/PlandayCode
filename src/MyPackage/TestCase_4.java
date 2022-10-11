// Case no 3,4,5

package MyPackage;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase_4{

	public static void main(String[] args) {
		
				
		// Launch Chrome browser
		System.setProperty("webdriver.chrome.driver", "//Users//rajeshkumarbhatt//Downloads//chromedriver");
		WebDriver driver = new ChromeDriver();

		// maximize browser
		driver.manage().window().maximize();

		//Open URL
		driver.get("https://test1234.planday.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.id("cookie-consent-button")).click();

		// locate username by tagname

		driver.findElement(By.tagName("input")).sendKeys("plandayqa@outlook.com"); //valid username

		// locate password by name

		driver.findElement(By.name("Password")).sendKeys("APItesting21"); // valid password


		// locate login button

		driver.findElement(By.id("MainLoginButton")).click();


		driver.findElement(By.linkText("Schedule")).click();
		String actual_URL = driver.getCurrentUrl();
		String expected_URL = "https://test1234.planday.com/page/schedule";
		//Assert.assertEquals(actual_URL, expected_URL);
		
		if (actual_URL.equals(expected_URL))

		{
			System.out.println("URL Verified/Matched");

		}
		else
		{
			System.out.println("URL Verified/Not Matched");

		}


		driver.switchTo().frame(0);

		//Count and assert number of displayed employee is 3 

		int total_no_of_employee = driver.findElements(By.className("row-header3__text__title")).size()-1;
		int expected_no_of_employee = 3;
		int actual_no_of_employee = total_no_of_employee;

		if (expected_no_of_employee == actual_no_of_employee)

		{
			System.out.println("No of Employed is 3 Verified");

		}
		else
		{
			System.out.println("No of Employee is not 3");

		}
		driver.quit();

	}

}


