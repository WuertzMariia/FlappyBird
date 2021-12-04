package sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

public class Bird {
    /**
     * Class variables
     */
    private Vector3 position;
    private Vector3 velocity;
    public static final int GRAVITY = -15;
    private Texture bird;
    public static final int MOVING = 100;

    /**
     * Bird constructor
     */
    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        bird = new Texture("bird.png");
    }

    /**
     * Getters
     */
    public Vector3 getPosition() {
        return position;
    }

    public Texture getBird() {
        return bird;
    }

    /** Add flying functionality to bird object */
    public void update(float dt) {
        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVING * dt, velocity.y, 0);
        if (position.y < 0) {
            position.y = 0;
        }
        velocity.scl(1 / dt);
    }

    public void fly() {
        velocity.y = 250;
    }

}
