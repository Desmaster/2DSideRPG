package core.game.ui;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import core.game.graphics.UIRenderer;

public class UserInterface {
	
	public float x, y;
	public int width, height;
	public Image sprite;
	public UIRenderer UIRenderer;
	public String key, name;
	
	public UserInterface(UIRenderer UIRenderer,String name, float x, float y, int width, int height, String key) throws SlickException{
		this.UIRenderer = UIRenderer;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.sprite = new Image("/res/gfx/UserInterface/UI.png");
		this.key = key;
		this.name = name;
		
		UIRenderer.UIList.add(this);
	}

	public void ActivateOnKey(int updateTimer, String key) {
		if (Keyboard.isKeyDown(Keyboard.getKeyIndex(key)) && updateTimer >= 400){
			if (UIRenderer.isActive(this)){
				UIRenderer.deactivate(this);
			}else{
				UIRenderer.activate(this);
			}
		}
	}
}
