import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ClassTest13 {

    WebDriver driver = new ChromeDriver();
    @Test
    void AcmeRubberDucksTest(){
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[2]/a"));
        element.click();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store");
        //driver.quit();
    }
    @Test
    void AcmeDeliveryInfoTest() {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"footer\"]/table/tbody/tr/td[4]/nav/ul/li[2]/a"));
        element2.click();
        Assert.assertEquals(driver.getTitle(), "Delivery Information | My Store");
       // driver.quit();
    }

    @Test
    void AcmeSubCategTest()
    {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement icon = driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[2]/a"));
        Actions builder = new Actions(driver);
        builder.moveToElement(icon).perform();
        WebElement el = driver.findElement(By.className("category-2"));
        builder.moveToElement(el).perform();
        el.click();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store");
        //driver.quit();
    }

    @Test
    void AlertTest()
    {
        driver.get("https://the-internet.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[29]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertEquals(alertText, "I am a JS Alert");
        alert.accept();

    }
}
