import java.util.*;

/**
 *  Trainer class - stores party information, manipulating party, etc.
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
public class Trainer {
  
  private Pokemon[] party;
  private Pokemon active;
  private String name;
  private ArrayList<Item> items;
  private int base_money;

  
/**
 *  Sets up the Trainer
 *
 *  @param name The name of the trainer
 *  @param money The money the trainer gives when defeated
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Trainer(String name, int money) {
    this.party = new Pokemon[6];
    this.name = name;
    this.items = new ArrayList<Item>();
    this.base_money = money;
  }

  
/**
 *  Second constructor allowing specification of party
 *
 *  @param party Party of pokemon
 *  @param name The name of the trainer
 *  @param money The amount of money they give when defeated
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Trainer(Pokemon[] party, String name, int money) {
    this.party = party;
    this.name = name;
    this.base_money = money;
  }

  
/**
 *  Gets Trainer's inventory
 *
 *  @return The inventory
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<Item> getInventory() {
    return this.items;
  }

  
/**
 *  Returns Trainer's party
 *
 *  @return The party
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon[] getParty() {
    return this.party;
  }

  
/**
 *  Checks if Trainer's party is empty
 *
 *  @return Returns true if empty
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean partyIsEmpty() {
    for (int i = 0; i < 6; i++) {
      if (this.party[i] != null) {
        return false;
      }
    } 
    return true;
  }

  
/**
 *  Counts number of party members of Trainer
 *
 *  @return Returns number of party members
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int numberPartyMembers() {
    int j = 0;
    for (int i = 0; i < 6; i++) {
      if (this.party[i] != null) {
        j+= 1;
      }
    } return j;
  }

  
/**
 *  Gets base money of Trainer - money paid when defeated
 *
 *  @return Returns money paid when defeated
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int getBaseMoney() {
    return this.base_money;
  }

  
/**
 *  Sets base money of Trainer
 *
 *  @param i The base amount of money
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setBaseMoney(int i) {
    this.base_money = i;
  }

  
/**
 *  Gets party pokemon based on integer index
 *
 *  @param i Inputted integer
 *  @return Party pokemon based on integer index
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon getPartyPokemon(int i) {
    if (i < 0 || i > 5) {
      System.out.println("Pokémon doesn't exist");
      return null;
    }
    return this.party[i];
  }

  
/**
 *  Sets party of Trainer given Pokemon array
 *
 *  @param party The pokemon party array
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setParty(Pokemon[] party) {
    this.party = party;
  }

  
/**
 *  Adds a party member - in this case, if there are more than 6 Pokemon in the party, the Pokemon inputted is not added
 *
 *  @param p Pokemon to be added
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addPartyMember(Pokemon p) {
    for (int i = 0; i < 6; i++) {
      if (this.party[i] == null) {
        this.party[i] = p;
        return;
      }
    } 
  }

  
/**
 *  Is the party full? i.e. has 6 members
 *
 *  @return Returns true if the party is full
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean isPartyFull() {
    for (int i = 0; i < 6; i++) {
      if (this.party[i] == null) {
        return false;
      }
    } 
    return true;
  }

  
/**
 *  get index of a Pokemon
 *
 *  @param p Index of specific pokemon
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int getPokemonIndex(Pokemon p) {
    for (int i = 0; i < 6; i++) {
      if (this.party[i] == p) {
        return i;
      }
    } 
    return -1;
  }

  
/**
 *  Rebalances Trainer's team based on Player's max pokemon level
 *
 *  @param p The current player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void rebalanceTeam(Player p) {
    for (Pokemon poke : this.getParty()) {
      if (poke != null) {
        if (poke.getLevel() > p.getHighestLevelInParty()) {
          poke.setLevel(p.getHighestLevelInParty());
          poke.setCurrentHP(poke.calculateHP());
        }
      }
    }
  }

  
/**
 * Adds one item to Trainer's inventory
 *
 *  @param i The item to add to the inventory
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addToInventory(Item i) {
    this.items.add(i);
  }

  
/**
 * Adds multiple (specified quantity) items to Trainer's inventory
 *
 *  @param item The item to add
 *  @param quantity The amount of items to add
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addToInventory(Item item, int quantity) {
    for (int i = 0; i < quantity; i ++) {
      this.items.add(item);
    }
  }

  
/**
 * Removes item from Trainer's inventory
 *
 *  @param i Item to remove from inventory
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void removeFromInventory(Item i) {
    this.items.remove(i);
  }

  
/**
 * Prints out number of items in Trainer's inventory
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public String duplicatesInventory() {
    String str = "My Bag:";
    HashMap<Item, Integer> duplicates = new HashMap<Item, Integer>();
    ArrayList<Item> inventory = new ArrayList<Item>(getInventory());
    for (int i = 0; i < inventory.size(); i++) {
      int counter = 1;
      for (int j = 1; j < inventory.size(); j++) {
        if (inventory.get(i) == inventory.get(j) && i != j) { 
          counter++;
        }
      }
      duplicates.put(inventory.get(i), counter);
    }
    for (HashMap.Entry<Item, Integer> e : duplicates.entrySet()) {
      str = str + "\n" + e.getKey().getName() + " (" + e.getValue() + ")";
    }
    return str;
  }
  

/**
 * Checks if Trainer has item
 *
 *  @param i The item to check for
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean hasItem(Item i) {
    return this.items.contains(i);
  }

  
/**
 * Gets Trainer's current active pokemon
 *
 *  @return The trainer's active pokemon
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon getActivePokemon() {
    return this.active;
  }

  
/**
 * sets a Pokemon as active, with message
 *
 *  @param p Pokemon to set as active
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setActivePokemon(Pokemon p) {
    System.out.println(this.getName() + " sent out " + p.getNickname() + "!");
    this.active = p;
    try { Thread.sleep(400);	} catch (InterruptedException e) {};
  }

  
/**
 * Sets a Pokemon as active (indicated by input integer)
 *
 *  @param i Inputted integer
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setActivePokemon(int i) {
    if (party[i] == null) {
      return;
    }
    this.active.resetToxic();
    this.active.resetStatBoosts();
    this.active = party[i];
  }

  
/**
 * Returns if the Trainer have any non fainted Pokemon
 *
 *  @return Returns true if Trainer has non-fainted pokemon
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean hasStandingPokemon() {
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        if (!party[i].isFainted()) {
          return true;
        }
      }
    }
    return false;
  }

  
/**
 * Switches the Trainer's active Pokemon, by switching out, any confusion, stat boosts, etc.are reset
 *
 *  @param p Current pokemon
 *  @param opp Pokemon opposition
 *  @param field The specified battle field
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void switchPokemon(Pokemon p, Pokemon opp, Battle field) {
    if (!this.active.isFainted()) {
      System.out.println(p.getOwner().getName() + " withdrew " + this.active.getNickname() + ".");
      try { Thread.sleep(400);	} catch (InterruptedException e) {};
    }
    System.out.println(p.getOwner().getName() + " sent out " + p.getNickname() + "!");
    try { Thread.sleep(400);	} catch (InterruptedException e) {};
    this.active.resetStatBoosts(); // switching out resets all stat boosts
    this.active.resetToxic();
    this.active.setConfuseTurns(0);
    this.active.setResting(0);
    this.active.setChoiceLockedMove(null);
    if (this.active.getAbility() == Ability.REGENERATOR && !this.active.isFainted()) {
      this.active.heal((int)(this.active.getMaxHP() / 3.0));
    }
    if (this.active.getAbility() == Ability.NATURALCURE && !this.active.isFainted()) {
      this.active.setStatus("");
    }
    this.active = p;
    p.onEnterBattle(field, opp);
  }

  
/**
 * Can the trainer switch?
 *
 *  @param i Inputted number
 *  @return True if they can, false if they can't
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean canSwitch(int i) {
    if (i < 0 || i > 5) {
      System.out.println("Not a valid party member.");
      return false;
    }
    if (this.getPartyPokemon(i) == this.getActivePokemon()) {
      System.out.println(this.getActivePokemon().getNickname() + " is already in battle!");
      return false;
    }
    if (this.getPartyPokemon(i) == null) {
      System.out.println("This Pokémon doesn't exist.");
      return false;
    } 
    else if (this.getPartyPokemon(i).isFainted()) {
      System.out.println(this.getPartyPokemon(i).getNickname() + " is unable to battle!");
      return false;
    } 
    return true;
  }

  
/**
 * AI of the trainer - decides if it should switch
 *
 *  @param opponent Pokemon opponent
 *  @param field The battle field
 *  @return Positive or negtive depending on inputted moves
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int shouldSwitch(Pokemon opponent, Battle field) {
    if (opponent.getAbility() == Ability.SHADOWTAG || (opponent.getAbility() == Ability.ARENATRAP && !this.getActivePokemon().isAirborne()) || (opponent.getAbility() == Ability.MAGNETPULL && this.getActivePokemon().hasType(Type.STEEL))) {
      return -1;
    }
    Move best_move = this.getBestMove(this.getActivePokemon(), opponent, field);
    if (this.getActivePokemon().getToxicDamage() >= this.getActivePokemon().getCurrentHP() && this.whoToSwitchIn(opponent, field) != this.getActivePokemon()) {
      return 1;
    } 
    if (this.getActivePokemon().calculateDamage(best_move, opponent, field) < 0.25 * opponent.getCurrentHP()) {
      if (best_move.getMoveType() != MoveType.STATUS) {
        if (this.whoToSwitchIn(opponent, field) != this.getActivePokemon()) {
          return 1;
        }
      }
    }
    return -1;
  }

  
/**
 * Returns name of Trainer
 *
 *  @return Returns name
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return this.name;
  }

  
/**
 * AI of the Trainer. First, it decides whether to switch which is determined by several factors, if not, it decides what attack to use based on a calculated score for each move
 *
 *  @param opponent The pokemon opponent
 *  @param best_move The determined best move
 *  @param field The battlfield
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void determineAction(Pokemon opponent, Move best_move, Battle field) {
    if (shouldSwitch(opponent, field) != -1) {
      this.switchPokemon(whoToSwitchIn(opponent, field), opponent, field);
    } 
    else {
      if (best_move.getSpecialEffect().equals("Multi-Hit")) {
        field.multiHitAttack(this.getActivePokemon(), opponent, best_move);
      } 
      else {
        this.getActivePokemon().attack(best_move, opponent, field);
      }
    }
  }

  
/**
 * If the opponent switches, determines Trainer's action - AI
 *
 *  @param opponent The pokemon opponent
 *  @param in The inputted pokemon
 *  @param field The battle field
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void determineActionSwitched(Pokemon opponent, Pokemon in, Battle field) {
    if (shouldSwitch(opponent, field) != -1) {
      this.switchPokemon(whoToSwitchIn(opponent, field), opponent, field);
    } 
    else {
      Move best_move = getBestMove(this.getActivePokemon(), opponent, field);
      this.getActivePokemon().attack(best_move, in, field);
    }
  }

  
/**
 * Determines the best move to use of a Pokemon (calculates damage done against opponent). best move to use is determined by damage * the accuracy of the move. also, if two moves will both defeat the opponent, the one with higher accuracy will be used
 *
 *  @param friendly Pokemon friendly to the trainer
 *  @param opponent The pokemon opponent
 *  @param field The battle field
 *  @return The best potential move
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Move getBestMove(Pokemon friendly, Pokemon opponent, Battle field) {
    Pokemon p = friendly;
    // if Pokemon has run out of pp, can only use struggle
    if (p.hasRunOutOfPP()) {
      return Move.STRUGGLE;
    }
 // if Pokemon is choice locked, can only use the move
    if (p.isChoiceLocked()) {
      return p.getChoiceLockedMove();
    }
    Move best_move = p.getMove(0);
    for (int i = 0; i < 4; i++) {
      if (p.hasMove(i)) {
        Move temp = p.getMove(i);
        if (p.getMovePP(i) <= 0) {
          continue;
        }
        if (p.getCurrentHP() > (p.getMaxHP() * 0.6) && temp.getSpecialEffect().contains("Raise")) {
          if (p.calculateDamage(best_move, opponent, field) < (opponent.getCurrentHP() / 2)) {
            best_move = temp;
            continue;
          }
        }
        if (p.getCurrentHP() < (p.getMaxHP() * 0.6) && temp.getSpecialEffect().equals("Heal")) {
          if (p.calculateDamage(best_move, opponent, field) < opponent.getCurrentHP()) {
            best_move = temp;
            continue;
          }
        } 
        if (best_move.getSpecialEffect().equals("Heal")) {
          if (p.calculateDamage(temp, opponent, field) < opponent.getCurrentHP() * 0.5) {
            continue;
          }
        } 
        if (best_move.getSpecialEffect().contains("Raise")) {
          if (p.calculateDamage(temp, opponent, field) < opponent.getCurrentHP() * 0.5) {
            continue;
          }
        }
        int temp_score = p.calculateDamage(temp, opponent, field);
        int best_move_score = p.calculateDamage(best_move, opponent, field);
        if (temp_score > opponent.getCurrentHP()) {
          temp_score = (int)(opponent.getCurrentHP() * temp.getAccuracy());
        }
        if (best_move_score > opponent.getCurrentHP()) {
          best_move_score = (int)(opponent.getCurrentHP() * best_move.getAccuracy());
        }
        if (temp_score > best_move_score) {
          best_move = p.getMove(i);
        }
      }
    }
    return best_move;
  }

  
/**
 * Gets next non-fainted pokemon
 *
 *  @return Non-fainted pokemon in party
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon nextPokemonAlive() {
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        if (!party[i].isFainted()) {
          return party[i];
        }
      }
    }
    return null;
  }


/**
 * Determines the Pokemon to switch in from moves that switch the opponent out
 *
 *  @param thispoke The current pokemon
 *  @param opponent The pokemon opponent
 *  @param field The battle field
 *  @return The best pokemon to switch to
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon whoToSwitchInFromUTurn(Pokemon thispoke, Pokemon opponent, Battle field) {
    Pokemon bestPokemon = nextPokemonAlive();
    int best_score = calculatePokemonScore(bestPokemon, opponent, field);
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        if (!party[i].isFainted() && party[i] != thispoke) {
          int temp = calculatePokemonScore(party[i], opponent, field);
          if (temp > best_score) {
            best_score = temp;
            bestPokemon = party[i];
          }
        }
      }
    }
    return bestPokemon;
  }


/**
 * Determines best Pokemon to switch in based on calculated score (type effectiveness against the opposing pokemon, and the opposing pokemon's effective against it)
 *
 *  @param opponent The pokemon opponent
 *  @param field The battle field
 *  @param bestPokemon The best pokemon to switch in based on calculated score
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Pokemon whoToSwitchIn(Pokemon opponent, Battle field) {
    Pokemon bestPokemon = nextPokemonAlive();
    int best_score = calculatePokemonScore(bestPokemon, opponent, field);
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        if (!party[i].isFainted()) {
          int temp = calculatePokemonScore(party[i], opponent, field);
          if (temp > best_score) {
            best_score = temp;
            bestPokemon = party[i];
          }
        }
      }
    }
    return bestPokemon;
  }


/**
 * calculates a pokemon's score i.e. is it a good switch in?
 *
 *  @param friendly Pokemon that is part of the party
 *  @param opponent The pokemon opponent
 *  @param field The battle field
 *  @return The score of the pokemon's effectiveness
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int calculatePokemonScore(Pokemon friendly, Pokemon opponent, Battle field) {
    int score = 0;
    double effectiveness = friendly.getSpecies().getTypeEffectiveness(opponent.getTypeOne());
    double effectivenesstwo = friendly.getSpecies().getTypeEffectiveness(opponent.getTypeTwo());
    double opp_effectiveness = opponent.getSpecies().getTypeEffectiveness(friendly.getTypeOne());
    double opp_effectivenesstwo = opponent.getSpecies().getTypeEffectiveness(friendly.getTypeTwo());
    
    if (effectiveness > 1.0) {
      score -= effectiveness;
    } else {
      score += 1.0 / effectiveness;
    } 
    if (opp_effectiveness > 1.0) {
      score += opp_effectiveness;
    } else {
      score -= 1.0 / effectiveness;
    }
    Move m = getBestMove(friendly, opponent, field);
    // best damaging move good
    score += friendly.calculateDamage(m, opponent, field);
    // faster pokemon better
    score += friendly.calculateSpeed() - opponent.calculateSpeed();
    return score;
  }


/**
 * heals the party fully, including restoring PP, hp, heals all status, etc.
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void healParty() {
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        party[i].fullyHeal();
        party[i].restoreAllPP();
      } 
    }
  }


/**
 * Prints the trainer and their party
 *
 *  @return The trainer and their party printed to string
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public String toString() {
    String s = "";
    for (int i = 0; i < 6;i++) {
      if (party[i] != null) {
        s += party[i].toString();
      }
    }
    return this.getName() + "'s Party:" + "\n" + s;
  }


/**
 *  resetting all pokemon after a battle
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void resetAllPokemon() {
    for (int i = 0; i < party.length; i ++) {
      if (party[i] != null) {
        Pokemon par = party[i];
        par.setChoiceLockedMove(null);
        par.resetStatBoosts();
        // revert any megas back to original form
        par.revertToBaseForm();
        par.setFlinch(false);
        par.setConfuseTurns(0);
      }
    }
  }

  
/**
 *  print pokeballs that the trainer has
 *
 *  @return Pokeball string
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String printPokeballs() {
    String s = "Poke Balls: "+ Collections.frequency(items, Item.POKEBALL) +  "\nGreat Balls: " + Collections.frequency(items, Item.GREATBALL) +  "\nUltra Balls: " + Collections.frequency(items, Item.ULTRABALL);
    return s;
  }

  
}