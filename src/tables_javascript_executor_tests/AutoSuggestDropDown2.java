package tables_javascript_executor_tests;

//import java.util.Iterator;
import java.util.List;
//import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDropDown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load Makemytrip website
		driver.get("https://www.makemytrip.com/");
		
		// Seem to need these 2 lines to get to "From" input field - not sure why??
		driver.findElement(By.tagName("body")).click(); // This seems to take you to "To" field
		driver.findElement(By.tagName("input")).click(); // Then this to "From" field
		/*Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> windowIterator = windowHandles.iterator();
		driver.switchTo().window(windowIterator.next());
		driver.findElement(By.tagName("body")).click();*/
		
		// Search auto-suggest drop down list using "he"
		driver.findElement(By.cssSelector("[placeholder='From']")).sendKeys("h");
		// Need to pause for a second as otherwise input field doesn't produce correct auto-suggestions
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[placeholder='From']")).sendKeys("e");
		
		// Retrieve listed options in auto-suggest drop down list
		List<WebElement> options = driver.findElements(By.cssSelector(".react-autosuggest__suggestions-list li"));
		
		// For each option in list
		for (WebElement opt : options)
		{
			// Retrieve the corresponding airport 
			WebElement option = opt.findElement(By.cssSelector("p:nth-child(2)")); 
			
			// If airport contains the text "heathrow"
			if (option.getText().toLowerCase().contains("heathrow"))
			{
				// Click the option and break out of loop
				opt.click();
				break;
			}
		}
		
	}

}
