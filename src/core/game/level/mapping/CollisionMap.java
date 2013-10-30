package core.game.level.mapping;

import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.util.Log;

public class CollisionMap {

	private boolean[] solid;
	private int width, height;
	
	public CollisionMap(TiledMap map, int tileSize) {
		int layer = map.getObjectLayerIndex("Collision");

		width = map.getWidth();
		height = map.getHeight();

		solid = new boolean[width * height];

		for (int i = 0; i < map.getObjectCount(layer); i++) {
			int x = (map.getObjectX(layer, i) + map.getObjectWidth(layer, i)) / tileSize;
			int y = (map.getObjectY(layer, i) + map.getObjectHeight(layer, i)) / tileSize;

			for (int xa = map.getObjectX(layer, i) / tileSize; xa < x; xa++) {
				for (int ya = map.getObjectY(layer, i) / tileSize; ya < y; ya++) {
					solid[xa + ya * width] = true;
				}
			}

		}
	}
	
	public boolean getCollision(int x, int y){
		return x < 0 || y < 0 || x >= width || y >= height || solid[x + y * width];
	}

}
