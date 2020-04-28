import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import java.util.*;
//import org.lwjgl.input.Mouse;

public class Play extends BasicGameState
{
	boolean quit = false;
	
	boolean drawBox = true;		// option to show player hitbox for debugging purposes
	
	// Start in upper left screen in 2d screens array
	int row = 0;
	int col = 0;
	
	Player player = new Player();		// Create an instance of Player
	
	TiledMap[][] screens = new TiledMap[2][2];
	TiledMap map;
	
	public Play(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{	
		/*screens = new ArrayList<TiledMap>();
		screens.add(new TiledMap("res/map_02/screen1.tmx"));
		screens.add(new TiledMap("res/map_02/screen2.tmx"));
		
		map = screens.get(0);*/
		
		screens[0][0] = new TiledMap("res/map_02/screen_0_0.tmx");
		screens[1][0] = new TiledMap("res/map_02/screen_1_0.tmx");
		screens[0][1] = new TiledMap("res/map_02/screen_0_1.tmx");
		screens[1][1] = new TiledMap("res/map_02/screen_1_1.tmx");
		
		map = screens[row][col];

		player.init();		// run init method for player
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		map.render(0, 0);
		player.playerAnim.draw(player.getX(), player.getY());
		g.drawString("Player X: " + player.getX() + "\nPlayer Y: " + player.getY(), 100, 50);
		if (drawBox)
		{
			g.draw(player.getBox() );
		}
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{		
		player.update(delta, gc);

		
		// This code will change, just for testing purposes
		if (player.getY() > 450 && row < 1)
		{
			//map = screens.get(1);
			row++;
			map = screens[row][col];
			player.setY(Game.HEIGHT - player.getY() + 30);
		}
		if (player.getY() < 30 && row > 0)
		{
			row--;
			map = screens[row][col];
			player.setY(Game.HEIGHT - player.getY() - 30 );
		}
		if (player.getX() > 610 && col < 1)
		{
			col++;
			map = screens[row][col];
			player.setX(Game.WIDTH  - player.getX() + 30);
		}
		if (player.getX() < 30 && col > 0)
		{
			col--;
			map = screens[row][col];
			player.setX(Game.WIDTH  - player.getX() - 30);
		}
	}
	
	public int getID()
	{
		return 1;
	}
	

}