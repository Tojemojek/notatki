package pl.sda.wzorce;

import java.util.Optional;
import java.util.function.Consumer;


public class Main {

    public static void main(String[] args) {


        Optional<Country> someCountry = Optional.empty();
//        Country maybePoland = someCountry.get();
        printCountry(someCountry);

//        System.out.println("maybe Poland: " + maybePoland);


//        Optional<Country> someCountry2 = Optional.of(null);


//        Optional<Country> someCountry3 = Optional.ofNullable(null);
//        System.out.println("maybe Poland: " + someCountry3);


        Optional<Country> someCountry4 = Optional.ofNullable(CountryFactory.getCountry(CountryFactory.franceCode));
        printCountry(someCountry4);

        printCountryWithConsumer(someCountry4);
        printCountryWithLambda(someCountry4);
        printCountryWithLambdaOnlyCapitor(someCountry4);
        printCountryWithAnonymousClass(someCountry4);


    }

    public static void printCountry(Optional<Country> country) {
        if (country.isPresent()) {
            System.out.println(country.get());
        }
    }

    public static void printCountryWithConsumer(Optional<Country> country) {
        country.ifPresent(new CountryConsumer());

        country.ifPresent(new Consumer<Country>() {
            @Override
            public void accept(Country country) {
                System.out.println("Country with anonymous class: " + country);
            }
        });

    }

    public static void printCountryWithAnonymousClass(Optional<Country> country) {
        country.ifPresent(new Consumer<Country>() {
            @Override
            public void accept(Country country) {
                System.out.println("Country with anonymous class: " + country);
            }
        });

    }



    public static void printCountryWithLambda(Optional<Country> country) {
        country.ifPresent(t-> System.out.println("Country with lamda: " + t));
    }

    public static void printCountryWithLambdaOnlyCapitor(Optional<Country> country) {
        country.ifPresent(t-> System.out.println("Country with lamda (only capital): " + t.getCapitalCity()));
    }




}


class CountryConsumer<Country> implements Consumer<Country> {
    @Override
    public void accept(Country country) {
        System.out.println("Country with consumer: " + country);
    }
}
