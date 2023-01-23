import java.lang.*;
import java.util.*;
import java.io.*;
import com.google.common.graph.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;


/**
 *  Main class runs the game. If the player is new, allows them to pick a starter pokemon. the player can create infinitely many save files technically, and load old save files
 *  Credits: All Pokémon and concepts belong to Nintendo, the Pokémon Company, and Game Freak. Pokémon sprites by Game Freak, Miraidon and Koraidon sprites by https://www.deviantart.com/kingofthe-x-roads. Mega Flygon sprite by Pokemon Insurgence team. Inspiration from Pokémon Essentials by Maruno.
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
class Main {

  public static Pokemon read_poke;
/**
 *  main function runs the game
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void main(String[] args) {
    
    String[] pathnames;
    File f = new File("Saves");

    // Populates the array with names of files and directories
    pathnames = f.list();
    
    Scanner scanner = new Scanner(System.in);
    JFrame oak_frame = new JFrame();
    ShowPicture oak = new ShowPicture(oak_frame);
    oak.showImage(oak.getFrame(), "Graphics/pictures/introOak.png");
    System.out.println("Professor Tree: " + NPC.PROFESSORTREE.getDialogue());
    String status = scanner.nextLine();
    int j = Util.parseInt(status);
    String p_file = null;
    String name = null;

    if (j == 0) {
     System.out.println("\nProfessor Tree: " + NPC.PROFESSORTREE.getDialogueTwo());
      System.out.println("By the way, these are the names we got on file.");
      ArrayList<String> existing = new ArrayList<String>();
        for (String pathname : pathnames) {
          // Print the names of files and directories
          if (pathname.contains("_player.txt")) {
            System.out.println(pathname.split("_",-1)[0]);
            existing.add(pathname.split("_",-1)[0]);
          }
        }
      name = scanner.nextLine();
      String lower_input = name.toLowerCase();
      if (!(existing.contains(lower_input))) {
        System.out.println("Ok, looks like you're new here. We're going to start a new game. Alright?");
        j = 1;
      } else {
        p_file = "Saves/" + lower_input + "_player.txt";
      }
      
    }
    if (j == 1 || j == -1) {
      System.out.println("\nProfessor Tree: " + NPC.PROFESSORTREE.getDialogueTwo());
      name = scanner.nextLine();
      String lower_input = name.toLowerCase();
      p_file = "Saves/" + lower_input + "_player.txt";
    }
    
    oak.undisplay();
    ArrayList<Trainer> trainers = readSaveFile("Saves/trainers.txt");
    Player p = readPlayerFile(p_file);
    JFrame map = new JFrame("Map");
    Map map_canvas = new Map(p.getLocation().getX(), p.getLocation().getY());

    map.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    map.add(map_canvas);
    map.pack();
  
    map.setVisible(false);
    p.setName(name);
    p.setMoney(5000);
    JFrame frame = new JFrame();
    ShowPicture pic = new ShowPicture(frame);
    p.setBackground(pic);
    map.setVisible(true);

    //Creates world
    ImmutableValueGraph<Location, Integer> world = WorldMap.createWorldMap();
    p.setWorld(world);
    p.setMap(map);
    p.setMapCanvas(map_canvas);
    if (p.partyIsEmpty()) {
      pic.undisplay();

      if (j == 1) {
        //Lets new player pick initial pokemon
        System.out.println("We found some Pokémon in the wild a while ago... They need a trainer. Which one will you take? (1 = Turtwig, 2 = Chimchar, 3 = Piplup)");
        ShowPicture show = p.getBackground();
        show.displayPokemon(new Pokemon[] {new Pokemon(Species.TURTWIG, 5, null), new Pokemon(Species.CHIMCHAR, 5, null), new Pokemon(Species.PIPLUP, 5, null)}, p.getBackground().getFrame());       
        boolean valid = false;
        while (!valid) {
          String input = scanner.nextLine();
          int i = Util.parseInt(input);
          if (i >= 1 && i <= 3) {
            if (i == 1) {
              System.out.println("\nTurtwig! The Tiny Leaf Pokémon. What a great choice! Your new friend will be joining you on this journey.");
              System.out.println("Obtained Turtwig!");
              p.addPartyMember(new Pokemon(Species.TURTWIG, 5, p));
              valid = true;
            } else if (i == 2) {
              System.out.println("\nChimchar! The Monkey Pokémon. What a fiery choice! Your new friend will be joining you on this journey.");
              System.out.println("Obtained Chimchar!");
              p.addPartyMember(new Pokemon(Species.CHIMCHAR, 5, p));
              valid = true;
            } else if (i == 3) {
              System.out.println("\nPiplup! The Penguin Pokémon. What a cute choice! Your new friend will be joining you on this journey.");
              System.out.println("Obtained Piplup!");
              p.addPartyMember(new Pokemon(Species.PIPLUP, 5, p));
              valid = true;
            }
            System.out.println("Also, here are 20 Pokéballs to get you started!");
            p.addToInventory(Item.POKEBALL, 20);
          }
          else {
            System.out.println("Welcome back to the game " + p.getName() + "! We've saved your progress!\n");
          }
          p.getBackground().undisplay();
          p.setBackground(pic);
        } 
      }
    } 
    Interactable.town(p);
    writeSaveFile(p_file, p);
  }

  
/**
 *  reads a gym leader file - adds all the gym leader's possible teams
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static GymLeader readGymLeaderFile(String filename) {
    Pokemon[] team = new Pokemon[6];
    int pokeno = 0;
    GymLeader t = new GymLeader("", 10000, new ArrayList<Pokemon[]>(), null, "");
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      return new GymLeader("", 0,new ArrayList<Pokemon[]>(), null, "");
    }
    while (file.hasNextLine()) {
      String line = file.nextLine();
      if (line.startsWith("[")) {
        t = new GymLeader(line.substring(1, line.length()-1), 10000,new ArrayList<Pokemon[]>(), null, "");
      }
      if (line.startsWith("Items")) {
        if (!line.equals("Items=")) {
          String[] items = line.split("=",-1)[1].split(",",-1);
          for (int i = 0; i < items.length; i++) {
            t.addToInventory(Item.valueOf(items[i]));
          }
        }
      } 
      if (line.startsWith("Reward")) {
        if (!line.equals("Reward=")) {
          t.setReward(Item.valueOf(line.split("=",-1)[1]));
        }
      } 
      if (line.startsWith("LoseText")) {
        if (!line.equals("LoseText=")) {
          t.setLoseText(line.split("=",-1)[1]);
        }
      } 
      if (line.startsWith("Badge")) {
        if (!line.equals("Badge=")) {
          t.setBadge(line.split("=",-1)[1]);
        }
      }
      if (line.startsWith("end")) {
        t.getTeams().add(team);
        team = new Pokemon[6];
        pokeno = 0;
      }
      if (line.startsWith("Pokemon")) {
        try {
          Species species = Species.valueOf(line.split("=",-1)[1].split(",",-1)[0]);
          read_poke = new Pokemon(species, Integer.valueOf(line.split("=",-1)[1].split(",",-1)[1]), t);
          line = "**";
          while (line.startsWith("**") && file.hasNextLine()) {
            line = file.nextLine();
            
            // set IVs
            if (line.startsWith("**IVs")) {
              String[] string_ivs = line.split("=",2)[1].split(",",6);
              int[] ivs = new int[6];
                for(int i = 0;i < string_ivs.length;i++) {
                  ivs[i] = Integer.parseInt(string_ivs[i]);
                }
            read_poke.setIVs(ivs);
            } 
            
            // set EVs 
            if (line.startsWith("**EVs")) {
              String[] string_evs = line.split("=",-1)[1].split(",",-1);
              int[] evs = new int[6];
              for(int i = 0;i < string_evs.length;i++) {
                evs[i] = Integer.parseInt(string_evs[i]);
              }
            read_poke.setEVs(evs);
            }  if (line.startsWith("**Shiny")) {
              read_poke.setShiny(true);          
            } 
            if (line.startsWith("**Moves")) {
              read_poke.setMoves(new Move[4]);
              String[] string_moves = line.split("=",-1)[1].split(",",-1);
              for (int i = 0;i < string_moves.length;i++) {
                read_poke.setMove(i, Move.valueOf(string_moves[i]));
              }
            } if (line.startsWith("**Ability")) {
              read_poke.setAbility(Integer.valueOf(line.split("=",-1)[1]));
            } if (line.startsWith("**Item")) {
              if (!(line.equals("**Item="))) {
                read_poke.setHeldItem(Item.valueOf(line.split("=",-1)[1]));
                Item.valueOf(line.split("=",-1)[1]).onGive(read_poke);
              }
            }    
            if (line.startsWith("**Nature")) {
              read_poke.setNature(Nature.valueOf(line.split("=",-1)[1]));
            }
          }
          read_poke.fullyHeal();
          team[pokeno] = read_poke;
          pokeno += 1;
        } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Not a valid Pokémon");
        }
      }
    }
    return t;
  }

  
/**
 *  Reads a player save file
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static Player readPlayerFile(String filename) {
    Player t = new Player("", 0, Location.MOONFORKTOWNPKMCENTER);
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      return new Player("", 0, Location.MOONFORKTOWNPKMCENTER);
    }
    while (file.hasNextLine()) {
      String line = file.nextLine();
      if (line.startsWith("[")) {
        t = new Player(line.substring(1, line.length()-1), 0, Location.MOONFORKTOWNPKMCENTER);
      }
      if (line.startsWith("Items")) {
        if (!line.equals("Items=")) {
          String[] items = line.split("=",-1)[1].split(",",-1);
          for (int i = 0; i < items.length; i++) {
            t.addToInventory(Item.valueOf(items[i]));
          }
        }
      } if (line.startsWith("Tags")) {
        if (!line.equals("Tags=")) {
          String[] tags = line.split("=",-1)[1].split(",",-1);
          for (int i = 0; i < tags.length; i++) {
            t.addTag(tags[i]);
          }
        }
      }
      if (line.startsWith("Money")) {
        int money = Integer.parseInt(line.split("=",-1)[1]);
        t.addMoney(money);
      } if (line.startsWith("Location")) {
        Location location = Location.valueOf(line.split("=",-1)[1]);
        t.setLocation(location);
      }
      int pokeno = 0;
      if (line.startsWith("Pokemon")) {
        try {
          Species species = Species.valueOf(line.split("=",-1)[1].split(",",-1)[0]);
          read_poke = new Pokemon(species, Integer.valueOf(line.split("=",-1)[1].split(",",-1)[1]), t);
          read_poke.setShiny(false);
          line = "**";
          while (line.startsWith("**") && file.hasNextLine()) {
            line = file.nextLine();
            
            // set IVs
            if (line.startsWith("**IVs")) {
              String[] string_ivs = line.split("=",2)[1].split(",",6);
              int[] ivs = new int[6];
              for(int i = 0;i < string_ivs.length;i++) {
                ivs[i] = Integer.parseInt(string_ivs[i]);
              }
              read_poke.setIVs(ivs);          
            } if (line.startsWith("**Shiny")) {
              read_poke.setShiny(true);          
            } 
            // set EVs 
            if (line.startsWith("**EVs")) {
              String[] string_evs = line.split("=",-1)[1].split(",",-1);
              int[] evs = new int[6];
              for(int i = 0;i < string_evs.length;i++) {
                evs[i] = Integer.parseInt(string_evs[i]);
              }
              read_poke.setEVs(evs);
            } if (line.startsWith("**Moves")) {
              read_poke.setMoves(new Move[4]);
              String[] string_moves = line.split("=",-1)[1].split(",",-1);
              for (int i = 0;i < string_moves.length;i++) {
                read_poke.setMove(i, Move.valueOf(string_moves[i]));
              }
            } if (line.startsWith("**Ability")) {
              read_poke.setAbility(Integer.valueOf(line.split("=",-1)[1]));
            } if (line.startsWith("**Item")) {
              if (!(line.equals("**Item="))) {
                read_poke.setHeldItem(Item.valueOf(line.split("=",-1)[1]));
                Item.valueOf(line.split("=",-1)[1]).onGive(read_poke);
              }
            } if (line.startsWith("**Nature")) {
              read_poke.setNature(Nature.valueOf(line.split("=",-1)[1]));
            }      
          }
          read_poke.fullyHeal();
          if (!t.isPartyFull()) {
            t.addPartyMember(read_poke);
          } else {
            t.getStorage().add(read_poke);
          }
          pokeno += 1;
        } catch (Exception e) {
          System.out.println("Not a valid Pokémon");
        }     
      }
    }
    return t;
  }

  
/**
 *  reads trainer file
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static ArrayList<Trainer> readSaveFile(String filename) {
    ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    Scanner file = null;
    try {
      file = new Scanner(new File(filename));
    } catch (FileNotFoundException e) {
      System.err.println("That file doesn't exist.");
      System.exit(-1);
    }
    while (file.hasNextLine()) {
      String line = file.nextLine();
      if (line.startsWith("[")) {
        Trainer t = new Trainer(line.substring(1, line.length()-1), 0);
        trainers.add(0, t);
      } if (line.startsWith("Money")) {
        try {
          trainers.get(0).setBaseMoney(Integer.parseInt(line.split("=",-1)[1]));
        } catch (Exception e) {
          System.out.println("Something went wrong!");
        }       
      }
      
      if (line.startsWith("Items")) {
        String[] items = line.split("=",-1)[1].split(",",-1);
        for (int i = 0; i < items.length; i++) {
          trainers.get(0).addToInventory(Item.valueOf(items[i]));
        }
      }
      
      if (line.startsWith("Pokemon")) {
        try {
          Species species = Species.valueOf(line.split("=",-1)[1].split(",",-1)[0]);
          read_poke = new Pokemon(species, Integer.valueOf(line.split("=",-1)[1].split(",",-1)[1]), trainers.get(0));
          line = "**";
          while (line.startsWith("**") && file.hasNextLine()) {
            line = file.nextLine();
            
            // set IVs
            if (line.startsWith("**IVs")) {
              String[] string_ivs = line.split("=",2)[1].split(",",6);
              int[] ivs = new int[6];
              for(int i = 0;i < string_ivs.length;i++) {
                ivs[i] = Integer.parseInt(string_ivs[i]);
              }
              read_poke.setIVs(ivs);             
            } 
            
            // set EVs 
            if (line.startsWith("**EVs")) {
              String[] string_evs = line.split("=",-1)[1].split(",",-1);
              int[] evs = new int[6];
              for(int i = 0;i < string_evs.length;i++) {
                evs[i] = Integer.parseInt(string_evs[i]);
              }
              read_poke.setEVs(evs);
            } if (line.startsWith("**Moves")) {
              String[] string_moves = line.split("=",-1)[1].split(",",-1);
              for (int i = 0;i < string_moves.length;i++) {
                read_poke.setMove(i, Move.valueOf(string_moves[i]));
              }
            } if (line.startsWith("**Ability")) {
              try {
                read_poke.setAbility(Integer.valueOf(line.split("=",-1)[1]));
              } catch (Exception e) {
                System.out.println(read_poke.getSpecies().getName() + "'s ability is invalid");
              }  
            } if (line.startsWith("**Item")) {
              if (!(line.equals("**Item="))) {
                read_poke.setHeldItem(Item.valueOf(line.split("=",-1)[1]));
                Item.valueOf(line.split("=",-1)[1]).onGive(read_poke);
              }
            } if (line.startsWith("**Nature")) {
              read_poke.setNature(Nature.valueOf(line.split("=",-1)[1]));
            }
          }
          read_poke.fullyHeal();
          trainers.get(0).addPartyMember(read_poke);
        } catch (Exception e) {
          System.out.println("Error: Pokémon doesn't exist, or something went wrong with reading in its stats");
        }
      }
    }
    return trainers;
  }

  
/**
 *  writes player save file
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void writeSaveFile(String filename, Player p) {
    System.out.println("Saving...");
    try {
      PrintWriter file = new PrintWriter(new FileWriter(filename));
      file.println("[" + p.getName() + "]");
      String items = "Items=";
      for (Item item : p.getInventory()) {
        items += item.name() + ",";
      }
      if (!items.equals("Items=")) {
        items = items.substring(0, items.length() - 1);
      }
      file.println(items);
      file.println("Money=" + p.getMoney());
      String tags = "Tags=";
      for (String tag : p.getTags()) {
        if (tag != null) {
          tags += tag + ",";
        }
      }
      if (!tags.equals("Tags=")) {
        tags = tags.substring(0, tags.length() - 1);
      }
      file.println(tags);
      file.println("Location=" + p.getLocation().name());
      for (Pokemon poke : p.getParty()) {
        if (poke != null) {
          file.println("Pokemon=" + poke.getSpecies().name() + ","+ poke.getLevel());
          file.println("**EXP=" + poke.getExp());
          if (poke.isShiny()) {
            file.println("**Shiny");
          }
          if (poke.getHeldItem() != null) {
            file.println("**Item=" + poke.getHeldItem().name());
          }
          file.println("**IVs=" + poke.getIVByIndex(0) + "," + poke.getIVByIndex(1)+ "," + poke.getIVByIndex(2)+ "," + poke.getIVByIndex(3)+ "," + poke.getIVByIndex(4)+ "," + poke.getIVByIndex(5));
          file.println("**EVs=" + poke.getEVByIndex(0) + "," + poke.getEVByIndex(1)+ "," + poke.getEVByIndex(2)+ "," + poke.getEVByIndex(3)+ "," + poke.getEVByIndex(4)+ "," + poke.getEVByIndex(5));
          file.println("**Nature=" + poke.getNature().name());
          String s = "**Moves=";
          for (Move move : poke.getMoves()) {
            if (move != null) {
              s += move.name() + ",";
            }
          }
          if (!s.equals("**Moves=")) {
            s = s.substring(0, s.length() - 1);
          }
          file.println(s);
          file.println("**Ability=" + poke.getSpecies().getIndexAbility(poke.getAbility()) + "\n");
        }
      } if (!p.getStorage().isEmpty()) {
        for (Pokemon storage : p.getStorage()) {
          file.println("Pokemon=" + storage.getSpecies().name() + ","+ storage.getLevel());
          file.println("**EXP=" + storage.getExp());
          if (storage.getHeldItem() != null) {
            file.println("**Item=" + storage.getHeldItem().name());
          }
          file.println("**IVs=" + storage.getIVByIndex(0) + "," + storage.getIVByIndex(1)+ "," + storage.getIVByIndex(2)+ "," + storage.getIVByIndex(3)+ "," + storage.getIVByIndex(4)+ "," + storage.getIVByIndex(5));
          file.println("**EVs=" + storage.getEVByIndex(0) + "," + storage.getEVByIndex(1)+ "," + storage.getEVByIndex(2)+ "," + storage.getEVByIndex(3)+ "," + storage.getEVByIndex(4)+ "," + storage.getEVByIndex(5));
          file.println("**Nature=" + storage.getNature().name());
          String s = "**Moves=";
          for (Move move : storage.getMoves()) {
            if (move != null) {
              s += move.name() + ",";
            }
          }
          if (!s.equals("**Moves=")) {
            s = s.substring(0, s.length() - 1);
          }
          file.println(s);
          file.println("**Ability=" + storage.getSpecies().getIndexAbility(storage.getAbility()) + "\n");
        }
      }
      file.close();
      System.out.println("Saved!"); 
    } catch (Exception e) {
      System.out.println(e.getMessage());
      System.out.println("Something went wrong");
    }
  }



//not entirely sure if we ever use this so may just delete
/**
 *  creates a file
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static void createFile(String filename) {
    File file = new File("Saves/" + filename + "_player.txt");
    boolean result;  
    try {  
      result = file.createNewFile(); 
      if (result) { 
      }  
      else {  
      System.out.println("\nThat file already exists, sorry!");  
      System.exit(-1);
      }  
      } catch (IOException e)   
      {  
      e.printStackTrace();
      }         
   }



  
}