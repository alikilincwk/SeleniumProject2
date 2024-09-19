package Tests;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TC_0601 extends BaseDriver {
    public static WebDriverWait wait;

    @Test
    public void Test1() {

        driver.get("https://demowebshop.tricentis.com/");

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-login']")));
        actions.click(loginLink).build().perform();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Email']")));
        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Password']")));
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 login-button']")));

        actions
                .sendKeys(email, "testerkurs202401@gmx.com")
                .sendKeys(pass, "tester01")
                .click(loginBtn)
                .build().perform();

        WebElement urunList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-grid")));
        actions.moveToElement(urunList).build().perform();
        MyFunc.wait(2);

        WebElement ilkUrun = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2/a[text()='14.1-inch Laptop']")));
        actions.click(ilkUrun).build().perform();

        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='add-to-cart-button-31']")));
        actions.click(addToCartBtn).build().perform();

        WebElement productAddedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='content']")));
        System.out.println("Product Added  = " + productAddedBtn.getText());

        WebElement sepetSimgesi = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cart-label")));
        actions.click(sepetSimgesi).build().perform();

        WebElement countrySelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CountryId")));
        Select countrySelect = new Select(countrySelectElement);
        countrySelect.selectByVisibleText("United States");

        WebElement stateSelectElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='StateProvinceId']")));
        Select stateSelect = new Select(stateSelectElement);
        stateSelect.selectByVisibleText("Alabama");

        WebElement termsCheckBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice")));
        actions.click(termsCheckBox).build().perform();

        WebElement checkOutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='checkout']")));
        actions.click(checkOutBtn).build().perform();

        WebElement continueBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='billing-buttons-container']/input")));
        actions.click(continueBtn).build().perform();

        WebElement shippingBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shipping-buttons-container']/input")));
        actions.click(shippingBtn).build().perform();

        WebElement methodBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='shipping-method-buttons-container']/input")));
        actions.click(methodBtn).build().perform();

        WebElement paymentBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='payment-method-buttons-container']/input")));
        actions.click(paymentBtn).build().perform();

        WebElement infoBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='payment-info-buttons-container']/input")));
        actions.click(infoBtn).build().perform();

        WebElement confirmBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='confirm-order-buttons-container']/input")));
        actions.click(confirmBtn).build().perform();

        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='section order-completed']/div")));
        String successMessageText = successMsg.getText();
        System.out.println("successMsg.getText() = " + successMessageText);

        Assert.assertTrue("Başarı mesajı doğru değil", successMessageText.contains("Your order has been successfully processed!"));

        WebElement orderNumberElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[1]")));
        String orderNumber = orderNumberElement.getText();
        System.out.println("Sipariş Numarası: " + orderNumber);

        WebElement orderLinkElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a")));
        orderLinkElement.click();

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div[1]/div[1]/strong")));

        System.out.println("Element sayfada göründü: " + element.getText());



        MyFunc.wait(5);
        driver.quit();
    }
}