package lt.rdarius.powerpuffgirls;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlayScreen implements Screen {

    private Main game;

    private SpriteBatch batch;

    private TargetableCamera cam;

    private Settings settings;

    private Font font, fontSmall;

    public PlayScreen(Main game) {
        this.game = game;
        this.batch = game.batch;
        this.settings = game.settings;

        cam = new TargetableCamera(Main.V_WIDTH, Main.V_HEIGHT);
        cam.setPosition(Main.V_WIDTH/2, Main.V_HEIGHT/2);
        cam.setMargin(0);

        font = new Font(35, Color.CYAN);
        fontSmall = new Font(20, Color.CYAN);
    }

    public void handleInput(float dt) {


    }

    public void update(float dt) {
        handleInput(dt);
        cam.update();

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();




        fontSmall.write(cam.getProjectedX(Gdx.input.getX())+" - "+cam.getProjectedY(-Gdx.input.getY()), batch, 1000, 20);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        cam.updateViewport();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}