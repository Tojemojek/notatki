package pl.sdacademy.ed.model;

public class Hifi extends Device{

    public Hifi(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    public void showDeviceDetails (){
        System.out.println("Hifi. Model: " + this.getModel() + " producent: " +this.getProducent() +" rok produkcji: "+ this.getYearOfProduction());
    }



}
