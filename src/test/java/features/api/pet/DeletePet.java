package features.api.pet;

import features.api.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeletePet {

    @Step("Delete Pet")
    public void byId(String petId) {
        SerenityRest.given()
                .header("accept", "application/json")
                .when()
                .delete(WebServiceEndPoints.DELETE_PET.getUrl(), petId);
    }
}
