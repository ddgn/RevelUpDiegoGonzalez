package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//div[@class='ui-spinner']")
    private WebElement loaderSpinner;

    @FindBy(xpath="//h1[@class='title']")
    private WebElement title;

    @FindBy(xpath="//div[contains(@class, 'product_list_item')]//h3[contains(text(), 'Prevailing Tax Group')]")
    private WebElement prevailingTaxGroup;

    @FindBy(xpath="//div[contains(@class,'action_button btn') and text() = 'Add Item']")
    private WebElement addItem;

    @FindBy(xpath="//div[@class='increase btn-qty input-border alternate-text']")
    private WebElement increaseButton;

    @FindBy(xpath="//input[@class='quantity_edit_input']")
    private WebElement quantityTextInput;

    @FindBy(xpath="//input[@class='price input product-price']")
    private WebElement priceTextInput;

    public boolean isPageLoaded(){
        return driver.getCurrentUrl().contains("weborder/?establishment=1") && wait.until(ExpectedConditions.invisibilityOf(loaderSpinner)) && wait.until(ExpectedConditions.visibilityOf(prevailingTaxGroup)).isDisplayed();
    }

    public void clickPrevailingTaxGroup(){
        prevailingTaxGroup.click();
    }

    public void waitPopUpLoaded(){
        super.waitForElementDisplayedFluently(addItem);
    }

    public void clickIncreaseButton(int numberOfTimes){
        for (int i = 0; i < numberOfTimes; i++) {
            increaseButton.click();
        }
    }

    public void clickAddItemButton(){
        addItem.click();
    }

    public String getQuantityPopUpInput(){
       return getInputValue(quantityTextInput);
    }

    public String getPricePopUpInput(){
        return getInputValue(priceTextInput);
    }

}
