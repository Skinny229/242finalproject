package gamelogic;

public class GameRunner {

    private Player player1;
    private Player player2;


    public GameRunner(){
        player1 = new Player();
        player2 = new Player();
    }




    public PlayerView getPlayer1(){
        return new PlayerView(player1, player2);
    }


    public PlayerView getPlayer2(){
        return new PlayerView(player1, player2);
    }

    public boolean placeShipPlayer1(){}

    public boolean placeShipPlayer2(){}




    public FireRepsonse firePlayer1(int x, int y){
        return player2.beingFiredOn(x,y);
    }


    public FireRepsonse firePlayer2(int x, int y){
        return player1.beingFiredOn(x,y);
    }


    public boolean hasWinner(){
        return false; //TODO::IMPLEMENT ME
    }






}
