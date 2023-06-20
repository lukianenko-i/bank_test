package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MethodsHomePage extends HomePage{


    public MethodsHomePage(WebDriver driver) {
        super(driver);
    }


    public MethodsHomePage clickToExchange() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonToExchange)).click();
        return this;
    }
}
