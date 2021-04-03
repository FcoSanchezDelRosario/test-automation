package features.web;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"features.web.steps"},
        plugin = {"pretty"},
        features = {"src/test/resources/features/web/d_product_categories_navigation.feature",
                "src/test/resources/features/web/a_add_product.feature",
                "src/test/resources/features/web/b_delete_product.feature",
                "src/test/resources/features/web/c_place_order.feature"
        }
)
public class CucumberWebTestSuite {
}
