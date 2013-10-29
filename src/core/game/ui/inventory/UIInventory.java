package core.game.ui.inventory;

import org.newdawn.slick.SlickException;

import core.game.ui.UserInterface;
import core.game.graphics.UIRenderer;

public class UIInventory extends UserInterface {

	public UIInventory(UIRenderer UIRenderer, float x, float y, int width, int height, String key)	throws SlickException {
		super(UIRenderer, "Inventory", x, y, width, height, key);
	}
}
