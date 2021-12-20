package org.computervision.qbranch;

import java.util.List;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class ObjectOverlay {
    private final CascadeClassifier classifier = new CascadeClassifier();

    public ObjectOverlay(String cascadeFilename) {
        if (!classifier.load(cascadeFilename)) {
            System.err.println("Error loading face cascade: " + cascadeFilename);
            System.exit(0);
        }
    }

    public void overlay(Mat image) {
        MatOfRect faces = new MatOfRect();
        // Do the detection
        classifier.detectMultiScale(image, faces);
        List<Rect> listOfFaces = faces.toList();

        // Overlay detected regions on image
        for (Rect face : listOfFaces) {
            var center = new Point(face.x + face.width / 2, face.y + face.height / 2);
            var size = new Size(face.width / 2, face.height / 2);
            var color = new Scalar(255, 0, 255);

            Imgproc.ellipse(image, center, size, 0, 0, 360, color, 2);
        }
    }
}
