package ui.tests;

import ui.page.MethodsExchangePage;
import ui.page.MethodsHomePage;
import org.testng.annotations.Test;

public class TestsExchange extends BaseTests {



    @Test(groups = {"testEUR"})
    public void positiveTestExchangeEurTrue() {
        new MethodsHomePage(driver)
                .clickToExchange();
        new MethodsExchangePage(driver)
                .assuredEurGetMethod()
                .assuredEurGetApiMethod()
                .goHomePage();


    }

    @Test(groups = {"testEUR"})
    public void positiveTestExchangeInputEurTrue() {
        new MethodsHomePage(driver)
                .clickToExchange();
        new MethodsExchangePage(driver)
                .assertCorrectWorkInputEur()
                .goHomePage();
    }

    @Test(groups = {"testUSD"})
    public void positiveTestExchangeUsdTrue() {
        new MethodsHomePage(driver)
                .clickToExchange();
        new MethodsExchangePage(driver)
                .assuredUsdGetMethod()
                .assuredUsdGetApiMethod()
                .goHomePage();
    }

    @Test(groups = {"testUSD"})
    public void positiveTestExchangeInputUsdTrue() {
        new MethodsHomePage(driver)
                .clickToExchange();
        new MethodsExchangePage(driver)
                .assertCorrectWorkInputUsd()
                .goHomePage();
    }

}
