package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_0501 extends BaseDriver {
    @Test
    public void Test1() {
        //null email, null password.
        loginAttempt("","");
        //valid email, null password.
        loginAttempt("testerkurs202401@gmx.com","");
        //null email, valid password.
        loginAttempt("","tester01");
        //invalid email, invalid password.
        loginAttempt("gecersizemail@mail.com","gecersizsifre1133");
        waitAndQuit();
    }
    public void loginAttempt(String email, String password){
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(2);
        WebElement loginButton1 = driver.findElement(By.xpath("//a[text()='Log in']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(loginButton1)
                .click()
                .build()
                .perform();
        MyFunc.wait(1);
        WebElement emailInputArea = driver.findElement(By.xpath("//input[@id='Email']"));
        actions
                .moveToElement(emailInputArea)
                .click()
                .sendKeys(email)
                .build()
                .perform();
        MyFunc.wait(1);
        WebElement passwordInputArea = driver.findElement(By.xpath("//input[@id='Password']"));
        actions
                .moveToElement(passwordInputArea)
                .click()
                .sendKeys(password)
                .build()
                .perform();
        MyFunc.wait(1);
        WebElement loginButton2 = driver.findElement(By.xpath("//div[@class='buttons']//input[contains(@class,'login')]"));
        actions
                .moveToElement(loginButton2)
                .click()
                .build()
                .perform();
        MyFunc.wait(1);
        String errorText = driver.findElement(By.xpath("//div[@class='validation-summary-errors']")).getText();
        try {
            Assert.assertTrue("Hata mesajı görüntülenemedi.", errorText.toLowerCase().contains("login was unsuccessful"));
        } catch (NoSuchElementException e) {
            System.out.println("Hata mesajı görüntülenemedi.");
        }
        MyFunc.wait(2);
    }
}
