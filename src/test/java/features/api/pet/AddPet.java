package features.api.pet;

import features.api.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class AddPet {

    @Step("Add a new pet to the store")
    public void withDetails(String pet) {
        SerenityRest.given()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post(WebServiceEndPoints.ADD_PET.getUrl())
                .then().statusCode(200);
    }
}
