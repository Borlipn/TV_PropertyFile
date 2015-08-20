package core;

//BEGIN
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
 

public class Selenium_properties {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String test_case_id = null;
		String url = null;
		String title_expected = null;

		Properties website_properties = new Properties();

		website_properties.load(new FileInputStream("./src/main/resources/property_file.txt"));

		test_case_id =website_properties.getProperty("test_case_id");
		url = website_properties.getProperty("url");
		title_expected = website_properties.getProperty("title_expected");

		WebDriver browser = new FirefoxDriver();
		
		browser.get(url);
		browser.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		String title_actual = browser.getTitle();
		 
		if (title_expected.equals(title_actual)) {
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "PASSED");
		} else {
			System.out.println("Test Case ID: \t\t" + test_case_id);
			System.out.println("URL: \t\t\t" + url);
			System.out.println("Title Expected: \t" + title_expected);
			System.out.println("Title Actual: \t\t" + title_actual);
			System.out.println("Test Case Result: \t" + "FAILED");
			}
		
		
		browser.quit();
	}
}

//END


