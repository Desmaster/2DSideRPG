package core.game;

import core.game.entity.Player;
import core.game.graphics.Screen;
import core.game.level.Level;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame {

	private Screen screen;
	private Player player;
	private Level level;

	public Game(String title) {
		super(title);
	}

	public void init(GameContainer gameContainer) throws SlickException {
		screen = new Screen(gameContainer.getGraphics());
		player = new Player(0, 0);
		level = new Level("/res/level.tmx");
		level.add(player);
	}

	public void update(GameContainer gameContainer, int delta) throws SlickException {
		level.update(delta);
	}

	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
		float xOffset = player.getX() - Display.getWidth() / 2;
		float yOffset = player.getY() - Display.getHeight() / 2;
		screen.setOffset(xOffset, yOffset);
		level.render(screen);
	}

}
