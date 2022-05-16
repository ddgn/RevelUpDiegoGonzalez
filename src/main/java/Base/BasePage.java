package Base;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;


public class BasePage {

        protected WebDriver driver;
        protected FluentWait<WebDriver> wait;

        public BasePage(WebDriver driver, int waitDuration) {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
            this.driver = driver;
            wait = new FluentWait<>(this.driver);
            wait.withTimeout(Duration.ofSeconds(waitDuration)).pollingEvery(Duration.ofSeconds(1));
            wait.ignoring(NoSuchElementException.class);
        }

        public void waitForElementDisplayedFluently(WebElement element)
        {
            wait.until(ExpectedConditions.visibilityOf(element));
        }

        public void waitForElementNotDisplayedFluently(WebElement element)
        {
            wait.until(ExpectedConditions.invisibilityOf(element));
        }

        public void waitForElementToBeClickableFluently(WebElement element)
        {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }

        public String getElementText (WebElement element)
        {
           return element.getText();
        }

        public String getInputValue (WebElement element)
        {
            return element.getAttribute("value");
        }


}
