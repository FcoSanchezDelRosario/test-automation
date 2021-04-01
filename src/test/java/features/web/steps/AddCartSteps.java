package features.web.steps;

import features.web.Product.ProductPage;
import features.web.alert_modal.AlertModal;
import features.web.search.ResultList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class AddCartSteps {

    @Steps
    ResultList resultList;
    @Steps
    ProductPage productPage;
    @Steps
    AlertModal alertModal;

    @And("he adds to cart the model {string}")
    public void heAddsToCartTheModel(String model) {
        resultList.selectProduct(model);
        productPage.addProductDesired(model);
    }

    @And("he accepts that the product is added")
    public void heAcceptsThatTheProductIsAdded() {
        productPage.acceptProductAdded();
    }

    @Then("lightbox with message {string} is shown")
    public void lightboxWithMessageIsShown(String message) {
        assertThat(alertModal.getAlertMessage()).isEqualToIgnoringCase(message);
    }
}
