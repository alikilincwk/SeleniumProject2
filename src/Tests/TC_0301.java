package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TC_0301 extends BaseDriver {


    @Test
    public void test1(){
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);
        WebElement login1=driver.findElement(By.cssSelector("[class=\"ico-login\"]"));
        actions.click(login1).build().perform();
        MyFunc.wait(1);

        WebElement eMail=driver.findElement(By.id("Email"));
        actions.click(eMail).build().perform();
        MyFunc.wait(1);
        actions.sendKeys("testerkurs202401@gmx.com").build().perform();
        MyFunc.wait(1);

        WebElement sifre=driver.findElement(By.id("Password"));
        actions.click(sifre).build().perform();
        MyFunc.wait(1);
        actions.sendKeys("tester01").build().perform();
        MyFunc.wait(1);

        WebElement login2=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        actions.moveToElement(login2).click().build().perform();
        MyFunc.wait(3);

        WebElement userName=driver.findElement(By.xpath("//a[text()=\"testerkurs202401@gmx.com\"]"));
        Assert.assertTrue("Kullanıcı adı görüntülenemedi.",userName.isDisplayed());
        actions.moveToElement(userName).build().perform();
        MyFunc.wait(2);

        WebElement logOut=driver.findElement(By.xpath("//a[text()=\"Log out\"]"));
        actions.moveToElement(logOut).click().build().perform();
        MyFunc.wait(3);

        WebElement logOutControl=driver.findElement(By.xpath("//a[text()=\"Register\"]"));
        Assert.assertTrue("LogOut Başarısız",logOutControl.getText().contains("Register"));
        MyFunc.wait(4);

        waitAndQuit();


    }

}
