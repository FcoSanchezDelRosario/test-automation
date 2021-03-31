package features.web.step_definitions;

import features.web.search.SearchFor;
import features.web.search.SearchResult;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import features.web.navigation.NavigateTo;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageSteps {

    @Steps
    NavigateTo navigateTo;
    @Steps
    SearchFor searchFor;
    @Steps
    SearchResult searchResult;

    @Given("James lands to home page")
    public void jamesLandsToHomePage() {
        navigateTo.theDemoBlazeHomePage();
    }

    @When("he chooses the category {string}")
    public void heChoosesTheCategory(String option) {
        searchFor.category(option);
    }

    @Then("the results list is shown")
    public void theResultsListIsShown() {
        assertThat(searchResult.getList()).isTrue();
    }

    @And("the following model {string} is shown")
    public void theFollowingModelIsShown(String model) {
        assertThat(searchResult.getListModelsTitle()).contains(model);
    }
}
