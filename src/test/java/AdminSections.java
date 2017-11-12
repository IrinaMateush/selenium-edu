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


public class AdminSections {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }
    @Test
    public void adminSectionsTest() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        List<WebElement> elementsMenu = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
        int menuCounter = elementsMenu.size();
        for (int x = 0; x < menuCounter; x = x + 1) {
            elementsMenu = driver.findElements(By.xpath("//ul[@id='box-apps-menu']//li[@id='app-']"));
            WebElement elementMenu = elementsMenu.get(x);
            elementMenu.click();
            driver.findElements(By.cssSelector("td#content>h1"));

            List<WebElement> elementsSubmenu = driver.findElements(By.xpath("//ul[contains(@class, 'docs')]//li"));
            int subMenuCounter = elementsSubmenu.size();
            for (int y = 0; y < subMenuCounter; y = y + 1) {
                elementsSubmenu = driver.findElements(By.xpath("//ul[contains(@class, 'docs')]//li"));
                WebElement elementSubmenu = elementsSubmenu.get(y);
                elementSubmenu.click();
                driver.findElements(By.cssSelector("td#content>h1"));
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}