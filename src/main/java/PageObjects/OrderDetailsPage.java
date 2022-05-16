package PageObjects;

import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OrderDetailsPage extends BasePage {

    public OrderDetailsPage(WebDriver driver, int waitDuration) {
        super(driver, waitDuration);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".order-details-title")
    private WebElement titleOrderDetails;

    @FindBy(css=".firstName")
    private WebElement firstNameInput;

    @FindBy(css=".lastName")
    private WebElement lastNameInput;

    @FindBy(xpath="//input[@class='email input ios-safari-caret size4']")
    private WebElement emailInput;

    @FindBy(css="#phone")
    private WebElement phoneInput;

    @FindBy(css=".cash")
    private WebElement payAtStoreButton;


    public boolean isPageLoaded(){
        return driver.getCurrentUrl().contains("establishment=1#checkout") && wait.until(ExpectedConditions.visibilityOf(titleOrderDetails)).isDisplayed();
    }

    public void inputOrderDetails(String name, String lastName, String email, String phoneNumber){
        firstNameInput.sendKeys(name);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        phoneInput.sendKeys(phoneNumber);
    }

    public void clickPayAtStore(){
        payAtStoreButton.click();
    }

}
