package model;

import javax.swing.*;

public class Block {

    private boolean hasShip;
    public FireResponse blockStatus;
    public JLabel blockLabel;

    // Determines if the ship blocked the attack
    
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

    // Determines if the ship was hit
    
    public FireResponse reciveFire() {
      if(blockStatus == FireResponse.NONE) {
          if (hasShip)
              blockStatus = FireResponse.HIT;
          else
              blockStatus = FireResponse.MISS;
          return blockStatus;
      }else
          return FireResponse.ALREADY_FIRED;
    }
}
