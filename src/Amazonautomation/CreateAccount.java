package Amazonautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateAccount {

	public static void main(String[] args) {
		System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium\\Software\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		// Open Browser
		driver.get("https://www.amazon.in/");
		
		// Maximazie Window
		driver.manage().window().maximize();
		
		// Mouse Over on Hello, Sign in Account	& List
		
		WebElement signmenu = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement signbtn = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']"));
		Actions act=new Actions(driver);
		act.moveToElement(signmenu).moveToElement(signbtn).click().perform();
		
		// Display,Enabled and Click on Create Your Amazon Account Button
		WebElement crtbutton = driver.findElement(By.xpath("//a[@id='createAccountSubmit']"));
		if (crtbutton.isDisplayed()&&crtbutton.isEnabled()) {
			
			crtbutton.click();
		}
		
		// Name Pass the Name Text_Box
		WebElement nametxtbox = driver.findElement(By.id("ap_customer_name"));
		if (nametxtbox.isEnabled()) {
			nametxtbox.sendKeys("Swagat Ranjan Mohanty");
			
		}
		
		// Mobile no pass the Mobile no text box
		WebElement mbltextbox = driver.findElement(By.id("ap_phone_number"));
		if (mbltextbox.isEnabled()) {
			mbltextbox.sendKeys("9337763392");
		}
		
		// Email Pass the Email_Text Box
		
		driver.findElement(By.id("ap_email")).sendKeys("swagat96mohanty@gmail.com");
		
		// Give Password in Password text box
		
		driver.findElement(By.id("ap_password")).sendKeys("Estacha@2017");
		
		// Verify The text Password must be at least 6 characters
		
		 String actual_msg = driver.findElement(By.xpath("//div[@class='a-box a-alert-inline a-alert-inline-info auth-inlined-information-message a-spacing-top-mini']//div[@class='a-alert-content'][normalize-space()='Passwords must be at least 6 characters.']")).getText();
		 System.out.println(actual_msg);
		 String except_msg="Passwords must be at least 6 characters.";
		 if (actual_msg.equals(except_msg)==true) {
			System.out.println("Test Case Is Passed");
		}
		 else {
			System.out.println("Test Case Is Failed");
		}


		// Click On Continue Button
		 
		 driver.findElement(By.xpath("//input[@id='continue']")).click();
		 
	
	}

}
