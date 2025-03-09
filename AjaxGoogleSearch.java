package demo;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
public class AjaxGoogleSearch {
public static void main(String[] args)throws NoSuchElementException 
{
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dell\\git\\SeleniumJavaFramework1\\SeleniumJavaFramework\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.google.com");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	//enter techlistic tutorials in search box
	driver.findElement(By.name("q")).sendKeys("selenium tutorial techlistic");

	//wait for suggestions
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("btnK")));

	WebElement list=driver.findElement(By.tagName("li"));


	if (list != null) {
	    List<WebElement> rows = list.findElements(By.tagName("li"));
	    for (WebElement elem : rows) {
	        System.out.println(elem.getText());
	    }
	} else {
	    System.out.println("No suggestions found.");
	}
}
}
