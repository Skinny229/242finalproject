package view;

import model.BlockAsEnemy;
import model.BlockAsSelf;

import javax.swing.*;
import java.awt.*;

public class SelfView extends JFrame {


    JPanel view = new JPanel();
    public SelfView(){
        super("Self View");
        setSize(1000,1000);
    }

    public void setPlayerView(BlockAsSelf[][] arr2){

        remove(view);
        view = new JPanel(new GridLayout(8,8,2,2));
        add(view);
        for(BlockAsSelf[] arr : arr2)
            for(BlockAsSelf val : arr) {
                JLabel label = new JLabel();
                ImageIcon icon;
                switch (val) {
                    case SHIP_HIT:
                        icon = ImageLoader.getShipHit();
                        break;
                    case WATER_HIT:
                        icon = ImageLoader.getWaterHit();
                        break;
                    case SHIP_NO_HIT:
                        icon = ImageLoader.getShip();
                        break;
                    case WATER_NO_HIT:
                    default:
                        icon = ImageLoader.getWater();
                }
                label.setIcon(icon);
                view.add(label);
            }
        setVisible(true);
    }
}
