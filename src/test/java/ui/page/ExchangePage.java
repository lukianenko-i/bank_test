package ui.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExchangePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public ExchangePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }

    @FindBy(xpath = "//div[@class=\"root__qLrNeW4jK\"][1]/div[@class=\"rate_kx9iSqCXBH\"][2]")
    protected WebElement costSaleEur;

    @FindBy(xpath = "//div[@class=\"root__qLrNeW4jK\"][1]/div[@class=\"rate_kx9iSqCXBH\"][1]")
    protected WebElement costBuyEur;

    @FindBy(xpath = "//div[@class=\"root__qLrNeW4jK\"][1]/div[@class=\"rate_kx9iSqCXBH\"][1]")
    protected WebElement costSaleUsd;

    @FindBy(xpath = "//div[@class=\"root__qLrNeW4jK\"][2]/div[@class=\"rate_kx9iSqCXBH\"][1]")
    protected WebElement costBuyUsd;

    @FindBy(xpath = "//button[@data-qa-node=\"currencyA\"]")
    protected WebElement windowMany;

    @FindBy(xpath = "//button[@data-qa-node=\"currencyA-option\"][@title=\"USD\"]")
    protected WebElement windowManyUsd;

    @FindBy(xpath = "//button[@data-qa-node=\"currencyA-option\"][@title=\"EUR\"]")
    protected WebElement windowManyEur;

    @FindBy(xpath = "//input[@data-qa-node=\"amountA\"]")
    protected WebElement inputIn;

    @FindBy(xpath = "//input[@data-qa-node=\"amountB\"]")
    protected WebElement inputOut;

    @FindBy(xpath = "//a[@class=\"sc-jxOSlx fCXiVh home_AVx7zJR9wg\"]")
    protected WebElement goHome;
}
