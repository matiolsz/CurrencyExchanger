package pl.mateusz.exchange.api;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ControllerCreationTest {

    @Autowired
    private CurrencyExchangeController currencyExchangeController;

    @Test
    void contextLoads() throws Exception {
        assertThat(currencyExchangeController).isNotNull();
    }
}
