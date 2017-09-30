package pl.sdacademy.singleton;

public class Main {
    public static void main(String[] args) {

    	System.out.println("Inside main()\n");

        EagerCreatedSingleton aaa = EagerCreatedSingleton.getInstance();
        EagerCreatedSingleton bbb = EagerCreatedSingleton.getInstance();

        if (aaa == bbb){
            System.out.println("to samo");
        } else {
            System.out.println("nie to samo");
        }

        System.out.println("\n++++++++++++++\n");


        System.out.println(Main.class.getSimpleName());
        System.out.println(Main.class.getCanonicalName());

        System.out.println("\n++++++++++++++");


        SingletonByBillPugh.getInstance();



        SingletonByBillPugh.print();






    }
}
