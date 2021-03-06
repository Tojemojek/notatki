package pl.sdacademy.singleton;

public class EagerCreatedSingleton {
    private static final EagerCreatedSingleton INSTANCE = new EagerCreatedSingleton();
    
    private EagerCreatedSingleton() {
        // empty
    }
    
    public static EagerCreatedSingleton getInstance() {
        return INSTANCE;
    }

    static {
        System.out.println("to jest w bloku statycznym EagerCreatedSingleton");
    }

}
