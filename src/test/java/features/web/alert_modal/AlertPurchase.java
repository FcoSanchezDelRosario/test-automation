package features.web.alert_modal;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

public class AlertPurchase extends UIInteractionSteps {

    @Step("Confirmation message is Visible")
    public String ConfirmationMessageIsVisible() {
        return find(By.cssSelector(".sweet-alert > h2:nth-child(6)")).getText();
    }

    public String idValue() {
        String id = StringUtils.substringBefore(
                StringUtils.substringAfter(
                        StringUtils.deleteWhitespace(
                                find(By.cssSelector(".lead.text-muted")).getText())
                        , "Id:")
                , "Amount");
        idInfo(id);
        return id;
    }

    public String amountValue() {
        String amount = StringUtils.substringBefore(
                StringUtils.substringAfter(
                        StringUtils.deleteWhitespace(
                                find(By.cssSelector(".lead.text-muted")).getText())
                        , "Amount:")
                , "USDCard");
        amountInfo(amount);
        return amount;
    }

    private void idInfo(String value) {
        Serenity.recordReportData()
                .withTitle("id: ")
                .andContents(value);
    }

    private void amountInfo(String value) {
        Serenity.recordReportData()
                .withTitle("amount: ")
                .andContents(value);
    }

}
