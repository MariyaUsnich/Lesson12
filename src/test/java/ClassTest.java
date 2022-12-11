import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class ClassTest {

    @Test
    public void TestPage(){
        System.setProperty("webdriver.chrome.driver","C:\\WebDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.tagName("li"));
        List<WebElement> elements = driver.findElements(By.tagName("li"));

        for (WebElement we : elements) {
            System.out.print(we.getText());
            System.out.println();
        }
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/drag_and_drop");
        driver.quit();
        }
    }
