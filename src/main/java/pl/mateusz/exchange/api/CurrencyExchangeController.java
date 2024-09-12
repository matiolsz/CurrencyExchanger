package pl.mateusz.exchange.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.exchange.model.dto.UserInput;
import pl.mateusz.exchange.model.dto.CurrencyExchange;
import pl.mateusz.exchange.model.values.Currency;
import pl.mateusz.exchange.service.CurrencyExchangeService;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

   private final CurrencyExchangeService currencyExchangeService;

   public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
       this.currencyExchangeService = currencyExchangeService;
   }

   @GetMapping("/hello")
   public String hello(){
       return "hello";
   }

    @GetMapping("/{amount}/{from}/{to}")
    public CurrencyExchange createFromParameters(
            @PathVariable BigDecimal amount,
            @PathVariable Currency from,
            @PathVariable Currency to) {
    return currencyExchangeService.exchangeCurrency(new UserInput(amount,from,to));
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    public CurrencyExchange createFromJson(@RequestBody UserInput userInput) {
        return currencyExchangeService.exchangeCurrency(userInput);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleMyCustomException(EntityNotFoundException e) {
        return new ResponseEntity<>("Something happened: " + e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
