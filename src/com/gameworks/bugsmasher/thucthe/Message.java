package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.thucthe.Hiscores;

public class Message implements Drawable {

   Sound SoundGameover;
   boolean animate = false;
   float desiredHeight;
   float desiredWidth;
   float dropY;
   public float fade = 0.0F;
   BitmapFont font;
   float fontWidth;
   BugSmasher g;
   float height;
   Hiscores hiscore;
   private int index = 0;
   float maxTitleResize;
   String message = "";
   float minTitleResize;
   boolean playSound = true;
   float resize;
   float resizeTitle;
   private float second;
   float targetResize;
   float titleResize;
   float width;
   Sound wushSound;
   float x;
   float y;


   public Message(BugSmasher var1) {
      this.g = var1;
      this.hiscore = new Hiscores(this.g);
      Texture var2 = (Texture)this.g.asset.get("chu/font.png", Texture.class);
      var2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font = new BitmapFont(Gdx.files.internal("chu/font.fnt"), new TextureRegion(var2), false);
      this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.fontWidth = this.font.getBounds("A").width;
      this.resize = this.g.screenWidth / this.fontWidth / 3.0F;
      this.targetResize = this.g.screenWidth / this.fontWidth / 9.0F;
      this.font.setScale(this.resize);
      this.y = 0.0F - this.font.getBounds("A").height / 2.0F;
      this.SoundGameover = (Sound)this.g.asset.get("tainguyen/sounds/gameover.wav", Sound.class);
      this.setChoosenMessage();
   }

   public void dispose() {
      this.wushSound.dispose();
   }

   public void draw(SpriteBatch var1) {
      if(this.g.playState != 4 && this.g.playState != 5) {
         if(this.g.playState == 2) {
            this.setChoosenMessage();
            this.font.setScale(this.targetResize);
            this.y = this.g.screenTop - this.g.screenTop / 4.0F;
            this.x = 0.0F - this.font.getBounds(this.message).width / 2.0F;
            this.font.draw(var1, this.message, this.x, this.y);
            return;
         }
      } else {
         if(this.fade < 0.99F) {
            this.fade += 0.01F;
         }

         this.setChoosenMessage();
         this.x = 0.0F - this.font.getBounds(this.message).width / 2.0F;
         if(this.resize > this.targetResize) {
            this.resize -= 0.05F;
         } else if(this.g.playState != 5) {
            this.g.playState = 5;
         }

         this.y = this.g.screenTop - this.g.screenTop / 4.0F;
         this.font.setScale(this.resize);
         this.font.setColor(1.0F, 1.0F, 1.0F, this.fade);
         this.font.draw(var1, this.message, this.x, this.y);
      }

   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public void drawTitle(SpriteBatch var1) {
      this.font.setScale(this.titleResize);
      if(this.titleResize >= this.maxTitleResize) {
         this.resizeTitle = -this.maxTitleResize / 1500.0F;
      }

      if(this.titleResize <= this.minTitleResize) {
         this.resizeTitle = this.maxTitleResize / 1500.0F;
      }

      this.titleResize += this.resizeTitle;
      this.x = 0.0F - this.font.getBounds("Cockroach").width / 2.0F;
      this.y = this.g.screenTop - this.g.screenTop / 4.0F;
      this.font.draw(var1, "Cockroach", this.x, this.y);
      this.x = 0.0F - this.font.getBounds("Killer").width / 2.0F;
      this.y = this.g.screenTop - this.g.screenTop / 4.0F - 1.0F * this.font.getBounds("Killer").height;
      this.font.draw(var1, "Killer", this.x, this.y);
   }

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

   public void setChoosenMessage() {
      if(this.g.screenState == 1) {
         if(this.g.playState == 4) {
            this.message = "GameOver!";
            if(this.playSound) {
               this.SoundGameover.play();
            }

            this.playSound = false;
            this.hiscore.Write();
         }

         if(this.g.playState == 2) {
            this.message = "Paused";
         }
      } else if(this.g.screenState == 0) {
         this.message = "BugSmasher";
         this.maxTitleResize = this.g.screenWidth / this.fontWidth / 7.3F;
         this.minTitleResize = this.g.screenWidth / this.fontWidth / 7.5F;
         this.titleResize = this.maxTitleResize;
         this.resizeTitle = -this.maxTitleResize / 1500.0F;
         return;
      }

   }

   public void setLeftWidth(float var1) {}

   public void setMinHeight(float var1) {}

   public void setMinWidth(float var1) {}

   public void setRightWidth(float var1) {}

   public void setTopHeight(float var1) {}
}
