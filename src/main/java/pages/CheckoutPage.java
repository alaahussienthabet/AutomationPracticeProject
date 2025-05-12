package pages;

import ui.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to checkout page and checkout
 */
public class CheckoutPage {
    UiActions action = new UiActions();


    private final By formTitle = By.xpath("//h3[contains(text(),'Billing Details')]");

    /**
     * get Billing Details Form page
     */
    public String getBillingDetailsForm() {
        action.waitFunction(formTitle, "waitVisibility");
        return action.findElement(formTitle).getTextOfElement();
    }

}
