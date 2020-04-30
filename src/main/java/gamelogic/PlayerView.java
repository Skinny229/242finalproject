package gamelogic;

public class PlayerView {


    public BlockAsSelf[][] self = new BlockAsSelf[8][8];
    public boolean[][] enemy = new boolean[8][8];

    public PlayerView(Player selfPlayer, Player enemyPlayer){

        Block[][] selfTable = selfPlayer.getTable();
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                switch(selfTable[i][j].blockStatus){
                    case HIT:
                        self[i][j] = BlockAsSelf.SHIPHIT;
                    case MISS:
                        self[i][j] = BlockAsSelf.WATERHIT;
                    case NONE:
                        if(selfTable[i][j].hasShip())
                            self[i][j] = BlockAsSelf.SHIP;
                        else
                            self[i][j] = BlockAsSelf.WATER;
                }


            enemy = enemyPlayer.getTableAsEnemy();
        }

}
