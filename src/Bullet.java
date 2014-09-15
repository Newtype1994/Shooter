import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Bullet {
	private Image image;
	private int x;
	private int y;
	
	public Bullet(int x,int y)throws SlickException {
		
		this.x = x;
		this.y = y;
	}
}
