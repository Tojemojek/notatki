package pl.sda.javawwa;

public class Main {

    public static void main(String[] args) {


        int[] oceny1 = {1, 2, 2, 2, 3};
        int[] oceny2 = {3, 2, 5, 6, 6};
        int[] oceny3 = {3, 5, 6, 6};
        int[] oceny4 = {5, 6, 5, 5, 6, 5, 4, 5};

        Double avg1 = Calculate.AVR.srednia(oceny1);
        Double avg2 = Calculate.AVR.srednia(oceny2);
        Double avg3 = Calculate.AVR.srednia(oceny3);
        Double avg4 = Calculate.AVR.srednia(oceny4);

        System.out.println(avg1);

//        if (avg1 < 3) {
//            System.out.println(Status.NIEDOSTATECZNY.getOpisUcznia());
//        } else if (avg1 < 4) {
//            System.out.println(Status.SLABY.getOpisUcznia());
//        } else if (avg1 < 5) {
//            System.out.println(Status.DOBRY.getOpisUcznia());
//        } else if (avg1 < 6) {
//            System.out.println(Status.WZOROWY.getOpisUcznia());
//        }

        System.out.println(calcualteStudentStatus(avg1).getOpisUcznia());
        System.out.println(calcualteStudentStatus(avg2).getOpisUcznia());
        System.out.println(calcualteStudentStatus(avg3).getOpisUcznia());
        System.out.println(calcualteStudentStatus(avg4).getOpisUcznia());



    }

    private static Status calcualteStudentStatus(double avg) {
        if (avg < 3) {
            return Status.NIEDOSTATECZNY;
        } else if (avg < 4) {
            return Status.SLABY;
        } else if (avg < 5) {
            return Status.DOBRY;
        } else {
            return Status.WZOROWY;
        }

    }

}