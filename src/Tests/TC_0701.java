package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TC_0701 extends BaseDriver {
    @Test
    public void TC_0701() {
        //random register required for voting every time

        String randomMail = "tsetxxx" + ((int) (Math.random() * 10000)) + "@test.com";
        System.out.println(randomMail);
        String password = "testtest123";
        System.out.println(password);

        driver.get("https://demowebshop.tricentis.com/");
        WebElement anket = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
        anket.click();
        MyFunc.wait(2);

        WebElement vote = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
        vote.click();
        MyFunc.wait(2);

        WebElement errorText3 = driver.findElement(By.xpath("//*[text()='Only registered users can vote.']"));
        Assert.assertTrue(errorText3.getText().contains("Only registered users can vote."));


        WebElement registerButton1 = driver.findElement(By.xpath("//a[text()='Register']"));
        Actions actions = new Actions(driver);
        MyFunc.wait(1);
        actions
                .moveToElement(registerButton1)
                .click()
                .build()
                .perform();
        WebElement genderSelection = driver.findElement(By.xpath("//input[@id='gender-male']"));
        MyFunc.wait(1);
        actions
                .moveToElement(genderSelection)
                .click()
                .build()
                .perform();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
        MyFunc.wait(1);
        actions
                .moveToElement(firstName)
                .click()
                .sendKeys("Tester")
                .build()
                .perform();
        WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
        MyFunc.wait(1);
        actions
                .moveToElement(lastName)
                .click()
                .sendKeys("Kurs")
                .build()
                .perform();
        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        MyFunc.wait(1);
        actions
                .moveToElement(email)
                .click()
                .sendKeys(randomMail)
                .build()
                .perform();

        WebElement password1 = driver.findElement(By.xpath("//input[@id='Password']"));
        MyFunc.wait(1);
        actions
                .moveToElement(password1)
                .click()
                .sendKeys(password)
                .build()
                .perform();
        WebElement password2 = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        MyFunc.wait(1);
        actions
                .moveToElement(password2)
                .click()
                .sendKeys(password)
                .build()
                .perform();
        WebElement registerButton2 = driver.findElement(By.xpath("//input[@id='register-button']"));
        MyFunc.wait(1);
        actions
                .moveToElement(registerButton2)
                .click()
                .build()
                .perform();
        WebElement cont = driver.findElement(By.xpath("//div[@class='buttons']//input[@value='Continue']"));
        MyFunc.wait(1);
        actions
                .moveToElement(cont)
                .click()
                .build()
                .perform();

        // random register end

        MyFunc.wait(2);
        try {
            anket = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
            anket.click();
            MyFunc.wait(2);

            vote = driver.findElement(By.xpath("//input[@id='vote-poll-1']"));
            vote.click();
            MyFunc.wait(2);
        } catch (Exception e) {
            System.out.println("Önceden oylama yapılmış");
        }

        String errorText = driver.findElement(By.xpath("//span[@class='poll-total-votes']")).getText();
        Assert.assertTrue("Sonuc görüntülenemedi.", errorText.toLowerCase().contains("vote"));

        waitAndQuit();
    }
}