package features.api.steps;

import com.google.gson.Gson;
import features.api.pet.AddPet;
import features.api.pet.FindPet;
import features.api.pet.PetDetails;
import features.api.templates.AddNewPet;
import features.api.templates.FieldValues;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class AddPetSteps {

    @Steps
    AddPet addPet;
    @Steps
    FindPet findPet;

    String pet;
    PetDetails petInfo;

    @Given("the following pet information:")
    public void theFollowingPetInformation(@NotNull List<Map<String, String>> petDetails) {
        pet = AddNewPet.template("templates/add_pet.json")
                .withDefaultValuesFrom(
                        FieldValues.in("templates/add_pet.properties"))
                .withFieldsFrom(petDetails.get(0));
        petInfo = new Gson().fromJson(pet, PetDetails.class);

    }

    @When("James adds the new pet to the store")
    public void jamesAddsTheNewToTheStore() {
        addPet.withDetails(pet);
    }

    @Then("He find by id the new pet added")
    public void heFindByIdTheNewPetAdded() {
        findPet.byId(petInfo.getId());
    }

    @And("the new pet added should include the following details:")
    public void theNewPetAddedShouldIncludeTheFollowingDetails(@NotNull List<Map<String, String>> petDetails) {
        restAssuredThat(response -> response.statusCode(200));
        Map<String, String> expectedResponse = petDetails.get(0);
        Map<?, ?> actualResponse = SerenityRest.lastResponse().getBody().as(Map.class);
        assertThat(actualResponse.get("name")).isEqualTo(expectedResponse.get("name"));
        assertThat(actualResponse.get("status")).isEqualTo(expectedResponse.get("status"));
    }
}
