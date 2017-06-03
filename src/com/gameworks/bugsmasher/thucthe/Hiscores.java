package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;

public class Hiscores implements Drawable {

   boolean animate = false;
   FileHandle file;
   BitmapFont font;
   BugSmasher g;
   String str;
   String str2;
   Texture tempTexture;
   boolean writed = false;
   float x;
   float y;


   public Hiscores(BugSmasher var1) {
      this.g = var1;
      Texture var2 = (Texture)this.g.asset.get("chu/font.png", Texture.class);
      var2.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font = new BitmapFont(Gdx.files.internal("chu/font.fnt"), new TextureRegion(var2), false);
      this.str = "0";
      float var3 = this.font.getBounds(this.str).width;
      float var4 = this.g.screenWidth / 18.0F / var3;
      this.font.setScale(var4);
      this.file = Gdx.files.local("highscore.txt");
      if(!this.file.exists()) {
         this.file.writeString("0", false);
      }

      this.str = this.file.readString();
      this.str2 = "Best: ";
      this.x = 0.0F - this.font.getBounds(this.str2 + this.str).width / 2.0F;
      this.y = -0.5F * this.g.screenHeight + this.g.bottomSection + 2.0F * this.font.getBounds("A").height;
   }

   public void Write() {
      if(!this.writed && Integer.parseInt(this.str) < this.g.totalKilled) {
         this.file.writeString("" + this.g.totalKilled, false);
      }

   }

   public void dispose() {
      this.tempTexture.dispose();
   }

   public void draw(SpriteBatch var1) {
      if(this.file.exists()) {
         this.font.draw(var1, this.str2 + this.str, this.x, this.y);
      }

   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public void drawText(SpriteBatch var1, String var2) {
      float var3 = 0.0F - this.font.getBounds(var2).width / 2.0F;
      this.font.draw(var1, var2, var3, 0.0F);
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
