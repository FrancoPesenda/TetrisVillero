package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.tetris10;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title= "Tetris bien cajetilla perri" ;
		config.resizable = false ;
		config.width = 500 ;
		config.height = 800;
		new LwjglApplication(new tetris10(config.height , config.width ), config);
	}
}
