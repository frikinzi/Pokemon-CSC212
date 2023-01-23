import com.google.common.graph.*;
import java.util.*;

/**
 *  Class that establishes the world map
 *
 *  @author Angela Jiang, Sian, Kira 
 *  @version CSC 212, Fall 2022
 */
public class WorldMap {

  
  /** 
  *  Constructor to create the Pokemon world map
  *  @return Graph of the world
  */
  public static ImmutableValueGraph<Location, Integer> createWorldMap() {
    ImmutableValueGraph<Location, Integer> world_map = ValueGraphBuilder.undirected()
      .<Location, Integer>immutable()
      .addNode(Location.MOONFORKTOWN)
      .putEdgeValue(Location.MOONFORKTOWN, Location.FLASHBREEZESWAMP, 0)
      .putEdgeValue(Location.MOONFORKTOWN, Location.MOONFORKTOWNPKMCENTER, 0)
      .putEdgeValue(Location.MOONFORKTOWN, Location.COPPERPEAK, 0)
      .putEdgeValue(Location.MOONFORKTOWN, Location.BLAZEFACTORY, 0)
      .putEdgeValue(Location.FLASHBREEZESWAMP, Location.STARGLASSKELPBED, 0)
      .putEdgeValue(Location.FLASHBREEZESWAMP, Location.COPPERPEAK, 0)
      .putEdgeValue(Location.FLASHBREEZESWAMP, Location.MISTGRASSLAND, 0)
      .putEdgeValue(Location.STARGLASSKELPBED, Location.RUSTCRYISLE, 0)
      .putEdgeValue(Location.RUSTCRYISLE, Location.SWEETFLOATWATER, 0)
      .putEdgeValue(Location.SWEETFLOATWATER, Location.SHORTBRUSHHOLLOW, 0)
      .putEdgeValue(Location.SWEETFLOATWATER, Location.BLIZZARDISLAND, 0)
      .putEdgeValue(Location.SHORTBRUSHHOLLOW, Location.SANDSPKMCENTER, 0)
      .putEdgeValue(Location.SHORTBRUSHHOLLOW, Location.GROVEPKMCENTER, 0)
      .putEdgeValue(Location.SANDSPKMCENTER, Location.SHATTERDUNES, 0)
      .putEdgeValue(Location.GROVEPKMCENTER, Location.SUNSPOREFOREST, 0)
      .putEdgeValue(Location.SUNSPOREFOREST, Location.TANGLEPKMCENTER, 0)
      .putEdgeValue(Location.TANGLEPKMCENTER, Location.IRONSWEEPRUINS, 0)
      .putEdgeValue(Location.IRONSWEEPRUINS, Location.NEEDLESUMMIT, 0)
      .putEdgeValue(Location.IRONSWEEPRUINS, Location.BLAZEFACTORY, 0)
      .putEdgeValue(Location.BLAZEFACTORY, Location.COPPERPEAK, 0)
      .putEdgeValue(Location.BLAZEFACTORY, Location.MISTGRASSLAND, 0)
      .putEdgeValue(Location.COPPERPEAK, Location.PEAKPKMCENTER, 0)
      .putEdgeValue(Location.PEAKPKMCENTER, Location.NEEDLESUMMIT, 0)
      .build();
    return world_map;
  }

  
}

