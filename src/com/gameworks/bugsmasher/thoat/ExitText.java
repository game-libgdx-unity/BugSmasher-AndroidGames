package com.gameworks.bugsmasher.thoat;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gameworks.bugsmasher.BugSmasher;

public class ExitText extends Actor {

   BitmapFont font;
   BugSmasher g;
   String str = "You want to exit";
   int style;
   float x;
   float y = 0.0F;


   public ExitText(BugSmasher var1, float var2) {
      this.g = var1;
      Texture var3 = (Texture)this.g.asset.get("chu/font-white-black.png", Texture.class);
      var3.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.font = new BitmapFont(Gdx.files.internal("chu/font-white-black.fnt"), new TextureRegion(var3), false);
      this.font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      float var4 = this.font.getBounds(this.str).width / var2;
      this.font.setScale(1.0F / var4);
   }

   public void act(float var1) {
      super.act(var1);
   }

   public void dispose() {}

   public void draw(SpriteBatch var1, float var2) {
      this.font.draw(var1, this.str, this.x, this.y);
   }

   public float getHeight() {
      return this.font.getBounds(this.str).height;
   }

   public float getWidth() {
      return this.font.getBounds(this.str).width;
   }

   public void setPosition(float var1, float var2) {
      this.x = var1;
      this.y = var2;
   }
}
