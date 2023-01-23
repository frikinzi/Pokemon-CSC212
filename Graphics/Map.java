import javax.swing.JPanel;	// Extending JPanel class
import java.awt.Dimension;	// Setting dimensions of JPanel
import java.awt.Graphics;	// Using Graphics object to draw


/**
 *  Class for the Map graphics
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Map extends JPanel {
	Background bg;
  Icon character;


/**
 *  Constructor for the map class
 *
 *  @param x X location of the character
 *  @param y Y location of the character
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Map(int x, int y){
		bg = new Background("Graphics/pictures/map.png");
    character = new Icon("Graphics/pictures/character.png", x, y);
	}


/**
 *  Determines preferred size of the graphic
 *
 *  @return Preferred size of the graphic
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public Dimension getPreferredSize() {
    return new Dimension(500,450);
  }

  
/**
 *  Paints components on the map (background, character, etc.)
 *
 *  @param g The graphics object
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
    bg.draw(g);
    character.draw(g);
	}


/**
 *  The method that runs the animation loop
 *
 *  @param x The x value that the character is moving towards
 *  @param y The y value that the character is moving towards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public void animate(int x, int y){
		while (character.getX() != x || character.getY() != y){
			try {
				Thread.sleep(100);	
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			character.move(x,y);
      
			repaint();
		}
	}


/**
 *  Method that determines what types of animations to run
 *
 *  @param loc The current location of the playerr
 *  @param new_loc The location the player is moving to
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void animateMap(Location loc, Location new_loc){
    if(loc==Location.SHATTERDUNES && new_loc==Location.SANDSPKMCENTER){
      this.animate(40, 150);
    }
    else if(loc==Location.SANDSPKMCENTER && new_loc==Location.SHATTERDUNES){
      this.animate(40, 50);
    }
    else if(loc==Location.SANDSPKMCENTER && new_loc==Location.SHORTBRUSHHOLLOW){
      this.animate(40, 210);
      this.animate(90, 210);
    }
    else if(loc==Location.SHORTBRUSHHOLLOW && new_loc==Location.SANDSPKMCENTER){
      this.animate(40, 210);
      this.animate(40, 150);
    }
    else if(loc==Location.SWEETFLOATWATER && new_loc==Location.SHORTBRUSHHOLLOW){
      this.animate(90, 210);
    }
    else if(loc==Location.SHORTBRUSHHOLLOW && new_loc==Location.SWEETFLOATWATER){
      this.animate(90, 320);
    }
    else if(loc==Location.SWEETFLOATWATER && new_loc==Location.RUSTCRYISLE){
      this.animate(90, 400);
    }
    else if(loc==Location.RUSTCRYISLE && new_loc==Location.SWEETFLOATWATER){
      this.animate(90, 320);
    }
    else if(loc==Location.SHORTBRUSHHOLLOW && new_loc==Location.GROVEPKMCENTER){
      this.animate(90, 100);
    }
    else if(loc==Location.GROVEPKMCENTER && new_loc==Location.SHORTBRUSHHOLLOW){
      this.animate(90, 210);
    }
    else if(loc==Location.GROVEPKMCENTER && new_loc==Location.SUNSPOREFOREST){
      this.animate(90, 70);
    }
    else if(loc==Location.SUNSPOREFOREST && new_loc==Location.GROVEPKMCENTER){
      this.animate(90, 100);
    }
    else if(loc==Location.SUNSPOREFOREST && new_loc==Location.TANGLEPKMCENTER){
      this.animate(170, 70);
      this.animate(170, 40);
      this.animate(230, 40);
    }
    else if(loc==Location.TANGLEPKMCENTER && new_loc==Location.SUNSPOREFOREST){
      this.animate(170, 40);
      this.animate(170, 70);
      this.animate(90, 70);
    }
    else if(new_loc==Location.IRONSWEEPRUINS){ //from:tangle, blaze, needle
      this.animate(290, 40);
    }
    else if(loc==Location.IRONSWEEPRUINS && new_loc==Location.TANGLEPKMCENTER){
      this.animate(230, 40);
    }
    else if(new_loc==Location.NEEDLESUMMIT){ //from:iron, peak
      this.animate(390,40);
    }
    else if(new_loc==Location.PEAKPKMCENTER){ //from: copper, needle
      this.animate(390,80);
    }
    else if(loc==Location.PEAKPKMCENTER && new_loc==Location.COPPERPEAK){
      this.animate(390,130);
    }
    else if(loc==Location.BLAZEFACTORY && new_loc==Location.COPPERPEAK){
      this.animate(390,130);
    }
    else if(new_loc==Location.BLAZEFACTORY){ //from: copper, moonfork, mistfront, ironsweep
      this.animate(290,130);
    }
    else if(loc==Location.BLAZEFACTORY && new_loc==Location.MISTGRASSLAND){
      this.animate(220,130);
    }
    else if(loc==Location.BLAZEFACTORY && new_loc==Location.MOONFORKTOWN){
      this.animate(290,230);
    }
    else if(loc==Location.MISTGRASSLAND && new_loc==Location.FLASHBREEZESWAMP){
      this.animate(140,130);
      this.animate(140,340);
      this.animate(240,320);
    }
    else if(loc==Location.FLASHBREEZESWAMP && new_loc==Location.MISTGRASSLAND){
      this.animate(140,340);
      this.animate(140,130);
      this.animate(220,130);
    }
    else if(loc==Location.RUSTCRYISLE && new_loc==Location.STARGLASSKELPBED){
      this.animate(170,400);
    }
    else if(loc==Location.STARGLASSKELPBED && new_loc==Location.RUSTCRYISLE){
      this.animate(90,400);
    }
    else if(loc==Location.STARGLASSKELPBED && new_loc==Location.FLASHBREEZESWAMP){
      this.animate(220,400);
      this.animate(240,320);
    }
    else if(loc==Location.FLASHBREEZESWAMP && new_loc==Location.STARGLASSKELPBED){
      this.animate(220,400);
      this.animate(170,400);
    }
    else if(loc==Location.FLASHBREEZESWAMP && new_loc==Location.MOONFORKTOWN){
      this.animate(320,340);
      this.animate(320,290);
      this.animate(390,280);
      this.animate(390,220);
      this.animate(290,220);
    }
    else if(loc==Location.MOONFORKTOWN && new_loc==Location.FLASHBREEZESWAMP){
      this.animate(390,220);
      this.animate(390,280);
      this.animate(320,290);
      this.animate(320,340);
      this.animate(240,340);
    }
    else if(loc==Location.FLASHBREEZESWAMP && new_loc==Location.COPPERPEAK){
      this.animate(320,340);
      this.animate(320,290);
      this.animate(390,280);
      this.animate(390,130);
    }
    else if(loc==Location.COPPERPEAK && new_loc==Location.FLASHBREEZESWAMP){
      this.animate(390,280);
      this.animate(320,290);
      this.animate(320,340);
      this.animate(240,320);
    }
    else if(loc==Location.MOONFORKTOWN && new_loc==Location.COPPERPEAK){
      this.animate(390,220);
      this.animate(390,130);
    }
    else if(loc==Location.COPPERPEAK && new_loc==Location.MOONFORKTOWN){
      this.animate(390,220);
      this.animate(290,230);
    }
  }

  
}