package pl.sdacademy.ed.model;

public class Device {

    private String model;
    private String producent;
    private Integer yearOfProduction;
    private boolean onOff;

    public Device(String model, String producent, Integer yearOfProduction) {
        this.model = model;
        this.producent = producent;
        this.yearOfProduction = yearOfProduction;
        this.onOff = Boolean.FALSE;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }

    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(Integer yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void showDeviceDetails (){

        System.out.println("Model Hifi. Model: " + this.getModel() + " producent: " +this.getProducent() +" rok produkcji: "+ this.getYearOfProduction());

    }

    public String getElectronicDeviceDetails (){
        return ("model: " + getModel() + ", producent: " +getProducent() +", rok produkcji: "+ getYearOfProduction());

    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        this.onOff = onOff;
    }

    public void showDeviceMode() {
        System.out.println("This device 'on' mode is " + isOnOff());
    }

    public void showDeviceMode(Boolean onOff) {
        System.out.println("This device 'on' mode is " + onOff);
    }




}
