package pl.sda.kostrowski.readonly;

public interface FindStudent {

    //interfejs wymuszający wszystkie wyszukiwania
    //wyobrażam sobie że tu mogłoby być szukanie po
    //nazwisku, ocenach, roczniku itp.
    Integer findStudentPos(String name, String lastName);

}
