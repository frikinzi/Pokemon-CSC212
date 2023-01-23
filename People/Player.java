import java.util.*;
import com.google.common.graph.*;
import java.util.Scanner;
import java.lang.*;
import javax.swing.*;
import java.awt.*;

/**
 *  Class defining the Player
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
public class Player extends Trainer {

  /** Name of Player */
  private String name;
  
  /** Money of Player */
  private int money;

  /** Current Location of Player */
  private Location location;

  /** Pokémon storage of Player */
  private ArrayList<Pokemon> storage;

  /** Unimplemented as of now - but last visited Pokémon Center */
  private Location last_visited_pkm_center;

  /** World that Player is in */
  private ImmutableValueGraph<Location, Integer> world;

  /** Graphics of Player world */
  private ShowPicture background; 

  /** tags - i.e. has the player encountered x legendary pokemon, has the first Gym leader been beaten, etc.? */
  private ArrayList<String> tags;

  /** The frame of the map graphic */
  private JFrame map;

  /** The map graphic */
  private Map map_canvas;

  
/**
 *  Constructor with Player's party, name, amount of money and location
 *
 *  @param party The player's pokemon party
 *  @param name The player's name
 *  @param money The player's money
 *  @param l The player's location
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Player(Pokemon[] party, String name, int money, Location l) {
    super(party, name, money);
    this.money = money;
    this.storage = new ArrayList<Pokemon>();
    this.location = l;
    this.tags = new ArrayList<String>();
  }

  
/**
 *  Constructor with only name, money and location
 *
 *  @param name The player's name
 *  @param money The player's money
 *  @param l The player's location
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Player(String name, int money, Location l) {
    super(name, money);
    this.name = name;
    this.money = money;
    this.storage = new ArrayList<Pokemon>();
    this.location = l;
    this.tags = new ArrayList<String>();
  }

  
/**
 *  Returns Player's Pokémon storage
 *
 *  @return Pokemon storage
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<Pokemon> getStorage() {
    return this.storage;
  }

  
/**
 *  Sets Player's world
 *
 *  @param world The graph that has the player's world
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setWorld(ImmutableValueGraph<Location, Integer> world){
    this.world = world;
  }

  
/**
 *  Sets Player's map
 *
 *  @param map The JFrame for the map of the player's world
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setMap(JFrame map){
    this.map = map;
  }

  
/**
 *  Sets Player's map canvas
 *
 *  @param map_canvas The editable graphic of the map
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setMapCanvas(Map map_canvas){
    this.map_canvas = map_canvas;
  }

  
/**
 *  Sets name of Player
 *
 *  @param name Name of player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setName(String name){
    this.name = name;
  }

  
/**
 *  Gets name of Player
 *
 *  @return Name of player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public String getName(){
    return this.name;
  }

  
/**
 *  Get the highest level of the Pokémon in Player's party. Used for balancing trainers
 *
 *  @return highest level of pokemon in party
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int getHighestLevelInParty() {
    int i = 0;
    for (Pokemon p : this.getParty()) {
      if (p!= null) {
        if (p.getLevel() > i) {
          i = p.getLevel();
        }
      }
    } 
    return i;
  }

  
/**
 *  Set background of the Player
 *
 *  @param pic The graphic to set the background
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setBackground(ShowPicture pic){
    this.background = pic;
  }

  
/**
 *  Gets background of the Player
 *
 *  @return The current background
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public ShowPicture getBackground() { //
    return this.background;
  }

  
/**
 *  Gives Player money
 *
 *  @param i The amount of money given to player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addMoney(int i) {
    this.money += i;
  }

  
/**
 *  Sets the amount of money a player has
 *
 *  @param i The amount of money a player has
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setMoney(int i) {
    this.money = i;
  }

  
/**
 *  Subtracts Player's money. if money falls below zero, sets back to zero.
 *
 *  @param i The amount of money removed from player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void subtractMoney(int i) {
    this.money -= i;
    if (this.money < 0) {
      this.money = 0;
    }
  }

  
/**
 *  Gets player's current balance
 *
 *  @return The current balance
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public int getMoney() {
    return this.money;
  }

  
/**
 *  Adds party member for Player, extending the addPartyMember method in the Trainer class. If the Player's party is full, the Pokémon gets sent to their storage.
 *
 *  @param p The added pokemon
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addPartyMember(Pokemon p) {
    if (this.isPartyFull()) {
      this.storage.add(p);
      p.fullyHeal();
      p.restoreAllPP();
      return;
    }
    super.addPartyMember(p);
  }

  
/**
 *  Sets Player's location
 *
 *  @param l The new location of player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setLocation(Location l) {
    this.location = l;
  }

  
/**
 *  Returns Player's location
 *
 *  @return Location of player
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public Location getLocation() {
    return this.location;
  }

  
/**
 *  Player's menu - can check bag, rearrange/swap Pokémon, evolve Pokémon, etc.
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void menu() {
    Scanner scanner = new Scanner(System.in);
    boolean exit = false;
    while (!exit) {
      this.getBackground().undisplay();
      map.setVisible(true);
      System.out.println("1 - Pokemon || 2 - Bag || 3 - Check Storage || Any other key - exit");
      String input = scanner.nextLine();
      int i = Util.parseInt(input);
      if (i == 1) {
        ShowPicture showing = this.getBackground();
        showing.undisplay();
        showing.displayParty(this.getParty(), this.getBackground().getFrame());
        Util.printAllPokemon(this);
        input = scanner.nextLine();
        int index = Util.parseInt(input);
        Pokemon p = this.getPartyPokemon(index - 1);
        this.getBackground().undisplay();
        if (p != null) {
          ShowPicture show = this.getBackground();
          show.displayPokemon(p, this.getBackground().getFrame());
          System.out.println("What to do with " + p.getNickname() + "?");
          System.out.println("1: View Summary");
          System.out.println("2: Use Item");
          System.out.println("3: Teach Move");
          System.out.println("4: Swap");
          System.out.println("5: View Species Info");
          if (p.canEvolve()) {
            System.out.println("6: Evolve");
          }
          input = scanner.nextLine();
          int dec = Util.parseInt(input);
          System.out.println(dec);
          if (dec == 1) {
            Pokemon pokepoke = p;
            getBackground().undisplay();
            System.out.println("Press e to exit");
            getBackground().displaySummary(pokepoke, getBackground().getFrame());
            String sum = scanner.nextLine();
            while (!sum.equals("e")) {
              sum = scanner.nextLine();
            }
            getBackground().undisplay();
            
          } else if (dec == 2) {
            Util.useItemOnPoke(scanner, this, p);
          } else if (dec == 3) {
            p.getSpecies().getLearnSet();
            for (Integer name: p.getSpecies().getLearnSet().keySet()) {
              Integer key = name;
              String value = p.getSpecies().getLearnSet().get(name).getName();
              if (key <= p.getLevel()) {
                System.out.println(key + ": " + value);
              }
            }
            input = scanner.nextLine();
            int mo = Util.parseInt(input);
            if (p.getSpecies().getLearnSet().get(mo) != null && mo <= p.getLevel()) {
              Util.teachMove(scanner, p.getSpecies().getLearnSet().get(mo), p);
            }
          } else if (dec == 4) {
            if (this.numberPartyMembers() <= 1) {
              System.out.println("You don't have anyone to swap with...");
            } else {
              System.out.println("Who to swap with?");
              Util.printAllPokemon(this);
              input = scanner.nextLine();
              index = Util.parseInt(input);
                if (index - 1 < 0 || index - 1 > 5) {
                  continue;
                }
              Pokemon swap = this.getPartyPokemon(index - 1);
              if (swap != p) {
                int p_pos = this.getPokemonIndex(p);
                this.getParty()[this.getPokemonIndex(swap)] = p;
                this.getParty()[p_pos] = swap;
              }
            }
          } else if (dec == 5) {
            System.out.println("Press e to exit");
            getBackground().displaySpecies(p, getBackground().getFrame());
            String sum = scanner.nextLine();
            while (!sum.equals("e")) {
              sum = scanner.nextLine();
            }
            getBackground().undisplay();
          } else if (dec == 6 && p.canEvolve()) {
            p.evolve();
            this.getBackground().undisplay();
            show.displayPokemon(p, this.getBackground().getFrame());
            try { Thread.sleep(10000);	} catch (InterruptedException e) {};
          }
          this.getBackground().undisplay();
        } else {
          System.out.println("Not a valid party member");
          this.getBackground().undisplay();
        }
        this.getBackground().undisplay();
      } if (i == 2) {
        Util.bag(scanner, this);
      } if (i == 3) {
        if (this.getStorage().size() == 0) {
          System.out.println("You have no Pokémon in storage!");
        } else {
          Util.printStoragePokemon(this);
          input = scanner.nextLine();
          int index = Util.parseInt(input);
          if (index <= this.getStorage().size() && index >= 0) {
            Pokemon p = this.getStorage().get(index - 1);
            if (p != null) {
              ShowPicture show = this.getBackground();
              show.displayPokemon(p, this.getBackground().getFrame());
              System.out.println("What to do with " + p.getNickname() + "?");
              System.out.println("1: View Summary");
              System.out.println("2: Give/Use Item");
              System.out.println("3: Swap");
              System.out.println("4: View Species Info");
              if (p.canEvolve()) {
                System.out.println("5: Evolve");
              }
              input = scanner.nextLine();
              int dec = Util.parseInt(input);
              if (dec == 1) {
            getBackground().undisplay();
            System.out.println("Press e to exit");
            getBackground().displaySummary(p, getBackground().getFrame());
            String sum = scanner.nextLine();
            while (!sum.equals("e")) {
              sum = scanner.nextLine();
            }
            getBackground().undisplay();
                System.out.println(p);
              } 
              if (dec == 2) {
                Util.useItemOnPoke(scanner, this, p);
              } 
              if (dec == 3) {
                System.out.println("Swap with who?");
                Util.printAllPokemon(this);
                input = scanner.nextLine();
                int ind = Util.parseInt(input);
                if (ind - 1 < 0 || ind - 1 > 5) {
                  continue;
                }
                Pokemon tobeswapped = this.getPartyPokemon(ind - 1);
                if (tobeswapped != null) {
                  this.getStorage().remove(p);
                  this.getStorage().add(tobeswapped);
                  this.getParty()[ind - 1] = p;
                }
              } 
              if (dec == 4) {
                System.out.println(p.getSpecies());
              }
              if (dec == 5 && p.canEvolve()) {
                p.evolve();
                this.getBackground().undisplay();
                show.displayPokemon(p, this.getBackground().getFrame());
                try { Thread.sleep(500);	} catch (InterruptedException e) {};
              }
              this.getBackground().undisplay();
            } else {
              System.out.println("Not a Pokémon");
            }
          }
        }
      }
      else {
        exit = true;
      }
    }
  }


/**
 *  changes the Player's location based on user input
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void travel(){
    this.getBackground().undisplay();
    ShowPicture pic = new ShowPicture(new JFrame());
    map.setVisible(true);
    
    Scanner scanner = new Scanner(System.in);
    Set<Location> nodes_set = world.adjacentNodes(location);
    Location[] nodes_array = new Location[nodes_set.size()];
    nodes_set.toArray(nodes_array);
    System.out.println("\nWhere do you want to go?");

    String guide = "0 = Cancel Travel, ";
    for (int i = 0; i < nodes_array.length; i++) {
      int j = i + 1;
      if (j==nodes_array.length) {
        guide += j + " = " +nodes_array[i].getName(); 
      }
      else {
        guide += j + " = " +nodes_array[i].getName() + ", "; 
      }
    }
    System.out.println(guide);

    String input = scanner.nextLine();
    int int_input = Integer.parseInt(input);
    if (int_input == 0) {
      return;
    }
    else {
      try {
        System.out.println("Location: " + nodes_array[int_input - 1].getName());
        map_canvas.animateMap(location, nodes_array[int_input - 1]);
        setLocation(nodes_array[int_input - 1]);
        Interactable.parseLoc(this, location);
      } catch(Exception e) {
        throw new RuntimeException("we need to do something here");
      }
    }
  }

  
/**
 *  What happens when all of your pokemon haev fainted
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void blackout() {
    System.out.println(this.getName() + " blacked out!");
    System.out.println(this.getName() + " scurried to a Pokémon Center, protecting the exhausted and fainted Pokémon from further harm...");
    System.out.println("Nurse Joy: First, we will restore your Pokémon to full health.");
    try { Thread.sleep(100);	} catch (InterruptedException e) {};
    System.out.println("1...");
    try { Thread.sleep(100);	} catch (InterruptedException e) {};
    System.out.println("2...");
    try { Thread.sleep(100);	} catch (InterruptedException e) {};
    System.out.println("3...");
    try { Thread.sleep(100);	} catch (InterruptedException e) {};
    this.healParty();
    System.out.println("All done! Your Pokémon are happy and healthy. Be more careful next time.");
    System.out.println("We hope to see you again!");
  }

  
/**
 *  Adds a tag to the Player
 *
 *  @param s The new tag
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void addTag(String s) {
    this.tags.add(s);
  }

  
/**
 *  Removes Player tag
 *
 *  @param s The tag to be removed
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void removeTag(String s) {
    if (!this.tags.contains(s)) {
      return;
    }
    this.tags.remove(s);
  }

  
/**
 *  Does the Player have a tag?
 *
 *  @param s Checks if player has that tag
 *  @return True if it has the tag
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public boolean hasTag(String s) {
    return this.tags.contains(s);
  }

  
/**
 *  Returns Player tags
 *
 *  @return The player's tags
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<String> getTags() {
    return this.tags;
  }

  
}