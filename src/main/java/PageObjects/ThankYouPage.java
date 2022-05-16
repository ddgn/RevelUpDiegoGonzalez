package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ThankYouPage extends BasePage {

    public ThankYouPage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='ui-spinner']")
    private WebElement loaderSpinner;

    @FindBy(css=".thanks")
    private WebElement thanksTitle;

    @FindBy(css=".order-id")
    private WebElement orderId;

    public boolean isPageLoaded(){
        return wait.until(ExpectedConditions.invisibilityOf(loaderSpinner)) && wait.until(ExpectedConditions.visibilityOf(thanksTitle)).isDisplayed();
    }

    public String getOrderId(){
        return getElementText(orderId);
    }

}
