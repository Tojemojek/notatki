package pl.sda.javawwa.hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "email")
    private String email;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ClientType type;

    public Client() {
    }

    public Client(String firstName, String secondName, String email, ClientType type) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.email = email;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getEmail() {
        return email;
    }

    public ClientType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}