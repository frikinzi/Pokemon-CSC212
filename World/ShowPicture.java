import javax.swing.*;
import java.awt.*;

/**
 *  Class for graphics of game, including map graphics, battle graphics, etc.
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
class ShowPicture {
  
  private JFrame background;
  

/**
 *  Constructor for ShowPicture
 *
 *  @param background The JFrame parameter
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public ShowPicture(JFrame background) {
    this.background = background;
  }

  
/**
 *  Gets JFrame of ShowPicture Object
 *
 *  @return the JFrame 
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public JFrame getFrame() {
    return this.background;
  }

  
/**
 *  Sets frame of the ShowPicture object
 *
 *  @param frame the JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void setFrame(JFrame frame) {
    this.background = frame;
  }

  
/**
 *  Stop displaying an image
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void undisplay() { 
    getFrame().setVisible(false);
    getFrame().setBackground(null);
    getFrame().removeAll();
  }

  
/**
 *  Display Pokémon battle - your Pokémon on one side, opponent on the other
 *
 *  @param player The player's pokemon
 *  @param opposing The opposing pokemon
 *  @param weather The current weather
 *  @param location The player's current location
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public BattleGraphics displayBattle(Pokemon player, Pokemon opposing, Weather weather, Location location) {
    JFrame battle = new JFrame("Battle");
    setFrame(battle);
    BattleGraphics battle_canvas = new BattleGraphics(player, opposing, weather, location);

    battle.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    battle.add(battle_canvas);
    battle.pack();

    battle.setVisible(true);
    return battle_canvas;
  }

  
/**
 *  Refreshes battle with current Pokémon, weather, location
 *
 *  @param player The player's pokemon
 *  @param opposing The opposing pokemon
 *  @param weather The current weather
 *  @param location The location of the player
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void refreshJFrame(Pokemon player, Pokemon opposing, Weather weather, Location location, JFrame j) {
    BattleGraphics battle_canvas = new BattleGraphics(player, opposing, weather, location);
    j.getContentPane().removeAll();
    j.add(battle_canvas);
    j.pack();
    j.setVisible(true);
    j.repaint();
  }

  
/**
 *  Display one Pokémon - for summary screen
 *
 *  @param p The player's pokemon
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displayPokemon(Pokemon p, JFrame j) {
    var bframe = new JFrame("Summary");
    setFrame(bframe);
    var opposepoke = new ImageIcon(p.getBattleFront());
    var oppose_label = new JLabel(opposepoke);
    bframe.add(oppose_label);
    bframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    bframe.pack();
    bframe.setVisible(true);
  }

  
/**
 *  Display player's party
 *
 *  @param p The player's pokemon array
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displayParty(Pokemon[] p, JFrame j) {
    var bframe = new JFrame("Pokemon Party");
    setFrame(bframe);
    for (Pokemon poke : p) {
      if (poke != null) {
        var opposepoke = new ImageIcon(poke.getBattleFront());
        var oppose_label = new JLabel(opposepoke);
        bframe.add(oppose_label);
      }
    }
    bframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    bframe.pack();
    bframe.setVisible(true);
  }

  
/**
 *  Shows a specified image (param = directory of image)
 *
 *  @param j The JFrame
 *  @param s The image string
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void showImage(JFrame j, String s) {
    var bframe = new JFrame("");
    setFrame(bframe);
    var opposepoke = new ImageIcon(s);
    var oppose_label = new JLabel(opposepoke);
    bframe.add(oppose_label);
    bframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    bframe.pack();
    bframe.setVisible(true);
  }

  
/**
 *  Displays specified list of Pokémon
 *
 *  @param p The player's pokemon array
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displayPokemon(Pokemon[] p, JFrame j) {
    var bframe = new JFrame("Pokemon Party");
    setFrame(bframe);
    for (Pokemon poke : p) {
      if (poke != null) {
        var opposepoke = new ImageIcon(poke.getBattleFront());
        var oppose_label = new JLabel(opposepoke);
        bframe.add(oppose_label);
      }
    }
    bframe.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    bframe.pack();
    bframe.setVisible(true);
  }

  
/**
 *  Displays summary of specified pokemon
 *
 *  @param pokemon The player's pokemon
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displaySummary(Pokemon pokemon, JFrame j) {
    var frame = new JFrame("Pokemon Summary");
    setFrame(frame);
    var poke = new ImageIcon(pokemon.getBattleFront());
    JLabel label = new JLabel();
		frame.add(label);
    
		//Write text to the label
		String str = pokemon.toString();
    frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    JTextArea textArea = jText(str);
    frame.getContentPane().add(textArea, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

  
/**
 *  Displays JFrame text
 *
 *  @param text The specified text
 *  @return The text area
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public JTextArea jText(String text) {
    JTextArea textArea = new JTextArea(2, 50);
    textArea.setText(text);
    textArea.setWrapStyleWord(true);
    textArea.setLineWrap(true);
    textArea.setOpaque(false);
    textArea.setEditable(false);
    textArea.setFocusable(false);
    textArea.setBackground(UIManager.getColor("Label.background"));
    textArea.setFont(UIManager.getFont("Label.font"));
    textArea.setBorder(UIManager.getBorder("Label.border"));
    return textArea;
  }

  
/**
 *  Displays summary of specified pokemon
 *
 *  @param pokemon The player's pokemon
 *  @param j The JFrame
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displaySpecies(Pokemon pokemon, JFrame j) {
    var frame = new JFrame("Pokemon Species");
    setFrame(frame);
    var poke = new ImageIcon(pokemon.getBattleFront());
    JLabel label = new JLabel();
		frame.add(label);
		//Write text to the label
		String str = pokemon.getSpecies().toString();
    frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    JTextArea textArea = jText(str);
    frame.getContentPane().add(textArea, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }


/**
 *  Displays text on the screen
 *
 *  @param str The string to display
 *  @param j The JFrame
 *  @param j_name The label of the text
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
  public void displayText(String str, JFrame j, String j_name) {
    var frame = new JFrame(j_name);
    frame.setSize(30, 60);
    setFrame(frame);
    JLabel label = new JLabel();
    frame.add(label);
    //Write text to the label
    frame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    JTextArea textArea = jText(str);
    frame.getContentPane().add(textArea, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);
  }

  
}