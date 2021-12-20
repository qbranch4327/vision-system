package org.computervision.qbranch;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.swing.*;
import javax.imageio.ImageIO;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Screen {
    private final JFrame frame;
    private final ImageIcon image = new ImageIcon();

    public Screen(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().add(new JLabel(image));
        frame.setVisible(true);
    }

    public void display(Mat img) {
        byte[] byteArray = toByteArray(img);

        try {
            InputStream in = new ByteArrayInputStream(byteArray);
            BufferedImage bufImage = ImageIO.read(in);
            image.setImage(bufImage);
            frame.pack();
            frame.repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] toByteArray(Mat img) {
        Imgproc.resize(img, img, new Size(640, 480));
        MatOfByte m = new MatOfByte();
        Imgcodecs.imencode(".jpg", img, m);

        return m.toArray();
    }
}
