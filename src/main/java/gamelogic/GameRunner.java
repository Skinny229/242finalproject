package gamelogic;

import view.AIFrame;
import view.PlayerFrame;
import view.ShipPlacer;

import java.util.Random;

public class GameRunner {

    private static Player player1;
    private static Player player2;


    static int onPlayer = 1;

    public GameRunner()  {
        player1 = new Player();
        player2 = new Player();

        new ShipPlacer(player1);
        new ShipPlacer(player2);


        while(!player1.allShipsPlaced() || !player2.allShipsPlaced()) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }


       //Player vs AI
        new PlayerFrame(player1);
        new AIFrame(player2);


        //Player vs Player

    }

    public static String AIFire() {
        int y = new Random().nextInt(7);
        int x = new Random().nextInt(7);
        System.out.println(y +" + "+ x);

        while(firePlayer2(y,x) == FireResponse.ALREADYFIRED);

        return (String) (y+""+x);
    }


    public PlayerView getPlayer1(){
        return new PlayerView(player1, player2);
    }


    public PlayerView getPlayer2(){
        return new PlayerView(player1, player2);
    }


    public static FireResponse firePlayer1(int y, int x){
        return player2.beingFiredOn(y,x);
    }


    public static FireResponse firePlayer2(int y, int x){
        return player1.beingFiredOn(y,x);
    }


    public int hasWinner(){
        if(!player2.isAllShipsDown() && !player1.isAllShipsDown())
            return 0;
        if(player2.isAllShipsDown())
            return 1;
        else
            return 2;
    }






}
