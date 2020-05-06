package controller;

import model.Direction;
import model.PlayerView;
import model.FireResponse;
import model.Player;
import view.*;

import javax.swing.*;
import java.util.Random;

public class GameRunner {

    private static Player player1;
    private static Player player2;


    static int onPlayer = 1;

    public GameRunner() {
        player1 = new Player(1);
        player2 = new Player(2);


        //aiGameSetup();
        pvp();


    }


    private void aiGameSetup() {
        new ShipPlacer(player1);

        placeShipsRandom();


        //Wait for ship placement to be done
        while (!player1.allShipsPlaced() || !player2.allShipsPlaced()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
        }

        //Player vs AI
        JFrame playerView = new PlayerFrame(player1);
        JFrame aiEnemyView = new AIFrame(player2);


        while (hasWinner() == 0) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
        }

        playerView.setVisible(false);
        aiEnemyView.setVisible(false);


        System.out.println("Congrats to player: " + hasWinner());
    }


    private void placeShipsRandom() {

        do {
            Direction dir;
            switch (new Random().nextInt(3)) {
                case 0:
                    dir = Direction.UP;
                    break;
                case 1:
                    dir = Direction.DOWN;
                    break;
                case 2:
                    dir = Direction.LEFT;
                    break;
                case 3:
                    dir = Direction.RIGHT;
                    break;
                default:
                    dir = Direction.UP;
            }
            int y = new Random().nextInt(7);
            int x = new Random().nextInt(7);
            player2.setShip(y, x, dir);

        } while (!player2.allShipsPlaced());

    }

    public synchronized static String AIFire() {


        int y;
        int x;
        FireResponse fire;
        do {
            y = new Random().nextInt(7);
            x = new Random().nextInt(7);
            fire = firePlayer2(y, x);
            System.out.println(y + " + " + x);
        }
        while (fire == FireResponse.ALREADY_FIRED);

        player1.getTable()[y][x].blockLabel.setIcon(fire == FireResponse.HIT ? ImageLoader.getShipHit() : ImageLoader.getWaterHit());

        return (String) (y + "" + x);
    }


    private void pvp() {


        //Place ships for player 1
        new ShipPlacer(player1);

        //Sleep main thread while we wait
        while (!player1.allShipsPlaced()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
        }


        //Place ships for player 2
        new ShipPlacer(player2);
        //sleep main thread while we wait
        while (!player2.allShipsPlaced()) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {

            }
        }

        //Intianciate pvp views
        SelfView selfView = new SelfView();
        EnemyView enemyView = new EnemyView();

        while (true) {


            //Generate 2 dimension arrays of enums for rendering
            PlayerView model = new PlayerView(player2, player1);

            //render the views
            selfView.setPlayerView(model.getSelf(), player2);
            enemyView.setPlayerView(model.getEnemy(), player1);

            //Wait for player 2 FIRE
            while (!enemyView.hasFired()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }


            if (hasWinner() != 0)
                break;


            //Wait for Player 2 pressing CONTINUE
            selfView.hideAndWait(player1.getPlayerNumber());
            while (!selfView.continueFlag()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }

            System.out.println("Swtichin  views");


            //Same procedure except for player 2 it's for player 1

            PlayerView model2 = new PlayerView(player1, player2);
            selfView.setPlayerView(model2.getSelf(), player1);
            enemyView.setPlayerView(model2.getEnemy(), player2);

            while (!enemyView.hasFired()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }

            if (hasWinner() != 0)
                break;

            selfView.hideAndWait(player2.getPlayerNumber());
            while (!selfView.continueFlag()) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {

                }
            }


        }

        selfView.setVisible(false);
        selfView.setVisible(false);

        //print out winner
        System.out.println("Congrats to winner... :" + hasWinner());


    }


    public synchronized static FireResponse firePlayer1(int y, int x) {
        return player2.beingFiredOn(y, x);
    }


    public synchronized static FireResponse firePlayer2(int y, int x) {
        return player1.beingFiredOn(y, x);
    }


    public int hasWinner() {
        if (!player2.isAllShipsDown() && !player1.isAllShipsDown())
            return 0;
        if (player2.isAllShipsDown())
            return 1;
        else
            return 2;
    }


}
