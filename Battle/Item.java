/**
 *  Enum class defining items in the game - held items, poke balls, medicine, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */

public enum Item {
  
  // potions and healing items
  POTION("Heal20", 20, "Potion", "Potions", "A medicine that heals 20 HP.", null, true, 1, 300),
  SUPERPOTION("Heal50", 50, "Super Potion","Super Potions", "A medicine that heals 50 HP.", null, true, 1, 700),
  MAXPOTION("HealMax", 0, "Max Potion", "Max Potions", "A medicine that restores all of the Pokémon's HP.", null, true, 1, 2000),
  HYPERPOTION("Heal200", 0, "Hyper Potion", "Hyper Potions", "A medicine that restores 200 HP.", null, true, 1, 1000),
  FULLRESTORE("HealAll", 0, "Full Restore", "Full Restores", "A medicine that restores all of the Pokémon's HP and cures all status ailments.", null, true, 1, 3000),
  FULLHEAL("CureAllStatusCondition", 0, "Full Heal", "Full Heals", "A medicine that cures the Pokémon of any status condition.", null, true, 1, 600),
  REVIVE("Revive", 0, "Revive", "Revives", "A medicine that revives a fainted Pokémon at half HP.", null, true, 1, 1200),
  MAXREVIVE("ReviveHealAll", 0, "Max Revive", "Max Revives", "A medicine that revives a fainted Pokémon and restores it to full health.", null, true, 1, 5000),

  //pokeballs
  MASTERBALL("Pokeball", 0, "Master Ball", "Master Balls", "A Pokéball that guarentees the capture of any Pokémon", null, true, 2, 1000000000),
  POKEBALL("Pokeball", 0, "Poké Ball", "Poké Balls", "Can be used to capture wild Pokémon.", null, true, 2, 100),
  ULTRABALL("Pokeball", 0, "Ultra Ball", "Ultra Balls", "A Pokéball that doubles the chance of capturing a wild Pokémon.", null, true, 2, 1200),
  GREATBALL("Pokeball", 0, "Great Ball", "Great Balls", "A Pokéball that increases the chance of capturing a wild Pokémon.", null, true, 2, 600),

  //mega stones
  CHARIZARDITEX("Held", 0, "Charizardite X", "Charizardite X", "One of the mysterious Mega Stones. Let Charizard hold it to allow it to Mega Evolve into Mega Charizard X.", null, false, 4, 10000),
  CHARIZARDITEY("Held", 0, "Charizardite Y", "Charizardite Y", "One of the mysterious Mega Stones. Let Charizard hold it to allow it to Mega Evolve into Mega Charizard Y.", null, false, 4, 10000),
  VENUSAURITE("Held", 0, "Venusarite", "Venusarites", "One of the mysterious Mega Stones. Let Venusaur hold it to allow it to Mega Evolve into Mega Venusaur.", null, false, 4, 10000),
  BLASTOISITE("Held", 0, "Blastoisite", "Blastoisites", "One of the mysterious Mega Stones. Let Blastoise hold it to allow it to Mega Evolve into Mega Blastoise.", null, false, 4, 10000),
  GENGARITE("Held", 0, "Gengarite", "Gengarites", "One of the mysterious Mega Stones. Let Gengar hold it to allow it to Mega Evolve into Mega Gengar.", null, false, 4, 10000),
  PIDGEOTITE("Held", 0, "Pidgeotite", "Pidgeotites", "One of the mysterious Mega Stones. Let Pidgeot hold it to allow it to Mega Evolve into Mega Pidgeot.", null, false, 4, 10000),
  SALAMENCITE("Held", 0, "Salamencite", "Salamencites", "One of the mysterious Mega Stones. Let Salamence hold it to allow it to Mega Evolve into Mega Salamence.", null, false, 4, 10000),
  AGGRONITE("Held", 0, "Aggronite", "Aggronites", "One of the mysterious Mega Stones. Let Aggron hold it to allow it to Mega Evolve into Mega Aggron.", null, false, 4, 10000),
  GYARADOSITE("Held", 0, "Gyaradosite", "Gyaradosites", "One of the mysterious Mega Stones. Let Gyarados hold it to allow it to Mega Evolve into Mega Gyarados.", null, false, 4, 10000),
  ALTARIANITE("Held", 0, "Altarianite", "Altarianites", "One of the mysterious Mega Stones. Let Altaria hold it to allow it to Mega Evolve into Mega Altaria.", null, false, 4, 10000),
  GARCHOMPITE("Held", 0, "Garchompite", "Garchompites", "One of the mysterious Mega Stones. Let Garchomp hold it to allow it to Mega Evolve into Mega Garchomp.", null, false, 4, 10000),
  TYRANITARITE("Held", 0, "Tyranitarite", "Tyranitarites", "One of the mysterious Mega Stones. Let Tyranitar hold it to allow it to Mega Evolve into Mega Tyranitar.", null, false, 4, 10000),
  FLYGONITE("Held", 0, "Flygonite", "Flygonites", "One of the mysterious Mega Stones. Let Flygon hold it to allow it to Mega Evolve into Mega Flygon.", null, false, 4, 10000),
  METAGROSSITE("Held", 0, "Metagrossite", "Metagrossites", "One of the mysterious Mega Stones. Let Metagross hold it to allow it to Mega Evolve into Mega Metagross.", null, false, 4, 10000),
  GRISEOUSORB("Held", 0, "Griseous Orb", "Griseous Orbs", "A glowing orb to be held by Giratina. It boosts the power of Dragon- and Ghost-type moves when it is held.", null, false, 4, 10000),
  ADAMANTORB("Held", 0, "Adamant Orb", "Adamant Orbs", "A glowing orb to be held by Dialga. It boosts the power of Dragon- and Steel-type moves when it is held.", null, false, 4, 10000),
  LUSTROUSORB("Held", 0, "Lustrous Orb", "Lustrous Orbs", "A glowing orb to be held by Palkia. It boosts the power of Dragon- and Water-type moves when it is held.", null, false, 4, 10000),

  // items with in battle effect when held
  LEFTOVERS("Held", 0, "Leftovers", "Leftovers", "Passively heals a Pokémon's HP per turn.", null, true, 3, 5000),
  LIFEORB("Held", 0, "Life Orb", "Life Orbs", "Boosts damage but hurts the user every turn.", null, true, 3, 10000),
  FOCUSSASH("Held", 0, "Focus Sash", "Focus Sashes", "If a move will KO the holder at full health, leaves the holder at 1 HP instead of being knocked out.", null, true, 3, 5000),
  SITRUSBERRY("Held", 0, "Sitrus Berry", "Sitrus Berries", "Heals the Pokémon 1/4 of its HP if it falls below 1/2 HP.", null, true, 3, 500),
  CHOICESPECS("Held", 0, "Choice Specs", "Choice Specs", "Boosts Special Attack, but can only use one move.", null, true, 3, 6000),
  ASSAULTVEST("Held", 0, "Assault Vest", "Assault Vests", "Boosts Special Defense, but can only use attacking moves.", null, true, 3, 5000),
  FLAMEPLATE("Held", 0, "Flame Plate", "Flame Plates", "Boosts Fire-type attacks.", null, true, 3, 5000),
  MEADOWPLATE("Held", 0, "Meadow Plate", "Meadow Plates", "Boosts Grass-type attacks.", null, true, 3, 5000),
  SPLASHPLATE("Held", 0, "Splash Plate", "Splash Plates", "Boosts Water-type attacks.", null, true, 3, 5000),
  ZAPPLATE("Held", 0, "Zap Plate", "Zap Plates", "Boosts Electric-type attacks.", null, true, 3, 5000),
  SKYPLATE("Held", 0, "Sky Plate", "Sky Plates", "Boosts Flying-type attacks.", null, true, 3, 5000),
  DRACOPLATE("Held", 0, "Draco Plate", "Draco Plates", "Boosts Dragon-type attacks.", null, true, 3, 5000),
  SPOOKYPLATE("Held", 0, "Spooky Plate", "Spooky Plates", "Boosts Ghost-type attacks.", null, true, 3, 5000),
  EXPERTBELT("Held", 0, "Expert Belt", "Expert Belts", "Boosts the power of super-effective attacks.", null, true, 3, 2000),
  CHOICESCARF("Held", 0, "Choice Scarf", "Choice Scarves", "Boosts Speed, but can only use one move.", null, true, 3, 6000),
  CHOICEBAND("Held", 0, "Choice Band", "Choice Bands", "Boosts Attack, but can only use one move.", null, true, 3, 6000),
  MYSTICWATER("Held", 0, "Mystic Water", "Mystic Waters", "Boosts Water-type attacks.", null, true, 3, 5000),
  HEATROCK("Held", 0, "Heat Rock", "Heat Rocks", "Sun lasts longer when this Pokémon starts it.", null, true, 3, 5000),
  DAMPROCK("Held", 0, "Damp Rock", "Damp Rocks", "Rain lasts longer when this Pokémon starts it.", null, true, 3, 5000),
  SMOOTHROCK("Held", 0, "Smooth Rock", "Smooth Rocks", "Sandstorm lasts longer when this Pokémon starts it.", null, true, 3, 5000),
  ICYROCK("Held", 0, "Icy Rock", "Icy Rocks", "Hail lasts longer when this Pokémon starts it.", null, true, 3, 5000),
  HEAVYDUTYBOOTS("Held", 0, "Heavy Duty Boots", "Pairs of Heavy Duty Boots", "These boots prevent the effects of traps set on the battlefield.", null, true, 3, 5000),
  TERRAINEXTENDER("Held", 0, "Terrain Extender", "Terrain Extenders", "An item to be held by a Pokémon. It extends the duration of the terrain caused by the holder's move or Ability.", null, true, 3, 5000),

  //tms
  TMFIREBLAST("TM", 0, "TM01", "TM01s", "", Move.FIREBLAST, true, 7, 8000),
  TMTHUNDER("TM", 0, "TM02", "TM02s", "", Move.THUNDER, true, 7, 7000),
  TMICEBEAM("TM", 0, "TM03", "TM03s", "", Move.ICEBEAM, true, 7, 9000),
  TMBLIZZARD("TM", 0, "TM04", "TM04s", "", Move.BLIZZARD, true, 7, 7000),
  TMEARTHQUAKE("TM", 0, "TM05", "TM05s", "", Move.EARTHQUAKE, true, 7, 7000),
  TMKNOCKOFF("TM", 0, "TM06", "TM06s", "", Move.KNOCKOFF, true, 7, 7000),
  TMSURF("TM", 0, "TM07", "TM07s", "", Move.SURF, true, 7, 7000),
  TMTHUNDERWAVE("TM", 0, "TM08", "TM08s", "", Move.THUNDERWAVE, true, 7, 7000),
  TMFLASHCANNON("TM", 0, "TM09", "TM09s", "", Move.FLASHCANNON, true, 7, 7000),
  TMSHADOWBALL("TM", 0, "TM10", "TM10s", "", Move.SHADOWBALL, true, 7, 7000),
  TMHURRICANE("TM", 0, "TM11", "TM11s", "", Move.HURRICANE, true, 7, 9000),
  TMFLAMETHROWER("TM", 0, "TM12", "TM12s", "", Move.FLAMETHROWER, true, 7, 7000),
  TMHYPERBEAM("TM", 0, "TM13", "TM13s", "", Move.HYPERBEAM, true, 7, 7000),
  TMGIGAIMPACT("TM", 0, "TM14", "TM14s", "", Move.GIGAIMPACT, true, 7, 7000),
  TMDRAGONCLAW("TM", 0, "TM15", "TM15s", "", Move.DRAGONCLAW, true, 7, 7000),
  TMBRAVEBIRD("TM", 0, "TM16", "TM16s", "", Move.BRAVEBIRD, true, 7, 9000),
  TMCLOSECOMBAT("TM", 0, "TM17", "TM17s", "", Move.CLOSECOMBAT, true, 7, 7000),
  TMENERGYBALL("TM", 0, "TM18", "TM18s", "", Move.ENERGYBALL, true, 7, 7000),
  TMGIGADRAIN("TM", 0, "TM19", "TM19s", "", Move.GIGADRAIN, true, 7, 7000),
  TMHYDROPUMP("TM", 0, "TM20", "TM20s", "", Move.HYDROPUMP, true, 7, 7000),
  TMEARTHPOWER("TM", 0, "TM21", "TM21s", "", Move.EARTHPOWER, true, 7, 9000),
  TMDRACOMETEOR("TM", 0, "TM22", "TM22s", "", Move.DRACOMETEOR, true, 7, 11000),
  TMBUGBUZZ("TM", 0, "TM23", "TM23s", "", Move.BUGBUZZ, true, 7, 9000),
  TMDOUBLEEDGE("TM", 0, "TM24", "TM24s", "", Move.DOUBLEEDGE, true, 7, 9000),
  TMSLUDGEBOMB("TM", 0, "TM25", "TM25s", "", Move.SLUDGEBOMB, true, 7, 7000),
  TMSLUDGEWAVE("TM", 0, "TM26", "TM26s", "", Move.SLUDGEWAVE, true, 7, 8000),
  TMMOONBLAST("TM", 0, "TM27", "TM27s", "", Move.MOONBLAST, true, 7, 9000),
  TMSTONEEDGE("TM", 0, "TM28", "TM28s", "", Move.STONEEDGE, true, 7, 7000),
  TMROCKSLIDE("TM", 0, "TM29", "TM29s", "", Move.ROCKSLIDE, true, 7, 7000),
  TMICEPUNCH("TM", 0, "TM30", "TM30s", "", Move.ICEPUNCH, true, 7, 7000),
  TMFIREPUNCH("TM", 0, "TM31", "TM31s", "", Move.FIREPUNCH, true, 7, 7000),
  TMTHUNDERPUNCH("TM", 0, "TM32", "TM32s", "", Move.THUNDERPUNCH, true, 7, 7000),
  TMSTEALTHROCK("TM", 0, "TM33", "TM33s", "", Move.STEALTHROCK, true, 7, 7000),
  TMAURASPHERE("TM", 0, "TM34", "TM34s", "", Move.AURASPHERE, true, 7, 7000),
  TMFOCUSBLAST("TM", 0, "TM35", "TM35s", "", Move.FOCUSBLAST, true, 7, 9000),
  TMDRAGONPULSE("TM", 0, "TM36", "TM36s", "", Move.DRAGONPULSE, true, 7, 8000),
  TMICYWIND("TM", 0, "TM37", "TM37s", "", Move.ICYWIND, true, 7, 7000),
  TMDRAGONDANCE("TM", 0, "TM38", "TM38s", "", Move.DRAGONDANCE, true, 7, 7000),

  // evolution items
  MOONSTONE("Evolve", 0, "Moon Stone", "Moon Stones", "A peculiar stone that can make certain species of Pokémon evolve. It is as black as the night sky.", null, true, 5, 2000),
  THUNDERSTONE("Evolve", 0, "Thunder Stone", "Thunder Stones", "A peculiar stone that can make certain species of Pokémon evolve. It is sizzling with sparks.", null, true, 5, 2000),
  SHINYSTONE("Evolve", 0, "Shiny Stone", "Shiny Stones", "A peculiar stone that can make certain species of Pokémon evolve. It shines brightly even under faint light.", null, true, 5, 2000),
  FIRESTONE("Evolve", 0, "Fire Stone", "Fire Stones", "A peculiar stone that can make certain species of Pokémon evolve. It has a flame dancing in it.", null, true, 5, 2000),
  PROTECTOR("Evolve", 0, "Protector", "Protectors", "It's made of tough and hardy. Certain Pokémon love it.", null, true, 5, 2000),

  // megaring
  MEGARING("Key", 0, "Mega Ring", "Mega Rings", "Enables Mega Evolution.", null, true, 6, 10000);
  
  String EFFECT;
  String DESCRIPTION;
  int AMOUNT;
  String NAME;
  String PLURAL;
  Move MOVE_TAUGHT;
  boolean CANKNOCKOFF;
  int CATEGORY;
  int BASEPRICE;

/**
 *  Enum constructor defining an item.
 *
 *  @param effect The effect of the item
 *  @param amount How many you have
 *  @param name The name of the item
 *  @param plural The name pluralized of the item
 *  @param description The description of the item
 *  @param move The move that it causes
 *  @param canKnockOff If it can be knocked off in battle
 *  @param category The category/type
 *  @param baseprice The baseprice of the item
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Item(String effect, int amount, String name, String plural, String description, Move move, boolean canKnockOff, int category, int baseprice) {
    EFFECT = effect;
    AMOUNT = amount;
    NAME = name;
    DESCRIPTION = description;
    PLURAL = plural;
    MOVE_TAUGHT = move;
    CANKNOCKOFF = canKnockOff;
    CATEGORY = category;
    BASEPRICE = baseprice;
  }

  
/**
 *  gets name of item
 *  @return Name of the item
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    if (this.getCategory() == 7) {
      return NAME + " - " + this.getMoveTaught().getName();
    }
    return NAME;
  }

  
/**
 *  can the item be knocked off in battle?
 *  @return True/False based on if it be knocked off in battle
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean canKnockOff() {
    return CANKNOCKOFF;
  }

  
/**
 *  uses an item on a pokemon
 *  @param p The pokemon the item is being used on
 *  @return Returns true if it can be used
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean use(Pokemon p) {
    switch (EFFECT) {
      case "Heal20":
        if (p.isAtFullHealth() || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        p.heal(20);
        break;
      case "Heal50":
        if (p.isAtFullHealth() || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        p.heal(50);
        break;
      case "HealMax":
        if (p.isAtFullHealth() || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        p.heal(p.getMaxHP());
        break;
      case "Revive":
        if (!p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        System.out.println(p.getNickname() + " was revived!");
        p.heal((int)(p.getMaxHP() / 2.0));
        break;
      case "ReviveHealAll":
        if (!p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        System.out.println(p.getNickname() + " was revived!");
        p.heal(p.getMaxHP());
        break;
      case "Heal200":
        if (p.isAtFullHealth() || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        p.heal(200);
        break;
      case "HealAll":
        if (p.isAtFullHealth() || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        System.out.println(p.getNickname() + " was fully restored!");
        p.fullyHeal();
        break;
      case "CureAllStatusCondition":
        if (p.getStatus().equals("")  || p.isFainted()) {
          System.out.println("It won't have any effect.");
          return false;
        }
        System.out.println(p.getNickname() + " was healed of its status conditions!");
        p.setStatus("");
        break;
    }
    return true;
  }

  
/**
 *  gets item's base price
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getBasePrice() {
    return BASEPRICE;
  }

  
/**
 *  gets item's category - i.e. 1 - medicine, 2 - pokeball, 3 - held item, 4 - mega stone, 5 - evolution item, 7 - tm
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getCategory() {
    return CATEGORY;
  }

  
/**
 *  gets item's effect
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getEffect() {
    return EFFECT;
  }

  
/**
 *  if item is a tm, gets move taught
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Move getMoveTaught() {
    return MOVE_TAUGHT;
  }

  
/**
 *  gets item's description. if it is a tm, it uses the move's description as its description instead.
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getDescription() {
    if (this.getCategory() == 7) {
      return MOVE_TAUGHT.toString();
    } return DESCRIPTION;
  }

  
/**
 *  lists all items
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static String listItems() {
    //System.out.println("\nItems:");
    String str = "";
    String potions = "Potions:\n"; //1
    String pokeballs = "Pokeballs:\n"; //2
    String megastone = "Megastones:\n"; //4
    String battle = "Battle items:\n"; //3
    String tms = "TMS:\n"; //7
    String evo = "Evolution Items:\n"; //5
    String megaring = "Megarings:\n"; //6
    for (Item i : Item.values()) {
      if (i.getCategory() == 1) {
        potions = potions + i.getName() + ", ";
      }
      else if (i.getCategory() == 2) {
        pokeballs = pokeballs + i.getName() + ", ";
      }
      else if (i.getCategory() == 3) {
        battle = battle + i.getName() + ", ";
      }
      else if (i.getCategory() == 4) {
        megastone = megastone + i.getName() + ", ";
      }
      else if (i.getCategory() == 5) {
        evo = evo + i.getName() + ", ";
      }
      else if (i.getCategory() == 6) {
        megaring = megaring + i.getName() + ", ";
      }
      else if (i.getCategory() == 7) {
        tms = tms + i.getName() + ", ";
      }
      //System.out.println(i.getName());
    //return str;
    }
  return potions + "\n\n" + pokeballs + "\n\n" + battle + "\n\n" + megastone + "\n\n" + evo + "\n\n" + tms + "\n\n" + megaring;
  }

  
/**
 *  what happens on giving an item to a pokemon - some pokemon change their forms immediately, like giratina when given a griseous orb
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void onGive(Pokemon receiver) {
    if (this == GRISEOUSORB && receiver.getSpecies() == Species.GIRATINA) {
      receiver.changeForm(Forms.GIRATINAORIGIN);
    }
  }

  
}