package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.thucthe.Bug;

public class BugImage implements Drawable {

   private static final int FRAME_COLS = 5;
   private static final int FRAME_ROWS = 10;
   private static int ROTATE_DOWN = 0;
   private static int ROTATE_HALF_LEFT = 315;
   private static int ROTATE_HALF_RIGHT = 45;
   private static int ROTATE_LEFT = 270;
   private static int ROTATE_RIGHT = 90;
   Animation ant;
   Animation antDie;
   Animation bee;
   Animation beeDie;
   Animation butterfly;
   Animation butterflyDie;
   Animation cBeetle;
   Animation cBeetleDie;
   Animation cockroach;
   Animation cockroachDie;
   TextureRegion currentFrame;
   Animation dragonfly;
   Animation dragonflyDie;
   Animation fly;
   Animation flyDie;
   BugSmasher g;
   Animation mosquito;
   Animation mosquitoDie;
   Animation oCockroach;
   Animation oCockroachDie;
   Animation spider;
   Animation spiderDie;
   Sprite spriteAnt;
   Sprite spriteBee;
   Sprite spriteButterfly;
   Sprite spriteCBeetle;
   Sprite spriteCockroach;
   Sprite spriteDragonfly;
   Sprite spriteFly;
   Sprite spriteMosquito;
   Sprite spriteOCockroach;
   Sprite spriteSpider;
   private float stateTime = 0.0F;
   Texture[] tex;
   Texture texDie;
   TextureRegion[][] tmp;
   TextureRegion[] walkFrames;
   Texture walkSheet;


   public BugImage(BugSmasher var1) {
      this.g = var1;
      this.walkSheet = (Texture)this.g.asset.get("tainguyen/img/bugs/bug-sprite2.png", Texture.class);
      this.walkSheet.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.tmp = TextureRegion.split(this.walkSheet, this.walkSheet.getWidth() / 5, this.walkSheet.getHeight() / 10);
      int var2 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var3 = 0; var3 < 4; ++var3) {
         this.walkFrames[var2] = this.tmp[0][var3];
         ++var2;
      }

      this.ant = new Animation(0.065F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[0][4];
      this.antDie = new Animation(0.065F, this.walkFrames);
      int var4 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var5 = 0; var5 < 4; ++var5) {
         this.walkFrames[var4] = this.tmp[1][var5];
         ++var4;
      }

      this.cockroach = new Animation(0.075F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[1][4];
      this.cockroachDie = new Animation(0.065F, this.walkFrames);
      int var6 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var7 = 0; var7 < 4; ++var7) {
         this.walkFrames[var6] = this.tmp[2][var7];
         ++var6;
      }

      this.bee = new Animation(0.01F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[2][4];
      this.beeDie = new Animation(0.065F, this.walkFrames);
      int var8 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var9 = 0; var9 < 4; ++var9) {
         this.walkFrames[var8] = this.tmp[3][var9];
         ++var8;
      }

      this.cBeetle = new Animation(0.07F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[3][4];
      this.cBeetleDie = new Animation(0.065F, this.walkFrames);
      int var10 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var11 = 0; var11 < 4; ++var11) {
         this.walkFrames[var10] = this.tmp[4][var11];
         ++var10;
      }

      this.fly = new Animation(0.01F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[4][4];
      this.flyDie = new Animation(0.065F, this.walkFrames);
      int var12 = 0;
      this.walkFrames = new TextureRegion[8];

      for(int var13 = 0; var13 < 4; ++var13) {
         this.walkFrames[var12] = this.tmp[5][var13];
         ++var12;
      }

      for(int var14 = 3; var14 >= 0; --var14) {
         this.walkFrames[var12] = this.tmp[5][var14];
         ++var12;
      }

      this.butterfly = new Animation(0.03F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[5][4];
      this.butterflyDie = new Animation(0.065F, this.walkFrames);
      int var15 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var16 = 0; var16 < 4; ++var16) {
         this.walkFrames[var15] = this.tmp[6][var16];
         ++var15;
      }

      this.mosquito = new Animation(0.01F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[6][4];
      this.mosquitoDie = new Animation(0.065F, this.walkFrames);
      int var17 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var18 = 0; var18 < 4; ++var18) {
         this.walkFrames[var17] = this.tmp[7][var18];
         ++var17;
      }

      this.oCockroach = new Animation(0.06F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[7][4];
      this.oCockroachDie = new Animation(0.085F, this.walkFrames);
      int var19 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var20 = 0; var20 < 4; ++var20) {
         this.walkFrames[var19] = this.tmp[8][var20];
         ++var19;
      }

      this.dragonfly = new Animation(0.04F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[8][4];
      this.dragonflyDie = new Animation(0.085F, this.walkFrames);
      int var21 = 0;
      this.walkFrames = new TextureRegion[4];

      for(int var22 = 0; var22 < 4; ++var22) {
         this.walkFrames[var21] = this.tmp[9][var22];
         ++var21;
      }

      this.spider = new Animation(0.06F, this.walkFrames);
      this.walkFrames = new TextureRegion[1];
      this.walkFrames[0] = this.tmp[9][4];
      this.spiderDie = new Animation(0.115F, this.walkFrames);
      this.spriteBee = new Sprite();
      this.spriteCockroach = new Sprite();
      this.spriteOCockroach = new Sprite();
      this.spriteAnt = new Sprite();
      this.spriteCBeetle = new Sprite();
      this.spriteFly = new Sprite();
      this.spriteButterfly = new Sprite();
      this.spriteMosquito = new Sprite();
      this.spriteDragonfly = new Sprite();
      this.spriteSpider = new Sprite();
   }

   public void dispose() {}

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public void draw(SpriteBatch var1, Bug var2, float var3) {
      float var10000 = var2.x;
      var10000 = var2.y;
      this.drawBug(var1, var2);
   }

   public void drawBug(SpriteBatch var1, Bug var2) {
      float var3 = var2.x;
      float var4 = var2.y;
      if(var2.action != 5 && this.g.playState == 1) {
         var2.bugFrame += Gdx.graphics.getDeltaTime();
      }

      if(var2.type == 0) {
         this.spriteAnt.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
         this.spriteAnt.setRotation(90.0F + 57.295776F * var2.angle);
         if(var2.status != 1) {
            this.spriteAnt.setRegion(this.ant.getKeyFrame(var2.bugFrame, true));
         } else {
            this.spriteAnt.setRegion(this.antDie.getKeyFrame(var2.bugFrame, true));
         }

         this.spriteAnt.setSize((float)var2.size, (float)var2.size);
         this.spriteAnt.setPosition(var3, var4);
         this.spriteAnt.draw(var1);
      } else {
         if(var2.type == 3) {
            this.spriteCockroach.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteCockroach.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteCockroach.setRegion(this.cockroach.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteCockroach.setRegion(this.cockroachDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteCockroach.setSize((float)var2.size, (float)var2.size);
            this.spriteCockroach.setPosition(var3, var4);
            this.spriteCockroach.draw(var1);
            return;
         }

         if(var2.type == 6) {
            this.spriteOCockroach.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteOCockroach.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteOCockroach.setRegion(this.oCockroach.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteOCockroach.setRegion(this.oCockroachDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteOCockroach.setSize((float)var2.size, (float)var2.size);
            this.spriteOCockroach.setPosition(var3, var4);
            this.spriteOCockroach.draw(var1);
            return;
         }

         if(var2.type == 1) {
            this.spriteCBeetle.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteCBeetle.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteCBeetle.setRegion(this.cBeetle.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteCBeetle.setRegion(this.cBeetleDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteCBeetle.setSize((float)var2.size, (float)var2.size);
            this.spriteCBeetle.setPosition(var3, var4);
            this.spriteCBeetle.draw(var1);
            return;
         }

         if(var2.type == 7) {
            this.spriteFly.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteFly.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteFly.setRegion(this.fly.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteFly.setRegion(this.flyDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteFly.setSize((float)var2.size, (float)var2.size);
            this.spriteFly.setPosition(var3, var4);
            this.spriteFly.draw(var1);
            return;
         }

         if(var2.type == 4) {
            this.spriteButterfly.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteButterfly.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteButterfly.setRegion(this.butterfly.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteButterfly.setRegion(this.butterflyDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteButterfly.setSize((float)var2.size, (float)var2.size);
            this.spriteButterfly.setPosition(var3, var4);
            this.spriteButterfly.draw(var1);
            return;
         }

         if(var2.type == 2) {
            this.spriteBee.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteBee.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteBee.setRegion(this.bee.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteBee.setRegion(this.beeDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteBee.setSize((float)var2.size, (float)var2.size);
            this.spriteBee.setPosition(var3, var4);
            this.spriteBee.draw(var1);
            return;
         }

         if(var2.type == 5) {
            this.spriteMosquito.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteMosquito.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteMosquito.setRegion(this.mosquito.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteMosquito.setRegion(this.mosquitoDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteMosquito.setSize((float)var2.size, (float)var2.size);
            this.spriteMosquito.setPosition(var3, var4);
            this.spriteMosquito.draw(var1);
            return;
         }

         if(var2.type == 8) {
            this.spriteDragonfly.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteDragonfly.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteDragonfly.setRegion(this.dragonfly.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteDragonfly.setRegion(this.dragonflyDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteDragonfly.setSize((float)var2.size, (float)var2.size);
            this.spriteDragonfly.setPosition(var3, var4);
            this.spriteDragonfly.draw(var1);
            return;
         }

         if(var2.type == 9) {
            this.spriteSpider.setOrigin((float)(var2.size / 2), (float)(var2.size / 2));
            this.spriteSpider.setRotation(90.0F + 57.295776F * var2.angle);
            if(var2.status != 1) {
               this.spriteSpider.setRegion(this.spider.getKeyFrame(var2.bugFrame, true));
            } else {
               this.spriteSpider.setRegion(this.spiderDie.getKeyFrame(var2.bugFrame, true));
            }

            this.spriteSpider.setSize((float)var2.size, (float)var2.size);
            this.spriteSpider.setPosition(var3, var4);
            this.spriteSpider.draw(var1);
            return;
         }
      }

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

   public void setLeftWidth(float var1) {}

   public void setMinHeight(float var1) {}

   public void setMinWidth(float var1) {}

   public void setRightWidth(float var1) {}

   public void setTopHeight(float var1) {}
}
