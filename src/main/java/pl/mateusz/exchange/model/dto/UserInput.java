package pl.mateusz.exchange.model.dto;

import pl.mateusz.exchange.model.values.Currency;

import java.math.BigDecimal;

public class UserInput {

    private BigDecimal amount;

    private Currency currencyFrom;

    private Currency currencyTo;

    public UserInput() {
    }

    public UserInput(BigDecimal amount, Currency currencyFrom, Currency currencyTo) {
        this.amount = amount;
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }
}
