package Amazonautomation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class LoginAccount {

	public static void main(String[] args) throws Exception {
		System.setProperty("Webdriver.Chrome.driver", "D:\\Selenium\\Software\\Chrome Driver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();

		// Open Browser Using .get() method
		driver.get("https://www.amazon.in/");

		// Maximazie Window
		driver.manage().window().maximize();

		// Implicit Wait

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); 

		// Verify Title Of Web_Page using.getTitle() method

		String except_title="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String act_title=driver.getTitle();
		System.out.println(act_title);

		if (except_title.equals(act_title)==true) {
			System.out.println("Test Case is Passed");	
		}
		else {
			System.out.println("Test Case is Failed");
		}

		// Verify Title Length Of Web_Page using.getTitle().length() method

		int pagelength = driver.getTitle().length();
		System.out.println("Length of the Title is"+pagelength);
		
		// Verify The Logo is displayed or not using .idDisplayed()
		
		WebElement logoest = driver.findElement(By.id("nav-logo-sprites"));
		if (logoest.isDisplayed()==true) {
			System.out.println("Test Case is Passed");
			
		}
		else {
			System.out.println("Test Case is Failed ");
		}

		// Mouse Over on Hello, Sign in Account	& List using Action class 

		WebElement signmenu = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		WebElement signbtn = driver.findElement(By.xpath("//div[@id='nav-flyout-ya-signin']//span[@class='nav-action-inner'][normalize-space()='Sign in']"));
		Actions act=new Actions(driver);
		act.moveToElement(signmenu).moveToElement(signbtn).click().perform();

		// Enter Mobile No in Mobile text box

		driver.findElement(By.id("ap_email")).sendKeys("9337763392");

		// Click On Continue Button

		driver.findElement(By.xpath("//input[@id='continue']")).click();

		// Enter Password in Password box

		driver.findElement(By.id("ap_password")).sendKeys("Estacha@2017");

		// Click On Sign in Button using .click() method

		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

		// Searching Product In Search Bar using .sendKeys() method

		WebElement serchbar = driver.findElement(By.id("twotabsearchtextbox"));
		serchbar.sendKeys("iphone 14 pro max");

		// Click on Search Button using .Click() method

		WebElement searchbutton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		searchbutton.click();

		// Scrool Down Window using javascriptExecutor class

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,100)", "");
		
		Thread.sleep(5000);

		// Select Product For Add to Cart using .click() method
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();

		// Click On Add to Cart Button using Window Handeling Method

		Set<String> s =driver.getWindowHandles();
		ArrayList ar=new ArrayList(s);
		System.out.println(ar.get(0));
		System.out.println(ar.get(1));

		// Switch To Child Window

		driver.switchTo().window((String)ar.get(1)); 

		Thread.sleep(10000);

		// Click on Add To Cart Button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		// Close The Curent Window

		driver.close();

		// Swith to Parent Window

		driver.switchTo().window((String)ar.get(0));

		// Back To Home Menu Using Navigation Back() command
		driver.navigate().back();

		Thread.sleep(5000);

		// Click Cart button verify the product is available on in Shopping Cart Window

		driver.findElement(By.xpath("//span[normalize-space()='Cart']")).click();

		WebElement cart = driver.findElement(By.xpath("//span[@class='a-truncate-cut']"));
		System.out.println(cart.getText());

		// Back To Home Menu Using Navigation Back() command
		driver.navigate().back();

		// Find Total Number of Hyper Links In Web_Page using .size() Method

		List<WebElement> totalhprlinks = driver.findElements(By.tagName("a"));
		int count=totalhprlinks.size();
		System.out.println("The number of links on Webpage: "+count);


		// Selecet "All Categories" from  all Drop_Down

		WebElement selecttext = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select selectdroptext=new Select(selecttext);

		// Using Get Options() metho to get all option from dropdown

		List<WebElement> alloptions = selectdroptext.getOptions();

		for(WebElement option:alloptions)
		{
			System.out.println(option.getText());
			if (option.getText().equals("Books")) {
				option.click();
				break;
			}
		}

		Thread.sleep(10000);

		// Refresh Your Page Using Using .Refresh() command.

		driver.navigate().refresh();

		// Mouse Over on EN menu.

		WebElement englng = driver.findElement(By.xpath("//span[@class='icp-nav-link-inner']"));
		act.moveToElement(englng).perform();

		// Select English Language using isSelect()

		WebElement englishradbtn = driver.findElement(By.xpath("//div[@id='nav-flyout-icp']//i[contains(@class,'icp-radio icp-radio-active')]"));
		boolean selectvalue = englishradbtn.isSelected();
		if (selectvalue==false) {
			englishradbtn.click();
			
		}
		
		// Quit The Browse using .quit() method.
		
		driver.quit();
		
			
		

		
	

	}

}
