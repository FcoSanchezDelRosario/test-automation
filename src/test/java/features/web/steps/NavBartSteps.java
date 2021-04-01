package features.web.steps;

import features.web.search.NavigationBar;
import io.cucumber.java.en.And;
import net.thucydides.core.annotations.Steps;

public class NavBartSteps {

    @Steps
    NavigationBar navBar;

    @And("he chooses {string} brand")
    public void heChoosesBrand(String brand) {
        navBar.selectBrand(brand);

    }
}
