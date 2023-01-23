/**
 *  Enum defining NPCs and their dialogue
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum NPC {
  
  PROFESSORTREE("Professor Tree", "Hello! Welcome to the world of Pokémon! Here you'll be able to explore the land, fight other Pokémon trainers and catch wild Pokémon! To see a map of the world look at the 'Output' window on your screen. Can you earn all 4 badges by defeating the strongest trainers here? \n\nIf you're a returning player press 0, if you're a new player press 1!", "Awesome! To begin, why don't you tell us your name?", true, null),
  SWAMPPERSON("Swamp Person", "Help! Help! There's a wild Nidoqueen in the swamp! Can you help me?", "blabalbal", false, null);
  
  private String name;
  private String dialogue;
  private String dialogue_switch;
  private boolean gave_item;
  private Trainer trainer;

  
/**
 *  Constructor defining NPC, including their dialogue, and whether they gave an item or not, and if they are a trainer
 *
 *  @param name Name of the NPC
 *  @param dialogue1 First type of dialogue
 *  @param dialogue2 Second type of dialogue
 *  @param gave_item Whether or not they already gave an item to the player
 *  @param t If they are a trainer
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private NPC(String name, String dialogue1, String dialogue2, boolean gave_item, Trainer t) {
    this.name = name;
    this.dialogue = dialogue1;
    this.dialogue_switch = dialogue2;
    this.gave_item = gave_item;
    this.trainer = t;
  }

  
/**
 *  gets item given by trainer
 *
 *  @return Whether or not they already gave an item to the player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean getGiveItem(){
    return gave_item;
  }

  
/**
 *  gets trainer object of the npc
 *
 *  @return trainer object of NPC
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Trainer getTrainer() {
    return this.trainer;
  }

  
/**
 *  gets dialogue of the trainer
 *
 *  @return Dialogue
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getDialogue() {
    return this.dialogue;
  }

  
/**
 *  gets second dialogue of the npc
 *
 *  @return Second dialogue
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getDialogueTwo() {
    return this.dialogue_switch;
  }

  
/**
 *  is this npc a trainer?
 *
 *  @return boolean if Trainer object is not null
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isTrainer() {
    return this.trainer != null;
  }

  
}