package core.game.entity.player;

import core.game.entity.Mob;
import core.game.graphics.Screen;

import org.lwjgl.input.Keyboard;

public class Player extends Mob{

	public Player(float x, float y) {
		super(x, y);
		setWidth(64);
		setHeight(64);
	}

	public void update(int delta) {
		super.update(delta);

		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			velocity.x -= delta / 3;
		} else if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			velocity.x += delta / 3;
		}

		if (! onAir && jt <= 0 && Keyboard.isKeyDown(Keyboard.KEY_W)) {
			velocity.y -= jumpSpeed;
			jt = jumpDelay;
			onAir = true;
		}

		move();
	}

	public void render(Screen screen) {
		screen.render(this);
	}

}
