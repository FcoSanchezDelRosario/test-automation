package features.api.steps;

import features.api.pet.DeletePet;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class DeletePetSteps {

    @Steps
    DeletePet deletePet;

    @When("James deletes the pet with id {string}")
    public void jamesDeletesThePetWithId(String petId) {
        deletePet.byId(petId);
    }

    @Then("the pet with the id {string} should be deleted from the store")
    public void thePetWithTheIdShouldBeDeletedFromTheStore(String petId) {
        restAssuredThat(response -> response.statusCode(200));
        Map<?, ?> actualResponse = SerenityRest.lastResponse().getBody().as(Map.class);
        assertThat(actualResponse.get("message")).isEqualTo(petId);
        reportPetIDDeleted(actualResponse.get("message").toString());
    }

    private void reportPetIDDeleted(String value) {
        Serenity.recordReportData()
                .withTitle("ID of the pet Deleted:")
                .andContents(value);
    }
}
