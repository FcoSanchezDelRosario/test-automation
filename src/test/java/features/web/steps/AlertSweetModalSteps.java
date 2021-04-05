package features.web.steps;

import features.web.alert_modal.AlertPurchase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;
import static features.web.store.Store.*;

public class AlertSweetModalSteps {

    @Steps
    AlertPurchase alertPurchase;

    @Then("he sees {string} message")
    public void heSeesMessage(String message) {
        assertThat(alertPurchase.ConfirmationMessageIsVisible()).isEqualToIgnoringCase(message);
    }

    @And("he sees the purchase id")
    public void heSeesThePurchaseId() {
        assertThat(alertPurchase.idValue()).isNotEmpty();
    }

    @And("he sees the purchase amount")
    public void heSeesThePurchaseAmount() {
        assertThat(alertPurchase.amountValue()).isNotEmpty();
    }

    @And("the purchase amount is as expected")
    public void thePurchaseAmountIsAsExpected() {
        assertThat(alertPurchase.amountValue()).isEqualToIgnoringCase(getTotalPrice());
    }

    @When("James chooses to confirm the purchase" )
    public void jamesChoosesToConfirmThePurchase() {
        alertPurchase.confirm();
    }

    @Then("the lightbox disappear" )
    public void theLightboxDisappear() {
        assertThat(alertPurchase.disappear()).isFalse();
    }
}
