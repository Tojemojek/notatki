package pl.sdacademy.ed.model;

public class Tv extends Device {


    private Boolean fourKReady;


    public Tv(String model, String producent, Integer yearOfProduction) {
        super(model, producent, yearOfProduction);
    }

    public Tv(String model, String producent, Integer yearOfProduction, Boolean fourKReady) {
        super(model, producent, yearOfProduction);
        this.fourKReady = fourKReady;
    }


    @Override
    public String getElectronicDeviceDetails() {
        return super.getElectronicDeviceDetails() + ", is 4K ready: " + this.fourKReady;
    }

    public void showDeviceMode() {
        super.showDeviceMode();
    }
}

