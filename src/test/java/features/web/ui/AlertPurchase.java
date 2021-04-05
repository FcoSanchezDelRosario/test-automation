package features.web.ui;

import org.openqa.selenium.By;

public class AlertPurchase {

    public static final By ALERT_PURCHASE = By.cssSelector(".sweet-alert");
    public static final By CONFIRMATION_MESSAGE = By.cssSelector(".sweet-alert > h2:nth-child(6)" );
    public static final By OK_BUTTON = By.cssSelector(".confirm.btn" );
    public static final By TEXT_DETAILS = By.cssSelector(".lead.text-muted" );
}
