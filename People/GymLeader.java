import java.util.*;

/**
 *  Gym leader class that extends Trainer. Gym leaders have different teams depending on the badges you have
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
class GymLeader extends Trainer {
  ArrayList<Pokemon[]> teams;
  Item reward;
  String losetext;
  String badge;

  
/**
 *  constructor defining a gym leader - including the item they give after defeat, possible teams, etc.
 *
 *  @param name The name of the gym leader
 *  @param money The money given when defeated
 *  @param teams The Pokemon teams they have
 *  @param reward The rewards given when defeated
 *  @param losetext The message when they lose
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public GymLeader(String name, int money, ArrayList<Pokemon[]> teams, Item reward, String losetext) {
    super(name, money);
    this.teams = teams;
    this.reward = reward;
    this.losetext = losetext;
    this.badge = "";
  }

  
/**
 *  Gets all the possible teams of the gym leader
 *
 *  @return The Pokemon teams they have
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public ArrayList<Pokemon[]> getTeams() {
    return this.teams;
  }

  
/**
 *  sets the badge name that the gym leader gives
 *
 *  @param s Badge name
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setBadge(String s) {
    this.badge = s;
  }

  
/**
 *  Gets the badge name that the gym leader gives
 *
 *  @return Badge name
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getBadge() {
    return this.badge;
  }

  
/**
 *  Gets the gym leader's team when the player has 0 badges
 *
 *  @return Gym leader's team when player has 0 badges
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Pokemon[] getZeroBadgeTeam() {
    return teams.get(0);
  }

  
/**
 *  Gets the gym leader's team when the player has 1 badge
 *
 *  @return Gym leader's team when player has 1 badge
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Pokemon[] getOneBadgeTeam() {
    return teams.get(1);
  }

  
/**
 *  Gets the gym leader's team when the player has 2 badges
 *
 *  @return Gym leader's team when player has 2 badges
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Pokemon[] getTwoBadgeTeam() {
    return teams.get(2);
  }

  
/**
 *  Gets the gym leader's team when the player has 3 badges
 *
 *  @return Gym leader's team when player has 3 badges
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Pokemon[] getThreeBadgeTeam() {
    return teams.get(3);
  }

  
/**
 *  Sets the gym leader's lose text
 *
 *  @param s The new lose text
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setLoseText(String s) {
    this.losetext = s;
  }

  
/**
 *  Gets the lose text of the gym leader. i.e. what they say after losing
 *
 *  @return Gym leader's lose text
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getLoseText() {
    return this.losetext;
  }

  
/**
 *  Gets reward item of the gym leader
 *
 *  @return Gym leader's reward
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Item getReward() {
    return this.reward;
  }

  
/**
 *  sets reward item of the gym leader
 *
 *  @param i The new item they give as reward
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setReward(Item i) {
    this.reward = i;
  }

  
/**
 *  sets the gym leader's team depending on the player's badges
 *
 *  @param p Current player
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setRightTeam(Player p) {
    if (!p.hasTag("FirstBadge")) {
      this.setParty(this.getZeroBadgeTeam());
      return;
    }
    if (!p.hasTag("SecondBadge")) {
      this.setParty(this.getOneBadgeTeam());
      return;
    } else if (!p.hasTag("ThirdBadge")) {
      this.setParty(this.getTwoBadgeTeam());
      return;
    } else {
      this.setParty(this.getThreeBadgeTeam());
    }
  }

  
}