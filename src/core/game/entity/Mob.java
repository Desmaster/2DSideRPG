package core.game.entity;

import core.game.graphics.Screen;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.util.Log;

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
		if (jt > 0 && ! onAir) jt -= delta;
	}

	protected void move() {
		velocity.x *= friction;

		if (friction >= Math.abs(velocity.x)) velocity.x = 0;

		if (onAir) {
			velocity.y += gravity;
		} else {
			velocity.y = 0;
		}

		float newX = velocity.x + x;
		float newY = velocity.y + y;

		wasOnAir = onAir;

		onAir = ! coll(newX, newY);

		if (coll(newX, newY)) Log.info("Collision");

		if (!coll(newX, newY)) {
			x = newX;
			y = newY;
		}
	}

	private boolean coll(float x, float y) {
		boolean solid = false;
		int x1 = (int) (x / level.tileSize);
		int y1 = (int) (y / level.tileSize);
		int x2 = (int) (x + (width * 0.25)) / level.tileSize;
		int y2 = (int) (y + (height * 0.25)) / level.tileSize;
		int x3 = (int) (x + (width * 0.75)) / level.tileSize;
		int y3 = (int) (y + (height * 0.75)) / level.tileSize;
		int x4 = (int) (x + width) / level.tileSize;
		int y4 = (int) (y + height) / level.tileSize;
		if (level.isSolid(x1, y1)) solid = true;
		if (level.isSolid(x2, y1)) solid = true;
		if (level.isSolid(x3, y1)) solid = true;
		if (level.isSolid(x4, y1)) solid = true;

		if (level.isSolid(x4, y2)) solid = true;
		if (level.isSolid(x4, y3)) solid = true;
		if (level.isSolid(x4, y4)) solid = true;

		if (level.isSolid(x3, y4)) solid = true;
		if (level.isSolid(x2, y4)) solid = true;
		if (level.isSolid(x1, y4)) solid = true;

		if (level.isSolid(x1, y3)) solid = true;
		if (level.isSolid(x1, y2)) solid = true;
		if (level.isSolid(x1, y1)) solid = true;

		return solid;
	}

	private boolean collision(float x, float y) {
		boolean solid = false;
		int x1 = (int) (x / level.tileSize);
		int y1 = (int) (y / level.tileSize);
		int x2 = (int) (x + width) / level.tileSize;
		int y2 = (int) (y + height) / level.tileSize;
		int x3 = (int) (x + (width / 2)) / level.tileSize;
		int y3 = (int) (y + (height / 2)) / level.tileSize;
		int x4;
		int y4;
		if (level.isSolid(x1, y1)) solid = true;
		if (level.isSolid(x2, y1)) solid = true;
		if (level.isSolid(x2, y2)) solid = true;
		if (level.isSolid(x1, y2)) solid = true;
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
