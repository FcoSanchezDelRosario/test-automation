package features.web.search;

import lombok.SneakyThrows;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static features.web.ui.HomePage.*;

public class SearchResult extends UIInteractionSteps {

    @Step("Result category List is Visible")
    public boolean getList() {
        return find(RESULT_CATEGORY_LIST).isVisible();
    }

    @Step("Recover Models title")
    public List<String> getListModelsTitle() {
        waitForRenderedElements(CARD);
        return findAllProductCards()
                .map(Products::getTitle)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Step("Select Product {0}")
    public void selectProduct(String model) {
        findAllProductCards()
                .filter(products -> products.getTitle().equalsIgnoreCase(model))
                .findFirst()
                .orElseThrow(() -> new Exception("City not found"))
                .element.click();
    }

    Stream<Products> findAllProductCards() {
        return findAll(CARD)
                .stream()
                .map(Products::new);
    }

    public static class Products {

        private final WebElementFacade element;

        public Products(WebElementFacade element) {
            this.element = element;
        }

        private String getTitle() {
            return element.find(CARD_TITLE).getText();
        }
    }
}
