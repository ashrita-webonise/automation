
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import java.util.Random;

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
        driver.get("https://www.tripadvisor.in/");
        assertTrue(driver.getTitle().contains("TripAdvisor"));

        //enter destination
        driver.findElement(By.xpath("//*[@id='rdoFlights']")).click();
        driver.findElement(By.xpath("//*[@id='metaFlightTo']")).click();
        element=driver.findElement(By.xpath("//*[@id='metaFlightTo']"));
        element.sendKeys("New Delhi");
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);

        //leave date
        driver.findElement(By.xpath("//*[@id='checkIn']")).click();
        driver.findElement(By.xpath("//*[@id='overlayInnerDiv']/div/div[2]/table/tbody/tr[3]/td[4]/a")).click();

        //arrival date
        driver.findElement(By.xpath("//*[@id='metaCheckOutSpan']/div")).click();
        driver.findElement(By.xpath("//*[@id='overlayInnerDiv']/div/div[2]/table/tbody/tr[4]/td[6]/a")).click();

        //Travellers

        Random num = new Random();
        int n=num.nextInt(5);

        Select traveller=new Select(driver.findElement(By.xpath("//*[@id='fadults']")));
        traveller.selectByIndex(n);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id='SUBMIT_FLIGHTS']")).click();
        WebDriverWait waitTab = new WebDriverWait(driver,50);

        waitTab.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui_close_x")));

        driver.findElement(By.className("ui_close_x")).click();
        //driver.findElement(By.xpath("//*[@id='taplc_flights_search_results_search_records_0']")).click();



        //waitTab.until(ExpectedConditions.elementToBeClickable());

        //*[@id="taplc_flight_results_sorts_0"]/div[1]/span[2]/span[4]/label

        //driver.findElement(By.className("price")).click();

    }
}