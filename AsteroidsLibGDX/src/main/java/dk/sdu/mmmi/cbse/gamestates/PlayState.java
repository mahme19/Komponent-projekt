package dk.sdu.mmmi.cbse.gamestates;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import dk.sdu.mmmi.cbse.entities.Bullets;
import dk.sdu.mmmi.cbse.entities.Enemy;
import dk.sdu.mmmi.cbse.entities.Player;
import dk.sdu.mmmi.cbse.managers.GameKeys;
import dk.sdu.mmmi.cbse.managers.GameStateManager;

import java.util.ArrayList;


public class PlayState extends GameState {
	
	private ShapeRenderer sr;
	
	private Player player;
	private Enemy enemy;
	private ArrayList<Bullets> bullets;
	public PlayState(GameStateManager gsm) {
		super(gsm);
	}
	
	public void init() {
		
		sr = new ShapeRenderer();
		bullets = new ArrayList<Bullets>();
		player = new Player();
		enemy = new Enemy (bullets);
	}
	
	public void update(float dt) {
		
		handleInput();
		
		player.update(dt);
		enemy.update(dt);

		// update bullets

		for(int i =0; i<bullets.size(); i++){
			bullets.get(i).update(dt);
			if(bullets.get(i).shouldRemove()){
				bullets.remove(i);
				i--;
			}
		}
	}



	public void draw() {
		player.draw(sr);
		enemy.draw(sr);
		// draw bullets
		for (Bullets bullet : bullets) {
			bullet.draw(sr);
		}

	}
	
	public void handleInput() {
		player.setLeft(GameKeys.isDown(GameKeys.LEFT));
		player.setRight(GameKeys.isDown(GameKeys.RIGHT));
		player.setUp(GameKeys.isDown(GameKeys.UP));

		enemy.setLeft(MathUtils.randomBoolean());
		enemy.setRight(MathUtils.randomBoolean());
		enemy.setUp(MathUtils.randomBoolean());
		enemy.shoot(MathUtils.randomBoolean());
	}
	
	public void dispose() {}

}









