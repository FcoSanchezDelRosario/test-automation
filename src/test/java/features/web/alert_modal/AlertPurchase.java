package features.web.alert_modal;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;

import static features.web.ui.AlertPurchase.*;

public class AlertPurchase extends UIInteractionSteps {

    @Step("Confirmation message is Visible" )
    public String ConfirmationMessageIsVisible() {
        return find(CONFIRMATION_MESSAGE).getText();
    }

    @Step("Click on OK button" )
    public void confirm() {
        find(OK_BUTTON).waitUntilClickable().click();
    }

    @Step("the light box disappears")
    public boolean disappear() {
        return find(ALERT_PURCHASE).isVisible();
    }

    public String idValue() {
        String id = StringUtils.substringBefore(
                StringUtils.substringAfter(
                        StringUtils.deleteWhitespace(
                                find(TEXT_DETAILS).getText())
                        , "Id:" )
                , "Amount" );
        idInfo(id);
        return id;
    }

    public String amountValue() {
        String amount = StringUtils.substringBefore(
                StringUtils.substringAfter(
                        StringUtils.deleteWhitespace(
                                find(TEXT_DETAILS).getText())
                        , "Amount:" )
                , "USDCard" );
        amountInfo(amount);
        return amount;
    }

    private void idInfo(String value) {
        Serenity.recordReportData()
                .withTitle("id: " )
                .andContents(value);
    }

    private void amountInfo(String value) {
        Serenity.recordReportData()
                .withTitle("amount: " )
                .andContents(value);
    }
}
