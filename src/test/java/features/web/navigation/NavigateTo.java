package features.web.navigation;

import net.thucydides.core.annotations.Step;

public class NavigateTo {

    HomePage homePage;
    CartPage cartPage;

    @Step("Land to Demo Blaze Page")
    public void theDemoBlazeHomePage() {
        homePage.open();
    }

    @Step("Land to Cart Page")
    public void theCartPage() {

    }
}
