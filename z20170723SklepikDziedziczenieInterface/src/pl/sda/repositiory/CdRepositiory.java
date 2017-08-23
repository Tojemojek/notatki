package pl.sda.repositiory;

import pl.sda.objects.Cd;


//interface - wymusza żeby wszystkie klasy go implementujące miały
//wymienione w nim metody - nie ma mowy jak mają te metody wyglądać
public interface CdRepositiory {

    void save(Cd book);
    Cd update(Cd book);
    Cd findCdById(Integer id);


}
