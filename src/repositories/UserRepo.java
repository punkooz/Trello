package repositories;

import entities.User;

import java.util.HashMap;

public class UserRepo {

    HashMap<String, User> userHashMap;

    public UserRepo() {
        this.userHashMap = new HashMap<>();
    }

    public void createUser(User user){
        userHashMap.put(user.getEmail(), user);
    }

    public void udpateUser(User user){
        userHashMap.put(user.getEmail(), user);
    }

    public User getUserByEmail(String email){
        return userHashMap.get(email);
    }

    public HashMap<String, User> getUserHashMap() {
        return userHashMap;
    }
}
