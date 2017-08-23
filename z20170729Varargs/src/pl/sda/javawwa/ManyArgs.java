package pl.sda.javawwa;

public class ManyArgs {

    public static int calculateSum (int... numbers) {
        int sum = 0;

        for (int i=0; i < numbers.length; i++){
            sum+= numbers[i];
        }
        return sum;
    }

}
