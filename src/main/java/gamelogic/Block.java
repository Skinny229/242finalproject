package gamelogic;

import javax.swing.*;

public class Block {

    private boolean hasShip;
    public FireRepsonse blockStatus;

    public Block(){
        blockStatus = FireRepsonse.NONE;
        hasShip = false;
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean hasShip(){
        return hasShip();
    }

    public FireRepsonse reciveFire() {
      if(blockStatus == FireRepsonse.NONE) {
          if (hasShip)
              blockStatus = FireRepsonse.HIT;
          else
              blockStatus = FireRepsonse.MISS;
          return blockStatus;
      }else
          return FireRepsonse.ALREADYFIRED;
    }
}
