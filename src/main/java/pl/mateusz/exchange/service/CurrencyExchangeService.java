package pl.mateusz.exchange.service;

import org.springframework.stereotype.Service;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.dto.UserInput;

import javax.persistence.EntityNotFoundException;

@Service
public class CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public CurrencyExchange exchangeCurrency(UserInput jsonBody) {
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeRepository
                .findByCurrencyFromAndAndCurrencyTo(jsonBody.getCurrencyFrom(), jsonBody.getCurrencyTo());
        if (currencyExchangeEntity == null) {
            throw new EntityNotFoundException("This currency exchange is not possible.");
        }
        return CurrencyExchange.of(currencyExchangeEntity.getCurrencyMultiplier().multiply(jsonBody.getAmount()));
    }
}
