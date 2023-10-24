package ui.page;

import api.exchange.ExchangeApi;
import api.tools.Specification;
import ui.tools.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static api.points.ExchangePoints.getExchangeEur;
import static api.points.ExchangePoints.getExchangeUsd;

public class MethodsExchangePage extends ExchangePage {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public MethodsExchangePage(WebDriver driver) {
        super(driver);
        MethodsExchangePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MethodsExchangePage goHomePage(){
        goHome.click();
        return this;
    }


    public MethodsExchangePage assertCorrectWorkInputEur() {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        windowMany.click();
        windowManyEur.click();
        inputIn.clear();
        inputIn.sendKeys(ConfProperties.getProperty("postEur"));

        String str = js.executeScript("return arguments[0].value", inputOut).toString();

        Assert.assertEquals(ConfProperties.getProperty("getEur"), str);


        return this;
    }


    public MethodsExchangePage assertCorrectWorkInputUsd() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        windowMany.click();
        wait.until(ExpectedConditions.elementToBeClickable(windowManyUsd)).click();
        inputIn.clear();
        inputIn.sendKeys(ConfProperties.getProperty("postUsd"));
        String str = js.executeScript("return arguments[0].value", inputOut).toString();
        Assert.assertEquals(ConfProperties.getProperty("getUsd"), str);


        return this;
    }


    public MethodsExchangePage assuredUsdGetMethod() {
        String wareBuyValue = costBuyUsd.getText();
        String wareSaleValue = costSaleUsd.getText();

        Assert.assertEquals(ConfProperties.getProperty("wareBuyUsd"), wareBuyValue);
        Assert.assertEquals(ConfProperties.getProperty("wareSaleUsd"), wareSaleValue);
        return this;
    }

    public MethodsExchangePage assuredUsdGetApiMethod() {

        Specification.installSpecification(
                Specification.responseSpecification200(),
                Specification.requestSpecification(ConfProperties.getProperty("URL")));

        List<ExchangeApi> usdExchangeList = getExchangeUsd();

        String buyValue = usdExchangeList.get(0).getBuy();
        double buyNumericValue = Double.parseDouble(buyValue.replace(",", "."));
        double roundedValue = Double.parseDouble(String.format("%.4f", buyNumericValue));
        String valueBuy = Double.toString(roundedValue);

        String saleValue = usdExchangeList.get(0).getSale();
        double saleNumericValue = Double.parseDouble(saleValue.replace(",", "."));
        double roundedValueSale = Double.parseDouble(String.format("%.4f", saleNumericValue));
        String valueSale = Double.toString(roundedValueSale);

        Assert.assertEquals(ConfProperties.getProperty("wareBuyUsd"), valueBuy);
        Assert.assertEquals(ConfProperties.getProperty("wareSaleUsd"), valueSale);

        return this;

    }

    public MethodsExchangePage assuredEurGetMethod() {
        String wareBuyValue = costBuyEur.getText();
        String wareSaleValue = costSaleEur.getText();

        Assert.assertEquals(ConfProperties.getProperty("wareBuyEur"), wareBuyValue);
        Assert.assertEquals(ConfProperties.getProperty("wareSaleEur"), wareSaleValue);
        return this;
    }

    public MethodsExchangePage assuredEurGetApiMethod() {

        Specification.installSpecification(
                Specification.responseSpecification200(),
                Specification.requestSpecification(ConfProperties.getProperty("URL")));
    //
        List<ExchangeApi> eurExchangeList = getExchangeEur();

        String buyValue = eurExchangeList.get(0).getBuy();
        double buyNumericValue = Double.parseDouble(buyValue.replace(",", "."));
        double roundedValue = Double.parseDouble(String.format("%.4f", buyNumericValue));
        String valueBuy = Double.toString(roundedValue);

        String saleValue = eurExchangeList.get(0).getSale();
        double saleNumericValue = Double.parseDouble(saleValue.replace(",", "."));
        double roundedValueSale = Double.parseDouble(String.format("%.4f", saleNumericValue));
        String valueSale = Double.toString(roundedValueSale);

        Assert.assertEquals(ConfProperties.getProperty("wareBuyEur"), valueBuy);
        Assert.assertEquals(ConfProperties.getProperty("wareSaleEur"), valueSale);

        return this;

    }

}
