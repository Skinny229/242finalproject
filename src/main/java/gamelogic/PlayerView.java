package gamelogic;

public class PlayerView {


    public BlockAsSelf[][] self = new BlockAsSelf[8][8];
    public boolean[][] enemy = new boolean[8][8];

    public PlayerView(Player selfPlayer, Player enemyPlayer){

        Block[][] selfTable = selfPlayer.getTable();


        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++){
                BlockAsSelf blockState;
                switch(selfTable[i][j].blockStatus){
                    case HIT:
                        blockState = BlockAsSelf.SHIPHIT;
                    case MISS:
                        blockState = BlockAsSelf.WATERHIT;
                    case NONE:
                        if(selfTable[i][j].hasShip())
                            blockState = BlockAsSelf.SHIP;
                        else
                           blockState = BlockAsSelf.WATER;
                    default:
                        blockState = BlockAsSelf.WATER;
                }
                self[i][j] = blockState;
            }


            enemy = enemyPlayer.getTableAsEnemy();
        }

}
