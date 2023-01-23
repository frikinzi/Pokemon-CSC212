/**
 *  Enum defining a pokemon's nature, which determines which stats are increased/decreased, or not at all
 *
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
public enum Nature {
  
  TIMID(5,1),
  LONELY(1,2),
  ADAMANT(1,3),
  NAUGHTY(1,4),
  BRAVE(1,5),
  BOLD(2,1),
  IMPISH(2,3),
  LAX(2,4),
  RELAXED(2,5),
  BASHFUL(-1,-1),
  HARDY(-1,-1),
  DOCILE(-1,-1),
  QUIRKY(-1,-1),
  SERIOUS(-1,-1),
  MODEST(3,1),
  MILD(3,2),
  RASH(3,4),
  QUIET(3,5),
  CALM(4,1),
  GENTLE(4,2),
  CAREFUL(4,3),
  SASSY(4,5),
  HASTY(5,2),
  JOLLY(5,3),
  NAIVE(5,4);

  int STAT_INCREASED;
  int STAT_DECREASED;

  
/**
 *  constructor defining a nature. stat increased and stat decreased (1 = atk, 2 = def, 3 = spa, 4 = spd, etc.)
 *
 *  @param stat_increased How much the stat increased
 *  @param stat_decreased How much the stat decreased
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  private Nature(int stat_increased, int stat_decreased) {
    STAT_INCREASED = stat_increased;
    STAT_DECREASED = stat_decreased;
  }

  
/**
 *  applies stat boost/nerf given the nature
 *
 *  @param stats Provides list of stat numbers
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public void applyNatureStatBoost(int[] stats) {
    if (STAT_INCREASED == -1) {
      return;
    }
    stats[STAT_INCREASED] *= 1.1;
    stats[STAT_DECREASED] *= 0.9;
  }

  
/**
 *  returns stat that is boosted
 *
 *  @return The boosted stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getStatBoosted() {
    return STAT_INCREASED;
  }

  
/**
 *  returns stat that is nerfed
 *
 *  @return Decreased stat
 *  @author  Angela Jiang, Kira Kaplan, Sian Bareket
 *  @version CSC 212, Fall 2022
 */
  public int getStatDecreased() {
    return STAT_DECREASED;
  }

  
}