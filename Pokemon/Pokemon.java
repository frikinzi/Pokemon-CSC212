import java.util.Random;
import java.util.*;

/**
 *  Class defining an individual Pokémon, including its stats in battle, individual abilities, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Pokemon {

  /** Is the Pokémon fainted? */
  private boolean fainted;
  
  /** species of the Pokémon */
  private Species species;

  /** level of the Pokémon, calculated by exp */
  private int level;

  /** exp of the Pokémon */
  private int exp;

  /** IVs of the Pokémon, range from 0-31 for each stat */
  private int[] iv;

  /** current HP of the Pokémon. if it falls to 0, the Pokémon is fainted */
  private int current_hp;

  /** Maximum HP of the Pokémon, calculated by its base HP, level, IVs and EVs */
  private int max_hp;

  /** effort values (EVs) of the Pokémon */
  private int[] ev;

  /** Moves of the Pokémon. Maximum of 4 */
  private Move[] moves;

  /** Status conditions of the Pokémon - poison, paralysis, sleep, burn, etc. */
  private String status;

  /** stats of the Pokémon, calculated by base stats */
  private int[] stats;

  /** nickname of the Pokémon */
  private String nickname;

  /** owner of the Pokémon */
  private Trainer owner;

  /** in battle stat boosts of the Pokémon. Should reset to 0 after every battle */
  private int[] stat_boosts;

  /** how many turns of bad poison has the Pokémon accumulated */
  private int toxic_turns;

  /** nature of the Pokémon - determines which stats are boosted and which are decreased */
  private Nature nature;

  /** critical hit stage of the Pokémon */
  private int crit_stage;

  /** if the Pokémon is holding a choice item (choice specs, scarf, etc.) which move did it select to be locked into */
  private Move choice_locked;

  /** held item of the Pokémon */
  private Item held_item;

  /** how many turns of sleep this Pokémon has left */
  private int sleep_counter;

  /** owner of the Pokémon */
  private int confusion_turns;

  /** the Pokémon's ability */
  private Ability ability;

  /** How many turns a Pokémon is resting */
  private int resting_turns;

  /** if the Pokémon is currently Destiny Bonded that turn - if knocked out, the attacker also faints */
  private boolean destiny_bond;

  /** the pp of the Pokémon's moves */
  private int[] pp;

  /** unimplemented: if the Pokémon is affected by Leech Seed */
  private boolean isSeeded;

  /** the Pokémon's first type */
  private Type typeone;

  /** the Pokémon's second type */
  private Type typetwo;

  /** the Pokémon's current form. if null, the Pokémon is in its base form */
  private Forms form;

  /** the Pokémon's base stats */
  private int[] base_stats;

  /** the Pokémon's move that is charging */
  private Move charging_move;

  /** is the Pokémon shiny */
  private boolean is_shiny;

  /** is the Pokémon flinching */
  private boolean flinch;

  
/**
 *  Constructor taking in the Pokémon's species, level and owner (Trainer object)
 *
 *  @param species Pokemon species
 *  @param level Pokemon level
 *  @param owner Owner of Pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Pokemon(Species species, int level, Trainer owner) {
    this.species = species;
    this.nature = Util.randomNature(Nature.class);
    this.base_stats = this.species.getBaseStats();
    this.held_item = null;
    this.crit_stage = 0;
    this.fainted = false;
    this.level = level;
    // evs start at 0
    this.ev = new int[] {0,0,0,0,0,0};
    this.stat_boosts = new int[] {0,0,0,0,0,0};
    this.iv = new int[6];
    this.moves = new Move[4];
    this.sleep_counter = 0;
    this.confusion_turns = 0;
    // randomize IVs
    for(int i = 0; i < iv.length; i++) {
      iv[i] = (byte)(Math.random() * 32);
    }
    this.nickname = this.species.getName();
    this.exp = this.level * this.level * this.level;
    this.stats = getStats();
    this.max_hp = stats[0];
    this.current_hp = stats[0];
    // set to last 4 level up movesets
    initializeMoves();
    this.pp = new int[4];
    for (int j = 0; j < 4; j++) {
      if (this.getMove(j) != null) {
        this.pp[j] = this.getMove(j).getPP();
      }
    }
    this.status = "";
    this.toxic_turns = 1;
    this.owner = owner;
    this.ability = this.species.getRandomAbility();
    this.resting_turns = 0;
    this.destiny_bond = false;
    this.choice_locked = null;
    this.typeone = this.species.getTypeOne();
    this.typetwo = this.species.getTypeTwo();
    this.form = null;
    this.charging_move = null;
    this.flinch = false;

    Random r = new Random();
    if (r.nextInt(4097)  == 1) {
      this.is_shiny = true;
    } else {
      this.is_shiny = false;
    }
  }
  
/**
 *  Returns Pokémon's current level by getting the cube root of its EXP
 *
 *  @return Current level of Pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getLevel() {
    return (int)Math.cbrt(this.exp);
  }

  
/**
 *  Sets Pokemon's current level, and recalculates its stats
 *
 *  @param i The level to be set
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setLevel(int i) {
    this.exp = i * i * i;
    this.level = i;
    this.stats = getStats();
  }
  

/**
 *  Returns the Pokemon's exp
 *  @return Pokémon's exp
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getExp() {
    return this.exp;
  }

  
/**
 *  Gets Pokémon's nickname
 *
 *  @return Pokémon's nickname
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String getNickname() {
    return this.nickname;
  }

  
/**
 *  Sets Pokémon's nickname
 *
 *  @param s The nickname to be set
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setNickname(String s) {
    this.nickname = s;
  }

  
/**
 *  Gets Pokémon's ability
 *
 *  @return The ability of pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Ability getAbility() {
    return this.ability;
  }


/**
 *  Sets Pokémon's ability
 *
 *  @param a The new ability
 *  @param a The ability to be set
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setAbility(Ability a) {
    this.ability = a;
  }

  
/**
 *  Checks if Pokémon has ability
 *
 *  @param a Ability to be checked
 *  @return True if Pokémon has ability
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasAbility(Ability a) {
    return this.ability == a;
  }

  
/**
 *  Sets Pokémon's ability
 *
 *  @param a The integer for the ability
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setAbility(int a) {
    try {
      this.ability = this.species.getAbilities()[a];
    } catch (Exception e) {
      System.out.println("Not a valid index number for this Pokémon's abilities");
    }
  }

  
/**
 *  Checks if Pokémon is resting from a move such as Hyper Beam, Giga Impact, etc.
 *
 *  @return True if Pokémon is resting
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isResting() {
    return this.resting_turns > 0;
  }

  
/**
 *  Sets Pokémon's resting turns
 *
 *  @param resting The number of turns to rest - typically 2
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setResting(int resting) {
    this.resting_turns = resting;
  }

  
/**
 *  Decrement a Pokémon's resting turns
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void decrementResting() {
    this.resting_turns -= 1;
  }

  
/**
 *  Does this Pokémon's have Destiny Bond active - if so, if it is knocked out, the opponent will faint
 *
 *  @return True if Pokémon has Destiny Bond active
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isDestinyBond() {
    return this.destiny_bond;
  }

  
/**
 *  Set Pokémon Destiny Bond based on input
 *
 *  @param b The inputted boolean
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setDestinyBond(boolean b) {
    this.destiny_bond = b;
  }

  
/**
 *  Returns Pokémon's choice locked move
 *
 *  @return Choice-locked move 
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Move getChoiceLockedMove() {
    return this.choice_locked;
  }

  
/**
 *  Returns whether a Pokémon is choice-locked
 *
 *  @return True if Pokémon is choice-locked
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isChoiceLocked() {
    if (this.getHeldItem() == null) {
      return false;
    }
    return this.choice_locked != null;
  }

  
/**
 *  Sets Pokémon's choice-locked move - typically due to Choice Band, Choice Specs, etc.
 *
 *  @param move The move to lock the Pokémon into
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setChoiceLockedMove(Move move) {
    if (this.getHeldItem() == null) {
      this.choice_locked = null;
      return;
    }
    this.choice_locked = move;
  }

  
/**
 *  Removes Pokémon's item and returns the item to the owner's inventory
 *
 *  @return Item removed
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Item removeHeldItem() {
    if (this.held_item == null) {
      return null;
    } 
    Item i = this.held_item;
    this.owner.addToInventory(this.held_item);
    this.setHeldItem(null);
    return i;
  }

  
/**
 *  Give Pokémon held item, and removes it from the owner's inventory. Fails if owner doesn't have item in inventory.
 *
 *  @param item Item to be given
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void giveHeldItem(Item item) {
    if (!this.owner.hasItem(item)) {
      System.out.println("You don't have that item!");
      return;
    }
    if (this.held_item == null) {
      this.setHeldItem(item);
      this.owner.removeFromInventory(item);
      System.out.println(this.getNickname() + " was given " + item.getName() + " to hold.");
      return;
    } else {
      this.owner.addToInventory(this.held_item);
      this.setHeldItem(item);
      this.owner.removeFromInventory(item);
      System.out.println(this.getNickname() + " was given " + item.getName() + " to hold.");
    } 
  }

  
/**
 *  Sets Pokémon's held item (does not alter owner's inventory)
 *
 *  @param item Item for Pokémon to hold
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setHeldItem(Item item) {
    this.held_item = item;
  }

  
/**
 *  Returns Pokémon's held item
 *
 *  @return Item held, or null if none
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Item getHeldItem() {
    return this.held_item;
  }

  
/**
 *  Sets Pokémon charging move - typically used for 2-turn moves such as Solar Beam, etc.
 *
 *  @param m Move that is charging
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setChargingMove(Move m) {
    this.charging_move = m;
    if (m == Move.SOLARBEAM) {
      System.out.println(this.getNickname() + " is taking in sunlight!");
    }
  }

  
/**
 *  Returns whether the Pokémon has a move that is charging that will be used the next turn
 *
 *  @return True if Pokémon has move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasChargingMove() {
    return this.charging_move != null;
  }

  
/**
 *  Returns Pokémon's charging move - i.e. Solar Beam
 *
 *  @return The charging move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Move getChargingMove() {
    return this.charging_move;
  }

  
/**
 *  Gets Pokémon's IV based on the index. 0 = hp, 1 = atk, etc,
 *
 *  @param i Inputted index
 *  @return The Pokemon's IV (e.g. hp, atk)
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getIVByIndex(int i) {
    return this.iv[i];
  }

  
/**
 *  Gets Pokémon's EV based on the index. 0 = hp, 1 = atk, etc,
 *
 *  @param i Inputted index
 *  @return The Pokemon's EV (e.g. hp, atk)
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getEVByIndex(int i) {
    return this.ev[i];
  }

  
/**
 *  Calculates Pokémon's HP stat
 *
 *  @return HP stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateHP() {
    return (int)Math.floor(0.01 * (2 * this.base_stats[0] + iv[0] + Math.floor(0.25 * ev[0])) * this.getLevel()) + 10 + this.getLevel();
  }

  
/**
 *  Calculates Pokémon's Attack stat
 *
 *  @return Attack stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateAttack() {
    double atk = Math.floor(0.01 * (2 * this.base_stats[1] + iv[1] + Math.floor(0.25 * ev[1])) * this.getLevel()) + 5;
    if (this.nature.getStatBoosted() == 1) {
      atk *= 1.1;
    } 
    if (this.nature.getStatDecreased() == 1) {
      atk *= 0.9;
    }
    return (int)atk;
  }

  
/**
 *  Calculates Pokémon's Def stat
 *
 *  @return Def stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateDefense() {
    double def = Math.floor(0.01 * (2 * this.base_stats[2] + iv[2] + Math.floor(0.25 * ev[2])) * this.getLevel()) + 5;
    if (this.nature.getStatBoosted() == 2) {
      def *= 1.1;
    } 
    if (this.nature.getStatDecreased() == 2) {
      def *= 0.9;
    }
    return (int)def;
  }

  
/**
 *  Calculates Pokémon's Special attack stat
 *
 *  @return Special attack stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateSpecialAttack() {
    double spA = Math.floor(0.01 * (2 * this.base_stats[3] + iv[3] + Math.floor(0.25 * ev[3])) * this.getLevel()) + 5;
    if (this.nature.getStatBoosted() == 3) {
      spA *= 1.1;
    } if (this.nature.getStatDecreased() == 3) {
      spA *= 0.9;
    }
    return (int)spA;
  }

  
/**
 *  Calculates Pokémon's Special Defense stat
 *
 *  @return Special Defense stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateSpecialDefense() {
    double spd = Math.floor(0.01 * (2 * this.base_stats[4] + iv[4] + Math.floor(0.25 * ev[4])) * this.getLevel()) + 5;
    if (this.nature.getStatBoosted() == 4) {
      spd *= 1.1;
    } 
    if (this.nature.getStatDecreased() == 4) {
      spd *= 0.9;
    }
    return (int)spd;
  }

  
/**
 *  Calculates Pokémon's Speed stat
 *
 *  @return Speed stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateSpeed() {
    double sp = Math.floor(0.01 * (2 * this.base_stats[5] + iv[5] + Math.floor(0.25 * ev[5])) * this.getLevel()) + 5;
    if (this.nature.getStatBoosted() == 5) {
      sp *= 1.1;
    } 
    if (this.nature.getStatDecreased() == 5) {
      sp *= 0.9;
    }
    return (int)sp;
  }

  
/**
 *  Calculates Pokémon stat modifiers based on stat boost stage
 *
 *  @param i Boost number
 *  @return The modifier for stat
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getMultiplierByStage(double i) {
    if (i == -1.0) {
      return 0.66;
    } else if (i == -2.0) {
      return 0.5;
    } else if (i == -3.0) {
      return 0.4;
    } else if (i == -4.0) {
      return 0.33;
    } else if (i == -5.0) {
      return 0.28;
    } else if (i == -6.0) {
      return 0.25;
    }
    else if (i == 1) {
      return 1.5;
    } else if (i == 2) {
      return 2.0;
    } else if (i == 3) {
      return 2.5;
    } else if (i == 4) {
      return 3.0;
    } else if (i == 5) {
      return 3.5;
    } else if (i == 6) {
      return 4.0;
    } 
    return 1.0;
  }

  
/**
 *  Calculates Pokémon's Defense stat in battle, also taking account of stat boosts
 *
 *  @return In battle defense stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getInBattleDefense() {
    return (int)(stats[2] * this.getDefenseBoost());
  }

  
/**
 *  Calculates Pokémon's Attack stat in battle, also taking account of stat boosts
 *
 *  @return In battle Attack stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getInBattleAttack() {
    int atk = (int)(stats[1] * this.getAttackBoost());
    return atk;
  }

  
/**
 *  Calculates Pokémon's Special Attack stat in battle, also taking account of stat boosts
 *
 *  @return In battle Special Attack stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getInBattleSpecialAttack() {
    int spa = (int)(stats[3] * this.getSpecialAttackBoost());
    return spa;
  }

  
/**
 *  Calculates Pokémon's Special Defense stat in battle, also taking account of stat boosts, weather boosts, and items
 *
 *  @param field Battlefield
 *  @return In battle Special Defense stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getInBattleSpecialDefense(Battle field) {
    double spd = (stats[4] * this.getSpecialDefenseBoost());
    if (this.getHeldItem() == Item.ASSAULTVEST) {
      spd *= 1.5;
    }
    if (this.hasType(Type.ROCK) && field.getWeather() == Weather.SANDSTORM) {
      spd *= 1.5;
    }
    return (int)(spd);
  }

  
/**
 *  Calculates Pokémon's in battle Speed stat in battle, also taking account of stat boosts, paralysis, weather, etc.
 *
 *  @param field Battlefield
 *  @return In battle defense stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getInBattleSpeed(Battle field) {
    int i = (int)(stats[5] * this.getSpeedBoost());
    if (this.isParalyzed()) {
      i *= 0.25;
    }
    if (this.hasAbility(Ability.CHLOROPHYLL) && field.getWeather() == Weather.SUN) {
      i *= 2.0;
    }
    if (this.getHeldItem() == Item.CHOICESCARF) {
      i *= 1.5;
    }
    return i;
  }

  
/**
 *  Calculates Pokémon's stats
 *
 *  @return In battle defense stat of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int[] getStats() {
    int[] stats = new int[] {this.calculateHP(), this.calculateAttack(), this.calculateDefense(), this.calculateSpecialAttack(), this.calculateSpecialDefense(), this.calculateSpeed()};
    return stats;
  }

  
/**
 *  Gets Pokémon's nature (aka determines which stats are boosted or nerfed)
 *
 *  @return Nature of Pokémon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Nature getNature() {
    return this.nature;
  }

  
/**
 *  Sets Pokémon's nature
 *
 *  @param n Nature of Pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setNature(Nature n) {
    this.nature = n;
  }

  
/**
 *  checks if Pokémon has an empty move slot
 *
 *  @return True if it has empty slot
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasEmptyMoveSlot() {
    for(int i = 0; i < moves.length; i++) {
      if (moves[i] == null) {
        return true;
      } 
    }
    return false;
  }

  
/**
 *  Returns Pokémon's moves
 *
 *  @return Array of Move values
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Move[] getMoves() {
    return moves;
  }

  
/**
 *  checks if Pokémon has 4 moves
 *
 *  @return True if has 4 moves
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasFourMoves() {
    for (Move m : moves) {
      if (m == null) {
        return false;
      }
    } return true;
  }


/**
 *  checks for Pokémon's next open moveslot
 *
 *  @return Integer index of open move slot or -1 if none
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int nextOpenMoveSlot() {
    for (int i = 0; i < 4; i++) {
      if (moves[i] == null) {
        return i;
      }
    } 
    return -1;
  }


/**
 *  Returns move given index
 *
 *  @param i Index
 *  @return The move at that index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Move getMove(int i) {
    return moves[i];
  }

  
/**
 *  Sets Pokémon's moves
 *
 *  @param m Array of Move values
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setMoves(Move[] m) {
    this.moves = m;
  }

  
/**
 *  checks if Pokémon has a certain move
 *
 *  @param m The specific move 
 *  @return True if it has that move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasMove(Move m) {
    for (int i = 0; i < 4; i++) {
      if (moves[i] == m) {
        return true;
      }
    } 
    return false;
  }


/**
 *  return Pokémon's pp
 *
 *  @param i Inputted index
 *  @return The pp at that index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getMovePP(int i) {
    return pp[i];
  }

  
/**
 *  sets Pokémon's move at index i
 *
 *  @param Index of move (must be from 0-3)
 *  @param m The move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setMove(int i, Move m) {
    if (i >= 4 || i < 0) {
      return;
    }
    moves[i] = m;
    pp[i] = m.getPP();
  }


/**
 *  sets Pokémon's IVs with array of int
 *
 *  @param i Array of integers
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setIVs(int[] i) {
    this.iv = i;
  }

  
/**
 *  sets Pokémon's EVs with array of int
 *
 *  @param i Array of integers
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setEVs(int[] i) {
    this.ev = i;
  }

  
/**
 *  Trains Pokémon's EV stat based on a Pokémon it defeated
 *
 *  @param ev_Trained Integer array, typically the defeated Pokémon's EV yield
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void trainEVStat(int[] ev_Trained) {
    if (this.isFullyEVTrained()) {
      return;
    }
    for (int i = 0; i< 6;i++) {
      if (this.ev[i] == 255) {
        return;
      } 
      int old_sum = this.sumEVs();
      if (old_sum + i > 510) {
        i = 510 - old_sum;
      }
      this.ev[i] += ev_Trained[i];
      if (this.ev[i] > 255) {
        this.ev[i] = 255;
      }
    }
  }

  
/**
 *  Is Pokémon fully EV trained? i.e. has 510 EV points
 *
 *  @return boolean
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isFullyEVTrained() {
    int sum = sumEVs();
    if (sum >= 510) {
      return true;
    } 
    return false;
  }

  
/**
 *  Sums all of a Pokémon's EVs
 *
 *  @return Int sum of EVs
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int sumEVs() {
    int sum = 0;
    for (int i : this.ev) {
      sum += i;
    }
    return sum;
  }

  
/**
 *  Restores a Pokémon's PP for all of its moves
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void restoreAllPP() {
    for (int j = 0; j < 4; j++) {
      if (this.getMove(j) != null) {
        this.pp[j] = this.getMove(j).getPP();
      }
    }
  }

  
/**
 *  Does this Pokémon's have any moves with PP left?
 *
 *  @return True if it has moves left
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasRunOutOfPP() {
    // choice items
    if (this.choice_locked != null) {
      if (this.getMovePP(getMoveIndex(this.choice_locked)) <= 0) {
        return true;
      }
    }
    for (int i : this.pp) {
      if (i > 0) {
        return false;
      }
    }
    return true;
  }

  
/**
 *  Decrements Pokémon's PP for a given move
 *
 *  @param m Move to be checked
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void decrementPP(Move m) {
    try {
      this.pp[getMoveIndex(m)] -= 1;
      if (this.pp[getMoveIndex(m)] < 0) {
        this.pp[getMoveIndex(m)] = 0;
      }
    } catch (Exception e) {
      System.out.println("Something went wrong");
    }
  }

  
/**
 *  Get index of this Pokémon's move
 *
 *  @param m The specific move
 *  @return The index of that move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getMoveIndex(Move m) {
    int counter = 0;
    for (Move move : this.moves) {
      if (m == move) {
        return counter;
      } counter += 1;
    } 
    return -1; // not found
  }

  
/**
 *  decrements Pokémon's PP given Move's index
 *
 *  @param i Inputted index
 *  @author Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void decrementPP(int i) {
    if (pp[i] == 0) {
      return;
    }
    pp[i] -= 1;
  }

  
/**
 *  Restores Pokémon's PP given integer index of move
 *
 *  @param i Index of move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void restorePP(int i) {
    pp[i] = moves[i].getPP();
  }

  
/**
 *  Does a Pokémon have a move at a given index
 *
 *  @param i Index to check
 *  @return True if it has the move, false if not
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasMove(int i) {
    if (this.moves[i] == null) {
      return false;
    } 
    return true;
  }

  
/**
 *  Does this Pokémon have the input type?
 * 
 *  @param t Type to be checked
 *  @return True if it has the type
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasType(Type t) {
    if (this.getTypeOne() == t || this.getTypeTwo() == t) {
      return true;
    } 
    return false;
  }

  
/**
 *  Initialize Pokemon's moves based on its learnset
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void initializeMoves() {
    int temp = this.level;
    while (temp != 0 && (this.hasEmptyMoveSlot())) {
      if (this.species.getMoveLearned(temp) == null) {
        temp -= 1;
      } else {
        if (moves[0] == null) {
          moves[0] = this.species.getMoveLearned(temp);
        } else if (moves[1] == null) {
          moves[1] = this.species.getMoveLearned(temp);
        } else if (moves[2] == null) {
          moves[2] = this.species.getMoveLearned(temp);
        } else {
          moves[3] = this.species.getMoveLearned(temp);
        }
        temp -= 1;
      }
    }
  }

  
/**
 *  Levels up the pokemon and recalculates its stats
 *
 *  @param Type to be checked
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void levelUp() {
    this.level += 1;
    // recalculate stats
    this.stats = this.getStats();
    if (this.getSpecies().getMoveLearned(this.level) != null) {
      Util.teachMove(new Scanner(System.in), this.getSpecies().getMoveLearned(this.level), this);
    }
  }

  
/**
 *  This Pokemon gains experience
 *
 *  @param i Inputted index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void gainExperience(int i) {
    this.exp += i;
    for (Pokemon p : this.getOwner().getParty()) {
      if (p != null && p != this) {
        p.simpleGainExp(i / 2);
        if (p.exp > 100 * 100 * 100) {
          p.exp = 100 * 100 * 100;
        }
        if (p.getLevel() > p.level) {
          System.out.println("Leveled up! Now " + p.nickname + " is level " + p.getLevel() + "!");
          p.levelUp();
        }
      }
    }
    // level cap at 100
    if (this.exp > 100 * 100 * 100) {
      this.exp = 100 * 100 * 100;
    }
    if (this.getLevel() > this.level) {
      System.out.println("Leveled up! Now " + this.nickname + " is level " + this.getLevel() + "!");
      this.levelUp();
    }
  }

  
/**
 *  Simplified gain experienced method
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void simpleGainExp(int i) {
    this.exp += i;
  }

  
/**
 *  gets pokemon's current HP
 *
 *  @return The current HP
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getCurrentHP() {
    return this.current_hp;
  }

  
/**
 *  sets this pokemon's current hp
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setCurrentHP(int i) {
    this.current_hp = i;
  }

  
/**
 *  Gets pokemon's max hp, calculated from its base stats
 *
 *  @return Max HP of pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getMaxHP() {
    this.max_hp = this.calculateHP();
    return this.max_hp;
  }

  
/**
 *  is this pokemon at full health?
 *
 *  @return True if at full health
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isAtFullHealth() {
    return this.current_hp == this.max_hp;
  }

  
/**
 *  Returns if this pokemon is mega evolved
 *
 *  @return False if not mega evolved, returns form if it is
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isMegaEvolved() {
    if (this.form == null) {
      return false;
    }
    return this.form != null && this.getHeldItem() == this.form.getMegaStone();
  }

  
/**
 *  method to let pokemon take damage. if pokemon has the ability sturdy and is at full health, it will be left with one hp
 *
 *  @param damage Amount of damage
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeDamage(int damage) {
    if (this.current_hp == this.max_hp && damage >= this.max_hp && (this.hasAbility(Ability.STURDY) || this.held_item == Item.FOCUSSASH)) {
      damage = max_hp - 1;
      System.out.println(this.getNickname() + " endured the hit!");
      if (this.held_item == Item.FOCUSSASH) {
        this.held_item = null;
      }
    }
    this.current_hp -= damage;
    if (this.current_hp < 0) {
      this.current_hp = 0;
    }
    if (this.isFainted()) {
      if (this.isMegaEvolved()) {
        this.revertToBaseForm();
      }
      Util.printFaintedMessage(this);
    }
  }

  
/**
 *  Gets pokemon's attacks modifiers (i.e. if it is burned, physical moves are 1/2 the power)
 *
 *  @param move Move to be checked
 *  @return The attack modifier
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getModifiers(Move move) {
    Random r = new Random();
    double randomValue = 0.85 + (1.0 - 0.85) * r.nextDouble(); // roll
    double modifier = 1.0;
    if (move.getType() == this.getTypeOne() || move.getType() == this.getTypeTwo()) {
      modifier *= 1.5; //STAB bonus
    }
    if (move.getType() == Type.FREEZEDRY && this.hasType(Type.ICE)) {
      modifier *= 1.5; //STAB bonus
    }
    modifier *= randomValue;
    if (move.getMoveType() == MoveType.PHYSICAL && this.isBurned()) {
      modifier *= 0.5; //physical attacks weakened when burned
    } 
    if (move.getMoveType() == MoveType.PHYSICAL && this.getHeldItem() == Item.CHOICEBAND) {
      modifier *= 1.5; //physical attacks stronger when holding choice band
    } 
    if (move.getMoveType() == MoveType.SPECIAL && this.getHeldItem() == Item.CHOICESPECS) {
      modifier *= 1.5; //special attacks stronger when holding choice specs
    }
    if (this.held_item == Item.ADAMANTORB && this.getSpecies() == Species.DIALGA && (move.getType() == Type.DRAGON || move.getType() == Type.STEEL)) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.LUSTROUSORB && this.getSpecies() == Species.PALKIA && (move.getType() == Type.DRAGON || move.getType() == Type.WATER)) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.GRISEOUSORB && this.getSpecies() == Species.GIRATINA && (move.getType() == Type.DRAGON || move.getType() == Type.GHOST)) {
      modifier *= 1.2;
    }
    if (this.getCurrentHP() < (1.0 / 3.0 * this.getMaxHP()) && this.getAbility() == Ability.BLAZE && move.getType() == Type.FIRE) {
      modifier *= 1.5;
    }
    if (this.getCurrentHP() < (1.0 / 3.0 * this.getMaxHP()) && this.getAbility() == Ability.TORRENT && move.getType() == Type.WATER) {
      modifier *= 1.5;
    }
    if (this.getCurrentHP() < (1.0 / 3.0 * this.getMaxHP()) && this.getAbility() == Ability.OVERGROW && move.getType() == Type.GRASS) {
      modifier *= 1.5;
    }
    if (move.isContactMove() && this.getAbility() == Ability.TOUGHCLAWS) {
      modifier *= 1.3;
    }
    if (move.isPulseMove() && this.getAbility() == Ability.MEGALAUNCHER) {
      modifier *= 1.5;
    }
    if (move.isSoundMove() && this.getAbility() == Ability.AMPLIFIER) {
      modifier *= 1.5;
    }
    if (move.getBasePower() <= 60 && this.getAbility() == Ability.TECHNICIAN) {
      modifier *= 1.5;
    }
    if (this.getHeldItem() == Item.LIFEORB) {
      modifier *= 1.5;
    }
    if (this.hasAbility(Ability.SHEERFORCE) && move.hasSideEffect()) {
      modifier *= 1.3;
    }
    if (this.hasAbility(Ability.AERILATE) && move.getOriginalType() == Type.NORMAL) {
      modifier *= 1.3;
    }
    if (this.hasAbility(Ability.PIXILATE) && move.getOriginalType() == Type.NORMAL) {
      modifier *= 1.3;
    }
    if ((this.held_item == Item.MYSTICWATER || this.held_item == Item.SPLASHPLATE) && move.getType() == Type.WATER) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.FLAMEPLATE && move.getType() == Type.FIRE) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.MEADOWPLATE && move.getType() == Type.GRASS) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.SPOOKYPLATE && move.getType() == Type.GHOST) {
      modifier *= 1.2;
    }
    if (this.held_item == Item.ZAPPLATE && move.getType() == Type.ELECTRIC) {
      modifier *= 1.2;
    }
    return modifier;
  }

  
/**
 *  Returns the critical hit stage of the pokemon
 * 
 *  @return The critical stage
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getCriticalHitStage() {
    return this.crit_stage;
  }

  
/**
 *  Checks if the move this pokemon used is a critical hit
 *
 *  @param move Move to be checked
 *  @return True if move can be used as critical hit
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isCriticalHit(Move move) {
    Random r = new Random();
    if (r.nextDouble() < this.criticalHitChance(this.getCriticalHitStage(), move)) {
      return true;
    }
    return false;
  }

  
/**
 *  Gets Pokemon's species
 *
 *  @return The species of the Pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Species getSpecies() {
    return this.species;
  }

  
/**
 *  Gets pokemon's first type
 *
 *  @return Pokemon's first type
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeOne() {
    return this.typeone;
  }

  
/**
 *  Gets pokemon's second type
 *
 *  @return Pokemon's second type
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeTwo() {
    return this.typetwo;
  }

  
/**
 *  Gets the effectiveness of the parameter type against this pokemon
 *
 *  @param type Type to be checked
 *  @return The multiplier associated with type effectiveness
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getTypeEffectiveness(Type type) {
    double i = 1.0;
    if (type == null) {
      return i;
    }
    if (typeone == null) {
      return i;
    }
    if (type.isSuperEffectiveOn(this.typeone.getName())) {
      i *= 2;
    } 
    if (type.isNotVeryEffectiveOn(this.typeone.getName())) {
      i *= 0.5;
    } 
    if (type.hasNoEffect(this.typeone.getName())) {
      i *= 0;
    }
    if (this.typetwo != null) {
      if (type.isSuperEffectiveOn(this.typetwo.getName())) {
        i *= 2;
      } 
      if (type.isNotVeryEffectiveOn(this.typetwo.getName())) {
        i *= 0.5;
      } 
      if (type.hasNoEffect(this.typetwo.getName())) {
        i *= 0;
      }
    }
    if (this.hasAbility(Ability.LEVITATE) && type == Type.GROUND) {
      i *= 0;
    }
    return i;
  }

  
/**
 *  Calculates damage of a move based on base power, defense and attack
 *
 *  @param base_power Base power of pokemon
 *  @param defense Defense level of pokemon
 *  @param attack Attack level of pokemon
 *  @return Damage the move causes
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calcDamage(int base_power, int defense, int attack) {
    return (int)((((0.4)* this.level + 2)* base_power * (double)attack / (double)defense) / 50.0 + 2);
  }

  
/**
 *  this Pokémon attacks the target with a move. also calculates many modifiers based on each pokemon's ability, and move effects. this method also checks if a move is interuptted (i.e. if it misses, if the pokemon is confused and hits itself, if it gets full paralyzed, etc.)
 *
 *  @param move this Pokemon used, target of move, battle field the pokemon are in
 *  @param target Pokemon target
 *  @param field Battlefield
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void attack(Move move, Pokemon target, Battle field) {
    int damage = 0;
    if (move.getSpecialEffect().equals("DecreasePowerLowerHP")) {
      move.setBasePower((int)((150.0 * this.getCurrentHP()) / this.getMaxHP()));
    }
    if (move == Move.CONFUSIONHIT) {
      damage = (int)(((((0.4)* this.level + 2)* move.getBasePower() *(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move));
      target.takeDamage(damage);
      return;
    }
    if (!executeMoveSuccessfully(move, target, field)) {
      return;
    }
    if (this.hasAbility(Ability.AERILATE) && move.getType() == Type.NORMAL) {
      move.setType(Type.FLYING);
    }
    if (this.hasAbility(Ability.PIXILATE) && move.getType() == Type.NORMAL) {
      move.setType(Type.FAIRY);
    }
    if (move.getSpecialEffect().equals("TwoTurn") && this.getChargingMove() == null) {
      if (move == Move.SOLARBEAM && field.getWeather() == Weather.SUN) {
      } else {
        this.setChargingMove(move);
        return;
      }
    }
    System.out.println(this.getNickname() + " used " + move.getName() + "!");
    if (move.getMoveType() == MoveType.STATUS) {
      this.decrementPP(move);
      if (target.getAbility() == Ability.PRESSURE) {
        this.decrementPP(move);
      } 
      if (move.getSpecialEffect().equals("Defog")) {
        System.out.println("Entry hazards were cleared.");
        field.getOpposingEntryHazard(this.getOwner()).clear();
        field.getOwnHazards(this.getOwner()).clear();
      }
      if (move.getSpecialEffect().equals("SetSpikes")) {
        if (Collections.frequency(field.getOpposingEntryHazard(this.getOwner()), "Spikes") == 3) {
          System.out.println("But it failed!");
          return;
        } 
        System.out.println("A layer of spikes was set on the battlefield.");
        field.getOpposingEntryHazard(this.getOwner()).add("Spikes");
      }
      if (move.getSpecialEffect().equals("SetToxicSpikes")) {
        if (Collections.frequency(field.getOpposingEntryHazard(this.getOwner()), "ToxicSpikes") == 2) {
          System.out.println("But it failed!");
          return;
        } 
        System.out.println("A layer of toxic spikes was set on the battlefield.");
        field.getOpposingEntryHazard(this.getOwner()).add("ToxicSpikes");
      }
      if (move.getSpecialEffect().equals("SetStickyWeb")) {
        if (field.getOpposingEntryHazard(this.getOwner()).contains("StickyWeb")) {
          System.out.println("But it failed!");
          return;
        }
        System.out.println("A sticky web was laid on the ground!");
        field.getOpposingEntryHazard(this.getOwner()).add("StickyWeb");
      }
      if (move.getSpecialEffect().equals("SetStealthRock")) {
        if (field.getOpposingEntryHazard(this.getOwner()).contains("StealthRock")) {
          System.out.println("But it failed!");
          return;
        }
        System.out.println("Pointed stones float on the opposing side of the battlefield!");
        field.getOpposingEntryHazard(this.getOwner()).add("StealthRock");
      }
      move.applyEffectSelf(this);
      //System.out.println("hah");
      move.applySpecialEffect(this, target, field);
      return;
    }
    if (move.getMoveType() == MoveType.PHYSICAL) {
      if (this.isCriticalHit(move) && !target.hasAbility(Ability.SHELLARMOR)) {
        int physical_attack = this.getInBattleAttack();
        if (this.getAttackBoost() < 1.0) {
          physical_attack = this.calculateAttack();
        }
        damage = (int)(((((0.4)* this.level + 2)* move.getBasePower()*(double)physical_attack / (double)target.calculateDefense())/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move) * 1.5);
        System.out.println("A critical hit!");
      } else {
        damage = (int)(((((0.4)* this.level + 2)* move.getBasePower() *(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move));
      }
      if (field.getWeather() == Weather.SUN && this.hasAbility(Ability.ORICHALCUMPULSE)) {
        damage *= 1.3;
      } 
      if (field.getTerrain() == Weather.ELECTRICTERRAIN && move.getType() == Type.ELECTRIC && !this.isAirborne()) {
        damage *= 1.5;
      }
    }
    if (move.getMoveType() == MoveType.SPECIAL) {
      if (this.isCriticalHit(move) && !target.hasAbility(Ability.SHELLARMOR)) {
        int special_attack = this.getInBattleSpecialAttack();
        if (this.getSpecialAttackBoost() < 1.0) {
          special_attack = this.calculateSpecialAttack();
        }
        damage = (int)(((((0.4)*this.level+2)* move.getBasePower() *((double)special_attack / (double)target.calculateSpecialDefense()))/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move) * 1.5);
        System.out.println("A critical hit!");
      } else {
      damage = (int)(((((0.4)*this.level+2)* move.getBasePower() *((double)this.getInBattleSpecialAttack() / (double)target.getInBattleSpecialDefense(field)))/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move));
      }
      if (target.hasAbility(Ability.ICESCALES)) {
        damage *= 0.5;
      }
      if (field.getTerrain() == Weather.ELECTRICTERRAIN && this.hasAbility(Ability.HADRONENGINE)) {
        damage *= 1.3;
      }
    }
    int current_health_target = target.current_hp;
    if (target.getAbility() == Ability.MULTISCALE && target.getCurrentHP() == target.getMaxHP()) {
      damage *= 0.5;
    }
    if (field.getWeather() == Weather.SUN && move.getType() == Type.FIRE) {
      damage *= 1.5;
    }
    if (target.calculateSpeed() > this.calculateSpeed() && this.hasAbility(Ability.ANALYTIC)) {
      damage *= 1.3;
    }
    if (field.getWeather() == Weather.SUN && move.getType() == Type.WATER) {
      damage *= 0.5;
    }
    if (field.getWeather() == Weather.RAIN && move.getType() == Type.WATER) {
      damage *= 1.5;
    }
    if (field.getWeather() == Weather.RAIN && move.getType() == Type.FIRE) {
      damage *= 0.5;
    }
    if (field.getWeather() == Weather.HAIL && move.getType() == Type.ICE) {
      damage *= 1.5;
    }
    if (this.getHeldItem() == Item.CHOICESPECS || this.getHeldItem() == Item.CHOICEBAND || this.getHeldItem() == Item.CHOICESCARF && !this.isChoiceLocked()) {
      this.choice_locked = move;
    }
    if (target.getAbility() == Ability.THICKFAT && (move.getType() == Type.FIRE || move.getType() == Type.ICE)) {
      damage *= 0.5;
    }
    if (move.getSpecialEffect().equals("KnockOff") && target.getHeldItem() != null && target.getHeldItem().canKnockOff()) {
      damage *= 1.5;
    }
    if (target.getTypeEffectiveness(move.getType()) > 1.0 && (target.hasAbility(Ability.FILTER) || target.hasAbility(Ability.SOLIDROCK))) {
      damage *= 0.75;
    }
    if (target.getTypeEffectiveness(move.getType()) > 1.0 && (this.held_item == Item.EXPERTBELT)) {
      damage *= 1.2;
    }
    if (this.hasAbility(Ability.RECKLESS) && move.getSpecialEffect().equals("RecoilOneThird")) {
      damage *= 1.3;
    }
    if (target.getAbility() == Ability.FLASHFIRE && move.getType() == Type.FIRE) {
      damage *= 0;
      System.out.println(target.getNickname() + "'s Flash Fire rendered the Fire move ineffective!");
      return;
    }
    if (target.getAbility() == Ability.LIGHTNINGROD && move.getType() == Type.ELECTRIC) {
      damage *= 0;
      System.out.println(target.getNickname() + "'s Lightning Rod activated!");
      target.raiseSpecialAttackByStage(1);
      return;
    }
    if (target.getAbility() == Ability.SOUNDPROOF && move.isSoundMove()) {
      damage *= 0;
      System.out.println(target.getNickname() + "'s Sound Proof made it immune to sound moves!");
      return;
    }
    if (target.getAbility() == Ability.BULLETPROOF && move.hasTag("BulletMove")) {
      damage *= 0;
      System.out.println(target.getNickname() + "'s Bulletproof made it immune to ballistic moves!");
      return;
    }
    if (target.getAbility() == Ability.WATERABSORB && move.getType() == Type.WATER) {
      damage *= 0;
      System.out.println(target.getNickname() + "'s Water Absorb made it immune to Water moves!");
      target.heal((int)(target.getMaxHP() / 4.0));
      return;
    }
    if (move != Move.CONFUSIONHIT) {
      Util.printDamageMessage(this, target, damage, move);
    }
    this.decrementPP(move);
    if (target.getAbility() == Ability.PRESSURE) {
      this.decrementPP(move);
    }
    target.takeDamage(damage);
    if (move.getSpecialEffect().equals("Drain")) {
      this.heal((int)(damage / 2.0));
    }
    // static has a chance of paralyzing those who use contact moves
    if (move.isContactMove() && target.getAbility() == Ability.STATIC) {
      Random rand = new Random();
      if (rand.nextDouble() <= 0.3) {
        this.paralyze();
      }
    }
    if (move.isContactMove() && target.getAbility() == Ability.FLAMEBODY) {
      Random rand = new Random();
      if (rand.nextDouble() <= 0.3) {
        this.burn();
      }
    }
    if (move.getSpecialEffect().equals("RecoilOneThird") && !this.hasAbility(Ability.ROCKHEAD)) {
      int recoil = (int)(damage / 3.0);
      if (current_health_target < damage) {
        this.takeDamage((int)(current_health_target / 3.0));
        System.out.println(this.getNickname() + " took " + (int)(current_health_target / 3.0) + " damage from recoil!");
      } else {
        this.takeDamage((int)(damage / 3.0));
        System.out.println(this.getNickname() + " took " + recoil + " damage from recoil!");
      }
    }
    if (move.getSpecialEffect().equals("RecoilOneHalf") && !this.hasAbility(Ability.ROCKHEAD)) {
      int recoil = (int)(damage / 2.0);
      if (current_health_target < damage) {
        this.takeDamage((int)(current_health_target / 2.0));
        System.out.println(this.getNickname() + " took " + (int)(current_health_target / 2.0) + " damage from recoil!");
      } else {
        this.takeDamage((int)(damage / 2.0));
        System.out.println(this.getNickname() + " took " + recoil + " damage from recoil!");
      }
    }
    move.applyEffectSelf(this);
    if (!target.isFainted() && !this.hasAbility(Ability.SHEERFORCE)) {
      move.applySpecialEffect(this, target, field);
    }
    if (target.isFainted()) {
      if (this.hasAbility(Ability.MOXIE)) {
        System.out.println("Moxie boosted " + this.getNickname() + "'s attack!");
        this.raiseAttackByStage(1);
      } 
      if (this.getOwner() instanceof Player) {
        if (this.getLevel() != 100) {
          System.out.println(this.getNickname() + " gained " + this.getExpGain(target) + " experience!");
          this.gainExperience(this.getExpGain(target));
          this.trainEVStat(target.getSpecies().getEVYield());
        } 
      }
    }
    if (this.getHeldItem() == Item.LIFEORB && damage > 0 && !this.hasAbility(Ability.SHEERFORCE)) {
      System.out.println(this.getNickname() + " was hurt by its Life Orb!");
      this.takeDamage((int)(this.getMaxHP() / 10.0));
    }
    if (target.isFainted() && target.isDestinyBond()) {
      System.out.println(target.getNickname() + " took down its attacker with it!");
      this.current_hp = 0;
      Util.printFaintedMessage(this);
    }
    if (this.hasAbility(Ability.AERILATE) && move.getType() == Type.FLYING) {
      move.setType(move.getOriginalType());
    }
    if (this.hasAbility(Ability.PIXILATE) && move.getType() == Type.FAIRY) {
      move.setType(move.getOriginalType());
    }
  }

  
/**
 *  Calculates damage of a move on a target. used for AI purposes
 *
 *  @param move Move and target to be checked
 *  @param target Pokemon target 
 *  @param field Battlefield
 *  @return The damage of the move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int calculateDamage(Move move, Pokemon target,Battle field) {
    if (move.getSpecialEffect().equals("Multi-Hit")) {
      return 3 * (int)(((((0.4)* this.level + 2)* move.getBasePower()*(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(move.getType()) *     this.getModifiers(move));
    }
    if (this.hasAbility(Ability.AERILATE) && move.getType() == Type.NORMAL) {
      return (int)(((((0.4)* this.level + 2)* move.getBasePower()*(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(Type.FLYING) * this.getModifiers(move));
    }
    if (this.hasAbility(Ability.PIXILATE) && move.getType() == Type.NORMAL) {
      return (int)(((((0.4)* this.level + 2)* move.getBasePower()*(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(Type.FAIRY) * this.getModifiers(move));
    }
    if (move.getMoveType() == MoveType.PHYSICAL) {
      return (int)(((((0.4)* this.level + 2)* move.getBasePower()*(double)this.getInBattleAttack() / (double)target.getInBattleDefense())/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move));
    }  
    return (int)(((((0.4)*this.level+2)* move.getBasePower() *((double)this.getInBattleSpecialAttack() / (double)target.getInBattleSpecialDefense(field)))/50 + 2) * target.getTypeEffectiveness(move.getType()) * this.getModifiers(move));
  }

  
/**
 *  Chance of a critical hit, determined by the critical hit stage. some moves heighten the critical hit chance
 *
 *  @param stage Critical hit stage
 *  @param move The move
 *  @return The chance of the critical hit
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double criticalHitChance(int stage, Move move) {
    if (move.getSpecialEffect().equals("IncreasedCritRate")) {
      stage += 1;
    }
    if (stage == 1) {
      return 0.125;
    } else if (stage == 2) {
      return 0.25;
    } else if (stage == 3) {
      return 0.332;
    } else if (stage == 4) {
      return 0.5;
    }
    return 0.0667;
  }

  
/**
 *  Returns if the pokemon is airborne (i.e. has the ability Levitate, is a flying-type, etc.)
 *
 *  @return True if the pokemon is airborne
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isAirborne() {
    return (this.hasAbility(Ability.LEVITATE)) || this.hasType(Type.FLYING);
  }

  
/**
 *  Gets status of this pokemon
 *
 *  @return The status of the pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String getStatus() {
    return this.status;
  }

  
/**
 *  Sets status of this pokemon
 *
 *  @param s Status
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setStatus(String s) {
    this.status = s;
  }

  
/**
 *  Returns if the Pokemon has a status
 *
 *  @return True if Pokemon has a status
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean hasStatus() {
    return !this.status.equals("");
  }

  
/**
 *  Burn this pokemon. if it is a fire-type, then it is immune to burns
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void burn() {
    if (this.hasType(Type.FIRE)) {
      return;
    } 
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    System.out.println(this.getNickname() + " was burned!");
    this.status = "Burn";
  }

  
/**
 *  Returns if the pokemon is confused
 *
 *  @return True if the pokemon is confused
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isConfused() {
    return this.confusion_turns > 0;
  }

  
/**
 *  Confuses the pokemon. randomly adds 2-5 confusion turns
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void confuse() {
    if (this.isConfused()) {
      System.out.println(this.getNickname() + " is already confused!");
      return;
    }
    System.out.println(this.getNickname() + " was confused!");
    Random rand = new Random();
    this.confusion_turns = rand.nextInt(2, 6);
  }

  
/**
 *  Sets confusion turns
 *
 *  @param i The number of confusion turns
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setConfuseTurns(int i) {
    this.confusion_turns = 0;
  }

  
/**
 *  Freezes the pokemon. ice-types are immune.
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void freeze() {
    if (this.hasType(Type.ICE)) {
      return; // cannot freeze an ice type
    } 
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    System.out.println(this.getNickname() + " was frozen solid!");
    this.status = "Freeze";
  }

  
/**
 *  Puts pokemon to sleep for 1-3 turns
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void sleep() {
    if (this.getStatus().equals("Sleep")) {
      System.out.println(this.getNickname() + " is already asleep!");
      return;
    }
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    System.out.println(this.getNickname() + " fell asleep!");
    Random rand = new Random();
    this.sleep_counter = rand.nextInt(1, 3);
    this.status = "Sleep";
  }

  
/**
 *  paralyzes the pokemon. electric-types are immune
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void paralyze() {
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    if (this.hasType(Type.ELECTRIC)) {
      return; // cannot paralyze electric type
    }
    System.out.println(this.getNickname() + " was paralyzed!");
    this.status = "Paralysis";
  }

  
/**
 *  poisons the pokemon with regular poison i.e. does consistent damage every turn
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void poison() {
    if (this.hasType(Type.POISON) || this.hasType(Type.STEEL)) {
      System.out.println("Poison had no effect.");
      return; // cannot poison a poison type or steel type
    }
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    System.out.println(this.getNickname() + " was poisoned!");
    this.status = "Poison";
  }

  
/**
 *  Badly poison a pokemon. the more turns that pass, the more the poison damages. poison types are immune
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void badlyPoison() {
    if (this.hasType(Type.POISON) || this.hasType(Type.STEEL)) {
      return; // cannot poison a poison type or steel type
    }
    if (this.hasStatus()) {
      System.out.println(this.getNickname() + " is already statused!");
      return;
    }
    System.out.println(this.getNickname() + " was badly poisoned!");
    this.status = "BadlyPoisoned";
    this.toxic_turns = 1;
  }


/**
 *  Heals a pokemon's status
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void healStatus() {
    this.status = "";
    this.confusion_turns = 0;
    this.sleep_counter = 0;
    this.cureToxic();
  }

  
/**
 *  Returns whether pokemon is burned
 *
 *  @return True if burned
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isBurned() {
    return this.getStatus().equals("Burn");
  }

  
/**
 *  Returns whether pokemon is frozen
 *
 *  @return True if frozen
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isFrozen() {
    return this.getStatus().equals("Freeze");
  }

  
/**
 *  Returns whether a pokemon is poisoned
 *
 *  @return True if poisoned
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isPoisoned() {
    return this.getStatus().equals("Poison");
  }

  
/**
 *  Returns whether a pokemon is badly poisoned
 *
 *  @return True if badly poisoned
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isBadlyPoisoned() {
    return this.getStatus().equals("BadlyPoisoned");
  }

  
/**
 *  Returns whether a pokemon is paralyzed or not
 *
 *  @return True if paralyzed
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isParalyzed() {
    return this.getStatus().equals("Paralysis");
  }

  
/**
 *  Returns whether a pokemon is asleep or not
 *
 *  @return True if asleep
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isAsleep() {
    return (this.status.equals("Sleep"));
  }

  
/**
 *  Pokemon takes poison damage (damage: 1/12 of its health). if it has the ability poison heal, it heals 1/8 of its health instead)
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takePoisonDamage() {
    if (this.hasAbility(Ability.POISONHEAL)) {
      this.heal((int)(this.getMaxHP() / 8.0));
      return;
    }
    Util.takePoisonDamage(this);
    this.current_hp -= this.max_hp * 0.12;
    if (this.isFainted()) {
      Util.printFaintedMessage(this);
    }
  }

  
/**
 *  Takes sandstorm damage if sandstorm is active. rock, ground, and steel type pokemon are immune
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeSandStormDamage() {
    if (this.hasType(Type.ROCK) || this.hasType(Type.GROUND) || this.hasType(Type.STEEL)) {
      return;
    }
    System.out.println(this.getNickname() + " was buffered by the sandstorm!");
    this.current_hp -= this.max_hp * (1.0 / 16.0);
    if (this.isFainted()) {
      Util.printFaintedMessage(this);
    }
  }

  
/**
 *  takes burn damage (6% of its health)
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeBurnDamage() {
    Util.takeBurnDamage(this);
    this.current_hp -= this.max_hp * 0.06;
    if (this.isFainted()) {
      Util.printFaintedMessage(this);
    }
  }

  
/**
 *  takes toxic damage. damage doubles with every turn
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeToxicDamage() {
    if (this.hasAbility(Ability.POISONHEAL)) {
      this.heal((int)(this.getMaxHP() / 8.0));
      return;
    }
    Util.takePoisonDamage(this);
    int damage = this.getToxicDamage();
    this.toxic_turns += 1;
    this.current_hp -= damage;
    if (this.isFainted()) {
      Util.printFaintedMessage(this);
    }
  }

  
/**
 *  gets how much damage bad poison should do this turn. depends on how many turns elapsed since poisoned.
 *
 *  @return The amount toxic damage
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getToxicDamage() {
    return (int)(this.getMaxHP() * (1.0 / 16.0) * this.toxic_turns);
  }

  
/**
 *  resets bad poison turns - happens when the pokemon switches out
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void resetToxic() {
    this.toxic_turns = 1;
  }

  
/**
 *  cures bad poison
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void cureToxic() {
    this.toxic_turns = 0;
  }

  
/**
 *  Puts pokemon to sleep for 1-3 turns
 *
 *  @return True if fainted
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isFainted() {
    return this.current_hp <= 0;
  }

  
/**
 *  raises attack by stage (max 6 stages, min -6 stages)
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void raiseAttackByStage(int i) {
    if (this.hasAbility(Ability.CONTRARY)) {
      i = -i;
    }
    if (this.hasAbility(Ability.CLEARBODY) && i < 0) {
      System.out.println(this.getNickname() + "'s Clear Body prevented its stats from being lowered!");
      return;
    }
    if (stat_boosts[1] == 6) {
      System.out.println(this.getNickname() + "'s Attack can't go any higher!");
      return;
    } else if (stat_boosts[1] == -6) {
      System.out.println(this.getNickname() + "'s Attack can't go any lower!");
      return;
    }
    if (i == 1) {
      System.out.println(this.getNickname() + "'s Attack rose!");
    } else if (i == 2) {
      System.out.println(this.getNickname() + "'s Attack sharply rose!");
    } else if (i > 2) {
      System.out.println(this.getNickname() + "'s Attack drastically rose!");
    } else if (i == -1) {
      System.out.println(this.getNickname() + "'s Attack fell!");
    } else if (i == -2) {
      System.out.println(this.getNickname() + "'s Attack fell sharply!");
    } else if (i < -2) {
      System.out.println(this.getNickname() + "'s Attack fell drastically!");
    }
    this.stat_boosts[1] += i;

    // cap at 6
    if (stat_boosts[1] > 6) {
      stat_boosts[1] = 6;
    } else if (stat_boosts[1] < -6) {
      stat_boosts[1] = -6;
    }
  }

  
/**
 *  gets a pokemon's stat boost by index. 0= hp, 1 =atk, 2 = def, etc.
 *
 *  @param i Index
 *  @return The boosted stat
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getStatBoostByIndex(int i) {
    return this.stat_boosts[i];
  }

  
/**
 *  gets pokemon's attack boost
 *
 *  @return The boosted attack
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getAttackBoost() {
    return this.getMultiplierByStage(this.stat_boosts[1]);
  }

  
/**
 *  raises defense by stage (max 6 stages, min -6 stages)
 * 
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void raiseDefenseByStage(int i) {
    if (this.hasAbility(Ability.CONTRARY)) {
      i = -i;
    }
    if (this.hasAbility(Ability.CLEARBODY) && i < 0) {
      System.out.println(this.getNickname() + "'s Clear Body prevented its stats from being lowered!");
      return;
    }
    if (stat_boosts[2] == 6) {
      System.out.println(this.getNickname() + "'s Defense can't go any higher!");
      return;
    } else if (stat_boosts[2] == -6) {
      System.out.println(this.getNickname() + "'s Defense can't go any lower!");
      return;
    }
    if (i == 1) {
      System.out.println(this.getNickname() + "'s Defense rose!");
    } else if (i == 2) {
      System.out.println(this.getNickname() + "'s Defense sharply rose!");
    } else if (i > 2) {
      System.out.println(this.getNickname() + "'s Defense drastically rose!");
    } else if (i == -1) {
      System.out.println(this.getNickname() + "'s Defense fell!");
    } else if (i == -2) {
      System.out.println(this.getNickname() + "'s Defense fell sharply!");
    } else if (i < -2) {
      System.out.println(this.getNickname() + "'s Defense fell drastically!");
    }
    this.stat_boosts[2] += i;
    // reset to 6 if higher, or -6
    if (stat_boosts[2] > 6) {
      stat_boosts[2] = 6;
    } else if (stat_boosts[2] < -6) {
      stat_boosts[2] = -6;
    }
  }

  
/**
 *  gets pokemon's defense boost based on its stat boost
 *
 *  @return Boosted defense
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getDefenseBoost() {
    return this.getMultiplierByStage(this.stat_boosts[2]);
  }

  
/**
 *  raises pokemon's special attack by a stage. max 6, min -6
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void raiseSpecialAttackByStage(int i) {
    if (this.hasAbility(Ability.CONTRARY)) {
      i = -i;
    }
    if (this.hasAbility(Ability.CLEARBODY) && i < 0) {
      System.out.println(this.getNickname() + "'s Clear Body prevented its stats from being lowered!");
      return;
    }
    if (stat_boosts[3] == 6) {
      System.out.println(this.getNickname() + "'s Special Attack can't go any higher!");
      return;
    } else if (stat_boosts[3] == -6) {
      System.out.println(this.getNickname() + "'s Special Attack can't go any lower!");
      return;
    }
    if (i == 1) {
      System.out.println(this.getNickname() + "'s Special Attack rose!");
    } else if (i == 2) {
      System.out.println(this.getNickname() + "'s Special Attack sharply rose!");
    } else if (i > 2) {
      System.out.println(this.getNickname() + "'s Special Attack drastically rose!");
    } else if (i == -1) {
      System.out.println(this.getNickname() + "'s Special Attack fell!");
    } else if (i == -2) {
      System.out.println(this.getNickname() + "'s Special Attack fell sharply!");
    } else if (i < -2) {
      System.out.println(this.getNickname() + "'s Special Attack fell drastically!");
    }
    this.stat_boosts[3] += i;
    
    // reset to 6 if higher, or -6
    if (stat_boosts[3] > 6) {
      stat_boosts[3] = 6;
    } else if (stat_boosts[3] < -6) {
      stat_boosts[3] = -6;
    }
  }

  
/**
 *  gets pokemon's special attack boost
 *
 *  @return Ppokemon's special attack boost
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getSpecialAttackBoost() {
    return this.getMultiplierByStage(this.stat_boosts[3]);
  }

  
/**
 *  Raises pokemon's special defense by stage. max 6, min -6
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void raiseSpecialDefenseByStage(int i) {
    if (this.hasAbility(Ability.CONTRARY)) {
      i = -i;
    }
    if (this.hasAbility(Ability.CLEARBODY) && i < 0) {
      System.out.println(this.getNickname() + "'s Clear Body prevented its stats from being lowered!");
      return;
    }
    if (stat_boosts[4] == 6) {
      System.out.println(this.getNickname() + "'s Special Defense can't go any higher!");
      return;
    } else if (stat_boosts[4] == -6) {
      System.out.println(this.getNickname() + "'s Special Defense can't go any lower!");
      return;
    }
    if (i == 1) {
      System.out.println(this.getNickname() + "'s Special Defense rose!");
    } else if (i == 2) {
      System.out.println(this.getNickname() + "'s Special Defense sharply rose!");
    } else if (i > 2) {
      System.out.println(this.getNickname() + "'s Special Defense drastically rose!");
    } else if (i == -1) {
      System.out.println(this.getNickname() + "'s Special Defense fell!");
    } else if (i == -2) {
      System.out.println(this.getNickname() + "'s Special Defense fell sharply!");
    } else if (i < -2) {
      System.out.println(this.getNickname() + "'s Special Defense fell drastically!");
    }
    this.stat_boosts[4] += i;
    
    // reset to 6 if higher, or -6
    if (stat_boosts[4] > 6) {
      stat_boosts[4] = 6;
    } else if (stat_boosts[4] < -6) {
      stat_boosts[4] = -6;
    }
  }

  
/**
 *  gets pokemon's special defense boost
 *
 *  @return The special defense boost
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getSpecialDefenseBoost() {
    return this.getMultiplierByStage(this.stat_boosts[4]);
  }

  
/**
 *  raises pokemon's speed by stage
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void raiseSpeedByStage(int i) {
    if (this.hasAbility(Ability.CONTRARY)) {
      i = -i;
    }
    if (this.hasAbility(Ability.CLEARBODY) && i < 0) {
      System.out.println(this.getNickname() + "'s Clear Body prevented its stats from being lowered!");
      return;
    }
    if (stat_boosts[5] == 6) {
      System.out.println(this.getNickname() + "'s Speed can't go any higher!");
      return;
    } else if (stat_boosts[5] == -6) {
      System.out.println(this.getNickname() + "'s Speed can't go any lower!");
      return;
    }
    if (i == 1) {
      System.out.println(this.getNickname() + "'s Speed rose!");
    } else if (i == 2) {
      System.out.println(this.getNickname() + "'s Speed sharply rose!");
    } else if (i > 2) {
      System.out.println(this.getNickname() + "'s Speed drastically rose!");
    } else if (i == -1) {
      System.out.println(this.getNickname() + "'s Speed fell!");
    } else if (i == -2) {
      System.out.println(this.getNickname() + "'s Speed fell sharply!");
    } else if (i < -2) {
      System.out.println(this.getNickname() + "'s Speed fell drastically!");
    }
    this.stat_boosts[5] += i;
    
    // reset to 6 if higher, or -6
    if (stat_boosts[5] > 6) {
      stat_boosts[5] = 6;
    } else if (stat_boosts[5] < -6) {
      stat_boosts[5] = -6;
    }
  }

  
/**
 *  gets pokemon's speed boost
 *
 *  @return Speed boost
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getSpeedBoost() {
    return this.getMultiplierByStage(this.stat_boosts[5]);
  }

  
/**
 *  resets pokemons stat boosts or debuffs. happens when switched out, or when battle ends. 
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void resetStatBoosts() {
    this.stat_boosts = new int[] {0,0,0,0,0,0};
  }

  
/**
 *  resets all stat boosts in battle
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void resetStatBoostsInBattle() {
    this.stat_boosts = new int[] {0,0,0,0,0,0};
  }

  
/**
 *  pokemon's summary
 *
 *  @return The summary of the pokemon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String toString() {
    String mov = "";
    for (int i = 0; i < 4; i++) {
      if (moves[i] != null) {
        mov += "\n\n" + this.moves[i].toString(this);
      }
    }
    String type = this.getTypeOne().getName();
    if (this.getTypeTwo() != null) {
      type += "/" + this.getTypeTwo().getName();
    }

    String item = "";
    if (this.getHeldItem() != null) {
      item += this.getHeldItem().getName();
    } else {
      item += "None";
    }
    return this.nickname + "'s Summary: " + "\nType: " + type + "\tItem: " + item + "\nLevel: " + this.level + "\nExperience: " + this.exp + "\nHP: " + this.current_hp + "/" + this.calculateHP() + "\nAbility: " + this.getAbility().getName() + " - " + this.getAbility().getDescription() + "\nThis Pokémon has a " + this.nature + " nature." + "\nStats: " + Arrays.toString(this.getStats()) + "\nIVs: " + Arrays.toString(this.iv) + "\nStat boosts: " + Arrays.toString(this.stat_boosts) + "\nMoves: " + mov;
  }

  
/**
 *  checks if move is executed successfully. checks number of factors such as sleep turns, move accuracy, etc.
 *
 *  @param move Move
 *  @param opponent The Pokemon's opponent
 *  @param field Battlefield
 *  @return True if move is executed successfully
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean executeMoveSuccessfully(Move move, Pokemon opponent, Battle field) {
    Random rand = new Random();
    if (this.isAsleep()) {
      if (this.sleep_counter == 0) {
        this.status = "";
        System.out.println(this.getNickname() + " woke up!");
        return true;
      }
      Util.isAsleep(this);
      this.sleep_counter -= 1;
      return false;
    } 
    if (this.isFrozen()) {
      if (rand.nextDouble() < 0.2) {
        System.out.println(this.getNickname() + " thawed out!");
        this.status = "";
        return true;
      }
      Util.getFrozen(this);
      return false;
    } 
    if (this.isParalyzed() && rand.nextInt(4) == 1) {
      Util.getParalyzed(this);
      return false;
    } 
    if (this.flinch) {
      System.out.println(this.getNickname() + " flinched!");
      this.flinch = false;
      return false;
    }
    if (this.confusion_turns > 0) {
      System.out.println(this.getNickname() + " is confused!");
      if (rand.nextInt(100) < 50) {
      } else {
        System.out.println(this.getNickname() + " hurt itself in its confusion!");
        this.attack(Move.CONFUSIONHIT, this, field);
        return false;
      }
    }
    
    // move misses
    if (this.getAbility() == Ability.NOGUARD || opponent.getAbility() == Ability.NOGUARD) {
      return true;
    }
    if (move.getAccuracy() > 0) {
      double lol = move.getAccuracy();
      if (move == Move.HURRICANE && field.getWeather() == Weather.SUN) {
        lol = 0.5;
      }
      if (this.hasAbility(Ability.COMPOUNDEYES)) {
        lol *= 1.3;
      }
      if (move == Move.THUNDER && field.getWeather() == Weather.RAIN) {
        lol = 10.0;
      } 
      if (rand.nextDouble() > lol) {
        Util.printMissedMove(this, move);
        this.decrementPP(move);
        if (move.getSpecialEffect().equals("HurtSelfIfMiss")) {
          System.out.println(this.getNickname() + " kept going and crashed!");
          this.takeDamage((int)(this.getMaxHP() / 2.0));
        }
        return false;
      }
    }
    return true;
  }

  
/**
 *  heals the pokemon with message
 *
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void heal(int i) {
    if (this.current_hp == this.max_hp) {
      System.out.println(this.getNickname() + " is already at full health!");
      return;
    }
    System.out.println(this.getNickname() + " regained " + i + " HP!");
    this.current_hp += i;
    if (this.current_hp > this.max_hp) {
      this.current_hp = this.max_hp;
    }
  }

  
/**
 *  heals pokemon without message
 * 
 *  @param i Index
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void healSilent(int i) {
    this.current_hp += i;
    if (this.current_hp > this.max_hp) {
      this.current_hp = this.max_hp;
    }
  }

  
/**
 *  fully heals a pokemon, including its status
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void fullyHeal() {
    this.healSilent(this.getMaxHP());
    this.healStatus();
    this.sleep_counter = 0;
    this.confusion_turns = 0;
    this.toxic_turns = 0;
  }

  
/**
 *  gets pokemon's owner
 *
 *  @return Pokemon's owner
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Trainer getOwner() {
    return this.owner;
  }

  
/**
 *  returns whether this pokemon can mega evolve - must have a mega stone, owner must have a mega ring, and the species must have a mega evolution defined
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean canMegaEvolve() {
    if (this.owner == null) {
      return false;
    }
    if (this.isMegaEvolved()) {
      return false;
    }
    if (this.species.getForms() == null) {
      return false;
    } 
    if (!this.owner.hasItem(Item.MEGARING)) {
      return false;
    } 
    for (Forms f : this.species.getForms()) {
      if (this.held_item == f.getMegaStone()) {
        return true;
      }
    } 
    return false;
  }

  
/**
 *  gets pokemon's mega form, if there is any
 *
 *  @return Pokemon's mega form or null if it doesn't have one
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Forms getMegaForm() {
    if (this.species.getForms() != null) {
      Forms[] forms = this.species.getForms();
    } 
    for (Forms f : this.species.getForms()) {
      if (this.held_item == f.getMegaStone()) {
        return f;
      }
    }
    return null;
  }

  
/**
 *  mega evolves the pokemon given conditions are correct
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void megaEvolve() {
    if (this.getMegaForm() == null) {
      System.out.println("Cannot Mega Evolve.");
      return;
    }
    String oldname = this.getNickname();
    Forms mega = this.getMegaForm();
    System.out.println(this.getNickname() + " is reacting to its " + mega.getMegaStone().getName() + "!");
    this.changeForm(mega);
    System.out.println(oldname + " has Mega Evolved into " + mega.getName() + "!");
  }

  
/**
 *  changes the pokemon's form
 * 
 *  @param f Pokemon form
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void changeForm(Forms f) {
    if (this.nickname == this.species.getName()) {
      this.nickname = f.getName();
    }
    this.base_stats = f.getStats();
    this.stats = getStats();
    this.typeone = f.getTypeOne();
    this.typetwo = f.getTypeTwo();
    this.ability = f.getRandomAbility();
    this.form = f;
  }

  
/**
 *  reverts pokemon to base form
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void revertToBaseForm() {
    if (this.form == null) {
      return;
    }
    if (this.nickname == this.form.getName()) {
      this.nickname = this.species.getName();
    }
    this.base_stats = this.species.getBaseStats();
    this.stats = getStats();
    this.typeone = this.species.getTypeOne();
    this.typetwo = this.species.getTypeTwo();
    this.ability = this.species.getRandomAbility();
    this.form = null;
  }

  
/**
 *  pokemon sets weather - applicable for those with weather setting abilities, such as drizzle, drought, etc.
 *
 *  @param field Battlefield
 *  @param w Weather
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setWeather(Battle field, Weather w) {
    field.setWeather(w);
    if (this.getHeldItem() == Item.HEATROCK && w == Weather.SUN) {
      field.setWeatherTurns(8);
    } else if (this.getHeldItem() == Item.DAMPROCK && w == Weather.RAIN) {
      field.setWeatherTurns(8);
    } else if (this.getHeldItem() == Item.SMOOTHROCK && w == Weather.SANDSTORM) {
      field.setWeatherTurns(8);
    } else if (this.getHeldItem() == Item.ICYROCK && w == Weather.HAIL) {
      field.setWeatherTurns(8);
    }
    else {
      field.setWeatherTurns(5);
    }
    System.out.println(w.getStartMessage());
  }

  
/**
 *  pokemon sets terrain - i.e. electric terrain, grassy terrain, etc.
 *
 *  @param field Battlefield
 *  @param w Weather
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setTerrain(Battle field, Weather w) {
    field.setTerrain(w);
    if (this.getHeldItem() == Item.TERRAINEXTENDER) {
      field.setTerrainTurns(8);
    } 
    else {
      field.setTerrainTurns(5);
    }
    System.out.println(w.getStartMessage());
  }

/**
 *  events as pokemon enters a battle. for example, if the entering pokemon has the ability intimidate, it will lower the opponent's attack stat 
 * 
 *  @param field Battlefield
 *  @param opponent Pokemon opponent
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void onEnterBattle(Battle field, Pokemon opponent) {
    if (this.hasAbility(Ability.PRESSURE)) {
      System.out.println(this.getNickname() + " is exerting its pressure!");
    } 
    if (this.hasAbility(Ability.INTIMIDATE)) {
      System.out.println(this.getNickname() + "'s Intimidate lowered the opposing Pokémon's Attack stat!");
      opponent.raiseAttackByStage(-1);
    } 
    if (this.hasAbility(Ability.DROUGHT)) {
      this.setWeather(field, Weather.SUN);
    } 
    if ((this.hasAbility(Ability.ORICHALCUMPULSE))) {
      System.out.println("Koraidon turned the sunlight harsh, sending its ancient pulse into a frenzy!");
      this.setWeather(field, Weather.SUN);
    } 
    if (this.hasAbility(Ability.DRIZZLE)) {
      this.setWeather(field, Weather.RAIN);
    } 
    if (this.hasAbility(Ability.SANDSTREAM)) {
      this.setWeather(field, Weather.SANDSTORM);
    } 
    if (this.hasAbility(Ability.HADRONENGINE)) {
      System.out.println("Miraidon turned the ground into Electric Terrain, energizing its futuristic engine!");
      this.setTerrain(field, Weather.ELECTRICTERRAIN);
    } 
    if (this.hasAbility(Ability.ELECTRICSURGE)) {
      this.setTerrain(field, Weather.ELECTRICTERRAIN);
    } 
    if (this.hasAbility(Ability.GRASSYSURGE)) {
      this.setTerrain(field, Weather.GRASSYTERRAIN);
    } 
    if (this.hasAbility(Ability.PSYCHICSURGE)) {
      this.setTerrain(field, Weather.PSYCHICTERRAIN);
    } 
    if (this.hasAbility(Ability.MISTYSURGE)) {
      this.setTerrain(field, Weather.MISTYTERRAIN);
    }
    if (this.getHeldItem() != Item.HEAVYDUTYBOOTS) {
      if (field.getOwnHazards(this.getOwner()).contains("StealthRock")) {
        this.takeStealthRockDamage();
      } 
      if (field.getOwnHazards(this.getOwner()).contains("StickyWeb")) {
        this.getCaughtInStickyWeb();
      } 
      if (field.getOwnHazards(this.getOwner()).contains("Spikes")) {
        this.takeSpikesDamage(field);
      } 
      if (field.getOwnHazards(this.getOwner()).contains("ToxicSpikes")) {
        this.getPoisonedByToxicSpikes(field);
      } 
    }
  }

  
/**
 *  gets exp gain based on pokemon defeated
 *
 *  @param defeated Defeated Pokemon
 *  @return The exp gain
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public int getExpGain(Pokemon defeated) {
    int exp = (int)((defeated.getSpecies().getBaseExp() * defeated.getLevel() / 5) * Math.pow(((2 * defeated.getLevel() + 10) / (defeated.getLevel() + this.getLevel() + 10)), 2.5) + 1);
    if (defeated.getOwner() != null) {
      exp *= 1.5;
    }
    return exp;
  }

  
/**
 *  gets this pokemon's catch chance. lower hp, better pokeballs, and status conditions will increase the chance of being captured
 *
 *  @param i Item
 *  @return Catch chance
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public double getCatchChance(Item i) {
    int bonus = 1;
    if (i == Item.ULTRABALL) {
      bonus *= 2;
    } 
    if (i == Item.GREATBALL) {
      bonus *= 1.5;
    }
    int bonus2 = 1;
    if (this.getStatus().equals("Sleep") || this.getStatus().equals("Freeze")) {
      bonus2 *= 2.0;
    } 
    if (this.getStatus().equals("Paralyze") || this.getStatus().equals("Burn") || this.getStatus().equals("Poison")) {
      bonus2 *= 1.5;
    }
    double rate = (((this.getMaxHP() * 3 - 2 * this.getCurrentHP()) * 4096 * this.species.getCatchRate() * bonus) / (3 * this.getMaxHP())) * bonus;
    return rate;
  }

  
/**
 *  attempts to catch the pokemon. 4 checks must pass 
 *
 *  @param item Item
 *  @return True if pokemon has been caught
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean catchPoke(Item item) {
    double shake_check = 65536 / Math.sqrt(Math.sqrt(1044480/this.getCatchChance(item)));
    Random rand = new Random();
    for (int i = 0; i < 4; i ++) {
      if (rand.nextInt(65536) >= shake_check && item != Item.MASTERBALL) {
        if (i == 0) {
          System.out.println("The Pokémon broke free!");
          try { Thread.sleep(400);	} catch (InterruptedException e) {};
        } else if (i == 1) {
          System.out.println(this.getSpecies().getName() + " broke free!");
          System.out.println("Aww! It appeared to be caught!");
          try { Thread.sleep(400);	} catch (InterruptedException e) {};
        } else if (i == 2) {
          System.out.println(this.getSpecies().getName() + " broke free!");
          System.out.println("Aargh! Almost had it!");
          try { Thread.sleep(400);	} catch (InterruptedException e) {};
        } else if (i == 3) {
          System.out.println(this.getSpecies().getName() + " broke free!");
          System.out.println("Shoot! It was so close, too!");
          try { Thread.sleep(400);	} catch (InterruptedException e) {};
        }
        return false;
      }
      System.out.println("Shaking...");
      try { Thread.sleep(400);	} catch (InterruptedException e) {};
    } 
    return true;
  }

  
/**
 *  gets a random move. used in a wild battle where the wild pokemon chooses a random move
 *
 *  @return The random move
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public Move getRandomMove() {
    if (this.hasRunOutOfPP()) {
      return Move.STRUGGLE;
    } 
    if (this.hasChargingMove()) {
      Move m = this.getChargingMove();
      this.setChargingMove(null);
      return m;
    }
    Random rand = new Random();
    int i = rand.nextInt(4);
    while (moves[i] == null) {
      i = rand.nextInt(4);
    }
    return moves[i];
  }

  
/**
 *  sets pokemon's owner
 * 
 *  @param t Trainer
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setOwner(Trainer t) {
    this.owner = t;
  }

  
/**
 *  this pokemon takes stealth rock damage - if it is 2x weak to rock, it takes 1/4 of its health, if it is x4 weak to rock, it takes 1/2 of its health. pokemon neutral to rock take 1/8 of its health. pokemon that resist rock take less damage.
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeStealthRockDamage() {
    if (this.getTypeEffectiveness(Type.ROCK) == 4.0) {
      this.takeDamage((int)(this.getMaxHP() / 2.0));
    } else if (this.getTypeEffectiveness(Type.ROCK) == 2.0) {
      this.takeDamage((int)(this.getMaxHP() / 4.0));
    } else if (this.getTypeEffectiveness(Type.ROCK) == 0.5) {
      this.takeDamage((int)(this.getMaxHP() / 16.0));
    } else if (this.getTypeEffectiveness(Type.ROCK) == 0.25) {
      this.takeDamage((int)(this.getMaxHP() / 32.0));
    } else {
      this.takeDamage((int)(this.getMaxHP() / 8.0));
    }
    System.out.println(this.getNickname() + " was hurt by Stealth Rock!");
  }

  
/**
 *  pokemon gets caught in sticky web - lowers its speed stat unless it is airborne
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void getCaughtInStickyWeb() {
    if (!this.isAirborne()) {
      System.out.println(this.getNickname() + " was caught in a sticky web!");
      this.raiseSpeedByStage(-1);
    }
  }

  
/**
 *  if pokemon is not airborne, takes spikes damage
 *
 *  @param field Battlefield
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void takeSpikesDamage(Battle field) {
    if (!this.isAirborne()) {
      System.out.println(this.getNickname() + " was hurt by spikes!");
      if (Collections.frequency(field.getOwnHazards(this.getOwner()), "Spikes") == 1) {
        this.takeDamage((int)(this.getMaxHP() / 16.0));
      } 
      if (Collections.frequency(field.getOwnHazards(this.getOwner()), "Spikes") == 2) {
        this.takeDamage((int)(this.getMaxHP() / 8.0));
      } 
      if (Collections.frequency(field.getOwnHazards(this.getOwner()), "Spikes") == 3) {
        this.takeDamage((int)(this.getMaxHP() / 4.0));
      }
    }
  }

  
/**
 *  this pokemon gets poisoned by toxic spikes - if it is a poison type, it absorbs the toxic spikes instead
 *
 *  @param field Battlefield
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void getPoisonedByToxicSpikes(Battle field) {
    if (!this.isAirborne() && !this.hasType(Type.POISON)) {
      System.out.println(this.getNickname() + " was poisoned by toxic spikes!");
      if (Collections.frequency(field.getOwnHazards(this.getOwner()), "ToxicSpikes") == 1) {
        this.poison();
      } 
      if (Collections.frequency(field.getOwnHazards(this.getOwner()), "Spikes") == 2) {
        this.badlyPoison();
      }
    } 
    if (!this.isAirborne() && this.hasType(Type.POISON)) {
      System.out.println(this.getNickname() + " absorbed the toxic spikes!");
      field.getOwnHazards(this.getOwner()).remove("ToxicSpikes");
      field.getOwnHazards(this.getOwner()).remove("ToxicSpikes");
    }
  }

  
/**
 *  checks if pokemon can evolve
 *
 *  @return True if can evolve
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean canEvolve() {
    if (!this.species.hasEvolution()) {
      return false;
    }
    Object[] evo_method = this.species.getEvolutionMethod();
    if (((String)evo_method[0]).equals("Level")) {
      if (this.getLevel() >= (int)evo_method[1]) {
        return true;
      }
    }
    return false;
  }

  
/**
 *  evolves the pokemon
 *
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void evolve() {
    if ((this.getSpecies().getEvolution() == null)) {
      return;
    }
    System.out.println("What? " + this.getNickname() + " is evolving!");
    System.out.println("1...");
    System.out.println("2...");
    System.out.println("3...");
    String oldname = this.getNickname();
    if (this.getNickname().equals(this.species.getName())) {
      this.setNickname(this.species.getEvolution().getName());
    }
    this.species = this.species.getEvolution();
    this.base_stats = this.species.getBaseStats();
    this.stats = this.getStats();
    this.ability = this.species.getRandomAbility();
    System.out.println("Congratulations! Your " +  oldname + " has evolved into " + this.species.getName() + "!");
  }

  
/**
 *  gets pokemon's back sprite directory
 *
 *  @return Pokemon's back sprite
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String getBattleBack() {
    String str = "";
    if (this.getSpecies().getDexNumber() < 10) {
      str = "00";
    }
    else if (this.getSpecies().getDexNumber() < 100) {
      str = "0";
    }
    String fin = "Graphics/battler/" + str + this.getSpecies().getDexNumber();
    if (this.is_shiny) {
      fin += "s";
    }
    fin += "b";
    if (this.form != null) {
      fin += "_" + this.form.getFormNumber();
    }
    return fin + ".png";
  }

  
/**
 *  gets pokemon's front sprite directory
 *
 *  @return Pokemon's front sprite
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String getBattleFront() {
    String str = "";
    if (this.getSpecies().getDexNumber() < 10) {
      str = "00";
    }
    else if (this.getSpecies().getDexNumber() < 100) {
      str = "0";
    }
    String fin = "Graphics/battler/" + str + this.getSpecies().getDexNumber();
    if (this.is_shiny) {
      fin += "s";
    }
    if (this.form != null) {
      fin += "_" + this.form.getFormNumber();
    }
    return fin + ".png";
  }

  
/**
 *  gets pokemon's icon sprite directory
 *
 *  @return Graphic icon
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public String getIcon() {
    return "Graphics/icons/" + this.getSpecies().getDexNumber() + ".png";
  }

  
/**
 *  Sets pokemon to shiny
 *
 *  @param True if shiny, false if not
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setShiny(boolean b) {
    this.is_shiny = b;
  }

  
/**
 *  Returns whether a pokemon is shiny
 *
 *  @return whether Pokemon is shiny
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public boolean isShiny() {
    return this.is_shiny;
  }

  
/**
 *  Sets pokemon's flinch status
 *
 *  @param b True if flinching, false if not
 *  @author  Angela Jiang, Sian Bareket, Kira Kaplan
 *  @version CSC 212, Fall 2022
 */
  public void setFlinch(boolean b) {
    this.flinch = b;
  }

  
}