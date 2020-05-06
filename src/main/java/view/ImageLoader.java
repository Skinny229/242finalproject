package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    // Adds game images 

    private static  ImageIcon ship;

    static {
        try {
            ship = new ImageIcon(ImageIO.read(new File("src/ship.jpg")));
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

    private static ImageIcon waterhit;

    static {
        try {
            waterhit = new ImageIcon(ImageIO.read(new File("src/waterhit.jpeg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ImageIcon shiphit;

    static {
        try {
            shiphit = new ImageIcon(ImageIO.read(new File("src/shiphit.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ImageIcon getWater(){
        return water;
    }
    static ImageIcon getWaterHit(){
        return waterhit;
    }
    static ImageIcon getShip(){
        return ship;
    }
    static ImageIcon getShipHit(){
        return shiphit;
    }
}
