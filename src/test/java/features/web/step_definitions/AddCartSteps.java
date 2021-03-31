package features.web.step_definitions;

import features.web.addcart.AddCart;
import features.web.search.SearchResult;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class AddCartSteps {


    @Steps
    SearchResult searchResult;
    @Steps
    AddCart addCart;


    @And("he add to cart the model {string}")
    public void heAddToCartTheModel(String model) {
        searchResult.selectProduct(model);
       // addCart.desired(model);
    }
}
