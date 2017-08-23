package pl.sda.javawwa;

public enum Calculate {

    AVR;

    public Double srednia (int... oceny){
        Integer sum = 0;
        Double avr = 0D;
        for (int i=0; i < oceny.length; i++){
            sum+= oceny[i];
        }

        avr = (double)sum / (double)oceny.length;
        //avr = Double.valueOf(sum / oceny.length);


        return avr;

    }

}
