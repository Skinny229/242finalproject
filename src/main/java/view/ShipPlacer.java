package view;

import model.Block;
import model.Direction;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShipPlacer extends JFrame implements ActionListener {


    JPanel view = new JPanel(new GridLayout(9, 8,1,1));
    JButton directionButton = new JButton("DIR: UP");
    private Player ply;


    Direction placeDirection = Direction.UP;

    public ShipPlacer(Player ply) {
        super("Battleship -- Place Ships for PLAYER " + ply.getPlayerNumber());
        setSize(1000, 1000);
        this.add(view);
        this.ply = ply;


        Block[][] table = ply.getTable();


        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                JLabel block = table[i][j].blockLabel;
                block.setSize(125,125);
                int finalY = i;
                int finalX = j;
                //  block.setText(i +" + "+j);
                block.setIcon(ImageLoader.getWater());
                block.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        placeShip(finalY, finalX);
                        //setVisible(true);
                    }
                });
                view.add(block);
            }


        directionButton.addActionListener(this);
        directionButton.setSize(10,20);
        view.add(directionButton);

        setVisible(true);


    }


    private void placeShip(int y, int x) {

        if (ply.setShip(y, x, placeDirection)) {
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++) {
                    JLabel block = ply.getTable()[i][j].blockLabel;
                    block.setIcon(ply.getTable()[i][j].hasShip() ? ImageLoader.getShip() : ImageLoader.getWater());
                }
        }

        if (ply.allShipsPlaced())
            this.setVisible(false);
        else
            this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


        switch (placeDirection) {
            case UP:
                placeDirection = Direction.DOWN;
                break;
            case DOWN:
                placeDirection = Direction.LEFT;
                break;
            case LEFT:
                placeDirection = Direction.RIGHT;
                break;
            case RIGHT:
                placeDirection = Direction.UP;
                break;
        }

        directionButton.setText("DIR: " + placeDirection.toString());

    }
}
