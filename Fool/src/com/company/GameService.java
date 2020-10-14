package com.company;

import java.util.*;

public class GameService {

    public void initGameWithCards(Game g) {
        ArrayList<Card> allCards = new ArrayList<>();
        Stack<Card> cards = new Stack<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                allCards.add(new Card(rank, suit));
                Collections.shuffle(allCards);
            }
        }
        Card trump = allCards.remove(35);
        g.setTrump(trump);
        cards.push(trump);
        for (Card card : allCards) {
            cards.push(card);
        }
        g.setCards(cards);
    }

    public void initGameWithPlayers(Game g, int playersCount) {
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= playersCount; i++) {
            players.add(new Player(Integer.toString(i)));
        }
        g.setPlayers(players);
    }

    public void play(Game g) {
        //deal cards
        Map<Player, List<Card>> playerToCardsMap = new HashMap<>();
        for (Player p : g.getPlayers()) {
            List<Card> pc = new ArrayList<>();
            for (int i = 0; i < 6; i++) {
                pc.add(g.getCards().pop());
            }
            Collections.sort(pc);
            playerToCardsMap.put(p, pc);
        }
        g.setPlayerToCardsMap(playerToCardsMap);

         System.out.println(g.getCards());
        System.out.println(g.getTrump());
         System.out.println(g.getPlayers());
        System.out.println(g.getPlayerToCardsMap());
        boolean isFirstRound = true;
        boolean isPickedUp = false;
        // Player current = g.getPlayers().get(0);
        int indexCurrentSource = 0;
        List<Round> stepList = new ArrayList<>();
        Player source;
        Player target;
       // while (!isDeckEmpty(g) || isGameAlive(g)) {
            if (isFirstRound) {
                 source = getSourcePlayerFirstTime(g);
                indexCurrentSource = g.getPlayers().indexOf(source);
            } else {
               source= getSourcePlayer(g, indexCurrentSource, isPickedUp);
                indexCurrentSource = g.getPlayers().indexOf(source);
            }
        System.out.println(source);
            if (indexCurrentSource == g.getPlayers().size() - 1) {
                 target = g.getPlayers().get(0);
            } else {
                 target = g.getPlayers().get(indexCurrentSource+1);
            }
        System.out.println(target);
            Round r = new Round();
            r.setSource(source);
            r.setTarget(target);



//            List<Player> truncatedList = ...;
//            while (true) {
//                getNext();
//                r.getFights().add(new Fight());
//                if (count == 0) break;
//            }
//            getFirstCard();
//            Fight f = buildFight();
       // }
    }
    private boolean isThrownUp(Game g){
    if()
    }

    private Player getSourcePlayer(Game g, int indexCurrentSource, boolean isPickedUp) {
        Player player;
        if (!isPickedUp) {
            if (indexCurrentSource == g.getPlayers().size() - 1) {
                indexCurrentSource=0;
              player=  g.getPlayers().get(0);
            } else {
               player= g.getPlayers().get(indexCurrentSource + 1);
            }
        } else {
            if (indexCurrentSource == g.getPlayers().size() - 1) {
                indexCurrentSource=1;
               player= g.getPlayers().get(1);
            } else {
              player=  g.getPlayers().get(indexCurrentSource + 2);
            }
        }
        return  player;
    }

    private Player getSourcePlayerFirstTime(Game g) {
        int minRang = 14;
        int maxRang = 0;
        Card currentCard=g.getTrump();
        if (g.getTrump().getRank().getRank() > 10) {
            outer:
            for (Player p : g.getPlayers()) {
                for (Card c : g.getPlayerToCardsMap().get(p)) {
                    if ((c.getSuit() == g.getTrump().getSuit()) && (c.getRank().getRank() < minRang)) {
                        currentCard = c;
                        minRang = c.getRank().getRank();
                        continue outer;

                    }
                }
            }
        } else {
            outer:
            for (Player p : g.getPlayers()) {
                for (Card c : g.getPlayerToCardsMap().get(p)) {
                    if ((c.getSuit() == g.getTrump().getSuit()) && (c.getRank().getRank() > maxRang)) {
                        currentCard = c;
                        maxRang = c.getRank().getRank();
                        continue outer;

                    }
                }
            }
        }
        for (Player p : g.getPlayers()) {
            if (g.getPlayerToCardsMap().get(p).contains(currentCard)) {
                return p;
            }
        }
        return g.getPlayers().get(0);
    }

    private boolean isGameAlive(Game g) {
        int count = 0;
        for (Player p : g.getPlayers()) {
            if (!isPlayerAlive(p, g)) {
                count++;
            }
        }
        if (!isDeckEmpty(g) && count < 5) {
            return true;
        }
        return false;
    }

    private boolean isPlayerAlive(Player p, Game g) {
        if (!g.getPlayerToCardsMap().get(p).isEmpty() && !isDeckEmpty(g)) {
            return true;
        }
        return false;
    }

    private boolean isDeckEmpty(Game g) {
        if (g.getCards().isEmpty()) {
            return true;
        }
        return false;
    }
}
