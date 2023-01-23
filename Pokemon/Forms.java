import java.util.Random;

/**
 *  Enum defining forms of the pokemon. used for mega evolutions and other forms. i.e. giratina-origin
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Forms {

  MEGAVENUSAUR(Species.VENUSAUR, 1, "Mega Venusaur", Type.GRASS, Type.POISON, new int[] {80,100,123,122,120,80}, new Ability[] {Ability.THICKFAT}, new Ability[] {Ability.THICKFAT}, "In order to support its flower, which has grown larger due to Mega Evolution, its back and legs have become stronger.", Item.VENUSAURITE),
  MEGACHARIZARDY(Species.CHARIZARD, 2, "Mega Charizard Y", Type.FIRE, Type.FLYING, new int[] {78,104,78,159,115,100}, new Ability[] {Ability.DROUGHT}, new Ability[] {Ability.DROUGHT}, "Its bond with its Trainer is the source of its power. It boasts speed and maneuverability greater than that of a jet fighter.", Item.CHARIZARDITEY),
  MEGACHARIZARDX(Species.CHARIZARD, 1, "Mega Charizard X", Type.FIRE, Type.DRAGON, new int[] {78,130,111,130,85,100}, new Ability[] {Ability.TOUGHCLAWS}, new Ability[] {Ability.TOUGHCLAWS}, "The overwhelming power that fills its entire body causes it to turn black and create intense blue flames.", Item.CHARIZARDITEX),
  MEGABLASTOISE(Species.BLASTOISE, 1, "Mega Blastoise", Type.WATER, null, new int[] {79,103,120,135,115,78}, new Ability[] {Ability.MEGALAUNCHER}, new Ability[] {Ability.MEGALAUNCHER}, "The cannon on its back is as powerful as a tank gun. Its tough legs and back enable it to withstand the recoil from firing the cannon.", Item.BLASTOISITE),
  MEGAGENGAR(Species.GENGAR, 1, "Mega Gengar", Type.GHOST, Type.POISON, new int[] {60,65,80,170,95,130}, new Ability[] {Ability.SHADOWTAG}, new Ability[] {}, "The energy of Mega Evolution awakened it. It sinks into another dimension, where it keeps a patient watch for its chance to attack.", Item.GENGARITE),
  MEGAPIDGEOT(Species.PIDGEOT, 1, "Mega Pidgeot", Type.NORMAL, Type.FLYING, new int[] {83,80,80,135,80,121}, new Ability[] {Ability.NOGUARD}, new Ability[] {}, "With its muscular strength now greatly increased, it can fly continuously for two weeks without resting.", Item.PIDGEOTITE),
  MEGAGYARADOS(Species.GYARADOS, 1, "Mega Gyarados", Type.WATER, Type.DARK, new int[] {95,155,109,70,130,81}, new Ability[] {Ability.MOLDBREAKER}, new Ability[] {}, "It zooms out of the water at Mach speeds. Even large ships caught in its path are split cleanly in two!", Item.GYARADOSITE),
  MEGAAGGRON(Species.AGGRON, 1, "Mega Aggron", Type.STEEL, null, new int[] {70,140,230,60,80,50}, new Ability[] {Ability.FILTER}, new Ability[] {}, "Mega Evolution has granted this Pokémon incredibly powerful metal armor. Researchers are still trying to find a material that is capable of even scratching it.", Item.AGGRONITE),
  MEGAALTARIA(Species.ALTARIA, 1, "Mega Altaria", Type.DRAGON, Type.FAIRY, new int[] {75,110,110,110,105,80}, new Ability[] {Ability.PIXILATE}, new Ability[] {}, "This Pokémon's singing voice is even more beautiful than before it Mega-Evolved. Anyone who hears its singing is completely entranced, hanging on every note.", Item.ALTARIANITE),
  MEGAGARCHOMP(Species.GARCHOMP, 1, "Mega Garchomp", Type.DRAGON, Type.GROUND, new int[] {108,170,115,120,95,92}, new Ability[] {Ability.SANDFORCE}, new Ability[] {}, "Its vaunted wings become scythes, sending it mad with rage. It swings its scythes wildly and slices the ground to pieces.", Item.GARCHOMPITE),
  MEGATYRANITAR(Species.TYRANITAR, 1, "Mega Tyranitar", Type.ROCK, Type.DARK, new int[] {100,164,150,95,120,71}, new Ability[] {Ability.SANDSTREAM}, new Ability[] {}, "Due to the colossal power poured into it, this Pokémon's back split right open. Its destructive instincts are the only thing keeping it moving.", Item.TYRANITARITE),
  MEGASALAMENCE(Species.SALAMENCE, 1, "Mega Salamence", Type.DRAGON, Type.FLYING, new int[] {95,145,130,120,90,120}, new Ability[] {Ability.AERILATE}, new Ability[] {}, "It puts its forelegs inside its shell to streamline itself for flight. Salamence flies at high speeds over all kinds of topographical features.", Item.SALAMENCITE),
  MEGAFLYGON(Species.FLYGON, 1, "Mega Flygon", Type.BUG, Type.DRAGON, new int[] {80,110,90,140,80,120}, new Ability[] {Ability.AMPLIFIER}, new Ability[] {}, "The flapping of its wings sounds like singing. To prevent detection by enemies, it hides itself by flapping up a cloud of desert sand.", Item.FLYGONITE),
  MEGAMETAGROSS(Species.METAGROSS, 1, "Mega Metagross", Type.STEEL, Type.PSYCHIC, new int[] {95,145,130,120,90,120}, new Ability[] {Ability.TOUGHCLAWS}, new Ability[] {}, "Its intellect surpasses its previous level, resulting in battles so cruel, they'll make you want to cover your eyes.", Item.METAGROSSITE),
  GIRATINAORIGIN(Species.GIRATINA, 1, "Giratina-Origin", Type.DRAGON, Type.GHOST, new int[] {150,120,100,120,100,90}, new Ability[] {Ability.LEVITATE}, new Ability[] {}, "This Pokémon is said to live in a world on the reverse side of ours, where common knowledge is distorted and strange.", Item.GRISEOUSORB);
  
  private int FORM_NUMBER;
  private Species BASE;
  private String NAME;
  private Type TYPE1;
  private Type TYPE2;
  private int[] BASESTATS;
  private Ability[] ABILITIES;
  private Ability[] HIDDEN_ABILITY;
  private String POKEDEX_ENTRY;
  private Item MEGA_STONE;

  
/**
 *  enum constructor defining a form. needs the base species, form number, name, type, base stats, and if it is a mega evolution, the mega stone must be defined
 *
 *  @param base The base species
 *  @param form_number Number of the form
 *  @param name Name of the form
 *  @param type1 The first main type
 *  @param type2 The second main type
 *  @param base_stats The base stats of that form
 *  @param abilities The abilities that come with it
 *  @param hidden_ability The hidden abilities in that form
 *  @param pokedex_entry How it is entered into the pokedex
 *  @param mega_stone The mega stone of that form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Forms(Species base, int form_number, String name, Type type1, Type type2, int[] base_stats, Ability[] abilities, Ability[] hidden_ability, String pokedex_entry, Item mega_stone) {
    BASE = base;
    FORM_NUMBER = form_number;
    NAME = name;
    TYPE1 = type1;
    TYPE2 = type2;
    BASESTATS = base_stats;
    ABILITIES = abilities;
    HIDDEN_ABILITY = hidden_ability;
    POKEDEX_ENTRY = pokedex_entry;
    MEGA_STONE = mega_stone;
  }

  
/**
 *  Gets stats of the form
 *
 *  @return The base stats
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int[] getStats() {
    return BASESTATS;
  }

  
/**
 *  Gets mega stone of the form
 *
 *  @return The mega stone of the form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Item getMegaStone() {
    return MEGA_STONE;
  }

  
/**
 *  Gets name of the form
 *
 *  @return The name of the form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return NAME;
  }

  
/**
 *  Gets the first type of the form
 *
 *  @return The first type of the form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeOne() {
    return TYPE1;
  }

  
/**
 *  Gets the second type of the form
 *
 *  @return The second type of the form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeTwo() {
    return TYPE2;
  }

  
/**
 *  Gets the base form
 *
 *  @return The base form
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Species getBaseForm() {
    return BASE;
  }

  
/**
 *  Gets random ability, if it has multiple
 *
 *  @return A random ability if the form has multiple
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Ability getRandomAbility() {
    Random rand = new Random();
    return ABILITIES[rand.nextInt(ABILITIES.length)];
  }

  
/**
 *  Gets form number
 *
 *  @return Form number
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getFormNumber() {
    return FORM_NUMBER;
  }

  
}