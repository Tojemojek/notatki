package pl.sda.javawwa.streamCwiczenia;

import com.sun.org.apache.xpath.internal.SourceTree;
import pl.sda.javawwa.streamCwiczenia.Util.CsvReader;
import pl.sda.javawwa.streamCwiczenia.Util.PersonaConverter;
import pl.sda.javawwa.streamCwiczenia.model.Gender;
import pl.sda.javawwa.streamCwiczenia.model.Person;

import java.util.*;
import java.util.stream.Collectors;

public class StreamCwiczenia {


    public static void main(String[] args) {

        String path = "baza.csv";

        List<String[]> people = CsvReader.readCsvFile(path);
        List<String[]> peopleFromString = CsvReader.readCsvFileByStream(path);

        System.out.println("\nWyświetl liczbę linii zaczytanych z pliku");
        System.out.println(people.size());

        System.out.println("\nWyświetl liczbę linii zaczytanych z pliku używając stream");
        System.out.println(peopleFromString.size());

        System.out.println("\nWyświetl liczbę obiektów skonwertowanych");
        List<Person> mojeOsobyTestowe = PersonaConverter.convertFromListArrays(people);

        System.out.println(mojeOsobyTestowe.size());
        System.out.println(mojeOsobyTestowe.get(13));

        System.out.println("\nZabawy streamami i pętlami");
        System.out.println("\nPierwsze 20 osób z nawiększymi dochodami wykorzystując streamem");

        List<Person> max20Salaries = mojeOsobyTestowe.stream()
                .sorted((o1, o2) -> -1 * o1.getSalary().compareTo(o2.getSalary()))
                .limit(20)
                .collect(Collectors.toList());

        max20Salaries.forEach(p -> System.out.println(String.format("Nazwisko %15s, \t pensja %d", p.getSurname(), p.getSalary())));

        System.out.println("\nPierwsze 20 osób z nawiększymi dochodami pętlą for each");

        List<Person> max20SalariesFE = new ArrayList<>(mojeOsobyTestowe);

        Collections.sort(max20SalariesFE, (o1, o2) -> o2.getSalary().compareTo(o1.getSalary()));

        for (int i = 0; i < 20; i++) {
            System.out.println(String.format("Nazwisko %15s, \t pensja %d", max20SalariesFE.get(i).getSurname(), max20SalariesFE.get(i).getSalary()));
        }


        System.out.println("\nOsoby z nazwiskiem na literę C wykorzystując stream");

        List<Person> startsWithC = mojeOsobyTestowe.stream()
                .filter(s -> s.getSurname().startsWith("C"))
                .collect(Collectors.toList());


        startsWithC.forEach(p -> System.out.println(String.format("Nazwisko %15s, imię %15s", p.getSurname(), p.getName())));


        System.out.println("\nOsoby z nazwiskiem na literę C wykorzystując pętle");

        List<Person> startsWithCFE = new ArrayList<>();
        for (Person osobaTmp : mojeOsobyTestowe) {
            if (osobaTmp.getSurname().startsWith("C")) {
                startsWithCFE.add(osobaTmp);
            }
        }

        startsWithCFE.forEach(p -> System.out.println(String.format("Nazwisko %15s, imię %15s", p.getSurname(), p.getName())));

        System.out.println("\nUnikalne nazwiska na literę C z wykorzystaniem stream");
        Set<String> startsSetWithC = mojeOsobyTestowe.stream()
                .map(s -> s.getSurname())
                .filter(s -> s.startsWith("C"))
                //.distinct - zwraca tylko unikalne wartość - to jest metoda zamiast stosowania set
                .collect(Collectors.toSet());

        startsSetWithC.forEach(p -> System.out.println(String.format("Nazwisko %15s", p)));

        System.out.println("\nUnikalne nazwiska na literę C z wykorzystaniem stream");
        Set<String> startsSetWithCFE = new HashSet<>();

        for (Person osobaTmp : mojeOsobyTestowe) {
            if (osobaTmp.getSurname().startsWith("C")) {
                startsSetWithCFE.add(osobaTmp.getSurname());
            }
        }
        startsSetWithCFE.forEach(p -> System.out.println(String.format("Nazwisko %15s", p)));

        System.out.println("\nŚrednia zarobków dla osób w przedziale wieku 21 ÷ 30 z wykorzystaniem stream");

        OptionalDouble optAverage = mojeOsobyTestowe.stream()
                .filter(s -> s.getAge() > 20 && s.getAge() < 31)
                .mapToInt(s -> s.getSalary())
                .average();

        Double average = optAverage.getAsDouble();
        System.out.println(average);


        System.out.println("\nŚrednia zarobków dla osób w przedziale wieku 21 ÷ 30 z wykorzystaniem for each");

        Double averageFE = 0D;
        Integer sumFE = 0;
        Integer countFE = 0;
        for (Person osobaTmp : mojeOsobyTestowe) {
            if (osobaTmp.getAge() > 20 && osobaTmp.getAge() < 31) {
                sumFE += osobaTmp.getSalary();
                countFE++;
            }
        }
        averageFE = (double) sumFE / (double) countFE;
        System.out.println(averageFE);

        System.out.println("\nLiczba kobiet i mężczyzn z wykorzystaniem stream");

        long howManyMales = mojeOsobyTestowe.stream()
                .filter(s -> s.getGender() == Gender.MALE)
                .count();

        long howManyFemales = mojeOsobyTestowe.stream()
                .filter(s -> s.getGender() == Gender.FEMALE)
                .count();

        System.out.println(String.format("Mężczyzn jest %d, kobiet %d", howManyMales, howManyFemales));

        Integer maleCount = 0;
        Integer femaleCount = 0;

        System.out.println("\nLiczba kobiet i mężczyzn z wykorzystanie for each");
        for (Person osobaTmp : mojeOsobyTestowe) {
            if (osobaTmp.getGender().equals(Gender.MALE)) {
                maleCount++;
            } else {
                femaleCount++;
            }
        }
        System.out.println(String.format("Mężczyzn jest %d, kobiet %d", maleCount, femaleCount));





        System.out.println("\nŚrednia zarobków dla danego stanowiska stream");

        Map<String, Double> daneDoSrZarobkow = mojeOsobyTestowe.stream()
                .collect(Collectors.groupingBy(s -> s.getOccupation(), Collectors.averagingInt(s -> s.getSalary())));

        daneDoSrZarobkow.entrySet().forEach(s ->
                System.out.print(String.format("\nZawód %s, średnia %f",
                        s.getKey(), s.getValue())));


        System.out.println("\nŚrednia zarobków dla danego stanowiska for Each");
        Map<String, Integer[]> daneDoSrZarobkowFE = new TreeMap<>();

        for (Person osobaTmp : mojeOsobyTestowe) {
            if (daneDoSrZarobkowFE.containsKey(osobaTmp.getOccupation())) {
                Integer[] tmpDblArr = {0, 0};
                tmpDblArr[0] = daneDoSrZarobkowFE.get(osobaTmp.getOccupation())[0] + osobaTmp.getSalary();
                tmpDblArr[1] = daneDoSrZarobkowFE.get(osobaTmp.getOccupation())[1] + 1;
                daneDoSrZarobkowFE.replace(osobaTmp.getOccupation(), tmpDblArr);
            } else {
                Integer[] tmpDblArr = {0, 0};
                tmpDblArr[0] = osobaTmp.getSalary();
                tmpDblArr[1] = 1;
                daneDoSrZarobkowFE.put(osobaTmp.getOccupation(), tmpDblArr);
            }
        }

        daneDoSrZarobkowFE.entrySet().forEach(s ->
                System.out.print(String.format("\nZawód %s, liczba pracujących w zawodzie %d, łączne zarobki %d, średnia %f",
                        s.getKey(), s.getValue()[1], s.getValue()[0], 1.0 * s.getValue()[0] / s.getValue()[1])));


         System.out.println("\nIlość osób pracujących w danym mieście stream");

        Map<String, Long> dataNoOfPeopleInCities = mojeOsobyTestowe.stream()
                .collect(Collectors.groupingBy(s -> s.getCity(), Collectors.counting()));

        dataNoOfPeopleInCities.entrySet()
                .forEach(s->System.out.println(String.format("Miasto - %s, mieszkańców - %d",s.getKey(),s.getValue())));

        System.out.println("\nIlość osób pracujących w danym mieście for Each");

        Map<String, Integer> dataNoOfPeopleInCities2 =new TreeMap<>();

        for (Person p: mojeOsobyTestowe){
            if (dataNoOfPeopleInCities2.containsKey(p.getCity())) {
                dataNoOfPeopleInCities2.replace(p.getCity(), dataNoOfPeopleInCities2.get(p.getCity())+1);
            } else {
                dataNoOfPeopleInCities2.put(p.getCity(), 1);
            }

        }


        dataNoOfPeopleInCities2.entrySet()
                .forEach(s->System.out.println(String.format("Miasto - %s, mieszkańców - %d",s.getKey(),s.getValue())));



    }
}
