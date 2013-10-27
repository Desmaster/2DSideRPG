package core.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class RunGame {

	public static void main(String[] args) {
		try {
			AppGameContainer gameContainer = new AppGameContainer(new Game("Zijwaardse RPG"));
			gameContainer.setVSync(true);
			gameContainer.setDisplayMode(1280, 720, false);
			gameContainer.setMinimumLogicUpdateInterval(17);
			gameContainer.setMaximumLogicUpdateInterval(17);
			gameContainer.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
