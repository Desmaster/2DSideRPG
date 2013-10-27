package core.game.entity;

import core.game.graphics.Screen;

public class Mob extends Entity {

	double lives;

	public Mob(float x, float y, double lives) {
		super(x, y);
		this.lives = lives;
	}

	public void update(int delta) {
	}

	public void render(Screen screen) {
	}

}
