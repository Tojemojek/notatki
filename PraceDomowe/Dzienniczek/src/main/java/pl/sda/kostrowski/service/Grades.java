package pl.sda.kostrowski.service;

public interface Grades {

    //iterface do dodawania / zmiany ocen
    //mogę sobie wymyślić że można zmienić / poprawić / usunąć błędnie wpisaną ocenę

    //cała ta paczka jest oddzielona od reszty
    //bo wydaje mi się że logiczniej jest oddzielić część
    //którą może obsługiwać węższa grupa użytkowników
    //np. tylko nauczyciele
    //od funkcji które mogą być używane szerzej - np. nauczycieli, uczniów, rodziców
    //a do takich bym zaliczył sprawdzanie zagrożeń lub uwag.


    void addGrade(Integer newGrade, String courseName);

}
