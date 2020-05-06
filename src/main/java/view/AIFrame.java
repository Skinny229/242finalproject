package view;

import controller.GameRunner;
import model.Block;
import model.BlockAsEnemy;
import model.FireResponse;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AIFrame extends JFrame {


    JPanel view = new JPanel(new GridLayout(8,8));

    public AIFrame(Player ply) {
        super("AI VIEW");
        setSize(1800, 1800);
        setContentPane(view);


        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                JLabel enemyBlock = new JLabel();
                int finalY = i;
                int finalX = j;
                enemyBlock.setIcon(ImageLoader.getWater());
                enemyBlock.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FireResponse response = GameRunner.firePlayer1(finalY, finalX);
                        //AI COMPONENT
                        if (response != FireResponse.ALREADY_FIRED) {
                            GameRunner.AIFire();
                            enemyBlock.setIcon(response == FireResponse.HIT ? ImageLoader.getShipHit() : ImageLoader.getWaterHit());
                        }
                    }

                });
                view.add(enemyBlock);
                setVisible(true);
            }
    }




}
