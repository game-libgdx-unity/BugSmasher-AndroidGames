package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.thucthe.Bug;
import com.gameworks.bugsmasher.thucthe.BugImage;

public class MessageBox implements Drawable {

   Bug bug;
   BugImage bugImage;
   BitmapFont font;
   float fontHeight;
   float fontWidth;
   BugSmasher g;
   float h;
   NinePatch nine;
   float paddingX;
   float resize;
   Sound sound;
   float targetY = 0.0F;
   Texture tempTexture;
   String[] tmpS;
   String txt = "";
   float w;
   float x;
   float xText;
   float y;
   float yText;


   public MessageBox(BugSmasher var1) {
      this.g = var1;
      this.tempTexture = new Texture("tainguyen/img/box.9.png");
      this.tempTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.nine = new NinePatch(this.tempTexture, 29, 19, 11, 27);
      this.font = new BitmapFont();
      this.font.setColor(0.0F, 0.0F, 0.0F, 0.6F);
      this.fontWidth = this.font.getBounds("A").width;
      this.fontHeight = this.font.getBounds("A").height;
      this.resize = this.g.screenWidth / this.fontWidth / 40.0F;
      this.font.setScale(this.resize);
      this.fontWidth = this.font.getBounds("A").width;
      this.fontHeight = this.font.getBounds("A").height;
      this.sound = (Sound)this.g.asset.get("tainguyen/sounds/wush.wav", Sound.class);
      this.setText();
      this.bugImage = new BugImage(this.g);
   }

   public void checkTouchDown() {
      if(Gdx.input.isTouched() && this.g.playState == 0 && this.y > this.targetY) {
         this.targetY = this.g.screenTop + this.h;
         this.sound.play();
      }

   }

   public void dispose() {
      this.tempTexture.dispose();
   }

   public void draw(SpriteBatch var1) {
      if(this.g.playState == 0) {
         String[] var2 = this.txt.split("\n");
         this.nine.draw(var1, this.x, this.y, this.w, this.h);

         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.xText = 0.0F - this.font.getBounds(var2[var3]).width / 2.0F;
            if(this.g.level <= this.g.totalBugsType) {
               this.yText = this.y + this.h - (float)(var3 + 1) * 3.0F * this.fontHeight + this.fontHeight - 1.5F * (float)this.bug.size;
            } else {
               this.yText = this.y + this.h - (float)(var3 + 1) * 3.0F * this.fontHeight + this.fontHeight;
            }

            if(var3 == -1 + var2.length) {
               this.font.setColor(1.0F, 0.0F, 0.0F, 0.6F);
            } else {
               this.font.setColor(0.0F, 0.0F, 0.0F, 0.6F);
            }

            this.font.draw(var1, var2[var3], this.xText, this.yText);
            this.yText += 2.0F * this.fontHeight;
         }

         if(this.y < this.targetY) {
            this.y += 0.03F * this.g.screenHeight;
         }

         if(this.y > this.g.screenTop) {
            this.g.playState = 1;
         }

         if(this.g.level <= this.g.totalBugsType) {
            this.bug.y = this.y + this.h - 1.5F * (float)this.bug.size;
            this.bugImage.draw(var1, this.bug, Gdx.graphics.getDeltaTime());
         }
      }

   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public float getBottomHeight() {
      return 0.0F;
   }

   public String getInsectName(int var1) {
      return var1 == 0?"Ant":(var1 == 1?"Carpet Bettle":(var1 == 2?"Bee":(var1 == 3?"Cockroach":(var1 == 4?"Butterfly":(var1 == 5?"Mosquito":(var1 == 6?"Oriental Cokcroach":(var1 == 7?"Fly":(var1 == 8?"Dragonfly":"Spider"))))))));
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

   public void setText() {
      if(this.g.level <= this.g.totalBugsType) {
         if(this.g.level == 1) {
            this.bug = new Bug(this.g, 0);
            this.txt = "Bug : Ant \n Smash all the ants!";
         } else if(this.g.level == 2) {
            this.bug = new Bug(this.g, 1);
            this.txt = "New bug : Carpet Beettle \n Carpet bettle so terrible, \n kill them all";
         } else if(this.g.level == 3) {
            this.bug = new Bug(this.g, 2);
            this.txt = "New bug : Bee \nOh no, bees... they will stung you, \n better never touch em ever!";
         } else if(this.g.level == 4) {
            this.bug = new Bug(this.g, 3);
            this.txt = "New bug : Cockroach \nCockroach.... uah... \n they are disgusthing... smash em!!";
         } else if(this.g.level == 5) {
            this.bug = new Bug(this.g, 4);
            this.txt = "New bug : Butterfly \nButterfly  is such a beautiful creature,\n don\'t ever smash them!";
         } else if(this.g.level == 6) {
            this.bug = new Bug(this.g, 5);
            this.txt = "New bug : Mosquito \nThey always suck our blood, \nsmash em all!!";
         } else if(this.g.level == 7) {
            this.bug = new Bug(this.g, 6);
            this.txt = "New bug : Oriental Cockroach \n I hate this type of cockroach,\n one word : smash";
         } else if(this.g.level == 8) {
            this.bug = new Bug(this.g, 7);
            this.txt = "New bug : Fly \n This bug touches anything, \n smash them!";
         } else if(this.g.level == 9) {
            this.bug = new Bug(this.g, 8);
            this.txt = "New bug : Dragonfly \n smash this bug!!";
         } else if(this.g.level == 10) {
            this.bug = new Bug(this.g, 9);
            this.txt = "New bug : Spider \n Beware of spider, \n smash them carefully!!";
         }

         this.bug.x = (float)(0 - this.bug.size / 2);
         this.txt = this.txt + "\n tap to continue";
         String[] var7 = this.txt.split("\n");
         this.h = 3.0F * this.fontHeight * (float)(1 + var7.length) + 1.5F * (float)this.bug.size;
      } else {
         String var1 = this.getInsectName(this.g.forbiddenToKill);
         if(this.g.forbiddenToKill != 2 && this.g.forbiddenToKill != 4) {
            int var6 = MathUtils.random(0, 4);
            if(var6 == 0) {
               this.txt = "Don\'t smash the next" + var1 + " for now";
            } else if(var6 == 1) {
               this.txt = "Let the next" + var1 + "s pass";
            } else if(var6 == 2) {
               this.txt = "Do me a favor, \n dont smash the next" + var1 + "s";
            } else if(var6 == 3) {
               this.txt = "I hate " + var1 + " but \n i dont want you to smash \n the next " + var1 + " ";
            } else if(var6 == 4) {
               this.txt = "Let the next " + var1 + "s lives";
            }
         } else {
            int var2 = MathUtils.random(0, 2);
            if(var2 == 0) {
               this.txt = "Remember don\'t ever try \n to smash Bee and Butterfly \n but smash all other bugs";
            } else if(var2 == 1) {
               this.txt = "Bee and Butterfly, thats the two \n bugs you should never smash!";
            } else {
               this.txt = "You can smash all bugs \nexcept bee and butterfly";
            }
         }

         this.txt = this.txt + "\n tap to continue";
         String[] var3 = this.txt.split("\n");
         this.h = 3.0F * this.fontHeight * (float)(1 + var3.length);
      }

      this.w = this.g.screenWidth - 10.0F;
      this.x = 0.0F - this.w / 2.0F;
      this.y = this.g.screenBottom - this.h;
      this.targetY = 0.0F - this.h / 2.0F;
      this.sound.play();
   }

   public void setTopHeight(float var1) {}
}
