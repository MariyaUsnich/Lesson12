import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.tagName("li"));
        List<WebElement> elements = driver.findElements(By.tagName("li"));

        for (WebElement we : elements) {
            System.out.print(we.getText());
            System.out.println();
        }

        //WebElement e = elements.get(9); //По элементу не срабатывает
        //e.click();
        //elements.get(9).click();
        //driver.findElement((By) elements.get(9)).click();
        driver.quit();
    }
}