import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Bullet {
	private Image image;
	private int x;
	private int y;
	private int rotation;
	private boolean isUse;
	
	public Bullet(int x,int y) throws SlickException{
		image = new Image("res/Bullet.png");
		this.x = x;
		this.y = y;
		isUse = false;
	}
	
	public void draw(){
		image.draw(x,y);
	}
	
	public boolean use(int x,int y,int rotation){
		if(isUse){
			return false;
		}
		isUse = true;
		this.x = x+6+((int)Math.cos(Math.toRadians(rotation-90))*26);
		this.y = y+6+((int)Math.sin(Math.toRadians(rotation-90))*26);
		this.rotation = rotation;
		return true;
	}
		
	public void update(){
		if(this.x + Math.cos(Math.toRadians(rotation-90)) > 0 && this.x + Math.cos(Math.toRadians(rotation-90)) < 620 && this.y + Math.sin(Math.toRadians(rotation-90)) > 0 && this.y + Math.sin(Math.toRadians(rotation-90)) < 460){
			for(int i=0;i<5;i++){
				this.x += Math.cos(Math.toRadians(rotation-90));
				this.y += Math.sin(Math.toRadians(rotation-90));
			}	
		}
		else {
			this.x = -100;
			this.y = -100;
			this.isUse = false;
		}
	}
}
