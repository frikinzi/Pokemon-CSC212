import java.util.Scanner;

/**
 *  Class to create pokemon centers
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class PokemonCenter {

  /** 
  *  Constructor to create a Pokemon Center
  * @param npcs The NPC associated with a Pokemon Center
  * @param trainer The trainer at a Pokemon Center
  * @param name The name of the pokemon center
  * @param interactable The interactable function associated with the center
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public PokemonCenter(NPC[] npcs, Trainer trainer, String name, Interactable[] interactable) {  
  }

  
  /** 
  *  Interaction with the nurse at the pokemon center to heal pokemon
  *  @param p The current player
  * @author  Angela Jiang, Kira Kaplan, Sian Bareket
  * @version CSC 212, Fall 2022
  */
  public void nurseInteraction(Player p) {
    System.out.println("Hello! Welcome to the Pokémon Center. Would you like to heal your Pokémon?");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (Util.parseInput(input)) {
      System.out.println("Ok, let me take your Pokémon for a second.");
      try { Thread.sleep(100);	} catch (InterruptedException e) {};
      System.out.println("1...");
      try { Thread.sleep(100);	} catch (InterruptedException e) {};
      System.out.println("2...");
      try { Thread.sleep(100);	} catch (InterruptedException e) {};
      System.out.println("3...");
      try { Thread.sleep(100);	} catch (InterruptedException e) {};
      p.healParty();
      System.out.println("All done! Your Pokémon are happy and healthy.");
      System.out.println("We hope to see you again!");
    }
    System.out.println("We hope to see you again!");
  }


}