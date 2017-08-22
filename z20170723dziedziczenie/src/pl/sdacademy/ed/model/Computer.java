package pl.sdacademy.ed.model;

public class Computer extends Device {

    public Computer(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    public void showDeviceDetails (){

        System.out.println("Komputer. Model: " + this.getModel() + " producent: " +this.getProducent() +" rok produkcji: "+ this.getYearOfProduction());

    }

}
