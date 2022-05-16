
import Base.BaseTest;
import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import PageObjects.OrderDetailsPage;
import PageObjects.ThankYouPage;
import Utils.OrderSaver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DemoTaskTest extends BaseTest {

    @Test
    public void demoTaskRevelUp() {

        HomePage homePage = new HomePage(getDriver(), 10);
        Assert.assertTrue(homePage.isPageLoaded(), "Home Page is not loaded correctly");
        homePage.clickPrevailingTaxGroup();
        homePage.waitPopUpLoaded();
        homePage.clickIncreaseButton(2);
        Assert.assertEquals(homePage.getQuantityPopUpInput(), "3");
        Assert.assertEquals(homePage.getPricePopUpInput(), "29.97");
        homePage.clickAddItemButton();

        CheckoutPage checkoutPage = new CheckoutPage(getDriver(), 5);
        Assert.assertEquals(checkoutPage.getQuantityTextCheckout(), "3");
        Assert.assertEquals(checkoutPage.getPriceTextCheckout(), "$29.97");
        checkoutPage.waitClickableCheckoutButton();
        checkoutPage.clickCheckoutButton();

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage(getDriver(), 3);
        Assert.assertTrue(orderDetailsPage.isPageLoaded(), "Order Details Page is not loaded correctly");
        orderDetailsPage.inputOrderDetails("Diego", "Gonzalez", "dnol@hotmail.com", "5523215884");
        Assert.assertEquals(checkoutPage.getQuantityTextCheckout(), "3");
        Assert.assertEquals(checkoutPage.getPriceTextCheckout(), "$29.97");
        Assert.assertEquals(checkoutPage.getTaxTextCheckout(), "2.66");
        Assert.assertEquals(checkoutPage.getTipTextCheckout(), "0.00");
        Assert.assertEquals(checkoutPage.getGrandTotalTextCheckout(), "32.63");

        orderDetailsPage.clickPayAtStore();
        checkoutPage.waitClickableSendOrderButton();
        checkoutPage.clickSendOrderButton();

        ThankYouPage thankYouPage = new ThankYouPage(getDriver(), 5);
        Assert.assertTrue(thankYouPage.isPageLoaded(), "Thank You Page is not loaded correctly");
        OrderSaver.saveOrder(thankYouPage.getOrderId());

    }

}
