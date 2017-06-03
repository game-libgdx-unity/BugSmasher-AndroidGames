package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.manhinh.MainMenu;
import com.gameworks.bugsmasher.manhinh.Play;
import com.gameworks.utils.AndroidService;

public class UIButton implements Drawable {

   private static int MAIN_MENU = 0;
   private static int PLAY_ACTIVE = 2;
   private static int PLAY_GAMEOVER = 3;
   private static int PLAY_PAUSE = 1;
   TextureAtlas atlas;
   TextButton buttonExit;
   TextButton buttonMainMenu;
   TextButton buttonMainMenu2;
   TextButton buttonPause;
   TextButton buttonPlay;
   TextButton buttonRate;
   TextButton buttonResume;
   BitmapFont font;
   BugSmasher g;
   float h;
   Skin skin;
   Sound sound;
   public Stage stage;
   boolean t = true;
   float t2 = 0.02F;
   private Table table;
   private Table table2;
   private Table table3;
   private Table table4;
   float targetY = 0.0F;
   float temp = 0.0F;
   float w;
   float x;
   float xText;
   float y;
   float yText;


   public UIButton(BugSmasher var1) {
      this.g = var1;
      this.stage = new Stage();
      this.table = new Table();
      this.table2 = new Table();
      this.table3 = new Table();
      this.table4 = new Table();
      this.atlas = new TextureAtlas("tainguyen/img/ui/button.pack");
      this.skin = new Skin(this.atlas);
      Texture var2 = (Texture)this.g.asset.get("chu/font.png", Texture.class);
      var2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font = new BitmapFont(Gdx.files.internal("chu/font.fnt"), new TextureRegion(var2), false);
      this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      float var3 = this.font.getBounds("A").width;
      float var4 = this.font.getBounds("A").height;
      float var5 = this.g.screenWidth / var3 / 20.0F;
      this.font.setScale(var5);
      TextButton.TextButtonStyle var6 = new TextButton.TextButtonStyle();
      var6.up = this.skin.getDrawable("button.up");
      var6.down = this.skin.getDrawable("button.down");
      var6.font = this.font;
      if(this.g.screenState == 0) {
         this.buttonPlay = new TextButton("PLAY", var6);
      } else {
         this.buttonPlay = new TextButton("PLAY AGAIN", var6);
      }

      float var7 = this.g.screenWidth / 8.0F;
      float var8 = this.g.screenHeight / 60.0F;
      this.buttonPlay.pad(var8, var7, var8, var7);
      this.buttonExit = new TextButton("QUIT", var6);
      this.buttonExit.pad(var8, var7, var8, var7);
      this.buttonRate = new TextButton("REVIEW", var6);
      this.buttonRate.pad(var8, var7, var8, var7);
      this.buttonResume = new TextButton("RESUME", var6);
      this.buttonResume.pad(var8, var7, var8, var7);
      this.buttonMainMenu = new TextButton("MAIN MENU", var6);
      this.buttonMainMenu.pad(var8, var7, var8, var7);
      this.buttonMainMenu2 = new TextButton("MAIN MENU", var6);
      this.buttonMainMenu2.pad(var8, var7, var8, var7);
      this.buttonPause = new TextButton("]]", var6);
      this.buttonPause.pad(var8 / 2.0F, var8 / 2.0F, var8 / 2.0F, var8 / 2.0F);
      if(this.g.screenState == 0) {
         this.table.setBounds(0.0F, 0.0F, this.g.screenWidth, this.g.screenHeight);
         this.table.add((Actor)this.buttonPlay);
         this.table.getCell(this.buttonPlay).spaceBottom(var7 / 2.0F).row();
         this.table.row();
         this.table.add((Actor)this.buttonRate).spaceBottom(var7 / 2.0F).row();
         this.table.row();
         this.table.add((Actor)this.buttonExit);
      } else if(this.g.screenState == 1) {
         this.table2.setBounds(0.0F, 0.0F, this.g.screenWidth, this.g.screenHeight);
         this.table2.add((Actor)this.buttonResume);
         this.table2.getCell(this.buttonResume).spaceBottom(var7 / 2.0F).row();
         this.table2.row();
         this.table2.add((Actor)this.buttonMainMenu);
         this.stage.addActor(this.table2);
         this.table3.add((Actor)this.buttonPause);
         this.table3.setBounds(0.0F, this.g.screenTop - var8 - var4 / 4.0F, this.g.screenWidth, this.g.screenHeight);
         this.table4.setBounds(0.0F, 0.0F, this.g.screenWidth, this.g.screenHeight);
         this.table4.add((Actor)this.buttonPlay);
         this.table4.getCell(this.buttonPlay).spaceBottom(var7 / 2.0F).row();
         this.table4.row();
         this.table4.add((Actor)this.buttonMainMenu2);
      }

      this.stage.addActor(this.table);
      this.stage.addActor(this.table2);
      this.stage.addActor(this.table3);
      this.stage.addActor(this.table4);
      this.sound = (Sound)this.g.asset.get("tainguyen/sounds/click.wav", Sound.class);
      this.buttonPlay.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            ((Game)Gdx.app.getApplicationListener()).setScreen(new Play(UIButton.this.g));
         }
      });
      this.buttonExit.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
        	 if(Gdx.app.getType()==ApplicationType.Android) {
//             	((NativeService)Gdx.app).showMoreGame(); 
             	((AndroidService)Gdx.app).onGameExit();
        	 }
         }
      });
      this.buttonRate.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            if(Gdx.app.getType()==ApplicationType.Android)
             	((AndroidService)Gdx.app).rate();
         }
      });
      this.buttonResume.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            UIButton.this.g.playState = 1;
         }
      });
      this.buttonMainMenu.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(UIButton.this.g));
         }
      });
      this.buttonMainMenu2.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(UIButton.this.g));
         }
      });
      this.buttonPause.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            UIButton.this.sound.play();
            UIButton.this.g.playState = 2;
         }
      });
   }

   public void dispose() {
      this.atlas.dispose();
   }

   public void draw(SpriteBatch var1) {
      if(this.g.screenState == 0) {
         ((Actor)this.stage.getActors().get(MAIN_MENU)).setVisible(true);
      } else {
         ((Actor)this.stage.getActors().get(MAIN_MENU)).setVisible(false);
      }

      if(this.g.screenState == 1) {
         if(this.g.playState == 2) {
            ((Actor)this.stage.getActors().get(PLAY_PAUSE)).setVisible(true);
         } else {
            ((Actor)this.stage.getActors().get(PLAY_PAUSE)).setVisible(false);
         }

         if(this.g.playState == 1) {
            ((Actor)this.stage.getActors().get(PLAY_ACTIVE)).setVisible(true);
         } else {
            ((Actor)this.stage.getActors().get(PLAY_ACTIVE)).setVisible(false);
         }

         if(this.g.playState == 5) {
            ((Actor)this.stage.getActors().get(PLAY_GAMEOVER)).setVisible(true);
         } else {
            ((Actor)this.stage.getActors().get(PLAY_GAMEOVER)).setVisible(false);
         }
      }

      this.stage.act(Gdx.graphics.getDeltaTime());
      this.stage.draw();
   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public float getBottomHeight() {
      return 0.0F;
   }

   public float getLeftWidth() {
      return 0.0F;
   }

   public float getMinHeight() {
      return 0.0F;
   }

   public float getMinWidth() {
      return 0.0F;
   }

   public float getRightWidth() {
      return 0.0F;
   }

   public float getTopHeight() {
      return 0.0F;
   }

   public void setBottomHeight(float var1) {}

   public void setLeftWidth(float var1) {}

   public void setMinHeight(float var1) {}

   public void setMinWidth(float var1) {}

   public void setRightWidth(float var1) {}

   public void setTopHeight(float var1) {}
}
