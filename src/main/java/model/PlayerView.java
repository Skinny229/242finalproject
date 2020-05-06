package model;


public class PlayerView {


    private final BlockAsSelf[][] self = new BlockAsSelf[8][8];
    private final BlockAsEnemy[][] enemy = new BlockAsEnemy[8][8];

    public PlayerView(Player selfPlayer, Player enemyPlayer){

        Block[][] selfTable = selfPlayer.getTable();



        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++){
                BlockAsSelf blockSelfState;
                BlockAsEnemy blockAsEnemy;
                switch(selfTable[i][j].blockStatus){
                    case HIT:
                        blockSelfState = BlockAsSelf.SHIP_HIT;
                        break;
                    case MISS:
                        blockSelfState = BlockAsSelf.WATER_HIT;
                        break;
                    case NONE:

                        if(selfTable[i][j].hasShip())
                            blockSelfState = BlockAsSelf.SHIP_NO_HIT;
                        else
                           blockSelfState = BlockAsSelf.WATER_NO_HIT;
                        break;
                    default:
                        blockSelfState = BlockAsSelf.WATER_NO_HIT;

                }
                switch(enemyPlayer.getTable()[j][i].blockStatus){
                    case HIT:
                        blockAsEnemy = BlockAsEnemy.Ship_hit;
                        break;
                    case MISS:
                        blockAsEnemy = BlockAsEnemy.Water_Miss;
                        break;
                    case NONE:
                    default:
                        blockAsEnemy = BlockAsEnemy.Water;
                }
                self[i][j] = blockSelfState;
                enemy[i][j] = blockAsEnemy;

            }



        }


    public BlockAsSelf[][] getSelf() {
        return self;
    }

    public BlockAsEnemy[][] getEnemy() {
        return enemy;
    }
}
