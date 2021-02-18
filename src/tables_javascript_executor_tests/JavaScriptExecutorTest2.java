package tables_javascript_executor_tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		// Create driver to invoke JavaScript DOM command
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		/*// Scroll down window, wait 3 seconds, and then scroll down table
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=5000");*/
		
		// Create string containing JS DOM command that first creates a variable containing the table
		// then scrolls the window down to the (top of) the table
		// then scrolls the table down to the bottom
		String jSScript = "var webTableFixedHeader = document.querySelector(\".tableFixHead\");" +
			     		  "webTableFixedHeader.scrollIntoView();" +
			     		  "webTableFixedHeader.scrollTop=120;";
		
		// Execute JavaScript DOM command
		js.executeScript(jSScript);
		
		// Create List of cell elements from fourth column of Web Table Fixed Header
		List<WebElement> amounts = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		// Create int variable for calculating sum of amounts present in fourth column of table
		int amountSum = 0;
		
		//  For each cell in fourth column of table
		for (WebElement amount : amounts)
		{
			// Add all the amounts
			amountSum = amountSum + Integer.parseInt(amount.getText());
		}
		
		// Print the total amount calculated
		System.out.println("Total amount calculated is: " + amountSum);
		
		// Retrieve the Total Amount Collected field
		String totalAmountCollectedField = driver.findElement(By.cssSelector(".totalAmount")).getText();
		
		// Extract the value of the Total Amount Collected field
		int totalAmountCollected = Integer.parseInt(totalAmountCollectedField.split(":")[1].trim());
		
		// Print the total amount collected
		System.out.println("Total amount collected is: " + totalAmountCollected);
		
		// Close the browser
		driver.close();
		
		// Add assertion to fail the test if Total Amount Collected is not equal to Total Amount Calculated
		Assert.assertTrue(amountSum == totalAmountCollected, "Total Amount Collected is correct");
	}

}
