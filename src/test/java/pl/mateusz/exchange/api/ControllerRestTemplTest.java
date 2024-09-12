package pl.mateusz.exchange.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pl.mateusz.exchange.model.dto.CurrencyExchange;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerRestTemplTest {

    @LocalServerPort
    private int port;

    private String url;

    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp() {
        url = String.format("http://localhost:%d/currency-exchange/100/PLN/EUR", port);
    }

    @Test
    public void shouldReturnCurrencyExchangeWhenCorrectRequest() {
        assertThat(this.restTemplate.getForObject(url, CurrencyExchange.class))
                .hasFieldOrPropertyWithValue("result", new BigDecimal("22.00"));
    }
}


