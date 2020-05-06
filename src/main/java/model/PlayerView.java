package model;

import model.Block;
import model.BlockAsSelf;
import model.Player;

public class PlayerView {

    private BlockAsSelf[][] self = new BlockAsSelf[8][8];
    private boolean[][] enemy = new boolean[8][8];

    public PlayerView(Player selfPlayer, Player enemyPlayer){

        Block[][] selfTable = selfPlayer.getTable();

        //  
        
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++){
                BlockAsSelf blockState;
                switch(selfTable[i][j].blockStatus){
                    case HIT:
                        blockState = BlockAsSelf.SHIP_HIT;
                    case MISS:
                        blockState = BlockAsSelf.WATER_HIT;
                    case NONE:
                        if(selfTable[i][j].hasShip())
                            blockState = BlockAsSelf.SHIP_NO_HIT;
                        else
                           blockState = BlockAsSelf.WATER_NO_HIT;
                    default:
                        blockState = BlockAsSelf.WATER_NO_HIT;
                }
                self[i][j] = blockState;
            }

            enemy = enemyPlayer.getTableAsEnemy();
        }

    public BlockAsSelf[][] getSelf() {
        return self;
    }

    public boolean[][] getEnemy() {
        return enemy;
    }
}
