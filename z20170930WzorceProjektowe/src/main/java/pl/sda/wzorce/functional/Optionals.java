package pl.sda.wzorce.functional;

import pl.sda.wzorce.Country;
import pl.sda.wzorce.CountryFactory;

import java.util.Optional;


public class Optionals {

    Optional<Country> countryPl = Optional.empty();
    Optional<Country> countryDe = Optional.empty();


    void test (){
        Country poland = CountryFactory.getCountry(CountryFactory.polandCode);
        countryPl = Optional.ofNullable(poland);

        Country germany = CountryFactory.getCountry(CountryFactory.germanyCode);
        countryDe = Optional.ofNullable(germany);

    }
}
