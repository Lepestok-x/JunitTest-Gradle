package org.example;

public class Player {
    private String name;
    private int heal;
    public Player(String name, int heal) {
        this.name = name;
        this.heal = heal;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getHeal() {
        return heal;
    }
}
