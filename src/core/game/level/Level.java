package core.game.level;

import core.game.entity.Entity;
import core.game.graphics.Screen;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level {

	private List<Entity> entities = new ArrayList<Entity>();
	private TiledMap world;
	
	public Level() throws SlickException {
	}
	
	public void loadWorld(String path) throws SlickException{
		entities.clear();
		world = new TiledMap(path);
	}
	
	public void update(int delta) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(delta);
		}
	}

	public void render(Screen screen) {
		world.render(0, 0);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void add(Entity entity) {
		entity.setWorld(world);
		entities.add(entity);
	}

}
