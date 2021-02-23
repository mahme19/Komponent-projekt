package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * @param gameData In order to start event entities to the game, game data is also a parameter for creating a playership.
     * @param world In order to load game entities.
     */

    void start(GameData gameData, World world);


    /**

     * @param gameData Removes event entity.
     * @param world Removes instances of Players.
     */
    void stop(GameData gameData, World world);
}
