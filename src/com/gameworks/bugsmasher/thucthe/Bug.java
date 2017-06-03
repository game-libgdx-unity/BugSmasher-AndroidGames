package com.gameworks.bugsmasher.thucthe;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.gameworks.bugsmasher.BugSmasher;

public class Bug {

   public static final int BUG_DIE = 1;
   public static final int BUG_LIVE = 0;
   public static final int BUG_REMOVE = 2;
   public static final int MOVE_DOWN = 0;
   public static final int MOVE_HALF_LEFT = 4;
   public static final int MOVE_HALF_RIGHT = 2;
   public static final int MOVE_LEFT = 3;
   private static final int MOVE_MOVESTOP = 2;
   private static final int MOVE_RANDOM = 3;
   public static final int MOVE_RIGHT = 1;
   public static final int MOVE_STOP = 5;
   private static final int MOVE_STRAIGHT = 0;
   private static final int MOVE_ZIGZAG = 1;
   public static final int TYPE_ANT = 0;
   public static final int TYPE_BEE = 2;
   public static final int TYPE_BUTTERFLY = 4;
   public static final int TYPE_COCKROACH = 3;
   public static final int TYPE_C_BEETLE = 1;
   public static final int TYPE_DRAGONFLY = 8;
   public static final int TYPE_FLY = 7;
   public static final int TYPE_MOSQUITO = 5;
   public static final int TYPE_OCOCKROACH = 6;
   public static final int TYPE_SPIDER = 9;
   public int action;
   public float angle;
   public float bugFrame = 0.0F;
   OrthographicCamera camera;
   float degree = (float)MathUtils.random(-160, 20);
   String file = "";
   String fileDie = "";
   public boolean forbiden = false;
   BugSmasher g;
   int life = 1;
   float maxSpeed;
   float minSpeed;
   int movement;
   public float rotation = 0.0F;
   float seconds;
   public int size;
   Sound sound;
   Sound soundDie;
   public float speed;
   public float startX;
   public float startY;
   public int status;
   float targetDegree = -90.0F;
   float targetSeconds = 3.0F;
   public int type;
   private Vector2 velocity = new Vector2();
   public float x;
   public float y;


   public Bug(BugSmasher var1, int var2) {
      this.g = var1;
      this.size = (int)this.g.screenWidth / 8;
      this.type = var2;
      this.fileDie = "tainguyen/sounds/die3.wav";
      this.file = "tainguyen/sounds/insect2.wav";
      switch(this.type) {
      case 1:
         this.size = (int)(1.2F * (float)this.size);
         this.fileDie = "tainguyen/sounds/die6.wav";
         break;
      case 2:
         this.file = "tainguyen/sounds/bee.wav";
         this.size = (int)(2.0F * (float)this.size);
         this.forbiden = true;
         this.fileDie = "tainguyen/sounds/die5.wav";
         break;
      case 3:
         this.size = (int)(1.3F * (float)this.size);
         this.file = "tainguyen/sounds/cockroachStart.wav";
         this.fileDie = "tainguyen/sounds/die5.wav";
         break;
      case 4:
         this.file = "tainguyen/sounds/insectFly1.wav";
         this.fileDie = "tainguyen/sounds/die2.wav";
         this.size = (int)(2.0F * (float)this.size);
         this.forbiden = true;
         break;
      case 5:
         this.size = (int)(1.2F * (float)this.size);
         this.file = "tainguyen/sounds/mosquito.wav";
         break;
      case 6:
         this.size = (int)(1.3F * (float)this.size);
         this.file = "tainguyen/sounds/cockroachStart2.wav";
         this.fileDie = "tainguyen/sounds/die7.wav";
         break;
      case 7:
         this.file = "tainguyen/sounds/flyStart.wav";
         this.fileDie = "tainguyen/sounds/die4.wav";
         this.size = (int)(1.2F * (float)this.size);
         break;
      case 8:
         this.fileDie = "tainguyen/sounds/die4.wav";
         this.size = (int)(1.4F * (float)this.size);
         break;
      case 9:
         this.fileDie = "tainguyen/sounds/die5.wav";
         this.size = (int)(2.2F * (float)this.size);
      }

      this.sound = (Sound)this.g.asset.get(this.file, Sound.class);
      this.soundDie = (Sound)this.g.asset.get(this.fileDie, Sound.class);
      this.x = MathUtils.random(this.g.screenLeft, this.g.screenRight - (float)this.size);
      this.y = this.g.screenTop;
      this.setMinMaxSpeed();
      this.speed = MathUtils.random(this.minSpeed, this.maxSpeed);
      this.status = 0;
      this.sound.play();
   }

   public void bugMove() {
      float var1 = Gdx.graphics.getDeltaTime() * this.speed * (float)Gdx.graphics.getHeight() / 4.0F;
      if(this.g.playState == 1) {
         if(this.status == 0 && this.action != 5) {
            this.seconds += Gdx.graphics.getDeltaTime();
            if(this.seconds > this.targetSeconds) {
               if(this.degree == this.targetDegree) {
                  this.targetDegree = (float)MathUtils.random(-160, -20);
               }

               this.seconds = 0.0F;
               this.targetSeconds = (float)MathUtils.random(0, 4);
            }

            if(this.degree < this.targetDegree) {
               ++this.degree;
            }

            if(this.degree > this.targetDegree) {
               --this.degree;
            }

            this.angle = 0.017453292F * this.degree;
            this.velocity.set(var1 * (float)Math.cos((double)this.angle), var1 * (float)Math.sin((double)this.angle));
            this.x += 1.0F * this.velocity.x / 60.0F;
            this.y += 1.0F * this.velocity.y / 60.0F;
            if(this.x <= this.g.screenLeft) {
               this.degree = (float)MathUtils.random(-90, -20);
               this.targetDegree = (float)MathUtils.random(-90, -20);
            }

            if(this.x + (float)this.size >= this.g.screenRight) {
               this.degree = (float)MathUtils.random(-160, -90);
               this.targetDegree = (float)MathUtils.random(-160, -90);
            }
         }

         if(this.status == 1) {
            this.seconds += Gdx.graphics.getDeltaTime();
         }

         if(this.seconds > 10.0F) {
            this.status = 2;
         }
      }

   }

   public void bugMoveNatural() {
      float var1 = Gdx.graphics.getDeltaTime() * this.speed * (float)Gdx.graphics.getHeight() / 4.0F;
      if(this.action != 5) {
         this.seconds += Gdx.graphics.getDeltaTime();
         if(this.seconds > this.targetSeconds) {
            if(this.degree == this.targetDegree) {
               this.targetDegree = (float)MathUtils.random(-160, -20);
            }

            this.seconds = 0.0F;
            this.targetSeconds = (float)MathUtils.random(0, 4);
         }

         if(this.degree < this.targetDegree) {
            ++this.degree;
         }

         if(this.degree > this.targetDegree) {
            --this.degree;
         }

         this.angle = 0.017453292F * this.degree;
         this.velocity.set(var1 * (float)Math.cos((double)this.angle), var1 * (float)Math.sin((double)this.angle));
         this.x += 1.0F * this.velocity.x / 60.0F;
         this.y += 1.0F * this.velocity.y / 60.0F;
         if(this.x <= this.g.screenLeft) {
            this.degree = (float)MathUtils.random(-90, -20);
            this.targetDegree = (float)MathUtils.random(-90, -20);
         }

         if(this.x + (float)this.size >= this.g.screenRight) {
            this.degree = (float)MathUtils.random(-160, -90);
            this.targetDegree = (float)MathUtils.random(-160, -90);
         }

         if(this.x <= this.g.screenLeft && this.targetDegree < -80.0F && this.targetDegree > 80.0F) {
            this.degree = (float)MathUtils.random(-80, 20);
            this.targetDegree = (float)MathUtils.random(-80, 20);
         }

         if(this.x + (float)this.size >= this.g.screenRight && this.targetDegree < -160.0F && this.targetDegree > -80.0F) {
            this.degree = (float)MathUtils.random(-160, -90);
            this.targetDegree = (float)MathUtils.random(-160, -90);
         }

         if(this.y + (float)this.size >= this.g.screenTop) {
            this.degree = (float)MathUtils.random(-160, -20);
            this.targetDegree = (float)MathUtils.random(-160, -20);
         }

         if(this.y <= this.g.screenBottom) {
            this.degree = (float)MathUtils.random(20, 170);
            this.targetDegree = (float)MathUtils.random(20, 170);
         }

         if(this.status == 1) {
            this.seconds += Gdx.graphics.getDeltaTime();
         }

         if(this.seconds > 10.0F) {
            this.status = 2;
         }
      }

   }

   public void checkTouchDown(OrthographicCamera var1) {
      if(Gdx.input.isTouched()) {
         Vector3 var2 = new Vector3();
         var2.set((float)Gdx.input.getX(), (float)Gdx.input.getY(), 0.0F);
         var1.unproject(var2);
         if(this.isTouch(var2, this) && this.status != 1) {
            this.status = 1;
            this.soundDie.play();
            if(this.forbiden) {
               this.g.playState = 4;
               return;
            }

            BugSmasher var6 = this.g;
            ++var6.totalKilled;
            if(this.g.totalKilled % this.g.perkill == 0) {
               this.g.playState = 3;
               BugSmasher var7 = this.g;
               ++var7.level;
               BugSmasher var8 = this.g;
               var8.perkill += 5 * this.g.level;
               if(this.g.level > this.g.totalBugsType) {
                  this.g.forbiddenToKill = MathUtils.random(0, -1 + this.g.totalBugsType);
               }
            }
         }
      }

   }

   public boolean isTouch(Vector3 var1, Bug var2) {
      return var1.x >= var2.x && var1.x <= var2.x + (float)var2.size && var1.y >= var2.y && var1.y <= var2.y + (float)var2.size;
   }

   public void setMinMaxSpeed() {
      if(this.g.level <= 1) {
         this.minSpeed = 5.0F;
         this.maxSpeed = 20.0F;
      } else {
         if(this.g.level > 1 && this.g.level <= 3) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 40.0F;
            return;
         }

         if(this.g.level > 3 && this.g.level <= 6) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 60.0F;
            return;
         }

         if(this.g.level > 6 && this.g.level <= 9) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 80.0F;
            return;
         }

         if(this.g.level > 9 && this.g.level <= 12) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 100.0F;
            return;
         }

         if(this.g.level > 12 && this.g.level <= 15) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 120.0F;
            return;
         }

         if(this.g.level > 15) {
            this.minSpeed = 10.0F;
            this.maxSpeed = 160.0F;
            return;
         }
      }

   }
}
