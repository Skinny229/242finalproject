package view;

import model.Block;
import model.FireResponse;
import controller.GameRunner;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PlayerFrame extends JFrame {

    private Player ply;

    JPanel selfView = new JPanel(new GridLayout(8, 8));

    // Creates the player view
    
    public PlayerFrame(Player ply){
        super("YOUR TABLE");

        setSize(1800, 1800);
        add(selfView);
        this.ply = ply;

        Block[][] table = ply.getTable();
        
        // Renders images
        // Every button has a Fire event
        // After the Fire event comes AI response

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
                        if (response != FireResponse.ALREADY_FIRED) {
                            String coordsHit = GameRunner.AIFire();
                            int y = coordsHit.charAt(0) - 48;
                            int x = coordsHit.charAt(1) - 48;
                            ply.getTable()[y][x].blockLabel.setIcon(ply.getTable()[y][x].blockStatus == FireResponse.HIT ? ImageLoader.getShipHit() : ImageLoader.getWaterHit());
                        }
                    }
                });
                selfView.add(block);
            }
        setVisible(true);
    }

}
