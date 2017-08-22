package pl.sda.javawwa.enumexample;

public enum DniTygodnia {

    PONIEDZIALEK, WTOREK, SRODA, CZWARTEK, PIATEK, SOBOTA, NIEDZIELA;

   public String returnDayOfWeek (){
        switch (this) {
            case PONIEDZIALEK:
                return "Poniedziałek jest pierwszym dniem tygodnia";
            case WTOREK:
                return "Wtorek jest drugim dniem tygodnia";
            case SRODA:
                return "Środa jest trzecim dniem tygodnia";
            case CZWARTEK:
                return "Czwartek jest czwartym dniem tygodnia";
            case PIATEK:
                return "Piątek jest piątym dniem tygodnia";
            case SOBOTA:
                return "Sobota jest szóstym dniem tygodnia";
            case NIEDZIELA:
                return "Niedziela jest siódmym dniem tygodnia";
            default:
                throw new AssertionError("dupa");
        }


    }

}
