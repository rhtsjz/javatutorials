package com.github.rhtsjz.json.org;

public class Bear {
    private String name;
    private int age;
    private int ID;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getID() {
        return ID;
    }

    public Bear(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Bear(String name, int age, int ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }
}
