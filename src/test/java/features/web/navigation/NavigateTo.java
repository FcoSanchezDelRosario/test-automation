package features.web.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    DemoBlazeHOmePage homePage;

    @Step("Open Demo Blaze")
    public void theDemoBlazeHomePage() {
        homePage.open();
    }
}
