package one.neoBank.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class TestNeoBank {

    @Test
    public void TestNeoBank () throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "H:\\downloads\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://web.neobank.one/");

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnNext")));
        Thread.sleep(4000);

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("NEOBANK для бізнесу"));

        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("login")).sendKeys("954207300");

        driver.manage().window().maximize();

        driver.findElement(By.id("btnNext")).click();

        Thread.sleep(4000);

        String actualString = driver.findElement(By.className("auth-form-title")).getText();
        Assert.assertTrue(actualString.contains("Відкриття бізнес-рахунку можливе тільки через додаток NEOBANK для бізнесу"));


        driver.quit();
    }
}
