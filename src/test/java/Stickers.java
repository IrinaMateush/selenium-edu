import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Stickers {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void stickersTest() {
        driver.navigate().to("http://localhost/litecart/en/");
        List<WebElement> ducks = driver.findElements(By.cssSelector(".product"));
        int ducksCounter = ducks.size();
        for (int x = 0; x < ducksCounter; x = x + 1) {
            WebElement duck = ducks.get(x);
            int counterStickers = duck.findElements(By.cssSelector(".sticker")).size();
            if ((counterStickers != 1 ) && (counterStickers != 0 )) throw new AssertionError();
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}