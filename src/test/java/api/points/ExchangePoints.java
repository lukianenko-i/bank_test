package api.points;

import api.exchange.ExchangeApi;
import api.tools.RestHelper;

import java.util.List;
import java.util.stream.Collectors;

public class ExchangePoints {
    public static List<ExchangeApi> getExchangeUsd() {
        List<ExchangeApi> exchangeApiList = RestHelper.get("/p24api/pubinfo?exchange&coursid=11")
                .jsonPath()
                .getList(".", ExchangeApi.class);

        return exchangeApiList.stream()
                .filter(exchangeApi -> "USD".equals(exchangeApi.getCcy()))
                .collect(Collectors.toList());
    }

    public static List<ExchangeApi> getExchangeEur() {
        List<ExchangeApi> exchangeApiList = RestHelper.get("/p24api/pubinfo?exchange&coursid=11")
                .jsonPath()
                .getList(".", ExchangeApi.class);

        return exchangeApiList.stream()
                .filter(exchangeApi -> "EUR".equals(exchangeApi.getCcy()))
                .collect(Collectors.toList());
    }

}
