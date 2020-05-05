package model;

public class Player {


    private final static int maxHits = 12;

    private int shipPlacedCount;

    private int hitCount;

    private Block[][] table = new Block[8][8];

    public Player(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                table[i][j] = new Block();
        }
        shipPlacedCount = 0;
    }



    public Block[][] getTable(){
        return table;
    }


    public boolean setShip(int y , int x, Direction direction){
        //Check that the placement will be in bounds in the first place
        //Depending on the direction we check the X or Y to have a min/max value
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
        //have to iterate through the blocks to check if there's no ships in the first place
        //If there's interference, return false(as in not placed)
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
        //Same for iteration strategy, this time updating the block to let it know there's a ship now there
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
        //Increase ship count
        shipPlacedCount++;
        //return true(as in ship has been placed)
        return true;
    }

    public boolean allShipsPlaced(){
        return shipPlacedCount >= 3;
    }


    public boolean[][] getTableAsEnemy(){
        boolean[][] asEnemy = new boolean[8][8];

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++)
                asEnemy[i][j] = table[i][j].blockStatus == FireResponse.HIT;
        }
        return asEnemy;
    }


    public FireResponse beingFiredOn(int y, int x){
        FireResponse response  = table[y][x].reciveFire();
        if (response == FireResponse.HIT)
            hitCount++;
        return response;
    }


    public boolean isAllShipsDown(){
        return hitCount >= maxHits;
    }
}
