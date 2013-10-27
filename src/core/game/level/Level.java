package core.game.level;

import core.game.entity.Entity;
import core.game.graphics.Screen;

import java.util.ArrayList;
import java.util.List;

public class Level {

	private List<Entity> entities = new ArrayList<Entity>();

	public Level(String path) {
	}

	public void update(int delta) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(delta);
		}
	}

	public void render(Screen screen) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void add(Entity entity) {
		entities.add(entity);
	}

}
