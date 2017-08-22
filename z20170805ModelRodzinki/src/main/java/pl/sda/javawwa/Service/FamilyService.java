package pl.sda.javawwa.Service;

import pl.sda.javawwa.Model.Older.Parent;
import pl.sda.javawwa.Model.Younger.Brother;
import pl.sda.javawwa.Model.Family;
import pl.sda.javawwa.Model.Younger.Sibling;
import pl.sda.javawwa.Model.Younger.Sister;
import pl.sda.javawwa.Model.Younger.TypeOfMember;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {

    public static Integer howManyBrothers (Family rodzinka1) {

        Set<Sibling> tmpSibling = rodzinka1.getSiblings();
        Integer counterBrothers = 0;

        for (Sibling sibling: tmpSibling) {
            if (sibling instanceof Brother) {
                counterBrothers++;
            }
        }
        return counterBrothers;
    }

    public static Integer howManyBrothers2 (Family rodzinka1) {

        Set<Sibling> tmpSibling = rodzinka1.getSiblings();
        Integer counterBrothers = 0;

        for (Sibling sibling: tmpSibling) {
            if (sibling.getSisterOrBrother().equals(TypeOfMember.BROTHER)) {
                counterBrothers++;
            }
        }
        return counterBrothers;
    }

    public static Integer howManyBrothers3 (Family rodzinka1) {

        Set<Sibling> tmpSibling = rodzinka1.getSiblings();

         Integer collect = tmpSibling.stream()
                .filter(brother -> Objects.equals(brother.getSisterOrBrother(),TypeOfMember.BROTHER))
                .mapToInt(brother -> 1)
                .sum();

        return collect;

    }



    public static Integer howManySisters (Family rodzinka1) {

        Set<Sibling> tmpSibling = rodzinka1.getSiblings();
        Integer counterSisters = 0;


        for (Sibling sibling: tmpSibling) {
            if (sibling instanceof Sister) {
                counterSisters++;
            }
        }
        return counterSisters;
    }

    public static void showAllFamilyMembers (Family rodzinka1) {
        Set<Parent> tmpParents = rodzinka1.getParents();
        Set<Sibling> tmpSiblings = rodzinka1.getSiblings();


        System.out.println("Rodzice");
        for (Parent tmpParent: tmpParents) {

            System.out.println(tmpParent);

        }

        System.out.println("Dzieci");
        for (Sibling tmpSibling:tmpSiblings) {
            System.out.println(tmpSibling);
        }



    }

    public static List<String> getNamesByStream(Family family) {
        Set<Sibling> siblings = family.getSiblings();

        List<String> collect = siblings.stream()
                .map(sibling -> sibling.getName())
                .collect(Collectors.toList());

        return collect;
    }



    public static List<String> getNamesOfAllSiblings(Family family) {

        Set<Sibling> siblings = family.getSiblings();
        List<String> siblingNames = new ArrayList<>();


        for (Sibling sibling : siblings) {
            siblingNames.add(sibling.getName());
        }

        return siblingNames;

    }


}
