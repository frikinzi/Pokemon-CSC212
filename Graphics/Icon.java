import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.JPanel;


/**
 *  Class for the graphics characters
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Icon extends JPanel{
	private int x;
  private int y;
  private String file;
  private int height;
  private int width;
	

  /**
 *  Constructor for the icon class without location
 *
 *  @param file The file name of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public Icon(String file) {
    this.file = file;
    
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File(file));
      this.height = img.getHeight();
      this.width = img.getWidth();
    } catch (IOException e) {
      throw new RuntimeException("The image won't load");
    } 
	}
  
/**
 *  Constructor for the icon class with location
 *
 *  @param file The file name of the image
 *  @param x The x value of the character's location
 *  @param y The y value of the character's location
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public Icon(String file, int x, int y) {
		this.x = (int) Math.round(x/10.0) * 10;
		this.y = (int) Math.round(y/10.0) * 10;
    this.file = file;
    
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File(file));
      this.height = img.getHeight();
      this.width = img.getWidth();
    } catch (IOException e) {
      throw new RuntimeException("The image won't load");
    } 
	}


/**
 *  Sets the file for the image
 *
 *  @param file The file name of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setFile(String file){
    this.file = file;
  }
    

/**
 *  Method that allows the character to move in small increments
 *
 *  @param x1 The x value of the location the character will move towards
 *  @param y1 The y value of the location the character will move towards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public void move(int x1, int y1) {
	  int x_direction = 0;
    int y_direction = 0;
    
    if(this.x > x1){
      x_direction = -1;
    }
    else if(this.x < x1){
      x_direction = 1;
    }

    if(this.y > y1){
      y_direction = -1;
    }
    else if(this.y < y1){
      y_direction = 1;
    }

    if(this.y != y1){
      setY(y + (y_direction * 10));
    }
    if(this.x != x1){
      setX(x + (x_direction * 10));
    }
	}

  
/**
 *  Gets X value
 *
 *  @return X value of the location of the character
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getX() {						
		return x;							
	}

  
/**
 *  Gets Y value
 *
 *  @return X value of the location of the character
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public int getY() {
		return y;
	}

  
/**
 *  Sets the Y value of the character
 *
 *  @param y1 The new y value
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setY(int y1) {
		this.y = y1;
	}

  
/**
 *  Sets the X value of the character
 *
 *  @param x1 The new x value
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setX(int x1) {
		this.x = x1;
	}


/**
 *  Draws the image for the graphics object at the determined location and sets the height/width of the image
 *
 *  @param g The graphics object
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void draw(Graphics g){
      
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File(file));
    } catch (IOException e) {
      throw new RuntimeException("The image won't load");
    } 
    g.drawImage(img, x, y, null);
  }

  
/**
 *  Sets height of image
 *
 *  @param height THe height of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setHeight(int height){
    this.height = height;
  }


  /**
 *  Gets height of image
 *
 *  @return The height of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getHeight(){
    return this.height;
  }

  /**
 *  Gets width of image
 Gets
 *  @return The width of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getWidth(){
    return this.width;
  }


/**
 *  Sets width of image
 *
 *  @param width The width of the image
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setWidth(int width){
    this.width = width;
  }
  
  
}