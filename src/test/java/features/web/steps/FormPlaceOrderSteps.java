package features.web.steps;

import features.web.FormPlaceOrder.FormPlaceOrder;
import features.web.model.FormDetails;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class FormPlaceOrderSteps {

    public static FormDetails formInput;

    @Before
    public void setUp() {
        formInput = FormDetails.builder()
                .name("James")
                .city("London")
                .country("UK")
                .creditCard("5434687781518500")
                .Month("April")
                .year("2021")
                .build();
    }

    @Steps
    FormPlaceOrder form;

    @And("fill the Place Order form")
    public void fillThePlaceOrderForm() {
        form.fillPlaceOrderForm(formInput);
    }

    @And("chooses Purchases")
    public void choosesPurchases() {
        form.clickOnPurchases();
    }
}
