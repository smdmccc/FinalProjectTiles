import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Screens
{	
	public static ArrayList<TiledMap> screens;
	public static void initScreens() throws SlickException
	{
		screens = new ArrayList<TiledMap>();
		screens.add(new TiledMap("res/map_02/screen1.tmx"));
		screens.add(new TiledMap("res/map_02/screen2.tmx"));

	}

}
