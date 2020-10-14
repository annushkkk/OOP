package com.company;

import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Game {
    private Card trump;
    private List<Player> players;
private Stack<Card> cards;
private Map<Player, List<Card>> playerToCardsMap;
private List<Round> stepList;

    public List<Round> getStepList() {
        return stepList;
    }

    public void setStepList(List<Round> stepList) {
        this.stepList = stepList;
    }

    public Map<Player, List<Card>> getPlayerToCardsMap() {
        return playerToCardsMap;
    }

    public void setPlayerToCardsMap(Map<Player, List<Card>> playerToCardsMap) {
        this.playerToCardsMap = playerToCardsMap;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Card getTrump() {
        return trump;
    }

    public void setTrump(Card trump) {
        this.trump = trump;
    }
}
