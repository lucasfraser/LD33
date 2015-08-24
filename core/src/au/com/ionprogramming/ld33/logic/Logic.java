package au.com.ionprogramming.ld33.logic;

import au.com.ionprogramming.ld33.entities.*;
import au.com.ionprogramming.ld33.gfx.Lighting;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Logic {

    private Balloon balloon;
    private Carrot carrot;
    private Lolly lolly;

    private Player player;
    private Hedgehog hedgehog;
    private Rabbit rabbit;

    public Logic(World world, Lighting lighting){
        balloon = new Balloon(0, 0, world, lighting);
        carrot = new Carrot(0, 0, world, lighting);
        lolly = new Lolly(0, 0, world, lighting);

        player = new Player(0, 0, world, lighting);
        hedgehog = new Hedgehog(0, 0, world, lighting);
        rabbit = new Rabbit(0, 0, world, lighting);

    }

    public ArrayList<Entity> getEntities(){
        ArrayList<Entity> ents = new ArrayList<Entity>();

        ents.add(balloon);
        ents.add(carrot);
        ents.add(lolly);

        ents.add(player);
        ents.add(hedgehog);
        ents.add(rabbit);

        return ents;
    }

    public Player getPlayer(){
        return player;
    }

    public void update(){

    }
}
