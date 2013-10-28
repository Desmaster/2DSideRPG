package core.game.entity;

import core.game.graphics.Screen;
import org.newdawn.slick.geom.Vector2f;

public class Mob extends Entity {

	protected Vector2f velocity = new Vector2f();
	private float friction = 0.55f;
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

		if (onAir) {
			velocity.y += gravity;
		} else {
			velocity.y = 0;
		}

		float newX = velocity.x + x;
		float newY = velocity.y + y;

		wasOnAir = onAir;

		onAir = newY < 500;

		x = newX;
		y = newY;
	}

	public void render(Screen screen) {
	}

}
