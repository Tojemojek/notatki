package pl.sda.repositiory;


import pl.sda.objects.Game;

//interface - wymusza żeby wszystkie klasy go implementujące miały
//wymienione w nim metody - nie ma mowy jak mają te metody wyglądać
public interface GameRepositiory {

    void save(Game book);
    Game update(Game book);
    Game findGameById(Integer id);


}
