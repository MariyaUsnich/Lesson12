import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClassTest {

    WebDriver driver = new ChromeDriver();
    @Test
    void TestPage(){
        driver.get("https://the-internet.herokuapp.com/");
        List<WebElement> elements = driver.findElements(By.tagName("li"));
        for (WebElement we : elements) {
            System.out.print(we.getText());
            System.out.println();
        }
       //elements.get(9).click(); //???

      driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
      Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/drag_and_drop");
      driver.quit();
        }
    }
