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

    public static Texture stars;

    public static Texture[] monster;

    public static Texture monster0;
    public static Texture monster1;
    public static Texture monster2;
    public static Texture monster3;

    public static Texture firefly;
    public static Texture balloon;
    public static Texture bush1;
    public static Texture bush2;
    public static Texture carrot;
    public static Texture hedgehog;
    public static Texture lakeLeft;
    public static Texture lakeRight;
    public static Texture log;
    public static Texture lolly;
    public static Texture plant1;
    public static Texture plant2;
    public static Texture plant3;
    public static Texture rabbitBig;
    public static Texture rabbitSmall;
    
    public static void loadImages(){

        IPL = new Texture("IonProgrammingLogo640.png");

        grass0 = new Texture("grass/grass_0.png");
        grass1 = new Texture("grass/grass_1.png");
        grass2 = new Texture("grass/grass_2.png");
        grass3 = new Texture("grass/grass_3.png");
        grass4 = new Texture("grass/grass_4.png");
        grass5 = new Texture("grass/grass_5.png");
        grass6 = new Texture("grass/grass_6.png");
        grass7 = new Texture("grass/grass_7.png");
        grass8 = new Texture("grass/grass_8.png");


        grass = new Texture[]{grass0, grass1, grass2, grass3, grass4, grass5, grass6, grass7, grass8};

        stars = new Texture("backgroundStars.png");
        stars.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        monster0 = new Texture("monster/0.png");
        monster1 = new Texture("monster/1.png");
        monster2 = new Texture("monster/2.png");
        monster3 = new Texture("monster/3.png");

        firefly = new Texture("firefly.png");
        balloon = new Texture("images/balloon.png");
        bush1 = new Texture("images/bush1.png");
        bush2 = new Texture("images/bush2.png");
        carrot = new Texture("images/carrot.png");
        hedgehog = new Texture("images/hedgehog.png");
        lakeLeft = new Texture("images/lakeLeft.png");
        lakeRight = new Texture("images/lakeRight.png");
        log = new Texture("images/log.png");
        lolly = new Texture("images/lolly.png");
        plant1 = new Texture("images/plant1.png");
        plant2 = new Texture("images/plant2.png");
        plant3 = new Texture("images/plant3.png");
        rabbitBig = new Texture("images/rabbitBig.png");
        rabbitSmall = new Texture("images/rabbitSmall.png");

        monster = new Texture[]{monster0, monster1, monster2, monster3};
    }
}
