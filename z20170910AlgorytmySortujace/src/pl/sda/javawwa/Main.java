package pl.sda.javawwa;

public class Main {

    public static void main(String[] args) {

        System.out.println(silnia(60));

    }

    public static long silnia(long wartosc) {
        if (wartosc == 0) {
            System.out.print(1 + " = ");
            return 1;
        } else {
            System.out.print(wartosc+ " * ");
            return wartosc * silnia(wartosc - 1);
        }
    }
}