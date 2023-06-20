package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    public static WebDriverWait wait;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @FindBy(xpath = "//div[@class=\"exchangeRates_rdIOGINeZq\"]/a")
    protected static WebElement buttonToExchange;


}
