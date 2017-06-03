package com.gameworks.bugsmasher.manhinh;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.manhinh.MainMenu;

public class Splash implements Screen {

   SpriteBatch batch = new SpriteBatch();
   OrthographicCamera camera;
   BitmapFont font = new BitmapFont();
   BugSmasher g;
   private float ratio = 0.0F;
   Texture tex;
   private float texHeight = 0.0F;
   private float texWidth = 0.0F;


   public Splash(BugSmasher var1) {
      this.g = var1;
      this.g.screenState = 2;
   }

   public void dispose() {
      this.tex.dispose();
      this.batch.dispose();
      this.font.dispose();
   }

   public void hide() {
      this.dispose();
   }

   public void pause() {}

   public void render(float var1) {
      Gdx.gl.glClearColor(.1F, 0.5F, 0.7F, 1.0F);
      Gdx.gl.glClear(16384);
      this.camera.update();
      this.batch.setProjectionMatrix(this.camera.combined);
      this.batch.begin();
      this.batch.draw(this.tex, 0.0F - this.texWidth / 2.0F, 0.0F - this.texHeight / 2.0F, this.texWidth, this.texHeight);
      this.batch.end();
      if(this.g.asset.update()) {
         ((Game)Gdx.app.getApplicationListener()).setScreen(new MainMenu(this.g));
      } else {
         this.batch.begin();
         this.batch.draw(this.tex, 0.0F - this.texWidth / 2.0F, 0.0F - this.texHeight / 2.0F, this.texWidth, this.texHeight);
         this.font.draw(this.batch, "Loading : " + (int)(100.0F * this.g.asset.getProgress()) + " %", -50.0F, 20.0F + this.g.screenBottom + this.g.bottomSection);
         this.batch.end();
      }
   }

   public void resize(int var1, int var2) {}

   public void resume() {}

   public void show() {
      this.font.setColor(1.0F, 1.0F, 1.0F, 1.0F);
      this.tex = new Texture(Gdx.files.internal("tainguyen/img/logo.png"));
      this.tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
      this.ratio = (float)(this.tex.getWidth() / this.tex.getHeight());
      this.texWidth = (float)(Gdx.graphics.getWidth() / 2);
      this.texHeight = this.texWidth / this.ratio;
      this.camera = new OrthographicCamera();
      this.camera.position.set(0.0F, 0.0F, 0.0F);
      this.camera.viewportWidth = this.g.screenWidth;
      this.camera.viewportHeight = this.g.screenHeight;
      this.g.asset.load("tainguyen/img/others/red.png", Texture.class);
      this.g.asset.load("tainguyen/img/others/red-dot.png", Texture.class);
      this.g.asset.load("tainguyen/img/others/life-dot.png", Texture.class);
      this.g.asset.load("tainguyen/img/background/1.jpg", Texture.class);
      this.g.asset.load("tainguyen/img/background/shadow-top.png", Texture.class);
      this.g.asset.load("tainguyen/img/background/grass.png", Texture.class);
      this.g.asset.load("tainguyen/img/bugs/bug-sprite2.png", Texture.class);
      this.g.asset.load("chu/font.png", Texture.class);
      this.g.asset.load("chu/font-white-black.png", Texture.class);
      this.g.asset.load("tainguyen/img/more-games/1.png", Texture.class);
      this.g.asset.load("tainguyen/img/more-games/2.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-get1.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-get2.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-more1.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-more2.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-close1.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-close2.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-ok1.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-ok2.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-cancel1.png", Texture.class);
      this.g.asset.load("tainguyen/img/ui/buttons/button-cancel2.png", Texture.class);
      this.g.asset.load("tainguyen/sounds/click.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die2.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die3.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die4.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die5.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die6.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/die7.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/bee.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/cockroachStart.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/cockroachStart2.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/flyStart.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/insect1.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/insect2.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/insect3.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/insectFly1.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/mosquito.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/life-lost.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/life-new.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/gameover.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/bubble.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/wush.wav", Sound.class);
      this.g.asset.load("tainguyen/sounds/music.mp3", Music.class);
      this.g.asset.load("chu/font.fnt", BitmapFont.class);
      this.g.asset.load("chu/font1.fnt", BitmapFont.class);
   }
}
