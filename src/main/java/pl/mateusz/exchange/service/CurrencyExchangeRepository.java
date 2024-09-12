package pl.mateusz.exchange.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mateusz.exchange.model.CurrencyExchangeEntity;
import pl.mateusz.exchange.model.values.Currency;

@Repository
interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

    CurrencyExchangeEntity findByCurrencyFromAndAndCurrencyTo(Currency from, Currency to);

}
