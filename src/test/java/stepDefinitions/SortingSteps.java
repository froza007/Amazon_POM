package stepDefinitions;

import base.BaseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.SortingPage;

public class SortingSteps {

    @When("User sorts by price low to high")
    public void sortLow(){

        SortingPage sorting =
                new SortingPage(BaseClass.driver);

        sorting.sortLowToHigh();
    }

    @When("User sorts by customer review")
    public void sortReview(){

        SortingPage sorting =
                new SortingPage(BaseClass.driver);

        sorting.sortByCustomerReview();
    }

    @Then("Verify sorting applied")
    public void verifySorting(){

        SortingPage sorting =
                new SortingPage(BaseClass.driver);

        Assert.assertTrue(sorting.verifyProductsPresent());
    }
}
