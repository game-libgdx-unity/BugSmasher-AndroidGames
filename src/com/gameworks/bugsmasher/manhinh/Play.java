package com.gameworks.bugsmasher.manhinh;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.dieukhien.InputControler;
import com.gameworks.bugsmasher.manhinh.MainMenu;
import com.gameworks.bugsmasher.thucthe.Background;
import com.gameworks.bugsmasher.thucthe.Bug;
import com.gameworks.bugsmasher.thucthe.BugImage;
import com.gameworks.bugsmasher.thucthe.Life;
import com.gameworks.bugsmasher.thucthe.Message;
import com.gameworks.bugsmasher.thucthe.MessageBox;
import com.gameworks.bugsmasher.thucthe.Score;
import com.gameworks.bugsmasher.thucthe.UIButton;

import java.util.Iterator;

public class Play implements Screen {

   Background background;
   SpriteBatch batch;
   BugImage bugImage;
   Array bugImages;
   Array bugs;
   OrthographicCamera camera;
   BugSmasher g;
   Life life;
   int maxBugs = 1;
   float minSeconds;
   Message msg;
   MessageBox msgBox;
   float nextSeconds = 1.0F;
   Score score;
   float seconds;
   float totalBugSpawn = 0.0F;
   boolean touched = false;
   UIButton uibutton;
   float x = 180.0F;


   public Play(BugSmasher var1) {
      this.g = var1;
   }

   public void dispose() {}

   public void hide() {
      this.dispose();
   }

   public void pause() {
      this.g.playState = 2;
   }

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      this.camera.update();
      this.batch.setProjectionMatrix(this.camera.combined);
      this.batch.begin();
      this.background.draw(this.batch);
      this.background.drawBugRemoveEffect(this.batch);
      Iterator var2 = this.bugs.iterator();

      while(var2.hasNext()) {
         Bug var3 = (Bug)var2.next();
         this.bugImage.draw(this.batch, var3, var1);
         var3.bugMove();
         if(var3.y - (float)var3.size < this.g.screenBottom - (float)var3.size || var3.status == 2) {
            if(var3.y - (float)var3.size < this.g.screenBottom - (float)var3.size && !var3.forbiden) {
               BugSmasher var4 = this.g;
               var4.life += -1;
               this.background.setBugRemove(var3.x, (float)var3.size);
               if(this.g.life <= 0) {
                  this.g.playState = 4;
//                  if(Gdx.app.getType()==ApplicationType.Android)
               }
            }

            var2.remove();
         }
      }

      this.background.drawSections(this.batch);
      this.background.drawShadow(this.batch);
      this.msgBox.draw(this.batch);
      this.msg.draw(this.batch);
      this.life.draw(this.batch);
      this.score.draw(this.batch);
      this.batch.end();
      this.uibutton.draw(this.batch);
      if(this.g.playState == 3) {
         this.msgBox.setText();
         this.totalBugSpawn = 0.0F;
         this.g.playState = 0;
      }

      this.spawnBugs();
   }

   public void resize(int var1, int var2) {
      this.camera.viewportWidth = (float)Gdx.graphics.getWidth();
      this.camera.viewportHeight = (float)Gdx.graphics.getHeight();
      this.camera.update();
   }

   public void resume() {}

   public void setMaxBugs() {
      if(this.g.level <= 1) {
         this.maxBugs = 2;
         this.minSeconds = 4.0F;
      } else {
         if(this.g.level > 1 && this.g.level <= 3) {
            this.maxBugs = 3;
            this.minSeconds = 4.0F;
            return;
         }

         if(this.g.level > 3 && this.g.level <= 6) {
            this.minSeconds = 3.0F;
            this.maxBugs = 3;
            return;
         }

         if(this.g.level > 6 && this.g.level <= 9) {
            this.maxBugs = 4;
            this.minSeconds = 3.0F;
            return;
         }

         if(this.g.level > 9 && this.g.level <= 12) {
            this.maxBugs = 4;
            this.minSeconds = 2.0F;
            return;
         }

         if(this.g.level > 12 && this.g.level <= 15) {
            this.maxBugs = 4;
            this.minSeconds = 1.0F;
            return;
         }

         if(this.g.level > 15 && this.g.level <= 18) {
            this.maxBugs = 5;
            this.minSeconds = 2.0F;
            return;
         }

         if(this.g.level > 18) {
            this.maxBugs = 5;
            this.minSeconds = 1.0F;
            return;
         }
      }

   }

   public void show() {
      this.g.start();
      this.g.screenState = 1;
      this.g.playState = 0;
      if(this.g.backgroundMusic.isPlaying()) {
         this.g.backgroundMusic.stop();
      }

      this.camera = new OrthographicCamera();
      this.camera.position.set(0.0F, 0.0F, 0.0F);
      this.camera.viewportWidth = this.g.screenWidth;
      this.camera.viewportHeight = this.g.screenHeight;
      this.batch = new SpriteBatch();
      this.background = new Background(this.g);
      this.bugs = new Array();
      this.bugImages = new Array();
      this.bugImage = new BugImage(this.g);
      this.life = new Life(this.g, this.camera);
      this.score = new Score(this.g);
      this.msg = new Message(this.g);
      this.msgBox = new MessageBox(this.g);
      this.uibutton = new UIButton(this.g);
      InputMultiplexer var2 = new InputMultiplexer();
      var2.addProcessor(this.uibutton.stage);
      var2.addProcessor(new InputControler() {
         public boolean keyUp(int var1) {
            if(var1 == 4) {
               ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(Play.this.g));
            }

            return false;
         }
         public boolean touchDown(int var1, int var2, int var3, int var4) {
            if(Play.this.g.playState == 0) {
               Play.this.msgBox.checkTouchDown();
            } else {
               if(Play.this.g.playState == 1) {
                  Play.this.touched = true;
                  Iterator var5 = Play.this.bugs.iterator();

                  while(var5.hasNext()) {
                     ((Bug)var5.next()).checkTouchDown(Play.this.camera);
                  }

                  Play.this.score.Setup(Play.this.g.totalKilled);
                  Play.this.life.checkTouchDown();
                  return true;
               }

               if(Play.this.g.playState == 5) {
                  Play.this.g.life = 3;
                  Play.this.g.totalKilled = 0;
                  Play.this.g.level = 1;
                  ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(Play.this.g));
                  return true;
               }
            }

            return true;
         }
         public boolean touchDragged(int var1, int var2, int var3) {
            if(Play.this.g.playState == 1) {
               Play.this.touched = true;
               Iterator var4 = Play.this.bugs.iterator();

               while(var4.hasNext()) {
                  ((Bug)var4.next()).checkTouchDown(Play.this.camera);
               }

               Play.this.score.Setup(Play.this.g.totalKilled);
               Play.this.life.checkTouchDown();
            }

            return false;
         }
         public boolean touchUp(int var1, int var2, int var3, int var4) {
            return false;
         }
      });
      Gdx.input.setInputProcessor(var2);
   }

   public void spawnBugs() {
      this.setMaxBugs();
      if(this.g.playState == 1) {
         this.seconds += Gdx.graphics.getDeltaTime();
         if(this.seconds > this.nextSeconds) {
            int var1 = MathUtils.random(1, this.maxBugs);

            for(int var2 = 0; var2 < var1; ++var2) {
               int var3;
               if(this.g.level < this.g.totalBugsType) {
                  if(this.totalBugSpawn == 0.0F) {
                     var3 = -1 + this.g.level;
                  } else {
                     var3 = MathUtils.random(0, -1 + this.g.level);
                  }
               } else {
                  var3 = MathUtils.random(0, -1 + this.g.totalBugsType);
               }

               Bug var4 = new Bug(this.g, var3);
               if(this.g.level > this.g.totalBugsType && var4.type == this.g.forbiddenToKill) {
                  var4.forbiden = true;
               }

               this.bugs.add(var4);
               this.seconds = 0.0F;
               ++this.totalBugSpawn;
            }

            this.nextSeconds = MathUtils.random(this.minSeconds, 4.0F);
         }
      }

   }

   public interface ActionResolver {

      void openUri(String var1);

      void showAlertBox(String var1, String var2, String var3);

      void showChartBoostInterstitial();

      void showInterBanner();

      void showToast(CharSequence var1, int var2);
   }
}
