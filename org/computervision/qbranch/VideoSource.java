package org.computervision.qbranch;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class VideoSource {
    private final VideoCapture video;
    private final Mat matrix = new Mat();

    public VideoSource(Integer deviceNumber) {
        this.video = new VideoCapture(deviceNumber);
    }

    public Mat nextImage() {
        video.read(matrix);
        return matrix;
    }
}
