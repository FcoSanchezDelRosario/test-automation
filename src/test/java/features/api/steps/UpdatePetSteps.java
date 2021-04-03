package features.api.steps;

import features.api.pet.FindPet;
import features.api.pet.UpdatePet;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdatePetSteps {

    @Steps
    UpdatePet updatePet;
    @Steps
    FindPet findPet;

    @When("James update the pet with the following information:")
    public void jamesUpdateThePetWithTheFollowingInformation(@NotNull List<Map<String, String>> petUpdateDetails) {
        updatePet.inTheStore(petUpdateDetails);
    }

    @Then("He find by the id {int} the pet updated")
    public void heFindByTheIdThePetUpdated(int id) {
        findPet.byId(id);
    }

    @And("pet updated should include the following details:")
    public void petUpdatedShouldIncludeTheFollowingDetails(@NotNull List<Map<String, String>> petUpdateDetails) {
        restAssuredThat(response -> response.statusCode(200));
        Map<String, String> expectedResponse = petUpdateDetails.get(0);
        Map<?, ?> actualResponse = SerenityRest.lastResponse().getBody().as(Map.class);
        assertThat(actualResponse.get("name")).isEqualTo(expectedResponse.get("name"));
        assertThat(actualResponse.get("status")).isEqualTo(expectedResponse.get("status"));
    }

}
