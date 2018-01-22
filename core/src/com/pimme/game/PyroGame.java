package com.pimme.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.pimme.game.screens.MenuScreen;
import com.pimme.game.tools.Graphics;
import com.pimme.game.tools.Utils;

public class PyroGame extends Game
{
    public SpriteBatch batch;
    public static int V_WIDTH = 700;
    public static int V_HEIGHT = 400;
    public static final int SWIM_V_WIDTH = 400;
    public static final int SWIM_V_HEIGHT = 250;

    public static final float PPM = 100; // pixel per meter
    public static final float FPS = 60;

    public static final short NOTHING_BIT = 0;
    public static final short BRICK_BIT = 1;
    public static final short PLAYER_BIT = 2;
    public static final short ENEMY_BIT = 4;
    public static final short COIN_BIT = 8;
    public static final short ENEMY_HEAD_BIT = 16;
    public static final short SPIKE_BIT = 32;
    public static final short BOUNCE_BIT = 64;
    public static final short TAMPON_BIT = 128;
    public static final short GOAL_BIT = 256;
    public static final short HP_BIT = 512;

    public static Level currentLevel;
    public static AssetManager manager;
    public static Array<Level> completedLevels;

    public enum Level {
        MENS,
        MENS2,
        MENS3,
        BOUNCE,
        FLY,
        SWIM
    }

    @Override
    public void create () {
        batch = new SpriteBatch();
        Graphics.init();
        Utils.load();
        manager = new AssetManager();
        loadSounds();
//        Highscore.load();
//        Highscore.reset();
        setScreen(new MenuScreen(this));
    }

    private void loadSounds() {
        manager.load("audio/music/Avener_lonely_boy.mp3", Music.class);
        manager.load("audio/sounds/coin2.wav", Sound.class);
        manager.load("audio/sounds/bounce.wav", Sound.class);
        manager.load("audio/sounds/enemyBounce.wav", Sound.class);
        manager.load("audio/sounds/healthpack.wav", Sound.class);
        manager.finishLoading();
    }

    @Override
    public void dispose () {
        super.dispose();
        batch.dispose();
    }

}
