import java.util.*;

/**
 *  Enum defining the species present in the game. Each species has a pokedex number, name, type, base stats, abilities, movesets, etc.
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Species {
  
  VENUSAUR(3, "Venusaur", Type.GRASS, Type.POISON, new int[]{80,82,83,100,100,80}, 236, new int[]{0,0,0,2,1,0}, 50, new Ability[]{Ability.OVERGROW}, new Ability[] {Ability.CHLOROPHYLL}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.LEECHSEED,11,Move.RAZORLEAF,12,Move.POISONPOWDER,20,Move.GIGADRAIN,40,Move.SLUDGEBOMB,50,Move.SOLARBEAM}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB, Move.GIGADRAIN)), 0.7, 6.9, "Seed", "Huge amounts of pollen burst from it with the force of a volcanic eruption. Breathing in too much of the pollen can cause fainting.", null, null, 45, new Forms[] {Forms.MEGAVENUSAUR}),

  IVYSAUR(2, "Ivysaur", Type.GRASS, Type.POISON, new int[]{60,62,63,80,80,60}, 142, new int[]{0,0,0,1,1,0}, 50, new Ability[]{Ability.OVERGROW}, new Ability[] {Ability.CHLOROPHYLL}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.LEECHSEED,11,Move.RAZORLEAF,12,Move.POISONPOWDER,20,Move.GIGADRAIN,40,Move.SLUDGEBOMB,50,Move.SOLARBEAM}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB, Move.GIGADRAIN)), 0.7, 6.9, "Seed", "When the bud on its back starts swelling, a sweet aroma wafts to indicate the flower's coming bloom.", Species.VENUSAUR, new Object[]{"Level",36}, 45, null),
  
  BULBASAUR(1, "Bulbasaur", Type.GRASS, Type.POISON, new int[]{45,49,49,65,65,45}, 64, new int[]{0,0,0,1,0,0}, 50, new Ability[]{Ability.OVERGROW}, new Ability[] {Ability.CHLOROPHYLL}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.LEECHSEED,11,Move.RAZORLEAF,12,Move.POISONPOWDER,20,Move.GIGADRAIN,50,Move.SOLARBEAM}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM)), 0.7, 6.9, "Seed", "For some time after its birth, it grows by taking nourishment from the seed on its back.", Species.IVYSAUR, new Object[]{"Level",16}, 45, null),

  CHARIZARD(6, "Charizard", Type.FIRE, Type.FLYING, new int[]{78,84,78,100,109,85}, 240, new int[]{0,0,0,0,3,0}, 50, new Ability[]{Ability.BLAZE}, new Ability[] {Ability.SOLARPOWER}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.EMBER,10,Move.SOLARBEAM,17,Move.DRAGONBREATH,20,Move.NASTYPLOT,40,Move.FLAMETHROWER,50,Move.HURRICANE}, new HashSet<Move>(Arrays.asList(Move.HURRICANE, Move.FIREBLAST, Move.ROOST, Move.FOCUSBLAST, Move.WINGATTACK)), 0.7, 6.9, "Flame", "Charizard flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything. However, it never turns its fiery breath on any opponent weaker than itself.", null, null, 45, new Forms[] {Forms.MEGACHARIZARDY, Forms.MEGACHARIZARDX}),

  CHARMELEON(5, "Charmeleon", Type.FIRE, null, new int[]{58,64,58,80,80,65}, 64, new int[]{0,0,0,1,1,0}, 142, new Ability[]{Ability.BLAZE}, new Ability[] {Ability.SOLARPOWER}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.EMBER,10,Move.SOLARBEAM,17,Move.DRAGONBREATH,20,Move.FIREFANG,40,Move.FLAMETHROWER}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER)), 0.7, 6.9, "Flame", "Tough fights could excite this Pokémon. When excited, it may breathe out bluish-white flames.",Species.CHARIZARD, new Object[]{"Level",36}, 45, null),
  
  CHARMANDER(4, "Charmander", Type.FIRE, null, new int[]{39,52,43,65,60,50}, 64, new int[]{0,0,0,1,0,0}, 50, new Ability[]{Ability.BLAZE}, new Ability[] {Ability.SOLARPOWER}, new Object[] {1, Move.TACKLE, 5, Move.GROWTH,6, Move.EMBER,10,Move.SOLARBEAM,17,Move.DRAGONBREATH,20,Move.FIREFANG,40,Move.FLAMETHROWER}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM)), 0.7, 6.9, "Lizard", "The flame on its tail shows the strength of its life force. If it is weak, the flame also burns weakly.", Species.CHARMELEON, new Object[]{"Level",16}, 45, null),

  BLASTOISE(9, "Blastoise", Type.WATER, null, new int[]{79,83,100,85,105,78}, 64, new int[]{0,0,0,0,3,0}, 240, new Ability[]{Ability.TORRENT}, new Ability[] {Ability.RAINDISH}, new Object[] {1, Move.TACKLE, 5, Move.WATERGUN,6, Move.FLASHCANNON,30,Move.AQUATAIL,35,Move.SHELLSMASH,42,Move.IRONDEFENSE,49,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLASHCANNON,Move.AQUATAIL,Move.SURF,Move.BLIZZARD)), 0.7, 6.9, "Shellfish", "The pressurized water jets on this brutal Pokémon's shell are used for high-speed tackles.", null, null, 45, new Forms[] {Forms.MEGABLASTOISE}),

  WARTORTLE(8, "Wartortle", Type.WATER, null, new int[]{59,63,80,65,80,58}, 64, new int[]{0,0,1,0,1,0}, 142, new Ability[]{Ability.TORRENT}, new Ability[] {Ability.RAINDISH}, new Object[] {1, Move.TACKLE, 5, Move.WATERGUN,6, Move.FLASHCANNON,30,Move.AQUATAIL,35,Move.SHELLSMASH,42,Move.IRONDEFENSE,49,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLASHCANNON,Move.AQUATAIL,Move.SURF)), 0.7, 6.9, "Turtle", "It is said to live 10,000 years. Its furry tail is popular as a symbol of longevity.", Species.BLASTOISE, new Object[]{"Level",36}, 45, null),

  SQUIRTLE(7, "Squirtle", Type.WATER, null, new int[]{44,48,65,50,64,43}, 64, new int[]{0,0,1,0,0,0}, 50, new Ability[]{Ability.TORRENT}, new Ability[] {Ability.RAINDISH}, new Object[] {1, Move.TACKLE, 5, Move.WATERGUN,6, Move.FLASHCANNON,30,Move.AQUATAIL,35,Move.SHELLSMASH,42,Move.IRONDEFENSE,49,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLASHCANNON,Move.AQUATAIL,Move.SURF)), 0.7, 6.9, "Tiny Turtle", "Shoots water at prey while in the water. Withdraws into its shell when in danger.", Species.WARTORTLE, new Object[]{"Level",16}, 45, null),

  PIDGEOT(18, "Pidgeot", Type.NORMAL, Type.FLYING, new int[]{83,80,75,70,70,101}, 64, new int[]{0,0,0,0,0,3}, 50, new Ability[]{Ability.KEENEYE, Ability.TANGLEDFEET}, new Ability[] {Ability.BIGPECKS}, new Object[] {1, Move.TACKLE, 5, Move.GUST,6, Move.WINGATTACK,30,Move.ROOST,35,Move.DOUBLEEDGE,42,Move.AERIALACE,49,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.HURRICANE, Move.HEATWAVE,Move.AERIALACE,Move.DOUBLEEDGE,Move.HYPERBEAM,Move.GIGAIMPACT)), 0.7, 6.9, "Bird", "It spreads its gorgeous wings widely to intimidate enemies. It races through the skies at Mach-2 speed.", null, null, 45, new Forms[] {Forms.MEGAPIDGEOT}),

  PIDGEOTTO(17, "Pidgeotto", Type.NORMAL, Type.FLYING, new int[]{40,45,40,35,35,56}, 122, new int[]{0,0,0,0,0,1}, 50, new Ability[]{Ability.KEENEYE, Ability.TANGLEDFEET}, new Ability[] {Ability.BIGPECKS}, new Object[] {1, Move.TACKLE, 5, Move.WATERGUN,6, Move.FLASHCANNON,30,Move.AQUATAIL,35,Move.SHELLSMASH,42,Move.IRONDEFENSE,49,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.HURRICANE, Move.HEATWAVE,Move.AERIALACE,Move.DOUBLEEDGE, Move.HYPERBEAM,Move.GIGAIMPACT)), 0.7, 6.9, "Bird", "Very protective of its sprawling territorial area, this PokÃ©mon will fiercely peck at any intruder.", Species.PIDGEOT, new Object[]{"Level",36}, 120, null),

  PIDGEY(16, "Pidgey", Type.NORMAL, Type.FLYING, new int[]{40,45,40,35,35,56}, 64, new int[]{0,0,0,0,0,1}, 50, new Ability[]{Ability.KEENEYE, Ability.TANGLEDFEET}, new Ability[] {Ability.BIGPECKS}, new Object[] {1, Move.TACKLE, 5, Move.QUICKATTACK,6, Move.FLASHCANNON,30,Move.WINGATTACK,35,Move.AERIALACE,42,Move.HURRICANE,49,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.HURRICANE, Move.HEATWAVE,Move.AERIALACE,Move.DOUBLEEDGE,Move.HYPERBEAM,Move.GIGAIMPACT)), 0.7, 6.9, "Tiny Bird", "It is docile and prefers to avoid conflict. If disturbed, however, it can ferociously strike back.", Species.PIDGEOTTO, new Object[]{"Level",18}, 255, null),

  RAICHU(26, "Raichu", Type.ELECTRIC, null, new int[]{60,90,55,90,80,110}, 218, new int[]{0,0,0,0,0,3}, 50, new Ability[]{Ability.STATIC, Ability.LIGHTNINGROD}, new Ability[] {}, new Object[] {1, Move.NASTYPLOT,2,Move.THUNDERSHOCK,4,Move.THUNDERWAVE,5, Move.QUICKATTACK,6,Move.GROWL,30,Move.AGILITY,35,Move.DISCHARGE,36,Move.THUNDERBOLT,44,Move.THUNDER}, new HashSet<Move>(Arrays.asList(Move.THUNDER, Move.THUNDERBOLT,Move.QUICKATTACK,Move.IRONTAIL)), 0.4, 6.0, "Mouse", "It can loose 100,000-volt bursts of electricity, instantly downing foes several times its size.", null, null, 75, null),

  PIKACHU(25, "Pikachu", Type.ELECTRIC, null, new int[]{35,55,40,50,50,90}, 112, new int[]{0,0,0,0,0,2}, 50, new Ability[]{Ability.STATIC, Ability.LIGHTNINGROD}, new Ability[] {}, new Object[] {1, Move.NASTYPLOT,2,Move.THUNDERSHOCK,4,Move.THUNDERWAVE,5, Move.QUICKATTACK,6,Move.GROWL,30,Move.AGILITY,35,Move.DISCHARGE,36,Move.THUNDERBOLT,44,Move.THUNDER}, new HashSet<Move>(Arrays.asList(Move.THUNDER, Move.THUNDERBOLT,Move.QUICKATTACK,Move.IRONTAIL)), 0.4, 6.0, "Mouse", "It has small electric sacs on both its cheeks. If threatened, it looses electric charges from the sacs.", Species.RAICHU, new Object[]{"Item",Item.THUNDERSTONE}, 190, null),

  NIDOQUEEN(31, "Nidoqueen", Type.POISON, Type.GROUND, new int[]{90,92,87,75,85,76}, 225, new int[]{3,0,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.EARTHPOWER,48,Move.EARTHQUAKE,54,Move.SLUDGEBOMB}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.FLAMETHROWER,Move.ICEBEAM, Move.STEALTHROCK, Move.STONEEDGE)), 1.3, 6.0, "Drill", "It pacifies offspring by placing them in the gaps between the spines on its back. The spines will never secrete poison while young are present.", null, null, 45, null),

  NIDOKING(34, "Nidoking", Type.POISON, Type.GROUND, new int[]{81,102,77,85,75,85}, 225, new int[]{0,3,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.EARTHPOWER,48,Move.EARTHQUAKE,54,Move.SLUDGEBOMB}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.FLAMETHROWER,Move.ICEBEAM, Move.STEALTHROCK, Move.STONEEDGE)), 1.3, 6.0, "Drill", "One swing of its mighty tail can snap a telephone pole as if it were a matchstick.", null, null, 45, null),

  NIDORINO(33, "Nidorino", Type.POISON, null, new int[]{61,72,57,55,55,65}, 128, new int[]{0,2,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.EARTHPOWER,48,Move.EARTHQUAKE,54,Move.SLUDGEBOMB}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.EARTHQUAKE,Move.BULLDOZE)), 1.3, 6.0, "Poison Pin", "It's nervous and quick to act aggressively. The potency of its poison increases along with the level of adrenaline present in its body.", Species.NIDOKING, new Object[] {"Item", Item.MOONSTONE}, 120, null),

  NIDORINA(30, "Nidorina", Type.POISON, null, new int[]{70,62,67,55,55,56}, 128, new int[]{2,0,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.SCRATCH, 2,Move.GROWL,5, Move.BITE,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,22,Move.TOXICSPIKES,50,Move.TOXIC,48,Move.EARTHQUAKE,64,Move.CRUNCH,71,Move.EARTHPOWER}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.EARTHQUAKE,Move.BULLDOZE)), 1.3, 6.0, "Poison Pin", "If the group is threatened, these Pokémon will band together to assault enemies with a chorus of ultrasonic waves.", Species.NIDOQUEEN, new Object[] {"Item", Item.MOONSTONE}, 120, null),

  NIDORANF(29, "Nidoran", Type.POISON, null, new int[]{55,47,52,40,40,41}, 225, new int[]{1,0,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.SCRATCH, 2,Move.GROWL,5, Move.BITE,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,22,Move.TOXICSPIKES,40,Move.TOXIC,50,Move.CRUNCH,55,Move.EARTHPOWER}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.EARTHQUAKE,Move.BULLDOZE)), 1.3, 6.0, "Poison Pin", "It uses its hard incisor teeth to crush and eat berries. The tip of a female Nidoran's horn is a bit more rounded than the tip of a male's horn.", Species.NIDORINA, new Object[] {"Level", 16}, 235, null),

  NIDORAN(32, "Nidoran", Type.POISON, null, new int[]{46,57,40,40,40,50}, 225, new int[]{0,1,0,0,0,0}, 240, new Ability[]{Ability.POISONPOINT, Ability.SHEERFORCE}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.TOXIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.EARTHPOWER,48,Move.EARTHQUAKE,54,Move.SLUDGEBOMB}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.EARTHQUAKE,Move.BULLDOZE)), 1.3, 6.0, "Poison Pin", "The horn on a male Nidoran's forehead contains a powerful poison. This is a very cautious Pokémon, always straining its large ears.", Species.NIDORINO, new Object[] {"Level", 16}, 235, null),

  GENGAR(94, "Gengar", Type.GHOST, Type.POISON, new int[]{60,65,60,130,75,110}, 225, new int[]{0,0,0,3,0,0}, 240, new Ability[]{Ability.LEVITATE}, new Ability[] {Ability.LEVITATE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.PSYCHIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.DARKPULSE,48,Move.SHADOWBALL,54,Move.DESTINYBOND}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.DARKPULSE,Move.SHADOWBALL, Move.HYPERBEAM, Move.PSYCHIC, Move.THUNDERBOLT, Move.THUNDERWAVE)), 1.5, 40.5, "Shadow", "Hiding in people's shadows at night, it absorbs their heat. The chill it causes makes the victims shake.", null, null, 45, new Forms[] {Forms.MEGAGENGAR}),

  HAUNTER(93, "Haunter", Type.GHOST, Type.POISON, new int[]{45,50,45,115,55,95}, 225, new int[]{0,0,0,2,0,0}, 240, new Ability[]{Ability.LEVITATE}, new Ability[] {Ability.LEVITATE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.PSYCHIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.DARKPULSE,48,Move.SHADOWBALL,54,Move.DESTINYBOND}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.DARKPULSE,Move.SHADOWBALL)), 0.7, 6.9, "Gas", "It licks with its gaseous tongue to steal the victim's life force. It lurks in darkness for prey.", Species.GENGAR, new Object[]{"Level",36}, 60, null),

  GASTLY(92, "Gastly", Type.GHOST, Type.POISON, new int[]{30,35,30,100,35,80}, 225, new int[]{0,0,0,1,0,0}, 240, new Ability[]{Ability.LEVITATE}, new Ability[] {Ability.LEVITATE}, new Object[] {1, Move.TACKLE, 5, Move.SUCKERPUNCH,6, Move.PSYCHIC,30,Move.CONFUSERAY,36,Move.SLUDGEBOMB,42,Move.DARKPULSE,48,Move.SHADOWBALL,54,Move.DESTINYBOND}, new HashSet<Move>(Arrays.asList(Move.SLUDGEBOMB,Move.DARKPULSE,Move.SHADOWBALL)), 0.7, 6.9, "Gas", "Born from gases, anyone would faint if engulfed by its gaseous body, which contains poison.", Species.HAUNTER, new Object[]{"Level",16}, 190, null),

  GYARADOS(130, "Gyarados", Type.WATER, Type.FLYING, new int[]{95,125,79,60,100,81}, 225, new int[]{0,2,0,0,0,0}, 240, new Ability[]{Ability.INTIMIDATE, Ability.MOXIE}, new Ability[] {}, new Object[] {1, Move.TACKLE, 5, Move.EARTHQUAKE,6, Move.TOXIC,30,Move.WATERFALL,36,Move.CRUNCH,44,Move.HURRICANE,32,Move.AQUATAIL,52,Move.HYPERBEAM}, new HashSet<Move>(Arrays.asList(Move.HURRICANE,Move.CRUNCH,Move.WATERFALL,Move.EARTHQUAKE,Move.DRAGONDANCE,Move.ICEFANG,Move.FIREFANG,Move.THUNDERFANG,Move.RAINDANCE)), 6.5, 235.0, "Atrocious", "Rarely seen in the wild. Huge and vicious, it is capable of destroying entire cities in a rage.", null, null, 45, null),

  MAGIKARP(129, "Magikarp", Type.WATER, null, new int[]{20,10,55,15,20,80}, 40, new int[]{0,0,0,0,0,1}, 240, new Ability[]{Ability.SWIFTSWIM, Ability.RATTLED}, new Ability[] {}, new Object[] {1, Move.SPLASH,15,Move.TACKLE,30,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.HURRICANE,Move.CRUNCH,Move.WATERFALL)), 6.5, 235.0, "Fish", "In the distant past, it was somewhat stronger than the horribly weak descendants that exist today.", Species.GYARADOS, new Object[] {"Level", 20}, 255, null),

  LAPRAS(131, "Lapras", Type.WATER, Type.ICE, new int[]{130,85,80,85,95,60}, 187, new int[]{2,0,0,0,0,0}, 50, new Ability[]{Ability.WATERABSORB, Ability.RATTLED}, new Ability[] {}, new Object[] {1, Move.GROWL,2,Move.WATERGUN,20,Move.ICESHARD,30,Move.WATERPULSE,35,Move.CONFUSERAY,40,Move.BODYSLAM,45,Move.ICEBEAM,50,Move.RAINDANCE,55,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.HYDROPUMP,Move.SURF,Move.WATERFALL, Move.BLIZZARD,Move.ICEBEAM,Move.PSYCHIC,Move.THUNDERBOLT,Move.DRAGONDANCE,Move.DRAGONPULSE,Move.ANCIENTPOWER)), 6.5, 235.0, "Transport", "Its high intelligence enables it to understand human speech. It likes to ferry people on its back.", null, null, 45, null),
  
  ARTICUNO(144, "Articuno", Type.ICE, Type.FLYING, new int[]{90,85,100,95,125,85}, 261, new int[]{0,0,0,0,3,0}, 50, new Ability[]{Ability.PRESSURE}, new Ability[] {Ability.SNOWCLOAK}, new Object[] {1, Move.GUST, 5,Move.POWDERSNOW,6, Move.HURRICANE,10,Move.ICEBEAM,15,Move.ICESHARD,40,Move.ROOST,25,Move.ANCIENTPOWER,45,Move.ICEBEAM,50,Move.NASTYPLOT,65,Move.BLIZZARD}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.BLIZZARD,Move.HURRICANE,Move.ROOST,Move.AIRSLASH)), 1.7, 55.4, "Freeze", "This legendary bird Pokémon can create blizzards by freezing moisture in the air.", null, null, 3, null),
  
  ZAPDOS(145, "Zapdos", Type.ELECTRIC, Type.FLYING, new int[]{90,90,85,100,125,90}, 261, new int[]{0,0,0,0,3,0}, 50, new Ability[]{Ability.PRESSURE}, new Ability[] {Ability.STATIC}, new Object[] {1, Move.TACKLE, 5, Move.FLAMETHROWER,6, Move.HURRICANE,10,Move.THUNDERBOLT,20,Move.RECOVER,50,Move.NASTYPLOT}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT,Move.RAINDANCE,Move.HURRICANE,Move.THUNDER,Move.AIRSLASH,Move.ROOST,Move.THUNDERWAVE,Move.HEATWAVE,Move.RAINDANCE)), 1.7, 55.4, "Electric", "This legendary bird Pokémon is said to appear only when a thundercloud parts into two halves.", null, null, 3, null),
  
  MOLTRES(146, "Moltres", Type.FIRE, Type.FLYING, new int[]{90,100,90,90,125,85}, 261, new int[]{0,0,0,0,3,0}, 50, new Ability[]{Ability.PRESSURE}, new Ability[] {Ability.FLAMEBODY}, new Object[] {1, Move.EMBER, 5, Move.FLAMETHROWER,6, Move.HURRICANE,10,Move.FLAMETHROWER,20,Move.RECOVER,50,Move.NASTYPLOT}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER,Move.FIREBLAST,Move.SUNNYDAY,Move.ROOST,Move.HURRICANE,Move.AIRSLASH)), 1.7, 55.4, "Flame", "Moltres is a legendary bird Pokémon that has the ability to control fire. If this Pokémon is injured, it is said to dip its body in the molten magma of a volcano to burn and heal itself.", null, null, 3, null),

  URSARING(217, "Ursaring", Type.NORMAL, null, new int[]{90,130,75,75,75,55}, 306, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.GUTS}, new Ability[] {}, new Object[] {1, Move.HAMMERARM,2,Move.SCRATCH,3,Move.LEER, 15, Move.SLASH,33,Move.EARTHQUAKE,37,Move.DOUBLEEDGE,52,Move.HYPERBEAM,59,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.CLOSECOMBAT, Move.DRAINPUNCH, Move.EARTHQUAKE, Move.ICEPUNCH, Move.THUNDERPUNCH, Move.FIREPUNCH, Move.HYPERBEAM, Move.GIGAIMPACT)), 5.2, 216.0, "Hibernator", "Although it has a large body, it is quite skilled at climbing trees. It eats and sleeps in the treetops.", null, null, 60, null),

  TEDDIURSA(216, "Teddiursa", Type.NORMAL, null, new int[]{60,80,50,50,50,40}, 306, new int[]{0,1,0,0,0,0}, 70, new Ability[]{Ability.GUTS}, new Ability[] {}, new Object[] {1, Move.HAMMERARM,2,Move.SCRATCH,3,Move.LEER, 15, Move.SLASH,33,Move.EARTHQUAKE,37,Move.DOUBLEEDGE,52,Move.HYPERBEAM,59,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.CLOSECOMBAT, Move.DRAINPUNCH, Move.EARTHQUAKE, Move.ICEPUNCH, Move.THUNDERPUNCH, Move.FIREPUNCH, Move.HYPERBEAM, Move.GIGAIMPACT)), 0.6, 8.8, "Little Bear", "Before food becomes scarce in wintertime, its habit is to hoard food in many hidden locations.", Species.URSARING, new Object[] {"Level",30}, 120, null),

  TYRANITAR(248, "Tyranitar", Type.ROCK, Type.DARK, new int[]{100,134,110,95,100,61}, 306, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.SANDSTREAM}, new Ability[] {}, new Object[] {1, Move.THUNDERFANG,2,Move.ICEFANG,3,Move.FIREFANG, 15, Move.ROCKSLIDE,24,Move.DARKPULSE,33,Move.EARTHQUAKE,37,Move.STONEEDGE,47,Move.SANDSTORM,52,Move.HYPERBEAM,59,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.ICEBEAM, Move.ROCKSLIDE, Move.EARTHQUAKE, Move.ICEPUNCH, Move.THUNDERPUNCH, Move.FIREPUNCH, Move.STONEEDGE, Move.HYPERBEAM, Move.GIGAIMPACT, Move.THUNDERWAVE, Move.KNOCKOFF,Move.SANDSTORM)), 5.2, 216.0, "Armor", "If it rampages, it knocks down mountains and buries rivers. Maps must be redrawn afterward.", null, null, 45, new Forms[] {Forms.MEGATYRANITAR}),

  PUPITAR(247, "Pupitar", Type.ROCK, Type.GROUND, new int[]{70,84,70,65,70,51}, 144, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.SANDSTREAM}, new Ability[] {}, new Object[] {1, Move.IRONDEFENSE,2,Move.TACKLE,3,Move.LEER, 15, Move.ROCKSLIDE,33,Move.EARTHQUAKE,37,Move.STONEEDGE,52,Move.HYPERBEAM,59,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.ROCKSLIDE, Move.EARTHQUAKE, Move.STONEEDGE, Move.HYPERBEAM, Move.GIGAIMPACT, Move.THUNDERWAVE, Move.KNOCKOFF)), 1.2, 152.0, "Hard Shell", "Its shell is as hard as sheet rock, and it is also very strong. Its thrashing can topple a mountain.", Species.TYRANITAR, new Object[] {"Level",55}, 45, null),

  LARVITAR(246, "Larvitar", Type.ROCK, Type.GROUND, new int[]{50,64,50,45,50,41}, 60, new int[]{0,1,0,0,0,0}, 35, new Ability[]{Ability.GUTS}, new Ability[] {}, new Object[] {1, Move.TACKLE,2,Move.LEER,3,Move.BITE, 15, Move.ROCKSLIDE,33,Move.EARTHQUAKE,37,Move.STONEEDGE,52,Move.HYPERBEAM,59,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.ROCKSLIDE, Move.EARTHQUAKE, Move.ICEPUNCH, Move.THUNDERPUNCH, Move.FIREPUNCH, Move.STONEEDGE, Move.HYPERBEAM, Move.GIGAIMPACT, Move.THUNDERWAVE)), 0.6, 72.0, "Rock Skin", "Born deep underground, it comes aboveground and becomes a pupa once it has finished eating the surrounding soil.", Species.PUPITAR, new Object[] {"Level",30}, 45, null),
  
  LUGIA(249, "Lugia", Type.PSYCHIC, Type.FLYING, new int[]{106,90,130,90,154,110}, 306, new int[]{0,0,0,0,3,0}, 0, new Ability[]{Ability.MULTISCALE}, new Ability[] {Ability.MULTISCALE}, new Object[] {1, Move.EMBER,27,Move.CALMMIND,30,Move.AEROBLAST,10,Move.PSYCHIC,45,Move.RECOVER,72,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.SURF)), 5.2, 216.0, "Diving", "It is said to be the guardian of the seas. It is rumored to have been seen on the night of a storm.", null, null, 3, null),
  
  HOOH(250, "Ho-Oh", Type.FIRE, Type.FLYING, new int[]{106,130,90,110,154,90}, 306, new int[]{0,0,0,0,3,0}, 0, new Ability[]{Ability.REGENERATOR}, new Ability[] {Ability.REGENERATOR}, new Object[] {1, Move.EMBER,20,Move.FLAMETHROWER,27,Move.CALMMIND,30, Move.BRAVEBIRD,45,Move.RECOVER,54,Move.SACREDFIRE,72,Move.FIREBLAST}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.SURF)), 5.2, 216.0, "Rainbow", "It will reveal itself before a pure-hearted trainer by shining its bright rainbow-colored wings.", null, null, 3, null),

  BRELOOM(286, "Breloom", Type.GRASS, Type.FIGHTING, new int[]{60,130,80,60,60,70}, 161, new int[]{0,2,0,0,0,0}, 70, new Ability[]{Ability.POISONHEAL, Ability.TECHNICIAN}, new Ability[] {}, new Object[] {1,Move.MACHPUNCH,2,Move.TACKLE,3,Move.LEECHSEED,20,Move.MEGADRAIN,27,Move.IRONHEAD,30,Move.CRUNCH,33,Move.SPORE,55,Move.BULLETSEED,50,Move.FORCEPALM}, new HashSet<Move>(Arrays.asList(Move.STONEEDGE, Move.CLOSECOMBAT, Move.ROCKTOMB, Move.GIGADRAIN, Move.KNOCKOFF, Move.SPORE, Move.DRAINPUNCH, Move.GIGAIMPACT, Move.TOXIC)), 5.2, 216.0, "Mushroom", "It scatters poisonous spores and throws powerful punches while its foe is hampered by inhaled spores.", null, null, 90, null),

  SHROOMISH(285, "Shroomish", Type.GRASS, null, new int[]{60,40,60,40,60,35}, 59, new int[]{1,0,0,0,0,0}, 70, new Ability[]{Ability.POISONHEAL, Ability.TECHNICIAN}, new Ability[] {}, new Object[] {1,Move.POISONPOWDER,2,Move.TACKLE,3,Move.LEECHSEED,20,Move.MEGADRAIN,27,Move.IRONHEAD,30,Move.CRUNCH,33,Move.TOXIC,55,Move.BULLETSEED,50,Move.SPORE}, new HashSet<Move>(Arrays.asList(Move.STONEEDGE, Move.CLOSECOMBAT, Move.ROCKTOMB, Move.GIGADRAIN, Move.KNOCKOFF)), 5.2, 216.0, "Mushroom", "It spouts poison spores from the top of its head. These spores cause pain all over if inhaled.", Species.BRELOOM, new Object[] {"Level",23}, 255, null),

  AGGRON(306, "Aggron", Type.STEEL, Type.ROCK, new int[]{70,110,180,60,60,50}, 270, new int[]{0,0,3,0,0,0}, 0, new Ability[]{Ability.STURDY, Ability.ROCKHEAD}, new Ability[] {Ability.ROCKHEAD}, new Object[] {1, Move.STEALTHROCK,20,Move.IRONTAIL,27,Move.IRONHEAD,30, Move.CRUNCH,33,Move.STONEEDGE,55,Move.HEADSMASH,73,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.STONEEDGE, Move.HEADSMASH, Move.EARTHQUAKE)), 5.2, 216.0, "Iron Armor", "Long ago, there was a king who wore a helmet meant to resemble the head of an Aggron. He was trying to channel the Pokémon's strength.", null, null, 45, new Forms[] {Forms.MEGAAGGRON}),

  LAIRON(305, "Lairon", Type.STEEL, Type.ROCK, new int[]{60,90,140,50,50,40}, 151, new int[]{0,0,2,0,0,0}, 0, new Ability[]{Ability.STURDY, Ability.ROCKHEAD}, new Ability[] {Ability.ROCKHEAD}, new Object[] {1, Move.TACKLE,20,Move.IRONTAIL,27,Move.IRONHEAD,30, Move.CRUNCH,33,Move.STONEEDGE,55,Move.HEADSMASH,73,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.STONEEDGE, Move.HEADSMASH, Move.EARTHQUAKE)), 0.9, 120.0, "Iron Armor", "During territorial disputes, Lairon fight by slamming into each other. Close inspection of their steel armor reveals scratches and dents.", Species.AGGRON, new Object[] {"Level",42}, 90, null),

  ARON(304, "Aron", Type.STEEL, Type.ROCK, new int[]{50,70,100,40,40,30}, 151, new int[]{0,0,1,0,0,0}, 0, new Ability[]{Ability.STURDY, Ability.ROCKHEAD}, new Ability[] {Ability.ROCKHEAD}, new Object[] {1, Move.TACKLE,20,Move.IRONTAIL,27,Move.IRONHEAD,30, Move.CRUNCH,33,Move.STONEEDGE,55,Move.HEADSMASH,73,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.STONEEDGE, Move.HEADSMASH, Move.EARTHQUAKE)), 0.9, 120.0, "Iron Armor", "When Aron evolves, its steel armor peels off. In ancient times, people would collect Aron's shed armor and make good use of it in their daily lives.", Species.LAIRON, new Object[] {"Level",32}, 180, null),

  ALTARIA(334, "Altaria", Type.DRAGON, Type.FLYING, new int[]{75,70,90,70,105,80}, 270, new int[]{0,0,0,0,2,0}, 0, new Ability[]{Ability.NATURALCURE}, new Ability[] {}, new Object[] {1, Move.WINGATTACK,20,Move.FLAMETHROWER,27,Move.ROOST,30, Move.DRAGONPULSE,33,Move.STONEEDGE,44,Move.MOONBLAST,73,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.DRAGONDANCE, Move.DRAGONCLAW, Move.EARTHQUAKE, Move.DOUBLEEDGE)), 5.2, 216.0, "Humming", "This Pokémon has a kind disposition, but if it's provoked, it will threaten opponents with shrill cries before attacking them without mercy.", null, null, 45, new Forms[] {Forms.MEGAALTARIA}),

  SWABLU(333, "Swablu", Type.NORMAL, Type.FLYING, new int[]{45,40,60,40,75,50}, 270, new int[]{0,0,0,0,1,0}, 0, new Ability[]{Ability.NATURALCURE}, new Ability[] {}, new Object[] {1, Move.WINGATTACK,20,Move.FLAMETHROWER,27,Move.ROOST,30, Move.DRAGONPULSE,33,Move.STONEEDGE,44,Move.MOONBLAST,73,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.DRAGONDANCE, Move.DRAGONCLAW, Move.EARTHQUAKE, Move.DOUBLEEDGE)), 5.2, 216.0, "Cotton Bird", "Its cottony wings are full of air, making them light and fluffy to the touch. Swablu takes diligent care of its wings.", Species.ALTARIA, new Object[] {"Level",35}, 255, null),

  FLYGON(330, "Flygon", Type.GROUND, Type.DRAGON, new int[]{80,100,80,80,80,100}, 270, new int[]{0,1,0,0,0,2}, 0, new Ability[]{Ability.LEVITATE}, new Ability[] {}, new Object[] {1, Move.DRAGONCLAW,2,Move.DRAGONBREATH,3,Move.DRAGONDANCE,30, Move.CRUNCH,33,Move.DRAGONCLAW,40, Move.DRAKONVOICE,55,Move.FLAMETHROWER,60,Move.DRAGONRUSH}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.HYDROPUMP, Move.DRACOMETEOR, Move.OUTRAGE, Move.EARTHPOWER, Move.BUGBUZZ, Move.BOOMBURST, Move.FIREBLAST, Move.DRAKONVOICE, Move.ROCKSLIDE, Move.STONEEDGE, Move.DRAGONDANCE, Move.UTURN, Move.EARTHQUAKE)), 2.0, 82.0, "Mystic", "Known as 'The Desert Spirit,' this Pokémon hides in the sandstorms it causes by beating its wings.", null, null, 45, new Forms[] {Forms.MEGAFLYGON}),

  VIBRAVA(329, "Virbrava", Type.GROUND, Type.DRAGON, new int[]{50,70,50,50,50,70}, 270, new int[]{0,1,0,0,0,1}, 0, new Ability[]{Ability.LEVITATE}, new Ability[] {}, new Object[] {1, Move.DRAGONCLAW,2,Move.DRAGONBREATH,3,Move.DRAGONDANCE,30, Move.CRUNCH,33,Move.DRAGONCLAW,55,Move.FLAMETHROWER,60,Move.DRAGONRUSH}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.HYDROPUMP, Move.DRACOMETEOR, Move.OUTRAGE)), 1.1, 15.3, "Vibration", "It generates ultrasonic waves by violently flapping its wings. After making its prey faint, it melts the prey with acid.", Species.FLYGON, new Object[] {"Level",45}, 45, null),

  TRAPINCH(328, "Trapinch", Type.GROUND, null, new int[]{45,100,45,45,45,10}, 270, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.ARENATRAP}, new Ability[] {}, new Object[] {1, Move.BULLDOZE,2,Move.DRAGONBREATH,3,Move.DRAGONDANCE,30, Move.CRUNCH,33,Move.DRAGONCLAW,55,Move.FLAMETHROWER,60,Move.EARTHQUAKE}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.EARTHQUAKE, Move.FLAMETHROWER, Move.DRACOMETEOR)), 0.7, 15.0, "Ant Pit", "It makes an inescapable conical pit and lies in wait at the bottom for prey to come tumbling down.", Species.VIBRAVA, new Object[] {"Level",35}, 45, null),

  SALAMENCE(373, "Salamence", Type.DRAGON, Type.FLYING, new int[]{95,135,80,110,80,100}, 270, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.INTIMIDATE}, new Ability[] {Ability.MOXIE}, new Object[] {1, Move.EMBER,2,Move.DRAGONBREATH,3,Move.BITE,4,Move.ROOST,20,Move.FLAMETHROWER,27,Move.ZENHEADBUTT,30, Move.CRUNCH,33,Move.DRAGONCLAW,55,Move.FLAMETHROWER,73,Move.DOUBLEEDGE}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.HYDROPUMP, Move.DRACOMETEOR, Move.HURRICANE, Move.CRUNCH, Move.EARTHQUAKE, Move.DRAGONDANCE)), 1.5, 102.6, "Dragon", "While basking in the joy of flight generally keeps this Pokémon in high spirits, Salamence turns into an uncontrollable menace if something angers it.", null, null, 45,  new Forms[] {Forms.MEGASALAMENCE}),

  SHELGON(372, "Shelgon", Type.DRAGON, null, new int[]{65,95,100,60,50,50}, 270, new int[]{0,0,2,0,0,0}, 0, new Ability[]{Ability.ROCKHEAD}, new Ability[] {}, new Object[] {1, Move.EMBER,2,Move.DRAGONBREATH,3,Move.BITE,20,Move.FLAMETHROWER,25,Move.CRUNCH,27,Move.ZENHEADBUTT,30, Move.CRUNCH,33,Move.DRAGONCLAW,55,Move.FLAMETHROWER,60,Move.OUTRAGE,73,Move.DOUBLEEDGE}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.OUTRAGE, Move.DRAGONCLAW, Move.SURF, Move.DRACOMETEOR)), 1.1, 110.5, "Endurance", "Shelgon ignores its hunger entirely, never eating any food. Apparently, Shelgon will evolve once all its energy stores are used up.", Species.SALAMENCE, new Object[] {"Level", 50}, 45,  null),

  BAGON(371, "Bagon", Type.DRAGON, null, new int[]{45,75,60,40,30,50}, 270, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.ROCKHEAD}, new Ability[] {Ability.SHEERFORCE}, new Object[] {1, Move.EMBER,20,Move.FLAMETHROWER,27,Move.ZENHEADBUTT,30, Move.CRUNCH,33,Move.DRAGONCLAW,45,Move.FLAMETHROWER,50,Move.OUTRAGE,55,Move.DOUBLEEDGE}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.OUTRAGE, Move.DRACOMETEOR, Move.IRONHEAD)), 5.2, 216.0, "Endurance", "Shelgon ignores its hunger entirely, never eating any food. Apparently, Shelgon will evolve once all its energy stores are used up.", Species.SHELGON, new Object[] {"Level", 30}, 45,  null),

  METAGROSS(376, "Metagross", Type.STEEL, Type.PSYCHIC, new int[]{80,135,130,95,90,70}, 270, new int[]{0,3,0,0,0,0}, 35, new Ability[]{Ability.CLEARBODY}, new Ability[] {}, new Object[] {1,Move.HAMMERARM,2,Move.CONFUSION,3,Move.METALCLAW,4,Move.BULLETPUNCH,20,Move.FLASHCANNON,27,Move.ZENHEADBUTT,30, Move.PSYCHIC,33,Move.SCARYFACE,55,Move.METEORMASH,73,Move.IRONDEFENSE}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.ICEPUNCH, Move.SWORDSDANCE, Move.THUNDERPUNCH)), 1.5, 102.6, "Iron Leg", "Metagross is the result of the fusion of two Metang. This Pokémon defeats its opponents through use of its supercomputer-level brain.", null, null, 3,  new Forms[] {Forms.MEGAMETAGROSS}),

  METANG(375, "Metang", Type.STEEL, Type.PSYCHIC, new int[]{60,75,100,55,80,50}, 147, new int[]{0,2,0,0,0,0}, 35, new Ability[]{Ability.CLEARBODY}, new Ability[] {}, new Object[] {1,Move.CONFUSION,3,Move.METALCLAW,4,Move.BULLETPUNCH,20,Move.FLASHCANNON,27,Move.ZENHEADBUTT,30, Move.PSYCHIC,33,Move.SCARYFACE,55,Move.METEORMASH,58,Move.IRONDEFENSE,66,Move.AGILITY,74,Move.HYPERBEAM}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.ICEPUNCH, Move.SWORDSDANCE, Move.THUNDERPUNCH, Move.IRONHEAD)), 1.5, 102.6, "Iron Claw", "Using magnetic forces to stay aloft, this Pokémon flies at high speeds, weaving through harsh mountain terrain in pursuit of prey.", Species.METAGROSS, new Object[] {"Level",45}, 3, null),

  BELDUM(374, "Beldum", Type.STEEL, Type.PSYCHIC, new int[]{60,75,100,55,80,50}, 147, new int[]{0,2,0,0,0,0}, 35, new Ability[]{Ability.CLEARBODY}, new Ability[] {}, new Object[] {1,Move.TACKLE}, new HashSet<Move>(Arrays.asList(Move.TACKLE)), 1.5, 102.6, "Iron Ball", "From its rear, Beldum emits a magnetic force that rapidly pulls opponents in. They get skewered on Beldum's sharp claws.", Species.METANG, new Object[] {"Level",20}, 3, null),

  KYOGRE(382, "Kyogre", Type.WATER, null, new int[]{100,100,90,150,140,90}, 302, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.DRIZZLE}, new Ability[] {}, new Object[]{1,Move.WATERPULSE,2,Move.ANCIENTPOWER,3,Move.BODYSLAM,4,Move.SCARYFACE,9,Move.AQUATAIL,18,Move.CALMMIND,36, Move.ICEBEAM,63,Move.ORIGINPULSE,72,Move.HYDROPUMP,81,Move.DOUBLEEDGE,90,Move.WATERSPOUT}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.ICEBEAM, Move.BLIZZARD, Move.THUNDER, Move.THUNDERBOLT, Move.SURF, Move.HYDROPUMP, Move.RAINDANCE)), 4.5, 352.0, "Sea Basin", "Kyogre is said to be the personification of the sea itself. Legends tell of its many clashes against Groudon, as each sought to gain the power of nature.", null, null, 3, null),

  GROUDON(383, "Groudon", Type.GROUND, null, new int[]{100,150,140,100,90,90}, 302, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.DROUGHT}, new Ability[] {}, new Object[]{1,Move.MUDSHOT,2,Move.ANCIENTPOWER,3,Move.LAVAPLUME,4,Move.SCARYFACE,9,Move.EARTHPOWER,18,Move.BULKUP,27,Move.EARTHQUAKE,36,Move.HAMMERARM,63,Move.PRECIPICEBLADES,72,Move.FIREBLAST,81,Move.SOLARBEAM,90,Move.ERUPTION}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.ICEBEAM, Move.BLIZZARD, Move.THUNDER, Move.THUNDERBOLT, Move.SURF, Move.HYDROPUMP, Move.RAINDANCE)), 4.5, 352.0, "Continent", "Groudon is said to be the personification of the land itself. Legends tell of its many clashes against Kyogre, as each sought to gain the power of nature.", null, null, 3, null),

  TORTERRA(389, "Torterra", Type.GRASS, Type.GROUND, new int[]{95,109,105,75,85,56}, 236, new int[]{0,3,0,0,0,0}, 70, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.WOODHAMMER,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.PECK,12,Move.SHADOWSNEAK,13,Move.RAZORLEAF,21,Move.BITE,29,Move.LEECHSEED,32,Move.EARTHQUAKE,33,Move.SYNTHESIS,37,Move.CRUNCH,41,Move.GIGADRAIN,45,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.GROWTH, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE, Move.WOODHAMMER, Move.GIGADRAIN, Move.CRUNCH, Move.IRONTAIL, Move.IRONHEAD, Move.OUTRAGE, Move.STONEEDGE, Move.ROCKSLIDE, Move.FRENZYPLANT)), 1.3, 42.0, "Continent", "Small Pokémon occasionally gather on its unmoving back to begin building their nests.", null, null, 45, null),

  GROTLE(388, "Grotle", Type.GRASS, null, new int[]{75,89,85,55,65,36}, 142, new int[]{0,2,0,0,0,0}, 70, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.GROWL,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.WITHDRAW,13,Move.RAZORLEAF,21,Move.BITE,29,Move.LEECHSEED,33,Move.SYNTHESIS,37,Move.CRUNCH,41,Move.GIGADRAIN,45,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.GROWTH, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE)), 1.3, 42.0, "Grove", "It knows where pure water wells up. It carries fellow Pokémon there on its back.", Species.TORTERRA, new Object[] {"Level",32}, 45, null),

  TURTWIG(387, "Turtwig", Type.GRASS, null, new int[]{55,68,64,45,55,31}, 64, new int[]{0,1,0,0,0,0}, 70, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.GROWL,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.PECK,12,Move.SHADOWSNEAK,13,Move.RAZORLEAF,21,Move.BITE,29,Move.LEECHSEED,33,Move.SYNTHESIS,37,Move.CRUNCH,41,Move.GIGADRAIN,45,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.GROWTH, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE)), 1.3, 42.0, "Tiny Leaf", "It undertakes photosynthesis with its body, making oxygen. The leaf on its head wilts if it is thirsty.", Species.GROTLE, new Object[] {"Level",18}, 45, null),

  INFERNAPE(392, "Infernape", Type.FIRE, Type.FIGHTING, new int[]{76,104,71,104,71,108}, 236, new int[]{0,1,0,1,0,1}, 70, new Ability[]{Ability.BLAZE}, new Ability[] {}, new Object[] {1,Move.CLOSECOMBAT,2, Move.MACHPUNCH,5,Move.EMBER,9,Move.SCRATCH,12,Move.FLAMEWHEEL,30,Move.NASTYPLOT,45,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.BULKUP, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE, Move.THUNDERPUNCH, Move.MACHPUNCH, Move.CLOSECOMBAT, Move.KNOCKOFF, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.BLASTBURN)), 1.3, 42.0, "Flame", "It tosses its enemies around with agility. It uses all its limbs to fight in its own unique style.", null, null, 45, null),

  MONFERNO(391, "Monferno", Type.FIRE, Type.FIGHTING, new int[]{64,78,52,78,52,81}, 236, new int[]{0,0,0,1,0,1}, 126, new Ability[]{Ability.BLAZE}, new Ability[] {}, new Object[] {1,Move.CLOSECOMBAT,2, Move.MACHPUNCH,5,Move.EMBER,9,Move.SCRATCH,12,Move.FLAMEWHEEL,30,Move.NASTYPLOT,45,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.BULKUP, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE, Move.THUNDERPUNCH, Move.MACHPUNCH, Move.CLOSECOMBAT, Move.KNOCKOFF, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.BLASTBURN)), 1.3, 42.0, "Playful", "It uses ceilings and walls to launch aerial attacks. Its fiery tail is but one weapon.", Species.INFERNAPE, new Object[] {"Level",36}, 45, null),

  CHIMCHAR(390, "Chimchar", Type.FIRE, null, new int[]{44,58,44,58,44,61}, 62, new int[]{0,0,0,0,0,1}, 70, new Ability[]{Ability.BLAZE}, new Ability[] {}, new Object[] {1,Move.CLOSECOMBAT,2, Move.MACHPUNCH,5,Move.EMBER,9,Move.SCRATCH,12,Move.FLAMEWHEEL,30,Move.NASTYPLOT,45,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.BULKUP, Move.EARTHPOWER, Move.KNOCKOFF, Move.SUPERPOWER, Move.BODYSLAM, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.BULLDOZE, Move.THUNDERPUNCH, Move.MACHPUNCH, Move.CLOSECOMBAT, Move.KNOCKOFF, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.BLASTBURN)), 1.3, 42.0, "Chimp", "The gas made in its belly burns from its rear end. The fire burns weakly when it feels sick.", Species.MONFERNO, new Object[] {"Level",14}, 45, null),

  EMPOLEON(395, "Empoleon", Type.WATER, Type.STEEL, new int[]{84,86,88,111,101,60}, 236, new int[]{0,0,0,3,0,0}, 70, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[] {1,Move.AQUAJET,2, Move.METALCLAW,5,Move.WATERGUN,9,Move.BUBBLEBEAM,12,Move.SWORDSDANCE,30,Move.DRILLPECK,45,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SURF, Move.KNOCKOFF, Move.FLASHCANNON, Move.ROOST, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.WATERFALL, Move.DEFOG, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.HYDROCANNON)), 1.3, 42.0, "Emperor", "The three horns that extend from its beak attest to its power. The leader has the biggest horns.", null, null, 45, null),

  PRINPLUP(394, "Prinplup", Type.WATER, null, new int[]{64,66,68,81,76,50}, 126, new int[]{0,0,0,2,0,0}, 70, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[] {1,Move.AQUAJET,2, Move.METALCLAW,5,Move.WATERGUN,9,Move.BUBBLEBEAM,12,Move.SWORDSDANCE,30,Move.DRILLPECK,45,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SURF, Move.KNOCKOFF, Move.FLASHCANNON, Move.ROOST, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.WATERFALL, Move.DEFOG, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.HYDROCANNON)), 1.3, 42.0, "Penguin", "It lives a solitary life. Its wings deliver wicked blows that can snap even the thickest of trees.", Species.EMPOLEON, new Object[] {"Level",36}, 45, null),

  PIPLUP(393, "Piplup", Type.WATER, null, new int[]{53,51,53,61,56,40}, 63, new int[]{0,0,0,1,0,0}, 70, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[]{1,Move.TACKLE,5,Move.WATERGUN,9,Move.BUBBLEBEAM,12,Move.SWORDSDANCE,30,Move.DRILLPECK,45,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SURF, Move.KNOCKOFF, Move.FLASHCANNON, Move.ROOST, Move.STEALTHROCK, Move.DOUBLEEDGE, Move.WATERFALL, Move.DEFOG, Move.IRONHEAD, Move.EARTHQUAKE, Move.STONEEDGE, Move.ROCKSLIDE, Move.HYDROCANNON)), 1.3, 42.0, "Penguin", "Because it is very proud, it hates accepting food from people. Its thick down guards it from cold.", Species.PRINPLUP, new Object[] {"Level",16}, 45, null),

  STARAPTOR(398, "Staraptor", Type.NORMAL, Type.FLYING, new int[]{85,120,70,50,60,100}, 119, new int[]{0,3,0,0,0,0}, 70, new Ability[]{Ability.INTIMIDATE,Ability.RECKLESS}, new Ability[] {}, new Object[]{1,Move.TACKLE,3,Move.GROWL,5,Move.QUICKATTACK,9,Move.WINGATTACK,28,Move.AERIALACE,36,Move.CLOSECOMBAT,38,Move.AGILITY,43,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.DOUBLEEDGE, Move.HYPERBEAM, Move.DEFOG, Move.ROOST, Move.QUICKATTACK, Move.AGILITY, Move.AIRSLASH, Move.DEFOG, Move.UTURN, Move.RAINDANCE, Move.HEATWAVE, Move.HURRICANE,Move.BRAVEBIRD, Move.CLOSECOMBAT)), 1.3, 42.0, "Predator", "When Staravia evolve into Staraptor, they leave the flock to live alone. They have sturdy wings.", null, null, 45, null),

  STARAVIA(397, "Staravia", Type.NORMAL, Type.FLYING, new int[]{55,75,50,40,40,80}, 119, new int[]{0,0,0,0,0,2}, 70, new Ability[]{Ability.INTIMIDATE,Ability.RECKLESS}, new Ability[] {}, new Object[]{1,Move.TACKLE,3,Move.GROWL,5,Move.QUICKATTACK,9,Move.WINGATTACK,28,Move.AERIALACE,38,Move.AGILITY,43,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.DOUBLEEDGE, Move.HYPERBEAM, Move.DEFOG, Move.ROOST, Move.QUICKATTACK, Move.AGILITY, Move.AIRSLASH, Move.DEFOG, Move.UTURN, Move.RAINDANCE, Move.HEATWAVE, Move.HURRICANE,Move.BRAVEBIRD)), 1.3, 42.0, "Starling", "It lives in forests and fields. Squabbles over territory occur when flocks collide.", Species.STARAPTOR, new Object[] {"Level",34}, 45, null),

  STARLY(396, "Starly", Type.NORMAL, Type.FLYING, new int[]{40,55,30,30,30,60}, 49, new int[]{0,0,0,0,0,1}, 70, new Ability[]{Ability.KEENEYE,Ability.RECKLESS}, new Ability[] {}, new Object[]{1,Move.TACKLE,3,Move.GROWL,5,Move.QUICKATTACK,9,Move.WINGATTACK,25,Move.AERIALACE,33,Move.AGILITY,37,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.DOUBLEEDGE, Move.HYPERBEAM, Move.DEFOG, Move.ROOST, Move.QUICKATTACK, Move.AGILITY, Move.AIRSLASH, Move.DEFOG, Move.UTURN, Move.RAINDANCE, Move.HEATWAVE, Move.HURRICANE,Move.BRAVEBIRD)), 1.3, 42.0, "Starling", "They flock around mountains and fields, chasing after bug Pokémon. Their singing is noisy and annoying.", Species.STARAVIA, new Object[] {"Level",14}, 255, null),

  SPIRITOMB(442, "Spiritomb", Type.GHOST, Type.DARK, new int[]{50,92,108,92,108,35}, 270, new int[]{0,0,1,0,1,0}, 0, new Ability[]{Ability.PRESSURE}, new Ability[] {Ability.PRESSURE}, new Object[] {1, Move.CONFUSERAY,20,Move.NASTYPLOT,27,Move.SUCKERPUNCH,30, Move.CRUNCH,33,Move.SHADOWBALL,55,Move.DARKPULSE,73,Move.PSYCHIC}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.PSYCHIC, Move.CRUNCH, Move.NASTYPLOT)), 5.2, 216.0, "Forbidden", "All Spiritomb's mischief and misdeeds compelled a traveler to use a mysterious spell to bind Spiritomb to an odd keystone.", null, null, 45, null),

  GARCHOMP(445, "Garchomp", Type.DRAGON, Type.GROUND, new int[]{108,130,95,80,85,102}, 270, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.ROUGHSKIN}, new Ability[] {Ability.ROUGHSKIN}, new Object[] {1, Move.CRUNCH,2,Move.TACKLE,34,Move.SLASH,30, Move.BULLDOZE,42,Move.DRAGONCLAW,55,Move.EARTHQUAKE,82,Move.DRAGONRUSH}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.FLAMETHROWER, Move.FIREBLAST, Move.CRUNCH, Move.DRAGONCLAW, Move.DRAGONDANCE, Move.GIGAIMPACT, Move.HYPERBEAM)), 5.2, 216.0, "Mach", "Garchomp makes its home in volcanic mountains. It flies through the sky as fast as a jet airplane, hunting down as much prey as it can.", null, null, 45, new Forms[] {Forms.MEGAGARCHOMP}),

  GABITE(444, "Gabite", Type.DRAGON, Type.GROUND, new int[]{68,90,65,50,55,82}, 270, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.ROUGHSKIN}, new Ability[] {Ability.ROUGHSKIN}, new Object[] {1, Move.CRUNCH,2,Move.TACKLE,34,Move.SLASH,30, Move.BULLDOZE,42,Move.DRAGONCLAW,55,Move.EARTHQUAKE,82,Move.DRAGONRUSH}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.FLAMETHROWER, Move.FIREBLAST, Move.CRUNCH, Move.DRAGONCLAW, Move.DRAGONDANCE, Move.GIGAIMPACT, Move.HYPERBEAM)), 5.2, 216.0, "Cave", "Jewels are buried in the caves these Pokémon nest in, but you'll be torn apart by claws and fangs the moment you enter one of these caves.", Species.GARCHOMP, new Object[]{"Level",48}, 45, null),

  TOXICROAK(454, "Toxicroak", Type.POISON, Type.FIGHTING, new int[]{83,106,65,86,65,85}, 172, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.DRYSKIN}, new Ability[] {}, new Object[] {1,Move.POISONSTING,2,Move.MUDSLAP,20,Move.VENOSHOCK,24, Move.SUCKERPUNCH,28,Move.SWAGGER,32,Move.POISONJAB,36,Move.TOXIC,42,Move.NASTYPLOT,48,Move.SLUDGEBOMB,60,Move.GUNKSHOT}, new HashSet<Move>(Arrays.asList(Move.CLOSECOMBAT, Move.SLUDGEBOMB, Move.SLUDGEWAVE, Move.SUCKERPUNCH, Move.KNOCKOFF, Move.SWORDSDANCE, Move.DRAINPUNCH, Move.GIGAIMPACT,Move.EARTHQUAKE)), 1.3, 44.4, "Toxic Mouth", "Its knuckle claws secrete a toxin so vile that even a scratch could prove fatal.", null, null, 75, null),

  // CROAGUNK(453, "Croagunk", Type.POISON, Type.FIGHTING, new int[]{48,61,40,61,40,50}, 60, new int[]{0,1,0,0,0,0}, 100, new Ability[]{Ability.DRYSKIN}, new Ability[] {}, new Object[] {1,Move.POISONSTING,2,Move.MUDSLAP,20,Move.VENOSHOCK,24, Move.SUCKERPUNCH,28,Move.SWAGGER,32,Move.POISONJAB,36,Move.TOXIC,40,Move.NASTYPLOT,44,Move.SLUDGEBOMB,60,Move.GUNKSHOT}, new HashSet<Move>(Arrays.asList(Move.CLOSECOMBAT, Move.SLUDGEBOMB, Move.SLUDGEWAVE, Move.SUCKERPUNCH, Move.KNOCKOFF, Move.SWORDSDANCE, Move.DRAINPUNCH, Move.GIGAIMPACT,Move.EARTHQUAKE)), 0.7, 23.0, "Toxic Mouth", "Inflating its poison sacs, it fills the area with an odd sound and hits flinching opponents with a poison jab.", Species.TOXICROACK, new Object[] {"Level",37}, 140, null),

  MAGNEZONE(462, "Magnezone", Type.ELECTRIC, Type.STEEL, new int[]{70,70,115,130,90,60}, 270, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.MAGNETPULL,Ability.ANALYTIC, Ability.STURDY}, new Ability[] {}, new Object[] {1, Move.THUNDERSHOCK,2,Move.TACKLE,3,Move.THUNDERWAVE,34,Move.METALSOUND,30,Move.DISCHARGE,42,Move.FLASHCANNON,55,Move.THUNDERBOLT,64,Move.ZAPCANNON}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT, Move.THUNDER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.CONFUSERAY, Move.RAINDANCE, Move.IRONDEFENSE)), 1.2, 180.0, "Magnet Area", "It evolved from exposure to a special magnetic field. Three units generate magnetism.", null, null, 30, null),

  MAGNETON(82, "Magneton", Type.ELECTRIC, Type.STEEL, new int[]{50,60,95,120,70,70}, 163, new int[]{0,0,0,2,0,0}, 70, new Ability[]{Ability.MAGNETPULL,Ability.ANALYTIC, Ability.STURDY}, new Ability[] {}, new Object[] {1, Move.THUNDERSHOCK,2,Move.TACKLE,3,Move.THUNDERWAVE,34,Move.METALSOUND,30,Move.DISCHARGE,42,Move.FLASHCANNON,55,Move.THUNDERBOLT,64,Move.ZAPCANNON}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT, Move.THUNDER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.CONFUSERAY, Move.RAINDANCE, Move.IRONDEFENSE)), 1.2, 180.0, "Magnet", "It moves while constantly hovering. It discharges Thunder Wave and so on from the units at its sides.", Species.MAGNEZONE, new Object[] {"Item",Item.THUNDERSTONE}, 60, null),

  MAGNEMITE(81, "Magnemite", Type.ELECTRIC, Type.STEEL, new int[]{25,35,70,95,55,45}, 65, new int[]{0,0,0,1,0,0}, 70, new Ability[]{Ability.MAGNETPULL,Ability.ANALYTIC, Ability.STURDY}, new Ability[] {}, new Object[] {1, Move.THUNDERSHOCK,2,Move.TACKLE,3,Move.THUNDERWAVE,34,Move.METALSOUND,30,Move.DISCHARGE,42,Move.FLASHCANNON,55,Move.THUNDERBOLT,64,Move.ZAPCANNON}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT, Move.THUNDER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.CONFUSERAY, Move.RAINDANCE, Move.IRONDEFENSE)), 1.2, 180.0, "Magnet", "It moves while constantly hovering. It discharges Thunder Wave and so on from the units at its sides.", Species.MAGNETON, new Object[] {"Level",30}, 65, null),

  GIBLE(443, "Gible", Type.DRAGON, Type.GROUND, new int[]{58,70,45,40,45,42}, 270, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.ROUGHSKIN}, new Ability[] {Ability.ROUGHSKIN}, new Object[] {1, Move.CRUNCH,2,Move.TACKLE,34,Move.SLASH,30, Move.BULLDOZE,42,Move.DRAGONCLAW,55,Move.EARTHQUAKE,82,Move.DRAGONRUSH}, new HashSet<Move>(Arrays.asList(Move.EARTHQUAKE, Move.FLAMETHROWER, Move.FIREBLAST, Move.CRUNCH, Move.DRAGONCLAW, Move.DRAGONDANCE, Move.GIGAIMPACT, Move.HYPERBEAM)), 5.2, 216.0, "Land Shark", "Gible attacks anything that moves, and it drags whatever it catches into the crevice that is its lair. Despite the big mouth, Gible's stomach is small.", Species.GABITE, new Object[]{"Level",24}, 45, null),

  RHYPERIOR(464, "Rhyperior", Type.GROUND, Type.ROCK, new int[]{115,140,130,55,55,40}, 270, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.SOLIDROCK, Ability.RECKLESS}, new Ability[] {}, new Object[] {1, Move.HAMMERARM,2,Move.TACKLE,3,Move.SCARYFACE,30,Move.ROCKBLAST,42,Move.EARTHQUAKE,55,Move.STONEEDGE,60,Move.MEGAHORN,64,Move.ROCKWRECKER}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLAMETHROWER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.ICEPUNCH, Move.FIREPUNCH, Move.THUNDERPUNCH,Move.SURF,Move.HYDROPUMP, Move.ROCKSLIDE, Move.STONEEDGE, Move.EARTHQUAKE)), 1.2, 180.0, "Drill", "It puts rocks in holes in its palms and uses its muscles to shoot them. Geodude are shot at rare times.", null, null, 30, null),

  RHYDON(112, "Rhydon", Type.GROUND, Type.ROCK, new int[]{105,130,120,45,45,40}, 270, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.SOLIDROCK, Ability.RECKLESS}, new Ability[] {}, new Object[] {1, Move.BULLDOZE,2,Move.TACKLE,3,Move.SCARYFACE,30,Move.ROCKBLAST,42,Move.EARTHQUAKE,55,Move.STONEEDGE,60,Move.MEGAHORN,64,Move.ROCKWRECKER}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLAMETHROWER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.ICEPUNCH, Move.FIREPUNCH, Move.THUNDERPUNCH,Move.SURF,Move.HYDROPUMP, Move.ROCKSLIDE, Move.STONEEDGE, Move.EARTHQUAKE)), 1.0, 115.0, "Drill", "It begins walking on its hind legs after evolution. It can punch holes through boulders with its horn.", Species.RHYPERIOR, new Object[] {"Item",Item.PROTECTOR}, 30, null),

  RHYHORN(111, "Rhyhorn", Type.GROUND, Type.ROCK, new int[]{80,85,95,30,30,25}, 270, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.SOLIDROCK, Ability.RECKLESS}, new Ability[] {}, new Object[] {1, Move.BULLDOZE,2,Move.TACKLE,3,Move.SCARYFACE,30,Move.ROCKBLAST,42,Move.EARTHQUAKE,55,Move.STONEEDGE,60,Move.MEGAHORN,64,Move.ROCKWRECKER}, new HashSet<Move>(Arrays.asList(Move.ICEBEAM, Move.FLAMETHROWER, Move.FLASHCANNON, Move.ZAPCANNON, Move.IRONHEAD, Move.ICEPUNCH, Move.FIREPUNCH, Move.THUNDERPUNCH,Move.SURF,Move.HYDROPUMP, Move.ROCKSLIDE, Move.STONEEDGE, Move.EARTHQUAKE)), 1.0, 115.0, "Spikes", "It is inept at turning because of its four short legs. It can only charge and run in one direction.", Species.RHYDON, new Object[] {"Level",42}, 30, null),

  TOGEKISS(468, "Togekiss", Type.FAIRY, Type.FLYING, new int[]{85,50,95,120,115,80}, 270, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.SERENEGRACE}, new Ability[] {}, new Object[] {1, Move.AIRSLASH,2,Move.AURASPHERE,3,Move.ANCIENTPOWER,30,Move.DOUBLEEDGE,42,Move.GROWL,64,Move.SKYATTACK}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST,Move.THUNDERWAVE,Move.AIRSLASH,Move.HURRICANE,Move.DRAININGKISS,Move.MOONBLAST,Move.PSYCHIC,Move.SHADOWBALL)), 1.2, 180.0, "Jubilee", "It shares many blessings with people who respect one another's rights and avoid needless strife.", null, null, 30, null),

  TOGETIC(176, "Togetic", Type.FAIRY, Type.FLYING, new int[]{55,40,85,80,105,40}, 270, new int[]{0,0,0,2,0,0}, 0, new Ability[]{Ability.SERENEGRACE}, new Ability[] {}, new Object[] {1, Move.AIRSLASH,2,Move.AURASPHERE,3,Move.ANCIENTPOWER,30,Move.DOUBLEEDGE,42,Move.EARTHQUAKE,64,Move.SKYATTACK}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST,Move.THUNDERWAVE,Move.DRAININGKISS,Move.MOONBLAST,Move.PSYCHIC)), 1.2, 180.0, "Happiness", "They say that it will appear before kindhearted, caring people and shower them with happiness.", Species.TOGEKISS, new Object[] {"Item",Item.SHINYSTONE}, 30, null),
  
  DIALGA(483, "Dialga", Type.DRAGON, Type.STEEL, new int[]{100,120,120,150,100,90}, 306, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.PRESSURE}, new Ability[] {}, new Object[] {1, Move.EMBER,20,Move.ANCIENTPOWER,27,Move.CALMMIND,30, Move.DRAGONPULSE,72,Move.EARTHPOWER,80,Move.IRONTAIL,88,Move.ROAROFTIME}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.DRAGONCLAW, Move.GIGAIMPACT, Move.HYPERBEAM, Move.FIREBLAST, Move.THUNDER, Move.EARTHQUAKE, Move.DRACOMETEOR,Move.DRAGONDANCE,Move.ICEBEAM,Move.THUNDERBOLT)), 5.2, 683.0, "Temporal", "A Pokémon spoken of in legend. It is said that time began moving when Dialga was born.", null, null, 3, null),
  
  PALKIA(484, "Palkia", Type.DRAGON, Type.WATER, new int[]{90,120,120,150,100,100}, 306, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.PRESSURE}, new Ability[] {}, new Object[] {1, Move.EMBER,20,Move.FLAMETHROWER,27,Move.ANCIENTPOWER,30, Move.DRAGONPULSE,82,Move.EARTHPOWER,64,Move.FIREBLAST,80,Move.SPATIALREND,88,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.SURF,Move.DRAGONDANCE,Move.ICEBEAM,Move.BLIZZARD,Move.FIREBLAST,Move.THUNDER,Move.THUNDERBOLT)), 4.2, 336.0, "Spatial", "It is said to live in a gap in the spatial dimension parallel to ours. It appears in mythology.", null, null, 3, null),
  
  GIRATINA(487, "Giratina", Type.DRAGON, Type.GHOST, new int[]{150,100,120,100,120,90}, 306, new int[]{3,0,0,0,0,0}, 0, new Ability[]{Ability.PRESSURE}, new Ability[] {}, new Object[] {1, Move.EMBER,20,Move.FLAMETHROWER,27,Move.ANCIENTPOWER,30, Move.DRAGONPULSE,82,Move.EARTHPOWER,64,Move.FIREBLAST,80,Move.SHADOWFORCE,88,Move.DRAGONPULSE}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.SHADOWBALL, Move.SURF, Move.KNOCKOFF, Move.DRAGONPULSE, Move.DRACOMETEOR,Move.DRAGONDANCE)), 4.5, 750.0, "Renegade", "This Pokémon is said to live in a world on the reverse side of ours, where common knowledge is distorted and strange.", null, null, 3, null),

  SERPERIOR(497, "Serperior", Type.GRASS, Type.DRAGON, new int[]{75,75,95,75,95,113}, 238, new int[]{0,0,0,0,0,3}, 50, new Ability[]{Ability.OVERGROW,Ability.CONTRARY}, new Ability[] {}, new Object[] {1,Move.TACKLE,2, Move.VINEWHIP,5,Move.LEER,9,Move.GROWTH,12,Move.LEECHSEED,15,Move.MEGADRAIN,32,Move.LEAFBLADE,44,Move.GIGADRAIN,62,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.LEAFSTORM, Move.GIGADRAIN,Move.KNOCKOFF,Move.DRAGONPULSE,Move.DRACOMETEOR,Move.DRAGONDANCE)), 3.3, 63.0, "Regal", "It can stop its opponents' movements with just a glare. It takes in solar energy and boosts it internally.", null, null, 45, null),

  SERVINE(496, "Servine", Type.GRASS, null, new int[]{60,60,75,60,75,83}, 145, new int[]{0,0,0,0,0,2}, 50, new Ability[]{Ability.OVERGROW,Ability.CONTRARY}, new Ability[] {}, new Object[] {1,Move.TACKLE,2, Move.VINEWHIP,5,Move.LEER,9,Move.GROWTH,12,Move.LEECHSEED,15,Move.MEGADRAIN,32,Move.LEAFBLADE,44,Move.GIGADRAIN,62,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.LEAFSTORM, Move.GIGADRAIN, Move.KNOCKOFF,Move.DRAGONPULSE,Move.DRACOMETEOR)), 0.8, 16.0, "Grass Snake", "When it gets dirty, its leaves can't be used in photosynthesis, so it always keeps itself clean.", Species.SERPERIOR, new Object[] {"Level",36}, 45, null),

  SNIVY(495, "Snivy", Type.GRASS, null, new int[]{45,45,55,45,55,63}, 62, new int[]{0,0,0,0,0,1}, 70, new Ability[]{Ability.OVERGROW,Ability.CONTRARY}, new Ability[] {}, new Object[] {1,Move.TACKLE,2, Move.VINEWHIP,5,Move.LEER,9,Move.GROWTH,12,Move.LEECHSEED,15,Move.MEGADRAIN,32,Move.LEAFBLADE,44,Move.GIGADRAIN,62,Move.LEAFSTORM}, new HashSet<Move>(Arrays.asList(Move.LEAFSTORM, Move.GIGADRAIN, Move.KNOCKOFF,Move.DRAGONPULSE,Move.DRACOMETEOR)), 0.6, 8.1, "Grass Snake", "They photosynthesize by bathing their tails in sunlight. When they are not feeling well, their tails droop.", Species.SERVINE, new Object[] {"Level",17}, 45, null),

  GALVANTULA(596, "Galvantula", Type.BUG, Type.ELECTRIC, new int[]{70,77,60,97,60,108}, 165, new int[]{0,0,0,0,0,2}, 50, new Ability[]{Ability.COMPOUNDEYES}, new Ability[] {}, new Object[] {1,Move.STICKYWEB,2, Move.THUNDERWAVE,5,Move.THUNDERSHOCK,9,Move.AGILITY,12,Move.SUCKERPUNCH,15,Move.SLASH,16,Move.DISCHARGE,24,Move.BUGBUZZ}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT, Move.UTURN, Move.SUCKERPUNCH, Move.THUNDER, Move.BUGBUZZ, Move.STRUGGLEBUG)), 1.3, 42.0, "EleSpider", "When attacked, they create an electric barrier by spitting out many electrically charged threads.", null, null, 75, null),

  JOLTIK(595, "Joltik", Type.BUG, Type.ELECTRIC, new int[]{50,47,50,57,50,65}, 165, new int[]{0,0,0,0,0,1}, 50, new Ability[]{Ability.COMPOUNDEYES}, new Ability[] {}, new Object[] {1,Move.STICKYWEB,2, Move.THUNDERWAVE,5,Move.THUNDERSHOCK,9,Move.AGILITY,12,Move.SUCKERPUNCH,15,Move.SLASH,16,Move.DISCHARGE,24,Move.BUGBUZZ}, new HashSet<Move>(Arrays.asList(Move.THUNDERBOLT, Move.UTURN, Move.SUCKERPUNCH, Move.THUNDER, Move.BUGBUZZ, Move.STRUGGLEBUG)), 1.3, 42.0, "Attaching", "They attach themselves to large-bodied Pokémon and absorb static electricity, which they store in an electric pouch.", Species.GALVANTULA, new Object[] {"Level",36}, 190, null),

  DECIDUEYE(724, "Decidueye", Type.GRASS, Type.GHOST, new int[]{78,107,75,100,100,70}, 246, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.GROWL,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.PECK,12,Move.SHADOWSNEAK,15,Move.RAZORLEAF,16,Move.DEFOG,24,Move.NASTYPLOT,27,Move.SUCKERPUNCH,30,Move.LEAFBLADE,31,Move.SPIRITSHACKLE,36,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.UTURN, Move.KNOCKOFF, Move.SHADOWBALL, Move.DARKPULSE, Move.DEFOG, Move.HURRICANE, Move.SWORDSDANCE, Move.ROOST)), 1.3, 42.0, "Arrow Quill", "It nocks its arrow quills and shoots them at opponents. When it simply can't afford to miss, it tugs the vine on its head to improve its focus.", null, null, 75, null),

  DARTRIX(723, "Dartrix", Type.GRASS, Type.FLYING, new int[]{78,75,75,70,70,52}, 147, new int[]{2,0,0,0,0,0}, 0, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.GROWL,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.PECK,12,Move.SHADOWSNEAK,15,Move.RAZORLEAF,16,Move.DEFOG,24,Move.NASTYPLOT,27,Move.SUCKERPUNCH,30,Move.LEAFBLADE,36,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.UTURN, Move.KNOCKOFF, Move.DARKPULSE, Move.SHADOWBALL, Move.DEFOG, Move.HURRICANE, Move.SWORDSDANCE)), 1.3, 42.0, "Blade Quill", "This narcissistic Pokémon is a clean freak. If you don't groom it diligently, it will stop listening to you.", Species.DECIDUEYE, new Object[] {"Level", 34}, 75, null),

  ROWLET(722, "Rowlet", Type.GRASS, Type.FLYING, new int[]{68,55,55,50,50,42}, 64, new int[]{1,0,0,0,0,0}, 0, new Ability[]{Ability.OVERGROW}, new Ability[] {}, new Object[] {1,Move.GROWL,2, Move.TACKLE,5,Move.LEAFAGE,9,Move.PECK,12,Move.SHADOWSNEAK,15,Move.RAZORLEAF,16,Move.DEFOG,24,Move.NASTYPLOT,27,Move.SUCKERPUNCH,30,Move.LEAFBLADE,36,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.UTURN, Move.KNOCKOFF, Move.ICYWIND, Move.ICEBEAM, Move.DEFOG, Move.HURRICANE, Move.SWORDSDANCE)), 1.3, 42.0, "Grass Quill", "It sends its feathers, which are as sharp as blades, flying in attack. Its legs are strong, so its kicks are also formidable.", Species.DARTRIX, new Object[] {"Level",17}, 45, null),

  INCINEROAR(727, "Incineroar", Type.FIRE, Type.DARK, new int[]{95,115,90,80,90,60}, 246, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.BLAZE, Ability.INTIMIDATE}, new Ability[] {}, new Object[] {1,Move.GROWL,2,Move.TACKLE,5,Move.EMBER,9,Move.BULKUP,12,Move.QUICKATTACK,15,Move.FLAMEWHEEL,15,Move.BITE,25,Move.FIREFANG,27,Move.SUCKERPUNCH,44,Move.FLAMETHROWER,31,Move.DARKESTLARIAT,58,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.FIREBLAST, Move.KNOCKOFF, Move.BULKUP, Move.DARKPULSE, Move.UTURN, Move.FLAMETHROWER, Move.SWORDSDANCE, Move.EARTHQUAKE)), 1.3, 42.0, "Heel", "Although it's rough mannered and egotistical, it finds beating down unworthy opponents boring. It gets motivated for stronger opponents.", null, null, 45, null),

  TORRACAT(726, "Torracat", Type.FIRE, null, new int[]{65,85,50,80,50,90}, 147, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.BLAZE, Ability.INTIMIDATE}, new Ability[] {}, new Object[] {1,Move.GROWL,2,Move.TACKLE,5,Move.EMBER,9,Move.BULKUP,12,Move.QUICKATTACK,15,Move.FLAMEWHEEL,15,Move.BITE,25,Move.FIREFANG,27,Move.SUCKERPUNCH,44,Move.FLAMETHROWER,50,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.FIREBLAST, Move.KNOCKOFF, Move.BULKUP, Move.DARKPULSE, Move.UTURN, Move.FLAMETHROWER, Move.SWORDSDANCE, Move.EARTHQUAKE)), 1.3, 42.0, "Fire Cat", "It can act spoiled if it grows close to its Trainer. A powerful Pokémon, its sharp claws can leave its Trainer's whole body covered in scratches.", Species.INCINEROAR, new Object[] {"Level", 34}, 45, null),

  LITTEN(725, "Litten", Type.FIRE, null, new int[]{45,65,40,60,40,70}, 64, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.BLAZE, Ability.INTIMIDATE}, new Ability[] {}, new Object[] {1,Move.GROWL,2,Move.TACKLE,5,Move.EMBER,9,Move.BULKUP,12,Move.QUICKATTACK,15,Move.FLAMEWHEEL,16,Move.BITE,25,Move.FIREFANG,27,Move.SUCKERPUNCH,44,Move.FLAMETHROWER,50,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.FIREBLAST, Move.KNOCKOFF, Move.BULKUP, Move.DARKPULSE, Move.UTURN, Move.FLAMETHROWER, Move.SWORDSDANCE)), 0.4, 4.3, "Fire Cat", "If you try too hard to get close to it, it won't open up to you. Even if you do grow close, giving it too much affection is still a no-no.", Species.TORRACAT, new Object[] {"Level", 17}, 45, null),

  PRIMARINA(730, "Primarina", Type.WATER, Type.FAIRY, new int[]{80,74,74,126,116,60}, 239, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[] {1,Move.GROWL,2,Move.TACKLE,5,Move.WATERGUN,9,Move.DISARMINGVOICE,12,Move.AQUAJET,15,Move.ICYWIND,16,Move.BUBBLEBEAM,25,Move.SING,27,Move.HYPERVOICE,44,Move.MOONBLAST,50,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.SURF, Move.HYDROPUMP, Move.ICEBEAM, Move.ICYWIND, Move.CALMMIND, Move.DRAININGKISS, Move.MOONBLAST, Move.PSYCHIC)), 0.4, 4.3, "Soloist", "To Primarina, every battle is a stage. It takes down its prey with beautiful singing and dancing.", null, null, 45, null),
  
  BRIONNE(729, "Brionne", Type.WATER, null, new int[]{60,69,69,91,81,50}, 147, new int[]{0,0,0,2,0,0}, 0, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[] {1,Move.GROWL,2,Move.TACKLE,5,Move.WATERGUN,9,Move.DISARMINGVOICE,12,Move.AQUAJET,15,Move.ICYWIND,16,Move.BUBBLEBEAM,25,Move.SING,27,Move.HYPERVOICE,44,Move.MOONBLAST,50,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.SURF, Move.HYDROPUMP, Move.ICEBEAM, Move.ICYWIND, Move.CALMMIND, Move.DRAININGKISS, Move.MOONBLAST)), 0.4, 4.3, "Pop Star", "It gets excited when it sees a dance it doesn't know. This hard worker practices diligently until it can learn that dance.", Species.TORRACAT, new Object[] {"Level", 17}, 45, null),

  POPPLIO(728, "Popplio", Type.WATER, null, new int[]{50,54,54,66,56,40}, 64, new int[]{0,0,0,1,0,0}, 0, new Ability[]{Ability.TORRENT}, new Ability[] {}, new Object[]{1,Move.GROWL,2,Move.TACKLE,5,Move.WATERGUN,9,Move.DISARMINGVOICE,12,Move.AQUAJET,15,Move.ICYWIND,16,Move.BUBBLEBEAM,25,Move.SING,27,Move.HYPERVOICE,44,Move.MOONBLAST,50,Move.HYDROPUMP}, new HashSet<Move>(Arrays.asList(Move.SUCKERPUNCH, Move.SURF, Move.HYDROPUMP, Move.ICEBEAM, Move.ICYWIND, Move.CALMMIND, Move.DRAININGKISS, Move.MOONBLAST)), 0.4, 4.3, "Sea Lion", "The balloons it inflates with its nose grow larger and larger as it practices day by day.", Species.BRIONNE, new Object[] {"Level", 17}, 45, null),

  KOMMOO(784, "Kommo-o", Type.DRAGON, Type.FIGHTING, new int[]{75,110,125,100,105,85}, 270, new int[]{0,0,3,0,0,0}, 50, new Ability[]{Ability.BULLETPROOF,Ability.SOUNDPROOF}, new Ability[] {}, new Object[]{1,Move.CLANGINGSCALES,2,Move.BELLYDRUM,3,Move.TACKLE,4,Move.LEER,12,Move.SCARYFACE,20,Move.WORKUP,28,Move.IRONDEFENSE,32,Move.DRAGONCLAW,44,Move.DRAGONDANCE,52,Move.OUTRAGE,60,Move.CLOSECOMBAT,68,Move.CLANGOROUSSOUL,76,Move.BOOMBURST}, new HashSet<Move>(Arrays.asList(Move.FOCUSBLAST,Move.DRAINPUNCH,Move.FIREPUNCH,Move.FLAMETHROWER,Move.DRACOMETEOR,Move.DRAGONPULSE,Move.AURASPHERE,Move.DRAGONCLAW,Move.FLASHCANNON,Move.STEALTHROCK,Move.IRONHEAD,Move.SUPERPOWER,Move.CLOSECOMBAT,Move.SWORDSDANCE,Move.ROCKSLIDE,Move.THUNDERPUNCH,Move.DRAGONDANCE,Move.ICEPUNCH,Move.FIREPUNCH)), 1.6, 78.2, "Scaly", "When it howls after finishing off its prey, the metallic sounds of its celebrating comrades can be heard from all around.", null, null, 45, null),

  HAKAMOO(783, "Hakamo-o", Type.DRAGON, Type.FIGHTING, new int[]{55,75,90,65,70,65}, 147, new int[]{0,0,2,0,0,0}, 50, new Ability[]{Ability.BULLETPROOF,Ability.SOUNDPROOF}, new Ability[] {}, new Object[]{1,Move.TACKLE,4,Move.LEER,12,Move.SCARYFACE,20,Move.WORKUP,28,Move.IRONDEFENSE,32,Move.DRAGONCLAW,44,Move.DRAGONDANCE,50,Move.OUTRAGE,56,Move.CLOSECOMBAT}, new HashSet<Move>(Arrays.asList(Move.FOCUSBLAST,Move.DRAINPUNCH,Move.FIREPUNCH,Move.FLAMETHROWER,Move.DRACOMETEOR,Move.DRAGONPULSE,Move.AURASPHERE,Move.DRAGONCLAW,Move.FLASHCANNON,Move.STEALTHROCK,Move.IRONHEAD,Move.SUPERPOWER,Move.CLOSECOMBAT,Move.SWORDSDANCE,Move.ROCKSLIDE,Move.THUNDERPUNCH,Move.ICEPUNCH,Move.FIREPUNCH,Move.DRAGONDANCE)), 1.2, 47.0, "Scaly", "It makes noise by clanging its scales together. When the rhythm has reached its peak, Hakamo-o attacks.", Species.KOMMOO, new Object[] {"Level",45}, 45, null),

  JANGMOO(783, "Hakamo-o", Type.DRAGON, null, new int[]{45,55,65,45,45,45}, 60, new int[]{0,0,1,0,0,0}, 50, new Ability[]{Ability.BULLETPROOF,Ability.SOUNDPROOF}, new Ability[] {}, new Object[]{1,Move.TACKLE,4,Move.LEER,12,Move.SCARYFACE,20,Move.WORKUP,28,Move.IRONDEFENSE,32,Move.DRAGONCLAW,44,Move.DRAGONDANCE,50,Move.OUTRAGE}, new HashSet<Move>(Arrays.asList(Move.FOCUSBLAST,Move.FLAMETHROWER,Move.DRACOMETEOR,Move.DRAGONPULSE,Move.DRAGONCLAW,Move.FLASHCANNON,Move.STEALTHROCK,Move.IRONHEAD,Move.SUPERPOWER,Move.CLOSECOMBAT,Move.SWORDSDANCE,Move.ROCKSLIDE,Move.THUNDERPUNCH,Move.ICEPUNCH,Move.FIREPUNCH,Move.DRAGONDANCE)), 1.2, 47.0, "Scaly", "It smacks the scales on its head against rocks or against the ground to frighten its opponents. It can also contact its friends with these noises.", Species.HAKAMOO, new Object[] {"Level",35}, 45, null),

  CORVIKNIGHT(823, "Corviknight", Type.FLYING, Type.STEEL, new int[]{98,87,105,53,85,67}, 248, new int[]{0,0,3,0,0,0}, 50, new Ability[]{Ability.PRESSURE}, new Ability[] {}, new Object[] {1,Move.STEELWING,2, Move.IRONDEFENSE,3,Move.METALSOUND,4,Move.PECK,34,Move.DRILLPECK,16,Move.DEFOG,28,Move.SCARYFACE,40,Move.SWAGGER,50,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.BRAVEBIRD, Move.UTURN, Move.ROOST, Move.AIRSLASH, Move.AERIALACE, Move.FLASHCANNON, Move.IRONHEAD, Move.DEFOG, Move.HURRICANE, Move.HYPERBEAM, Move.AGILITY)), 1.3, 42.0, "Raven", "Although its wings have partly turned to steel and become heavy as a result, this Pokémon flies through the skies with ease.", null, null, 45, null),

  CORVISQUIRE(822, "Corvisquire", Type.FLYING, null, new int[]{68,67,55,43,55,77}, 128, new int[]{0,0,0,0,0,2}, 50, new Ability[]{Ability.KEENEYE}, new Ability[] {}, new Object[] {1,Move.PECK,2, Move.LEER,3,Move.METALSOUND,34,Move.DRILLPECK,16,Move.DEFOG,28,Move.SCARYFACE,40,Move.SWAGGER,50,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.BRAVEBIRD, Move.UTURN, Move.ROOST, Move.AIRSLASH, Move.AERIALACE,Move.DEFOG, Move.HURRICANE, Move.HYPERBEAM, Move.AGILITY)), 1.3, 42.0, "Raven", "The lessons of many harsh battles have taught it how to accurately judge an opponent's strength.", Species.CORVIKNIGHT, new Object[] {"Level",38}, 120, null),

  ROOKIDEE(821, "Rookidee", Type.FLYING, null, new int[]{38,47,35,33,33,57}, 128, new int[]{0,0,0,0,0,1}, 50, new Ability[]{Ability.KEENEYE}, new Ability[] {}, new Object[] {1,Move.PECK,2, Move.LEER,3,Move.METALSOUND,28,Move.DRILLPECK,16,Move.DEFOG,28,Move.SCARYFACE,32,Move.SWAGGER,36,Move.BRAVEBIRD}, new HashSet<Move>(Arrays.asList(Move.BRAVEBIRD, Move.UTURN, Move.ROOST, Move.AIRSLASH, Move.AERIALACE,Move.DEFOG, Move.HURRICANE, Move.HYPERBEAM, Move.AGILITY)), 1.3, 42.0, "Tiny Bird", "Jumping nimbly about, this small-bodied Pokémon takes advantage of even the slightest opportunity to disorient larger opponents.", Species.CORVISQUIRE, new Object[] {"Level",18}, 255, null),

  FROSMOTH(873, "Frosmoth", Type.ICE, Type.BUG, new int[]{70,65,60,125,90,65}, 306, new int[]{0,0,0,2,0,0}, 0, new Ability[]{Ability.ICESCALES}, new Ability[] {}, new Object[] {1,Move.ICYWIND,2, Move.POWDERSNOW,32,Move.ICEBEAM,16,Move.DEFOG,32,Move.BUGBUZZ,52,Move.QUIVERDANCE}, new HashSet<Move>(Arrays.asList(Move.BUGBUZZ, Move.UTURN, Move.QUIVERDANCE, Move.ICYWIND, Move.ICEBEAM, Move.BLIZZARD, Move.LUNGE, Move.DEFOG, Move.GIGADRAIN, Move.HYPERBEAM, Move.UTURN)), 1.3, 42.0, "Frost Moth", "It shows no mercy to any who desecrate fields and mountains. It will fly around on its icy wings, causing a blizzard to chase offenders away.", null, null, 75, null),

  SNOM(872, "Snom", Type.ICE, Type.BUG, new int[]{30,25,35,45,30,20}, 306, new int[]{0,0,0,1,0,0}, 0, new Ability[]{Ability.ICESCALES}, new Ability[] {}, new Object[] {1,Move.STRUGGLEBUG,2,Move.POWDERSNOW}, new HashSet<Move>(Arrays.asList(Move.ICYWIND, Move.POWDERSNOW)), 0.3, 3.8, "Worm", "It eats snow that piles up on the ground. The more snow it eats, the bigger and more impressive the spikes on its back grow.", Species.FROSMOTH, new Object[]{"HappinessNight",0}, 190, null),
  
  CENTISKORCH(851, "Centiskorch", Type.FIRE, Type.BUG, new int[]{100,115,65,90,90,65}, 306, new int[]{0,2,0,0,0,0}, 0, new Ability[]{Ability.FLASHFIRE}, new Ability[] {}, new Object[] {1, Move.EMBER,20,Move.CRUNCH,27,Move.STONEEDGE,30, Move.EARTHQUAKE,82,Move.LUNGE,64,Move.FLAMETHROWER,80,Move.FIREBLAST,88,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST, Move.EARTHQUAKE, Move.STONEEDGE, Move.CRUNCH, Move.LUNGE, Move.GIGAIMPACT,Move.HYPERBEAM, Move.KNOCKOFF)), 3.0, 120.0, "Radiator", "While its burning body is already dangerous on its own, this excessively hostile Pokémon also has large and very sharp fangs.", null, null, 75, null),

  SIZZLIPEDE(850, "Sizzlipede", Type.FIRE, Type.BUG, new int[]{50,65,45,50,50,45}, 306, new int[]{0,1,0,0,0,0}, 0, new Ability[]{Ability.FLASHFIRE}, new Ability[] {Ability.FLAMEBODY}, new Object[] {1, Move.EMBER,20,Move.CRUNCH,27,Move.STONEEDGE,30, Move.EARTHQUAKE,82,Move.LUNGE,64,Move.FLAMETHROWER,80,Move.FIREBLAST,88,Move.FLAREBLITZ}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST, Move.EARTHQUAKE, Move.STONEEDGE, Move.CRUNCH, Move.LUNGE, Move.GIGAIMPACT,Move.HYPERBEAM, Move.KNOCKOFF)), 3.0, 120.0, "Radiator", "It wraps prey up with its heated body, cooking them in its coils. Once they're well-done, it will voraciously nibble them down to the last morsel.", Species.CENTISKORCH, new Object[]{"Level",28}, 75, null),
  
  KORAIDON(998, "Koraidon", Type.DRAGON, Type.FIGHTING, new int[]{100,135,115,85,100,135}, 306, new int[]{0,3,0,0,0,0}, 0, new Ability[]{Ability.ORICHALCUMPULSE}, new Ability[] {}, new Object[] {1,Move.BREAKINGSWIPE,14,Move.ANCIENTPOWER,21,Move.DRAINPUNCH,28, Move.BRICKBREAK,35,Move.AGILITY,42,Move.DRAGONCLAW,49, Move.FLAMETHROWER,56,Move.COLLISIONCOURSE,77,Move.OUTRAGE,91,Move.FLAREBLITZ,98,Move.GIGAIMPACT}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST, Move.EARTHQUAKE, Move.STONEEDGE, Move.CRUNCH, Move.LUNGE, Move.GIGAIMPACT,Move.HYPERBEAM, Move.KNOCKOFF, Move.CLOSECOMBAT, Move.DRAINPUNCH, Move.SWORDSDANCE,Move.DRAGONDANCE)), 2.5, 303.0, "Paradox", "This seems to be the Winged King mentioned in an old expedition journal. It was said to have split the land with its bare fists.", null, null, 3, null),
  
  MIRAIDON(999, "Miraidon", Type.DRAGON, Type.ELECTRIC, new int[]{100,85,100,135,115,135}, 306, new int[]{0,0,0,3,0,0}, 0, new Ability[]{Ability.HADRONENGINE}, new Ability[] {}, new Object[] {1,Move.DRAGONBREATH,2,Move.THUNDERSHOCK,14,Move.THUNDERWAVE,21,Move.PARABOLICCHARGE,28, Move.DISCHARGE,35,Move.AGILITY,42,Move.DRAGONPULSE,49, Move.THUNDERBOLT,56,Move.ELECTRODRIFT,77,Move.THUNDER,91,Move.OVERHEAT,98,Move.HYPERBEAM}, new HashSet<Move>(Arrays.asList(Move.FLAMETHROWER, Move.FIREBLAST, Move.CONFUSERAY, Move.ZENHEADBUTT, Move.DRAGONCLAW, Move.THUNDERWAVE, Move.CALMMIND,Move.SOLARBEAM, Move.DRACOMETEOR, Move.OVERHEAT)), 3.5, 240.0, "Paradox", "This seems to be the Iron Serpent mentioned in an old book. The Iron Serpent is said to have turned the land to ash with its lightning.", null, null, 3, null);

  private int DEX_NUMBER;
  private String NAME;
  private Type TYPE1;
  private Type TYPE2;
  private int[] BASE_STATS;
  private int BASE_EXP;
  private int[] EFFORT_POINTS;
  private int HAPPINESS;
  private Ability[] ABILITIES;
  private Ability[] HIDDEN_ABILITY;
  private HashMap<Integer, Move> MOVESET;
  private HashSet<Move> MOVEPOOL;
  private double HEIGHT;
  private double WEIGHT;
  private String KIND;
  private String POKEDEX_ENTRY;
  private Species EVOLUTION;
  private Object[] EVOLUTION_METHOD;
  private int HP;
  private int ATTACK;
  private int DEFENSE;
  private int SPA;
  private int SPD;
  private int SPEED;
  private int CATCHRATE;
  private Forms[] FORMS;

  
/**
 *  Enum constructor defining the species present in the game. Each species has a pokedex number, name, type, base stats, abilities, movesets, etc.
 *  @param dex_number Pokemon's pokedex number
 *  @param name Name of the species
 *  @param type 1 First type (must be defined)
 *  @param type 2 Second type (null if none)
 *  @param base_stats The base stats as an int array
 *  @param base_exp The base experience
 *  @param effort_points The effort points given to pokemon who defeat it
 *  @param happiness The base happiness (note: friendship not implemented)
 *  @param abilities The abilities of the pokemon
 *  @param hidden_ability THe hidden ability of the pokemon
 *  @param moveset Set of moves
 *  @param movepool The movepool (i.e.compatibility with TMs)
 *  @param height The height of the pokemon
 *  @param weight The weight of the pokemon (in metric system)
 *  @param kind The kind of pokemon(i.e. Seed Pokemon)
 *  @param pokedex_entry The way it is entered into the pokedex
 *  @param evolution It's evolution or null if this pokemon is fully evolved
 *  @param evolution_method The method as Object array, catch rate of the pokemon
 *  @param catch_rate How easy it is to catch
 *  @param forms The forms that it has as an index
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Species(int dex_number, String name, Type type1, Type type2, int[] base_stats, int base_exp, int[] effort_points, int happiness, Ability[] abilities, Ability[] hidden_ability, Object[] moveset, HashSet<Move> movepool, double height, double weight, String kind, String pokedex_entry, Species evolution, Object[] evolution_method, int catch_rate, Forms[] forms) {
    DEX_NUMBER = dex_number;
    NAME = name;
    TYPE1 = type1;
    TYPE2 = type2;
    BASE_STATS = base_stats;
    BASE_EXP = base_exp;
    EFFORT_POINTS = effort_points;
    HAPPINESS = happiness;
    ABILITIES = abilities;
    HIDDEN_ABILITY = hidden_ability;
    MOVESET = new HashMap<Integer, Move>();
    for (int i = 0; i < moveset.length; i ++) {
      if (moveset[i] instanceof Integer) {
        MOVESET.put((Integer)moveset[i], (Move)moveset[i+1]);
      }
    }
    MOVEPOOL = movepool;
    HEIGHT = height;
    WEIGHT = weight;
    KIND = kind;
    POKEDEX_ENTRY = pokedex_entry;
    EVOLUTION = evolution;
    EVOLUTION_METHOD = evolution_method;
    HP = BASE_STATS[0];
    ATTACK = BASE_STATS[1];
    DEFENSE = BASE_STATS[2];
    SPA = BASE_STATS[3];
    SPD = BASE_STATS[4];
    SPEED = BASE_STATS[5];
    CATCHRATE = catch_rate;
    FORMS = forms;
  }

  
/**
 *  returns string of species information
 *
 *  @return String of species info
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String toString() {
    String s = "Species: " + NAME + "\nType 1: " + this.getTypeOne() + "\nType 2: " + this.getTypeTwo() + "\n" + KIND + " Pokémon" + "\nHeight (m):" + HEIGHT + "\nWeight (kg):" + WEIGHT + "\nBASE STATS:" + "\nHP:" + HP + "\nAttack: " + ATTACK + "\nDefense: " + DEFENSE + "\nSpecial Attack: " + SPA + "\nSpecial Defense: " + SPD + "\nSpeed: " + SPEED + "\n" + POKEDEX_ENTRY;
    return s;
  }

  
/**
 *  gets pokemon's abilities
 *
 *  @return Ability of pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Ability[] getAbilities() {
    return ABILITIES;
  }

  
/**
 *  gets random ability of the pokemon
 *
 *  @return Random pokemon ability
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Ability getRandomAbility() {
    Random rand = new Random();
    return ABILITIES[rand.nextInt(ABILITIES.length)];
  }

  
/**
 *  gets ability based on index
 *
 *  @param i Index
 *  @param Ability at that index
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Ability getAbility(int i) {
    return ABILITIES[i];
  }

  
/**
 *  gets hp stat of the pokemon
 *
 *  @param The HP of the pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getHP() {
    return HP;
  }

  
/**
 *  gets attack stat of the pokemon
 *
 *  @return The attack stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getAttack() {
    return ATTACK;
  }

  
/**
 *  gets defense stat of the pokemon
 *
 *  @param The defense stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getDefense() {
    return DEFENSE;
  }

  
/**
 *  gets special attack stat of the pokemon
 *
 *  @return Special attack stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getSpecialAttack() {
    return SPA;
  }

  
/**
 *  gets special defense stat of the pokemon
 *
 *  @return Special defense stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getSpecialDefense() {
    return SPD;
  }

  
/**
 *  gets speed stat of the pokemon
 *
 *  @return Speed of pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Integer getSpeed() {
    return SPEED;
  }

  
/**
 *  gets name of the species
 *
 *  @return Name of species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getName() {
    return NAME;
  }

  
/**
 *  gets first type of the species
 *
 *  @return First type of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeOne() {
    return TYPE1;
  }

  
/**
 *  gets second type of the species
 *
 *  @return Second type of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Type getTypeTwo() {
    return TYPE2;
  }

  
/**
 *  sets first type of the species
 *
 *  @param type Type of species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setTypeOne(Type type) {
    TYPE1 = type;
  }

  
/**
 *  sets second type of the species
 *
 *  @param type Type of species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void setTypeTwo(Type type) {
    TYPE2 = type;
  }

  
/**
 *  gets move pool of the species, or TM compatibility
 *
 *  @param The movepool of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public HashSet<Move> getMovePool() {
    return MOVEPOOL;
  }

  
/**
 *  gets move learned in the pokemon's learn set, based on the key (level of the pokemon)
 *
 *  @param i Integer
 *  @return The move learned in the learn set
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Move getMoveLearned(Integer i) {
    if (!MOVESET.containsKey(i)) {
      return null;
    }
    return MOVESET.get(i);
  }

  
/**
 *  gets tm compability of the species
 *
 *  @return Moveset
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public HashMap<Integer, Move> getLearnSet() {
    return MOVESET;
  }

  
/**
 *  gets type effectiveness on the species
 *
 *  @param type Type of species
 *  @return The effectiveness of the type on species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public double getTypeEffectiveness(Type type) {
    double i = 1.0;
    if (type == null) {
      return i;
    }
    if (type.isSuperEffectiveOn(TYPE1.getName())) {
      i *= 2;
    } 
    if (type.isNotVeryEffectiveOn(TYPE1.getName())) {
      i *= 0.5;
    } 
    if (type.hasNoEffect(TYPE1.getName())) {
      i *= 0;
    }
    if (TYPE2 != null) {
      if (type.isSuperEffectiveOn(TYPE2.getName())) {
        i *= 2;
      } 
      if (type.isNotVeryEffectiveOn(TYPE2.getName())) {
        i *= 0.5;
      } 
      if (type.hasNoEffect(TYPE2.getName())) {
        i *= 0;
      }
    }
    return i;
  }

  
/**
 *  prints out the level up moveset of the pokemon
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void printLevelUpMoveset() {
    System.out.println(Arrays.asList(MOVESET));
  }

  
/**
 *  gets possible forms of the species
 *
 *  @return Possible forms of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Forms[] getForms() {
    return FORMS;
  }

  
/**
 *  gets base stats of the species
 *
 *  @return Base stat of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int[] getBaseStats() {
    return BASE_STATS;
  }

  
/**
 *  gets base exp of the species
 *
 *  @return Base exp of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getBaseExp() {
    return BASE_EXP;
  }

  
/**
 *  gets catch rate of the species
 *
 *  @return Catch rate of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getCatchRate() {
    return CATCHRATE;
  }

  
/**
 *  gets index of an ability of the species, or -1 if not found
 *
 *  @param a Ability of species
 *  @return Index of ability or -1 if not found
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getIndexAbility(Ability a) {
    for (int index = 0; index < ABILITIES.length; index ++) {
      if (ABILITIES[index] == a) {
        return index;
      }
    }
    return -1;
  }

  
/**
 *  checks if the species has an evolution
 *
 *  @return True if has evolution
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public boolean hasEvolution() {
    return EVOLUTION != null;
  }

  
/**
 *  gets evolution of the species, if any
 *
 *  @return Evolution if it has one
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Species getEvolution() {
    return EVOLUTION;
  }

  
/**
 *  gets evolution method
 *
 *  @return Method of evolution
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public Object[] getEvolutionMethod() {
    return EVOLUTION_METHOD;
  }

  
/**
 *  gets random species
 *
 *  @return Random species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public static Species getRandomSpecies() {
    Random random = new Random();
    return values()[random.nextInt(values().length)];
  }

  
/**
 *  gets EV yield of the pokemon
 *
 *  @return Effort points of the pokemon
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int[] getEVYield() {
    return EFFORT_POINTS;
  }

  
/**
 *  gets poke dex number of the species
 *
 *  @return Dex number of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getDexNumber() {
    return DEX_NUMBER;
  }

  
/**
 *  gets back sprite of the species
 *
 *  @return Back sprite of the species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getBattleBack() {
    String str = "";
    if (this.getDexNumber() < 10) {
      str = "00";
    }
    else if (this.getDexNumber() < 100) {
      str = "0";
    }
    return "Graphics/battler/" + str + this.getDexNumber() + "b.png";
  }

  
/**
 *  gets front sprite of the species
 *
 *  @return Front sprite string of species
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public String getBattleFront() {
    String str = "";
    if (this.getDexNumber() < 10) {
      str = "00";
    }
    else if (this.getDexNumber() < 100) {
      str = "0";
    }
    return "Graphics/battler/" + str + this.getDexNumber() + ".png";
  }

  
}