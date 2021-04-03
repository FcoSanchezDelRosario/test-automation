package features.web.steps;

import features.web.navigation.NavigateTo;
import features.web.store.Store;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreSteps {

    @Steps
    NavigateTo navigateTo;
    @Steps
    Store store;

    @Given("James lands to Cart page")
    public void jamesLandsToCartPage() {
        navigateTo.theCartPage();
    }

    @Given("James sees the total price")
    public void jamesSeesTheTotalPrice() {
        store.checkTotalPrice();
    }

    @When("he deletes the product {string}")
    public void heDeletesProduct(String product) {
        store.delete(product);
    }

    @Then("the product {string} is not shown")
    public void theProductIsNotShown(String product) {
        assertThat(store.productIsNotVisible(product)).isFalse();
    }

    @When("he chooses Place order")
    public void heChoosesPlaceOrder() {
        store.clickOnPlaceOrder();
    }

    @Then("the product {string} is shown in Cart Page")
    public void theProductIsShownInCartPage(String product) {
        assertThat(store.productIsVisible(product)).isTrue();

    }
}
