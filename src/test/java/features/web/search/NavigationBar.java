package features.web.search;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;


public class NavigationBar extends UIInteractionSteps {

    public void selectBrand(String brand) {
        find(BrandLinkFor(brand)).click();
    }

    static final Map<String, By> NAVIGATION_BAR_OPTS = new HashMap<>();
    static {
        NAVIGATION_BAR_OPTS.put("Home", By.linkText("Home"));
        NAVIGATION_BAR_OPTS.put("Contact", By.linkText("Contact"));
        NAVIGATION_BAR_OPTS.put("AboutUs",  By.linkText("About us"));
        NAVIGATION_BAR_OPTS.put("Cart",  By.linkText("Cart"));
        NAVIGATION_BAR_OPTS.put("LogIn",  By.linkText("Log in"));
        NAVIGATION_BAR_OPTS.put("SignUp",  By.linkText("Sign up"));
    }

    public static By BrandLinkFor(String brand) {
        return NAVIGATION_BAR_OPTS.get(brand);
    }
}
