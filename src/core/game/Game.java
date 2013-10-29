package core.game;

import core.game.entity.Player;
import core.game.graphics.Screen;
import core.game.graphics.UIRenderer;
import core.game.level.Level;
import core.game.ui.UserInterface;
import core.game.ui.inventory.UIInventory;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Game extends BasicGame{

	private Screen screen;
	private Player player;
	private Level level;
	private static UIRenderer UIRenderer;
	private UserInterface inventory;

	public Game(String title) {
		super(title);
	}

	public void init(GameContainer gameContainer) throws SlickException {
		screen = new Screen(gameContainer.getGraphics());
		player = new Player(0, 0);
		level = new Level("/res/level.tmx");
		level.add(player);
		UIRenderer = new UIRenderer();
		inventory = new UIInventory(UIRenderer, 100, 100, 200, 200, "I");
	}

	public void update(GameContainer gameContainer, int delta) throws SlickException {
		level.update(delta);
		UIRenderer.update(delta);
		
	}

	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
		level.render(screen);
		UIRenderer.render(graphics);
	}
}
