package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC_0801 extends BaseDriver {

    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");
        MyFunc.wait(1);
        WebElement login1=driver.findElement(By.cssSelector("[class='ico-login']"));
        actions.click(login1).build().perform();
        MyFunc.wait(1);

        WebElement eMail=driver.findElement(By.id("Email"));
        actions.click(eMail).build().perform();
        MyFunc.wait(1);
        actions.sendKeys("testerkurs202401@gmx.com").build().perform();
        MyFunc.wait(1);

        WebElement password=driver.findElement(By.id("Password"));
        actions.click(password).build().perform();
        MyFunc.wait(1);
        actions.sendKeys("tester01").build().perform();
        MyFunc.wait(1);

        WebElement login2=driver.findElement(By.cssSelector("[class='button-1 login-button']"));
        actions.moveToElement(login2).click().build().perform();
        MyFunc.wait(2);

        WebElement computers= driver.findElement(By.xpath("(//a[@href='/computers'])[1]"));
        actions.moveToElement(computers).build().perform();
        MyFunc.wait(3);

        WebElement notebook= driver.findElement(By.xpath("(//a[@href='/notebooks'])[1]"));
        actions.moveToElement(notebook).click().build().perform();
        MyFunc.wait(3);


        WebElement laptopphoto= driver.findElement(By.className("product-title"));
        actions.scrollByAmount(0,200).build().perform();
        MyFunc.wait(3);
        actions.moveToElement(laptopphoto).click().build().perform();
        MyFunc.wait(3);


        WebElement addtocard= driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']"));
        actions.click(addtocard).build().perform();
        MyFunc.wait(2);

        WebElement addcartbildirimi=driver.findElement(By.className("content"));
        Assert.assertTrue("Doğrulama mesajı görüntülenemedi",addcartbildirimi.isDisplayed());

        WebElement shoppingcart= driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        actions.click(shoppingcart).build().perform();
        MyFunc.wait(3);

        WebElement applydiscount= driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        actions.click(applydiscount).build().perform();
        actions.scrollByAmount(0,200).build().perform();
        MyFunc.wait(2);
        Assert.assertTrue("Apply Coupon mesajı görüntülenemedi",driver.findElement(By.className("message")).isDisplayed());

        WebElement addgiftcard= driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        actions.click(addgiftcard).build().perform();
        actions.scrollByAmount(0,200).build().perform();
        MyFunc.wait(2);
        Assert.assertTrue("Add Gift Card mesajı görüntülenemedi",driver.findElement(By.xpath("((//div[@class='coupon-code'])[2]//following::div)[1]")).isDisplayed());

        WebElement country1= driver.findElement(By.xpath("//select[@id='CountryId']"));
        actions.moveToElement(country1).click().build().perform();
        MyFunc.wait(2);
        Select allcountry1=new Select(country1);
        allcountry1.selectByVisibleText("Canada");

        WebElement state1= driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
        Select allstate1=new Select(state1);
        actions.click(state1).build().perform();
        MyFunc.wait(2);
        allstate1.selectByVisibleText("Nunavut");

        WebElement checkpoint= driver.findElement(By.xpath("//input[@id='termsofservice']"));
        actions.click(checkpoint).build().perform();
        MyFunc.wait(2);

        WebElement checkout= driver.findElement(By.xpath("//button[@id='checkout']"));
        actions.click(checkout).build().perform();
        MyFunc.wait(3);

        WebElement selectadres= driver.findElement(By.xpath("//select[@id='billing-address-select']"));
        actions.click(selectadres).build().perform();
        Select alladdres=new Select(selectadres);
        alladdres.selectByVisibleText("New Address");
        MyFunc.wait(3);

        WebElement company= driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
        actions.click(company).build().perform();
        company.sendKeys("techno");

        WebElement country2= driver.findElement(By.cssSelector("[id='BillingNewAddress_CountryId']"));
        actions.moveToElement(country2).click().build().perform();
        MyFunc.wait(2);
        Select allcoutry2=new Select(country2);
        allcoutry2.selectByVisibleText("Canada");


        WebElement state2= driver.findElement(By.cssSelector("[id='BillingNewAddress_StateProvinceId']"));
        Select allstate2=new Select(state2);
        actions.click(state2).build().perform();
        MyFunc.wait(2);
        allstate2.selectByVisibleText("Nunavut");

        WebElement city= driver.findElement(By.cssSelector("[id='BillingNewAddress_City']"));
        actions.click(city).build().perform();
        city.sendKeys("toronto");
        MyFunc.wait(2);

        WebElement addres1= driver.findElement(By.xpath("(//div[@class='inputs']//input)[6]"));
        actions.click(addres1).build().perform();
        actions.sendKeys("techno street");
        MyFunc.wait(2);


        WebElement addres2= driver.findElement(By.xpath("(//div[@class='inputs']//input)[7]"));
        actions.click(addres2).build().perform();
        addres2.sendKeys("techno no:23");
        MyFunc.wait(2);

        WebElement zip= driver.findElement(By.xpath("(//div[@class='inputs']//input)[8]"));
        actions.click(zip).build().perform();
        zip.sendKeys("236875");
        MyFunc.wait(2);


        WebElement phonenumber= driver.findElement(By.xpath("(//div[@class='inputs']//input)[9]"));
        actions.click(phonenumber).build().perform();
        phonenumber.sendKeys("+4896745312");
        MyFunc.wait(2);


        WebElement contiune1= driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input"));
        actions.click(contiune1).build().perform();
        MyFunc.wait(3);


        WebElement instorecheckbox= driver.findElement(By.xpath("//div[@class='section pickup-in-store']/p[1]/input[1]"));
        actions.click(instorecheckbox).build().perform();
        MyFunc.wait(2);


        WebElement contiune2= driver.findElement(By.xpath("((//div[@class='buttons'])[3]/p//following-sibling::input)[1]"));
        actions.click(contiune2).build().perform();
        MyFunc.wait(2);

        WebElement contiune3= driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        actions.click(contiune3).build().perform();
        MyFunc.wait(2);


        WebElement contiune4= driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        actions.click(contiune4).build().perform();
        MyFunc.wait(2);

        WebElement confirm= driver.findElement(By.xpath("//input[@value='Confirm']"));
        actions.click(confirm).build().perform();
        MyFunc.wait(2);


        WebElement contiune5= driver.findElement(By.xpath("//div[@class='buttons']/input"));
        actions.click(contiune5).build().perform();
        MyFunc.wait(2);

        waitAndQuit();

    }


}
