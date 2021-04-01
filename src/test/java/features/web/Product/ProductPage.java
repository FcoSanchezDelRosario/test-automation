package features.web.Product;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static features.web.ui.ProductPage.ADD_TO_CART;

public class ProductPage extends UIInteractionSteps {

    @Step("add to cart the product {0}")
    public void addProductDesired(String model) {
        find(ADD_TO_CART).waitUntilClickable().click();
    }

    @Step("accept Product added lightbox")
    public void acceptProductAdded() {
        waitFor(ExpectedConditions.alertIsPresent());
        getDriver().switchTo().alert().accept();
    }
}
