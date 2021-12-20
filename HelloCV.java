import javax.swing.JFrame;
import org.computervision.qbranch.ObjectOverlay;
import org.computervision.qbranch.Screen;
import org.computervision.qbranch.VideoSource;
import org.opencv.core.Core;

public class HelloCV {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        var source = new VideoSource(0);
        var screen = new Screen(new JFrame());

        // robotOverlay
        // targetOverlay
        var faceOverlay = new ObjectOverlay("/usr/share/opencv4/haarcascades/haarcascade_frontalface_alt.xml");

        // Image Processing Loop
        while (true) {
            var image = source.nextImage();
            faceOverlay.overlay(image);
            screen.display(image);
        }
    }
}
