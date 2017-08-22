package pl.sda.kostrowski.readonly;

public interface InDanger {

    //interfejs wymuszający wyszukiawanie wszelkich zagrożeń
    //wyobrażam sobie że tu mogłoby być szukanie po
    //ocenach, uwagach, zagrożeniach itp.

    Boolean willPass ();
    Boolean isNice();

}
