package au.com.ionprogramming.ld33.sfx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class SoundHandler {

    private Music song;

    public void play(String file, boolean loop){
        if(song != null){
            song.dispose();
        }
        song = Gdx.audio.newMusic(Gdx.files.internal(file));
        song.setLooping(loop);
        song.play();
    }
}
