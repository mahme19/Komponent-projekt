package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {
/**
 * @param world With this parameter we are getting the player entity.
 * @param gameData This enables you to get the keys pressed by the player, and updates the position of player inside map.
 * */
    void process(GameData gameData, World world);
}
