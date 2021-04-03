package features.api;

public enum WebServiceEndPoints {

    ADD_PET("https://petstore.swagger.io/v2/pet"),
    FIND_PET("https://petstore.swagger.io/v2/pet/{id}"),
    UPDATE_PET("https://petstore.swagger.io/v2/pet/{id}"),
    DELETE_PET("https://petstore.swagger.io/v2/pet/{id}"),
    STORE("https://petstore.swagger.io/v2/store/inventory");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}

