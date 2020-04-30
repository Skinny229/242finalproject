package gamelogic;

public class Player {


    private final static int maxHits = 12;

    private int hitCount;
    private Block[][] table = new Block[8][8];

    public Player(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                table[i][j] = new Block();
        }
    }



    public Block[][] getTable(){
        return table;
    }


    boolean[][] getTableAsEnemy(){
        boolean[][] asEnemy = new boolean[8][8];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                asEnemy[i][j] = table[i][j].blockStatus == FireRepsonse.HIT;
        }
        return asEnemy;
    }


    FireRepsonse beingFiredOn(int x, int y){
        FireRepsonse response  = table[x][y].reciveFire();
        if (response == FireRepsonse.HIT)
            hitCount++;
        return response;
    }


    boolean isAllShipsDown(){
        return hitCount >= maxHits;
    }
}
