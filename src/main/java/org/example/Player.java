package org.example;

public class Player {
    private String name;
    private int heal;
    private boolean isActive;

    public Player(String name, int heal, boolean isActive) {
        this.name = name;
        this.heal = heal;
        this.isActive = isActive;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public int getHeal() {
        return heal;
    }

    public boolean isActive() {
        return isActive;
    }
}
