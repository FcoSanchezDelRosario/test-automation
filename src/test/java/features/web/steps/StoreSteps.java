package features.web.steps;

import features.web.store.Store;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreSteps {

    @Steps
    Store store;

    @Then("the product {string} is shown in Cart Page")
    public void theProductIsShownInCartPage(String module) {
        assertThat(store.getProductName(module)).contains(module);
    }
}
