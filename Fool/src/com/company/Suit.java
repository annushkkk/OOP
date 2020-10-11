package com.company;

enum Suit {
    CLUBS("♣"), DIAMONDS("♦"), HEARTS("♥"), SPADES("♠");

    private String suit;

    Suit(String suit) {
        this.suit = suit;
    }

    public String getSuit() {
        return suit;
    }
    @Override
    public String toString() {
        return String.format("%s", this.suit);
    }
}

