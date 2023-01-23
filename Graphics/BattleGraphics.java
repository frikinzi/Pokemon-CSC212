import javax.swing.JPanel;	// Extending JPanel class
import java.awt.Dimension;	// Setting dimensions of JPanel
import java.awt.Graphics;	// Using Graphics object to draw

/**
 *  Class for battle graphics including background and elements
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class BattleGraphics extends JPanel{
	Background bg;
  Background weather;
  Icon pokemon1;
  Icon pokemon2;


/**
 *  Constructors the graphics using the background and the added pokemon
 *
 *  @param poke The pokemon
 *  @param oppose The opposing pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public BattleGraphics(Pokemon poke, Pokemon oppose, Weather current_weather, Location location) {
    String background_string = "";
    if(location == Location.MOONFORKTOWN){
      background_string = "Graphics/pictures/Locations/moonfork.png";
    } else if(location == Location.STARGLASSKELPBED){
      background_string = "Graphics/pictures/Locations/starglass.png";
    } else if(location == Location.IRONSWEEPRUINS){
      background_string = "Graphics/pictures/Locations/ironsweep.png";
    } else if(location == Location.COPPERPEAK){
      background_string = "Graphics/pictures/Locations/copperpeak.png";
    } else if(location == Location.RUSTCRYISLE){
      background_string = "Graphics/pictures/Locations/rustcry.png";
    } else if(location == Location.BLAZEFACTORY){
      background_string = "Graphics/pictures/Locations/blazesting.png";
    } else if(location == Location.NEEDLESUMMIT){
      background_string = "Graphics/pictures/Locations/needlejaw.png";
    } else if(location == Location.MISTGRASSLAND){
      background_string = "Graphics/pictures/Locations/mistgrass.png";
    } else if(location == Location.BLIZZARDISLAND){
      background_string = "Graphics/pictures/Locations/blizzard.png";
    } else if(location == Location.SWEETFLOATWATER){
      background_string = "Graphics/pictures/Locations/sweetfloat.png";
    } else if(location == Location.SHORTBRUSHHOLLOW){
      background_string = "Graphics/pictures/Locations/shortbrush.png";
    } else if(location == Location.SHATTERDUNES){
      background_string = "Graphics/pictures/Locations/shatterdunes.png";
    } else if(location == Location.SUNSPOREFOREST){
      background_string = "Graphics/pictures/Locations/sunspore.png";
    } else if(location == Location.FLASHBREEZESWAMP){
      background_string = "Graphics/pictures/Locations/flashbreeze.png";
    }

    String weather_string = "";
    if (current_weather == Weather.RAIN){
      weather_string = "Graphics/pictures/Weather/rain.png";
    } else if (current_weather == Weather.SANDSTORM){
      weather_string = "Graphics/pictures/Weather/sandstorm.png";
    } else if (current_weather == Weather.HAIL){
      weather_string = "Graphics/pictures/Weather/hail.png";
    } else if (current_weather == Weather.SUN){
      weather_string = "Graphics/pictures/Weather/sunshine.png";
    } else if (current_weather == Weather.ELECTRICTERRAIN){
      background_string = "Graphics/pictures/Weather/electric.png";
    } else if (current_weather == Weather.PSYCHICTERRAIN){
      background_string = "Graphics/pictures/Weather/psychic.png";
    } else if (current_weather == Weather.MISTYTERRAIN){
      background_string = "Graphics/pictures/Weather/misty.png";
    } else if (current_weather == Weather.GRASSYTERRAIN){
      background_string = "Graphics/pictures/Weather/grassy.png";
    }
    
		bg = new Background(background_string);
    pokemon1 = new Icon(poke.getBattleBack());
    pokemon1.setY(200 - (pokemon1.getHeight())/2);
    pokemon1.setX(60);
    pokemon2 = new Icon(oppose.getBattleFront());
    pokemon2.setX(260);
    pokemon2.setY(12);
    if(weather_string != ""){
      weather = new Background(weather_string);
    }
	}


/**
 *  Determines preferred dimensions of the graphics
 *
 *  @return The preferred dimensions
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public Dimension getPreferredSize() {
    return new Dimension(500,300);
  }


/**
 *  Draws the components of the graphic to the object
 *
 *  @param g The graphics object
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
    bg.draw(g);
    pokemon1.draw(g);
    pokemon2.draw(g);
    if(weather != null){
      weather.draw(g);
    }
	}

	
}