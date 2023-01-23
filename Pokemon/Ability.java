/**
 *  Enum defining abilities in the game. Each ability has a unique effect in battle. For example, Chlorophyll allows the pokemon to move faster under the sun
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Ability {

  OVERGROW("Grass-type attacks get stronger if this Pokémon is at 1/4 health.", "Overgrow"),
  BLAZE("Fire-type attacks get stronger if this Pokémon is at 1/4 health.", "Blaze"),
  TORRENT("Water-type attacks get stronger if this Pokémon is at 1/4 health.", "Torrent"),
  CHLOROPHYLL("This Pokémon's speed is doubled under harsh sunlight.", "Chlorophyll"),
  SWIFTSWIM("This Pokémon's speed is doubled under rain.", "Swift Swim"),
  SANDRUSH("This Pokémon's speed is doubled under sand.", "Sand Rush"),
  DROUGHT("This Pokémon will set up harsh sunlight upon switch in.", "Drought"),
  SANDSTREAM("This Pokémon will set up a sandstorm upon switch in.", "Sand Stream"),
  DRIZZLE("This Pokémon will set up rain upon switch in.", "Drizzle"),
  SERENEGRACE("Moves with side effects have double the chance of the side effect occuring.", "Serene Grace"),
  CLEARBODY("This Pokémon's stats cannot be lowered.", "Clear Body"),
  BULLETPROOF("This Pokémon is immune to ballistic moves.", "Bulletproof"),
  SOUNDPROOF("This Pokémon is immune to sound moves.", "Sound Proof"),
  WATERABSORB("This Pokémon absorbs Water attacks to heal itself.", "Water Absorb"),
  DRYSKIN("This Pokémon absorbs Water attacks to heal itself, but takes more damage from Fire moves", "Dry Skin"),
  SHELLARMOR("Prevents critical hits.", "Shell Armor"),
  ELECTRICSURGE("This Pokémon will set up Electric Terrain upon switch in.", "Electric Surge"),
  PSYCHICSURGE("This Pokémon will set up Psychic Terrain upon switch in.", "Psychic Surge"),
  MISTYSURGE("This Pokémon will set up Misty Terrain upon switch in.", "Misty Surge"),
  GRASSYSURGE("This Pokémon will set up Grassy Terrain upon switch in.", "Grassy Surge"),
  THICKFAT("This Pokémon will take less damage from Ice and Fire-type moves.", "Thick Fat"),
  GUTS("This Pokémon do more damage when statused.", "Guts"),
  RATTLED("This Pokémon's speed will increase when hit by a Dark, Bug or Ghost move.", "Rattled"),
  MEGALAUNCHER("Boosts the power of aura and pulse moves.", "Mega Launcher"),
  AMPLIFIER("Boosts the power of sound moves.", "Amplifier"),
  TECHNICIAN("Boosts the power of weak moves.", "Technician"),
  POISONHEAL("Heals when poisoned.", "Poison Heal"),
  INTIMIDATE("Lowers opponent's attack upon switch in.", "Intimidate"),
  MOXIE("Knocking an opponent out raises this Pokémon's Attack stat.", "Moxie"),
  SHADOWTAG("The other Pokémon is prevented from switching out.", "Shadow Tag"),
  MOLDBREAKER("The opposing Pokémon's ability is ignored.", "Moldbreaker"),
  ARENATRAP("The other Pokémon is prevented from switching out.", "Arena Trap"),
  RAINDISH("This Pokémon heals in the rain.", "Rain Dish"),
  SOLARPOWER("This Pokémon's attacks are strong in the sunlight, but it takes damage every turn.", "Solar Power"),
  PRESSURE("The opposing Pokémon loses PP quicker.", "Pressure"),
  SNOWCLOAK("This Pokémon has increased evasion under Hail.", "Snow Cloak"),
  STATIC("Contact moves that hit this Pokémon may paralyze the opponent.", "Static"),
  FLAMEBODY("Contact moves that hit this Pokémon may burn the opponent.", "Flame Body"),
  HUGEPOWER("This Pokémon's physical attack is doubled.", "Huge Power"),
  LEVITATE("This Pokémon is immune to ground moves.", "Levitate"),
  KEENEYE("This Pokémon's accuracy can't be lowered.", "Keen Eye"),
  ANALYTIC("This Pokémon's power increases if it moves last.", "Analytic"),
  MAGNETPULL("This Pokémon traps any Steel-types present.", "Magnet Pull"),
  BIGPECKS("This Pokémon's defense can't be lowered.", "Big Pecks"),
  TANGLEDFEET("This Pokémon's evasion is doubled when confused.", "Tangled Feet"),
  NOGUARD("This Pokémon's moves never miss, but the opponent's moves never miss either.", "No Guard"),
  TOUGHCLAWS("Contact moves will be stronger.", "Tough Claws"),
  RECKLESS("Recoil moves will be stronger.", "Reckless"),
  FILTER("Super-effective moves will deal less damage.", "Filter"),
  SOLIDROCK("Super-effective moves will deal less damage.", "Solid Rock"),
  MULTISCALE("When at full health, this Pokémon takes half the damage from any move.", "Multiscale"),
  COMPOUNDEYES("Increases accuracy of moves by x1.3", "Compound Eyes"),
  LIGHTNINGROD("Makes this Pokémon immune to Electric-type attacks and boosts SpA when hit.", "Lightning Rod"),
  NATURALCURE("When switched out, this Pokémon's status conditions are healed.", "Natural Cure"),
  ROUGHSKIN("Contact moves to this Pokémon hurt the attacker.", "Rough Skin"),
  REGENERATOR("When switched out, this Pokémon heals 1/3 of its health.", "Regenerator"),
  SANDFORCE("Moves are more powerful in sand.", "Sand Force"),
  POISONPOINT("Contact moves have a chance to poison.", "Poison Point"),
  SHEERFORCE("Removes any additional effects from the Pokémon's moves, but increases the moves' power.", "Sheer Force"),
  STURDY("This Pokémon cannot be OHKO'ed.", "Sturdy"),
  CONTRARY("This Pokémon's stat changes are reversed.", "Contrary"),
  FLASHFIRE("This Pokémon is immune to Fire-type moves, and when hit by a Fire move, its own Fire moves get stronger.", "Flash Fire"),
  PIXILATE("This Pokémon's normal moves become Fairy-type moves and are powered up.", "Pixilate"),
  ICESCALES("Special moves do half the damage to this Pokémon.", "Ice Scales"),
  ORICHALCUMPULSE("Turns the sunlight harsh when the Pokémon enters a battle. The ancient pulse thrumming through the Pokémon also boosts its Attack stat in harsh sunlight.", "Orichacum Pulse"),
  HADRONENGINE("Turns the ground into Electric Terrain when the Pokémon enters a battle. The futuristic engine within the Pokémon also boosts its Sp. Atk stat on Electric Terrain.", "Hadron Engine"),
  ROCKHEAD("Prevents this Pokémon from taking recoil damage.", "Rock Head"),
  AERILATE("This Pokémon's normal moves become Flying-type moves and are powered up.", "Aerilate");
  
  private String DESCRIPTION;
  private String NAME;

  
/**
 *  constructor defining ability
 *
 *  @param description Description of ability
 *  @param name Name of ability
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Ability(String description, String name) {
    DESCRIPTION = description;
    NAME = name;
  }

  
/**
 *  Gets description of the ability
 *
 *  @return Description of ability
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getDescription() {
    return DESCRIPTION;
  }

  
/**
 *  Gets name of the ability
 *
 *  @return Name of ability
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return NAME;
  }

  
}