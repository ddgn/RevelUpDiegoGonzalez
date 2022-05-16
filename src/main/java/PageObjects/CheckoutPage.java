package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='qty']")
    private WebElement quantityTextCheckout;

    @FindBy(xpath="//div[@class='item-sum fl-right']")
    private WebElement priceTextCheckout;

    @FindBy(xpath="//div[@class='btn btn-bottom btn-checkout text-center']")
    private WebElement checkOutButton;

    @FindBy(css=".tax")
    private WebElement taxCheckout;

    @FindBy(css=".tip")
    private WebElement tipCheckout;

    @FindBy(css=".grandtotal")
    private WebElement grandTotalCheckout;

    @FindBy(xpath="//span[contains(text(),'Send Order')]")
    private WebElement sendOrderButton;


    public void clickCheckoutButton(){
        checkOutButton.click();
    }

    public void waitClickableCheckoutButton(){
        waitForElementToBeClickableFluently(checkOutButton);
    }

    public String getQuantityTextCheckout(){
        return getElementText(quantityTextCheckout);
    }

    public String getPriceTextCheckout(){
        return getElementText(priceTextCheckout);
    }

    public String getTaxTextCheckout(){
        return getElementText(taxCheckout);
    }

    public String getTipTextCheckout(){
        return getElementText(tipCheckout);
    }

    public String getGrandTotalTextCheckout(){
        return getElementText(grandTotalCheckout);
    }

    public void clickSendOrderButton(){
        sendOrderButton.click();
    }

    public void waitClickableSendOrderButton(){
        waitForElementToBeClickableFluently(sendOrderButton);
    }

}
