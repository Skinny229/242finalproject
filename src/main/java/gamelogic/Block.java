package gamelogic;

import javax.swing.*;

public class Block {

    private boolean hasShip;
    public FireResponse blockStatus;
    public JLabel blockLabel;

    public Block(){
        blockStatus = FireResponse.NONE;
        hasShip = false;
        blockLabel = new JLabel();
    }

    public void setHasShip(boolean hasShip) {
        this.hasShip = hasShip;
    }

    public boolean hasShip(){
        return hasShip;
    }

    public FireResponse reciveFire() {
      if(blockStatus == FireResponse.NONE) {
          if (hasShip)
              blockStatus = FireResponse.HIT;
          else
              blockStatus = FireResponse.MISS;
          return blockStatus;
      }else
          return FireResponse.ALREADYFIRED;
    }
}
