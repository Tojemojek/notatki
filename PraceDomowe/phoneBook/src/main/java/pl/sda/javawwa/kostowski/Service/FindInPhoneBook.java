package pl.sda.javawwa.kostowski.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindInPhoneBook {

    private Set<String> phoneNumbers = new HashSet<>();


    public static Set<String> searchByName(Map<String, Set<String>> phoneBook, String name) {
        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);
        }
        return null;
    }

    public static String searchByPhoneNumber(Map<String, Set<String>> phoneBook, String phoneNumber) {

        for (Map.Entry<String, Set<String>> entry : phoneBook.entrySet()) {
            Set<String> tmpSet;
            tmpSet = entry.getValue();

            for (String valuetmp: tmpSet) {
                if (valuetmp.equals(phoneNumber)) {
                    return entry.getKey();
                }
            }

        }return null;

    }
}
