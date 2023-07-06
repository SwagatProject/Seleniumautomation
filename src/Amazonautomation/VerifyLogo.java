package Amazonautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogo {

	public static void main(String[] args) {
		System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium\\Software\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		// Open Browser
		driver.get("https://www.amazon.in/");
		
		// Maximaize the Window
		
		driver.manage().window().maximize();
		
		WebElement logoest = driver.findElement(By.id("nav-logo-sprites"));
		if (logoest.isDisplayed()==true) {
			System.out.println("Test Case is Passed");
			
		}
		else {
			System.out.println("Test Case is Failed ");
		}
		


	}

}
