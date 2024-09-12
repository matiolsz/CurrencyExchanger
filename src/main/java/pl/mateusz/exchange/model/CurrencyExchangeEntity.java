package pl.mateusz.exchange.model;

import pl.mateusz.exchange.model.values.Currency;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private Currency currencyFrom;

    @Enumerated(EnumType.STRING)
    private Currency currencyTo;

    private BigDecimal currencyMultiplier;

    public CurrencyExchangeEntity(Currency currencyFrom, Currency currencyTo, BigDecimal currencyMultiplier) {
        this.currencyFrom = currencyFrom;
        this.currencyTo = currencyTo;
        this.currencyMultiplier = currencyMultiplier;
    }

    public CurrencyExchangeEntity() {
    }

    public Currency getCurrencyFrom() {
        return currencyFrom;
    }

    public Currency getCurrencyTo() {
        return currencyTo;
    }

    public BigDecimal getCurrencyMultiplier() {
        return currencyMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyExchangeEntity that = (CurrencyExchangeEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(currencyFrom, that.currencyFrom) && Objects.equals(currencyTo, that.currencyTo) && Objects.equals(currencyMultiplier, that.currencyMultiplier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currencyFrom, currencyTo, currencyMultiplier);
    }
}
