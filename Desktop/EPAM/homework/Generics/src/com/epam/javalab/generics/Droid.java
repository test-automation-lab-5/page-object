package com.epam.javalab.generics;

public class Droid {
    private String name;
    private int health;

    public Droid() {
    }

    public Droid(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public String toString() {
        return String.format("Droid %s", name);}
}
