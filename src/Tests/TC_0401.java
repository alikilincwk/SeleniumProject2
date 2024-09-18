package Tests;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_0401 extends BaseDriver {

    @Test
    public void test1() {
        driver.get("https://demowebshop.tricentis.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='ico-login']")));
        WebElement login1 = driver.findElement(By.cssSelector("[class='ico-login']"));
        actions.click(login1).build().perform();


        WebElement eMail = driver.findElement(By.id("Email"));
        wait.until(ExpectedConditions.elementToBeClickable(eMail));
        actions.click(eMail).build().perform();
        actions.sendKeys("testerkurs202401@gmx.com").build().perform();


        WebElement password = driver.findElement(By.id("Password"));
        wait.until(ExpectedConditions.elementToBeClickable(password));
        actions.click(password).build().perform();
        actions.sendKeys("tester01").build().perform();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='button-1 login-button']")));
        WebElement login2 = driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        actions.moveToElement(login2).click().build().perform();

        Assert.assertTrue("Anasayfa Görüntülenemedi",driver.findElement(By.xpath("(//a[@href='/customer/info'])[1]")).isDisplayed());

        waitAndQuit();
    }
}