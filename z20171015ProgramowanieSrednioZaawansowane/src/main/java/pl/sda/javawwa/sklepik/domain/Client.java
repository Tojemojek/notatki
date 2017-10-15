package pl.sda.javawwa.sklepik.domain;

public class Client {

    private String firstName;
    private String secondName;
    private String login;
    private ClientType type;

    public enum ClientType {

        REGULAR("Regular client in store"), VIP("Very important Client");

        private String value;

        ClientType(String value) {
            this.value = value;
        }
    }

    public Client(String firstName, String secondName, String login, ClientType type) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.login = login;
        this.type = type;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", type=" + type +
                '}';
    }
}
