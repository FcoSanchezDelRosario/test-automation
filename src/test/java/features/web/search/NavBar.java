package features.web.search;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static features.web.search.NavigationBarOptions.*;

public class NavBar extends UIInteractionSteps {

    public void selectOption(NavigationBarOptions option) {
        find(navigationBarLinkFor(option)).click();
    }

    static final Map<NavigationBarOptions, By> NAVIGATION_BAR_OPTS = new HashMap<>();
    static {
        NAVIGATION_BAR_OPTS.put(Home, By.linkText("Home"));
        NAVIGATION_BAR_OPTS.put(Contact, By.linkText("Contact"));
        NAVIGATION_BAR_OPTS.put(AboutUs,  By.linkText("About us"));
        NAVIGATION_BAR_OPTS.put(Cart,  By.linkText("Cart"));
        NAVIGATION_BAR_OPTS.put(LogIn,  By.linkText("Log in"));
        NAVIGATION_BAR_OPTS.put(SignUp,  By.linkText("Sign up"));
    }

    public static By navigationBarLinkFor(NavigationBarOptions navigationBarOptions) {
        return NAVIGATION_BAR_OPTS.get(navigationBarOptions);
    }
}
