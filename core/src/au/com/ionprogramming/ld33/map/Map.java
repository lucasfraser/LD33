package au.com.ionprogramming.ld33.map;

import au.com.ionprogramming.ld33.entities.*;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.logic.Physics;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Map {
    public static void loadMap(int width, int height, int[] tiles, ArrayList<Entity> entities, ArrayList<BGEntity> bgEntities, Physics physics, Lighting lighting){
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int position = (height - y - 1) * width + x;
                int block = tiles[position];

                //GRASS
                if(block > 0 && block <= 10) {
                    entities.add(new Grass(x, y, physics.getWorld(), lighting, block-1));
                }

                //ROOTS
                if(block >= 11 && block <= 14) {
                    bgEntities.add(new Roots(x, y, physics.getWorld(), lighting, block-11));
                }

                //PLANTS
                if(block >= 19 && block <= 21) {
                    bgEntities.add(new Plant(x, y, physics.getWorld(), lighting, block-19));
                }

                //BUSHES
                if(block >= 15 && block <= 16) {
                    bgEntities.add(new Bush(x, y, physics.getWorld(), lighting, block-15));
                }

                //LOG
                if(block == 17) {
                    bgEntities.add(new Log(x, y, physics.getWorld(), lighting));
                }

                //TREES
                if(block >= 33 && block <= 38) {
                    bgEntities.add(new Tree(x-1, y, physics.getWorld(), lighting, block-33));
                }

                //FIRE
                if(block == 39) {
                    bgEntities.add(new Campfire(x, y, physics.getWorld(), lighting));
                }

                //FIREFLIES
                if(block == 41){
                    entities.add(new Firefly(x, y, physics.getWorld(), lighting));
                }

            }
        }
    }
}
