package view;


import model.BlockAsEnemy;
import model.FireResponse;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EnemyView extends JFrame {


    JPanel view = new JPanel();
    public EnemyView(){
        super("Enemy view fire here");
        setSize(1000,1000);
    }

    boolean flag;

    public void setPlayerView(BlockAsEnemy[][] enemy, Player player) {
        flag = false;
        remove(view);
        view = new JPanel(new GridLayout(8,8,2,2));
        add(view);
        for(int i = 0; i < 8; i++)
            for(int j = 0; j < 8; j++) {
                BlockAsEnemy val = enemy[j][i];
                JLabel label = new JLabel();
                ImageIcon icon;
                switch (val) {
                    case Ship_hit:
                        icon = ImageLoader.getShipHit();
                        break;
                    case Water_Miss:
                       icon = ImageLoader.getWaterHit();
                        break;
                    case Water:
                    default:
                        icon = ImageLoader.getWater();
                }
                label.setIcon(icon);
                int finalJ = j;
                int finalI = i;
                label.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int finalY = finalI;
                        int finalX = finalJ;
                        if(player.beingFiredOn(finalY,finalX) != FireResponse.ALREADY_FIRED){
                            flag = true;

                        }

                    }

                });
                view.add(label);
            }
        setVisible(true);
    }

    public boolean hasFired() {
        return flag;
    }
}

