package pl.sda.wzorce.ObjectPoolExample;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReusablePool {
    static private ReusablePool pool;

    private Map<String, Boolean> reusablePool = new LinkedHashMap<>();

    public static ReusablePool getInstance() {
        if (null == pool) {
            pool = new ReusablePool();
        }
        return pool;
    }

    public String acquireReusable() {
        String result = null;
        for (Map.Entry<String, Boolean> entry: reusablePool.entrySet()) {
            if (entry.getValue() == false) {
                result = entry.getKey();
                entry.setValue(true);
                break;
            }
        }
        return  result;
    }

    public void releaseReusable(String reusasble) {
        if (reusablePool.containsKey(reusasble)) {
            reusablePool.put(reusasble, false);
        }
    }

    void addObjectToPoll(String reusable) {
        System.out.println("Metoda dodawania do Object Pool - agregacja ");
        reusablePool.put(reusable, false);
    }


    private ReusablePool() {
        super();
        // bloki
        System.out.println("Jestem w prytatnym konstruktorze Reusable Pool - kompozycja");

        reusablePool.put("Samochód jeden", false);
        reusablePool.put("Samochód dwa", false);
        reusablePool.put("Samochód trzy", false);
        reusablePool.put("Samochód cztery", false);
    }

}