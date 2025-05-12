package pages;


import ui.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to basket page to view selected product
 */
public class BasketPage {


    UiActions action = new UiActions();

    private final By productName = By.xpath("//tr[@class='cart_item']//td[@class='product-name']//a");
    private final By checkoutBtn = By.xpath("//a[@class='checkout-button button alt wc-forward']");




    /**
     * get products name from basket
     */
    public String getProductFromBasket() {

        action.waitFunction(productName, "waitVisibility");
       return action.findElement(productName).getTextOfElement();
    }

    /**
     * checkout with selected products
     */
    public void checkout() {
        action.scrollDownToBottom();
        action.findElement(checkoutBtn).actionOnElement("click");
    }


}
