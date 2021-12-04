package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyFluppyBird;

public class MenuState extends State {
    /**
     * Class variables
     */
    private Texture background;
    private Texture playBtn;

    /**
     * MenuState constructor
     */
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
        playBtn = new Texture("playbtn.png");
    }

    /**
     * On click or touch clear current playground and add new playground to stack
     */
    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            gsm.set(new PlayState(gsm));
        }
    }

    /**
     * Update actions
     */
    @Override
    public void update(float dt) {
        handleInput();
    }

    /**
     * Render background and button
     */
    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, MyFluppyBird.WIDTH, MyFluppyBird.HEIGHT);
        sb.draw(playBtn, (MyFluppyBird.WIDTH / 2) - (playBtn.getWidth() / 2), MyFluppyBird.HEIGHT / 2);
        sb.end();
    }

    /**
     * Dispose of background and button
     */
    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
