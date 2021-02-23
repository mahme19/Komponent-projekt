package asteroidsystem;

import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.UUID;


public class AsteroidPlugin implements IGamePluginService  {

    private Entity asteroid;

    @Override
    public void start(GameData gameData, World world) {
        asteroid = createAsteroid(gameData);
        world.addEntity(asteroid);
    }

    @Override
    public void stop(GameData gameData, World world) {
        world.removeEntity(asteroid);
    }
    private Entity createAsteroid(GameData gameData) {

        float speed = (float) Math.random() * 10f + 40f;



        float rotationSpeed = 5;
        float x = gameData.getDisplayWidth() / MathUtils.random(1,6);
        float y = gameData.getDisplayHeight() / MathUtils.random(1,6);
        float radians = 3.1415f / 2 + (float) Math.random();

        Entity asteroid = new Asteroid();
        asteroid.add(new MovingPart(0, speed, speed, rotationSpeed));
        asteroid.add(new PositionPart(x, y, radians));




        return asteroid;
    }

}
