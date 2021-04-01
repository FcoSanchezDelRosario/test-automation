package features.web.store;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static features.web.ui.ProductStorePage.*;

public class Store extends UIInteractionSteps {

    @SneakyThrows
    @Step("the product {0} is added to the cart")
    public boolean productIsVisible(String product) {
        return findAllProducts()
                .anyMatch(item -> item.getTitle().equalsIgnoreCase(product));
    }

    @SneakyThrows
    @Step("delete product {0}")
    public void delete(String product) {
         findAllProducts()
                .filter(byProductTitle(product))
                .findFirst()
                .orElseThrow(() -> new Exception("Product not deleted"))
                 .deleteCard();
    }

    @Step("the product{0} has been eliminated")
    public boolean productIsNotVisible(String product) {
        return  findAllProducts()
                .anyMatch(item -> item.getTitle().equalsIgnoreCase(product));
    }

    @Step("check the total price")
    public void checkTotalPrice() {
        setTotalPrice(find(TOTAL_PRICE).getText());
        reportTotalPriceInfo(getTotalPrice());
    }

    @NotNull
    private Predicate<Products> byProductTitle(String productName) {
        return name -> productName.equalsIgnoreCase(name.getTitle());
    }

    Stream<Products> findAllProducts() {
        return findAll(PRODUCTS)
                .stream()
                .map(Products::new);
    }

    public void clickOnPlaceOrder() {
        find(PLACE_ORDER).waitUntilClickable().click();
    }

    public static class Products {

        private final WebElementFacade element;

        public Products(WebElementFacade element) {
            this.element = element;
        }

        private String getTitle() {
            return element.find(PRODUCT_TITLE).getText();
        }

        private void deleteCard() {
            element.find(LINK_DELETE).click();
        }
    }

    private void reportTotalPriceInfo(String value) {
        Serenity.recordReportData()
                .withTitle("Total purchase price:")
                .andContents(value);
    }

    @Setter(AccessLevel.PUBLIC)
    @Getter(AccessLevel.PUBLIC)
    public static String totalPrice;
}
