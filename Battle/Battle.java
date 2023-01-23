import java.util.Scanner;
import java.util.Random;
import java.lang.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 *  Class defining a battle. can be either a battle between the player and a wild pokemon or a battle between trainers
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public class Battle {
  private int turn;
  private Player player1;
  private Trainer opponent;
  private Player player2;
  private Trainer winner;
  ArrayDeque<Pokemon> turn_order;
  private Weather weather;
  private int weather_turns;
  private boolean player_megaed;
  private boolean opponent_megaed;
  private Pokemon wild_poke;
  private ArrayList<String> player1_entry_hazards;
  private ArrayList<String> opponent_entry_hazards;
  private boolean wild_caught = false;
  private Weather terrain;
  private int terrain_turns;

/**
 *  Constructor taking in the player and another trainer controlled by the AI to start a new battle
 *  @param player1 The player playing the game
 *  @param npc The trainer that is battling the player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Battle(Player player1, Trainer npc) {
    this.player1 = player1;
    this.opponent = npc;
    turn_order = new ArrayDeque<Pokemon>();
    this.turn = 0;
    this.weather = null;
    this.weather_turns = 0;
    this.terrain = null;
    this.terrain_turns = 0;
    this.winner = null;
    this.player1_entry_hazards = new ArrayList<String>();
    this.opponent_entry_hazards = new ArrayList<String>();
    player_megaed = false;
    opponent_megaed = false;
  }

/**
 *  Constructor creating a wild battle
 *
 *  @param player1 The player playing the game
 *  @param p The wild pokemon that is battling the player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Battle(Player player1, Pokemon p) {
    this.player1 = player1;
    this.wild_poke = p;
    this.turn_order = new ArrayDeque<Pokemon>();
    this.turn = 0;
    this.weather = null;
    this.weather_turns = 0;
    this.terrain = null;
    this.terrain_turns = 0;
    this.player1_entry_hazards = new ArrayList<String>();
    this.opponent_entry_hazards = new ArrayList<String>();
    player_megaed = false;
    opponent_megaed = false;
  }

/**
 *  Increments turn
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void incrementTurn() {
    this.turn += 1;
  }

/**
 *  Method to determine if the battle is over
 *
 *  @return True if one side has all their Pokemon faint
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean shouldEndBattle() {
    if (wild_caught) {
      return true;
    }
    if (!player1.hasStandingPokemon()) {
      if (opponent != null) {
        winner = opponent;
      }
      return true;
    } else if (wild_poke != null) {
      if (wild_poke.isFainted()) {
        winner = player1;
        return true;
      }
    }
    else if (!opponent.hasStandingPokemon()) {
      winner = player1;
      return true;
    } 
    return false;
  }

/**
 *  Executes a battle between a trainer and a wild pokemon - can catch the wild pokemon
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void executeWildBattle() {
    Scanner scanner = new Scanner(System.in);
    Pokemon wild = this.wild_poke;
    System.out.println("Wild " + this.wild_poke.getSpecies().getName() + " appeared!");
    try { Thread.sleep(400);} catch (InterruptedException e) {};
    player1.setActivePokemon(player1.nextPokemonAlive());
    
    ShowPicture pic = player1.getBackground();
    pic.undisplay();
    pic.displayBattle(player1.getActivePokemon(), wild, getWeather(), player1.getLocation());

    
    determineOrder(player1.getActivePokemon(), this.wild_poke, Move.TACKLE, Move.TACKLE);
    while (!turn_order.isEmpty()) {
      Pokemon p = turn_order.removeFirst();
      if (p == player1.getActivePokemon()) {
        player1.getActivePokemon().onEnterBattle(this, wild);
      } else {
        wild.onEnterBattle(this, player1.getActivePokemon());
      } 
    }
    
    while (!this.shouldEndBattle()) {
      System.out.println("****TURN " + this.turn + "****\n");
      boolean decision_made = false;
      if (player1.getActivePokemon().isResting()) {
        System.out.println(player1.getActivePokemon().getNickname() + " must recharge!");
        wild.attack(wild.getRandomMove(), player1.getActivePokemon(), this);
        this.checkFainted();
      }
      while (decision_made == false) {
        System.out.println(battleInfo());
        System.out.println("\nWhat will you do? (1 = Fight, 2 = Switch, 3 = Bag, 4 = Summary)");    // so far only fight and switch work
        String input = scanner.nextLine();
        Pokemon playerpoke = player1.getActivePokemon();
       
        if (parseInput(input) == 1) {
          if (playerpoke.hasChargingMove()) {
            Move m = wild.getRandomMove();
            determineOrder(playerpoke, wild, playerpoke.getChargingMove(), m);
            while (!turn_order.isEmpty()) {
              Pokemon p = turn_order.removeFirst();
              if (!p.isFainted()) {
                if (p == playerpoke) {
                  p.attack(playerpoke.getChargingMove(), wild, this);
                  this.checkFainted();
                } else {
                  wild.attack(wild.getRandomMove(), player1.getActivePokemon(), this);
                  if (wild.isFainted()) {
                    if (!turn_order.isEmpty()) {
                      turn_order.removeFirst();
                    }
                  }
                  this.checkFainted();
                }
              }
            }
            playerpoke.setChargingMove(null);
            decision_made = true;
            break;
          }
          if (playerpoke.hasRunOutOfPP()) {
            Move m = wild.getRandomMove();
            determineOrder(playerpoke, wild, Move.STRUGGLE, m);
          
            while (!turn_order.isEmpty()) {
              Pokemon p = turn_order.removeFirst();
              if (!p.isFainted()) {
                if (p == playerpoke) {
                  p.attack(Move.STRUGGLE, wild, this);
                  this.checkFainted();
                } else {
                  wild.attack(wild.getRandomMove(), player1.getActivePokemon(), this);
                  if (wild.isFainted()) {
                    if (!turn_order.isEmpty()) {
                      turn_order.removeFirst();
                    }
                  }
                  this.checkFainted();
                }
              }
            }
            decision_made = true;
            break;
          }
          boolean will_mega = false;
          if (playerpoke.canMegaEvolve() && !player_megaed) {
            System.out.println("Would you like to Mega Evolve " + playerpoke.getNickname() + "?");
            input = scanner.nextLine();
            if (parseYN(input)) {
              will_mega = true;
            } else {
              will_mega = false;
            }
          }
          System.out.println("Choose a move!");
          for (int index = 0; index < playerpoke.getMoves().length; index ++) {
            if (playerpoke.getMoves()[index] != null) {
              System.out.println(index + ": " + playerpoke.getMoves()[index].getName() + "\tPP:" + playerpoke.getMovePP(index) + "/" + playerpoke.getMove(index).getPP() + "\tType: " + playerpoke.getMoves()[index].getType().getName() + "\n");
            }
          }
          System.out.println("-1 Cancel");
          input = scanner.nextLine();
          try {
            Integer decision = Integer.parseInt(input);
          } catch (Exception e) {
            continue; //cancel
          }
          Integer decision = Integer.parseInt(input);
          if (decision < 0 || decision > 3) {
            continue;
          }
          
          Move decision_move = player1.getActivePokemon().getMove(decision);
          System.out.println(decision_move);
          if (decision_move == null) {
            System.out.println("Not a valid move");
            continue;
          }
          if (playerpoke.isChoiceLocked()) {
            if (decision_move != playerpoke.getChoiceLockedMove()) {
              System.out.println(playerpoke.getNickname() + " must use " + playerpoke.getChoiceLockedMove().getName() + "!");
              continue;
            }
          }
          if (playerpoke.getHeldItem() == Item.ASSAULTVEST && decision_move.getMoveType() == MoveType.STATUS) {
            System.out.println(playerpoke.getNickname() + " can only use attacking moves because of its Assault Vest!");
            continue;
          }
          if (playerpoke.getMovePP(decision) == 0) {
            System.out.println(decision_move.getName() + " is out of PP!");
            continue;
          }
            
          Move m = wild.getRandomMove();
          if (will_mega) {
            playerpoke.megaEvolve();
            if (playerpoke.hasAbility(Ability.DROUGHT)) {
              playerpoke.setWeather(this, Weather.SUN);
            }
            player_megaed = true;
          }
          determineOrder(player1.getActivePokemon(), wild, decision_move, m);
          
          while (!turn_order.isEmpty()) {
            Pokemon p = turn_order.removeFirst();
            
            if (!p.isFainted()) {
              if (p == player1.getActivePokemon()) {
                if (p.getMoves()[decision].getSpecialEffect().equals("Multi-Hit")) {
          multiHitAttack(p, wild, p.getMoves()[decision]);  
                } else {
                  p.attack(p.getMoves()[decision], wild, this);
                }
                this.checkFainted();
              } else {
                wild.attack(wild.getRandomMove(), player1.getActivePokemon(), this);
                if (wild.isFainted()) {
                  if (!turn_order.isEmpty()) {
                    turn_order.removeFirst(); // if opponent fainted, player poke will not attack
                  }
                }
                this.checkFainted();
              }
            }
          }
          decision_made = true;
        } 
        else if (parseInput(input) == 2) {
          if (!(player1.getActivePokemon().hasType(Type.GHOST)) && wild.getAbility() == Ability.SHADOWTAG || (wild.getAbility() == Ability.ARENATRAP && !(player1.getActivePokemon().isAirborne())) || (wild.getAbility() == Ability.MAGNETPULL && player1.getActivePokemon().hasType(Type.STEEL))) {
            System.out.println("You are trapped and cannot switch!");
            continue;
          }
          boolean d = switchPokemon(scanner, false);
          decision_made = d;
          
          Pokemon p = player1.getActivePokemon();
          this.checkFainted();
        } 
        else if (parseInput(input) == 3) {
          player1.duplicatesInventory();
          System.out.println("Which Pokéball would you like to throw?");
          input = scanner.nextLine();
          Item used_item = Util.interpretItem(input);
          if (used_item == null) {
            System.out.println("Not a valid item");
            continue;
          }
          if (!player1.getInventory().contains(used_item)) {
            System.out.println("You don't have that item");
            continue;
          }
          if (used_item.getCategory() != 2 ) {
            System.out.println("Sorry, that's not a pokeball.");
            continue;
          }
          System.out.println(player1.getName() + " threw a " + used_item.getName() + "!");
          player1.removeFromInventory(used_item);
          boolean caught = wild.catchPoke(used_item);
          if (caught) {
            System.out.println("Gotcha! Caught " + wild.getSpecies().getName() + "!");
            if (player1.getActivePokemon().getOwner() instanceof Player) {
              if (player1.getActivePokemon().getLevel() != 100) {
                System.out.println(player1.getActivePokemon().getNickname() + " gained " + player1.getActivePokemon().getExpGain(wild_poke) + " experience!");
                  player1.getActivePokemon().gainExperience(player1.getActivePokemon().getExpGain(wild_poke));
                player1.getActivePokemon().trainEVStat(wild_poke.getSpecies().getEVYield());
              } 
            }
            wild.setOwner(player1);
            if (player1.isPartyFull()) {
        System.out.println("Your party is full. Sending " + wild.getNickname() + " to storage.");
            } 
            else {
              System.out.println(wild.getNickname() + " was added to your party!");
            }
            player1.addPartyMember(wild);
            System.out.println("Would you like to name " +  wild.getSpecies().getName() + "?");
            input = scanner.nextLine();
            boolean yesno = Util.parseInput(input);
            if (yesno) {
              System.out.println("Enter a nickname:");
              input = scanner.nextLine();
              wild.setNickname(input);
            }
            endOfBattle();
            
            wild_caught = true;
            winner = player1;
          } else {
            wild.attack(wild.getRandomMove(), player1.getActivePokemon(), this);
            this.checkFainted();
          }
          decision_made = true;
        }
        else if (parseInput(input) == 4) {
          System.out.println("Press e to exit");
          pic.displaySummary(player1.getActivePokemon(), pic.getFrame());
          String sum = scanner.nextLine();
          while (!sum.equals("e")) {
            sum = scanner.nextLine();
          }
          pic.undisplay();
        }
      }
      if (!this.shouldEndBattle()) {
        this.incrementTurn();
        executeEndOfTurn(scanner);
        pic.refreshJFrame(player1.getActivePokemon(), wild, getWeather(), player1.getLocation(), player1.getBackground().getFrame());
      }
      
    }
    if (winner == player1) {
      System.out.println(player1.getName() + " won the battle!");
    } else {
      System.out.println("You have no more Pokémon that can fight!");
      System.out.println("You dropped " + player1.getMoney() / 6 + " in panic...");
      player1.subtractMoney(player1.getMoney() / 6);
      player1.blackout();
    }
    endOfBattle();
    try { Thread.sleep(500);} catch (InterruptedException e) {};
    player1.getBackground().undisplay();
    pic = new ShowPicture(new JFrame());
    player1.setBackground(pic);
  }

  
/**
 *  Executes a battle between the trainer and the player
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void executeBattle() {
    System.out.println(opponent.getName() + " challenged you to a battle!");
    opponent_megaed = true;
    Scanner scanner = new Scanner(System.in);
    player1.setActivePokemon(player1.nextPokemonAlive());
    opponent.setActivePokemon(opponent.nextPokemonAlive());
    ShowPicture pic = player1.getBackground();
    pic.undisplay();
    pic.displayBattle(player1.getActivePokemon(), opponent.getActivePokemon(), getWeather(), player1.getLocation());
 
    determineOrder(player1.getActivePokemon(), opponent.getActivePokemon(), Move.TACKLE, Move.TACKLE);
    if (player1.getActivePokemon() == null) {
      winner = opponent;
      System.out.println("You have no more Pokémon that can fight!");
      return;
    }
    while (!turn_order.isEmpty()) {
      Pokemon p = turn_order.removeFirst();
      if (p == player1.getActivePokemon()) {
        player1.getActivePokemon().onEnterBattle(this, opponent.getActivePokemon());    
      } else {
        opponent.getActivePokemon().onEnterBattle(this, player1.getActivePokemon());
      }
    }
    opponent_megaed = false;
    
    while (!this.shouldEndBattle()) {
      System.out.println("****TURN " + this.turn + "****\n");
      boolean decision_made = false;
     
      if (player1.getActivePokemon().isResting()) {
        System.out.println(player1.getActivePokemon().getNickname() + " must recharge!");
        opponent.determineAction(player1.getActivePokemon(), opponent.getBestMove(opponent.getActivePokemon(), player1.getActivePokemon(), this), this);
        this.checkFainted();
      }
      while (decision_made == false) {
        System.out.println(battleInfo());
        System.out.println("\nWhat will you do? (1 = Fight, 2 = Switch, 3 = Bag, 4 = Summary)"); // so far only fight and switch work
        String input = scanner.nextLine();
        Pokemon playerpoke = player1.getActivePokemon();
       
        if (parseInput(input) == 1) {
          if (playerpoke.hasChargingMove()) {
            Move m = opponent.getBestMove(opponent.getActivePokemon(), playerpoke, this);
            determineOrder(playerpoke, opponent.getActivePokemon(), Move.STRUGGLE, m);
            while (!turn_order.isEmpty()) {
              Pokemon p = turn_order.removeFirst();
              if (!p.isFainted()) {
                if (p == playerpoke) {
                  p.attack(playerpoke.getChargingMove(), opponent.getActivePokemon(), this);
                  this.checkFainted();
                } else {
                  opponent.determineAction(player1.getActivePokemon(), m, this);
                  if (opponent.getActivePokemon().isFainted()) {
                    if (!turn_order.isEmpty()) {
                      turn_order.removeFirst();
                    }
                  }
                  this.checkFainted();
                }
              }
            }
            playerpoke.setChargingMove(null);
            decision_made = true;
            break;
          }
          if (playerpoke.hasRunOutOfPP()) {
            Move m = opponent.getBestMove(opponent.getActivePokemon(), playerpoke, this);
            determineOrder(playerpoke, opponent.getActivePokemon(), Move.STRUGGLE, m);
          
            while (!turn_order.isEmpty()) {
              Pokemon p = turn_order.removeFirst();
              if (!p.isFainted()) {
                if (p == playerpoke) {
                p.attack(Move.STRUGGLE, opponent.getActivePokemon(), this);
                this.checkFainted();
                } else {
                  opponent.determineAction(player1.getActivePokemon(), m, this);
                  if (opponent.getActivePokemon().isFainted()) {
                    if (!turn_order.isEmpty()) {
                      turn_order.removeFirst();
                    }
                  }
                  this.checkFainted();
                }
              }
            }
            decision_made = true;
            break;
          }
          boolean will_mega = false;
          if (playerpoke.canMegaEvolve() && !player_megaed) {
            System.out.println("Would you like to Mega Evolve " + playerpoke.getNickname() + "?");
            input = scanner.nextLine();
            if (parseYN(input)) {
              will_mega = true;
            } else {
              will_mega = false;
            }
          }
          System.out.println("Choose a move!");
          for (int index = 0; index < playerpoke.getMoves().length; index ++) {
            if (playerpoke.getMoves()[index] != null) {
              System.out.println(index + ": " + playerpoke.getMoves()[index].getName() + "\tPP:" + playerpoke.getMovePP(index) + "/" + playerpoke.getMove(index).getPP() + "\tType: " + playerpoke.getMoves()[index].getType().getName() + "\n");
            }
          }
          System.out.println("-1 Cancel");
          input = scanner.nextLine();
          try {
            Integer decision = Integer.parseInt(input);
          } catch (Exception e) {
            continue; //cancel
          }
          Integer decision = Integer.parseInt(input);
          if (decision < 0 || decision > 3) {
            continue;
          }
          
          Move decision_move = player1.getActivePokemon().getMove(decision);
          if (playerpoke.isChoiceLocked()) {
            if (decision_move != playerpoke.getChoiceLockedMove()) {
              System.out.println(playerpoke.getNickname() + " must use " + playerpoke.getChoiceLockedMove().getName() + "!");
              continue;
            }
          }
          if (playerpoke.getHeldItem() == Item.ASSAULTVEST && decision_move.getMoveType() == MoveType.STATUS) {
            System.out.println(playerpoke.getNickname() + " can only use attacking moves because of its Assault Vest!");
            continue;
          }
          if (playerpoke.getMovePP(decision) == 0) {
            System.out.println(decision_move.getName() + " is out of PP!");
            continue;
          }
          
          Move m = opponent.getBestMove(opponent.getActivePokemon(), player1.getActivePokemon(), this);
          if (will_mega) {
            playerpoke.megaEvolve();
            if (playerpoke.hasAbility(Ability.DROUGHT)) {
              playerpoke.setWeather(this, Weather.SUN);
            }
            player_megaed = true;
          }
          determineOrder(player1.getActivePokemon(), opponent.getActivePokemon(), decision_move, m);
          while (!turn_order.isEmpty()) {
            Pokemon p = turn_order.removeFirst();
            if (!p.isFainted()) {
              if (p == player1.getActivePokemon()) {
                if (p.getMoves()[decision].getSpecialEffect().equals("Multi-Hit")) {
                  multiHitAttack(p, opponent.getActivePokemon(), p.getMoves()[decision]);
                } else {
                  p.attack(p.getMoves()[decision], opponent.getActivePokemon(), this);
                }
                this.checkFainted();
              } else {
                opponent.determineAction(player1.getActivePokemon(), m, this);
                if (opponent.getActivePokemon().isFainted()) {
                  if (!turn_order.isEmpty()) {
                    turn_order.removeFirst(); // if opponent fainted, player poke will not attack
                  }
                }
                this.checkFainted();
              }
            }
          }
          decision_made = true;  
        } 
        else if (parseInput(input) == 2) {
          if (!(player1.getActivePokemon().hasType(Type.GHOST)) && opponent.getActivePokemon().getAbility() == Ability.SHADOWTAG || (opponent.getActivePokemon().getAbility() == Ability.ARENATRAP && !(player1.getActivePokemon().hasType(Type.FLYING))) || (opponent.getActivePokemon().getAbility() == Ability.MAGNETPULL && player1.getActivePokemon().hasType(Type.STEEL))) {
            System.out.println("You are trapped and cannot switch!");
            continue;
          }
          boolean d = switchPokemon(scanner, false);
          decision_made = d;
          Pokemon p = player1.getActivePokemon();
          this.checkFainted();
        } 
        else if (parseInput(input) == 3) {
          boolean b = Util.battleBag(scanner, player1);
          if (b) {
            Move lol = opponent.getBestMove(opponent.getActivePokemon(), player1.getActivePokemon(), this);            opponent.determineAction(player1.getActivePokemon(), lol, this);
            this.checkFainted();
            decision_made = true;
          }
        }
        else if (parseInput(input) == 4) {
          System.out.println("Press e to exit");
          pic.displaySummary(player1.getActivePokemon(), pic.getFrame());
          String sum = scanner.nextLine();
          while (!sum.equals("e")) {
            sum = scanner.nextLine();
          }
          pic.undisplay();
        }
      }
      if (!this.shouldEndBattle()) {
        this.incrementTurn();
        executeEndOfTurn(scanner);
        pic.refreshJFrame(player1.getActivePokemon(), opponent.getActivePokemon(), getWeather(), player1.getLocation(), player1.getBackground().getFrame());
      }
    }
    
    if (winner == player1) {
      System.out.println(player1.getName() + " won the battle!");
      System.out.println(player1.getName() + " won $" + opponent.getBaseMoney() + ".");
      player1.addMoney(opponent.getBaseMoney());
    } else {
      System.out.println("You have no more Pokémon that can fight!");
      System.out.println("You paid $" + player1.getMoney() / 6 + " to the winner...");
      player1.subtractMoney(player1.getMoney() / 6);
      player1.blackout();
    }
    endOfBattle();
    try { Thread.sleep(500);	} catch (InterruptedException e) {};
    //System.out.println("hhlakj");
    player1.getBackground().undisplay();
    pic = new ShowPicture(new JFrame());
    player1.setBackground(pic);
  }

  
/**
 *  Interprets a yes/no input
 *
 *  @param s User-inputted string
 *  @return Boolean interpretation of string
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static boolean parseYN(String s) {
    boolean valid_input = false;
    while (valid_input == false) {
      if (s.equals("N") || s.equals("No") || s.equals("no") || s.equals("n") || s.equals("nope") ||s.equals("Nope") || s.equals("NO")) {
        valid_input = true;
        return false;
      } else if ((s.equals("Y") || s.equals("Yes") || s.equals("yes") || s.equals("y") || s.equals("ya") ||s.equals("Ya") || s.equals("YES"))) {
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
 *  Faint check - if fainted, the player/opponent has to switch their pokemon
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void checkFainted() {
    Scanner scanner = new Scanner(System.in);
    Pokemon pl = player1.getActivePokemon();
    if (player1.getActivePokemon().isFainted()) {
      if (player1.hasStandingPokemon()) {
        switchPokemon(scanner, true);
      }     
    }
    if (wild_poke != null) {
      if (wild_poke.isFainted()) {
        return;
      }
    }
    if (opponent != null) {
      if (opponent.getActivePokemon().isFainted()) {
        if (opponent.hasStandingPokemon()) {
          opponent.switchPokemon(opponent.whoToSwitchIn(pl, this), pl, this);
        }
      }
    }
  }

  
/**
 *  prompts the player to switch pokemon. if the player is switching after their pokemon has fainted, then the opponent wont attack, but if the player switches as an action, then the opponent will attack.
 *
 *  @param scanner User scanner
 *  @param switch_front_faint Whether or not the pokemon has fainted
 *  @return Returns true if the pokemon has been switched out
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean switchPokemon(Scanner scanner, boolean switch_from_faint) {
    boolean valid_response = false;
    while (valid_response == false) {
      System.out.println("Who would you like to switch to?");
      Util.printSwitchOptions(player1);
      String input = scanner.nextLine();
      Integer decision = 0;
      try {
        decision = Integer.parseInt(input);
      } catch (Exception e) {
        if (!switch_from_faint) {
          return false;
        }
        continue;
      }
      if (player1.canSwitch(decision)) {
        if (switch_from_faint) {
          Pokemon last_active = player1.getActivePokemon();
          if (opponent != null) {
            player1.switchPokemon(player1.getPartyPokemon(decision), opponent.getActivePokemon(), this);
          } else {
            player1.switchPokemon(player1.getPartyPokemon(decision), wild_poke, this);
          }
          Util.printSwitchingOut(last_active, player1.getActivePokemon());
          valid_response = true;
          return true;
        }
        System.out.println("What to do with " + player1.getPartyPokemon(decision).getNickname() + "?");
        System.out.println("1: Switch In");
        System.out.println("2: View Summary");
        if (switch_from_faint == false) {
          System.out.println("3: Cancel");
        }
        input = scanner.nextLine();
        Integer more_decision = Integer.parseInt(input);
        if (more_decision == 1) {
          Pokemon last_active = player1.getActivePokemon();
          if (opponent == null) {
            player1.switchPokemon(player1.getPartyPokemon(decision), wild_poke, this);
            player1.getBackground().displayBattle(player1.getActivePokemon(), wild_poke, getWeather(), player1.getLocation());
          } else {
            player1.switchPokemon(player1.getPartyPokemon(decision), opponent.getActivePokemon(), this);
          }
          Util.printSwitchingOut(last_active, player1.getActivePokemon());
          valid_response = true;
          
          //if you are switching as an action
          if (!switch_from_faint) {
            if (opponent != null) {
              if (opponent.getActivePokemon().canMegaEvolve()) {
                opponent.getActivePokemon().megaEvolve();
              }
              opponent.determineActionSwitched(last_active, player1.getActivePokemon(), this);
              valid_response = true;
              player1.getBackground().displayBattle(player1.getActivePokemon(), opponent.getActivePokemon(), getWeather(), player1.getLocation());
              return true;
            } else {
              wild_poke.attack(wild_poke.getRandomMove(), player1.getActivePokemon(), this);
            }
            return true;
          }
        } else if (more_decision == 2) {
          Pokemon pokepoke = player1.getPartyPokemon(decision);
            System.out.println("Press e to exit");
            player1.getBackground().displaySummary(pokepoke, player1.getBackground().getFrame());
            String sum = scanner.nextLine();
            while (!sum.equals("e")) {
              sum = scanner.nextLine();
            }
            player1.getBackground().undisplay();
          return false;
        } else {
          if (switch_from_faint) {  
          } else {
            valid_response = true;
            return true;
          }
        }
      } else {
        if (switch_from_faint) {
          continue;
        }
        if (!switch_from_faint) {
          valid_response = true;
          return false;
        } 
       return false;  
      }
      return false;
    }
    return true;
  }

  
/**
 *  Uses a queue to determine turn order (determined by speed of pokemon, move priority, etc.)
 *
 *  @param player_poke The player's pokemon
 *  @param opposing_poke The pokemon that the player is fighting
 *  @param player_move The move that the player chose
 *  @param opponent_move The move that the pokemon chose
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void determineOrder(Pokemon player_poke, Pokemon opposing_poke, Move player_move, Move opponent_move) {
    if (opposing_poke.canMegaEvolve() && !opponent_megaed) {
      opposing_poke.megaEvolve();
    }
    if (opponent != null) {
      if (opponent.shouldSwitch(player_poke, this) == 1) {
        turn_order.addLast(opposing_poke);
        turn_order.addLast(player_poke);
        return;
      }
    }
    if (player_move.getPriority() > opponent_move.getPriority()) {
      turn_order.addLast(player_poke);
      turn_order.addLast(opposing_poke);
      return;
    } else if (opponent_move.getPriority() > player_move.getPriority()) {
      turn_order.addLast(opposing_poke);
      turn_order.addLast(player_poke);
      return;
    }
    else if (player_poke.getInBattleSpeed(this) > opposing_poke.getInBattleSpeed(this)) {
      turn_order.addLast(player_poke);
      turn_order.addLast(opposing_poke);
      return;
    } else if (player_poke.getInBattleSpeed(this) < opposing_poke.getInBattleSpeed(this)) {
      turn_order.addLast(opposing_poke);
      turn_order.addLast(player_poke);
      return;
    } else {
      Random rand = new Random();
      int t = rand.nextInt(2);
      if (t == 0) {
        turn_order.addLast(opposing_poke);
        turn_order.addLast(player_poke);
      } else {
        turn_order.addLast(player_poke);
        turn_order.addLast(opposing_poke);
      }
      return;
    }
  }

  
/**
 *  parses string input
 *
 *  @param s Inputted string
 *  @return Returns number based on string
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int parseInput(String s) {
    if (s.equals("Fight") || s.equals("f") || s.equals("fight")  || s.equals("1")) {
      return 1;
    } else if (s.equals("Switch") || s.equals("s") || s.equals("switch")  || s.equals("2")) {
      return 2;
    } else if (s.equals("Bag") || s.equals("3") || s.equals("bag")) {
      return 3;
    } else if (s.equals("Summary") || s.equals("4") || s.equals("summary")) {
      return 4;
    }
    return 1;
  }

  
/**
 *  Prints damage message - how much damage a move did to the pokemon
 *
 *  @param attacker The attacking pokemon
 *  @param defender The defending pokemon
 *  @param damage The damage dealt
 *  @param move The move that was used
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void printDamageMessage(Pokemon attacker, Pokemon defender, int damage, Move move) {
    System.out.println(attacker.getNickname() + " used " + move.getName() + " and dealt " + damage + " to " + defender.getOwner().getName() + "'s " + defender.getNickname() + "!");
  }

  
/**
 *  prints battle info: aka HP, active pokemon, etc.
 *
 *  @return Battle info for the player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String battleInfo() {
    if (opponent != null) {
      return "-------------------------------------\n" + player1.getName() + "'s Level " + player1.getActivePokemon().getLevel() + " " + player1.getActivePokemon().getNickname() + "\nHP: " + player1.getActivePokemon().getCurrentHP() + "/" + player1.getActivePokemon().calculateHP() + "\n-------------------------------------\n" + opponent.getName() + "'s Level " + opponent.getActivePokemon().getLevel() + " " + opponent.getActivePokemon().getNickname() + "\nHP: " + opponent.getActivePokemon().getCurrentHP() + "/" + opponent.getActivePokemon().calculateHP() + "\n-------------------------------------\n";
    }
    return "-------------------------------------\n" + player1.getName() + "'s Level " + player1.getActivePokemon().getLevel() + " " + player1.getActivePokemon().getNickname() + "\nHP: " + player1.getActivePokemon().getCurrentHP() + "/" + player1.getActivePokemon().calculateHP() + "\n-------------------------------------\n" + "Level " + wild_poke.getLevel() + " Wild " + wild_poke.getNickname() + "\nHP: " + wild_poke.getCurrentHP() + "/" + wild_poke.calculateHP() + "\n-------------------------------------\n";
  }

  
/**
 *  executes things to happen at the end of each turn - i.e. leftovers recovery, taking burn/poison damage, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void executeEndOfTurn(Scanner scanner) {
    Pokemon opposemon;
    Pokemon playermon = player1.getActivePokemon();
    if (opponent != null) {
      opposemon = opponent.getActivePokemon();
    } else {
      opposemon = this.wild_poke;
    }
    playermon.setFlinch(false);
    opposemon.setFlinch(false);
    playermon.setDestinyBond(false);
    opposemon.setDestinyBond(false);
    if (playermon.isResting()) {
      playermon.decrementResting();
    } 
    if (opposemon.isResting()) {
      opposemon.decrementResting();
    }
    if (!playermon.isFainted()) {
      if (playermon.getHeldItem() == Item.LEFTOVERS) {
        playermon.heal((int)(playermon.getMaxHP() / 16.0));
      }
      if (playermon.hasAbility(Ability.RAINDISH) && this.weather == Weather.RAIN) {
        playermon.heal((int)(playermon.getMaxHP() / 16.0));
      }
      if (playermon.isBurned()) {
        playermon.takeBurnDamage();
      } 
      if (playermon.isPoisoned()) {
        playermon.takePoisonDamage();
      } 
      if (playermon.isBadlyPoisoned() && !playermon.isFainted()) {
        playermon.takeToxicDamage();
      }  
      if (this.weather == Weather.SANDSTORM) {
        playermon.takeSandStormDamage();
      }
      if (player1.getActivePokemon().isFainted()) {
        if (player1.hasStandingPokemon()) {
          switchPokemon(scanner, true);
        }
      }
    } 
    if (!opposemon.isFainted()) {
      if (opposemon.isBurned() && !opposemon.isFainted()) {
        opposemon.takeBurnDamage();
      } 
      if (opposemon.isPoisoned() && !opposemon.isFainted()) {
        opposemon.takePoisonDamage();
      } 
      if (opposemon.isBadlyPoisoned() && !opposemon.isFainted()) {
        opposemon.takeToxicDamage();
      }  
      if (this.weather == Weather.SANDSTORM) {
        opposemon.takeSandStormDamage();
      }
      if (opposemon.isFainted()) {
        if (opponent != null) {
          if (opponent.hasStandingPokemon()) {
            opponent.switchPokemon(opponent.whoToSwitchIn(player1.getActivePokemon(), this), player1.getActivePokemon(), this);
          }
        }
      }
    }
    if (this.weather_turns > 0) {
      this.weather_turns -= 1;
      if (this.weather_turns > 0) {
        System.out.println(this.weather.getTurnEndMessage());
      }
      if (this.weather_turns == 0) {
        System.out.println(this.weather.getEndMessage());
        this.weather = null;
      }
    }   
    if (this.terrain_turns > 0) {
      this.terrain_turns -= 1;
      if (this.terrain_turns > 0) {
        System.out.println(this.terrain.getTurnEndMessage());
      }
      if (this.terrain_turns == 0) {
        System.out.println(this.terrain.getEndMessage());
        this.terrain = null;
      }
    }
  }

  
/**
 *  executes what should happen at the end of a battle. i.e. resetting all stat boosts, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void endOfBattle() {
    player1.resetAllPokemon();
    if (opponent != null) {
      opponent.resetAllPokemon();
      opponent.healParty();
    }
    if (wild_poke != null) {
      wild_poke.resetStatBoosts();
      wild_poke.setConfuseTurns(0);
      wild_poke.setChoiceLockedMove(null);
    } 
  }

  
/**
 *  ends the weather
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void endWeather() {
    System.out.println(this.weather.getEndMessage());
    this.weather = null;
    this.weather_turns = 0;
  }

  
/**
 *  sets the weather
 *
 *  @param w The new weather
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setWeather(Weather w) {
    this.weather = w;
    ShowPicture pic = player1.getBackground();
    if(wild_poke != null){
      pic.refreshJFrame(player1.getActivePokemon(), wild_poke, getWeather(), player1.getLocation(), player1.getBackground().getFrame());
    }
    else if(opponent != null){
      pic.refreshJFrame(player1.getActivePokemon(), opponent.getActivePokemon(), getWeather(), player1.getLocation(), player1.getBackground().getFrame());
    }
    
  }

  
/**
 *  sets weather turns
 *
 *  @param i The amount of turns the weather will last
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setWeatherTurns(int i) {
    this.weather_turns = i;
  }

  
/**
 *  sets the terrain
 *
 *  @param w The weather for the terrain
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setTerrain(Weather w) {
    this.terrain = w;
  }

  
/**
 *  sets terrain turns
 *
 *  @param i How long the terrain weather lasts
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setTerrainTurns(int i) {
    this.terrain_turns = i;
  }

  
/**
 *  gets the weather
 *
 *  @return The current weather condition
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Weather getWeather() {
    return this.weather;
  }

  
/**
 *  gets the terrain
 *
 *  @return The current terrain condition
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Weather getTerrain() {
    return this.terrain;
  }

  
/**
 *  parses user input (string) as item
 *
 *  @param item The item as a string
 *  @param scanner User scanner
 *  @return The item as an element of the item class
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Item parseItem(String item, Scanner scanner) {
    if (item.equals("Pokeball") || item.equals("Poke ball") || item.equals("poke ball") || item.equals("pokeball")) {
      return Item.POKEBALL;
    } else if (item.equals("Ultraball") || item.equals("Ultra ball") || item.equals("ultraball") || item.equals("ultra ball")) {
      return Item.ULTRABALL;
    } else if (item.equals("Masterball") || item.equals("master ball") || item.equals("masterball")) {
      return Item.MASTERBALL;
    } else if (item.equals("Greatball") || item.equals("greatball") || item.equals("great ball")) {
      return Item.GREATBALL;
    }
    return null;
  }

  
/**
 *  gets player's entry hazards
 *
 *  @return Player's entry hazards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<String> getPlayerEntryHazards() {
    return this.player1_entry_hazards;
  }

  
/**
 *  gets opponents entry hazards
 *
 *  @return Opponent's entry hazards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<String> getOpponentEntryHazards() {
    return this.opponent_entry_hazards;
  }

  
/**
 *  given a trainer, gets the trainer's opponents entry hazards
 *
 *  @param t The referenced trainer
 *  @return Trainer's entry hazards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<String> getOpposingEntryHazard(Trainer t) {
    if (t instanceof Player) {
      return this.opponent_entry_hazards;
    } 
    return this.player1_entry_hazards;
  }

  
/**
 *  given a trainer, gets the trainer's side of hazards
 *
 *  @param t The referenced trainer
 *  @return The trainer's side of hazards
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<String> getOwnHazards(Trainer t) {
    if (t instanceof Player) {
      return this.player1_entry_hazards;
    } 
    return this.opponent_entry_hazards;
  }

  
/**
 *  executes a multi-hit move. i.e. bullet seed
 *
 *  @param p The attacking pokemon
 *  @param defender The defending pokemon
 *  @param m The chosen move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void multiHitAttack(Pokemon p, Pokemon defender, Move m) {
    int times_hit = 1;
    Random rands = new Random();
    if (rands.nextDouble() <= 0.35) {
      for (int bla = 0; bla < 2 && !(defender.isFainted()); bla++) {
        p.attack(m, defender, this);  
      }
    } else if (rands.nextDouble() <= 0.70) {
      for (int bla = 0; bla < 3 && !(defender.isFainted()); bla++) {
        p.attack(m, defender, this);  
      }
    } else if (rands.nextDouble() <= 0.85) {
      for (int bla = 0; bla < 4 && !(defender.isFainted()); bla++) {
        p.attack(m, defender, this);  
      }
    } else {
      for (int bla = 0; bla < 5 && !(defender.isFainted()); bla++) {
        p.attack(m, defender, this);  
      }
    }
  }

  
/**
 *  Returns the winner of the battle
 *
 *  @return The winner
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Trainer getWinner() {
    return this.winner;
  }

  
}