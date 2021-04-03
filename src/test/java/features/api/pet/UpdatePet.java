package features.api.pet;

import features.api.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class UpdatePet {

    @Step("Update Pet in the store")
    public void inTheStore(@NotNull List<Map<String, String>> petUpdateDetails) {
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .formParam("name", petUpdateDetails.get(0).get("name"))
                .formParam("status", petUpdateDetails.get(0).get("status"))
                .when()
                .post(WebServiceEndPoints.UPDATE_PET.getUrl(), petUpdateDetails.get(0).get("id"));
    }
}
