package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;

public class Score implements Drawable {

   BitmapFont font;
   float fontHeight;
   BugSmasher g;
   int oldKilled;
   float paddingX;
   String str = "";
   int targetScore;
   Texture tempTexture;
   float x;
   float y;


   public Score(BugSmasher var1) {
      this.g = var1;
      this.oldKilled = this.g.totalKilled;
      this.tempTexture = (Texture)this.g.asset.get("chu/font.png", Texture.class);
      this.tempTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font = new BitmapFont(Gdx.files.internal("chu/font.fnt"), new TextureRegion(this.tempTexture), false);
      this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font.setScale(1.0F);
      this.fontHeight = this.font.getBounds("A").height;
      float var2 = this.g.topSection / this.fontHeight / 1.7F;
      this.font.setScale(var2);
      this.paddingX = this.font.getBounds("A").width;
      this.fontHeight = this.font.getBounds("A").height;
      this.y = this.g.screenTop - this.fontHeight / 10.0F;
   }

   public void Setup(int var1) {
      this.targetScore = var1;
   }

   public void dispose() {
      this.tempTexture.dispose();
      this.font.dispose();
   }

   public void draw(SpriteBatch var1) {
      if(this.oldKilled < this.targetScore) {
         ++this.oldKilled;
      }

      this.str = "" + this.oldKilled;
      this.x = -0.5F * (float)Gdx.graphics.getWidth() + this.font.getBounds(this.str).width / 6.0F;
      this.font.draw(var1, this.str, this.x, this.y);
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
