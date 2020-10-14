package com.company;


public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        GameService svc = new GameService();
        svc.initGameWithCards(g);
        svc.initGameWithPlayers(g, 4);
        svc.play(g);
//        List<Player> cl=new ArrayList<>();
//        ListIterator<Player> iter = cl.listIterator();
//
//
//        for(int i =0;i<=10;i++){
//
//            System.out.println(iter.next());
//
//        }


    }
}
