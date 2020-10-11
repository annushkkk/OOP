package com.company;

public class Player {
    private String name;

    public Player(String name) {
        this.name = name;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Player");
        sb.append(name);
        return sb.toString();
    }
}
