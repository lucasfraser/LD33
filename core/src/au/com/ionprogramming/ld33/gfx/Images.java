package au.com.ionprogramming.ld33.gfx;


import com.badlogic.gdx.graphics.Texture;

public class Images {

    public static Texture grass;
    public static Texture IPL;

    public static void loadImages(){
        grass = new Texture("grass.png");
        IPL = new Texture("IonProgrammingLogo640.png");

//        player = new Texture("Game-Character-2.png");
    }
}
