import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.geom.*;
import java.util.*;
import java.io.*;
//import org.lwjgl.input.Mouse;

public class Play extends BasicGameState
{
	boolean quit = false;
	
	boolean drawBox = true;		// option to show hitboxes for debugging purposes
	
	// Start in upper left screen in 2d screens array
	int row = 0;
	int col = 0;
	
	Player player = new Player();		// Create an instance of Player
	
	Screen[][] screens = new Screen[2][2];
	Screen currentScreen;
	TiledMap map;
	
	Rectangle[] worldCollisions;
	
	public Play(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{	
		/*screens = new ArrayList<TiledMap>();
		screens.add(new TiledMap("res/map_02/screen1.tmx"));
		screens.add(new TiledMap("res/map_02/screen2.tmx"));
		
		map = screens.get(0);
		
		screens[0][0] = new TiledMap("res/map_02/screen_0_0.tmx");
		screens[1][0] = new TiledMap("res/map_02/screen_1_0.tmx");
		screens[0][1] = new TiledMap("res/map_02/screen_0_1.tmx");
		screens[1][1] = new TiledMap("res/map_02/screen_1_1.tmx");
		*/
		try
		{
			screens[0][0] = new Screen("res/map_02/screen_0_0.tmx", "res/map_02/col_0_0.txt");
			screens[1][0] = new Screen("res/map_02/screen_1_0.tmx", "res/map_02/col_1_0.txt");
			screens[0][1] = new Screen("res/map_02/screen_0_1.tmx", "res/map_02/col_0_1.txt");
			screens[1][1] = new Screen("res/map_02/screen_1_1.tmx", "res/map_02/col_1_1.txt");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		map = screens[row][col].getMap();
		currentScreen = screens[row][col];
		worldCollisions = currentScreen.getCollisions();
		
		player.init();		// run init method for player
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		map.render(0, 0);
		player.playerAnim.draw(player.getX(), player.getY());
		g.drawString("Player X: " + player.getX() + "\nPlayer Y: " + player.getY(), 100, 50);
		g.drawString("Mouse X: " + Controls.getMouseX(gc) + " Mouse Y: " + Controls.getMouseY(gc), 300, 50);
		if (drawBox)
		{
			g.draw(player.getBox() );
			for (int i = 0; i < worldCollisions.length; i++)
			{
				g.draw(worldCollisions[i]);
			}
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{		
		player.update(delta, gc, worldCollisions);

		
		// This code will change, just for testing purposes
		if (player.getY() > 450 && row < 1)
		{
			//map = screens.get(1);
			row++;
			map = screens[row][col].getMap();
			worldCollisions = screens[row][col].getCollisions();
			player.setY(Game.HEIGHT - player.getY() + 30);
		}
		if (player.getY() < 30 && row > 0)
		{
			row--;
			map = screens[row][col].getMap();
			worldCollisions = screens[row][col].getCollisions();
			player.setY(Game.HEIGHT - player.getY() - 30 );
		}
		if (player.getX() > 610 && col < 1)
		{
			col++;
			map = screens[row][col].getMap();
			worldCollisions = screens[row][col].getCollisions();
			player.setX(Game.WIDTH  - player.getX() + 30);
		}
		if (player.getX() < 30 && col > 0)
		{
			col--;
			map = screens[row][col].getMap();
			worldCollisions = screens[row][col].getCollisions();
			player.setX(Game.WIDTH  - player.getX() - 30);
		}
	}
	
	public int getID()
	{
		return 1;
	}
	

}