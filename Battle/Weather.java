/**
 *  Enum class defining weather in the game - rain, sun, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */

public enum Weather {

  RAIN("Rain", "Rain continues to fall.", "It started to rain!", "The rain stopped.", Type.WATER),
  SANDSTORM("Sandstorm", "The sandstorm rages on.", "A sandstorm whipped up!", "The sandstorm subsided.", null),
  HAIL("Hail", "The hail pelts down.", "It started to hail!", "The hail died down.", Type.ICE),
  SUN("Sun", "The sunlight is strong.", "The sunlight became harsh!", "The harsh sunlight stopped.", Type.FIRE),
  ELECTRICTERRAIN("Electric Terrain", "", "The battlefield was covered in electricity!", "The Electric Terrain stopped.", Type.ELECTRIC),
  PSYCHICTERRAIN("Psychic Terrain", "", "The battlefield got weird!", "Psychic Terrain stopped.", Type.PSYCHIC),
  MISTYTERRAIN("Misty Terrain", "", "The battlefield was covered with a mysterious mist!", "Misty Terrain stopped.", Type.FAIRY),
  GRASSYTERRAIN("Grassy Terrain", "", "The battlefield was covered in dense grass!", "Grassy Terrain stopped.", Type.GRASS);
  
  private String NAME;
  private String MESSAGE;
  private String START;
  private String END;
  private Type BOOSTED;

  
/**
 *  Enum constructor defining weather, including start message, end message, etc.
 *
 *  @param name Name/type of weather
 *  @param message Message that shows while weather is active
 *  @param start_message Message that shows when weather starts
 *  @param end_message Message that shows when weather ends
 *  @param boosted The types of pokemon that get boosted during the weather
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Weather(String name, String message, String start_message, String end_message, Type boosted) {
    NAME = name;
    MESSAGE = message;
    START = start_message;
    END = end_message;
    BOOSTED = boosted;
  }

  
/**
 *  Get message that shows when the weather is set
 *
 *  @return Message that shows when weather starts
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getStartMessage() {
    return START;
  }

  
/**
 *  Get message that shows when turn ends while weather is active
 *
 *  @return Message that shows when the turn ends
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getTurnEndMessage() {
    return MESSAGE;
  }

  
/**
 *  Get message that shows when weather ends
 *
 *  @return Message that shows when weather ends
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getEndMessage() {
    return END;
  }

  
/**
 *  Gets type boosted by weather
 *
 *  @return Types that get boosted by the current weather
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeBoosted() {
    return BOOSTED;
  }

  
/**
 *  gets name of weather
 *
 *  @return The name of the weather
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return NAME;
  }

  
}