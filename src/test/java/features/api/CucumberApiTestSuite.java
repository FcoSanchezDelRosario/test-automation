package features.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"features.api.steps"},
        plugin = {"pretty"},
        features = { "src/test/resources/features/api/a_pet_availability.feature",
                "src/test/resources/features/api/b_add_new_pet_available.feature",
                "src/test/resources/features/api/c_update_pet_status.feature",
                "src/test/resources/features/api/d_delete_pet.feature"}
)
public class CucumberApiTestSuite {
}
