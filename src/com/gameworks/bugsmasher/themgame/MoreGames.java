package com.gameworks.bugsmasher.themgame;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.thucthe.MyButton;
import com.gameworks.utils.AndroidService;

public class MoreGames implements Drawable {

   boolean backgroundOn = false;
   Sprite backgroundSprite;
   BugSmasher g;
   Group group;
   Group group2;
   Group group3;
   MoreGamesImage moreGamesI;
   public Stage stage;
   float targetY;


   public MoreGames(BugSmasher var1) {
      this.g = var1;
      this.stage = new Stage();
      this.backgroundSprite = new Sprite((Texture)this.g.asset.get("tainguyen/img/others/red.png", Texture.class));
      this.backgroundSprite.setSize(this.g.screenWidth, this.g.screenHeight);
      this.backgroundSprite.setColor(0.0F, 0.0F, 0.0F, 0.5F);
      this.moreGamesI = new MoreGamesImage(this.g);
      MyButton var2 = new MyButton(this.g, 0, this.g.screenWidth / 2.5F);
      MyButton var3 = new MyButton(this.g, 1, this.g.screenWidth / 3.5F);
      MyButton var4 = new MyButton(this.g, 2, this.g.screenWidth / 8.5F);
      this.g = this.g;
      this.group = new Group();
      this.group2 = new Group();
      this.group3 = new Group();
      this.group.setPosition(0.0F, this.g.screenHeight);
      this.group2.setPosition(0.0F, 0.0F);
      new Actions();
      var2.setPosition(this.g.screenWidth / 2.0F - var2.getWidth() / 2.0F, 0.0F + var2.getHeight() / 1.5F);
      var4.setPosition(this.g.screenWidth - 1.2F * var4.getWidth(), this.moreGamesI.getHeight() - 1.3F * var4.getHeight());
      this.group.addActor(this.moreGamesI);
      this.group.addActor(var2);
      this.group.addActor(var4);
      var3.setPosition(this.g.screenWidth - 1.5F * var3.getWidth(), 0.0F);
      this.group2.addActor(var3);
      this.group2.setPosition(0.0F, this.group.getY() - var3.getHeight());
      this.group2.setSize(this.g.screenWidth, var3.getHeight());
      this.group3.setSize(this.g.screenWidth, this.g.screenHeight);
      this.group3.setPosition(0.0F, this.g.screenHeight);
      this.group3.setBounds(this.group3.getX(), this.group3.getY(), this.group3.getWidth(), this.group3.getHeight());
      this.stage.addActor(this.group3);
      this.stage.addActor(this.group);
      this.stage.addActor(this.group2);
      this.targetY = this.g.screenHeight - 1.1F * this.moreGamesI.getHeight();
      var3.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
            if(Gdx.app.getType()==ApplicationType.Android)
            	((AndroidService)Gdx.app).moreGame();
         }
      });
      var4.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
        	 if(Gdx.app.getType()==ApplicationType.Android)
             	((AndroidService)Gdx.app).moreGame();
         }
      });
      var2.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {
        	 if(Gdx.app.getType()==ApplicationType.Android)
             	((AndroidService)Gdx.app).moreGame();
         }
      });
      this.group3.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {}
      });
      this.group2.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {}
      });
      this.group.addListener(new ClickListener() {
         public void clicked(InputEvent var1, float var2, float var3) {}
      });
   }

   public void dispose() {
      this.stage.dispose();
   }

   public void draw(float var1) {
      if(this.backgroundOn) {
         this.stage.getSpriteBatch().begin();
         this.backgroundSprite.draw(this.stage.getSpriteBatch());
         this.stage.getSpriteBatch().end();
      }

      this.stage.act(var1);
      this.stage.draw();
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
