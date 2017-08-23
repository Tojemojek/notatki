package pl.sda.repositiory;

import pl.sda.objects.Cd;

//clasa implementująca 2 interface (można po dowolnie wielu nie tak jak w dziedziczeniu)

public class CdRepositoryImpl implements CdRepositiory, Logable {

    //ponieważ ta klasa nie będzie miała dostępu do
    //tablic main w bezpośredni sposób (są private)
    //a chcemy z nich korzystać to tworzymy sobie
    //tu prywatne pola

    private Cd[] cds;
    private Integer indexOfEmptyCdsPosition;

    //importujemy do naszych lokalnych pól tablicę książek
    public CdRepositoryImpl(Cd[] cds) {
        this.cds = cds;
    }


    //implementacja metody z interface
    @Override
    public void save(Cd cd) {
        Cd foundCd = findCdById(cd.getId());

        if (foundCd == null) {
            indexOfEmptyCdsPosition = getIndexOfEmptyCdsPosition();

            if (isCdAccessibleToAddNewCd()) {
                cds[indexOfEmptyCdsPosition] = cd;
            }

        }

    }

    @Override
    public Cd update(Cd cd) {
        return null;
    }



    //szukanie cd po id
    @Override
    public Cd findCdById(Integer id) {
        //for each
        for (Cd cd : cds) {
            //tu nie można po prostu szukać, bo w którymś momencie
            //jeśli cała tablica nie jest zapełniona byłoby porównanie coś == null i
            //wtedy program się wywali
            if (cdExists(cd,id)) {
                return cd;
            }
        }
        return null;
    }


    @Override
    public void before() {
    }

    @Override
    public void after() {
    }


    private Integer getIndexOfEmptyCdsPosition() {
        Integer index = 0;
        //szukamy wolnego indeksu - jest ryzyko że będzie to index poza wymiarem naszej tablicy
        for (Cd cd : cds) {
            if (cds[index] == null) {
                return index;
            }
            index++;
        }
        return index;
    }


    private Boolean isCdAccessibleToAddNewCd() {
        //sprawdamy czy jest jeszcze wolna pozycja w naszej liście
        return indexOfEmptyCdsPosition != null && indexOfEmptyCdsPosition < cds.length;

    }

    private Boolean cdExists (Cd cd, Integer id){
        //zabezpieczenie przed nullPointer exception + porównywanie książki po id
        //id nie jest typu prymitywnego więc musi być metoda equals
        //porówanie  ==  zawsze da fałsz, bo to jest obiekt i niezaleznie od treści będą
        // różne referencje
        return cd !=null && cd.getId().equals(id);

    }


}
