package browsertesting;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    public void selectMenu(String menu){
        WebElement selectMenu = driver.findElement(By.xpath(menu));
        selectMenu.click();
    }
    public void verifyPageNavigation(String title, String text) {
        String actualText = driver.findElement(By.xpath(title)).getText();
        Assert.assertEquals(actualText, text);
    }
    public void closeBrowser(){driver.quit();}
}
