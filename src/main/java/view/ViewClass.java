package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

public class ViewClass extends JFrame {


    JPanel selfView = new JPanel(new GridLayout(8,8));

    public ViewClass(){
        super("Hello Battleship");
        setSize(1000, 500);
        setContentPane(selfView);

        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        label1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
            }
        });
        add(label1);
        add(label2);

        try {
            BufferedImage myPicture = ImageIO.read(new File("src/test.png"));
            label1.setIcon(new ImageIcon(myPicture));
            label2.setIcon(new ImageIcon(myPicture));
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);


    }

    //1view for placing ships

    //one more for playing

}
