package features.web;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"features.web.steps"},
        plugin = {"pretty"},
        features = {"src/test/resources/features/web/product_categories_navigation.feature",
                "src/test/resources/features/web/add_product.feature",
                "src/test/resources/features/web/delete_product.feature",
                "src/test/resources/features/web/place_order.feature"}
)
public class CucumberWebTestSuite {
}
