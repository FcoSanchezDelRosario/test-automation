package features.api.steps;

import features.api.store.PetsStore;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class StoreSteps {

    @Steps
    PetsStore petsStore;

    @When("James asks for the available pets")
    public void jamesAsksForTheAvailablePets() {
        petsStore.getPetInventories();
    }

    @Then("he has the inventory of pets available")
    public void heHasTheInventoryOfPetsAvailable() {
        restAssuredThat(response -> response.statusCode(200));
        assertThat(Integer.valueOf(SerenityRest.lastResponse().path("available").toString())).isGreaterThan(0);
    }
}
