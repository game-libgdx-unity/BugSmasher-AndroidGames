package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Array;
import com.gameworks.bugsmasher.BugSmasher;

public class Background implements Drawable {

   private static final int BACKGROUND_1 = 1;
   private static final int BACKGROUND_2 = 2; 
   float animSeconds = 0.0F;
   private float bugRemoveSize = 0.0F;
   int currentBackground;
   float fade = 1.0F;
   private float fadeRemove = 1.0F;
   BugSmasher g;
   float grassPos = 0.0F;
   float grassX;
   float grassX2 = 0.0F;
   Array groundTextures;
   int nextBackground;
   float originalGrassX = 0.0F;
   private float rotation = 0.0F;
   float size;
   float sizeS;
   Sprite spriteBugRemove;
   Sprite spriteGameOver;
   Sprite spriteShadow;
   Sprite spriteTopSection;
   Texture texS;
   float x;
   float x2;
   float x3;
   private float xRemove = 0.0F;
   float xS;
   float y;
   float y2;
   float y3;
   float yS;


   public Background(BugSmasher var1) {
      this.g = var1;
      this.groundTextures = new Array();
      Texture var2 = (Texture)this.g.asset.get("tainguyen/img/background/1.jpg", Texture.class);
      var2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.groundTextures.add(var2);
      this.size = (float)Gdx.graphics.getHeight();
      this.x = -0.5F * (float)Gdx.graphics.getWidth();
      this.y = -0.5F * (float)Gdx.graphics.getHeight();
      this.texS = (Texture)this.g.asset.get("tainguyen/img/background/shadow-top.png", Texture.class);
      this.texS.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.sizeS = (float)Gdx.graphics.getWidth();
      this.xS = -0.5F * (float)Gdx.graphics.getWidth();
      this.yS = 0.5F * (float)Gdx.graphics.getHeight() - this.sizeS;
      this.spriteShadow = new Sprite(this.texS);
      this.spriteShadow.setSize(this.sizeS, this.sizeS);
      this.spriteShadow.setPosition(this.xS, this.yS);
      this.animSeconds = 500.0F / this.g.screenHeight;
      Texture var3 = (Texture)this.g.asset.get("tainguyen/img/background/grass.png", Texture.class);
      var3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      float var4 = (float)(var3.getWidth() / var3.getHeight());
      float var5 = this.g.screenWidth + this.g.screenWidth / 4.0F;
      float var6 = this.g.screenWidth / var4;
      float var7 = this.g.screenLeft - this.g.screenWidth / 8.0F;
      float var8 = this.g.screenTop - this.g.topSection;
      this.spriteTopSection = new Sprite(var3);
      this.spriteTopSection.setSize(var5, var6);
      this.spriteTopSection.setPosition(var7, var8);
      this.grassPos = 20.0F / this.g.screenWidth;
      this.grassX = var7;
      this.originalGrassX = var7;
      this.grassX2 = var7;
      this.spriteGameOver = new Sprite((Texture)this.g.asset.get("tainguyen/img/others/red.png", Texture.class));
      this.spriteGameOver.setSize(this.g.screenWidth, this.g.screenHeight);
      this.spriteGameOver.setPosition(this.g.screenLeft, this.g.screenBottom);
      this.spriteBugRemove = new Sprite((Texture)this.g.asset.get("tainguyen/img/others/red-dot.png", Texture.class));
      this.spriteBugRemove.setSize(this.bugRemoveSize, this.bugRemoveSize);
   }

   public void dispose() {}

   public void draw(SpriteBatch var1) {
      var1.draw((Texture)this.groundTextures.get(0), this.x, this.y, this.size, this.size);
   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public void draw2(SpriteBatch var1) {}

   public void drawBugRemoveEffect(SpriteBatch var1) {
      if(this.bugRemoveSize > 0.0F) {
         this.bugRemoveSize -= this.g.screenHeight / 300.0F;
         this.spriteBugRemove.setX(this.xRemove);
         this.spriteBugRemove.setSize(this.bugRemoveSize, this.bugRemoveSize);
         this.spriteBugRemove.setColor(1.0F, 1.0F, 1.0F, this.fadeRemove);
         if(this.fadeRemove > 0.05F) {
            this.fadeRemove -= 0.01F;
         }

         this.spriteBugRemove.setX(this.xRemove - this.bugRemoveSize / 2.0F);
         this.spriteBugRemove.draw(var1);
      }

   }

   public void drawContentSection(SpriteBatch var1) {
      if(this.g.playState == 4 || this.g.playState == 5) {
         this.spriteGameOver.setColor(1.0F, 1.0F, 1.0F, this.fade);
         if(this.fade > 0.3F) {
            this.fade -= 0.01F;
         }

         this.spriteGameOver.draw(var1);
      }

   }

   public void drawGrass(SpriteBatch var1) {
      if(this.grassX >= this.g.screenLeft) {
         this.grassPos = -20.0F / this.g.screenWidth;
      }

      if(this.grassX <= this.originalGrassX) {
         this.grassPos = 20.0F / this.g.screenWidth;
      }

      this.grassX += this.grassPos;
      this.spriteTopSection.setX(this.grassX);
      this.spriteTopSection.draw(var1);
      this.grassX2 -= this.grassPos;
      this.spriteTopSection.setX(this.grassX2);
      this.spriteTopSection.draw(var1);
   }

   public void drawSections(SpriteBatch var1) {
      this.drawGrass(var1);
      this.drawContentSection(var1);
   }

   public void drawShadow(SpriteBatch var1) {
      if(this.sizeS < 0.0F) {
         this.animSeconds = -500.0F / this.g.screenHeight;
      } else if(this.sizeS >= this.g.screenHeight) {
         this.animSeconds = 500.0F / this.g.screenHeight;
      }

      this.sizeS -= this.animSeconds;
      this.yS = 0.5F * (float)Gdx.graphics.getHeight() - this.sizeS;
      this.spriteShadow.setSize(this.sizeS, this.sizeS);
      this.spriteShadow.setPosition(this.xS, this.yS);
      this.spriteShadow.draw(var1);
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

   public void setBugRemove(float var1, float var2) {
      this.xRemove = var1;
      this.fadeRemove = 1.0F;
      this.spriteBugRemove.setPosition(this.xRemove, this.g.screenBottom - var2 * 3.0F / 2.0F);
      this.bugRemoveSize = var2 * 3.0F;
   }

   public void setLeftWidth(float var1) {}

   public void setMinHeight(float var1) {}

   public void setMinWidth(float var1) {}

   public void setRightWidth(float var1) {}

   public void setTopHeight(float var1) {}
}
