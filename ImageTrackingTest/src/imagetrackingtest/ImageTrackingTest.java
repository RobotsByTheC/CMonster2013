/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetrackingtest;

import com.googlecode.javacv.CanvasFrame;
import edu.wpi.first.wpijavacv.DaisyExtensions;
import edu.wpi.first.wpijavacv.WPIColorImage;
import edu.wpi.first.wpijavacv.WPIImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Ben
 */
public class ImageTrackingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Must use javacv-windows-x86_64.jar for 64bit, fixed first problem
        // ARGGGGG - JNI errors: Exception in thread "main" java.lang.UnsatisfiedLinkError: C:\Users\Ben\AppData\Local\Temp\jniopencv_core1344181916948926143.dll: %1 is not a valid Win32 application
        // Temporary fix using 32 bit JDK, only other way is to recompile OpenCV for 64 bit, I might try that (if I could find the source code).

//        IplImage img = cvLoadImage("C:\\Users\\Ben\\Dropbox\\Team 2084 Documents\\Code\\2013\\ImageTrackingTest\\potatoes.jpg");
        WPIColorImage img = null;
        try {
            img = new WPIColorImage(ImageIO.read(new File("C:\\Users\\Ben\\Dropbox\\Team 2084 Documents\\Code\\2013\\DaisyCV\\Team341TestImages\\Team341TestImages\\image (21).jpg")));
        } catch (IOException ex) {
        }
        CanvasFrame frame = new CanvasFrame("Test", 1);
        frame.setDefaultCloseOperation(CanvasFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        FollowProcessor fw = new FollowProcessor(true);
        WPIImage processed = fw.processImage(img);
        frame.showImage(DaisyExtensions.getIplImage(processed));
    }
}
