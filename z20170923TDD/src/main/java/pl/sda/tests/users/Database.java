package pl.sda.tests.users;

import pl.sda.tests.users.exceptions.UserExistsException;
import pl.sda.tests.users.exceptions.UserNotExistException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Database {

    private Set<User> users = new HashSet<User>();

    public void addUser(User user) throws UserExistsException {
        if (!users.add(Objects.requireNonNull(user))) {
            throw new UserExistsException("User with username " + user.getUsername() + "already exists in database");
        }
    }

    public void removeUser(User user) throws UserNotExistException {
        if (!users.remove(Objects.requireNonNull(user))) {
            throw new UserNotExistException("User with username " + user.getUsername() + "does not exist in database");
        }
    }

    public User getUser(String username) throws UserNotExistException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        throw new UserNotExistException("User with username " + username + "does not exist in database");
    }

    public Set<User> getUsers() {
        return users;
    }


    public boolean login(User user) {

        try {
            if (getUser(user.getUsername()).equals(user)) {
                return true;
            }
        } catch (UserNotExistException e) {
            return false;
        }
            return false;
    }

}
