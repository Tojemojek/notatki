package pl.sda.javawwa.KanalSprzedazy;

public class KanałSprzedaży {

    private String product;

    public void wystaw(String product){
        this.product = product;
    }

    public String pobierz(){
        String wynik = product;
        product = null;
        return wynik;
    }

    public boolean czyZajety(){
        return product != null;
    }


}
