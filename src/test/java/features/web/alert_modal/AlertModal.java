package features.web.alert_modal;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class AlertModal extends UIInteractionSteps {

    @Step("capture the alert message")
    public String getAlertMessage() {
        return getDriver().switchTo().alert().getText();
    }
}
