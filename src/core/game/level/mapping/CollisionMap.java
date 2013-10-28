package core.game.level.mapping;

import org.newdawn.slick.tiled.TiledMap;

public class CollisionMap {

	private boolean[] solid;

	public CollisionMap(TiledMap map, int width, int height, int tileSize) {
		int layer = map.getObjectLayerIndex("Collision");

		solid = new boolean[width * height];

		for (int i = 0; i < map.getObjectCount(layer); i++) {
			int x = map.getObjectX(layer, i) + map.getObjectWidth(layer, i);
			int y = map.getObjectY(layer, i) + map.getObjectHeight(layer, i);

			for (int xa = map.getObjectX(layer, i); xa < x; xa++) {
				for (int ya = map.getObjectY(layer, i); ya < y; ya++) {

					solid[xa + ya * width] = true;

				}
			}

		}
	}

}
