package features.web;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"features.web.steps"},
        plugin = {"pretty"},
//        features = {"src/test/resources/features/web/d._product_categories_navigation.feature",
//                "src/test/resources/features/web/a._add_product.feature",
//                "src/test/resources/features/web/b._delete_product.feature",
//                "src/test/resources/features/web/c._place_order.feature"
//        }
        features = {"src/test/resources/features/web"}
)
public class CucumberWebTestSuite {
}
