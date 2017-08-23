package pl.cdacademy.javawwa4weekend.Klient;

import java.util.LinkedList;


public class Klient {

    //chciałem mieć indywidualny identyfikator dla każdego klienta
    private static Integer id = 0;
    private Integer idKlient;
    //koniec chcenia

    private String name;
    private String surname;
    private Integer age;
    private Double[] expenseInMonths = new Double[12];


    //to powinna być cecha klienta (dzięki temu liczy się raz
    //aktualizować powinno się przy zmianie wydatków, ale tego nie robię
    //bo nie definiuję wydatków
    private Double totalSpend;

    //chcę mieć wszystkich zainicjowanych klientów w jednej liście
    //bo wtedy mogę korzystać z pętli for-each
    private static LinkedList<Klient> listaKlientow = new LinkedList<Klient>();


    public Klient(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        listaKlientow.add(this);

        // tak na wszelki wypadek
        totalSpend = 0.0;

        // indywidualne ID
        // to zachcianka z caveofprogramming.com
        this.id++;
        idKlient = this.id;

    }

    public static LinkedList<Klient> getListaKlientow() {
        return listaKlientow;
    }


    public void setExpenseInMonth(Integer month, Double expenseInMonth) {
        this.expenseInMonths[month] = expenseInMonth;
    }

    public Double getExpenseInMonth(Integer month) {
        return expenseInMonths[month];
    }

    public Double getTotalSpend() {
        return totalSpend;
    }

    public void setTotalSpend(Double totalSpend) {
        this.totalSpend = totalSpend;
    }

    // tylko do debugu i sprawdzenia czy działa jak należy
    public void printExpenses() {
        System.out.println(this);
        for (int i = 0; i < 12; i++) {
            System.out.print(this.getExpenseInMonth(i) + " ");
        }
        System.out.println();

    }

    @Override
    public String toString() {
        return  name + " " + surname + " w wieku " + age + " lat, łączne wydatki: " + totalSpend;
    }

}







