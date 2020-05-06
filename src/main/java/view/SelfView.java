package view;

import model.BlockAsSelf;
import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelfView extends JFrame implements ActionListener {


    JPanel selfPanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton revealButton = new JButton();

    public SelfView() {
        super("Self View");
        this.setSize(1000, 1000);
        this.setLayout(new BorderLayout());

        buttonPanel.add(revealButton);
        revealButton.addActionListener(this);
        this.add(buttonPanel, BorderLayout.NORTH);
    }

    public void setPlayerView(BlockAsSelf[][] arr2, Player ply) {
        remove(selfPanel);
        selfPanel = new JPanel(new GridLayout(8, 8, 1, 1));
        revealButton.setText(String.format("Player [%s], press here to start your turn", ply.getPlayerNumber()));
        selfPanel.setVisible(false);
        add(selfPanel,  BorderLayout.CENTER);
        for (BlockAsSelf[] arr : arr2)
            for (BlockAsSelf val : arr) {
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
                selfPanel.add(label);
            }
        setVisible(true);
    }


    public void hideAndWait(int x){
        selfPanel.setVisible(false);
        remove(selfPanel);
        revealButton.setText("You have Fired! Click this button to start Player " + x + "'s turn");
        flag = false;
    }

    boolean flag = false;
    public boolean continueFlag(){
        return flag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        selfPanel.setVisible(true);
        flag = true;
    }
}
