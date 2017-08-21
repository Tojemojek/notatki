package pl.sda.javawwa.myError;

public class NumberChecker {



    public Integer isANumber(String daneTestowe) throws MojWyjatek {
        try {
            Integer.valueOf(daneTestowe);
            return Integer.valueOf(daneTestowe);
        } catch (NumberFormatException e) {
            throw new MojWyjatek("To jest mój wyjątek", e);
        }

    }


}
