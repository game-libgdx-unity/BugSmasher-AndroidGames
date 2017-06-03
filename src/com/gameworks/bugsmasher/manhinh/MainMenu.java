package com.gameworks.bugsmasher.manhinh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.dieukhien.InputControler;
import com.gameworks.bugsmasher.themgame.MoreGames;
import com.gameworks.bugsmasher.thoat.ExitUI;
import com.gameworks.bugsmasher.thucthe.Background;
import com.gameworks.bugsmasher.thucthe.Bug;
import com.gameworks.bugsmasher.thucthe.BugImage;
import com.gameworks.bugsmasher.thucthe.Hiscores;
import com.gameworks.bugsmasher.thucthe.Message;
import com.gameworks.bugsmasher.thucthe.UIButton;
import com.gameworks.utils.AndroidService;

public class MainMenu implements Screen {

   Background background;
   SpriteBatch batch;
   Bug bug;
   BugImage bugImage;
   OrthographicCamera camera;
   BugSmasher g;
   Hiscores hiscores;
   MoreGames moreGames;
   Message msg;
   UIButton uibutton;


   public MainMenu(BugSmasher var1) {
      this.g = var1;
   }

   public void dispose() {
      if(this.g.exitUI.isDispose()) {
         this.g.asset.dispose();
      }

   }

   public void hide() {
      this.dispose();
   }

   public void pause() {}

   public void render(float var1) {
      Gdx.gl.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      Gdx.gl.glClear(16384);
      this.camera.update();
      this.batch.setProjectionMatrix(this.camera.combined);
      this.batch.begin();
      this.background.draw(this.batch);
      this.bugImage.draw(this.batch, this.bug, var1);
      this.bug.bugMoveNatural();
      this.background.drawGrass(this.batch);
      this.background.drawShadow(this.batch);
      this.g.totalKilled = MathUtils.random(0, 200);
      this.hiscores.draw(this.batch);
      this.msg.drawTitle(this.batch);
      this.batch.end();
      this.uibutton.draw(this.batch);
      this.moreGames.draw(var1);
      this.g.exitUI.draw(var1);
      if(this.g.exitUI.isDispose()) {
         ((AndroidService)Gdx.app).onGameExit();
      }

   }

   public void resize(int var1, int var2) {
      this.camera.viewportWidth = (float)Gdx.graphics.getWidth();
      this.camera.viewportHeight = (float)Gdx.graphics.getHeight();
      this.camera.update();
   }

   public void resume() {}

   public void show() {
      this.g.screenState = 0;
      this.camera = new OrthographicCamera();
      this.camera.position.set(0.0F, 0.0F, 0.0F);
      this.camera.viewportWidth = this.g.screenWidth;
      this.camera.viewportHeight = this.g.screenHeight;
      this.batch = new SpriteBatch();
      this.background = new Background(this.g);
      this.msg = new Message(this.g);
      this.uibutton = new UIButton(this.g);
      this.bug = new Bug(this.g, 6);
      this.bug.speed = 60.0F;
      this.g.playState = 1;
      this.bugImage = new BugImage(this.g);
      this.hiscores = new Hiscores(this.g);
      this.moreGames = new MoreGames(this.g);
      this.g.exitUI = new ExitUI(this.g);
      this.g.backgroundMusic = (Music)this.g.asset.get("tainguyen/sounds/music.mp3", Music.class);
      this.g.backgroundMusic.setLooping(true);
      this.g.backgroundMusic.play();
      InputMultiplexer var2 = new InputMultiplexer();
      var2.addProcessor(this.g.exitUI.stage);
      var2.addProcessor(this.moreGames.stage);
      var2.addProcessor(this.uibutton.stage);
      var2.addProcessor(new InputControler() {
         public boolean touchDown(int var1, int var2, int var3, int var4) {
            return true;
         }
         public boolean touchDragged(int var1, int var2, int var3) {
            return false;
         }
         public boolean touchUp(int var1, int var2, int var3, int var4) {
            return false;
         }
      });
      Gdx.input.setInputProcessor(var2);
   }
}
