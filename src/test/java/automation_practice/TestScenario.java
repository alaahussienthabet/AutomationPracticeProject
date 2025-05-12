package automation_practice;

import pages.CheckoutPage;
import pages.BasketPage;

import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * test scenario to validate  the purchasing flow
 */
public class TestScenario extends BaseClass {

    BasketPage basketPage = new BasketPage(); //Instantiation of basketPage object
    ProductsPage productsPage = new ProductsPage(); //Instantiation of productsPage object
    CheckoutPage checkoutPage = new CheckoutPage(); //Instantiation of checkoutPage object

    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Asserting Thinking in HTML book exist with the price </p>
     * <p> Step.3) Clicking on Add to Basket for Thinking in HTML book </p>
     * <p> Step.4) Clicking on View Basket </p>
     * <p> Step.5) Asserting Item added to cart with its details </p>
     * <p> Step.6) Clicking on Proceed to Checkout </p>
     * <p> Step.7) Assert Billing Details form displayed </p>
     */
    @Test
    public void validateThatUserCanPurchaseSuccessfullyWithViewBasketOption() {

        String productName = productsPage.getProductName();
        Assert.assertEquals(productName, "Thinking in HTML", "can't find The Product Name");
        String productPrice = productsPage.getProductPrice();
        Assert.assertEquals(productPrice, "₹400.00", "can't find The Product Price");
        productsPage.addProductsToBasket("Thinking in HTML");
        productsPage.viewBasket();

        String productNameInBasket = basketPage.getProductFromBasket();
        Assert.assertEquals(productNameInBasket, "Thinking in HTML", "can't find The Product Name");
        basketPage.checkout();

        String checkoutFormTitle = checkoutPage.getBillingDetailsForm();
        Assert.assertEquals(checkoutFormTitle, "Billing Details", "can't find The checkout form");


    }
    /**
     * <p> Test Scenario </p>
     * <p> Step.1) Open Url </p>
     * <p> Step.2) Asserting Thinking in HTML book exist with the price </p>
     * <p> Step.3) Clicking on Add to Basket for Thinking in HTML book </p>
     * <p> Step.4) Clicking on View Basket from menu bar </p>
     * <p> Step.5) Asserting Item added to cart with its details </p>
     * <p> Step.6) Clicking on Proceed to Checkout </p>
     * <p> Step.7) Assert Billing Details form displayed </p>
     */
    @Test
    public void validateThatUserCanPurchaseSuccessfullyWithViewBasketFromMenuBar() {

        String productName = productsPage.getProductName();
        Assert.assertEquals(productName, "Thinking in HTML", "can't find The Product Name");
        String productPrice = productsPage.getProductPrice();
        Assert.assertEquals(productPrice, "₹400.00", "can't find The Product Price");
        productsPage.addProductsToBasket("Thinking in HTML");
        productsPage.viewBasketFromMenu();

        String productNameInBasket = basketPage.getProductFromBasket();
        Assert.assertEquals(productNameInBasket, "Thinking in HTML", "can't find The Product Name");
        basketPage.checkout();

        String checkoutFormTitle = checkoutPage.getBillingDetailsForm();
        Assert.assertEquals(checkoutFormTitle, "Billing Details", "can't find The checkout form");


    }

}


