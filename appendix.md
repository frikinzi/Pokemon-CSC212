## Class/Enum Appendix
**Contains information about the attirbutes, methods, and constructors of each class/enum**

## class Main
**Attributes**
Pokemon read_poke;

**Methods**
main(String[] args)
readGymLeaderFile(String filename)
readPlayerFile(String filename)
readSaveFile(String filename)
createFile(String filename)



## class Battle
**Attributes**
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

**Constructors**
Battle(Player player1, Trainer npc)
Battle(Player player1, Pokemon p)

**Methods**
incrementTurn()
shouldEndBattle()
executeWildBattle()
parseYN(String s)
checkFainted()
switchPokemon(Scanner scanner, boolean switch_from_faint)
determineOrder(Pokemon player_poke, Pokemon opposing_poke, Move player_move, Move opponent_move)
parseInput(String s)
printDamageMessage(Pokemon attacker, Pokemon defender, int damage, Move move)
battleInfo()
executeEndOfTurn(Scanner scanner)
endOfBattle()
endWeather()
setWeather(Weather w)
setWeatherTurns(int i)
setTerrain(Weather w)
setTerrainTurns(int i)
getWeather()
getTerrain()
parseItem(String item, Scanner scanner)
getPlayerEntryHazards()
getOpponentEntryHazards()
getOpposingEntryHazard(Trainer t)
getOwnHazards(Trainer t)
multiHitAttack(Pokemon p, Pokemon defender, Move m)
getWinner()



## class Item
**Attributes**
String EFFECT
String DESCRIPTION
int AMOUNT
String NAME
String PLURAL
Move MOVE_TAUGHT
boolean CANKNOCKOFF
int CATEGORY
int BASEPRICE

**Constructor**
Item(String effect, int amount, String name, String plural, String description, Move move, boolean canKnockOff, int category, int baseprice)

**Methods**
getName()
canKnockOff()
use(Pokemon p)
getBasePrice()
getCategory()
getEffect()
getMoveTaught()
getDescription()
listItems()
onGive(Pokemon receiver)



## enum Weather
**Attributes**
String NAME
String MESSAGE
String START
String END
Type BOOSTED

**Constructor**
Weather(String name, String message, String start_message, String end_message, Type boosted)

**Methods**
getStartMessage()
getTurnEndMessage()
getEndMessage()
getTypeBoosted()
getName()



## class Background
**Attributes**
String file = null

**Constructor**
Background(String file)

**Methods**
setFile(String file)
draw(Graphics g)



## class BattleGraphics
**Attributes**
Background bg
Background weather
Icon pokemon1
Icon pokemon2

**Constructor**
BattleGraphics(Pokemon poke, Pokemon oppose, Weather current_weather, Location location)

**Methods**
getPreferredSize()
paintComponent(Graphics g)



## class Icon
**Attributes**
int x
int y
String file
int height
int width

**Constructors**
Icon(String file)
Icon(String file, int x, int y)

**Methods**
setFile(String file)
move(int x1, int y1)
getX()
getY()
setY(int y1)
setX(int x1)
draw(Graphics g)
setHeight(int height)
getHeight()
getWidth()
setWidth(int width)



## class Map
**Attributes**
Background bg
Icon character

**Constructor**
Map(int x, int y)

**Methods**
getPreferredSize()
paintComponent(Graphics g)
animate(int x, int y)
animateMap(Location loc, Location new_loc)



## class GymLeader
**Attributes**
ArrayList<Pokemon[]> teams
Item reward
String losetext
String badge

**Constructor**
GymLeader(String name, int money, ArrayList<Pokemon[]> teams, Item reward, String losetext)

**Methods**
ArrayList<Pokemon[]> getTeams()
setBadge(String s)
getBadge()
getZeroBadgeTeam()
getOneBadgeTeam()
getTwoBadgeTeam()
getThreeBadgeTeam()
setLoseText(String s)
getLoseText()
getReward()
setReward(Item i)
setRightTeam(Player p)



## class NPC
**Attributes**
private String name
private String dialogue
private String dialogue_switch
private boolean gave_item
private Trainer trainer

**Constructor**
NPC(String name, String dialogue1, String dialogue2, boolean gave_item, Trainer t)

**Methods**
getGiveItem()
getTrainer()
getDialogue()
getDialogueTwo()
isTrainer()



## class Player
**Attributes**
private String name;
private int money;
private Location location;
private ArrayList<Pokemon> storage;
private Location last_visited_pkm_center;
private ImmutableValueGraph<Location, Integer> world;
private ShowPicture background; 
private ArrayList<String> tags;
private JFrame map
private Map map_canvas

**Constructors**
Player(Pokemon[] party, String name, int money, Location l)
Player(String name, int money, Location l)

**Methods**
getStorage()
setWorld(ImmutableValueGraph<Location, Integer> world)
setMap(JFrame map)
setMapCanvas(Map map_canvas)
setName(String name)
getName()
getHighestLevelInParty()
setBackground(ShowPicture pic)
getBackground()
addMoney(int i)
setMoney(int i)
subtractMoney(int i)
getMoney()
addPartyMember(Pokemon p)
setLocation(Location l)
getLocation()
menu()
travel()
blackout()
addTag(String s)
removeTag(String s)
hasTag(String s)
getTags()



## class Trainer
**Attributes**
Pokemon[] party
Pokemon active
String name
ArrayList<Item> items
int base_money

**Constructors**
Trainer(String name, int money)
Trainer(Pokemon[] party, String name, int money)

**Methods**
getInventory()
getParty()
partyIsEmpty()
numberPartyMembers()
getBaseMoney()
setBaseMoney(int i)
getPartyPokemon(int i)
setParty(Pokemon[] party)
addPartyMember(Pokemon p)
isPartyFull()
getPokemonIndex(Pokemon p)
rebalanceTeam(Player p)
addToInventory(Item i)
addToInventory(Item item, int quantity)
removeFromInventory(Item i)
duplicatesInventory()
hasItem(Item i)
getActivePokemon()
setActivePokemon(Pokemon p)
setActivePokemon(int i)
hasStandingPokemon()
switchPokemon(Pokemon p, Pokemon opp, Battle field)
shouldSwitch(Pokemon opponent, Battle field)
getName()
determineAction(Pokemon opponent, Move best_move, Battle field)
determineActionSwitched(Pokemon opponent, Pokemon in, Battle field)
getBestMove(Pokemon friendly, Pokemon opponent, Battle field)
whoToSwitchInFromUTurn(Pokemon thispoke, Pokemon opponent, Battle field)
whoToSwitchIn(Pokemon opponent, Battle field)
calculatePokemonScore(Pokemon friendly, Pokemon opponent, Battle field)
healParty()
toString()
resetAllPokemon()
printPokeballs()



## enum Species
**Attributes**
int DEX_NUMBER;
String NAME;
Type TYPE1;
Type TYPE2;
int[] BASE_STATS;
int BASE_EXP;
int[] EFFORT_POINTS;
int HAPPINESS;
Ability[] ABILITIES;
Ability[] HIDDEN_ABILITY;
HashMap<Integer, Move> MOVESET;
HashSet<Move> MOVEPOOL;
double HEIGHT;
double WEIGHT;
String KIND;
String POKEDEX_ENTRY;
Species EVOLUTION;
Object[] EVOLUTION_METHOD;
int HP;
int ATTACK;
int DEFENSE;
int SPA;
int SPD;
int SPEED;
int CATCHRATE;
Forms[] FORMS;

**Constructor**
Species(int dex_number, String name, Type type1, Type type2, int[] base_stats, int base_exp, int[] effort_points, int happiness, Ability[] abilities, Ability[] hidden_ability, Object[] moveset, HashSet<Move> movepool, double height, double weight, String kind, String pokedex_entry, Species evolution, Object[] evolution_method, int catch_rate, Forms[] forms)

**Methods**
toString()
getAbilities()
getRandomAbility()
getAbility(int i)
getHP()
getAttack()
getDefense()
getSpecialAttack()
getSpecialDefense()
getSpeed()
getName()
getTypeOne()
getTypeTwo()
setTypeOne(Type type)
setTypeTwo(Type type)
getMovePool()
getMoveLearned(Integer i)
getLearnSet()
getTypeEffectiveness(Type type)
printLevelUpMoveset()
getForms()
getBaseStats()
getBaseExp()
getCatchRate()
getIndexAbility(Ability a)
hasEvolution()
getEvolution()
getEvolutionMethod()
getRandomSpecies()
getEVYield()
getDexNumber()
getBattleBack()
getBattleFront()



## enum Type
**Attributes**
String[] SUPER_EFFECTIVE;
String[] NOT_VERY_EFFECTIVE;
String[] NO_EFFECT;
String NAME;

**Constructor**
Type(String[] super_effective, String[] not_very_effective, String[] no_effect, String name)

**Methods**
contains(String[] s, String type)
isSuperEffectiveOn(String s)
isNotVeryEffectiveOn(String s)
hasNoEffect(String s)
getName()



## enum Ability
**Attributes**
String DESCRIPTION
String NAME

**Constructors**
Ability(String description, String name)

**Methods**
getDescription()
getName()



## class Forms
**Attributes**
int FORM_NUMBER
Species BASE
String NAME
Type TYPES
Type TYPE2
int[] BASESTATS
Ability[] ABILITIES
Ability[] HIDDEN_ABILITY
String POKEDEX_ENTRY
Item MEGA_STONE

**Constructors**
Forms(Species base, int form_number, String name, Type type1, Type type2, int[] base_stats, Ability[] abilities, Ability[] hidden_ability, String pokedex_entry, Item mega_stone)

**Methods**
getStats()
getMegaStone()
getName()
getTypeOne()
getTypeTwo()
getBaseForm()
getRandomAbility()
getFormNumber()



## class Move
**Attributes**
int BASE_POWER
double ACCURACY
MoveType TYPE
Type ELEMENT
int PP
String SPECIAL_EFFECT
int PRIORITY
String NAME
String DESCRIPTION
double CHANCE_SIDE_EFFECT
boolean CONTACT
boolean CAN_PROTECT
int BATTLE_PP
String[] FLAGS
Type ORIGINAL_TYPE

**Constructor**
Move(int base_power, double accuracy, Type element, MoveType type, int pp, String special_effect, int priority, double chance_side_effect, String name, String description, String[] flags)

**Methods**
contains(String[] s, String flag)
getBasePower()
setBasePower(int i)
getSpecialEffect()
getCurrentPP()
decrementPP()
restorePP()
applyEffectSelf(Pokemon self)
applySpecialEffect(Pokemon self, Pokemon opponent, Battle field)
getType()
getMoveType()
getPP()
getAccuracy()
getName()
getPriority()
toString(Pokemon p)
toString()
getDescription()
isContactMove()
isPulseMove()
isSoundMove()
hasTag(String s)
hasSideEffect()
setType(Type t)
getOriginalType()



## enum MoveType
No attributes, methods, or constructors (only enum)


## class Nature
**Attributes**
int STAT_INCREASED
int STAT_DECREASED

**Constructor**
Nature(int stat_increased, int stat_decreased)

**Methods**
applyNatureStatBoost(int[] stats)
getStatBoosted()
getStatDecreased()



## class Pokemon
**Attributes**
boolean fainted
Species species
int level
int exp
int[] iv
int current_hp
int max_hp
int[] ev
Move[] moves
String status
int[] stats
String nickname
Trainer owner
int[] stat_boosts
int toxic_turns
Nature nature
int crit_stage
Move choice_locked
Item held_item
int sleep_counter
int confusion_turns
Ability ability
int resting_turns
boolean destiny_bond
int[] pp
boolean isSeeded
Type typeone
Type typetwo
Forms form
int[] base_stats
Move charging_move
boolean is_shiny
boolean flinch

**Constructor**
Pokemon(Species species, int level, Trainer owner)

**Methods**
getLevel()
setLevel(int i)
getExp()
getNickname()
setNickname(String s)
getAbility()
setAbility(Ability a)
hasAbility(Ability a)
setAbility(int a)
isResting()
setResting(int resting)
decrementResting()
isDestinyBond()
setDestinyBond(boolean b)
getChoiceLockedMove()
isChoiceLocked()
setChoiceLockedMove(Move move)
removeHeldItem()
giveHeldItem(Item item)
setHeldItem(Item item)
getHeldItem()
setChargingMove(Move m)
hasChargingMove()
getChargingMove()
getIVByIndex(int i)
getEVByIndex(int i)
calculateHP()
calculateAttack()
calculateDefense()
calculateSpecialAttack()
calculateSpecialDefense()
calculateSpeed()
getMultiplierByStage(double i)
getInBattleDefense()
getInBattleAttack()
getInBattleSpecialAttack()
getInBattleSpecialDefense(Battle field)
getInBattleSpeed(Battle field)
getStats()
getNature()
setNature(Nature n)
hasEmptyMoveSlot()
getMoves()
hasFourMoves()
nextOpenMoveSlot()
getMove(int i)
setMoves(Move[] m)
hasMove(Move m)
getMovePP(int i)
setMove(int i, Move m)
setIVs(int[] i)
setEVs(int[] i)
trainEVStat(int[] ev_Trained)
isFullyEVTrained()
sumEVs()
restoreAllPP()
hasRunOutOfPP()
decrementPP(Move m)
getMoveIndex(Move m)
decrementPP(int i)
restorePP(int i)
hasMove(int i)
hasType(Type t)
initializeMoves()
levelUp()
ainExperience(int i)
simpleGainExp(int i)
getCurrentHP()
setCurrentHP(int i)
getMaxHP()
isAtFullHealth()
isMegaEvolved()
takeDamage(int damage)
getModifiers(Move move)
getCriticalHitStage()
isCriticalHit(Move move)
getSpecies()
getTypeOne()
getTypeTwo()
getTypeEffectiveness(Type type)
calcDamage(int base_power, int defense, int attack)
attack(Move move, Pokemon target, Battle field)
calculateDamage(Move move, Pokemon target,Battle field)
criticalHitChance(int stage, Move move)
isAirborne()
getStatus()
setStatus(String s)
hasStatus()
burn()
isConfused()
confuse()
setConfuseTurns(int i)
freeze()
sleep()
paralyze()
poison()
badlyPoison()
healStatus()
isBurned()
isFrozen()
isPoisoned()
isBadlyPoisoned()
isParalyzed()
isAsleep()
takePoisonDamage()
takeSandStormDamage()
takeBurnDamage()
takeToxicDamage()
getToxicDamage()
resetToxic()
cureToxic()
isFainted()
raiseAttackByStage(int i)
getStatBoostByIndex(int i)
getAttackBoost()
raiseDefenseByStage(int i)
getDefenseBoost()
raiseSpecialAttackByStage(int i)
getSpecialAttackBoost()
raiseSpecialDefenseByStage(int i)
getSpecialDefenseBoost()
raiseSpeedByStage(int i)
getSpeedBoost()
resetStatBoosts()
resetStatBoostsInBattle()
toString()
executeMoveSuccessfully(Move move, Pokemon opponent, Battle field)
heal(int i)
healSilent(int i)
fullyHeal()
getOwner()
canMegaEvolve()
getMegaForm()
megaEvolve()
changeForm(Forms f)
revertToBaseForm()
setWeather(Battle field, Weather w)
setTerrain(Battle field, Weather w)
onEnterBattle(Battle field, Pokemon opponent)
getExpGain(Pokemon defeated)
getCatchChance(Item i)
catchPoke(Item item)
getRandomMove()
setOwner(Trainer t)
takeStealthRockDamage()
getCaughtInStickyWeb()
takeSpikesDamage(Battle field)
getPoisonedByToxicSpikes(Battle field)
canEvolve()
evolve()
getBattleBack()
getBattleFront()
getIcon()
setShiny(boolean b)
isShiny()
setFlinch(boolean b)



## class Util
**Methods**
randomNature(Class<Nature> nature)
printDamageMessage(Pokemon attacker, Pokemon defender, int damage, Move move)
printFaintedMessage(Pokemon fainter)
printSwitchOptions(Trainer trainer)
printAllPokemon(Trainer t)
printAllPokemonTM(Trainer t, Move m)
printPokemonEvolution(Item item, Trainer t)
checkEvolutionStoneCompatibility(Item item, Pokemon p)
printStoragePokemon(Player t)
printSwitchingOut(Pokemon out, Pokemon in)
printMissedMove(Pokemon attacker, Move move)
isAsleep(Pokemon attacker)
getParalyzed(Pokemon attacker)
getFrozen(Pokemon attacker)
takePoisonDamage(Pokemon attacker)
takeBurnDamage(Pokemon p)
parseInput(String s)
parseInt(String s)
clearScreen()
interpretItem(String input)
checkMoveCompatibility(Move m, Species p)
teachMove(Scanner scanner, Move m, Pokemon p)
useItemOnPoke(Scanner scanner, Player p, Pokemon poke)
battleBag(Scanner scanner, Player p)
bag(Scanner scanner, Player p)
shop(Scanner s, Player p)
buyItems(String input, Scanner s, Player p)



## class Location
**Attributes**
NPC[] npcs
ArrayList<Trainer> trainer
String name
Interactable[] interactable
GymLeader gym_leader
int x
int y

**Constructor**
Location(NPC[] npcs, ArrayList<Trainer> trainer, String name, Interactable[] interactable, GymLeader gym_leader, int x, int y)

**Methods**
getX()
getY()
getNPCs()
getName()
getTrainers()
getGymLeader()



## class PokemonCenter
**Constructor**
PokemonCenter(NPC[] npcs, Trainer trainer, String name, Interactable[] interactable)

**Methods**
nurseInteraction(Player p)



## class ShowPicture
**Attributes**
JFrame background

**Constructor**
ShowPicture(JFrame background)

**Methods**
getFrame()
setFrame(JFrame frame)
undisplay()
displayBattle(Pokemon player, Pokemon opposing, Weather weather, Location location)
refreshJFrame(Pokemon player, Pokemon opposing, Weather weather, Location location, JFrame j)
displayPokemon(Pokemon p, JFrame j)
displayParty(Pokemon[] p, JFrame j)
showImage(JFrame j, String s)
displayPokemon(Pokemon[] p, JFrame j)
displaySummary(Pokemon pokemon, JFrame j)
jText(String text)
displaySpecies(Pokemon pokemon, JFrame j)
displayText(String str, JFrame j, String j_name)



## class Interactable
**Attributes**
Species [] black_listed_wild
List blastlist

**Methods**
town(Player player)
flashbreeze_swamp(Player player)
blazesting_factory(Player player)
copperlock_peak(Player player)
needlejaw_summit(Player player)
ironsweep_ruins(Player player)
mistfrond_grassland(Player player)
starglass_kelpbed(Player player)
rustcry_isle(Player player)
sweetfloat_waterfront(Player player)
shortbrush_hollow(Player player)
blizzard_island(Player player)
shatterflash_dunes(Player player)
sunspore_grove(Player player)
nurseInteraction(Player p)
choice(Player player)
parseLoc(Player player, Location loc)