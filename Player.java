

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;

public class Player 
{
	private int x;
	private int y;
	private int screenX;
	private int screenY;
	public Animation playerAnim, movingUp, movingDown, movingLeft, movingRight;
	public int[] duration = {200, 200, 200, 200};
	
	
	public Player()
	{
		// Start player in middle of first screen
		x = Game.WIDTH / 2;
		y = Game.HEIGHT / 2;
		screenX = Game.WIDTH / 2;
		screenY = Game.HEIGHT / 2;
	}
	
	public void init() throws SlickException
	{
		
		// Creates the animation
		Image[] walkUp = 
			{
				new Image("res/sprites/walkup1.png"),
				new Image("res/sprites/walkup2.png"),
				new Image("res/sprites/walkup3.png"),
				new Image("res/sprites/walkup4.png")
			};
		
		Image[] walkDown = 
			{
				new Image("res/sprites/walkdown1.png"),
				new Image("res/sprites/walkdown2.png"),
				new Image("res/sprites/walkdown3.png"),
				new Image("res/sprites/walkdown4.png")
			};
		
		Image[] walkLeft = 
			{
				new Image("res/sprites/walkleft1.png"),
				new Image("res/sprites/walkleft2.png"),
				new Image("res/sprites/walkleft3.png"),
				new Image("res/sprites/walkleft4.png")
			};
		
		Image[] walkRight = 
			{
				new Image("res/sprites/walkright1.png"),
				new Image("res/sprites/walkright2.png"),
				new Image("res/sprites/walkright3.png"),
				new Image("res/sprites/walkright4.png")
			};
			
		movingUp = new Animation(walkUp, duration, true);
		movingUp.setLooping(true);
		
		movingDown = new Animation(walkDown, duration, true);
		movingDown.setLooping(true);
		
		movingLeft = new Animation(walkLeft, duration, true);
		movingLeft.setLooping(true);
		
		movingRight = new Animation(walkRight, duration, true);
		movingRight.setLooping(true);	
						
		// Points to which 
		playerAnim = movingDown;
	}
	
	public void update(int delta, GameContainer gc) throws SlickException
	{
		
		// Links Player animation with keyboard input
		if(Controls.moveUp(gc))
		{
			// Sets which Animation to play
			playerAnim = movingUp;
			// Moves the character
			y -= (delta * .1f);
			// Starts the Animation
			playerAnim.start();
		}
		if(Controls.moveDown(gc))
		{
			playerAnim = movingDown;
			y += (delta * .1f);
			playerAnim.start();
		}
		if(Controls.moveLeft(gc))
		{
			playerAnim = movingLeft;
			x -= (delta * .1f);
			playerAnim.start();
		}
		if(Controls.moveRight(gc))
		{
			playerAnim = movingRight;
			x += (delta * .1f);
			playerAnim.start();
		}
		if (Controls.noMovement(gc))
		{
			playerAnim.stop();
		}
		
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
	
	public int getScreenX()
	{
		return this.screenX;
	}
	
	public int getScreenY()
	{
		return this.screenY;
	}
	
	public void setScreenX(int x)
	{
		this.screenX = x;
	}
	
	public void setScreenY(int y)
	{
		this.screenY = y;
	}
}
