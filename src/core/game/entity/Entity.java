package core.game.entity;

import core.game.level.Level;
import org.newdawn.slick.tiled.TiledMap;

import core.game.graphics.Screen;

public class Entity {

	protected float x, y;
	protected int width, height;
	protected Level level;

	public Entity(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void update(int delta) {
	}

	public void render(Screen screen) {
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setLevel(Level level) {
		this.level = level;
	}
}
