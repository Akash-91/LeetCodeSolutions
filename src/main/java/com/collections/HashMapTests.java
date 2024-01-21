package com.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

/*
    @Override
    public int hashCode() {
        // Using the id for hash code calculation
        return Objects.hash(id);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id;
    }
*/

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return id == user.id && Objects.equals(name, user.name);
    }


    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class HashMapTests {


    public static void main(String[] args) {

        User user1 = new User(1, "John");
        User user2 = new User(2, "Jane");

        Map<User, String> userMap = new HashMap();


        userMap.put(user1, "Admin");
        userMap.put(user2, "User");


        // Retrieving items for user1
        String roleForUser1 = userMap.get(user1);
        System.out.println("Items for user1: " + roleForUser1);

        // Retrieving items for user2
        String roleForUser2 = userMap.get(user2);
        System.out.println("Items for user2: " + roleForUser2);

        // Creating a new User object with the same ID as user1
        User user3 = new User(1, "Jim");

        // Retrieving items for user3
        String roleForUser3 = userMap.get(user3);
        System.out.println("Role for user3: " + roleForUser3);
    }
}
