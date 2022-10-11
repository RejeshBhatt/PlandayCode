// Case No. 1,2

package MyPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestCase_1N2 {

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

		driver.findElement(By.tagName("input")).sendKeys("rajesh@xyz.com"); //invalid username


		// locate password by name
		driver.findElement(By.name("Password")).sendKeys("123456"); // invalid password


		// locate login button by id

		driver.findElement(By.id("MainLoginButton")).click();



		// To verify that the login form is present
		WebElement LoginForm = driver.findElement(By.xpath("//form[@id='login']"));
		
		//Assert.assertTrue(LoginForm.isDisplayed());
		
		if (LoginForm.isDisplayed())

		{
			System.out.println("Login form is present verified");

		}
		else
		{
			System.out.println("Login form in not present verified");

		}
		

		//To verify Username is displayed
		WebElement user = driver.findElement(By.id("Username"));
		//Assert.assertTrue(user.isDisplayed());

		if (user.isDisplayed())

		{
			System.out.println("Username is displayed verified");

		}
		else
		{
			System.out.println("Username not displayed verified");

		}

		//To verify Password is displayed
		WebElement pass = driver.findElement(By.id("Password"));
		//Assert.assertTrue(pass.isDisplayed());

		if (pass.isDisplayed())
		{
			System.out.println("Password is displayed verified");

		}
		else
		{
			System.out.println("Password not displayed verified");

		}

		//To verify Login Button is displayed
		WebElement login = driver.findElement(By.id("MainLoginButton"));
		//Assert.assertTrue(login.isDisplayed());


		if (login.isDisplayed())
		{
			System.out.println("Login button is displayed verified");

		}
		else
		{
			System.out.println("Login button not displayed");

		}

		//To verify error message
		String username_actual_error_msg = driver.findElement(By.id("Username-validation-error")).getText(); 
		String password_actual_error_msg = driver.findElement(By.id("Password-validation-error")).getText(); 
		
		String expected_error_msg = "The username or password is incorrect.";
		//Assert.assertEquals(actual_error, expected_error);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		if (username_actual_error_msg.equals(expected_error_msg) || password_actual_error_msg.equals(expected_error_msg))
		{
			System.out.println("Error message are present verified");

		}
		else
		{
			System.out.println("Error message are not present verified");

		}
		
		driver.quit();
	}

}