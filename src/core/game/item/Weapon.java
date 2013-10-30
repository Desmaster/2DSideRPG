package core.game.item;

import org.newdawn.slick.Image;

public class Weapon extends Item {

	public Weapon(String name, Image sprite){
		super(name, sprite);
	}

	public boolean equipable() {
		return true;
	}

}
