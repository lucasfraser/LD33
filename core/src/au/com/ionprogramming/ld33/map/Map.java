package au.com.ionprogramming.ld33.map;

import au.com.ionprogramming.ld33.entities.Entity;
import au.com.ionprogramming.ld33.entities.Grass;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.logic.Physics;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Map {
    public static void loadMap(int width, int height, int[] tiles, ArrayList<Entity> entities, Physics physics, Lighting lighting){
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if(tiles[(height - y - 1) * width + x] > 0) {
                    entities.add(new Grass(x, y, physics.getWorld(), lighting, tiles[(height - y - 1) * width + x]));
                }
            }
        }
    }
}
