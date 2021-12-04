package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyFluppyBird;

import sprites.Bird;
import sprites.Tube;

public class PlayState extends State {
    /**
     * Class variables
     */
    public static final int TUBE_SPACE = 125;
    public static final int COUNT = 4;
    private Bird bird;
    private Texture gameBackground;
    private Tube tube;
    private Array<Tube> tubes;

    /**
     * PlayState Constructor
     */
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(50, 300);
        camera.setToOrtho(false, MyFluppyBird.WIDTH / 2, MyFluppyBird.HEIGHT / 2);
        gameBackground = new Texture("bg.png");
        tubes = new Array<Tube>();
        for (int i = 1; i < COUNT; i++) {
            tubes.add(new Tube(i * (TUBE_SPACE + Tube.TUBE_WIDHT)));
        }
    }

    /**
     * Change bird position on screen touch / on mouse click
     */
    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            bird.fly();
        }
    }

    /**
     * update screen on touch/click
     */
    @Override
    public void update(float dt) {
        handleInput();
        bird.update(dt);
        camera.position.x = bird.getPosition().x + 80;
        for (Tube tube : tubes) {
            if (camera.position.x - (camera.viewportWidth / 2) > tube.getPositionTopTube().x +
                    tube.getTopTube().getWidth()) {
                tube.reposition(tube.getPositionTopTube().x + ((Tube.TUBE_WIDHT + TUBE_SPACE) * COUNT));
            }
        }
        camera.update();
    }

    /**
     * Render new screen
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        sb.draw(gameBackground, camera.position.x - (camera.viewportWidth / 2), 0);
        sb.draw(bird.getBird(), bird.getPosition().x, bird.getPosition().y);
        for (Tube tube : tubes) {
            sb.draw(tube.getTopTube(), tube.getPositionTopTube().x, tube.getPositionTopTube().y);
            sb.draw(tube.getBottomTube(), tube.getPositionBottomTube().x, tube.getPositionBottomTube().y);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
