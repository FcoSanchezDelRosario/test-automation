package features.web.store;

import features.web.search.NavBar;
import lombok.SneakyThrows;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static features.web.search.NavigationBarOptions.Cart;

public class Store extends UIInteractionSteps {

    NavBar navBar;

    @SneakyThrows
    @Step("the product {0} is added to the cart")
    public String getProductName(String model) {
        navBar.selectOption(Cart);
     return    findAllProducts()
                .filter(byProductTitle(model))
                .findFirst()
                .orElseThrow(() -> new Exception("Product not found in Cards Cart"))
                .getTitle();
    }

    private Predicate<Products> byProductTitle(String productName){
        return name -> productName.equalsIgnoreCase(name.getTitle());
    }

    Stream<Products> findAllProducts() {
        return findAll(By.cssSelector("#tbodyid .success"))
                .stream()
                .map(Products::new);
    }

    public static class Products {

        private final WebElementFacade element;

        public Products(WebElementFacade element) {
            this.element = element;
        }

        private String getTitle(){
            return element.find(By.cssSelector("td:nth-child(2)")).getText();
        }

        private String getPrice() {
            return element.find(By.cssSelector("td:nth-child(3)")).getText();
        }

        private void deleteCard() {
             element.find(By.cssSelector("td:nth-child(4)")).click();
        }
    }
}
