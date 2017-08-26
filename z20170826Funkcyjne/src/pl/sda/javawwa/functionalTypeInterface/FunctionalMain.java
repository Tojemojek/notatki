package pl.sda.javawwa.functionalTypeInterface;

public class FunctionalMain {

    public static void main(String[] args) {

        Computable adder = (a, b) -> a + b;
        Computable substract = (a, b) -> a - b;

        System.out.println(adder.compute(5, 6));
        System.out.println(substract.compute(5, 6));

        StringPerformance deleteEverySecondChar = (s) -> {
            StringBuilder sb = new StringBuilder();
            char[] chars = s.toCharArray();

            for (int i = 0; i < s.length(); i += 2) {
                sb.append(chars[i]);
            }
            return sb.toString();
        };


        System.out.println("Wyrzucone znaki " + deleteEverySecondChar.perform("a1a2a3a4a5"));


        StringPerformance howManyVowels = (s) -> {
            int ileSamoglosek = 0;

            s = s.toLowerCase();

            char[] samogloski = {'a', 'e', 'o', 'i', 'u', 'y',};

            for (int i = 0; i < samogloski.length; i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (samogloski[i] == s.charAt(j)) {
                        ileSamoglosek++;
                    }
                }
            }
            return String.valueOf(ileSamoglosek);
        };

        System.out.println("Łącznie mamy samogłosek " + howManyVowels.perform("qwertyuiop"));

        //przykład odpowiednik klasy anonimowej
        Computable adder2 = new Computable() {
            @Override
            public int compute(int a, int b) {
                return a + b;
            }


        };


    }

}
