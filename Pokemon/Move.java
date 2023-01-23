import java.util.*;

/**
 *  Enum class defining the many moves in the game. moves are split into three categories: physical, special, or status. each move has a type, base power, and special effect, if applicable.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Move {
  
  RAZORLEAF(55, 0.95, Type.GRASS, MoveType.PHYSICAL, 20, "IncreasedCritRate", 0, 0.3, "Razor Leaf", "Sharp-edged leaves are launched to slash at opposing Pokémon. Critical hits land more easily.", new String[] {"CanProtect"}),
  METALCLAW(50, 0.95, Type.STEEL, MoveType.PHYSICAL, 20, "RaiseAtk", 0, 0.1, "Metal Claw", "The target is raked with steel claws. This may also boost the user's Attack stat.", new String[] {"CanProtect","MakesContact"}),
  GUST(40, 1.0, Type.FLYING, MoveType.SPECIAL, 56, "", 0, 0.3, "Gust", "A gust of wind is whipped up by wings and launched at the target to inflict damage.", new String[] {"CanProtect"}),
  SLASH(70, 1.0, Type.NORMAL, MoveType.PHYSICAL, 20, "IncreasedCritRate", 0, 0.3, "Slash", "The target is attacked with a slash of claws or blades. Critical hits land more easily.", new String[] {"MakesContact","CanProtect"}),
  LEAFBLADE(90, 1.0, Type.GRASS, MoveType.PHYSICAL, 24, "IncreasedCritRate", 0, 1.0, "Leaf Blade", "The user handles a sharp leaf like a sword and cuts the target to inflict damage. This move has a heightened chance of landing a critical hit.", new String[] {"MakesContact","CanProtect"}),
  FLAMEWHEEL(60, 1.0, Type.FIRE, MoveType.PHYSICAL, 24, "Burn", 0, 0.1, "Flame Wheel", "The user charges at the opponent in a rolling fashion while on fire. This may burn the target.", new String[] {"MakesContact","CanProtect"}),
  BUBBLEBEAM(65, 1.0, Type.WATER, MoveType.SPECIAL, 24, "LowerOpSpeed", 0, 0.1, "Bubble Beam", "A spray of bubbles is forcefully ejected at the target. This may also lower the target's Speed stat.", new String[] {"MakesContact","CanProtect"}),
  SPIRITSHACKLE(80, 1.0, Type.GHOST, MoveType.PHYSICAL, 24, "Trap", 0, 0.3, "Spirit Shackle", "The user attacks while simultaneously stitching the target's shadow to the ground to prevent the target from escaping.", new String[] {"CanProtect"}),
  DARKESTLARIAT(85, 1.0, Type.DARK, MoveType.PHYSICAL, 24, "IgnoreDefense", 0, 0.3, "Darkest Lariat", "The user swings both arms and hits the target. The target's stat changes don't affect the damage inflicted by this move.", new String[] {"CanProtect", "MakesContact"}),
  STONEEDGE(100, 0.8, Type.ROCK, MoveType.PHYSICAL, 20, "IncreasedCritRate", 0, 0.3, "Stone Edge", "The user stabs the target from below with sharpened stones. Critical hits land more easily.", new String[] {"CanProtect"}),
  ROCKSLIDE(75, 0.90, Type.ROCK, MoveType.PHYSICAL, 20, "Flinch", 0, 0.3, "Rock Slide", "Large boulders are hurled at opposing Pokémon to inflict damage. This may also make the opposing Pokémon flinch.", new String[] {"CanProtect"}),
  ROCKTOMB(60, 0.95, Type.ROCK, MoveType.PHYSICAL, 20, "LowerOpSpeed", 0, 1.0, "Rock Tomb", "The user hurls boulders at the target to inflict damage. This also lowers the target's Speed stat by cutting off its movement.", new String[] {"CanProtect"}),
  WATERGUN(40, 1.0, Type.WATER, MoveType.SPECIAL, 40, "", 0, 0, "Water Gun", "A burst of water is shot at the opponent.", new String[] {"CanProtect"}),
  LEAFAGE(40, 1.0, Type.GRASS, MoveType.PHYSICAL, 40, "", 0, 0, "Leafage", "The opponent is pelted with sharp leaves.", new String[] {"CanProtect"}),
  PECK(35, 1.0, Type.FLYING, MoveType.PHYSICAL, 40, "", 0, 0, "Peck", "The user pecks the opponent, dealing damage.", new String[] {"MakesContact","CanProtect"}),
  STRUGGLEBUG(50, 1.0, Type.BUG, MoveType.SPECIAL, 20, "LowerOpSpA", 0, 1.0, "Struggle Bug", "While resisting, the user attacks opposing Pokémon. This lowers the Sp. Atk stats of those hit.", new String[] {"CanProtect"}),
  POWDERSNOW(40, 1.0, Type.ICE, MoveType.SPECIAL, 40, "Freeze", 0, 0.1, "Powder Snow", "The user attacks with a chilling gust of powdery snow. This may also freeze opposing Pokémon.", new String[] {"CanProtect"}),
  THUNDERSHOCK(40, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 40, "Paralyze", 0, 0.1, "Thunder Shock", "The user attacks with a jolt of electricity. This may also paralyze opposing Pokémon.", new String[] {"CanProtect"}),
  DRAGONBREATH(60, 1.0, Type.DRAGON, MoveType.SPECIAL, 40, "Paralyze", 0, 0.3, "Dragon Breath", "The user exhales a mighty gust that inflicts damage. This may also leave the target with paralysis.", new String[] {"CanProtect"}),
  CONFUSION(40, 1.0, Type.PSYCHIC, MoveType.SPECIAL, 40, "Confuse", 0, 0.1, "Confusion", "Psychic energy is launched at the target. This may confuse the target.", new String[] {"CanProtect"}),
  FLASHCANNON(80, 1.0, Type.STEEL, MoveType.SPECIAL, 10, "LowerOpSpD", 0, 0.1, "Flash Cannon", "Concentrated metal luster is launched at the opponent.", new String[] {"CanProtect"}),
  EMBER(40, 1.0, Type.FIRE, MoveType.SPECIAL, 35, "Burn", 0, 0.1, "Ember", "The target is attacked with small flames. This may also leave the target with a burn.", new String[] {"CanProtect"}),
  HYDROPUMP(120, 0.80, Type.WATER, MoveType.SPECIAL, 8, "", 0, 0, "Hydro Pump", "The target is blasted by a huge volume of water launched under great pressure.", new String[] {"CanProtect"}),
  FLAMETHROWER(90, 1.0, Type.FIRE, MoveType.SPECIAL, 20, "Burn", 0, 0.1, "Flamethrower", "The target is scorched with an intense blast of fire. This may also leave the target with a burn.", new String[] {"CanProtect"}),
  HEATWAVE(95, 0.9, Type.FIRE, MoveType.SPECIAL, 20, "Burn", 0, 0.1, "Heat Wave", "The user attacks by exhaling hot breath on opposing Pokémon. This may also leave those Pokémon with a burn.", new String[] {"CanProtect"}),
  SOLARBEAM(120, 1.0, Type.GRASS, MoveType.SPECIAL, 20, "TwoTurn", 0, 0, "Solar Beam", "The user charges one turn, and then on the next turn, fires off a intense beam of light.", new String[] {"CanProtect"}),
  SKYATTACK(140, 1.0, Type.FLYING, MoveType.PHYSICAL, 20, "TwoTurn", 0, 0, "Sky Attack", "The user cloaks itself in light, and then on the next turn, attacks the opponent viciously.", new String[] {"CanProtect","MakesContact"}),
  SHADOWFORCE(120, 1.0, Type.GHOST, MoveType.PHYSICAL, 8, "TwoTurnInvulnerable", 0, 0, "Shadow Force", "The user disappears into the shadows for a turn, and then reemerges to strike at the opponent.", new String[] {"MakesContact","CanProtect"}),
  EARTHQUAKE(100, 1.0, Type.GROUND, MoveType.PHYSICAL, 10, "", 0, 0, "Earthquake", "The user causes a powerful earthquake that damages everything around it.", new String[] {"CanProtect"}),
  BULLDOZE(60, 1.0, Type.GROUND, MoveType.PHYSICAL, 10, "LowerOpSpeed", 0, 1.0, "Bulldoze", "The user causes a tremor in the ground, lowering the target's Speed stat.", new String[] {"CanProtect"}),
  MUDSHOT(55, 0.95, Type.GROUND, MoveType.SPECIAL, 10, "LowerOpSpeed", 0, 1.0, "Mud Shot", "The user attacks by hurling a blob of mud at the target. This also lowers the target's Speed stat.", new String[] {"CanProtect"}),
  AQUATAIL(80, 1.0, Type.WATER, MoveType.PHYSICAL, 20, "", 0, 0, "Aqua Tail", "The user attacks by swinging its tail as if it were a vicious wave in a raging storm.", new String[] {"MakesContact","CanProtect"}),
  TACKLE(40, 1.0, Type.NORMAL, MoveType.PHYSICAL, 35, "", 0, 0, "Tackle", "The user charges at the target with full force.", new String[] {"MakesContact","CanProtect"}),
  POISONSTING(15, 1.0, Type.POISON, MoveType.PHYSICAL, 35, "Poison", 0, 0.3, "Poison Sting", "The user stabs the target with a poisonous stinger. This may also poison the target.", new String[] {"CanProtect"}),
  VENOSHOCK(65, 1.0, Type.POISON, MoveType.SPECIAL, 35, "DoubleDamagePoisoned", 0, 1.0, "Venoshock", "The user drenches the target in a special poisonous liquid. This move's power is doubled if the target is poisoned.", new String[] {"CanProtect"}),
  POISONJAB(80, 1.0, Type.POISON, MoveType.PHYSICAL, 35, "Poison", 0, 0.1, "Poison Jab", "The user jabs the opponent with a poisonous limb. This may poison the target.", new String[] {"CanProtect","MakesContact"}),
  GUNKSHOT(120, 0.80, Type.POISON, MoveType.PHYSICAL, 35, "Poison", 0, 0.3, "Gunk Shot", "The user throws unsanitary sludge at the opponent. This may poison the target.", new String[] {"CanProtect"}),
  MUDSLAP(20, 1.0, Type.GROUND, MoveType.SPECIAL, 35, "LowerOpAccuracy", 0, 0.99, "Mud-Slap", "The user hurls mud in the target's face to inflict damage. Incoming moves also become more likely to miss.", new String[] {"CanProtect"}),
  SCRATCH(40, 1.0, Type.NORMAL, MoveType.PHYSICAL, 35, "", 0, 0, "Scratch", "Hard, pointed, sharp claws rake the target to inflict damage.", new String[] {"MakesContact","CanProtect"}),
  VINEWHIP(40, 1.0, Type.GRASS, MoveType.PHYSICAL, 35, "", 0, 0, "Vine Whip", "The user lashes out at the target with vines.", new String[] {"MakesContact","CanProtect"}),
  GROWTH(0, 1.0, Type.GRASS, MoveType.STATUS, 35, "IncreaseAtkSpA", 0, 1.0, "Growth", "The user gains more energy, raising its Attack and Special Attack by a stage", new String[] {}),
  WORKUP(0, 1.0, Type.NORMAL, MoveType.STATUS, 35, "IncreaseAtkSpA", 0, 1.0, "Work Up", "The user gains strength, raising its Attack and Special Attack by a stage", new String[] {}),
  ICEBEAM(90, 1.0, Type.ICE, MoveType.SPECIAL, 10, "Freeze", 0, 0.1, "Ice Beam",  "The target is struck with an icy-cold beam of energy. This may also freeze the target.", new String[] {"CanProtect"}),
  BUGBUZZ(90, 1.0, Type.BUG, MoveType.SPECIAL, 10, "LowerOpSpD", 0, 0.1, "Bug Buzz",  "The user generates a damaging sound wave by vibration. This may also lower the target's Sp. Def stat.", new String[] {"CanProtect"}),
  ICYWIND(55, 0.95, Type.ICE, MoveType.SPECIAL, 10, "LowerOpSpeed", 0, 1.0, "Icy Wind",  "The targets are struck with a cold wind. This lowers the target's speed.", new String[] {"CanProtect"}),
  FREEZEDRY(70, 1.0, Type.FREEZEDRY, MoveType.SPECIAL, 20, "Freeze", 0, 0.1, "Freeze Dry",  "The user rapidly cools the target. This may also leave the target frozen. This move is super effective on Water types.", new String[] {"CanProtect"}),
  ENERGYBALL(90, 1.0, Type.GRASS, MoveType.SPECIAL, 20, "LowerOpSpD", 0, 0.2, "Energy Ball",  "The user draws power from nature and fires it at the target. This may also lower the target's Sp. Def stat.", new String[] {"CanProtect","BulletMove"}),
  THUNDERBOLT(90, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 10, "Paralyze", 0, 0.1, "Thunderbolt",  "The target is struck a powerful lightning bolt. It may paralze the target.", new String[] {"CanProtect"}),
  DISCHARGE(80, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 10, "Paralyze", 0, 0.3, "Discharge",  "The user strikes everything around it by letting loose a flare of electricity. This may also cause paralysis.", new String[] {"CanProtect"}),
  LAVAPLUME(80, 1.0, Type.FIRE, MoveType.SPECIAL, 10, "Burn", 0, 0.3, "Lava Plume",  "The user strikes everything around it by letting loose fire. This may inflict a burn on its target.", new String[] {"CanProtect"}),
  BODYSLAM(85, 1.0, Type.NORMAL, MoveType.PHYSICAL, 10, "Paralyze", 0, 0.3, "Body Slam",  "The user drops onto the target with its full body weight. This may also leave the target with paralysis.", new String[] {"MakesContact","CanProtect"}),
  HURRICANE(110, 0.70, Type.FLYING, MoveType.SPECIAL, 10, "Confuse", 0, 0.3, "Hurricane", "The user attacks by wrapping its opponent in a fierce wind. This may confuse the target.", new String[] {"CanProtect"}),
  PSYCHIC(90, 1.0, Type.PSYCHIC, MoveType.SPECIAL, 10, "LowerOpSpD", 0, 0.1, "Psychic", "The user envelopes the target with powerful psychic energy. This may lower the target's Special Defense.", new String[] {"CanProtect"}),
  SHADOWBALL(80, 1.0, Type.GHOST, MoveType.SPECIAL, 10, "LowerOpSpD", 0, 0.1, "Shadow Ball", "The user launches a ghostly ball of energy at the opponent. This may lower the target's Special Defense.", new String[] {"CanProtect","BulletMove"}),
  HEX(65, 1.0, Type.GHOST, MoveType.SPECIAL, 10, "DoubleDamageStatus", 0, 0.1, "Hex", "The user attacks the opponent. If the opponent is statused, it does double the damage.", new String[] {"CanProtect"}),
  SURF(90, 1.0, Type.WATER, MoveType.SPECIAL, 10, "", 0, 1.0, "Surf", "The user swamps the field with a surging wave.", new String[] {"CanProtect"}),
  DRAININGKISS(50, 1.0, Type.FAIRY, MoveType.SPECIAL, 10, "Drain", 0, 1.0, "Draining Kiss", "A energy-draining attack. The user's HP is restored by half the damage taken by the target.", new String[] {"MakesContact","CanProtect"}),
  GIGADRAIN(75, 1.0, Type.GRASS, MoveType.SPECIAL, 10, "Drain", 0, 1.0, "Giga Drain", "A energy-draining attack. The user's HP is restored by half the damage taken by the target.", new String[] {"CanProtect"}),
  FORCEPALM(60, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 10, "Paralyze", 0, 0.3, "Force Palm", "The target is attacked with a shock wave. This may also leave the target with paralysis.", new String[] {"CanProtect","MakesContact"}),
  DYNAMICPUNCH(100, 0.5, Type.FIGHTING, MoveType.PHYSICAL, 10, "Confuse", 0, 0.99, "Dynamic Punch", "The user attacks by punching the target with full concentrated power. This also confuses the target.", new String[] {"CanProtect","MakesContact"}),
  HAMMERARM(100, 0.9, Type.FIGHTING, MoveType.PHYSICAL, 16, "LowerSelfSp", 0, 0.99, "Hammer Arm", "The user swings its strong, heavy fist at the target to inflict damage. This also lowers the user's Speed stat.", new String[] {"CanProtect","MakesContact"}),
  ZAPCANNON(120, 0.5, Type.ELECTRIC, MoveType.SPECIAL, 5, "Paralyze", 0, 0.99, "Zap Cannon", "TThe user attacks by firing an electric blast like a cannon. This also leaves the target with paralysis.", new String[] {"CanProtect","MakesContact","BulletMove"}),
  MEGADRAIN(40, 1.0, Type.GRASS, MoveType.SPECIAL, 10, "Drain", 0, 1.0, "Mega Drain", "A energy-draining attack. The user's HP is restored by half the damage taken by the target.", new String[] {"CanProtect"}),
  SPLASH(0, 1.0, Type.NORMAL, MoveType.STATUS, 40, "", 0, 1.0, "Splash", "The user just flops and splashes around to no effect at all...", new String[] {"CanProtect"}),
  PARABOLICCHARGE(65, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 10, "Drain", 0, 1.0, "Parabolic Charge", "The user attacks everything around it. The user's HP is restored by half the damage taken by those hit.", new String[] {"CanProtect"}),
  DRAINPUNCH(75, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 10, "Drain", 0, 1.0, "Drain Punch", "An energy-draining punch. The user's HP is restored by half the damage taken by the target.", new String[] {"CanProtect"}),
  LEECHLIFE(80, 1.0, Type.BUG, MoveType.PHYSICAL, 10, "Drain", 0, 1.0, "Leech Life", "A nutrient-draining attack. The user's HP is restored by half the damage taken by the target.", new String[] {"CanProtect"}),
  SLUDGEBOMB(90, 1.0, Type.POISON, MoveType.SPECIAL, 10, "Poison", 0, 0.3, "Sludge Bomb", "This user launches corrosive sludge at the opponent. This may poison the target.", new String[] {"CanProtect","BulletMove"}),
  SLUDGE(65, 1.0, Type.POISON, MoveType.SPECIAL, 10, "Poison", 0, 0.4, "Sludge", "The user hurls unsanitary sludge at the target to inflict damage. This may also poison the target.", new String[] {"CanProtect"}),
  SLUDGEWAVE(95, 1.0, Type.POISON, MoveType.SPECIAL, 10, "Poison", 0, 0.1, "Sludge Wave", "This user swamps the opponent with a poisonous wave. This may poison the target.", new String[] {"CanProtect"}),
  DRAGONPULSE(80, 1.0, Type.DRAGON, MoveType.SPECIAL, 15, "", 0, 0, "Dragon Pulse", "The user shoots a beam of draconic energy at the opponent.", new String[] {"CanProtect","PulseMove"}),
  AEROBLAST(105, 0.95, Type.FLYING, MoveType.SPECIAL, 8, "IncreasedCritRate", 0, 0, "Aeroblast", "A vortex of air is shot at the target to inflict damage. Critical hits land more easily.", new String[] {"CanProtect"}),
  ORIGINPULSE(110, 0.85, Type.WATER, MoveType.SPECIAL, 8, "", 0, 0, "Origin Pulse", "The user attacks opposing Pokémon with countless beams of light that glow a deep and brilliant blue.", new String[] {"CanProtect","PulseMove"}),
  PRECIPICEBLADES(110, 0.85, Type.GROUND, MoveType.PHYSICAL, 8, "", 0, 0, "Precipice Blades", "The user attacks opposing Pokémon by manifesting the power of the land in fearsome blades of stone.", new String[] {"CanProtect"}),
  SPATIALREND(105, 0.95, Type.DRAGON, MoveType.SPECIAL, 8, "IncreasedCritRate", 0, 0, "Spatial Rend", "The user bends space around the target. This move has a increased chance of scoring a critical hit.", new String[] {"CanProtect"}),
  SACREDFIRE(105, 0.95, Type.FIRE, MoveType.PHYSICAL, 8, "Burn", 0, 0.5, "Sacred Fire", "The target is razed with a mystical fire of great intensity. This may also leave the target with a burn.", new String[] {"CanProtect"}),
  ANCIENTPOWER(60, 1.0, Type.ROCK, MoveType.SPECIAL, 8, "RaiseAllStats", 0, 0.1, "Ancient Power", "The user attacks with a prehistoric power. It may also raise all the user's stats at once.", new String[] {"CanProtect"}),
  FIREBLAST(120, 0.85, Type.FIRE, MoveType.SPECIAL, 8, "Burn", 0, 0.3, "Fire Blast", "The target is attacked with an intense blast of all-consuming fire. This may also leave the target with a burn.", new String[] {"CanProtect"}),
  MEGAHORN(120, 0.85, Type.BUG, MoveType.PHYSICAL, 8, "", 0, 0.3, "Megahorn", "The target is attacked with a powerful horn.", new String[] {"CanProtect","MakesContact"}),
  THUNDER(120, 0.7, Type.ELECTRIC, MoveType.SPECIAL, 8, "Paralyze", 0, 0.3, "Thunder", "A wicked thunderbolt is dropped on the target to inflict damage. It may also leave the target with paralysis.", new String[] {"CanProtect"}),
  BLIZZARD(120, 0.7, Type.ICE, MoveType.SPECIAL, 8, "Freeze", 0, 0.3, "Blizzard", "A howling blizzard is summoned to strike opposing Pokémon. This may also leave the opposing Pokémon frozen.", new String[] {"CanProtect"}),
  POWERWHIP(120, 0.85, Type.GRASS, MoveType.PHYSICAL, 18, "", 0, 0, "Power Whip", "The user violently whirls its vines or tentacles to harshly lash the target.", new String[] {"MakesContact", "CanProtect"}),
  FIREPUNCH(75, 1.0, Type.FIRE, MoveType.PHYSICAL, 15, "Burn", 0, 0.1, "Fire Punch",  "The target is struck with a flaming fist. It may burn the target.", new String[] {"MakesContact", "CanProtect"}),
  ICEPUNCH(75, 1.0, Type.ICE, MoveType.PHYSICAL, 15, "Freeze", 0, 0.1, "Ice Punch",  "The target is struck with a icy fist. It may freeze the target.", new String[] {"MakesContact", "CanProtect"}),
  THUNDERPUNCH(75, 1.0, Type.ELECTRIC, MoveType.PHYSICAL, 15, "Paralyze", 0, 0.1, "Thunder Punch",  "The target is struck with a shocking fist. It may freeze the target.", new String[] {"MakesContact", "CanProtect"}),
  BITE(60, 1.0, Type.DARK, MoveType.PHYSICAL, 15, "Flinch", 0, 0.1, "Bite",  "The user bites with its fangs. This may also make the target flinch.", new String[] {"MakesContact", "CanProtect", "JawMove"}),
  ICEFANG(65, 0.95, Type.ICE, MoveType.PHYSICAL, 15, "Freeze", 0, 0.1, "Ice Fang",  "The user bites with cold-infused fangs. This may also make the target flinch or leave it frozen.", new String[] {"MakesContact", "CanProtect", "JawMove"}),
  FIREFANG(65, 0.95, Type.FIRE, MoveType.PHYSICAL, 15, "Burn", 0, 0.1, "Fire Fang",  "The user bites with flame-infused fangs. This may also make the target flinch or leave it burned.", new String[] {"MakesContact", "CanProtect", "JawMove"}),
  THUNDERFANG(65, 0.95, Type.ELECTRIC, MoveType.PHYSICAL, 15, "Paralyze", 0, 0.1, "Thunder Fang",  "The user bites with electricity-infused fangs. This may also make the target flinch or leave it paralyzed.", new String[] {"MakesContact", "CanProtect", "JawMove"}),
  BRAVEBIRD(120, 1.0, Type.FLYING, MoveType.PHYSICAL, 15, "RecoilOneThird", 0, 1.0, "Brave Bird", "The user tucks in its wings and charges from a low altitude. This also damages the user quite a lot.", new String[] {"MakesContact","CanProtect"}),
  FLAREBLITZ(120, 1.0, Type.FIRE, MoveType.PHYSICAL, 15, "RecoilOneThird", 0, 1.0, "Flare Blitz", "The user surrounds itself with fire and charges full-on at the target. This also damages the user quite a lot.", new String[] {"MakesContact","CanProtect"}),
  DOUBLEEDGE(120, 1.0, Type.NORMAL, MoveType.PHYSICAL, 15, "RecoilOneThird", 0, 1.0, "Double Edge", "A reckless, life-risking tackle in which the user rushes the target. This also damages the user quite a lot.", new String[] {"MakesContact","CanProtect"}),
  TAKEDOWN(100, 0.85, Type.NORMAL, MoveType.PHYSICAL, 15, "RecoilOneThird", 0, 1.0, "Take Down", "	A reckless full-body charge attack for slamming into the target. This also damages the user a little.", new String[] {"MakesContact","CanProtect"}),
  WOODHAMMER(120, 1.0, Type.GRASS, MoveType.PHYSICAL, 15, "RecoilOneThird", 0, 1.0, "Wood Hammer", "The user slams its rugged body into the target to attack. This also damages the user quite a lot.", new String[] {"MakesContact","CanProtect"}),
  HEADSMASH(150, 0.8, Type.ROCK, MoveType.PHYSICAL, 15, "RecoilOneHalf", 0, 1.0, "Head Smash", "The user attacks the target with a hazardous, full-power headbutt. This also damages the user terribly.", new String[] {"MakesContact","CanProtect"}),
  SEEDBOMB(80, 1.0, Type.GRASS, MoveType.PHYSICAL, 15, "", 0, 1.0, "Seed Bomb", "The user bombards the target with explosive seeds.", new String[] {"BulletMove","CanProtect"}),
  BULLETSEED(25, 1.0, Type.GRASS, MoveType.PHYSICAL, 15, "Multi-Hit", 0, 1.0, "Bullet Seed", "The user shoots the target with seeds that hit 2-5 times.", new String[] {"BulletMove","CanProtect"}),
  ROCKBLAST(25, 1.0, Type.ROCK, MoveType.PHYSICAL, 15, "Multi-Hit", 0, 1.0, "Rock Blast", "The user shoots the target with rocks that hit 2-5 times.", new String[] {"CanProtect","BulletMove"}),
  CLOSECOMBAT(120, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 8, "LowerSelfSpDDef", 0, 1.0, "Close Combat", "The user fights the target up close, lowering its Defense and Sp. Def stats.", new String[] {"MakesContact","CanProtect"}),
  SUPERPOWER(120, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 8, "LowerSelfAtkDef", 0, 1.0, "Superpower", "The user attacks the target with great power. This also lowers the user's Attack and Defense stats.", new String[] {"MakesContact","CanProtect"}),
  OUTRAGE(120, 1.0, Type.DRAGON, MoveType.PHYSICAL, 8, "LowerSelfSpDDef", 0, 1.0, "Outrage", "The user rampages for a couple of turns, and then becomes confused.", new String[] {"MakesContact","CanProtect"}),
  COLLISIONCOURSE(100, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 8, "MorePowerSuperEffective", 0, 1.0, "Collision Course", "The user transforms and crashes to the ground, causing a massive prehistoric explosion. This move's power is boosted more than usual if it’s a supereffective hit.", new String[] {"MakesContact","CanProtect"}),
  ELECTRODRIFT(100, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 8, "MorePowerSuperEffective", 0, 1.0, "Collision Course", "The user races forward at ultrafast speeds, piercing its target with futuristic electricity. This move's power is boosted more than usual if it's a supereffective hit.", new String[] {"MakesContact","CanProtect"}),
  HIGHJUMPKICK(130, 0.9, Type.FIGHTING, MoveType.PHYSICAL, 8, "HurtSelfIfMiss", 0, 1.0, "High Jump Kick", "The target is attacked with a knee kick from a jump. If it misses, the user is hurt instead.", new String[] {"MakesContact","CanProtect"}),
  IRONTAIL(100, 0.85, Type.STEEL, MoveType.PHYSICAL, 15, "LowerOpDef", 0, 0.3, "Iron Tail", "This user strikes the target with its metal-infused tail, potentially lowering the opponent's Def. stat.", new String[] {"MakesContact","CanProtect"}),
  CRUNCH(80, 1.0, Type.DARK, MoveType.PHYSICAL, 15, "LowerOpDef", 0, 0.2, "Crunch", "The user crunches up the target with sharp fangs. This may also lower the target's Defense stat.", new String[] {"MakesContact","CanProtect"}),
  BRICKBREAK(75, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 15, "BreakBarriers", 0, 1.0, "Brick Break", "The user attacks with a swift chop. It can also break barriers, such as Light Screen and Reflect.", new String[] {"MakesContact","CanProtect"}),
  EARTHPOWER(90, 1.0, Type.GROUND, MoveType.SPECIAL, 10, "LowerOpSpD", 0, 0.1, "Earth Power", "This user causes the ground around the target to burst, potentially lowering their Sp. Def. stat.", new String[] {"CanProtect"}),
  AURASPHERE(80, -1.0, Type.FIGHTING, MoveType.SPECIAL, 10, "", 0, 0, "Aura Sphere", "The user lets loose a blast of aura power from deep within its body at the target. This attack never misses.", new String[] {"CanProtect","PulseMove","BulletMove"}),
  DISARMINGVOICE(40, -1.0, Type.FAIRY, MoveType.SPECIAL, 24, "", 0, 0, "Disarming Voice", "Letting out a charming cry, the user does emotional damage to opposing Pokémon. This attack never misses.", new String[] {"CanProtect","Sound"}),
  WATERPULSE(60, 1.0, Type.WATER, MoveType.SPECIAL, 10, "Confuse", 0, 0.2, "Water Pulse", "The user attacks the target with a pulsing blast of water. This may also confuse the target.", new String[] {"CanProtect","PulseMove"}),
  IRONHEAD(80, 1.0, Type.STEEL, MoveType.PHYSICAL, 20, "Flinch", 0, 0.3, "Iron Head", "The strikes the target with its iron-hard head. This may flinch the opponent.", new String[] {"MakesContact","CanProtect"}),
  METEORMASH(100, 0.9, Type.STEEL, MoveType.PHYSICAL, 20, "RaiseAtk", 0, 0.2, "Meteor Mash", "The target is hit with a hard punch fired like a meteor. This may also boost the user’s Attack stat.", new String[] {"MakesContact","CanProtect"}),
  ZENHEADBUTT(80, 0.9, Type.PSYCHIC, MoveType.PHYSICAL, 15, "Flinch", 0, 0.2, "Zen Headbutt", "The user focuses its willpower to its head and attacks the target. This may also make the target flinch.", new String[] {"MakesContact","CanProtect"}),
  DRAGONCLAW(80, 1.0, Type.DRAGON, MoveType.PHYSICAL, 20, "", 0, 0, "Dragon Claw", "The strikes the target with its sharp claws.", new String[] {"MakesContact","CanProtect"}),
  DRAGONRUSH(100, 0.75, Type.DRAGON, MoveType.PHYSICAL, 20, "Flinch", 0, 0.2, "Dragon Rush", "The user tackles the target while exhibiting overwhelming menace. This may also make the target flinch.", new String[] {"MakesContact","CanProtect"}),
  STEELWING(70, 0.9, Type.STEEL, MoveType.PHYSICAL, 20, "RaiseDef", 0, 0.2, "Steel Wing", "The target is hit with wings of steel. This may also raise the user's Defense stat.", new String[] {"MakesContact","CanProtect"}),
  DARKPULSE(80, 1.0, Type.DARK, MoveType.SPECIAL, 15, "Flinch", 0, 0.2, "Dark Pulse", "The user releases a horrible aura imbued with dark thoughts. This may also make the target flinch.", new String[] {"CanProtect","PulseMove"}),
  WATERFALL(80, 1.0, Type.WATER, MoveType.PHYSICAL, 15, "Flinch", 0, 0.2, "Waterfall", "The user attacks the target with a raging waterfall.", new String[] {"CanProtect"}),
  LIQUIDATION(85, 1.0, Type.WATER, MoveType.PHYSICAL, 15, "LowerOpDef", 0, 0.2, "Liquidation", "The user slams into the target using a full-force blast of water. This may also lower the target's Defense stat.", new String[] {"MakesContact","CanProtect"}),
  WINGATTACK(60, 1.0, Type.FLYING, MoveType.PHYSICAL, 30, "", 0, 0.2, "Wing Attack", "The user strikes the opponent with its wings.", new String[] {"MakesContact","CanProtect"}),
  DRILLPECK(80, 1.0, Type.FLYING, MoveType.PHYSICAL, 10, "", 0, 0.2, "Drill Peck", "The user strikes the opponent with its sharp beak.", new String[] {"MakesContact","CanProtect"}),
  AIRSLASH(75, 0.95, Type.FLYING, MoveType.SPECIAL, 10, "Flinch", 0, 0.3, "Air Slash", "The user attacks with a blade of air that slices even the sky. This may also make the target flinch.", new String[] {"CanProtect"}),
  AERIALACE(60, -1.0, Type.FLYING, MoveType.PHYSICAL, 20, "", 0, 0, "Aerial Ace", "The user performs an aerial attack that never misses.", new String[] {"MakesContact","CanProtect"}),
  UTURN(70, 1.0, Type.BUG, MoveType.PHYSICAL, 20, "Switch", 0, 1.0, "U-Turn", "The user quickly attacks the opponent, and then returns to its trainer.", new String[] {"MakesContact","CanProtect"}),
  VOLTSWITCH(70, 1.0, Type.ELECTRIC, MoveType.SPECIAL, 20, "Switch", 0, 1.0, "Volt Switch", "The user quickly attacks the opponent, and then returns to its trainer.", new String[] {"CanProtect"}),
  KNOCKOFF(65, 1.0, Type.DARK, MoveType.PHYSICAL, 20, "KnockOff", 0, 1.0, "Knock Off", "The user slaps down the target's held item, and that item can't be used in that battle. The move does more damage if the target has a held item.", new String[] {"MakesContact","CanProtect"}),
  LUNGE(80, 1.0, Type.BUG, MoveType.PHYSICAL, 20, "LowerOpAtk", 0, 1.0, "Lunge", "The user makes a lunge at the target, attacking with full force. This also lowers the target's Attack stat.", new String[] {"MakesContact","CanProtect"}),
  BREAKINGSWIPE(60, 1.0, Type.DRAGON, MoveType.PHYSICAL, 20, "LowerOpAtk", 0, 1.0, "Breaking Swipe", "The user swings its tough tail wildly and attacks opposing Pokémon. This also lowers their Attack stats.", new String[] {"MakesContact","CanProtect"}),
  FOCUSBLAST(120, 0.7, Type.FIGHTING, MoveType.SPECIAL, 8, "LowerOpSpD", 0, 0.1, "Focus Blast", "The user heightens its mental focus and unleashes its power. This may also lower the target's Sp. Def stat. This move always misses", new String[] {"CanProtect","BulletMove"}),
  MOONBLAST(95, 1.0, Type.FAIRY, MoveType.SPECIAL, 8, "LowerOpSpA", 0, 0.3, "Moonblast", "Borrowing the power of the moon, the user attacks the target. This may also lower the target's Sp. Atk stat.", new String[] {"CanProtect"}),
  ROAROFTIME(180, 0.9, Type.DRAGON, MoveType.SPECIAL, 8, "Recharge", 0, 1.0, "Roar of Time", "This user fires an intense beam of concentrated time energy at the opponent. The user must rest a turn after using this move.", new String[] {"CanProtect"}),
  GIGAIMPACT(150, 0.9, Type.NORMAL, MoveType.PHYSICAL, 8, "Recharge", 0, 1.0, "Giga Impact", "The user charges at the target using every bit of its power. The user can't move on the next turn.", new String[] {"MakesContact","CanProtect"}),
  HYPERBEAM(150, 0.9, Type.NORMAL, MoveType.SPECIAL, 8, "Recharge", 0, 1.0, "Hyper Beam", "The target is attacked with a powerful beam. The user can't move on the next turn.", new String[] {"CanProtect"}),
  FRENZYPLANT(150, 0.9, Type.GRASS, MoveType.SPECIAL, 8, "Recharge", 0, 1.0, "Frenzy Plant", "The target is attacked with powerful vines. The user can't move on the next turn.", new String[] {"CanProtect"}),
  BLASTBURN(150, 0.9, Type.FIRE, MoveType.SPECIAL, 8, "Recharge", 0, 1.0, "Blast Burn", "The target is attacked with powerful, all-consuming fire. The user can't move on the next turn.", new String[] {"CanProtect"}),
  HYDROCANNON(150, 0.9, Type.WATER, MoveType.SPECIAL, 8, "Recharge", 0, 1.0, "Hydro Cannon", "The target is attacked with a powerful jet of water. The user can't move on the next turn.", new String[] {"CanProtect"}),
  ROCKWRECKER(150, 0.9, Type.ROCK, MoveType.PHYSICAL, 8, "Recharge", 0, 1.0, "Rock Wrecker", "The target is attacked with a powerful rock. The user can't move on the next turn.", new String[] {"CanProtect"}),
  BOOMBURST(140, 1.0, Type.NORMAL, MoveType.SPECIAL, 15, "", 0, 1.0, "Boomburst", "The user attacks everything around it with the destructive power of a terrible, explosive sound.", new String[] {"Sound"}),
  HYPERVOICE(90, 1.0, Type.NORMAL, MoveType.SPECIAL, 20, "", 0, 1.0, "Hyper Voice", "The user attacks its opponents with a damaging sound.", new String[] {"Sound"}),
  DRAKONVOICE(120, 0.85, Type.DRAGON, MoveType.SPECIAL, 20, "", 0, 1.0, "Drakon Voice", "The user attacks its opponents with a draconic, damaging sound.", new String[] {"Sound"}),
  CLANGINGSCALES(110, 1.0, Type.DRAGON, MoveType.SPECIAL, 20, "LowerSelfDef", 0, 1.0, "Clanging Scales", "The user rubs the scales on its entire body and makes a huge noise to attack opposing Pokémon. The user’s Defense stat is lowered after the attack.", new String[] {"Sound"}),
  ICESHARD(40, 1.0, Type.ICE, MoveType.PHYSICAL, 40, "", 1, 0, "Ice Shard", "This user quickly launches sharp ice at the target. This move always goes first.", new String[] {"CanProtect"}),
  SHADOWSNEAK(40, 1.0, Type.GHOST, MoveType.PHYSICAL, 40, "", 1, 0, "Shadow Sneak", "This user sneakily strikes the opponent from a shadow. This move always goes first.", new String[] {"MakesContact","CanProtect"}),
  QUICKATTACK(40, 1.0, Type.NORMAL, MoveType.PHYSICAL, 40, "", 1, 0, "Quick Attack", "This user hurls itself at the target in lightning speed. It always goes first.", new String[] {"MakesContact","CanProtect"}),
  AQUAJET(40, 1.0, Type.WATER, MoveType.PHYSICAL, 40, "", 1, 0, "Aqua Jet", "This user covers itself in water and hurls itself at the target in lightning speed. It always goes first.", new String[] {"MakesContact","CanProtect"}),
  MACHPUNCH(40, 1.0, Type.FIGHTING, MoveType.PHYSICAL, 40, "", 1, 0, "Mach Punch", "The user throws a fist at the target in lightning speed. It always goes first.", new String[] {"MakesContact","CanProtect"}),
  BULLETPUNCH(40, 1.0, Type.STEEL, MoveType.PHYSICAL, 40, "", 1, 0, "Bullet Punch", "The user punches the target in lightning speed. It always goes first.", new String[] {"MakesContact","CanProtect"}),
  ACCELEROCK(40, 1.0, Type.ROCK, MoveType.PHYSICAL, 40, "", 1, 0, "Accelerock", "The user smashes into the target at high speed. This move always goes first.", new String[] {"MakesContact","CanProtect"}),
  SUCKERPUNCH(80, 1.0, Type.DARK, MoveType.PHYSICAL, 8, "SuckerPunch", 0, 0, "Sucker Punch", "This move enables the user to attack first. This move fails if the target is not readying an attack.", new String[] {"MakesContact","CanProtect"}),
  DRACOMETEOR(140, 1.0, Type.DRAGON, MoveType.SPECIAL, 8, "LowerSelfSpA2", 0, 1.0, "Draco Meteor", "The user attacks the opponent with a meteor shower. This harshly lowers the user's Sp. Atk.", new String[] {"CanProtect"}),
  OVERHEAT(140, 1.0, Type.FIRE, MoveType.SPECIAL, 8, "LowerSelfSpA2", 0, 1.0, "Overheat", "The user attacks the target at full power. The attack's recoil harshly lowers the user's Sp. Atk stat.", new String[] {"CanProtect"}),
  LEAFSTORM(140, 1.0, Type.GRASS, MoveType.SPECIAL, 8, "LowerSelfSpA2", 0, 1.0, "Leaf Storm", "The user whips up a storm of leaves around the target. The recoil from this move harshly lowers the user's Sp. Atk stat.", new String[] {"CanProtect"}),
  WATERSPOUT(150, 1.0, Type.WATER, MoveType.SPECIAL, 8, "DecreasePowerLowerHP", 0, 1.0, "Water Spout", "The user spouts water to damage opposing Pokémon. The lower the user's HP, the lower the move's power.", new String[] {"CanProtect"}),
  ERUPTION(150, 1.0, Type.FIRE, MoveType.SPECIAL, 8, "DecreasePowerLowerHP", 0, 1.0, "Eruption", "The user attacks opposing Pokémon with explosive fury. The lower the user's HP, the lower the move's power.", new String[] {"CanProtect"}),

  //boosting moves
  NASTYPLOT(0, 1.0, Type.DARK, MoveType.STATUS, 10, "RaiseSpA2Stages", 0, 1.0, "Nasty Plot", "The user stimulates its brain by thinking bad thoughts. This sharply raises the user's Sp. Atk stat.", new String[] {}),
  CALMMIND(0, 1.0, Type.PSYCHIC, MoveType.STATUS, 10, "RaiseSpASpD", 0, 1.0, "Calm Mind", "The user meditates, raising its Sp. Attack and Sp. Defense.", new String[] {}),
  SWORDSDANCE(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "RaiseAtk2Stages", 0, 1.0, "Swords Dance", "The user raises its fighting spirit, raising its attack sharply.", new String[] {}),
  BULKUP(0, 1.0, Type.FIGHTING, MoveType.STATUS, 10, "RaiseAtkDef", 0, 1.0, "Bulk Up", "The user bulks itself up, raising its Attack and Defense stats.", new String[] {}),
  SHELLSMASH(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "LowerDefSpDRaiseAtkSpASp", 0, 1.0, "Shell Smash", "The user breaks its shell to increase its attack stats and speed, but lowers its defenses.", new String[] {}),
  WITHDRAW(0, 1.0, Type.WATER, MoveType.STATUS, 10, "SelfRaiseDefense", 0, 1.0, "Withdraw", "The user retreats into its shell, raising its Def. stat.", new String[] {}),
  IRONDEFENSE(0, 1.0, Type.STEEL, MoveType.STATUS, 10, "SharplyRaiseDefense", 0, 1.0, "Iron Defense", "The user hardens itself like steel, sharply raising its Def. stat.", new String[] {}),
  COTTONGUARD(0, 1.0, Type.GRASS, MoveType.STATUS, 10, "DrasticallyRaiseDefense", 0, 1.0, "Cotton Guard", "The user protects itself by wrapping its body in soft cotton, which drastically raises the user's Defense stat.", new String[] {}),
  GROWL(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "LowerOpAtk", 0, 1.0, "Growl", "The user growls menacingly, intimidating the opponent and lowering their attack.", new String[] {}),
  LEER(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "LowerOpDef", 0, 1.0, "Leer", "The user leers at the opponent, lowering their defense.", new String[] {}),
  METALSOUND(0, 0.85, Type.STEEL, MoveType.STATUS, 10, "LowerOpSpD2Stages", 0, 1.0, "Metal Sound", "The user lowers the opponent's special defense harshly by emitting a horrible metal sound.", new String[] {}),
  SCARYFACE(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "LowerOpSp2Stages", 0, 1.0, "Scary Face", "The user frightens the target with a scary face to harshly lower its Speed stat.", new String[] {}),
  BELLYDRUM(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "RaiseAtk6StagesButHurtUrself", 0, 1.0, "Belly Drum", "The user maximizes its Attack stat in exchange for HP equal to half its max HP.", new String[] {}),
  CLANGOROUSSOUL(0, 1.0, Type.DRAGON, MoveType.STATUS, 10, "RaiseAllStatsButHurtUrself", 0, 1.0, "Clangorous Soul", "The user boosts all its stats by using some of its own HP.", new String[] {}),
  AGILITY(0, 1.0, Type.PSYCHIC, MoveType.STATUS, 10, "SharplyRaiseSpeed", 0, 1.0, "Agility", "The user relaxes and lightens its body to move faster. This sharply raises the Speed stat.", new String[] {}),
  DRAGONDANCE(0, 1.0, Type.DRAGON, MoveType.STATUS, 10, "RaiseAtkSp", 0, 1.0, "Dragon Dance", "The user vigorously performs a mystic, powerful dance that raises its Attack and Speed stats.", new String[] {}),
  QUIVERDANCE(0, 1.0, Type.BUG, MoveType.STATUS, 10, "RaiseSpASpDSp", 0, 1.0, "Quiver Dance", "The user lightly performs a beautiful, mystic dance. This boosts the user's Sp. Atk, Sp. Def, and Speed stats.", new String[] {}),
  CURSE(0, 1.0, Type.GHOST, MoveType.STATUS, 10, "RaiseDefAtkLowerSp", 0, 1.0, "Curse", "Raises Attack and Defense at the expense of Speed. It works differently for the Ghost type.", new String[] {}),

  // status
  TOXIC(0, 1.0, Type.POISON, MoveType.STATUS, 10, "BadlyPoison", 0, 1.0, "Toxic", "The user emits a deadly poison, badly poisoning the target.", new String[] {"CanProtect", "MagicBounce"}),
  CONFUSERAY(0, 1.0, Type.GHOST, MoveType.STATUS, 10, "Confuse", 0, 1.0, "Confuse Ray", "The user shows an eerie light to the opponent, confusing it.", new String[] {"CanProtect", "MagicBounce"}),
  SWAGGER(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "ConfuseAndRaiseAtk", 0, 1.0, "Swagger", "The user enrages and confuses the target. However, this also sharply raises the target's Attack stat.", new String[] {"CanProtect", "MagicBounce"}),
  POISONPOWDER(0, 0.75, Type.POISON, MoveType.STATUS, 20, "Poison", 0, 1.0, "Poison Powder", "The user poisons the target.", new String[] {"CanProtect", "MagicBounce", "GrassImmune"}),
  SLEEPPOWDER(0, 1.0, Type.GRASS, MoveType.STATUS, 20, "Sleep", 0, 1.0, "Sleep Powder", "The user unleashes a sleep-inducing powder at the opponent.", new String[] {"CanProtect", "MagicBounce", "GrassImmune"}),
  HYPNOSIS(0, 0.6, Type.PSYCHIC, MoveType.STATUS, 20, "Sleep", 0, 1.0, "Hypnosis", "The user lulls the target to sleep with a hypnotic sound wave.", new String[] {"CanProtect", "MagicBounce"}),
  SING(0, 0.55, Type.NORMAL, MoveType.STATUS, 20, "Sleep", 0, 1.0, "Sing", "The user lulls the target to sleep with its soothing singing.", new String[] {"CanProtect", "MagicBounce"}),
  SPORE(0, 1.0, Type.GRASS, MoveType.STATUS, 20, "Sleep", 0, 1.0, "Spore", "The user puts the target to sleep with a curious substance.", new String[] {"CanProtect", "MagicBounce", "GrassImmune"}),
  LEECHSEED(0, 1.0, Type.GRASS, MoveType.STATUS, 20, "PlantSeed", 0, 1.0, "Leech Seed", "The user sows seeds onto its opponent, sapping away its health every turn.", new String[] {"CanProtect", "MagicBounce", "GrassImmune"}),
  RECOVER(0, 1.0, Type.NORMAL, MoveType.STATUS, 8, "Heal", 0, 1.0, "Recover", "Heals the user half of its health.", new String[] {""}),
  SYNTHESIS(0, 1.0, Type.GRASS, MoveType.STATUS, 8, "Heal", 0, 1.0, "Synthesis", "Heals the user half of its health, or 3/4 of its health in the sun.", new String[] {""}),
  ROOST(0, 1.0, Type.FLYING, MoveType.STATUS, 8, "HealAndLoseFlyingType", 0, 1.0, "Roost", "Heals the user half of its health and the user loses its Flying-type temporarily.", new String[] {}),
  DESTINYBOND(0, 1.0, Type.GHOST, MoveType.STATUS, 8, "DestinyBond", 0, 1.0, "Destiny Bond", "If the user faints, the attacker also faints.", new String[] {}),
  DEFOG(0, 1.0, Type.FLYING, MoveType.STATUS, 8, "Defog", 0, 1.0, "Defog", "Lowers the target's evasion stat and clears any entry hazards on the field.", new String[] {}),
  STEALTHROCK(0, 1.0, Type.ROCK, MoveType.STATUS, 32, "SetStealthRock", 0, 1.0, "Stealth Rock", "The user sets up a trap of floating rocks in the battle field, damaging those who switch in.", new String[] {"MagicBounce"}),
  SPIKES(0, 1.0, Type.GROUND, MoveType.STATUS, 32, "SetSpikes", 0, 1.0, "Spikes", "The user lays a trap of spikes at the opposing team's feet. The trap hurts Pokémon that switch into battle.", new String[] {"MagicBounce"}),
  TOXICSPIKES(0, 1.0, Type.POISON, MoveType.STATUS, 32, "SetToxicSpikes", 0, 1.0, "Toxic Spikes", "The user lays a trap of toxic spikes at the opposing team's feet. The trap poisons Pokémon that switch into battle.", new String[] {"MagicBounce"}),
  STICKYWEB(0, 1.0, Type.BUG, MoveType.STATUS, 32, "SetStickyWeb", 0, 1.0, "Sticky Web", "The user sets up sticky webs in the battle field, lowering the speed stat of grounded Pokémon who switch in.", new String[] {"MagicBounce"}),
  THUNDERWAVE(0, 1.0, Type.ELECTRIC, MoveType.STATUS, 10, "Paralyze", 0, 1.0, "Thunder Wave", "The user emits a weak electrical wave, paralyzing the target.", new String[] {"MagicBounce","CanProtect"}),
  PROTECT(0, 1.0, Type.NORMAL, MoveType.STATUS, 10, "SelfProtect", 0, 1.0, "Protect", "The user shields itself from any incoming attack. It gets progressively difficult to use this move consecutively.", new String[] {"MagicBounce","CanProtect"}),
  SUNNYDAY(0, 1.0, Type.FIRE, MoveType.STATUS, 10, "Sun", 0, 1.0, "Sunny Day", "The user intensifies the sun for five turns, powering up Fire-type moves. It lowers the power of Water-type moves.", new String[] {}),
  RAINDANCE(0, 1.0, Type.WATER, MoveType.STATUS, 10, "Rain", 0, 1.0, "Rain Dance", "The user intensifies the rain for five turns, powering up Water-type moves. It lowers the power of Fire-type moves.", new String[] {}),
  SANDSTORM(0, 1.0, Type.ROCK, MoveType.STATUS, 10, "Sandstorm", 0, 1.0, "Sandstorm", "The user whips up a sandstorm for five turns that does damage to most Pokémon per turn.", new String[] {}),
  ELECTRICTERRAIN(0, 1.0, Type.ELECTRIC, MoveType.STATUS, 10, "ElectricTerrain", 0, 1.0, "Electric Terrain", "The user covers the ground in electricity, powering up Electric-Type moves for five turns.", new String[] {}),

  // special moves that trigger in specific circumstances
  CONFUSIONHIT(40, 1.0, null, MoveType.PHYSICAL, 5, "", 0, 0, "", "", new String[] {"MakesContact"}),
  STRUGGLE(50, 1.0, null, MoveType.PHYSICAL, 5, "LoseOneFourthHP", 0, 1.0, "Struggle", "If the user has no more PP, this is the move they will use.", new String[] {"MakesContact", "CanProtect"});

  private int BASE_POWER;
  private double ACCURACY;
  private MoveType TYPE;
  private Type ELEMENT;
  private int PP;
  private String SPECIAL_EFFECT;
  private int PRIORITY;
  private String NAME;
  private String DESCRIPTION;
  private double CHANCE_SIDE_EFFECT;
  private boolean CONTACT;
  private boolean CAN_PROTECT;
  private int BATTLE_PP;
  private String[] FLAGS;
  private Type ORIGINAL_TYPE;

  
/**
 *  Constructor defining a move
 *  @param base_power The base power of the move
 *  @param accuracy How accurate it is
 *  @param element The element associated with it
 *  @param type The type of move (physical, special, status)
 *  @param pp The pp
 *  @param special_effect The special effect that can happen
 *  @param priority The priority of the move
 *  @param chance_side_effect The chance that a special effect occurs
 *  @param name The name of the move
 *  @param description Description of the move
 *  @param flags Flags of the move (e.g. is it a contact move)
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Move(int base_power, double accuracy, Type element, MoveType type, int pp, String special_effect, int priority, double chance_side_effect, String name, String description, String[] flags) {
    BASE_POWER = base_power;
    ACCURACY = accuracy;
    ELEMENT = element;
    TYPE = type;
    PP = pp;
    SPECIAL_EFFECT = special_effect;
    PRIORITY = priority;
    NAME = name;
    DESCRIPTION = description;
    CHANCE_SIDE_EFFECT = chance_side_effect;
    FLAGS = flags;
    BATTLE_PP = pp;
    ORIGINAL_TYPE = element;
  }

  
/**
 *  util function seeing if a string array contains a flag
 *  @param s Inputted string array
 *  @param flag The specific flag to check for
 *  @return True if it contains it, false if not
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean contains(String[] s, String flag) {
    for (String t : s) {
	    if (t.equals(flag)) {
		    return true;
	    }
    }
    return false;
  }

  
/**
 *  Gets base power of move
 *
 *  @return Base power of the move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getBasePower() {
    return BASE_POWER;
  }

/**
 *  Sets base power of move
 *
 *  @param Base power of the move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setBasePower(int i) {
    BASE_POWER = i;
  }

  
/**
 *  Gets special effect of move
 *
 *  @return Special effect of the move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getSpecialEffect() {
    return SPECIAL_EFFECT;
  }

  
/**
 *  Gets current pp of the move
 *
 *  @return Current battle PP of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getCurrentPP() {
    return BATTLE_PP;
  }

  
/**
 *  decreases move's pp
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void decrementPP() {
    BATTLE_PP -= 1;
  }

  
/**
 *  restores the move's pp
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void restorePP() {
    BATTLE_PP = PP;
  }

  
/**
 *  applies effects that are used on itself. i.e. dragon dance raising the user's attack and speed
 *
 *  @param self The pokemon in question
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void applyEffectSelf(Pokemon self) {
    switch (SPECIAL_EFFECT) {
      case "RaiseDefAtkLowerSp":
        self.raiseAttackByStage(1);
        self.raiseDefenseByStage(1);
        self.raiseSpeedByStage(-1);
        break;
      case "DestinyBond":
        System.out.println(self.getNickname() + " is trying to take down its attacker with it!");
        self.setDestinyBond(true);
        break;
      case "RaiseSpASpD":
        self.raiseSpecialAttackByStage(1);
        self.raiseSpecialDefenseByStage(1);
        break;
      case "RaiseAtkSpA":
        self.raiseAttackByStage(1);
        self.raiseSpecialAttackByStage(1);
        break;
      case "SelfRaiseDefense":
        self.raiseDefenseByStage(1);
        break;
      case "RaiseAtk":
        self.raiseAttackByStage(1);
        break;
      case "RaiseDef":
        self.raiseDefenseByStage(1);
        break;
      case "RaiseAtk2Stages":
        self.raiseAttackByStage(2);
        break;
      case "RaiseSpA2Stages":
        self.raiseSpecialAttackByStage(2);
        break;
      case "RaiseAtkDef":
        self.raiseAttackByStage(1);
        self.raiseDefenseByStage(1);
        break;
      case "LowerSelfSp":
        self.raiseSpeedByStage(-1);
        break;
      case "LowerSelfDef":
        self.raiseDefenseByStage(-1);
        break;
      case "LowerSelfSpDDef":
        self.raiseDefenseByStage(-1);
        self.raiseSpecialDefenseByStage(-1);
        break;
      case "Heal":
        self.heal((int)(self.getMaxHP() / 2.0));
        break;
      case "HealAndLoseFlyingType":
        self.heal((int)(self.getMaxHP() / 2.0));
        // incomplete! need to temporarily lose flying type
        break;
      case "DrasticallyRaiseDefense":
        self.raiseDefenseByStage(3);
        break;
      case "Recharge":
        self.setResting(2);
        break;
      case "SharplyRaiseDefense":
        self.raiseDefenseByStage(2);
        break;
      case "LowerDefSpDRaiseAtkSpASp":
        self.raiseDefenseByStage(-1);
        self.raiseSpecialDefenseByStage(-1);
        self.raiseAttackByStage(1);
        self.raiseSpecialAttackByStage(1);
        self.raiseSpeedByStage(1);
        break;
      case "RaiseAllStats":
        self.raiseAttackByStage(1);
        self.raiseDefenseByStage(1);
        self.raiseSpecialAttackByStage(1);
        self.raiseSpecialDefenseByStage(1);
        self.raiseSpeedByStage(1);
        break;
      case "RaiseAtk6StagesButHurtUrself":
        if (self.getCurrentHP() < (1.0 / 2.0) * self.getMaxHP()) {
          System.out.println("But it failed!");
          return;
        }
        self.raiseAttackByStage(6);
        self.takeDamage((int)(self.getMaxHP() / 2.0));
        System.out.println(self.getNickname() + " cut half of its HP!");
        break;
      case "RaiseAllStatsButHurtUrself":
        if (self.getCurrentHP() < (1.0 / 3.0) * self.getMaxHP()) {
          System.out.println("But it failed!");
          return;
        }
        self.raiseAttackByStage(1);
        self.raiseDefenseByStage(1);
        self.raiseSpecialAttackByStage(1);
        self.raiseSpecialDefenseByStage(1);
        self.raiseSpeedByStage(1);
        self.takeDamage((int)(self.getMaxHP() / 3.0));
        System.out.println(self.getNickname() + " cut some of its HP!");
        break;
      case "LoseOneFourthHP":
        int damage = (int)(self.getMaxHP() / 4.0);
        System.out.println(self.getNickname() + " took " + damage + " damage from recoil!");
        self.takeDamage(damage);
        break;
      case "LowerSelfSpA2":
        self.raiseSpecialAttackByStage(-2);
        break;
      case "RaiseAtkSp":
        self.raiseAttackByStage(1);
        self.raiseSpeedByStage(1);
        break;
      case "SharplyRaiseSpeed":
        self.raiseSpeedByStage(2);
        break;
      case "RaiseSpASpDSp":
        self.raiseSpecialAttackByStage(1);
        self.raiseSpecialDefenseByStage(1);
        self.raiseSpeedByStage(1);
        break; 
    }
  }

  
/**
 *  applies move's side effect if a random double is below the chance of the side effect happening. i.e. if it has a chance to burn
 *
 *  @param self The pokemon itself
 *  @param opponent Pokemon's opponent
 *  @param field The battle field
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void applySpecialEffect(Pokemon self, Pokemon opponent, Battle field) {
    if (self.hasAbility(Ability.SHEERFORCE)) {
      return;
    }
    Random rand = new Random();
    double d = rand.nextDouble();
    if (d < CHANCE_SIDE_EFFECT || (self.hasAbility(Ability.SERENEGRACE) && d < CHANCE_SIDE_EFFECT * 2)) {
      switch (SPECIAL_EFFECT) {
        case "Burn":
          opponent.burn();
          break;
        case "Freeze":
          opponent.freeze();
          break;
        case "Poison":
          opponent.poison();
          break;
        case "Paralyze":
          opponent.paralyze();
          break;
        case "BadlyPoison":
          opponent.badlyPoison();
          break;
        case "Rain":
          self.setWeather(field, Weather.RAIN);
          break;
        case "Sandstorm":
          System.out.println("sandstorm");
          self.setWeather(field, Weather.SANDSTORM);
          break;
        case "Sun":
          self.setWeather(field, Weather.SUN);
          break;
        case "Sleep":
          if (field.getTerrain() == Weather.ELECTRICTERRAIN && !opponent.isAirborne()) {
            System.out.println("Electric Terrain prevents grounded Pokémon from sleeping!");
            return;
          }
          opponent.sleep();
          break;
        case "Synthesis":
          if (field.getWeather() == Weather.SUN) {
            self.heal(self.getMaxHP() / 2);
          } else {
            self.heal((int)(self.getMaxHP() * (2.0 /3.0)));
          }
          break;
        case "Confuse":
          opponent.confuse();
          break;
        case "ConfuseAndRaiseAtk":
          opponent.confuse();
          opponent.raiseAttackByStage(2);
          break;
        case "LowerOpSpD":
          opponent.raiseSpecialDefenseByStage(-1);
          break;
        case "LowerOpSp2Stages":
          opponent.raiseSpeedByStage(-1);
          break;
        case "LowerOpSpA":
          opponent.raiseSpecialAttackByStage(-1);
          break;
        case "LowerOpSpeed":
          opponent.raiseSpeedByStage(-1);
          break;
        case "LowerOpDef":
          opponent.raiseDefenseByStage(-1);
          break;
        case "LowerOpAtk":
          opponent.raiseAttackByStage(-1);
          break;
        case "Flinch":
          opponent.setFlinch(true);
          break;
        case "Switch":
          if (self.getOwner() instanceof Player) {
            field.switchPokemon(new Scanner(System.in), true);
          } else {
            self.getOwner().switchPokemon(self.getOwner().whoToSwitchIn(opponent, field), opponent, field);
          }
          
          break;
        case "KnockOff":
          if (opponent.getHeldItem() != null) {
            if (opponent.getHeldItem().canKnockOff()) {
              Item t = opponent.removeHeldItem();
              if (t != null) {
              System.out.println(self.getNickname() + " knocked off the opponent's " + t.getName());
              }
            }
          }
          break;
      }
    }
  }

  
/**
 *  Gets element type of the move (i.e. fire, water, etc.)
 *
 *  @return Element of the move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getType() {
    return ELEMENT;
  }

  
/**
 *  Gets whether a move is physical, special, or status
 *
 *  @return Move type
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public MoveType getMoveType() {
    return TYPE;
  }

  
/**
 *  Gets max pp of the move
 *
 *  @return Max move PP
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getPP() {
    return PP;
  }

  
/**
 *  Gets accuracy of the move
 *
 *  @return Accuracy of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public double getAccuracy() {
    return ACCURACY;
  }

  
/**
 *  Gets name of the move
 *
 *  @return Name of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return NAME;
  }

  
/**
 *  Gets priority of the move
 *
 *  @return Priority of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getPriority() {
    return PRIORITY;
  }

  
/**
 *  returns string that says information on the move, including pp, name, type, base power, accuraacy, etc.
 *
 *  @param p Converts pokemon information into a string
 *  @return Informative string described above
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String toString(Pokemon p) {
    return NAME + "\nType:" + ELEMENT + "\tPP:" + p.getMovePP(p.getMoveIndex(this)) + "/" + PP + "\nBase Power: " + BASE_POWER + "\tCategory:" + TYPE + "\nAccuracy: " + (ACCURACY * 100) + "%\n" + DESCRIPTION;
  }

  
/**
 *  returns string that says information on the move, including pp, name, type, base power, accuraacy, etc.
 *
 *  @return Informative string described aboe
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String toString() {
    return NAME + "\nType:" + ELEMENT + "\tPP:"+ PP + "\nBase Power: " + BASE_POWER + "\tCategory:" + TYPE + "\nAccuracy: " + (ACCURACY * 100) + "%\n" + DESCRIPTION;
  }

  
/**
 *  returns description of the move in-game
 *
 *  @return Description of move in game
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getDescription() {
    return DESCRIPTION;
  }

  
/**
 *  returns whether a move is a contact move
 *
 *  @return True or false if move is contact move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isContactMove() {
    return contains(FLAGS, "MakesContact");
  }

  
/**
 *  returns whether a move is a pulse move. i.e. water pulse, aura sphere
 *
 *  @param True if pulse move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isPulseMove() {
    return contains(FLAGS, "PulseMove");
  }

  
/**
 *  returns whether a move is a sound move. i.e. hyper voice, boomburst
 *
 *  @return True if sound move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean isSoundMove() {
    return contains(FLAGS, "Sound");
  }

  
/**
 *  returns whether a move has a certain tag
 *
 *  @param s The specific tag
 *  @return True if it has specific tag
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean hasTag(String s) {
    return contains(FLAGS, s);
  }

  
/**
 *  returns whether the move has a side effect
 *
 *  @return Special side effect
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean hasSideEffect() {
    return !(SPECIAL_EFFECT.equals(""));
  }

  
/**
 *  sets the type of a move
 *
 *  @param t New type of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setType(Type t) {
    ELEMENT = t;
  }

  
/**
 *  gets the original type of the move. used in situations like when the pokemon has the ability pixilate or aerilate (changes normal moves to fairy/flying)
 *
 *  @return Original type of move
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getOriginalType() {
    return ORIGINAL_TYPE;
  }

  
}