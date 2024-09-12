package pl.mateusz.exchange.model.dto;

import java.math.BigDecimal;

public class CurrencyExchange {

    // zaproponowales aby bylo final ale nie bylem w stanie napisac testow gdy result bylo final
    private BigDecimal result;

    public CurrencyExchange() {
    }

    // zaproponowales aby bylo final ale nie bylem w stanie napisac testow gdy result bylo final
    public CurrencyExchange(BigDecimal result) {
        this.result = result;
    }

    public static CurrencyExchange of(BigDecimal result) {
        return new CurrencyExchange(result);
    }

    public BigDecimal getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "result=" + result +
                '}';
    }
}
