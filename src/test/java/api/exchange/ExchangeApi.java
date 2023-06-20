package api.exchange;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeApi {
    private String ccy;
    private String base_ccy;
    private String buy;
    private String sale;
}
