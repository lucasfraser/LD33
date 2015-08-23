package au.com.ionprogramming.ld33.gfx;

import au.com.ionprogramming.ld33.entities.Entity;
import au.com.ionprogramming.ld33.entities.Firefly;
import au.com.ionprogramming.ld33.entities.Player;
import au.com.ionprogramming.ld33.logic.Physics;
import au.com.ionprogramming.ld33.map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Renderer {

    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    private float camWidth = 8;
    private float camHeight = 8;

    private float borderX = 1;
    private float borderY = 1;

    private OrthographicCamera cam;

    private SpriteBatch batch;
    private SpriteBatch bg;
    private ShapeRenderer shapeRenderer;

    private SpeechBubble testBubble;                    //test
    private Firefly fly;

    public Renderer(Physics physics, Lighting lighting){

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(camWidth*(w/h), camHeight);
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();

        batch = new SpriteBatch();
        bg = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        Map.loadMap(20, 8, new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 1, 5, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 4, 5, -1, -1, 3, 8, 6, -1, -1,
                -1, -1, -1, 1, 1, -1, -1, -1, 1, 1, -1, 3, 6, -1, -1, -1, -1, -1, -1, -1,
                -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 3, 6, -1, -1, -1, -1, -1, -1, -1,
                -1, 4, 1, 5, -1, 4, 1, 1, 5, -1, 0, 3, 6, -1, -1, -1, -1, -1, -1, -1,
                0, 3, 8, 6, -1, -1, -1, -1, -1, -1, -1, 3, 6, -1, -1, -1, -1, -1, -1, -1,
                1, 2, 8, 7, 1, 1, 1, 1, 1, 1, 1, 2, 7, 1, 1, 1, 1, 1, 1, 1}, entities, physics, lighting);

        fly = new Firefly(4, 3.5f, physics.getWorld(), lighting);
        entities.add(fly);
        entities.add(new Player(0, 2, 1, 2, physics.getWorld(), Images.monster, lighting));

        testBubble = new SpeechBubble("Hello! Lucas is a bloody \nDICK NOSE!", 2f);           //test
        entities.get(entities.size() - 1).setSpeechBubble(testBubble);
    }

    public void render(){
        setCamPos(entities.get(entities.size() - 1));
        cam.update();

        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(cam.combined);
        batch.setProjectionMatrix(cam.combined);

        bg.setProjectionMatrix(cam.combined);

        bg.begin();
            for( int x = 0; x < 10; x++) {
                bg.draw(Images.stars, x*8, 0, 8, 8);
                bg.draw(Images.trees, x * 8, 0, 8, 8);
            }
        bg.end();

        batch.begin();
            for(int i = 0; i < entities.size(); i++){
                entities.get(i).render(shapeRenderer, batch);
            }
        batch.end();
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).renderSpeechBubble(shapeRenderer, batch);
        }
        fly.update();

        System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

    }

    public void setCamPos(Entity focus){
        float xOffset = focus.getBody().getPosition().x - cam.position.x;
        float yOffset = focus.getBody().getPosition().y - cam.position.y;
        if(xOffset < 0){
            xOffset += borderX;
            if(xOffset > 0){
                xOffset = 0;
            }
        }
        else{
            xOffset -= borderX;
            if(xOffset < 0){
                xOffset = 0;
            }
        }
        if(yOffset < 0){
            yOffset += borderY;
            if(yOffset > 0){
                yOffset = 0;
            }
        }
        else{
            yOffset -= borderY;
            if(yOffset < 0){
                yOffset = 0;
            }
        }
        cam.translate(xOffset, yOffset);
    }

    public void setCamBounds(float width, float height){
        cam.viewportHeight = camHeight;
        cam.viewportWidth = camWidth*(width/height);
    }

    public OrthographicCamera getCam() {
        return cam;
    }

}
