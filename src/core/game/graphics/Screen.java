package core.game.graphics;

import core.game.entity.Entity;
import core.game.entity.Mob;
import core.game.entity.Player;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.tiled.TiledMap;

public class Screen {

	private float xOffset, yOffset;
	private Graphics graphics;

	public Screen(Graphics graphics) {
		this.graphics = graphics;
	}

	public void render(TiledMap map, int tileSize) {
		int x = (int) - (xOffset % tileSize) - tileSize;
		int y = (int) - (yOffset % tileSize) - tileSize;
		int sx = (int) (xOffset / tileSize) - 1;
		int sy = (int) (yOffset / tileSize) - 1;
		int sectionWidth = (Display.getWidth() / tileSize) + 3;
		int sectionHeight = (Display.getHeight() / tileSize) + 4;

		map.render(x, y, sx, sy, sectionWidth, sectionHeight);
	}

	public void render(Entity entity) {
	}

	public void render(Mob mob) {
	}

	public void render(Player player) {
		graphics.fillRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
	}

	public void setOffset(float x, float y) {
		this.xOffset = x;
		this.yOffset = y;
	}

}
