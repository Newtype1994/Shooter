import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Player {

		private Image image;
		private int x;
		private int y;
		private int rotation;
		
		public Player(int x,int y)throws SlickException {
			image = new Image("res/Tank.png");
			this.x = x;
			this.y = y;
			this.rotation = 0;
		}
		
		public void draw(){
			image.draw(x,y);
		}
		
		public void move(int x,int y){
			if(this.x + x > 0 && this.x + x < 608){
				this.x += x;
			}
			if(this.y + y > 0 && this.y + y < 448){
				this.y += y;
			}
		}
		
		public void shoot(Bullet[] bullet){
			for(int i = 0 ; i < 3 ; i++){
				if(bullet[i].use(x,y,rotation)){
					break;
				}
			}
		}
		
		public int getX(){
			return this.x;
		}
		
		public int getY(){
			return this.y;
		}
		
		public void setRotation(int rotation){
			this.rotation = rotation;
			image.setRotation(rotation);
		}
		
}
