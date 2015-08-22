package au.com.ionprogramming.ld33.gfx;


import com.badlogic.gdx.graphics.Texture;

public class Images {

    public static Texture[] grass;
    public static Texture IPL;

    public static Texture grass0;
    public static Texture grass1;
    public static Texture grass2;
    public static Texture grass3;
    public static Texture grass4;
    public static Texture grass5;
    public static Texture grass6;
    public static Texture grass7;
    public static Texture grass8;



    public static void loadImages(){

        IPL = new Texture("IonProgrammingLogo640.png");

        grass0 = new Texture("test_0.png");
        grass1 = new Texture("test_1.png");
        grass2 = new Texture("test_2.png");
        grass3 = new Texture("test_3.png");
        grass4 = new Texture("test_4.png");
        grass5 = new Texture("test_5.png");
        grass6 = new Texture("test_6.png");
        grass7 = new Texture("test_7.png");
        grass8 = new Texture("test_8.png");


        grass = new Texture[]{grass0, grass1, grass2, grass3, grass4, grass5, grass6, grass7, grass8};



    }
}
