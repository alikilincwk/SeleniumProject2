package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TC_0201 extends BaseDriver {
    @Test
    public void test1() {
        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(2);

        WebElement register = driver.findElement(By.xpath("(//div [@class='header-links']//a)[1]"));
        actions.click(register).build().perform();
        MyFunc.wait(2);

        WebElement Mail1 = driver.findElement(By.xpath("(//div [@class='inputs']/input)[3]"));
        actions.click(Mail1).build().perform();
        actions.sendKeys("testerkurs202401@gmx.com").build().perform();
        MyFunc.wait(2);

        WebElement RegisterButton1=driver.findElement(By.id("register-button"));
        actions.click(RegisterButton1).build().perform();
        MyFunc.wait(2);

        WebElement male = driver.findElement(By.xpath("(//div [@class='gender']/input)[1]"));
        actions.click(male).build().perform();
        MyFunc.wait(2);

        WebElement FirstName = driver.findElement(By.xpath("(//div [@class='inputs']/input)[1]"));
        actions.click(FirstName).build().perform();
        actions.sendKeys("Techno").build().perform();
        MyFunc.wait(2);

        WebElement Surname = driver.findElement(By.xpath("(//div [@class='inputs']/input)[2]"));
        actions.click(Surname).build().perform();
        actions.sendKeys("Study").build().perform();
        MyFunc.wait(2);

        WebElement Password = driver.findElement(By.xpath("(//div [@class='inputs']/input)[4]"));
        actions.click(Password).build().perform();
        actions.sendKeys("tester01").build().perform();
        MyFunc.wait(2);

        WebElement PasswordAgain = driver.findElement(By.xpath("(//div [@class='inputs']/input)[5]"));
        actions.click(PasswordAgain).build().perform();
        actions.sendKeys("tester01").build().perform();
        MyFunc.wait(2);

        WebElement RegisterButton=driver.findElement(By.id("register-button"));
        actions.click(RegisterButton).build().perform();
        MyFunc.wait(2);

        WebElement ReFirstName = driver.findElement(By.xpath("(//div [@class='inputs']/input)[1]"));
        ReFirstName.clear();
        ReFirstName.sendKeys("Ali");
        MyFunc.wait(2);

        WebElement ReSurname = driver.findElement(By.xpath("(//div [@class='inputs']/input)[2]"));
        ReSurname.clear();
        ReSurname.sendKeys("Demir");
        MyFunc.wait(2);

        WebElement RegisterButton2=driver.findElement(By.id("register-button"));
        actions.click(RegisterButton2).build().perform();
        MyFunc.wait(2);

        waitAndQuit();

    }
}
