package pages;

import ui.UiActions;
import org.openqa.selenium.By;

/**
 * navigate to product page and check the items
 */

public class ProductsPage {
    UiActions action = new UiActions();

    private final By productName = By.xpath("//img[@title='Thinking in HTML']//following-sibling::h3");
    private final By productPrice = By.xpath("//img[@title='Thinking in HTML']//following-sibling::span//ins//span[@class='woocommerce-Price-amount amount']");
    private final By viewBasket = By.xpath("//img[@title='Thinking in HTML']//parent::a//following-sibling::a[@class='added_to_cart wc-forward']");
    private final By basketFromMenu = By.xpath("//a[@title='View your shopping cart']");
    private final String product = "//img[@title='%s']//parent::a//following-sibling::a";


    /**
     * select products to add them to basket
     */
    public void addProductsToBasket(String productName) {

        By addProductBtn = By.xpath(String.format(product,productName));
        action.findElement(addProductBtn).actionOnElement("click");
    }

    /**
     * go to basket from view basket option to see selected items and checkout
     */
    public void viewBasket() {

        action.waitFunction(viewBasket, "waitVisibility");
        action.findElement(viewBasket).actionOnElement("click");
    }

    /**
     * go to basket from menu bar option to see selected items and checkout
     */
    public void viewBasketFromMenu() {
        action.waitFunction(basketFromMenu, "waitVisibility");
        action.findElement(basketFromMenu).actionOnElement("click");
    }

    /**
     * get product name
     */
    public String getProductName() {
        action.scrollDownToBottom();
        return action.findElement(productName).getTextOfElement();
    }
    /**
     * get price of the product
     */
    public String getProductPrice() {
        action.scrollDownToBottom();
        return action.findElement(productPrice).getTextOfElement();
    }
}
