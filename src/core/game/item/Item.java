package core.game.item;

public class Item {
	private int itemID;
	private itemType type;
	
	public Item(int itemID, itemType type){
		this.itemID = itemID;
		this.type = type;
	}
	
	public enum itemType{
		CONSUMABLE,
		WEAPON,
		EQUIPABLE,
		MATERIAL;
	}
	
	/*
	 * Is called when player double clicks on item in inventory UI
	 */
	public void onUse(){
		switch(this.type){
		case CONSUMABLE:
			/*
			 * Add health to player or possibly weird status effect?
			 */
			break;
		case WEAPON:
			/*
			 * Equip weapon
			 */
			break;
		case EQUIPABLE:
			/*
			 * Equip equipment
			 */
			break;
		case MATERIAL:
			/*
			 * Nothing, unless shop or crafting GUI is opened
			 */
			break;
		default:
			//undefined type;
		}
	}
}
