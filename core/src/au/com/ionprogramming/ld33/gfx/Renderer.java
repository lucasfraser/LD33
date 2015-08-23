package au.com.ionprogramming.ld33.gfx;

import au.com.ionprogramming.ld33.entities.Entity;
import au.com.ionprogramming.ld33.entities.Firefly;
import au.com.ionprogramming.ld33.entities.Player;
import au.com.ionprogramming.ld33.logic.Physics;
import au.com.ionprogramming.ld33.map.Map;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Renderer {


    public static float px = 0;
    public static float py = 0;


    public static boolean FIGHT_MODE = false;
    public static Color FIGHT_COLOR = new Color(0.8f, 0.4f, 0.4f, 1f);

    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    private float camWidth = 8;
    private float camHeight = 8;

    private float borderX = 1;
    private float borderY = 1;

    private OrthographicCamera cam;

    private SpriteBatch batch;
    private SpriteBatch bg;
    private ShapeRenderer shapeRenderer;

    private SpeechBubble testBubble;

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

        entities.add(new Firefly(4, 5f, physics.getWorld(), lighting));
        entities.add(new Firefly(2, 5f, physics.getWorld(), lighting));
        entities.add(new Firefly(6, 5f, physics.getWorld(), lighting));
        entities.add(new Firefly(8, 5f, physics.getWorld(), lighting));
        entities.add(new Player(0, 2, physics.getWorld(), Images.monster, lighting));

        testBubble = new SpeechBubble("Do you know the Muffin Man?", 2f);           //test
        entities.get(entities.size() - 1).setSpeechBubble(testBubble);
        entities.get(entities.size() - 1).setSpeechActive(true);
    }

    public void render(){

        if(Gdx.input.isKeyPressed(Input.Keys.R)){
            FIGHT_MODE = true;
        }

        setCamPos(entities.get(entities.size() - 1));
        cam.update();

        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(cam.combined);
        batch.setProjectionMatrix(cam.combined);

//        bg.setProjectionMatrix(cam.combined);

        bg.begin();
            if(FIGHT_MODE){
                bg.setColor(FIGHT_COLOR);
            }
            bg.draw(Images.stars, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), px*0.01f - (float)Gdx.graphics.getWidth()/800f, py*0.01f - (float)Gdx.graphics.getHeight()/800f, px*0.01f + (float)Gdx.graphics.getWidth()/800f, py*0.01f + (float)Gdx.graphics.getHeight()/800f);

//            bg.draw(Images.trees, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), px*0.01f - (float)Gdx.graphics.getWidth()/800f, py*0.01f - (float)Gdx.graphics.getHeight()/800f, px*0.01f + (float)Gdx.graphics.getWidth()/800f, py*0.01f + (float)Gdx.graphics.getHeight()/800f);
        bg.end();

        batch.begin();
            if(FIGHT_MODE){
                batch.setColor(FIGHT_COLOR);
            }

            for(int i = 0; i < entities.size(); i++){
                entities.get(i).update();
                entities.get(i).render(shapeRenderer, batch);
            }
        batch.end();

        if(FIGHT_MODE){
            shapeRenderer.setColor(FIGHT_COLOR);
        }
        for(int i = 0; i < entities.size(); i++){
            entities.get(i).renderSpeechBubble(shapeRenderer, batch);
        }


//        System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond() + ", Player: " + px + ", " + py);

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
