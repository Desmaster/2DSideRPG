package core.game.item;

import java.util.ArrayList;
import java.util.List;

public class ItemStack extends Item {

	private List<Item> itemList = new ArrayList<Item>();
	private Item item;

	public ItemStack(Item item, int count) {
		super(item.name, item.sprite);
		this.item = item;
		for (int i = 0; i < count; i++) {
			itemList.add(item);
		}
	}

	public void remove(int amount) {
		if (itemList.size() >= amount) {
			for (int i = 0; i < amount; i++) {
				itemList.remove(0);
			}
		} else {
			for (int i = 0; i < itemList.size(); i++) {
				itemList.remove(0);
			}
		}
	}

}
