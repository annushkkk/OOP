package com.company;

import java.util.*;

public class GameService {

    public void initGameWithCards(Game g) {
        ArrayList<Card> allCards = new ArrayList<Card>();
        Stack<Card> cards = new Stack<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                allCards.add(new Card(rank, suit));
                Collections.shuffle(allCards);
            }
        }

        for (Card card : allCards) {
            cards.push(card);
        }
        g.setCards(cards);
    }

    public void initGameWithPlayers(Game g, int playersCount) {
        List<Player> players=new ArrayList<>();
         for (int i=1;i<=playersCount;i++){
             players.add(new Player(Integer.toString(i)));
         }
         g.setPlayers(players);
    }

    public void play(Game g) {
        //deal cards
        Map<Player, List<Card>> playerToCardsMap= new HashMap<>();
        for (Player p:g.getPlayers()) {
            List<Card> pc =new ArrayList<>();
            for (int i=0;i<6;i++){
                pc.add(g.getCards().pop());
            }
              playerToCardsMap.put(p,pc);
        }
        g.setPlayerToCardsMap(playerToCardsMap);

        System.out.println(g.getCards());
        System.out.println(g.getPlayers());
        System.out.println(g.getPlayerToCardsMap());

        Player current = g.getPlayers().get(0);
        while (!isDeckEmpty(g) || isGameAlive(g)) {
                getSourcePlayer();
                Player target = g.getPlayers().getNext(player);
                Round r = new Round(target);
                List<Player> truncatedList = ...;
                while (true) {
                    getNext();
                    r.getFights().add(new Fight());
                    if (count == 0) break;
                }
                getFirstCard();
                Fight f = buildFight();
        }
    }

    private boolean isGameAlive(Game g) {
        int count=0;
        for (Player p:g.getPlayers()) {
              if (!isPlayerAlive(p,g)){
                  count++;
              }
        }
        if(!isDeckEmpty(g)&&count<5){
            return  true;
        }
        return  false;
    }

    private boolean isPlayerAlive(Player p, Game g) {
        if(!g.getPlayerToCardsMap().get(p).isEmpty()&& !isDeckEmpty(g)){
            return  true;
        }
        return false;
    }

    private boolean isDeckEmpty(Game g) {
        if(g.getCards().isEmpty()){
            return true;
        }
        return false;
    }
}
