package pl.sda.polimorfizm;

import pl.sda.polimorfizm.bikes.Bike;
import pl.sda.polimorfizm.bikes.MountainBike;
import pl.sda.polimorfizm.bikes.OtherBike;
import pl.sda.polimorfizm.bikes.RoadBike;



public class Main {
    public static void main(String[] args) {

        Bike bike = new Bike();
        Bike mountainBike = new MountainBike();
        Bike roadBike = new RoadBike();
        Bike otherBike = new OtherBike();

        bike.go();
        mountainBike.go();
        roadBike.go();
        otherBike.go();



    }
}



