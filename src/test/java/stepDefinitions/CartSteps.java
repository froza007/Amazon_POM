package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.CartPage;

public class CartSteps {

    @When("User adds product to cart")
    public void addProduct(){

    	new CartPage(BaseClass.driver)
.addProductToCart();
    }

    @When("User opens cart")
    public void openCart(){

    	new CartPage(BaseClass.driver)
.openCart();
    }

    @Then("Verify product added to cart")
    public void verifyCart(){

        Assert.assertTrue(
        		new CartPage(BaseClass.driver)
.isProductInCart());
    }

    @When("User removes product from cart")
    public void removeProduct(){

    	new CartPage(BaseClass.driver)
.removeProduct();
    }
}
