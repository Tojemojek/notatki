package pl.sda.wzorce;

public class CountryFactory {

    public static final String polandCode = "pl";
    public static final String germanyCode = "de";
    public static final String franceCode = "fr";

    public static Country getCountry(String countryCode) {

        switch (countryCode) {
            case polandCode:
                return new Country("Warsaw", 38000000);
            case germanyCode:
                return new Country("Berlin", 82000000);
            case franceCode:
                return new Country("Paris", 67000000);
            default:
                return null;
        }
    }
}

