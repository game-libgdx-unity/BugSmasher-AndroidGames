package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;

public class Life implements Drawable {

   OrthographicCamera camera;
   float dropAnimation = 100.0F;
   float fade;
   float fontHeight;
   BugSmasher g;
   ParticleEffect lifeEffect;
   int oldLife;
   float paddingX;
   float secondsSpawn = 0.0F;
   float secondsSpawnTarget = (float)MathUtils.random(8, 30);
   float size;
   float sizeSpawn;
   Sound sound;
   Sound soundNewLife;
   boolean spawn = false;
   Vector2 spawnPos;
   Sprite spriteLife;
   String str = "";
   Texture tempTexture;
   float x;
   float xTarget;
   float y;


   public Life(BugSmasher var1, OrthographicCamera var2) {
      this.g = var1;
      this.camera = var2;
      this.size = this.g.screenWidth / 16.0F;
      this.sizeSpawn = 1.5F * this.size;
      this.tempTexture = (Texture)this.g.asset.get("tainguyen/img/others/life-dot.png", Texture.class);
      this.tempTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.spriteLife = new Sprite(this.tempTexture);
      this.spriteLife.setSize(this.size, this.size);
      this.y = this.g.screenTop - this.size - this.size / 8.0F;
      this.x = this.g.screenRight - this.size / 10.0F;
      this.spriteLife.setPosition(this.x, this.y);
      this.oldLife = this.g.life;
      this.sound = (Sound)this.g.asset.get("tainguyen/sounds/life-lost.wav", Sound.class);
      this.soundNewLife = (Sound)this.g.asset.get("tainguyen/sounds/life-new.wav", Sound.class);
      this.spawnPos = new Vector2(0.0F, this.g.screenTop + this.sizeSpawn);
      this.lifeEffect = new ParticleEffect();
      this.lifeEffect.load(Gdx.files.internal("hieuung/ring_big.p"), Gdx.files.internal("hieuung"));
      this.lifeEffect.setPosition(-1000.0F, -1000.0F);
   }

   public void checkTouchDown() {
      if(Gdx.input.isTouched()) {
         Vector3 var1 = new Vector3();
         var1.set((float)Gdx.input.getX(), (float)Gdx.input.getY(), 0.0F);
         this.camera.unproject(var1);
         if(this.isTouch(var1, this.spawnPos, this.sizeSpawn)) {
            this.lifeEffect.setPosition(var1.x, var1.y);
            this.lifeEffect.reset();
            BugSmasher var3 = this.g;
            ++var3.life;
            this.oldLife = this.g.life;
            this.sizeSpawn = 0.0F;
            this.spawn = false;
            this.soundNewLife.play();
         }
      }

   }

   public void dispose() {
      this.tempTexture.dispose();
   }

   public void draw(SpriteBatch var1) {
      this.spriteLife.setSize(this.size, this.size);

      for(int var2 = 1; var2 <= this.g.life; ++var2) {
         this.spriteLife.setPosition(this.x - (float)var2 * this.size - this.size / 8.0F, this.y);
         this.spriteLife.draw(var1);
      }

      if(this.oldLife > this.g.life) {
         this.dropAnimation = 0.0F;
         this.oldLife = this.g.life;
         this.fade = 1.0F;
         this.sound.play();
      }

      if(this.dropAnimation < 100.0F) {
         this.drawRemove(var1);
      }

      this.spawnLife(var1);
      this.lifeEffect.update(Gdx.graphics.getDeltaTime());
      this.lifeEffect.draw(var1);
   }

   public void draw(SpriteBatch var1, float var2, float var3, float var4, float var5) {}

   public void drawRemove(SpriteBatch var1) {
      this.spriteLife.setColor(0.0F, 1.0F, 1.0F, this.fade);
      if(this.fade > 0.02F) {
         this.fade -= 0.02F;
      }

      this.spriteLife.setPosition(this.x - (float)(1 + this.oldLife) * this.size - this.size / 8.0F, this.y - this.dropAnimation);
      this.dropAnimation += 0.005F * this.g.screenHeight;
      this.spriteLife.draw(var1);
      this.spriteLife.setColor(1.0F, 1.0F, 1.0F, 1.0F);
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

   public boolean isTouch(Vector3 var1, Vector2 var2, float var3) {
      return var1.x >= var2.x && var1.x <= var2.x + this.sizeSpawn && var1.y >= var2.y && var1.y <= var2.y + this.sizeSpawn;
   }

   public void setBottomHeight(float var1) {}

   public void setLeftWidth(float var1) {}

   public void setMinHeight(float var1) {}

   public void setMinWidth(float var1) {}

   public void setRightWidth(float var1) {}

   public void setTopHeight(float var1) {}

   public void spawnLife(SpriteBatch var1) {
      if(this.g.playState == 1 && this.g.life < 3) {
         if(!this.spawn) {
            this.secondsSpawn += Gdx.graphics.getDeltaTime();
         } else {
            this.sizeSpawn = 1.5F * this.size;
            this.spriteLife.setSize(this.sizeSpawn, this.sizeSpawn);
            this.spriteLife.setPosition(this.spawnPos.x, this.spawnPos.y);
            Vector2 var2 = this.spawnPos;
            var2.y -= this.g.screenHeight / 300.0F;
            this.spriteLife.draw(var1);
            if(this.spawnPos.y + this.sizeSpawn <= this.g.screenBottom + this.g.bottomSection) {
               this.spawn = false;
               this.secondsSpawnTarget = (float)MathUtils.random(8, 30);
            }

            if(this.xTarget > this.spawnPos.x) {
               Vector2 var5 = this.spawnPos;
               var5.x += 1000.0F / this.g.screenWidth;
            }

            if(this.xTarget < this.spawnPos.x) {
               Vector2 var3 = this.spawnPos;
               var3.x -= 1000.0F / this.g.screenWidth;
            }
         }

         if(this.secondsSpawn >= this.secondsSpawnTarget) {
            this.xTarget = MathUtils.random(this.g.screenLeft, this.g.screenRight - this.size);
            this.spawnPos.set(MathUtils.random(this.g.screenLeft, this.g.screenRight - this.size), this.g.screenTop);
            this.secondsSpawn = 0.0F;
            this.xTarget = MathUtils.random(this.g.screenLeft, this.g.screenRight - this.size);
            this.secondsSpawnTarget = (float)MathUtils.random(8, 30);
            this.spawn = true;
         }
      }

   }
}
