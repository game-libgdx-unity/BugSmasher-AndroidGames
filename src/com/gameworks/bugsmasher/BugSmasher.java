package com.gameworks.bugsmasher;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.gameworks.bugsmasher.manhinh.Splash;
import com.gameworks.bugsmasher.thoat.ExitUI;

public class BugSmasher extends Game implements ApplicationListener {

   public static final int MAIN_MENU = 0;
   public static final int PLAY = 1;
   public static final int PLAY_ACTIVE = 1;
   public static final int PLAY_CHANGE_LEVEL = 3;
   public static final int PLAY_GAMEOVER = 4;
   public static final int PLAY_PAUSE = 2;
   public static final int PLAY_RESTART = 5;
   public static final int PLAY_START = 0;
   public static final int SPLASH = 2;
   public AssetManager asset;
   public Music backgroundMusic;
   public float bottomSection;
   public int changeLevel = 2;
   public float contentSection;
   public ExitUI exitUI;
   public int forbiddenToKill = 0;
   public int level;
   public int life;
   public int perkill = 5;
   public int playState;
   BugSmasher.RequestHandler requestHandler;
   public float screenBottom;
   public float screenHeight;
   public float screenIntersection;
   public float screenLeft;
   public float screenRight;
   public int screenState;
   public float screenTop;
   public float screenWidth;
   public float topSection;
   public int totalBugsType = 10;
   public int totalKilled;


   public void ConfirmTest(BugSmasher.RequestHandler var1) {
      this.requestHandler = var1;
   }

   public void create() {
      this.asset = new AssetManager();
      this.screenWidth = (float)Gdx.graphics.getWidth();
      this.screenHeight = (float)Gdx.graphics.getHeight();
      this.screenTop = 0.5F * this.screenHeight;
      this.screenBottom = -0.5F * this.screenHeight;
      this.screenRight = 0.5F * this.screenWidth;
      this.screenLeft = -0.5F * this.screenWidth;
      Gdx.input.setCatchBackKey(true);
      if(this.screenWidth <= 480.0F) {
         this.bottomSection = 50.0F;
         this.topSection = 50.0F;
      } else {
         this.bottomSection = 90.0F;
         this.topSection = 90.0F;
      }

      this.playState = 1;
      this.contentSection = this.screenHeight - this.bottomSection;
      this.setScreen(new Splash(this));
   }

   public void dispose() {}

   public void pause() {
      super.pause();
   }

   public void render() {
      super.render();
   }

   public void resize(int var1, int var2) {
      super.resize(var1, var2);
   }

   public void resume() {
      super.resume();
   }

   public void showConfirmDialog() {
      this.requestHandler.confirm(new BugSmasher.ConfirmInterface() {
         public void no() {}
         public void yes() {}
      });
   }

   public void start() {
      this.life = 3;
      this.level = 1;
      this.totalKilled = 0;
      this.perkill = 5;
   }

   public interface RequestHandler {

      void confirm(BugSmasher.ConfirmInterface var1);
   }

   public interface ConfirmInterface {

      void no();

      void yes();
   }
}
