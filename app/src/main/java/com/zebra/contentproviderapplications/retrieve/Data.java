package com.zebra.contentproviderapplications.retrieve;

public class Data {
    public Data(String name, String age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    String name,age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
