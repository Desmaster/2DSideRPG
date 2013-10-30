package core.game.entity;

import core.game.graphics.Screen;
import org.newdawn.slick.geom.Vector2f;

public class Mob extends Entity {

	protected Vector2f velocity = new Vector2f();
	private float friction = 0.80f;
	private float gravity = 4.5f;

	protected float jumpSpeed = 40f;
	protected int jumpDelay = 150;

	protected boolean onAir = false;
	protected boolean wasOnAir = false;

	protected int jt = 0;

	public Mob(float x, float y) {
		super(x, y);
	}

	public void update(int delta) {
		if (jt > 0 && !onAir) jt -= delta;
	}

	protected void move() {
		velocity.x *= friction;

		if (friction >= Math.abs(velocity.x)) velocity.x = 0;

		if (onAir) {
			velocity.y += gravity;
		} else {
			velocity.y = 0;
		}

		move2(velocity.x, velocity.y);
	}

	private void move2(float xa, float ya) {
		if (xa != 0 && ya != 0) {
			move2(xa, 0);
			move2(0, ya);
			return;
		}

		wasOnAir = onAir;

		onAir = !collision(xa, ya);

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	private boolean collision(float xa, float ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (int) ((x + xa) + c % 2 * 45 - 25) / level.tileSize;
			int yt = (int) ((y + ya) + c / 2 * 20 + 10) / level.tileSize;
			if (level.isSolid(xt, yt)) solid = true;
		}
		return solid;
	}

	protected void jump() {
		velocity.y -= jumpSpeed;
		jt = jumpDelay;
		onAir = true;
	}

	public void render(Screen screen) {
	}

}
