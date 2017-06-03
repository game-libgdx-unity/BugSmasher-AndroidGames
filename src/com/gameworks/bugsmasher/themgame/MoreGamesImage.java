package com.gameworks.bugsmasher.themgame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.gameworks.bugsmasher.BugSmasher;

public class MoreGamesImage extends Actor {

   Sprite backgroundSprite;
   BugSmasher g;
   int randomMoreGames;
   int style;


   public MoreGamesImage(BugSmasher var1) {
      this.g = var1;
      this.randomMoreGames = MathUtils.random(1, 2);
      this.backgroundSprite = new Sprite((Texture)this.g.asset.get("tainguyen/img/more-games/" + this.randomMoreGames + ".png", Texture.class));
      this.backgroundSprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      float var2 = this.g.screenWidth;
      float var3 = this.backgroundSprite.getWidth() / this.backgroundSprite.getHeight();
      this.backgroundSprite.setPosition(0.0F, 0.0F);
      this.backgroundSprite.setSize(var2, var2 / var3);
   }

   public void act(float var1) {
      super.act(var1);
   }

   public void dispose() {}

   public void draw(SpriteBatch var1, float var2) {
      this.backgroundSprite.draw(var1);
   }

   public float getHeight() {
      return this.backgroundSprite.getHeight();
   }

   public String getUrl() {
      return this.randomMoreGames == 1?"https://play.google.com/store/apps/details?id=com.zahraworks.birdwars":"https://play.google.com/store/apps/details?id=com.zahraworks.fours";
   }
}
