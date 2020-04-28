

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Player 
{
	private int x;
	private int y;
	private int width;
	private int height;
	private int screenX;
	private int screenY;
	public Animation playerAnim, movingUp, movingDown, movingLeft, movingRight;
	public int[] duration = {200, 200, 200, 200};
	public Rectangle hitbox;
	
	public Player()
	{
		// Start player in middle of first screen
		x = Game.WIDTH / 2;
		y = Game.HEIGHT / 2;
	}
	
	public void init() throws SlickException
	{
		Image[] walkUp = 
			{
				new Image("res/character_walking/up_1.png"),
				new Image("res/character_walking/up_2.png"),
				new Image("res/character_walking/up_3.png"),
				new Image("res/character_walking/up_4.png")
			};
		
		Image[] walkDown = 
			{
				new Image("res/character_walking/down_1.png"),
				new Image("res/character_walking/down_2.png"),
				new Image("res/character_walking/down_3.png"),
				new Image("res/character_walking/down_4.png")
			};
		
		Image[] walkLeft = 
			{
				new Image("res/character_walking/left_1.png"),
				new Image("res/character_walking/left_2.png"),
				new Image("res/character_walking/left_3.png"),
				new Image("res/character_walking/left_4.png")
			};
		
		Image[] walkRight = 
			{
				new Image("res/character_walking/right_1.png"),
				new Image("res/character_walking/right_2.png"),
				new Image("res/character_walking/right_3.png"),
				new Image("res/character_walking/right_4.png")
			};
		
		width = 16;
		height = 32;
		
		hitbox = new Rectangle(x, y, width, height);
		
		movingUp = new Animation(walkUp, duration, true);
		movingUp.setLooping(true);
		
		movingDown = new Animation(walkDown, duration, true);
		movingDown.setLooping(true);
		
		movingLeft = new Animation(walkLeft, duration, true);
		movingLeft.setLooping(true);
		
		movingRight = new Animation(walkRight, duration, true);
		movingRight.setLooping(true);
		
		playerAnim = movingDown;
	}
	
	public void update(int delta, GameContainer gc) throws SlickException
	{
		if(Controls.moveUp(gc))
		{
			playerAnim = movingUp;
			y -= (delta * .2f);
			playerAnim.start();
		}
		if(Controls.moveDown(gc))
		{
			playerAnim = movingDown;
			y += (delta * .2f);
			playerAnim.start();
		}
		if(Controls.moveLeft(gc))
		{
			playerAnim = movingLeft;
			x -= (delta * .2f);
			playerAnim.start();
		}
		if(Controls.moveRight(gc))
		{
			playerAnim = movingRight;
			x += (delta * .2f);
			playerAnim.start();
		}
		if (Controls.noMovement(gc))
		{
			playerAnim.stop();
		}
		
		// Update the location of players hitbox on each frame
		hitbox.setX(x);
		hitbox.setY(y);
		
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public Rectangle getBox()
	{
		return hitbox;
	}
}
