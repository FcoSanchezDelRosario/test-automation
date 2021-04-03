package features.api.pet;

import features.api.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class FindPet {

    @Step("Find the Pet By id")
    public void byId(int petId) {
        SerenityRest.given()
                .when()
                .get(WebServiceEndPoints.FIND_PET.getUrl(),
                        String.valueOf(petId));
    }
}
