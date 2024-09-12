package pl.mateusz.exchange.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.dto.UserInput;
import pl.mateusz.exchange.model.values.Currency;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyExchangeServiceTest {

    @InjectMocks
    CurrencyExchangeService service;

    @Mock
    CurrencyExchangeRepository dao;

    @Test
    public void serviceShouldMakeCorrectLogicWhenMethodInvoked() {
    //given
        CurrencyExchangeEntity currencyExchangeEntity =
                new CurrencyExchangeEntity(Currency.PLN,Currency.EUR,new BigDecimal("0.22"));
    //when
        when(dao.findByCurrencyFromAndAndCurrencyTo(Currency.PLN, Currency.EUR))
                .thenReturn(currencyExchangeEntity);

        CurrencyExchange currencyExchange =
                service.exchangeCurrency(
                        new UserInput(BigDecimal.valueOf(100),Currency.PLN,Currency.EUR));
    //then
        assertEquals(currencyExchange.getResult(),new BigDecimal("22.00"));
    }

}
