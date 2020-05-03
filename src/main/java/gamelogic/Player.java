package gamelogic;

public class Player {


    private final static int maxHits = 12;

    private int shipPlacedCount = 0;

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


    public boolean setShip(int y , int x, Direction direction){
        //check in bounds
        switch (direction){
            case UP:
                if(y < 2)
                    return false;
                break;
            case DOWN:
                if( y > 5)
                    return false;
                break;
            case LEFT:
                if(x > 2)
                    return false;
                break;
            case RIGHT:
                if(x < 5)
                    return false;
                break;
        }
        //Check for overlap
        switch (direction){
            case UP:
                for(int i = y; i > y-3; i--)
                    if(table[i][x].hasShip())
                        return false;
                break;
            case DOWN:
                for(int i = y; i < y+3; i++)
                    if(table[i][x].hasShip())
                        return false;
                break;
            case LEFT:
                for(int i = x; i > x-3; i--)
                    if(table[y][i].hasShip())
                        return false;
                break;
            case RIGHT:
                for(int i = x; i < x+3; i++)
                    if(table[y][i].hasShip())
                        return false;
                break;
        }
        //Then place
        switch (direction){
            case UP:
                for(int i = y; i > y-3; i--)
                    table[i][x].setHasShip(true);
                break;
            case DOWN:
                for(int i = y; i < y+3; i++)
                    table[i][x].setHasShip(true);
                break;
            case LEFT:
                for(int i = x; i > x-3; i--)
                    table[y][i].setHasShip(true);
                break;
            case RIGHT:
                for(int i = x; i < x+3; i++)
                   table[y][i].setHasShip(true);
                break;
        }
        shipPlacedCount++;
        return true;
    }

    public boolean allShipsPlaced(){
        return shipPlacedCount >= 3;
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
