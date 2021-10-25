package pl.mateusz.exchange.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.exchange.model.dto.AmountAndCurrencies;
import pl.mateusz.exchange.model.dto.CurrencyExchangeDTO;
import pl.mateusz.exchange.service.CurrencyExchangeService;
import pl.mateusz.exchange.service.SaveIntoAFileService;

import javax.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/currency-exchange-json")
public class CurrencyExchangeControllerJSON {

    private CurrencyExchangeService currencyExchangeService;

    private SaveIntoAFileService saveIntoAFileService;

    private CurrencyExchangeControllerJSON(CurrencyExchangeService currencyExchangeService,SaveIntoAFileService saveIntoAFileService) {
        this.currencyExchangeService = currencyExchangeService;
        this.saveIntoAFileService = saveIntoAFileService;
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
        public CurrencyExchangeDTO giveMeAValueAfterExchange(@RequestBody AmountAndCurrencies amountAndCurrencies) {
        saveIntoAFileService.createAFile();
        return currencyExchangeService.exchangeCurrency(
                amountAndCurrencies.getAmount(),
                amountAndCurrencies.getCurrencyFrom(),
                amountAndCurrencies.getCurrencyTo());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleMyCustomException(EntityNotFoundException e) {
        return new ResponseEntity<>("Something happened: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
