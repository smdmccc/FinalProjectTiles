import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.tiled.TiledMap;
import java.io.*;
import java.util.Scanner;

public class Screen 
{
	private TiledMap map;
	private Rectangle[] collisionList;
	File collisions; 
	Scanner inputFile;
	
	public Screen(String mapFile, String collisionFile) throws SlickException, IOException
	{
		map = new TiledMap(mapFile);
		collisions = new File(collisionFile);
		inputFile = new Scanner(collisions);
		buildCollisions();
	}
	
	public void buildCollisions ()
	{
		Rectangle[] tempCollisionList = new Rectangle[500];
		int i = 0;
		while (inputFile.hasNext() )
		{
			int x = inputFile.nextInt();
			int y = inputFile.nextInt();
			int width = inputFile.nextInt();
			int height = inputFile.nextInt();
			tempCollisionList[i] = new Rectangle(x, y, width, height);
			i++;
		}
		this.collisionList = new Rectangle[i];
		for (int j = 0; j < i; j++)
		{
			collisionList[j] = tempCollisionList[j];
		}
	}
	
	public TiledMap getMap()
	{
		return this.map;
	}
	
	public Rectangle[] getCollisions()
	{
		return this.collisionList;
	}
	
	

}
