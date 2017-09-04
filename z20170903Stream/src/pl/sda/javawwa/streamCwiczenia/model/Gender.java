package pl.sda.javawwa.streamCwiczenia.model;

public enum Gender {
    MALE, FEMALE;



    public static Gender getGender (String value){
        for (Gender gender : values()){
            if (gender.toString().toLowerCase().equals(value)){
                return gender;
            }
        }
        return null;
    }





}
