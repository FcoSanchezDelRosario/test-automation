package features.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"features.api.steps"},
        plugin = {"pretty"},
        features = { "src/test/resources/features/api"}
)
public class CucumberApiTestSuite {
}
