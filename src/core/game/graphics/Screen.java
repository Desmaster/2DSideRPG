package core.game.graphics;

import core.game.entity.Entity;
import core.game.entity.Mob;
import core.game.entity.Player;

import org.newdawn.slick.Graphics;

public class Screen {

	private float x, y;
	private Graphics graphics;

	public Screen(Graphics graphics) {
		this.graphics = graphics;
	}

	public void render(Entity entity) {
	}

	public void render(Mob mob) {
	}

	public void render(Player player) {
		graphics.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
	}
	
	public void setOffset(float x, float y) {
		this.x = x;
		this.y = y;
	}

}
