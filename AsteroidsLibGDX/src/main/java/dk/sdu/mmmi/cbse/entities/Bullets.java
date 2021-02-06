package dk.sdu.mmmi.cbse.entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

public class Bullets extends SpaceObject {

    private float speed;
    private boolean remove;


    private float lifeTimer;
    private float lifeTime;
    private float width, height;

    public Bullets(float x ,float y, float radians) {
        speed = 350;


        this.radians = radians;
        this.x = x;
        this.y = y;


        dx = MathUtils.cos(radians) * speed;
        dy = MathUtils.sin(radians) * speed;

        width = height = 2;
        lifeTime = 1;
        lifeTimer = 0;

    }


    public boolean shouldRemove() {
        return remove;
    }

    public void update (float dt) {

        x += dx * dt;
        y += dy * dt;

        lifeTimer += dt;
        if(lifeTimer>lifeTime){
            remove = true;
        }

        wrap();

    }

    public void draw(ShapeRenderer sr) {

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(1,1,1,1);
        sr.circle(x-width/2, y-height / 2, width/2);

        sr.end();

    }
}
