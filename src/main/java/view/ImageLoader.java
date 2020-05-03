package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {


    private static ImageIcon ship;

    static {
        try {
            ship = new ImageIcon(ImageIO.read(new File("src/test.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ImageIcon water;

    static {
        try {
            water = new ImageIcon(ImageIO.read(new File("src/water.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static ImageIcon getWater(){
        return water;
    }
    static ImageIcon getWaterHit(){
        return null;
    }
    static ImageIcon getShip(){
        return ship;
    }
    static ImageIcon getShipHit(){
        return null;
    }
}
