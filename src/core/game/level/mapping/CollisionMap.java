package core.game.level.mapping;

import org.newdawn.slick.tiled.TiledMap;

public class CollisionMap {

	private boolean[] solid;
	private int width;
	
	public CollisionMap(TiledMap map, int width, int height, int tileSize) {
		this.width = width;
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
	
	public boolean getCollision(int x, int y){
		return solid[x + y * width];
	}

}
