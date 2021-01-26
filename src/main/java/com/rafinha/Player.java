package com.rafinha;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class Player {
    private String name;
    private String surname;
    private String club;
    private String position;
    private int age;

    public Player(String name, String surname, String club, String position, int age) {
        this.name = name;
        this.surname = surname;
        this.club = club;
        this.position = position;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getClub() {
        return club;
    }

    public String getPosition() {
        return position;
    }

    public int getAge() {
        return age;
    }

    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that, "club");
    }
}
