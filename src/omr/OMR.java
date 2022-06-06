package omr;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

class Pixel {

    BufferedImage image;
    int x = 148, y = 679, ind = 0, black = 0, tym = 0, max = 0, got;
    int roll[] = new int[6];
    int count = -1;
    

    public Pixel() {
        try {
            File input = new File("G:\\OMRreadindsystem\\H.jpg");
            image = ImageIO.read(input);
            
            while (ind < 6) {
                max = 0;
                tym = 0;
                while (tym < 10) {
                    black = 0;
                    count++;
                   
                    for (int j = y - 10; j <= y + 10; j++) {
                        for (int i = x - 10; i <= x + 10; i++) {
                            Color c = new Color(image.getRGB(i, j));
                            if (((float) c.getRed() / 255 + (float) c.getGreen() / 255 + (float) c.getBlue() / 255) == 0) {
                                black++;
                            }
                        }
                    }
                    if (black > max) {
                        max = black;
                        got = count;
                    }
                    tym++;
                    y += 25;
                }
                roll[ind] = got;
                ind++;
                count = -1;
                x += 25;
                y = 679;
            }
            System.out.println("Scanned Roll No: ");
            for (int i = 0; i < 6; i++) 
                System.out.print(roll[i]);            
            System.out.println("\n");
        } catch (Exception e) {
        }
    }
}

public class OMR{

    static public void main(String args[]) throws Exception {
        Pixel obj = new Pixel();
    }
}
