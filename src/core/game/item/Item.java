package core.game.item;

import org.newdawn.slick.Image;

import java.util.ArrayList;
import java.util.List;

public class Item {

	private static List<Item> itemList = new ArrayList<Item>();
	private String name;
	private Image sprite;

	public final static Item hammer = new Weapon("Hammer", null);

	public Item(String name, Image sprite) {
		this.name = name;
		this.sprite = sprite;
		itemList.add(this);
	}

	public static Item getItem(String name) {
		for (int i = 0; i < itemList.size(); i++) {
			if (itemList.get(i).name.equalsIgnoreCase(name))
				return itemList.get(i);
		}
		return null;
	}

	public boolean equipable() {
		return false;
	}

	public boolean eatable() {
		return false;
	}

	public boolean stackable() {
		return false;
	}

}
