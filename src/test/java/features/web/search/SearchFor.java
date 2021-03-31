package features.web.search;

import lombok.SneakyThrows;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

import static features.web.ui.HomePage.CATEGORIES;

public class SearchFor extends UIInteractionSteps {

    @SneakyThrows
    @Step("Search for category {0}")
    public void category(String option) {
        findEach(CATEGORIES)
                .filter(category->category.getText().equalsIgnoreCase(option))
                .findFirst()
                .orElseThrow(() -> new Exception("Category not found"))
                .click();
    }
}
