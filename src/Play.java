import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;
import java.util.*;
//import org.lwjgl.input.Mouse;

public class Play extends BasicGameState
{
	
	//Animation player, movingUp, movingDown, movingLeft, movingRight;
	Image worldMap;
	boolean quit = false;
	
	//int[] duration = {200, 200, 200, 200};
	int playerX = Game.WIDTH / 2;
	int playerY = Game.HEIGHT / 2;
	int shiftX = playerX - (Game.WIDTH / 2);
	int shiftY = playerY - (Game.HEIGHT / 2);
	
	Player player = new Player();
	
	ArrayList<TiledMap> screens = new ArrayList<TiledMap>();
	TiledMap map;
	
	public Play(int state)
	{
		
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		worldMap = new Image("res/map0.png");
		
		screens = new ArrayList<TiledMap>();
		screens.add(new TiledMap("res/map_02/screen1.tmx"));
		screens.add(new TiledMap("res/map_02/screen2.tmx"));
		
		map = screens.get(0);
		

		player.init();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
	{
		map.render(0, 0);
		player.playerAnim.draw(player.getX(), player.getY());
		g.drawString("Player X: " + player.getX() + "\nPlayer Y: " + player.getY(), 100, 50);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException
	{		
		player.update(delta, gc);

		
		// This code will change, just for testing purposes
		if (player.getY() > 450)
		{
			map = screens.get(1);
			player.setY(Game.HEIGHT - player.getY());
		}
	}
	
	public int getID()
	{
		return 1;
	}
	

}
