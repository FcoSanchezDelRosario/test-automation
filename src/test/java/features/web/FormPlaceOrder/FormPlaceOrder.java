package features.web.FormPlaceOrder;

import features.web.model.FormDetails;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;

import static features.web.ui.FormPlaceOrder.*;

public class FormPlaceOrder extends UIInteractionSteps {

    public void fillPlaceOrderForm(@NotNull FormDetails data) {
        find(NAME).type(data.getName());
        find(COUNTRY).type(data.getCountry());
        find(CITY).type(data.getCity());
        find(CARD).type(data.getCreditCard());
        find(MONTH).type(data.getMonth());
        find(YEAR).type(data.getYear());
    }

    public void clickOnPurchases() {
        find(By.cssSelector("#orderModal .btn-primary"))
                .waitUntilClickable()
                .click();
    }
}
