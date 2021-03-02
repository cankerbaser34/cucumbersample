package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;

public class WaitHepler {

    public WebDriver driver;

    public WaitHepler(WebDriver driver){

        this.driver =driver;
    }

    public void WaitForElement(WebElement element,long timeOutInSeconds){

        WebDriverWait wait= new WebDriverWait(driver,timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
