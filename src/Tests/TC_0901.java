package Tests;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_0901 extends BaseDriver {

    @Test
    public void US09_TC01 (){

        long startTime = System.currentTimeMillis();

        driver.get("https://demowebshop.tricentis.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);


        WebElement loginLink =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']")));
        actions.click(loginLink).build().perform();


        WebElement email =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));
        WebElement pass =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Password']")));
        WebElement loginBtn =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 login-button']")));
        actions
                .sendKeys(email, "testerkurs202401@gmx.com")
                .sendKeys(pass, "tester01")
                .click(loginBtn)
                .build().perform();


        WebElement myAcc =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='account' and text()='testerkurs202401@gmx.com']")));
        actions.click(myAcc).build().perform();


        WebElement order =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='inactive' and text()='Orders']")));
        actions.click(order).build().perform();


        WebElement detail =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-2 order-details-button' and @value='Details']")));
        actions.click(detail).build().perform();


        WebElement invoice =
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button-2 pdf-order-button' and text()='PDF Invoice']")));
        actions.click(invoice).build().perform();

        waitAndQuit();


        long endTime = System.currentTimeMillis();
        double duration = (endTime - startTime)/1000.0;

        System.out.println("Test süresi: " + duration + " saniye");
        System.out.println("Test Basari ile tamamlandi");


    }
}
