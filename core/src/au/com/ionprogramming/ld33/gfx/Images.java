package au.com.ionprogramming.ld33.gfx;


import com.badlogic.gdx.graphics.Texture;

public class Images {

    public static Texture IPL;
    public static Texture Title;

    public static Texture[] grass;

    public static Texture[] roots;

    public static Texture[] tree;

    public static Texture[] monster;

    public static Texture stars;

    public static Texture firefly;
    public static Texture balloon;
    public static Texture[] bush;
    public static Texture carrot;
    public static Texture hedgehog;
    public static Texture log;
    public static Texture lolly;
    public static Texture[] plant;
    public static Texture rabbitBig;
    public static Texture rabbitSmall;
    public static Texture frogBig;
    public static Texture frogSmall;
    public static Texture duckBig;
    public static Texture duckSmall;
    public static Texture[] fire;
    public static Texture fox;
    public static Texture hwb;
    public static Texture milk;
    public static Texture poo;
    public static Texture scarf;
    public static Texture snake;
    public static Texture turtleHat;
    public static Texture turtleNoHat;

    public static Texture play;



    public static void loadImages(){

        IPL = new Texture("IonProgrammingLogo640.png");

        Title = new Texture("title.png");

        grass = new Texture[]{
              new Texture("grass/1_grass_2.png"),
              new Texture("grass/2_grass_3.png"),
              new Texture("grass/3_grass_4.png"),
              new Texture("grass/4_grass_5.png"),
              new Texture("grass/5_grass_6.png"),
              new Texture("grass/6_grass_7.png"),
              new Texture("grass/7_grass_1.png"),
              new Texture("grass/8_grass_8.png"),
              new Texture("grass/9_lakeLeft.png"),
              new Texture("grass/10_lakeRight.png")
        };
        tree = new Texture[]{
                new Texture("images/tree1.png"),
                new Texture("images/tree2.png"),
                new Texture("images/tree3.png"),
                new Texture("images/tree4.png"),
                new Texture("images/tree5.png"),
                new Texture("images/tree6.png")};
        bush = new Texture[]{
                new Texture("images/bush1.png"),
                new Texture("images/bush2.png")};
        plant = new Texture[]{
                new Texture("images/plant1.png"),
                new Texture("images/plant2.png"),
                new Texture("images/plant3.png")};

        roots = new Texture[]{
                new Texture("grass/11_rootLeft.png"),
                new Texture("grass/12_root1.png"),
                new Texture("grass/13_root2.png"),
                new Texture("grass/14_rootRight.png")};

        fire = new Texture[]{
                new Texture("images/fire1.png"),
                new Texture("images/fire2.png"),
                new Texture("images/fire3.png")};

        stars = new Texture("backgroundStars.png");
        stars.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);

        firefly = new Texture("firefly.png");
        balloon = new Texture("images/balloon.png");
        carrot = new Texture("images/carrot.png");
        hedgehog = new Texture("images/hedgehog.png");
        log = new Texture("images/log.png");
        lolly = new Texture("images/lolly.png");
        rabbitBig = new Texture("images/rabbitBig.png");
        rabbitSmall = new Texture("images/rabbitSmall.png");
        frogBig = new Texture("images/frogBig.png");
        frogSmall = new Texture("images/frogSmall.png");
        duckBig = new Texture("images/duckBig.png");
        duckSmall = new Texture("images/duckSmall.png");
        fox = new Texture("images/fox.png");
        hwb = new Texture("images/hwb.png");
        milk = new Texture("images/milk.png");
        poo = new Texture("images/poo.png");
        scarf = new Texture("images/scarf.png");
        snake = new Texture("images/snake.png");
        turtleHat = new Texture("images/turtleHat.png");
        turtleNoHat = new Texture("images/turtleNoHat.png");

        monster = new Texture[]{
                new Texture("monster/0.png"),
                new Texture("monster/1.png"),
                new Texture("monster/2.png"),
                new Texture("monster/3.png")
        };

        play = new Texture("play.png");
    }
}
