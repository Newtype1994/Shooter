import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Object {
	
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	private int type; //1=Player1,2=Player2,3=Bullet
	
	public Object(int type)throws SlickException{
		this.type = type;
		if(type == 1 || type == 2 || type == 5){
			image = new Image("res/Tank2.png");
		}
		else if(type == 3){
			image = new Image("res/Bullet.png");
		}
		else if(type == 4){
			image = new Image("res/Wall.png");
		}
		this.width = image.getWidth();
		this.height = image.getHeight();
	}
	
	public void draw(){
		image.draw(x,y);
	}
	
	public void move(){
		this.x += vX();
		this.y += vY();
	}

	public void setPosition(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void setRotation(int rotation){
		image.setRotation(rotation);
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public int centerX(){
		return this.x-1+this.width/2;
	}

	public int centerY(){
		return this.y-1+this.height/2;
	}
	
	public int getType(){
		return this.type;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getRotation(){
		return (int)image.getRotation();
	}
	
	public int vX(){
		return (int)Math.cos(Math.toRadians(getRotation()-90));
	}
	
	public int vY(){
		return (int)Math.sin(Math.toRadians(getRotation()-90));
	}
}
