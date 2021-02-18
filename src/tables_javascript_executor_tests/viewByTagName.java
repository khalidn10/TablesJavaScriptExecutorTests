package tables_javascript_executor_tests;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class viewByTagName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load Makemytrip website
		driver.get("https://www.makemytrip.com/");
		
		// Seem to need these 2 lines to get to "From" input field - not sure why??
		//driver.findElement(By.tagName("body")).click(); // This seems to take you to "To" field
		//driver.findElement(By.tagName("input")).click(); // Then this to "From" field
		
		//System.out.println("No. of 'frame' tags: " + driver.findElements(By.tagName("frame")).size());
		//System.out.println("No. of 'frameset' tags: " + driver.findElements(By.tagName("frameset")).size());
		//System.out.println("No. of 'iframe' tags: " + driver.findElements(By.tagName("iframe")).size());
		
		System.out.println("Window handle:			" + driver.getWindowHandle());
		System.out.println("No. of window handles:	" + driver.getWindowHandles().size());
		System.out.println("Tag name: 				" + driver.switchTo().activeElement().getTagName());
		System.out.println("Is displayed?:			" + driver.switchTo().activeElement().isDisplayed());
		System.out.println("Is enabled?:			" + driver.switchTo().activeElement().isEnabled());
		//driver.findElement(By.tagName("body")).click();
		System.out.println("Is selected?:			" + driver.switchTo().activeElement().isSelected());
		System.out.println("Window handle:			" + driver.getWindowHandle());
		System.out.println("No. of window handles:	" + driver.getWindowHandles().size());
		System.out.println("Tag name: 				" + driver.switchTo().activeElement().getTagName());
	}

}
