package pl.sda.javawwa.sklepik.builder;

import pl.sda.javawwa.sklepik.domain.Client;

public class ClientBuilder {

    private String firstName;
    private String secondName;
    private String login;
    private Client.ClientType type;

    public ClientBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public ClientBuilder secondName(String secondName){
        this.secondName = secondName;
        return this;
    }

    public ClientBuilder login(String login){
        this.login = login;
        return this;
    }

    public ClientBuilder type(Client.ClientType type){
        this.type = type;
        return this;
    }

    public Client build(){
        return new Client(firstName, secondName, login, type);
    }

}
