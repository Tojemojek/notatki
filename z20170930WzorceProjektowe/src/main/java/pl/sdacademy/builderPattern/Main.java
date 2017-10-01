package pl.sdacademy.builderPattern;

public class Main {

    public static void main(String[] args) {

        UserWithBuilder.UserBuilder builder = new UserWithBuilder.UserBuilder("K", "O");
        System.out.println(builder.build());

        builder.age(16)
                .address("AAAA")
                .phone("555666777");

        System.out.println(builder.build());


    }
}
