import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

/**
 *  Class to create a graphics background 
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Background{
  private String file = null;

  
/**
 *  Constructor for background class
 *
 *  @param file The file name of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public Background(String file) {
		this.file = file;
	}

  
/**
 *  Sets the file for the image
 *
 *  @param file The file name of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setFile(String file) {
    this.file = file;
  }

/**
 *  Draws the file image to the Graphics background
 *
 *  @param g The graphics object for drawing
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void draw(Graphics g) {
      BufferedImage img = null;
      try {
          img = ImageIO.read(new File(file));
      } catch (IOException e) {
          throw new RuntimeException("There is an issue with the image");
      }
    g.drawImage(img, 0, 0, null);
  }
  
}