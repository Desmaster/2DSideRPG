package core.game.graphics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import core.game.ui.UserInterface;

public class UIRenderer {
	public List<UserInterface> UIList = new ArrayList<UserInterface>();
	private List<UserInterface> activeUIList = new ArrayList<UserInterface>();
	private int updateTimer;

	public UIRenderer() {
	}

	public void activate(UserInterface ui) {
		activeUIList.add(ui);
		updateTimer = 0;
	}

	public void deactivate(UserInterface ui) {
		Iterator<UserInterface> Iterator = activeUIList.iterator();
		while (Iterator.hasNext()) {
			UserInterface UI = Iterator.next();
			if (UI == ui) {
				Iterator.remove();
			}
		}
		updateTimer = 0;
	}

	public void render(Graphics graphics) {
		for (int i = 0; i < activeUIList.size(); i++) {
			UserInterface UI = UIList.get(i);
			graphics.drawImage(UI.sprite, UI.x, UI.y, 0, 0, UI.width, UI.height);
		}
	}

	public boolean isActive(UserInterface ui) {
		Iterator<UserInterface> Iterator = activeUIList.iterator();
		while (Iterator.hasNext()) {
			UserInterface UI = Iterator.next();
			if (UI == ui) {
				return true;
			}
		}
		return false;
	}

	public void update(int delta) {
		updateTimer += delta;
		for (int i = 0; i < UIList.size(); i++) {
			UserInterface UI = UIList.get(i);
			UI.ActivateOnKey(updateTimer, UI.key);
		}
	}
}
