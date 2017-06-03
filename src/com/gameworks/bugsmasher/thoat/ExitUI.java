package com.gameworks.bugsmasher.thoat;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.gameworks.bugsmasher.BugSmasher;
import com.gameworks.bugsmasher.themgame.MoreGamesImage;
import com.gameworks.bugsmasher.thucthe.MyButton;
import com.gameworks.utils.AndroidService;

public class ExitUI implements Drawable {

	Sprite backgroundSprite;
	private boolean dispose = false;
	private boolean exit = false;
	BugSmasher g;
	Group group;
	Group group2;
	Group group3;
	MoreGamesImage moreGamesI;
	public Stage stage;
	float targetY;
	float targetY2;

	public ExitUI(BugSmasher var1) {
		this.g = var1;
		this.stage = new Stage();
		this.exit = false;
		this.backgroundSprite = new Sprite((Texture) this.g.asset.get(
				"tainguyen/img/others/red.png", Texture.class));
		this.backgroundSprite.setSize(this.g.screenWidth, this.g.screenHeight);
		this.backgroundSprite.setColor(0.0F, 0.0F, 0.0F, 0.7F);
		ExitText var2 = new ExitText(this.g, this.g.screenWidth / 1.5F);
		float var3 = this.g.screenWidth / 6.0F;
		MyButton var4 = new MyButton(this.g, 3, var3);
		MyButton var5 = new MyButton(this.g, 4, var3);
		this.moreGamesI = new MoreGamesImage(this.g);
		MyButton var6 = new MyButton(this.g, 0, this.g.screenWidth / 2.5F);
		MyButton var7 = new MyButton(this.g, 2, this.g.screenWidth / 8.5F);
		this.g = this.g;
		this.group = new Group();
		this.group2 = new Group();
		this.group3 = new Group();
		float var8 = var3 * 4.0F;
		float var9 = (this.g.screenWidth - var8) / 2.0F + var5.getWidth()
				/ 2.0F;
		var5.setPosition(var9, 0.0F);
		var4.setPosition(var9 + 2.0F * var3, 0.0F);
		float var10 = 0.0F + 2.0F * var4.getHeight();
		var2.setPosition(this.g.screenWidth / 2.0F - var2.getWidth() / 2.0F,
				var10);
		this.group.addActor(var2);
		this.group.addActor(var4);
		this.group.addActor(var5);
		this.group.setPosition(0.0F, this.g.screenHeight);
		this.group2.setPosition(0.0F, 0.0F);
		new Actions();
		var6.setPosition(this.g.screenWidth / 2.0F - var6.getWidth() / 2.0F,
				0.0F + var6.getHeight() / 1.5F);
		var7.setPosition(this.g.screenWidth - 1.2F * var7.getWidth(),
				this.moreGamesI.getHeight() - 1.3F * var7.getHeight());
		this.group2.addActor(this.moreGamesI);
		this.group2.addActor(var6);
		this.group2.addActor(var7);
		this.group2.setPosition(0.0F, this.g.screenHeight);
		this.group3.setSize(this.g.screenWidth, this.g.screenHeight);
		this.group3.setPosition(0.0F, this.g.screenHeight);
		this.group3.setBounds(this.group3.getX(), this.group3.getY(),
				this.group3.getWidth(), this.group3.getHeight());
		this.stage.addActor(this.group3);
		this.stage.addActor(this.group);
		this.stage.addActor(this.group2);
		this.targetY2 = this.g.screenHeight - 1.1F
				* this.moreGamesI.getHeight();
		this.targetY = this.targetY2 - 1.5F * var10;
		var4.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
				((AndroidService) Gdx.app).moreGame();
			}
		});
		var5.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
				if (Gdx.app.getType() == ApplicationType.Android)
					((AndroidService) Gdx.app).moreGame();
			}
		});
		var7.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
				if (Gdx.app.getType() == ApplicationType.Android)
					((AndroidService) Gdx.app).moreGame();
			}
		});
		var6.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
				if (Gdx.app.getType() == ApplicationType.Android)
					((AndroidService) Gdx.app).rate();
			}
		});
		this.group3.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
			}
		});
		this.group2.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
			}
		});
		this.group.addListener(new ClickListener() {
			public void clicked(InputEvent var1, float var2, float var3) {
			}
		});
	}

	public void dispose() {
		this.stage.dispose();
	}

	public void draw(float var1) {
		if (this.exit) {
			this.stage.getSpriteBatch().begin();
			this.backgroundSprite.draw(this.stage.getSpriteBatch());
			this.stage.getSpriteBatch().end();
		}

		this.stage.act(var1);
		this.stage.draw();
	}

	public void draw(SpriteBatch var1, float var2, float var3, float var4,
			float var5) {
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

	public boolean isDispose() {
		return this.dispose;
	}

	public void setBottomHeight(float var1) {
	}

	public void setLeftWidth(float var1) {
	}

	public void setMinHeight(float var1) {
	}

	public void setMinWidth(float var1) {
	}

	public void setRightWidth(float var1) {
	}

	public void setTopHeight(float var1) {
	}

	public void show() {
		if (this.group.getY() >= this.g.screenHeight) {
			this.group3.addAction(Actions.moveTo(0.0F, 0.0F, 0.0F));
			this.group2.addAction(Actions.moveTo(0.0F, this.targetY2, 0.7F,
					Interpolation.bounceOut));
			this.exit = true;
			this.group.addAction(Actions.moveTo(0.0F, this.targetY, 0.0F));
		}

	}
}
