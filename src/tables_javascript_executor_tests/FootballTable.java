package tables_javascript_executor_tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FootballTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Khalid\\Documents\\Documents\\Courses\\Selenium\\Apps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// Load a Football Table from the BBC Football Website
		driver.get("https://www.bbc.co.uk/sport/football/tables");
		//driver.get("https://www.bbc.co.uk/sport/football/scottish-premiership/table");
		//driver.get("https://www.bbc.co.uk/sport/football/scottish-league-two/table");
		//driver.get("https://www.bbc.co.uk/sport/football/highland-league/table");
		
		// Create a List of WebElements containing records for all teams in the table
		List<WebElement> teamsInTable = driver.findElements(By.cssSelector("tbody.gel-long-primer tr"));
		
		// For each team
		for (int i=0; i<teamsInTable.size(); i++)
		{
			// Create a List of WebElements containing the record for the team
			List<WebElement> teams = teamsInTable.get(i).findElements(By.tagName("td"));
			
			// Retrieve and store the team name and number of wins, draws, losses and points
			//String teamName = teams.get(2).findElement(By.cssSelector("a.gs-o-table__link abbr")).getAttribute("title");
			String teamName = teams.get(2).findElement(By.tagName("abbr")).getAttribute("title");
			int noOfWins = Integer.parseInt(teams.get(4).getText());
			int noOfDraws = Integer.parseInt(teams.get(5).getText());
			int noOfLosses = Integer.parseInt(teams.get(6).getText());
			int noOfPoints = Integer.parseInt(teams.get(10).getText());
			
			// Calculate expected number of points based on match results
			int calculatedPoints = noOfWins*3 + noOfDraws;
			
			// If number of points is as expected
			if (calculatedPoints == noOfPoints)
			{
				// Print out the team details
				System.out.print(teamName + " has " + noOfWins + " win(s), " + noOfDraws + " draw(s) and " + noOfLosses + " loss(es). ");
				System.out.println("They have " + noOfPoints + " point(s) which is correct.");
			}
			// Otherwise
			else
			{
				// Print out mis-match between expected and actual points
				System.out.println(teamName + " has " + noOfPoints + " point(s) but should have " + calculatedPoints + " point(s)!");
			}
		}
	}

}
