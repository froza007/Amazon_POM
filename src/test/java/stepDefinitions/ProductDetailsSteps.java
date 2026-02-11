package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.ProductDetailsPage;

public class ProductDetailsSteps {

    @When("User opens first product details")
    public void openProduct(){

    	new ProductDetailsPage(BaseClass.driver)
.openFirstProduct();
    }

    @Then("Verify product title visible")
    public void verifyTitle(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.driver)
.isTitleVisible());
    }

    @Then("Verify product price visible")
    public void verifyPrice(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.driver)
.isPriceVisible());
    }

    @Then("Verify product image visible")
    public void verifyImage(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.driver)
.isImageVisible());
    }

    @Then("Verify product description visible")
    public void verifyDescription(){

        Assert.assertTrue(
        		new ProductDetailsPage(BaseClass.driver)
.isDescriptionVisible());
    }
}
