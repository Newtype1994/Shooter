import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player {

		private Image image;
		private int x;
		private int y;
		
		public Player(int x,int y)throws SlickException {
			image = new Image("res/Tank.png");
			this.x = x;
			this.y = y;
		}
		
		public void draw(){
			image.draw(x,y);
		}
		
}
