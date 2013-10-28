package core.game.entity.player;

import core.game.data.item.Item;

public class Weapon extends Item {
	public Weapon(int itemID){
		super(itemID, itemType.WEAPON);
	}
}
