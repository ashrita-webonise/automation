
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import static org.junit.Assert.assertTrue;

/**
 * Created by webonise on 23/8/16.
 */
public class Testing {

    @Test
    public void basicChromeDriverOptions () throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/home/webonise/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebElement element;
        WebDriver driver2 = null;
        driver.get("https://www.tripadvisor.in/");
        assertTrue(driver.getTitle().contains("TripAdvisor"));

        driver.findElement(By.xpath("//*[@id='rdoFlights']")).click();
        driver.findElement(By.xpath("//*[@id='metaFlightTo']")).click();
        element=driver.findElement(By.xpath("//*[@id='metaFlightTo']"));
        element.sendKeys("Delhi");
        driver2.wait(2000);
        driver.findElement(By.id("autocompleter-choices flights")).sendKeys(Keys.RETURN);
        driver.findElement(By.id("SUBMIT_HOTEL")).click();

    }
}
