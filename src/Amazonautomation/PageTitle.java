package Amazonautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageTitle {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium\\Software\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		// Open Browser
		driver.get("https://www.amazon.in/");
		
		// Maximazie Window
		driver.manage().window().maximize();
		
		// Get Web_Page Title
		
		String except_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String act_title=driver.getTitle();
		System.out.println(act_title);
		
		if (except_title.equals(act_title)==true) {
			System.out.println("Test Case is Passed");	
		}
		else {
			System.out.println("Test Case is Failed");
		}
		
		// Web_Page Length
		
		int pagelength = driver.getTitle().length();
		System.out.println("Length of the Title is"+pagelength);
		
		
		
		

	}



	}


