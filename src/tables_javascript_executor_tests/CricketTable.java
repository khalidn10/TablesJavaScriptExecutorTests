package tables_javascript_executor_tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CricketTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create Chrome driver 
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load Cricket Scorecard website
		//driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30469/kxip-vs-dc-38th-match-indian-premier-league-2020");
		//driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30474/kkr-vs-rcb-39th-match-indian-premier-league-2020");
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/30594/wa-vs-nsw-4th-match-sheffield-shield-2020-21");
		
		// Create List of WebElements consisting of each batsman's record 
		List<WebElement> inningsTable = driver.findElements(By.xpath("//div[@id='innings_1']/div[1]/div[@class='cb-col cb-col-100 cb-scrd-itms']"));
		
		// Create variable for batsman's name
		String batsman = "";
		
		// Create variable to store batsman's runs
		int runs = 0;
		
		// Create variable for total runs
		int totalRuns = 0;
		
		// For each batsman's record
		for (int i=0; i<inningsTable.size()-3; i++)
		{
			// Retrieve the batsman's name
			batsman = inningsTable.get(i).findElement(By.cssSelector("div:nth-child(1) a")).getText();
			
			// And batsman's runs 
			runs = Integer.parseInt(inningsTable.get(i).findElement(By.cssSelector("div:nth-child(3)")).getText());
			
			// And print them out
			System.out.print("Runs made by " + batsman);
			System.out.println(":\t" + runs);
			
			// Add batsman's runs to total
			totalRuns = totalRuns + runs;
		}
		
		// For next 2 records
		for (int i=inningsTable.size()-3; i<inningsTable.size()-1; i++)
		{
			// Retrieve the text from the batsman column
			batsman = inningsTable.get(i).findElement(By.cssSelector("div:nth-child(1)")).getText();
			
			// If value is "Extras"
			if (batsman.equalsIgnoreCase("extras"))
			{
				// Retrieve Extra runs
				runs = Integer.parseInt(inningsTable.get(i).findElement(By.cssSelector("div:nth-child(2)")).getText());
				
				// And print them out
				System.out.println("Extras:\t" + runs);
				
				// Add Extra runs to total
				totalRuns = totalRuns + runs;
			}
			// Otherwise if value is "Total"
			else if (batsman.equalsIgnoreCase("total"))
			{
				// Retrieve Total runs
				runs = Integer.parseInt(inningsTable.get(i).findElement(By.cssSelector("div:nth-child(2)")).getText());
				
				// If expected total runs is equal to actual total runs
				if (totalRuns == runs)
				{
					// Print out total runs
					System.out.println("Total runs are displayed as " + runs + " which is correct");
				}
				// Otherwise
				else
				{
					// Print that actual total runs are not as expected
					System.out.println("Total runs are displayed as " + runs + " instead of " + totalRuns + "!");
				}
			}
		}
	}

}
