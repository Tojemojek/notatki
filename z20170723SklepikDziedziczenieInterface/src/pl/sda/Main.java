package pl.sda;

import pl.sda.objects.Book;
import pl.sda.objects.Cd;
import pl.sda.objects.Game;
import pl.sda.repositiory.*;
import pl.sda.service.PriceCalculatorBook;
import pl.sda.service.PriceCalculatorCd;
import pl.sda.service.PriceCalculatorGame;

public class Main {

    // definiujemy sobie tablicę na przechowywanie obiektów
    // static żeby można się było ze static metod odwołać
    // w klasie main bo będziemy tylko tu tą tablice wykorzystywać
    private static Book[] books = new Book[10];
    private static Cd[] cds = new Cd[10];
    private static Game[] games = new Game[10];


    public static void main(String[] args) {

        // wybieg żeby było ładnie i czysto w metodzie main
        // dzięki temu inicjalizujemy aplikację
        initializeApp();

        System.out.println("Blok poświęcony książkom");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // blok dotyczący książek
        //korzystamy z polimorfizmu
        //tworzymy obiekt z implementacji interface
        BookRepositiory bookRepositiory = new BookRepositoryImpl(books);
        Book bookTmp;

        bookTmp = bookRepositiory.findBookById(5);
        //sprawdzam czy książka o nr 5 istnieje (powinien być null bo w inicjalizacji są tylko 4
        System.out.println("Jeśli poniżej będzie null to jest ok ");
        System.out.println(bookTmp);
        System.out.println("++++++++++++++++++++++++");


        //tworze książkę od id 5
        Book book5 = new Book("Na", 100, 10, 5);

        //wykorzystuję metodę .save aby dodac książkę do mojej " biblioteki"
        bookRepositiory.save(book5);

        //sprawdzam czy się dodałast
        System.out.println("Poniżej jest to wyświetlony toString z książki którą dodałem (oby) ");
        bookTmp = bookRepositiory.findBookById(5);

        //patrze co da toString dla znalezionej ksiazki
        // powinno dac to samo co dodałem wyżej jako book5
        System.out.println(bookTmp);


        System.out.println();
        System.out.println();
        System.out.println("A teraz blok CD");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // blok dotyczący cd
        //korzystamy z polimorfizmu
        //tworzymy obiekt z implementacji interface
        CdRepositiory cdRepositiory = new CdRepositoryImpl(cds);
        Cd cdTmp;

        cdTmp = cdRepositiory.findCdById(5);
        //sprawdzam czy cd o nr 5 istnieje (powinien być null bo w inicjalizacji są tylko 4
        System.out.println("Jeśli poniżej będzie null to jest ok ");
        System.out.println(cdTmp);
        System.out.println("++++++++++++++++++++++++");


        //tworze cd od id 5
        Cd cd5 = new Cd("Był", 100, 10, 5);

        //wykorzystuję metodę .save aby dodac cd do mojej " biblioteki"
        cdRepositiory.save(cd5);

        //sprawdzam czy się dodało
        System.out.println("Poniżej jest to wyświetlony toString z cd którą dodałem (oby) ");
        cdTmp = cdRepositiory.findCdById(5);

        //patrze co da toString dla znalezionej cd
        // powinno dac to samo co dodałem wyżej jako cd5
        System.out.println(cdTmp);


        System.out.println();
        System.out.println();
        System.out.println("A teraz blok Gry");
        // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        // blok dotyczący gier
        //korzystamy z polimorfizmu
        //tworzymy obiekt z implementacji interface
        GameRepositiory gamesRepositiory = new GameRepositoryImpl(games);
        Game gameTmp;

        gameTmp = gamesRepositiory.findGameById(5);
        //sprawdzam czy gra o nr 5 istnieje (powinien być null bo w inicjalizacji są tylko 4
        System.out.println("Jeśli poniżej będzie null to jest ok ");
        System.out.println(gameTmp);
        System.out.println("++++++++++++++++++++++++");


        //tworze grę od id 5
        Game game5 = new Game("Bo potem kicha", 100, 10, 5);

        //wykorzystuję metodę .save aby dodac grę do mojej " biblioteki"
        gamesRepositiory.save(game5);

        //sprawdzam czy się dodało
        System.out.println("Poniżej jest to wyświetlony toString z gry którą dodałem (oby) ");
        gameTmp = gamesRepositiory.findGameById(5);

        //patrze co da toString dla znalezionej cd
        // powinno dac to samo co dodałem wyżej jako cd5
        System.out.println(gameTmp);


    }


    //metoda na inicjalizację rożnych rodzajów danych
    // zaczynamy od dodania książek
    private static void initializeApp() {

        initializeBooks();
        initializeCds();
        initializeGames();

    }

    // metoda żeby dodać kilka książek do bazy danych
    private static void initializeBooks() {
        Book book1 = new Book("Świat", 100, 30, 1);
        Book book2 = new Book("Dysku", 90, 25, 2);
        Book book3 = new Book("Jest", 80, 20, 3);
        Book book4 = new Book("Najlepszy", 70, 15, 4);

        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;

    }


    // metoda żeby dodać kilka Cd do bazy danych
    private static void initializeCds() {
        Cd cd1 = new Cd("Frank", 100, 30, 1);
        Cd cd2 = new Cd("Sinatra", 90, 25, 2);
        Cd cd3 = new Cd("wybitnym", 80, 20, 3);
        Cd cd4 = new Cd("śpiewakiem", 70, 15, 4);

        cds[0] = cd1;
        cds[1] = cd2;
        cds[2] = cd3;
        cds[3] = cd4;

    }

    // metoda żeby dodać kilka gier do bazy danych
    private static void initializeGames() {
        Game game1 = new Game("Fallout", 100, 30, 1);
        Game game2 = new Game("super", 90, 25, 2);
        Game game3 = new Game("grą", 80, 20, 3);
        Game game4 = new Game("do numeru 2 jest", 70, 15, 4);

        games[0] = game1;
        games[1] = game2;
        games[2] = game3;
        games[3] = game4;

    }

}


//Zadanie 1
//
//        Cd cd1 = new Cd("Coldplay", 100);
//        Game game1 = new Game("Fallout", 100);
//        Book book1 = new Book("Świat Dysku", 100, PriceCalculatorBook.BOOK_MARGIN,10);
//
//
//        PriceCalculatorBook bookService = new PriceCalculatorBook();
//        Integer productPriceWithMargin = bookService.calculatePrice(book1);
//
//        System.out.println("Cena książki: " + productPriceWithMargin);
//
//
//        PriceCalculatorCd cdService = new PriceCalculatorCd();
//        productPriceWithMargin = cdService.calculatePrice(cd1);
//
//        System.out.println("Cena CD: " + productPriceWithMargin);
//
//
//        PriceCalculatorGame gameService = new PriceCalculatorGame();
//        productPriceWithMargin = gameService.calculatePrice(game1);
//
//        System.out.println("Cena game: " + productPriceWithMargin);
//
//
//        BookRepositiory bookRepositiory = new BookRepositoryImpl();