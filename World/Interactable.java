import java.util.*;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

/**
 *  Class that creates an interactable encounter for a location
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Interactable {

  public static Species[] black_listed_wild = {Species.DIALGA,Species.LUGIA,Species.PALKIA,Species.HOOH,Species.ARTICUNO,Species.MOLTRES,Species.ZAPDOS,Species.SALAMENCE,Species.GARCHOMP,Species.GYARADOS,Species.VENUSAUR, Species.BLASTOISE,Species.CHARIZARD,Species.KORAIDON,Species.MIRAIDON,Species.TORTERRA,Species.URSARING,Species.EMPOLEON,Species.INFERNAPE,Species.NIDOKING,Species.NIDOQUEEN,Species.MAGNEZONE,Species.MAGNETON, Species.GIRATINA, Species.DECIDUEYE,Species.PRIMARINA,Species.INCINEROAR,Species.CENTISKORCH,Species.FROSMOTH,Species.RHYPERIOR,Species.SERPERIOR,Species.GABITE,Species.STARAPTOR,Species.PIDGEOT,Species.VIBRAVA,Species.FLYGON,Species.ALTARIA,Species.AGGRON,Species.GENGAR,Species.RAICHU,Species.TOGEKISS,Species.KOMMOO,Species.HAKAMOO,Species.METAGROSS,Species.METANG,Species.GROUDON,Species.KYOGRE,Species.TOXICROAK};
  public static List blastlist = Arrays.asList(black_listed_wild);

  
  /** 
  *  Interaction at moonforktown
  *
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void town(Player player) {
    choice(player);
  }

  
  /** 
  *  Interaction at Flashbreeze Swamp
  *
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void flashbreeze_swamp(Player player) {
    choice(player);
  }

  
  /** 
  * Interaction at Blazesting Factory
  *
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void blazesting_factory(Player player){
    if (!player.hasTag("BattledZapdos") && player.hasTag("FourthBadge")) {
      System.out.println("You feel your hair standing on end. The legendary Pokémon Zapdos glares at you, and then swoops down at you!");
  Battle wild = new Battle(player, new   Pokemon(Species.ZAPDOS, 50, null));
      wild.executeWildBattle();
      player.addTag("BattledZapdos");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Copperlock Peak
  *
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void copperlock_peak(Player player){
    if (!player.hasTag("BattledHoOh") && player.hasTag("FourthBadge")) {
      System.out.println("You could hear bells chiming in the distance. Ho-Oh challenges you to a battle!");
  Battle wild = new Battle(player, new   Pokemon(Species.HOOH, 70, null));
      wild.executeWildBattle();
      player.addTag("BattledHoOh");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Needlejaw Summit
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void needlejaw_summit(Player player){
    System.out.println("You feel a mysterious energy emanate throughout the peak.");
    if (!player.hasTag("BattledDialga") && player.hasTag("FourthBadge")) {
      System.out.println("You could almost feel time distorting around you. Dialga challenges you to a battle!");
  Battle wild = new Battle(player, new   Pokemon(Species.DIALGA, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledDialga");
    }
    if (!player.hasTag("BattledPalkia") && player.hasTag("FourthBadge")) {
      System.out.println("You could almost feel space warping around you. Palkia challenges you to a battle!");
  Battle wild = new Battle(player, new   Pokemon(Species.PALKIA, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledPalkia");
    }
    if (!player.hasTag("BattledGiratina") && player.hasTag("FourthBadge")) {
      System.out.println("You could almost feel the laws of physics distorting. Giratina challenges you to a battle!");
  Battle wild = new Battle(player, new   Pokemon(Species.GIRATINA, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledGiratina");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Ironsweep Ruins
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void ironsweep_ruins(Player player){
    choice(player);
  }

  
  /** 
  * Interaction at Mistfrond Grassland
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void mistfrond_grassland(Player player){
    if (!player.hasTag("BattledKoraidon") && player.hasTag("FourthBadge")) {
      System.out.println("You almost feel like you are brought back to prehistoric times. The legendary Koraidon jumps in front of you with all of its might!");
  Battle wild = new Battle(player, new   Pokemon(Species.KORAIDON, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledKoraidon");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Starglass Kelpbed
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void starglass_kelpbed(Player player){
    if (!player.hasTag("BattledLugia") && player.hasTag("FourthBadge")) {
      System.out.println("A large shadow looms over you. It's the legendary Pokémon Lugia!");
  Battle wild = new Battle(player, new   Pokemon(Species.LUGIA, 70, null));
      wild.executeWildBattle();
      player.addTag("BattledLugia");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Rustcry Isle
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void rustcry_isle(Player player){
    if (!player.hasTag("BattledMiraidon") && player.hasTag("FourthBadge")) {
      System.out.println("You almost feel like you are brought into the future. The legendary Miraidon swoops down in front of you!");
  Battle wild = new Battle(player, new   Pokemon(Species.MIRAIDON, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledMiraidon");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Sweetfloat Waterfront
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *   @version CSC 212, Fall 2022
  */
  public static void sweetfloat_waterfront(Player player){
    if (!player.hasTag("BattledKyogre") && player.hasTag("FourthBadge")) {
      System.out.println("A large shadow looms under you. It's the God Pokémon Kyogre!");
  Battle wild = new Battle(player, new   Pokemon(Species.KYOGRE, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledKyogre");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Shortbrush Hollow
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void shortbrush_hollow(Player player){
    if (!player.hasTag("BattledGroudon") && player.hasTag("FourthBadge")) {
      System.out.println("A large shadow looms under you. It's the God Pokémon Groudon!");
  Battle wild = new Battle(player, new   Pokemon(Species.GROUDON, 80, null));
      wild.executeWildBattle();
      player.addTag("BattledGroudon");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Blizzard Island
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void blizzard_island(Player player){
    if (!player.hasTag("BattledArticuno") && player.hasTag("FourthBadge")) {
      System.out.println("You hear a mystical cry and feel a bone-shaking chill. Articuno swoops right down at you!");
  Battle wild = new Battle(player, new   Pokemon(Species.ARTICUNO, 50, null));
      wild.executeWildBattle();
      player.addTag("BattledArticuno");
    }
    choice(player);
  }

  
  /** 
  * Interaction at Shatterflash Dunes
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void shatterflash_dunes(Player player){
    choice(player);
  }

  
  /** 
  * Interaction at Sunspore Grove
  * @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void sunspore_grove(Player player){
    if (!player.hasTag("BattledMoltres") && player.hasTag("FourthBadge")) {
      System.out.println("You feel heat radiate around you. It's the grove's guardian, Moltres!");
  Battle wild = new Battle(player, new   Pokemon(Species.MOLTRES, 50, null));
      wild.executeWildBattle();
      player.addTag("BattledMoltres");
    }
    choice(player);
  }

  /** 
  * Nurse interaction with the player and heal pokemon
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void nurseInteraction(Player p) {
    System.out.println("Hello! Welcome to the Pokémon Center. Would you like to heal your Pokémon?");
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    if (Util.parseInput(input)) {
      System.out.println("Ok, let me take your Pokémon for a second.");
      try { Thread.sleep(500);	} catch (InterruptedException e) {};
      System.out.println("1...");
      try { Thread.sleep(500);	} catch (InterruptedException e) {};
      System.out.println("2...");
      try { Thread.sleep(500);	} catch (InterruptedException e) {};
      System.out.println("3...");
      try { Thread.sleep(500);	} catch (InterruptedException e) {};
      p.healParty();
      System.out.println("All done! Your Pokémon are happy and healthy.");
      System.out.println("We hope to see you again!");
    } else {
      System.out.println("We hope to see you again!");
    } 
  }

  
  /** 
  * Gives player choice of what to do
  *  @param player The current player
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void choice(Player player) {
    boolean exit = false;
    while (!exit) {
      System.out.println("\nYou are currently in " + player.getLocation().getName() + ". \nWhat would you like to do?");
      String guide = "0 = Travel, 1 = Fight Other Trainer, 2 = Catch Wild Pokemon, 3 = Menu, 4 = Shop, 5 = Save, 6 = Exit Game";
      if (player.getLocation().getGymLeader() != null) {
        if (!player.hasTag("Defeated" + player.getLocation().getGymLeader().getName())) {
          guide += ", 7 = Challenge Gym Leader";
        } 
        if (player.hasTag("FourthBadge")) {
          guide += ", 7 = Gym Leader Rematch";
        }
      }
      System.out.println(guide);
  
      ArrayList<Trainer> trainers = player.getLocation().getTrainers();
      Scanner scanner = new Scanner(System.in);
      String input = scanner.nextLine();
      try{
        int int_input = Util.parseInt(input);
        if (int_input == 0) {
          player.travel();
        }
        else if (int_input == 1) {
          if (trainers == null) {
            System.out.println("No trainers nearby");
            continue;
          }
          Random rand = new Random();
          int p = rand.nextInt(trainers.size());
          trainers.get(p).rebalanceTeam(player);
          Battle battle = new Battle(player, trainers.get(p));
          battle.executeBattle();
        }
        else if (int_input == 2) {
          if (player.getLocation().getName().contains("Pokémon Center")) {
            System.out.println("There are no wild Pokémon indoors. Go touch some grass!");
            continue;
          }
          Species species = Species.getRandomSpecies();
          while (blastlist.contains(species)) {
            species = Species.getRandomSpecies();
          }
          Battle wild = new Battle(player, new Pokemon(species, player.getHighestLevelInParty(), null));
          wild.executeWildBattle();
        } else if (int_input == 3) {
          player.menu();
        } else if (int_input == 4) {
          Util.shop(scanner, player);
        } else if (int_input == 5) {
          String p_file = "Saves/" + player.getName().toLowerCase() + "_player.txt";
          Main.writeSaveFile(p_file, player);
        } else if (int_input == 6) {
          System.out.println("If you want to save before you go, press 0.");
          System.out.println("Press any number to exit without saving.");
          input = scanner.nextLine();
          try {
            int_input = Util.parseInt(input);
            if (int_input==0){
              String p_file = "Saves/" + player.getName().toLowerCase() + "_player.txt";
              Main.writeSaveFile(p_file, player);
            }
            exit = true; 
            System.exit(0);
          } catch(Exception e) {
            e.printStackTrace();
            System.out.println("That was not a valid input, please input a number between 0 and 6.");
            choice(player);
          }
        } else if (int_input == 7 && player.getLocation().getGymLeader() != null && !player.hasTag("Defeated" + player.getLocation().getGymLeader().getName()) || player.hasTag("FourthBadge")) {
          GymLeader g = player.getLocation().getGymLeader();
          g.setRightTeam(player);
          g.rebalanceTeam(player);
          Battle battle = new Battle(player, g);
          battle.executeBattle();
          if (battle.getWinner() == player) {
            System.out.println(player.getLocation().getGymLeader().getName() + ": " + player.getLocation().getGymLeader().getLoseText());
            if (!player.hasTag("Defeated" + player.getLocation().getGymLeader().getName())) {
              System.out.println(player.getLocation().getGymLeader().getName() + ": That was impressive! Here is the " + player.getLocation().getGymLeader().getBadge() + "!");
            }
  
            if (!player.hasTag("FirstBadge")) {
              player.addTag("FirstBadge");
            } else if (!player.hasTag("SecondBadge")) {
              player.addTag("SecondBadge");
            }  else if (!player.hasTag("ThirdBadge")) {
              player.addTag("ThirdBadge");
            } else if (!player.hasTag("FourthBadge")) {
              player.addTag("FourthBadge");
            }
            player.addTag("Defeated" + player.getLocation().getGymLeader().getName());
            System.out.println("Well done! As a gift, here is a " + player.getLocation().getGymLeader().getReward().getName());
            player.addToInventory(player.getLocation().getGymLeader().getReward());
          } 
        }
        else {
          System.out.println("Sorry that was the incorrect input. Please try again");
          choice(player);
        }
      } catch(Exception e) {
        e.printStackTrace();
        System.out.println("That was not a valid input, please input a number between 0 and 6.");
        choice(player);
      }
    }
  }

  
  /** 
  *  Deciphers location
  *  @param player The current player
  *  @param loc The location
  *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
  *  @version CSC 212, Fall 2022
  */
  public static void parseLoc(Player player, Location loc) {
    if (loc.equals(Location.MOONFORKTOWN)) {
      town(player);
    }
    else if (loc.equals(Location.PEAKPKMCENTER) || loc.equals(Location.TANGLEPKMCENTER) || loc.equals(Location.GROVEPKMCENTER) || loc.equals(Location.SANDSPKMCENTER) || loc.equals(Location.MOONFORKTOWNPKMCENTER)) {
      nurseInteraction(player);
    }
    else if (loc.equals(Location.IRONSWEEPRUINS)){
      ironsweep_ruins(player);
    }
    else if (loc.equals(Location.COPPERPEAK)){
      copperlock_peak(player);
    }
    else if(loc.equals(Location.STARGLASSKELPBED)){
      starglass_kelpbed(player);
    }
    else if (loc.equals(Location.RUSTCRYISLE)){
      rustcry_isle(player);
    }
    else if (loc.equals(Location.BLAZEFACTORY)){
      blazesting_factory(player);
    }
    else if (loc.equals(Location.NEEDLESUMMIT)){
      needlejaw_summit(player);
    }
    else if (loc.equals(Location.MISTGRASSLAND)){
      mistfrond_grassland(player);
    }
    else if (loc.equals(Location.SWEETFLOATWATER)){
      sweetfloat_waterfront(player);
    }
    else if (loc.equals(Location.SHORTBRUSHHOLLOW)){
      shortbrush_hollow(player);
    }
    else if (loc.equals(Location.SHATTERDUNES)){
      shatterflash_dunes(player);
    }
    else if (loc.equals(Location.SUNSPOREFOREST)){
      sunspore_grove(player);
    }
    else if (loc.equals(Location.BLIZZARDISLAND)){
      blizzard_island(player);
    }
    else if (loc.equals(Location.FLASHBREEZESWAMP)){
      flashbreeze_swamp(player);
    }
  }

  
}