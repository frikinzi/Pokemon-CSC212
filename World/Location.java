import java.util.*;

/**
 *  Class for locations in the world
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Location {

 /** Locations in the Pokemon World */
  MOONFORKTOWN(new NPC[] {NPC.PROFESSORTREE}, Main.readSaveFile("Saves/moonfork_town.txt"), "Moonfork Town", new Interactable[] {}, null, 290, 230),
  MOONFORKTOWNPKMCENTER(new NPC[] {NPC.PROFESSORTREE}, null, "Moonfork Town Pokémon Center", new Interactable[] {}, null, 290, 230),
  PEAKPKMCENTER(new NPC[] {}, null, "Peak Pokémon Center", new Interactable[] {}, null, 390, 80),
  TANGLEPKMCENTER(new NPC[] {}, null, "Tangle Pokémon Center", new Interactable[] {}, null, 230, 40),
  GROVEPKMCENTER(new NPC[] {}, null, "Grove Pokémon Center", new Interactable[] {}, null, 90, 100),
  SANDSPKMCENTER(new NPC[] {}, null, "Sands Pokémon Center", new Interactable[] {}, null, 40, 150),
  STARGLASSKELPBED(new NPC[] {}, Main.readSaveFile("Saves/starglasskepbeld_trainers.txt"), "Starglass Kelpbed", new Interactable[] {}, null, 170, 400),
  IRONSWEEPRUINS(new NPC[] {}, Main.readSaveFile("Saves/iron_trainers.txt"), "Ironsweep Ruins", new Interactable[] {}, null, 290, 40),
  COPPERPEAK(new NPC[] {}, Main.readSaveFile("Saves/copper_trainers.txt"), "Copperlock Peak", new Interactable[] {}, null, 390,130),
  RUSTCRYISLE(new NPC[] {}, null, "Rustcry Isle", new Interactable[] {}, Main.readGymLeaderFile("Saves/gym_leaders/emma.txt"), 90, 400),
  BLAZEFACTORY(new NPC[] {}, Main.readSaveFile("Saves/factory_trainers.txt"), "Blazesting Factory", new Interactable[] {}, null, 290, 130),
  NEEDLESUMMIT(new NPC[] {}, Main.readSaveFile("Saves/needle_summit_trainers.txt"), "Needlejaw Summit", new Interactable[] {}, null, 390, 40),
  MISTGRASSLAND(new NPC[] {}, null, "Mistfront Grassland", new Interactable[] {}, Main.readGymLeaderFile("Saves/gym_leaders/amanda.txt"), 220, 130),
  BLIZZARDISLAND(new NPC[] {}, Main.readSaveFile("Saves/blizzard_trainers.txt"), "Blizzard Island", new Interactable[] {}, null, 90, 320),
  SWEETFLOATWATER(new NPC[] {}, Main.readSaveFile("Saves/sweet_trainers.txt"), "Sweetfloat Waterfront", new Interactable[] {}, null, 90, 320),
  SHORTBRUSHHOLLOW(new NPC[] {}, Main.readSaveFile("Saves/hollow_trainers.txt"), "Shortbrush Hollow", new Interactable[] {}, null, 90, 210),
  SHATTERDUNES(new NPC[] {}, Main.readSaveFile("Saves/dunes_trainers.txt"), "Shatterflash Dunes", new Interactable[] {}, Main.readGymLeaderFile("Saves/gym_leaders/pat.txt"), 40, 50),
  SUNSPOREFOREST(new NPC[] {}, null, "Sunspore Forest", new Interactable[] {}, Main.readGymLeaderFile("Saves/gym_leaders/clara.txt"), 90, 70),
  FLASHBREEZESWAMP(new NPC[] {}, Main.readSaveFile("Saves/swamp_trainers.txt"), "Flashbreeze Swamp", new Interactable[] {}, null, 240, 320);

  /** The NPC associated with a location */
  private NPC[] npcs;
  /** The trainers available at the location */
  private ArrayList<Trainer> trainer;
  /** The name of the location */
  private String name;
  /** The interactable function associated with the location */
  private Interactable[] interactable;
  /** The gym leader at the location */
  private GymLeader gym_leader;
  /** The x value of it's location on the map */
  private int x;
  /** The y value of it's location on the map */
  private int y;

  /** 
  *  Constructor to create a Location
  * @param npcs The NPC's associated with a location
  * @param trainer The trainers at a location
  * @param name The name of the location
  * @param interactable The interactable associated with a location
  * @param gym_leader The gym leader at a location
  * @param x The x value of it's location on the map
  * @param y The y value of it's location on the map 
  *
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  private Location(NPC[] npcs, ArrayList<Trainer> trainer, String name, Interactable[] interactable, GymLeader gym_leader, int x, int y) {
    this.npcs = npcs;
    this.trainer = trainer;
    this.name = name;
    this.interactable = interactable;
    this.gym_leader = gym_leader;
    this.x = x;
    this.y = y;
  }

  
  /** 
  * Gets the x value of the location on map
  * @return The x value of the location on map
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public int getX() {
    return this.x;
  }

  
  /** 
  * Gets the y value of the location on map
  * @return The y value of the location on map
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public int getY() {
    return this.y;
  }

  
  /** 
  * Gets the NPC array
  * @return The NPC Array of a Location
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public NPC[] getNPCs() {
    return this.npcs;
  }

  
  /** 
  * Gets the location name
  * @return The location name
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public String getName(){
    return this.name;
  }

  
  /** 
  * Gets trainers for a location
  * @return A list of trainers for the location
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public ArrayList<Trainer> getTrainers() {
    return this.trainer;
  }

  
  /** 
  * Gets gym leader, if any
  * @return A list of trainers for the location
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public GymLeader getGymLeader() {
    return this.gym_leader;
  }

  
}