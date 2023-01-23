import java.util.Random;
import java.util.Scanner;

/**
 *  Util class defining many useful functions used throughout the project
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Util {

  
/**
 *  Util function getting a random nature
 *
 *  @param nature A nature class
 *  @return Random nature
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static Nature randomNature(Class<Nature> nature){
    Random random = new Random();
    int x = random.nextInt(nature.getEnumConstants().length);
    return nature.getEnumConstants()[x];
  }

  
/**
 *  prints damage message, based on the attacker, defender, and damage dealt 
 *
 *  @param attacker Pokemon attacker
 *  @param defender Pokemon defender
 *  @param damage Amount of damange
 *  @param move Move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printDamageMessage(Pokemon attacker, Pokemon defender, int damage, Move move) {
    if (damage == 0) {
      System.out.println(attacker.getNickname() + " dealt no damage to " + defender.getNickname() + "!");
      return;
    }
    System.out.println(move.getName() + " dealt " + damage + " damage to " + defender.getNickname() + "!");
    double effectiveness = defender.getTypeEffectiveness(move.getType());
    if (effectiveness > 1.0) {
      System.out.println("It's super-effective!");
    } else if (effectiveness < 1.0) {
      System.out.println("It's not very effective...");
    }
  }

  
/**
 *  prints message if a pokemon faints
 *
 *  @param fainter Pokemon that fainted
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printFaintedMessage(Pokemon fainter) {
    System.out.println(fainter.getNickname() + " fainted!");
  }

  
/**
 *  prints options that the player can switch to
 *
 *  @param trainer Trainer
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printSwitchOptions(Trainer trainer) {
    for (int i = 0; i < 6; i++) {
      if (trainer.getPartyPokemon(i) != null) {
        if (!trainer.getPartyPokemon(i).isFainted()) {
          System.out.println(i + ": " + trainer.getPartyPokemon(i).getNickname());
        }
      }
    }
  }

  
/**
 *  prints all pokemon of the trainer in their party
 *
 *  @param t Trainer
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printAllPokemon(Trainer t) {
    for (int i = 0; i < 6; i++) {
      if (t.getPartyPokemon(i) != null) {
          System.out.println((i+ 1) + ": " + t.getPartyPokemon(i).getNickname());
      }
    }
  }

  
/**
 *  prints all pokemon and lists their compatibility with an input move
 *
 *  @param t Trainer
 *  @param m Move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printAllPokemonTM(Trainer t, Move m) {
    for (int i = 0; i < 6; i++) {
      if (t.getPartyPokemon(i) != null) {
        boolean b = Util.checkMoveCompatibility(m, t.getPartyPokemon(i).getSpecies());
        if (t.getPartyPokemon(i).hasMove(m)) {
          System.out.println((i+ 1) + ": " + t.getPartyPokemon(i).getNickname() + " - LEARNT");
        }
        if (b && !t.getPartyPokemon(i).hasMove(m)) {
          System.out.println((i+ 1) + ": " + t.getPartyPokemon(i).getNickname() + " - COMPATIBLE");
        } else {
          System.out.println((i+ 1) + ": " + t.getPartyPokemon(i).getNickname() + " - NOT COMPATIBLE");
        }  
      }
    }
  }

  
/**
 *  prints pokemon and their compatibility based on evolution stone
 *
 *  @param item Item 
 *  @param t Trainer
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printPokemonEvolution(Item item, Trainer t) {
    for (int i = 0; i < 6; i++) {
      if (t.getPartyPokemon(i) != null) {
        if (t.getPartyPokemon(i).getSpecies().getEvolution() != null) {
          Object[] evo_method = t.getPartyPokemon(i).getSpecies().getEvolutionMethod();
          if (((String)evo_method[0]).equals("Item")) {
            if (item == (Item)evo_method[1]) {
              System.out.println(i + 1 + ": " + t.getPartyPokemon(i).getNickname() + " - COMPATIBLE");
            } else {
              System.out.println(i + 1 + ": " + t.getPartyPokemon(i).getNickname() + " - NOT COMPATIBLE");
            }
          } else {
            System.out.println(i + 1 + ": " + t.getPartyPokemon(i).getNickname() + " - NOT COMPATIBLE");
          }
        }
      }
    }
  }

  
/**
 *  checks if a pokemon is compatible with an evolution item
 *
 *  @param item Item
 *  @param p Pokemon
 *  @return True if pokemone is compatible with evolution item
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean checkEvolutionStoneCompatibility(Item item, Pokemon p) {
    Object[] evo_method = p.getSpecies().getEvolutionMethod();
    if (((String)evo_method[0]).equals("Item")) {
      return true;
    }
    else {
      return false;
    }
  }

  
/**
 *  prints all of the player's storage pokemon
 *
 *  @param t The player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printStoragePokemon(Player t) {
    for (int i = 0; i < t.getStorage().size(); i++) {
      if (t.getStorage().get(i) != null) {
        System.out.println((i+ 1) + ": " + t.getStorage().get(i).getNickname());
      }
    }
  }

  
/**
 *  prints message when pokemon is switched out
 *
 *  @param out Pokemon switched out
 *  @param in Pokemon switched in
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printSwitchingOut(Pokemon out, Pokemon in) {
    Random rand = new Random();
    if (!out.isFainted()) {
      if (rand.nextInt(2) == 0) {
        System.out.println("Come back, " + out.getNickname() + "!");
      } else {
        System.out.println("You did great, " + out.getNickname() + "!");
      }
    }
    if (rand.nextInt(2) == 0) {
      System.out.println("Go get 'em, " + in.getNickname() + "!");
    } else {
      System.out.println("I choose you, " + in.getNickname() + "!");
    }
  }

  
/**
 *  prints move that missed
 *
 *  @param attacker Pokemon attacker
 *  @param move Move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void printMissedMove(Pokemon attacker, Move move) {
    System.out.println(attacker.getNickname() + "'s " + move.getName() + " missed!");
  }

  
/**
 *  prints message when pokemon is asleep
 *
 *  @param attacker The pokemon attacker
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void isAsleep(Pokemon attacker) {
    System.out.println(attacker.getNickname() + " is fast asleep.");
  }

  
/**
 *  prints message when pokemon is paralyzed
 *
 *  @param attacker The pokemon attacker
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void getParalyzed(Pokemon attacker) {
    System.out.println(attacker.getNickname() + " is paralyzed! It can't move!");
  }

  
/**
 *  prints message when pokemon is frozen
 *
 *  @param attacker The pokemon attacker
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void getFrozen(Pokemon attacker) {
    System.out.println(attacker.getNickname() + " is frozen solid!");
  }

  
/**
 *  prints message when pokemon takes poison damage
 *
 *  @param attacker The pokemon attacker
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void takePoisonDamage(Pokemon attacker) {
    if (attacker.hasAbility(Ability.POISONHEAL)) {
      return;
    }
    System.out.println(attacker.getNickname() + " is hurt by poison!");
  }

  
/**
 *  prints message when pokemon takes burn damage
 *
 *  @param p Pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void takeBurnDamage(Pokemon p) {
    System.out.println(p.getNickname() + " is hurt by its burn!");
  }

  
/**
 *  parses input and returns true if yes, false if no
 *
 *  @param s String to parse
 *  @return True if yes and false if no
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean parseInput(String s) {
    boolean valid_input = false;
    while (valid_input == false) {
      if (s.equals("N") || s.equals("No") || s.equals("no") || s.equals("n") || s.equals("nope") ||s.equals("Nope")) {
        valid_input = true;
        return false;
      } else if ((s.equals("Y") || s.equals("Yes") || s.equals("yes") || s.equals("y") || s.equals("ya") ||s.equals("Ya"))) {
        valid_input = true;
        return true;
      } else {
        System.out.println("Sorry I didn't understand that. Try typing your response again.");
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
      }
    }
    return false;
  }

  
/**
 *  parses string input into integer. -1 if not valid
 *
 *  @param s String to parse
 *  @return Integer version of string
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static int parseInt(String s) {
    try {
      Integer i = Integer.parseInt(s);
      return i;
    } catch (Exception e) {
      return -1;
    }
  }

  
/**
 *  clears screen
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void clearScreen() {  
   System.out.print("\033[H\033[2J");  
   System.out.flush();  
}

  
/**
 *  interprets item based on string input. null if not valid
 *
 *  @param input String to interpret
 *  @return Element based on string input
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static Item interpretItem(String input) {
    try {
      Item item = Item.valueOf(input.replaceAll("\\s", "").toUpperCase());
      System.out.println(item); //
      return item;
    } catch (Exception e) {
      return null;
    }
  }

  
/**
 *  checks move compatibility with a species
 *
 *  @param m Move
 *  @param p Species of Pokemon
 *  @return True if move is compatible with species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean checkMoveCompatibility(Move m, Species p) {
    return p.getMovePool().contains(m);
  }

  
/**
 *  teaches move to a pokemon. if pokemon has 4 moves, the player will be prompted to replace one or cancel
 *
 *  @param scanner Scanner
 *  @param m Move
 *  @param p Pokemon
 *  @return True if pokemon doesn't have move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean teachMove(Scanner scanner, Move m, Pokemon p) {
    if (p.hasMove(m)) {
      System.out.println(p.getNickname() + " already knows " + m.getName() + ".");
      return false;
    }
    if (p.hasFourMoves()) {
      System.out.println(p.getNickname() + " is trying to learn " + m.getName() + ".");
      System.out.println("But " + p.getNickname() + " already knows four moves. Choose a move to forget.");
      for (int i = 0; i < 4; i++) {
        System.out.println(i + ": "+ p.getMove(i).getName());
      }
      String input = scanner.nextLine();
      int index = Util.parseInt(input);
      if (index >= 4 || index < 0) {
        System.out.println(p.getNickname() + " did not learn " + m.getName() + ".");
        return false;
      } else {
        System.out.println("1, 2, 3... Tada! " + p.getNickname() + " forgot how to use " + p.getMove(index).getName() + ".");
        System.out.println(p.getNickname() + " learned " + m.getName() + "!");
        p.setMove(index, m);
        return true;
      }
    } else {
      p.setMove(p.nextOpenMoveSlot(), m);
      System.out.println(p.getNickname() + " learned " + m.getName() + "!");
      return true;
    }
  }

  
/**
 *  prompts user to use/give item on/to pokemon
 *
 *  @param scanner Scanner
 *  @param p Player
 *  @param poke The pokemon to use item on
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void useItemOnPoke(Scanner scanner, Player p, Pokemon poke) {
    p.duplicatesInventory();
    System.out.println("What would you like to use/give? e to exit");
    String input = scanner.nextLine();
    Item i = Util.interpretItem(input);
    if (i != null && p.getInventory().contains(i)) {
      if (i.getCategory() == 1) {
        if (poke != null) {
          boolean used = i.use(poke);
          if (used) {
            p.removeFromInventory(i);
          }
        }
      } 
      if (i.getCategory() == 2) {
        // placeholder
        System.out.println("Can't use that here.");
      }
      if (i.getCategory() == 3) {
        // placeholder
        if (poke != null) {
          poke.giveHeldItem(i);
        }
      }
      if (i.getCategory() == 4) {
        // placeholder
        if (poke != null) {
          poke.giveHeldItem(i);
        }
      }
      if (i.getCategory() == 5) {
        if (poke.getSpecies().getEvolution() != null) {
          if (poke.getSpecies().getEvolutionMethod()[0].equals("Item")) {
            if (i == (Item)(poke.getSpecies().getEvolutionMethod()[1])) {
              poke.evolve();
              p.removeFromInventory(i);
            }
          }
        }
      }
      if (i.getCategory() == 6) {
        // placeholder
      }
      if (i.getCategory() == 7) {
        System.out.println("Booted up a TM containing " + i.getMoveTaught().getName() + ".");
        if (poke != null) {
          if (Util.checkMoveCompatibility(i.getMoveTaught(), poke.getSpecies())) {
            Util.teachMove(scanner, i.getMoveTaught(), poke);
          } else {
            System.out.println(poke.getNickname() + " cannot learn the move " + i.getMoveTaught().getName() + ".");
          }  
        }
      }
    } else {
      System.out.println("You don't have that item.");
    }
  }

  
/**
 *  bag that is shown in battle - i.e. can use potions, etc
 *
 *  @param scanner Scanner
 *  @param p Player
 *  @return True if bag is shown in battle
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean battleBag(Scanner scanner, Player p) {
    p.getBackground().displayText(p.duplicatesInventory(), p.getBackground().getFrame(), "Bag");
    System.out.println("What would you like to use? e to exit");
    boolean exit = false;
    while (!exit) {
      String input = scanner.nextLine();
      if (input.equals("e")) {
        p.getBackground().undisplay();
        return false;
      } else {
        Item i = Util.interpretItem(input);
        if (i != null && p.getInventory().contains(i)) {
          if (i.getCategory() == 1) {
            System.out.println("Use on what Pokémon?");
            Util.printAllPokemon(p);
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              boolean used = i.use(poke);
              if (used) {
                p.removeFromInventory(i);
                p.getBackground().undisplay();
                return true;
              } else {
                p.getBackground().undisplay();
                return false;
              }
            
            } 
            if (i.getCategory() == 3) {
              // placeholder
              System.out.println("Can't use that here.");
            }
            if (i.getCategory() == 4) {
              System.out.println("Can't use that here.");
            }
            if (i.getCategory() == 5) {
              // placeholder
              System.out.println("Can't use that here.");
              exit = true;
            }
            if (i.getCategory() == 6) {
              // placeholder
              System.out.println("Can't use that here.");
            }
            if (i.getCategory() == 7) {
              System.out.println("Can't use that here.");
              exit = true;
            }
          } else {
            System.out.println("You don't have that item.");
          }
        }
        p.getBackground().undisplay();
        return false;
      }
    }
    p.getBackground().undisplay();
    return false;
  }

  
/**
 *  Bag menu outside of battle - i.e. can give items, evolve pokemon, etc.
 *
 *  @param scanner Scanner
 *  @param p Player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void bag(Scanner scanner, Player p) {
    p.getBackground().displayText(p.duplicatesInventory(), p.getBackground().getFrame(), "Bag");
    System.out.println("What would you like to use/give? e to exit");
    boolean exit = false;
    while (!exit) {
      String input = scanner.nextLine();
      if (input.equals("e")) {
        exit = true;
      } else {
        Item i = Util.interpretItem(input);
        if (i != null && p.getInventory().contains(i)) {
          if (i.getCategory() == 1) {
            System.out.println("Use on what Pokémon?");
            Util.printAllPokemon(p);
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              boolean used = i.use(poke);
              if (used) {
                p.removeFromInventory(i);
              }
              exit = true;
            }
          } 
          if (i.getCategory() == 2) {
            // placeholder
            System.out.println("Throw your pokeball!");
            exit = true;
          }
          if (i.getCategory() == 3) {
            // placeholder
            System.out.println("Give to what Pokémon?");
            Util.printAllPokemon(p);
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              poke.giveHeldItem(i);
              i.onGive(poke);
            }
            exit = true;
          }
          if (i.getCategory() == 4) {
            System.out.println("Give to what Pokémon?");
            Util.printAllPokemon(p);
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              poke.giveHeldItem(i);
            }
            exit = true;
          }
          if (i.getCategory() == 5) {
            Util.printPokemonEvolution(i, p);
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              if (checkEvolutionStoneCompatibility(i, poke)) {
                poke.evolve();
              } else {
                System.out.println("Not compatible.");
              }
            }
            exit = true;
          }
          if (i.getCategory() == 6) {
            // placeholder
            System.out.println("Can't use that here.");
            exit = true;
          }
          if (i.getCategory() == 7) {
            System.out.println("Booted up a TM containing " + i.getMoveTaught().getName() + ". Teach it to who?");
            printAllPokemonTM(p, i.getMoveTaught());
            input = scanner.nextLine();
            int index = Util.parseInt(input);
            Pokemon poke = p.getPartyPokemon(index - 1);
            if (poke != null) {
              if (Util.checkMoveCompatibility(i.getMoveTaught(), poke.getSpecies())) {
                Util.teachMove(scanner, i.getMoveTaught(), poke);
              }
              exit = true;
            }
          }
        } else {
          System.out.println("You don't have that item.");
        }
      }
    }
    p.getBackground().undisplay();
  }

  
/**
 *  Shop - can buy items
 *
 *  @param scanner Scanner
 *  @param p Player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void shop(Scanner s, Player p) {
    boolean exit = false;
    ShowPicture show = p.getBackground();
    show.undisplay();
    show.showImage(p.getBackground().getFrame(), "Graphics/pictures/pokemart.png");
    while (!exit) {
      System.out.println("\nHello! Welcome to the PokéMart. What would you like to buy? To see a list of our items ask 'list?' (e to exit)");
      System.out.println("Your Money: $" + p.getMoney());
      String input = s.nextLine();
      if (input.equals("e") || input.equals("exit")) {
        System.out.println("Please come again.");
        p.getBackground().undisplay();
        return;
      }
      if (input.equals("list?")) {
        System.out.println("Press e to exit");
        p.getBackground().displayText(Item.listItems(), p.getBackground().getFrame(), "Shop Items");
        String sum = s.nextLine();
        while (!sum.equals("e")) {
          sum = s.nextLine();
        }
        p.getBackground().undisplay();
        System.out.println("\nWhat would you like to buy?");
        String i = s.nextLine();
        exit = buyItems(i, s, p);
        show.undisplay();
      } 
      else {
        exit = buyItems(input, s, p);
        show.undisplay();
      }
    }
    show.undisplay();
    p.getBackground().undisplay();
  }

  
/**
 *  buying items
 *
 *  @param input String input
 *  @param scanner Scanner
 *  @param p Player
 *  @return True if exiting store
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean buyItems(String input, Scanner s, Player p) {
    boolean exit = false;
    while (!exit) {
      try {
        Item item = Item.valueOf(input.replaceAll("\\s", "").toUpperCase());
        System.out.println(item.getDescription());
        System.out.println(item.getName() + ", that would be $" + item.getBasePrice() + " for each. How many would you like?");
        input = s.nextLine();
        int parse = Util.parseInt(input);
        if (parse > 0) {
          System.out.println("That would be $" + parse * item.getBasePrice() + ". Is that ok?");
          input = s.nextLine();
          boolean yesno = Util.parseInput(input);
          if (yesno) {
            if (p.getMoney() < parse * item.getBasePrice()) {
              System.out.println("You can't afford that...Sorry!");
              exit = true;
              return exit;
            } else {
              System.out.println("Thank you! Please come again.");
              p.subtractMoney(parse * item.getBasePrice());
              for (int i = 0; i < parse; i ++) {
                p.addToInventory(item);
              }
              exit = true;
              return exit;
            }
          } else {
            System.out.println("Please come again.");
            exit = true;
            return exit;
          }
        } else {
          System.out.println("That's not a quantity.");
          exit = true;
          return exit;
        }
      } catch (Exception e) {
      System.out.println("We don't have that for sale, sorry.");
      exit = true;
      }
    }
    return exit;
  }

  
}