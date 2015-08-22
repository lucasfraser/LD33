package au.com.ionprogramming.ld33;


import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.IntroScreen;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.Renderer;
import au.com.ionprogramming.ld33.logic.Physics;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class LD33Game extends ApplicationAdapter {

	private Physics physics;
	private Renderer renderer;
	private Lighting lighting;

	public static boolean INTRO = false;
	public static boolean TITLE_SCREEN = false;

	private SpriteBatch batch;


	@Override
	public void create () {

		Images.loadImages();

		physics = new Physics();
		lighting = new Lighting(physics);
		renderer = new Renderer(physics, lighting);

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

		}
		else{
			renderer.render();
			physics.render(renderer.getCam());
			lighting.render(renderer.getCam());
			physics.doPhysicsStep(Gdx.graphics.getDeltaTime());
		}

	}

	@Override
	public void resize(int width, int height){
		renderer.setCamBounds(width, height);
	}
}
