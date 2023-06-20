package api.tests;

import api.exchange.ExchangeApi;
import api.tools.Specification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static api.points.ExchangePoints.getExchangeEur;
import static api.points.ExchangePoints.getExchangeUsd;

public class Tests {
    private final static String URL = "https://api.privatbank.ua";

    @Test(groups = {"testUSD"})
    public void positiveExchangeTestUsd() {
        Specification.installSpecification
                (Specification.responseSpecification200(), Specification.requestSpecification(URL));
        String buyCost = "36.56860";
        String saleCost = "37.45318";

        List<ExchangeApi> usdExchangeList = getExchangeUsd();

        Assert.assertEquals(buyCost, usdExchangeList.get(0).getBuy());
        Assert.assertEquals(saleCost, usdExchangeList.get(0).getSale());


    }

    @Test(groups = {"testEUR"})
    public void positiveExchangeTestEur() {
        Specification.installSpecification
                (Specification.responseSpecification200(), Specification.requestSpecification(URL));
        String buyCost = "39.17000";
        String saleCost = ":40.65041";

        List<ExchangeApi> usdExchangeList = getExchangeEur();

        Assert.assertEquals(buyCost, usdExchangeList.get(0).getBuy());
        Assert.assertEquals(saleCost, usdExchangeList.get(0).getSale());
    }
}
