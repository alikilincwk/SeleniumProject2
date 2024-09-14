package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;

    public static Actions actions;

    static {
        driver = new ChromeDriver();
        actions=new Actions(driver);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }

    public static void waitAndQuit() {
        MyFunc.wait(3);
        driver.quit();
    }

}
