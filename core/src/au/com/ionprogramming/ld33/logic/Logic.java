package au.com.ionprogramming.ld33.logic;

import au.com.ionprogramming.ld33.entities.*;
import au.com.ionprogramming.ld33.gfx.Images;
import au.com.ionprogramming.ld33.gfx.Lighting;
import au.com.ionprogramming.ld33.gfx.Renderer;
import au.com.ionprogramming.ld33.gfx.SpeechBubble;
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
    private Alpaca alpaca;
    private Cow cow;
    private Duck duck;
    private Fox fox;
    private Frog frog;
    private Pig pig;
    private Snake snake;
    private Turtle turtle;

    private boolean haveCarrot = false;
    private boolean haveBalloon = false;
    private boolean haveLolly = false;
    private boolean haveDuckling = false;
    private boolean haveBottle = false;
    private boolean haveScones = false;
    private boolean haveManure = false;
    private boolean haveMilk = false;
    private boolean haveScarf = false;
    private boolean haveHat = false;

    public Logic(World world, Lighting lighting){
        balloon = new Balloon(19, 16, world, lighting);
        carrot = new Carrot(2, 11, world, lighting);
        lolly = new Lolly(8, 2, world, lighting);

        player = new Player(3, 2, world, lighting);
        hedgehog = new Hedgehog(34, 18, world, lighting);
        rabbit = new Rabbit(44, 7, world, lighting);
        alpaca = new Alpaca(52, 13, world, lighting);
        cow = new Cow(65, 12, world, lighting);
        duck = new Duck(82, 9, world, lighting);
        fox = new Fox(71, 1, world, lighting);
        frog = new Frog(88, 6, world, lighting);
        pig = new Pig(94, 9, world, lighting);
        snake = new Snake(29, 7, world, lighting);
        turtle = new Turtle(23, 1, world, lighting);

        hedgehog.setSpeechBubble(new SpeechBubble("I popped my balloon and now I'm sad...", 2));
        hedgehog.setSpeechActive(true);
        rabbit.setSpeechBubble(new SpeechBubble("Time for dinner, but I can't seem to find any food...", 2));
        rabbit.setSpeechActive(true);
        alpaca.setSpeechBubble(new SpeechBubble("Brrr... Its chilly tonight, and my neck really feels the cold!", 2));
        alpaca.setSpeechActive(true);
        cow.setSpeechBubble(new SpeechBubble("My garden just isn't growing the way I'd like. Hmmmmmmm...", 2));
        cow.setSpeechActive(true);
        duck.setSpeechBubble(new SpeechBubble("My baby! My baby! Oh, where is he!?", 2));
        duck.setSpeechActive(true);
        fox.setSpeechBubble(new SpeechBubble("Looking for someone? I'll hand the little tyke over if you can answer my riddle! Ahem...\nWhat do I say?\n[y]- Ringadingdingding", 2));
        fox.setSpeechActive(true);
        frog.setSpeechBubble(new SpeechBubble("I feel awful! My sore throat has ruined my croak!", 2));
        frog.setSpeechActive(true);
        pig.setSpeechBubble(new SpeechBubble("I was just about to bake some scones, but I'm out of milk.", 2));
        pig.setSpeechActive(true);
        snake.setSpeechBubble(new SpeechBubble("Oh, I'm freezing out here!", 2));
        snake.setSpeechActive(true);
        turtle.setSpeechBubble(new SpeechBubble("Blimey! Some red whiskery fellow flipped me upside down and left me to rot! Gimme a hand would you? I'll give you a fancy hat! [y]", 2));
        turtle.setSpeechActive(true);

        Renderer.entities.add(balloon);
        Renderer.entities.add(carrot);
        Renderer.entities.add(lolly);

        Renderer.entities.add(player);
        Renderer.entities.add(hedgehog);
        Renderer.entities.add(rabbit);
        Renderer.entities.add(alpaca);
        Renderer.entities.add(cow);
        Renderer.entities.add(duck);
        Renderer.entities.add(fox);
        Renderer.entities.add(frog);
        Renderer.entities.add(pig);
        Renderer.entities.add(snake);
        Renderer.entities.add(turtle);
    }

    public boolean isClose(Entity ent1, Entity ent2){
        if(ent1 == null || ent2 == null){
            return false;
        }
        return (Math.abs(ent1.getBody().getPosition().x - ent2.getBody().getPosition().x) <= ent1.getSize().x/2 + ent2.getSize().x/2
                && Math.abs(ent1.getBody().getPosition().y - ent2.getBody().getPosition().y) <= ent1.getSize().y/2 + ent2.getSize().y/2);
    }

    public Player getPlayer(){
        return player;
    }

    public void update(World world){
        if(!haveCarrot && isClose(player, carrot)){
            setHaveCarrot(true);
            Renderer.entities.remove(carrot);
            world.destroyBody(carrot.getBody());
            carrot = null;
        }
        if(!haveBalloon && isClose(player, balloon)){
            setHaveBalloon(true);
            Renderer.entities.remove(balloon);
            world.destroyBody(balloon.getBody());
            balloon = null;
        }
        if(!haveLolly && isClose(player, lolly)){
            setHaveLolly(true);
            Renderer.entities.remove(lolly);
            world.destroyBody(lolly.getBody());
            lolly = null;
        }
        if(haveCarrot && rabbit.answerYes()){
            setHaveCarrot(false);
            rabbit.setSpeechBubble(new SpeechBubble("Mmm, crunchy! Many thanks!", 2));
        }
        if(haveBalloon && hedgehog.answerYes()){
            setHaveBalloon(false);
            hedgehog.setSpeechBubble(new SpeechBubble("Thanks mister!", 2));
        }
        if(haveLolly && frog.answerYes()){
            setHaveLolly(false);
            frog.setSpeechBubble(new SpeechBubble("You marvellous chap! You've saved this old frog's croak!", 2));
            setHaveBottle(true);
        }
        if(haveDuckling && duck.answerYes()){
            setHaveDuckling(false);
            duck.setSpeechBubble(new SpeechBubble("Oh, you saved my baby! You're my hero!", 2));
        }
        if(haveBottle && snake.answerYes()){
            setHaveBottle(false);
            snake.setSpeechBubble(new SpeechBubble("Mmm, yesssss, just like sssummer...", 2));
            setHaveScarf(true);
        }
        if(turtle.isOnBack() && turtle.answerYes()){
            turtle.flipUp();
            turtle.setSpeechBubble(new SpeechBubble("The world needs more people like you, kind sir ghost!", 2));
            setHaveHat(true);
        }
        if(!fox.isHungry() && fox.answerYes()){
            fox.setHungry(true);
            setHaveDuckling(true);
            if(haveScones){
                setHaveScones(true);
            }
            else {
                fox.setSpeechBubble(new SpeechBubble("Oh, but I'm so hungry!", 2));
            }
        }
        else if(fox.isHungry() && haveScones && fox.answerYes()){
            setHaveScones(false);
            fox.setSpeechBubble(new SpeechBubble("These are delicious! Much better than duckling!", 2));
        }
        if(haveManure && cow.answerYes()){
            setHaveManure(false);
            cow.setSpeechBubble(new SpeechBubble("I think I can see new shoots already!", 2));
            setHaveMilk(true);
        }
        if(haveMilk && pig.answerYes()){
            setHaveMilk(false);
            pig.setSpeechBubble(new SpeechBubble("Ahh, the smell of freshly baked scones...", 2));
            setHaveScones(true);
        }
        if(haveScarf && alpaca.answerYes()){
            setHaveScarf(false);
            alpaca.setSpeechBubble(new SpeechBubble("Don't eat that. Strictly plants only. Hehe...", 2));
            alpaca.setTex(Images.alpacaScarf);
            setHaveManure(true);
        }
    }


    public boolean isHaveCarrot() {
        return haveCarrot;
    }

    public void setHaveCarrot(boolean haveCarrot) {
        if(haveCarrot) {
            rabbit.setSpeechBubble(new SpeechBubble("Ooo! That carrot would make a lovely meal! May I have it? \n [y]", 2));
        }
        this.haveCarrot = haveCarrot;
    }

    public boolean isHaveBalloon() {
        return haveBalloon;
    }

    public void setHaveBalloon(boolean haveBalloon) {
        if(haveBalloon) {
            hedgehog.setSpeechBubble(new SpeechBubble("Another balloon! Can I have it?! Pretty pretty please?! \n [y]", 2));
        }
        this.haveBalloon = haveBalloon;
    }

    public boolean isHaveLolly() {
        return haveLolly;
    }

    public void setHaveLolly(boolean haveLolly) {
        if(haveLolly) {
            frog.setSpeechBubble(new SpeechBubble("Is that a cough lolly? That's bound to fix my sore throat! Could I have it? You can have this hot water bottle in return. My sensitive skin doesn't appreciate it. \n [y]", 2));
        }
        this.haveLolly = haveLolly;
    }

    public boolean isHaveDuckling() {
        return haveDuckling;
    }

    public void setHaveDuckling(boolean haveDuckling) {
        if(haveDuckling) {
            duck.setSpeechBubble(new SpeechBubble("Oh! You found my Baby?! \n [y]", 2));
        }
        this.haveDuckling = haveDuckling;
    }

    public boolean isHaveBottle() {
        return haveBottle;
    }

    public void setHaveBottle(boolean haveBottle) {
        if(haveBottle) {
            snake.setSpeechBubble(new SpeechBubble("That hot water bottle looksssss lovely and warm! May I have it? This scarf isn't doing the trick...\n [y]", 2));
        }
        this.haveBottle = haveBottle;
    }

    public boolean isHaveScones() {
        return haveScones;
    }

    public void setHaveScones(boolean haveScones) {
        if(fox.isHungry() && haveScones) {
            fox.setSpeechBubble(new SpeechBubble("Oh my! Those scones look delicious! Could I trouble you for a bite? \n [y]", 2));
        }
        this.haveScones = haveScones;
    }

    public boolean isHaveManure() {
        return haveManure;
    }

    public void setHaveManure(boolean haveManure) {
        if(haveManure) {
            cow.setSpeechBubble(new SpeechBubble("'SNIFF' Is that alpaca dung I smell? And... 'SNIFF' Nice and fresh! Could I have some for my garden? I'll squeeze you some fresh milk in return.\n [y]", 2));
        }
        this.haveManure = haveManure;
    }

    public boolean isHaveMilk() {
        return haveMilk;
    }

    public void setHaveMilk(boolean haveMilk) {
        if(haveMilk) {
            pig.setSpeechBubble(new SpeechBubble("Is that milk? Just what I need for my scones! May I have a cup or two? You can have some once they're baked.\n [y]", 2));
        }
        this.haveMilk = haveMilk;
    }

    public boolean isHaveScarf() {
        return haveScarf;
    }

    public void setHaveScarf(boolean haveScarf) {
        if(haveScarf) {
            alpaca.setSpeechBubble(new SpeechBubble("That scarf look jolly comfortable! Could I borrow it for the night? I'll give you some quality fertiliser as a thank you.\n [y]", 2));
        }
        this.haveScarf = haveScarf;
    }

    public boolean isHaveHat() {
        return haveHat;
    }

    public void setHaveHat(boolean haveHat) {
        turtle.setTex(Images.turtleNoHat);
        player.setTexSet(Images.monsterHat);
        this.haveHat = haveHat;
    }

}
