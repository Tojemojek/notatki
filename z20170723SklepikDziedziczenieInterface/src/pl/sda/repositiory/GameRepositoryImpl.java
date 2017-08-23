package pl.sda.repositiory;

import pl.sda.objects.Game;

//clasa implementująca 2 interface (można po dowolnie wielu nie tak jak w dziedziczeniu)

public class GameRepositoryImpl implements GameRepositiory, Logable {

    //ponieważ ta klasa nie będzie miała dostępu do
    //tablic main w bezpośredni sposób (są private)
    //a chcemy z nich korzystać to tworzymy sobie
    //tu prywatne pola

    private Game[] games;
    private Integer indexOfEmptyGamesPosition;

    //importujemy do naszych lokalnych pól tablicę książek
    public GameRepositoryImpl(Game[] games) {
        this.games = games;
    }


    //implementacja metody z interface
    @Override
    public void save(Game game) {
        Game foundGame = findGameById(game.getId());

        if (foundGame == null) {
            indexOfEmptyGamesPosition = getIndexOfEmptyGamesPosition();

            if (isGameAccessibleToAddNewGame()) {
                games[indexOfEmptyGamesPosition] = game;
            }

        }

    }

    @Override
    public Game update(Game game) {
        return null;
    }



    //szukanie Game po id
    @Override
    public Game findGameById(Integer id) {
        //for each
        for (Game game :games) {
            //tu nie można po prostu szukać, bo w którymś momencie
            //jeśli cała tablica nie jest zapełniona byłoby porównanie coś == null i
            //wtedy program się wywali
            if (gameExists(game,id)) {
                return game;
            }
        }
        return null;
    }


    @Override
    public void before() {
    }

    @Override
    public void after() {
    }


    private Integer getIndexOfEmptyGamesPosition() {
        Integer index = 0;
        //szukamy wolnego indeksu - jest ryzyko że będzie to index poza wymiarem naszej tablicy
        for (Game game : games) {
            if (games[index] == null) {
                return index;
            }
            index++;
        }
        return index;
    }


    private Boolean isGameAccessibleToAddNewGame() {
        //sprawdamy czy jest jeszcze wolna pozycja w naszej liście
        return indexOfEmptyGamesPosition != null && indexOfEmptyGamesPosition < games.length;

    }

    private Boolean gameExists (Game game, Integer id){
        //zabezpieczenie przed nullPointer exception + porównywanie książki po id
        //id nie jest typu prymitywnego więc musi być metoda equals
        //porówanie  ==  zawsze da fałsz, bo to jest obiekt i niezaleznie od treści będą
        // różne referencje
        return game !=null && game.getId().equals(id);

    }


}
