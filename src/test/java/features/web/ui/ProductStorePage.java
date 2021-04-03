package features.web.ui;

import org.openqa.selenium.By;

public class ProductStorePage {

    public static final By PRODUCTS = By.cssSelector("#tbodyid .success");
    public static final By PRODUCT_TITLE = By.cssSelector("td:nth-child(2)");
    public static final By LINK_DELETE = By.linkText("Delete");
    public static final By TOTAL_PRICE= By.id("totalp");
    public static final By PLACE_ORDER = By.cssSelector(".btn-success");

}
