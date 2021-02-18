package tables_javascript_executor_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load website
		driver.get("https://www.ksrtc.in");
		
		// Enter "BENG" into "From" input field and press down arrow key twice
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("BENG");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.DOWN);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ENTER); // Not selecting by pressing Enter
		//System.out.println("Text in From field is: " + driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText());
		// Above code does not bring back text displayed in "From" input field so using JavaScript DOM command instead
		
		// Create driver to invoke JavaScript DOM command
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		// Assign JavaScript command to String variable
		String jSScript = "return document.getElementById(\"fromPlaceName\").value;";
		
		// Execute JavaScript DOM command and assign to String variable
		String text = (String) js.executeScript(jSScript);
		
		// Print out text in "From" input field
		System.out.println("Text returned by JavaScript DOM command: " + text);
		
	}

}
