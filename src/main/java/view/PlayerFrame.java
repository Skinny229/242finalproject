package view;

import gamelogic.Block;
import gamelogic.FireResponse;
import gamelogic.GameRunner;
import gamelogic.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerFrame extends JFrame {



    private Player ply;

    JPanel selfView = new JPanel(new GridLayout(8, 8));

    public PlayerFrame(Player ply){
        super("YOUR VIEW");

        setSize(1000, 500);
        setContentPane(selfView);
        this.ply = ply;

        Block[][] table = ply.getTable();
        //Render image
        //Every button has a fire event
        //Within Fire event comes AI response

        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                table[i][j].blockLabel = new JLabel();
                JLabel block =  table[i][j].blockLabel;
                int finalY = i;
                int finalX = j;
                block.setIcon(table[i][j].hasShip() ? ImageLoader.getShip() : ImageLoader.getWater());
                block.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        FireResponse response = GameRunner.firePlayer1(finalY, finalX);
                        //AI COMPONENT
                        if (response != FireResponse.ALREADYFIRED) {
                            String coordsHit = GameRunner.AIFire();
                            int y = coordsHit.charAt(0) - 48;
                            int x = coordsHit.charAt(1) - 48;
                            boolean hasHitShip = ply.getTable()[y][x].blockStatus == FireResponse.HIT ? true : false;
                            ply.getTable()[y][x].blockLabel.setIcon(hasHitShip ? ImageLoader.getShipHit() : ImageLoader.getWaterHit());
                        }
                    }
                });
                add(block);
            }
        setVisible(true);
    }



}
