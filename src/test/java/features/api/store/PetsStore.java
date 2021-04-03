package features.api.store;


import features.api.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetsStore {

    @Step("Returns Pet inventories by status")
    public void getPetInventories() {
        SerenityRest
                .when()
                .get(WebServiceEndPoints.STORE.getUrl());

    }
}
