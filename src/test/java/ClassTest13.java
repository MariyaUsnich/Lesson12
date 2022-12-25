import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class ClassTest13 {

    WebDriver driver = new ChromeDriver();
    @Test
    void AcmeRubberDucksTest(){

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

    void AcmeSubCateg()
    {
        driver.get("https://litecart.stqa.ru/en/");
        WebElement icon = driver.findElement(By.xpath("//*[@id=\"site-menu\"]/ul/li[2]/a"));
        Actions builder = new Actions(driver);
        builder.moveToElement(icon).perform();
        WebElement el = driver.findElement(By.className("category-2"));
        builder.moveToElement(el).perform();
        el.click();

    }

    @Test
    void AcmeSubCategTest()
    {
        AcmeSubCateg();
        Assert.assertEquals(driver.getTitle(), "Subcategory | My Store");
        //driver.quit();
    }

    @Test
    void NameOrderTest() {
        AcmeSubCateg();
        driver.findElement(By.xpath("//*[@id=\"box-category\"]/nav/a[1]")).click();
        List<WebElement> elements = driver.findElements(By.className("name"));
        List<WebElement> example = new ArrayList<>(2);
        WebElement yellowDuck = driver.findElement(By.xpath("//div[@class='name'][text()='Yellow Duck']"));
        WebElement greenDuck = driver.findElement(By.xpath("//div[@class='name'][text()='Green Duck']"));
                example.add(greenDuck);
                example.add(yellowDuck);
        Assert.assertEquals(elements, example);
        //driver.quit();
        }

        @Test
        void PriceOrderTest()
        {
            AcmeSubCateg();
            driver.findElement(By.xpath("//*[@id=\"box-category\"]/nav/span")).click();
            List<WebElement> elements = driver.findElements(By.className("name"));
            List<WebElement> example = new ArrayList<>(2);
            WebElement yellowDuck = driver.findElement(By.xpath("//div[@class='name'][text()='Yellow Duck']"));
            WebElement greenDuck = driver.findElement(By.xpath("//div[@class='name'][text()='Green Duck']"));
            example.add(yellowDuck);
            example.add(greenDuck);
            Assert.assertEquals(elements, example);
            //driver.quit();
        }
    @Test
    void SaleLabelTest()
    {
        AcmeSubCateg();
        WebElement yellowDuck = driver.findElement(By.xpath("//a[@class='link'][@title='Yellow Duck']"));
        WebElement ydlabel = yellowDuck.findElement(By.cssSelector("div.sticker.sale"));
        Assert.assertEquals(ydlabel.getText(), "SALE");
        //driver.quit();
    }

    @Test
    void NewLabelTest()
    {
            AcmeSubCateg();
            WebElement greenDuck = driver.findElement(By.xpath("//a[@class='link'][@title='Green Duck']"));
            WebElement gdlabel = greenDuck.findElement(By.cssSelector("div.sticker.new"));
            Assert.assertEquals(gdlabel.getText(), "NEW");
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

    @Test
    void FrameTest()
    {
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.xpath("//a[text()='iFrame']")).click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement iFrameText = driver.findElement(By.tagName("p"));
        softAssert.assertEquals(iFrameText.getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
        driver.navigate().back();
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        String middleFrameText = driver.findElement(By.tagName("body")).getText();
        softAssert.assertEquals(middleFrameText, "MIDDLE");
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-left");
        String leftFrameText = driver.findElement(By.tagName("body")).getText();
        softAssert.assertEquals(leftFrameText, "LEFT");
        driver.switchTo().defaultContent();
        softAssert.assertAll();
        driver.quit();

    }

    @Test
    void TabTest()
    {
        driver.get("https://the-internet.herokuapp.com/windows");
        String initialTab = driver.getWindowHandle();
        driver.findElement(By.xpath("//div[@class='example']/a")).click();
        String newTab = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newTab);
        WebElement tabtext = driver.findElement(By.tagName("h3"));
        Assert.assertEquals(tabtext.getText(), "New Window");
        driver.close();
        driver.switchTo().window(initialTab);
        driver.quit();

    }
    private SearchContext getShadowRoot(WebElement root) {
        return (SearchContext) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", root);
    }
    @Test
    void ShadowTest() throws InterruptedException {
        driver.get("https://canvas.apps.chrome/");

        WebElement drawingApp = driver.findElement(By.id("drawing-app"));
        SearchContext drawingAppSR = getShadowRoot(drawingApp);

        WebElement welcomeDialog = drawingAppSR.findElement(By.cssSelector("welcome-dialog"));
        SearchContext welcomeDialogSR = getShadowRoot(welcomeDialog);

        WebElement getStartedButton = welcomeDialogSR.findElement(By.cssSelector("ea-button#get-started"));
        Thread.sleep(1000);
        getStartedButton.click();

        //driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //driver.close();

    }
}
