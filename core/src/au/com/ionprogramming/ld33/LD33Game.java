package au.com.ionprogramming.ld33;


import au.com.ionprogramming.ld33.gfx.*;
import au.com.ionprogramming.ld33.logic.Physics;
import au.com.ionprogramming.ld33.sfx.SoundHandler;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LD33Game extends ApplicationAdapter {

	private Physics physics;
	private Renderer renderer;
	private Lighting lighting;
	private SoundHandler sound;

	public static boolean INTRO = true;
	public static boolean TITLE_SCREEN = true;

	private SpriteBatch batch;


	@Override
	public void create () {

		Images.loadImages();

		physics = new Physics();
		lighting = new Lighting(physics);
		renderer = new Renderer(physics, lighting);
		sound = new SoundHandler();
//		sound.play("sounds/song1.mp3", true);

		batch = new SpriteBatch();


	}

	@Override
	public void render () {

		if(INTRO){
			batch.begin();
				IntroScreen.render(batch);
			batch.end();
		}
		else if(TITLE_SCREEN){
			batch.begin();
				Menu.render(batch);
			batch.end();
		}
		else{
			renderer.render(physics.getWorld());
			physics.render(renderer.getCam());
			lighting.render(renderer.getCam());
			physics.doPhysicsStep(Gdx.graphics.getDeltaTime());
		}

	}

	@Override
	public void resize(int width, int height){

		batch.getProjectionMatrix().setToOrtho2D(0, 0, width, height);

		if(width < 640){
			Gdx.graphics.setDisplayMode(640, Gdx.graphics.getHeight(), false);
		}
		if(height < 480){
			Gdx.graphics.setDisplayMode(Gdx.graphics.getWidth(), 480, false);
		}

		renderer.setCamBounds(width, height);
	}
}
