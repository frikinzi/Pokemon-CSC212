/**
 *  Enum defining types in the game. there are 18 types, including fire, water, grass, electric, etc. see cheatsheet
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Type {

  FIRE(new String[]{"Grass", "Steel", "Bug", "Ice"}, new String[]{"Water", "Fire", "Rock", "Dragon"}, new String[]{}, "Fire"),
  WATER(new String[]{"Fire", "Ground", "Rock"}, new String[]{"Grass", "Water", "Dragon"}, new String[]{}, "Water"),
  GRASS(new String[]{"Water", "Ground", "Rock"}, new String[]{"Fire", "Steel", "Poison", "Dragon", "Bug", "Flying", "Grass"}, new String[]{}, "Grass"),
  ELECTRIC(new String[]{"Flying", "Water"}, new String[]{"Electric", "Dragon", "Grass"}, new String[]{"Ground"}, "Electric"),
  ICE(new String[]{"Dragon", "Ground", "Grass", "Flying"}, new String[]{"Steel", "Water", "Fire", "Ice"}, new String[]{}, "Ice"),
  PSYCHIC(new String[]{"Fighting", "Poison"}, new String[]{"Psychic", "Steel"}, new String[]{"Dark"}, "Psychic"),
  DARK(new String[]{"Psychic", "Ghost"}, new String[]{"Fighting", "Dark", "Fairy"}, new String[]{}, "Dark"),
  FAIRY(new String[]{"Dragon", "Dark", "Fighting"}, new String[]{"Bug", "Steel", "Fire", "Poison"}, new String[]{}, "Fairy"),
  BUG(new String[]{"Fairy", "Dark", "Psychic", "Grass"}, new String[]{"Fighting", "Steel", "Fire", "Poison", "Flying", "Ghost"}, new String[]{}, "Bug"),
  GROUND(new String[]{"Rock", "Steel", "Fire", "Poison", "Electric"}, new String[]{"Grass", "Bug"}, new String[]{"Flying"}, "Ground"),
  ROCK(new String[]{"Flying", "Bug", "Fire", "Ice"}, new String[]{"Steel", "Fighting", "Ground"}, new String[]{}, "Rock"),
  DRAGON(new String[]{"Dragon"}, new String[]{"Steel"}, new String[]{"Fairy"}, "Dragon"),
  NORMAL(new String[]{}, new String[]{"Steel", "Rock"}, new String[]{"Ghost"}, "Normal"),
  GHOST(new String[]{"Ghost", "Psychic"}, new String[]{"Dark"}, new String[]{"Normal"}, "Ghost"),
  STEEL(new String[]{"Fairy", "Rock", "Ice"}, new String[]{"Electric", "Water", "Fire", "Steel"}, new String[]{}, "Steel"),
  POISON(new String[]{"Fairy", "Grass"}, new String[]{"Poison", "Ground", "Rock", "Ghost"}, new String[]{"Steel"}, "Poison"),
  FIGHTING(new String[]{"Steel", "Rock", "Normal", "Ice", "Dark"}, new String[]{"Poison", "Flying", "Fairy", "Bug"}, new String[]{"Ghost"}, "Fighting"),
  FLYING(new String[]{"Grass", "Bug", "Fighting"}, new String[]{"Steel", "Rock", "Electric"}, new String[]{}, "Flying"),

  //internal
  FREEZEDRY(new String[]{"Dragon", "Ground", "Grass", "Flying", "Water"}, new String[]{"Steel", "Fire", "Ice"}, new String[]{}, ""),;

  private String[] SUPER_EFFECTIVE;
  private String[] NOT_VERY_EFFECTIVE;
  private String[] NO_EFFECT;
  private String NAME;

  
/**
 *  Constructor defining types in the game. 
 *  @param super_effective List of types it's supereffective against
 *  @param not_very_effective List of types it's not effective against
 *  @param no_effective List of types it has no effect against
 *  @param name Name of type
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Type(String[] super_effective, String[] not_very_effective, String[] no_effect, String name) {
    SUPER_EFFECTIVE = super_effective;
    NOT_VERY_EFFECTIVE = not_very_effective;
    NO_EFFECT = no_effect;
    NAME = name;
  }

  
/**
 *  util method checking if a string array contains a string
 *
 *  @param s String array
 *  @param type Type as string
 *  @return True if contains string array
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean contains(String[] s, String type) {
    for (String t : s) {
	    if (t.equals(type)) {
		    return true;
	    }
    }
    return false;
  }

  
/**
 *  checks if a type is super effective on another
 *
 *  @param s The inputted type
 *  @return True if super effective
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isSuperEffectiveOn(String s) {
    return (contains(SUPER_EFFECTIVE, s));
  }

  
/**
 *  checks if a type is not very effective on another type
 *
 *  @param s The inputted type
 *  @return True if not very effective
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isNotVeryEffectiveOn(String s) {
    return (contains(NOT_VERY_EFFECTIVE, s));
  }

  
/**
 *  checks if a type has no effect on another type
 *
 *  @param s The inputted type
 *  @return True if has no effect
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean hasNoEffect(String s) {
    return (contains(NO_EFFECT, s));
  }

  
/**
 *  gets name of the type
 *
 *  @return Name of type
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    if (this == FREEZEDRY) {
      return "Ice";
    }
    return NAME;
  }

  
}