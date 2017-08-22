package pl.sda.collection;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, List<Integer>> myFirstMap = new HashMap<>();
        List<Integer> iPhoneModels = new ArrayList<>();

        iPhoneModels.add(5);
        iPhoneModels.add(6);

        myFirstMap.put("iPhone", iPhoneModels);

        List<Integer> iPhones = myFirstMap.get("iPhone");


        //na to zwróć uwagę - stream for each
        iPhones.stream().forEach(System.out::println);

        Map<String,Integer> map =new HashMap<>();

        map.put("one",1);
        map.put("two",2);
        map.put("three",3);
        map.put("four",4);


        for (Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.print(entry.getKey() + " " + entry.getValue());
            System.out.println();
        }


    }
}
