package core.game.level;

import core.game.entity.Entity;
import core.game.graphics.Screen;
import core.game.level.mapping.CollisionMap;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Level {

	public int tileSize;

	private List<Entity> entities = new ArrayList<Entity>();
	private TiledMap map;
	private CollisionMap collisionMap;

	public Level(String path) throws SlickException {
		map = new TiledMap(path);
		tileSize = map.getTileWidth() & map.getTileHeight();
		if (tileSize == 0) throw new SlickException("TileWidth and TileHeight are not equal.");
		collisionMap = new CollisionMap(map, tileSize);
		Log.info("Tilesize: " + tileSize);
	}

	/**
	 * Used for switching to a map.
	 *
	 * @param path Path to the map
	 * @throws SlickException
	 */
	public void loadWorld(String path) throws SlickException {
		entities.clear();
		map = new TiledMap(path);
	}

	public void update(int delta) {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update(delta);
		}
	}

	public void render(Screen screen) {
		screen.render(map, tileSize);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void add(Entity entity) {
		entity.setLevel(this);
		entities.add(entity);
	}

	public int getPixelWidth() {
		return map.getWidth() * map.getTileWidth();
	}

	public int getPixelHeight() {
		return map.getHeight() * map.getTileHeight();
	}

	public boolean isSolid(int x, int y) {
		return collisionMap.getCollision(x, y);
	}

}
