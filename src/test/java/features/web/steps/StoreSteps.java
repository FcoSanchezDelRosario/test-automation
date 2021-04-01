package features.web.steps;

import features.web.navigation.NavigateTo;
import features.web.store.Store;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreSteps {

    @Steps
    NavigateTo navigateTo;
    @Steps
    Store store;

    @Then("the product {string} is shown in Cart Page")
    public void theProductIsShownInCartPage(String module) {
        assertThat(store.getProductName(module)).isEqualToIgnoringCase(module);
    }

    @Given("James lands to Cart page")
    public void jamesLandsToCartPage() {
        navigateTo.theCartPage();
    }
}
