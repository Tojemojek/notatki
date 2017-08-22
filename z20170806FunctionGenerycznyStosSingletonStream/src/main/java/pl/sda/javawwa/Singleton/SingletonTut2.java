package pl.sda.javawwa.Singleton;

public class SingletonTut2 {


    private static SingletonTut2 INSTANCE2;

    private SingletonTut2() {

    }


    public static SingletonTut2 getInstance() {
        if (INSTANCE2 == null) {
            INSTANCE2 = new SingletonTut2();
        }
        return INSTANCE2;
    }


}
