package javawwa.Service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.sda.javawwa.Model.Family;
import pl.sda.javawwa.Model.Older.Father;
import pl.sda.javawwa.Model.Older.Mother;
import pl.sda.javawwa.Model.Younger.Brother;
import pl.sda.javawwa.Model.Younger.Sister;
import pl.sda.javawwa.Model.Younger.TypeOfMember;
import pl.sda.javawwa.Service.FamilyService;

import java.util.Set;

public class FamilyServiceTest {

    private static Family rodzinka1;

    @Before
    public void initFamilyServiceTest (){
        rodzinka1 = new Family();

        Father ojciec = new Father("Jan");
        Mother matka = new Mother("Anna");

        rodzinka1.addParent(ojciec);
        rodzinka1.addParent(matka);

        Brother brat1 = new Brother("brat1",matka,ojciec, TypeOfMember.BROTHER);
        Brother brat2 = new Brother("brat2",matka,ojciec,TypeOfMember.BROTHER);
        Brother brat3 = new Brother("brat3",matka,ojciec,TypeOfMember.BROTHER);

        Sister siostra1 = new Sister("siostra1",matka,ojciec,TypeOfMember.SISTER);
        Sister siostra2 = new Sister("siostra2",matka,ojciec,TypeOfMember.SISTER);

        rodzinka1.addSibling(brat1);
        rodzinka1.addSibling(brat2);
        rodzinka1.addSibling(brat3);
        rodzinka1.addSibling(siostra1);
        rodzinka1.addSibling(siostra2);

    }

    @Test
    public void testHowManyBrothers (){

        Integer expectedNoOfBrothers = 3;

        Assert.assertEquals("Niezgodna liczba ", expectedNoOfBrothers,FamilyService.howManyBrothers(rodzinka1));

    }

    @Test
    public void testHowManySisters (){

        Integer expectedNoOfSisters = 2;

        Assert.assertEquals("Niezgodna liczba ", expectedNoOfSisters,FamilyService.howManySisters(rodzinka1));

    }





}
