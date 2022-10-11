//Case No. 6,7,8

package MyPackage;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TestCase_6 {

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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(By.linkText("Schedule")).click();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.switchTo().frame(0);
		
		WebElement element = driver.findElement(By.xpath("//div[@aria-label='10 October 2022 Employee One']"));
		Actions act = new Actions(driver);
		act.click(element).perform(); 

		driver.findElement(By.xpath("//input[@id='shiftStartEnd_start']")).sendKeys("9:00");
		driver.findElement(By.xpath("//input[@id='shiftStartEnd_end']")).sendKeys("17:00");
		
		driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
		
		
		//To verify created shift for employee one is visible
		//WebElement shift = driver.findElement(By.xpath("//div[@class='shift-tile__inner']"));
		//Assert.assertTrue(shift.isDisplayed());
	
		boolean shift = driver.findElement(By.xpath("//div[@class='shift-tile__inner']")).isDisplayed();
		
		if (shift==true)
		{
		System.out.println("Shift is Visible verified");

		}
		else
		{
		System.out.println("Shift is not Visible verified");

		}
		
	}
}



