DROP TABLE IF EXISTS currency_exchange_entity;

CREATE TABLE currency_exchange_entity (
       id INT PRIMARY KEY,
       currency_from VARCHAR(250) NOT NULL,
       currency_to VARCHAR(250) NOT NULL,
       currency_multiplier DECIMAL DEFAULT NULL
    );