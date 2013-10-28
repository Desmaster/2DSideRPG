package core.game.data.item;

public class Item {
	private int itemID;
	private itemType itemType;
	
	public Item(int itemID, itemType itemType){
		this.itemID = itemID;
		this.itemType = itemType;
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
		switch(this.itemType){
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
			//undefined itemType;
		}
	}
}
