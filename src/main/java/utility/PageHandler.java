package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageHandler extends DriverUtils{

    public void fluentWait(WebElement element, int seconds) {
        Wait<WebDriver> wait = new FluentWait<>(getDriver())
            .withTimeout(Duration.ofSeconds(3))
            .pollingEvery(Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitWait(int seconds) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void explicitWait(WebElement element, int seconds) {
        Wait<WebDriver> wait = new WebDriverWait(getDriver(),Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
