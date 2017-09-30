package pl.sda.wzorce;

public class Country {
    //to jest agregacja

    private String capitalCity;
    private long population;

    public Country(String capitalCity, long population) {
        this.capitalCity = capitalCity;
        this.population = population;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "capitalCity='" + capitalCity + '\'' +
                ", population=" + population +
                '}';
    }
}


// zarządza cyklem życia capital
class PolandCountry{
    //kompozycja

    private String capitalCity = "Warsaw";

    public PolandCountry() {
    }
}

class CountryUtils{
    // asocjacja
    public void preattyPrint (Country country){
    }
}
