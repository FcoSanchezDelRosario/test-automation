package features.web.search;

import lombok.SneakyThrows;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static features.web.ui.HomePage.*;

public class ResultList extends UIInteractionSteps {

    @Step("Result category List is Visible")
    public boolean getList() {
        return find(RESULT_CATEGORY_LIST).isVisible();
    }

    @Step("Recover Models title")
    public List<String> getListModelsTitle() {
        waitForRenderedElements(CARD);
        return findAllCards()
                .map(Cards::getTitle)
                .collect(Collectors.toList());
    }

    @SneakyThrows
    @Step("Select Product {0}")
    public void selectProduct(String name) {
        waitForRenderedElements(CARD);
        waitABit(2000);
                findAllCards()
                        .filter(ByCardTitle(name))
                //.filter(product -> product.getTitle().equalsIgnoreCase(model))
                .findFirst()
                .orElseThrow(() -> new Exception("Product not found"))
         .getElement().click();

    }

    private Predicate<Cards> ByCardTitle(String card){
        return name -> card.equalsIgnoreCase(name.getTitle());
    }

    Stream<Cards> findAllCards() {
        return findAll(CARD)
                .stream()
                .map(Cards::new);
    }

    public static class Cards {

        private final WebElementFacade element;

        public Cards(WebElementFacade element) {
            this.element = element;
        }

        private WebElementFacade getElement(){
            return element.find(CARD_TITLE);
        }

        private String getTitle() {
            return element.find(CARD_TITLE).getText();
        }
    }
}
