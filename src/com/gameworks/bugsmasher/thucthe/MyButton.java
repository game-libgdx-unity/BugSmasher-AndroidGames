package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.gameworks.bugsmasher.BugSmasher;

public class MyButton extends Actor {

   Sprite buttonDown;
   Sprite buttonUp;
   BugSmasher g;
   Sound sound;
   boolean touch = false;
   boolean visible = true;
   float x;
   float y = 0.0F;


   public MyButton(BugSmasher var1, int var2, float var3) {
      this.g = var1;
      String var4;
      String var5;
      switch(var2) {
      case 1:
         var4 = "button-more1.png";
         var5 = "button-more2.png";
         break;
      case 2:
         var4 = "button-close1.png";
         var5 = "button-close2.png";
         break;
      case 3:
         var4 = "button-ok1.png";
         var5 = "button-ok2.png";
         break;
      case 4:
         var4 = "button-cancel1.png";
         var5 = "button-cancel2.png";
         break;
      default:
         var4 = "button-get1.png";
         var5 = "button-get2.png";
      }

      this.buttonUp = new Sprite((Texture)this.g.asset.get("tainguyen/img/ui/buttons/" + var4, Texture.class));
      this.buttonUp.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.buttonUp.setPosition(this.x, this.y);
      float var6 = this.buttonUp.getWidth() / this.buttonUp.getHeight();
      this.buttonUp.setSize(var3, var3 / var6);
      this.buttonDown = new Sprite((Texture)this.g.asset.get("tainguyen/img/ui/buttons/" + var5, Texture.class));
      this.buttonDown.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.buttonDown.setPosition(this.x, this.y);
      this.buttonDown.setSize(var3, var3 / var6);
      this.setWidth(this.buttonUp.getWidth());
      this.setHeight(this.buttonUp.getHeight());
      this.setBounds(this.x, this.y, this.getWidth(), this.getHeight());
      this.sound = (Sound)this.g.asset.get("tainguyen/sounds/bubble.wav", Sound.class);
      this.addListener(new InputListener() {
         public boolean touchDown(InputEvent var1, float var2, float var3, int var4, int var5) {
            MyButton.this.touch = true;
            MyButton.this.sound.play();
            return true;
         }
         public void touchUp(InputEvent var1, float var2, float var3, int var4, int var5) {
            MyButton.this.touch = false;
         }
      });
   }

   public void act(float var1) {
      super.act(var1);
   }

   public void draw(SpriteBatch var1, float var2) {
      if(this.visible) {
         if(!this.touch) {
            this.buttonUp.draw(var1);
            return;
         }

         this.buttonDown.draw(var1);
      }

   }

   public void setPosition(float var1, float var2) {
      this.x = var1;
      this.y = var2;
      this.buttonUp.setPosition(var1, var2);
      this.buttonDown.setPosition(var1, var2);
      super.setPosition(var1, var2);
   }

   public void setVisible(boolean var1) {
      this.visible = var1;
   }
}
