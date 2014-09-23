import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ShooterMapGame extends BasicGame{
	
	private Object player1;
	private Object player2;
	private int bulletNum = 3;
	private Object[] bullet1;
	private Object[] bullet2;
	private static int height = 480;
	private static int width = 640;
	private Map map;
	
	public ShooterMapGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		player1.draw();
		player2.draw();
		for(int i = 0 ; i < bulletNum ; i++){
			bullet1[i].draw();
			bullet2[i].draw();
		}
		arg1.drawString(player1.vX()+" "+player1.vY(),player1.getX(),player1.getY());
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		map = new Map(width,height);
		player1 = new Object(1);
		player1.setPosition(0,height/2);
		map.drawAll(player1);
		player2 = new Object(2);
		player2.setPosition(width-player2.getWidth(),height/2);
		map.drawAll(player2);
		bullet1 = new Object[bulletNum];
		bullet2 = new Object[bulletNum];
		for(int i = 0 ; i < bulletNum ; i++){
			bullet1[i] = new Object(3);
			bullet1[i].setPosition(-100,-100);
			map.drawAll(bullet1[i]);
			bullet2[i] = new Object(3);
			bullet2[i].setPosition(-100,-100);
			map.drawAll(bullet2[i]);
		}
	}

	void updatePlayer1(Input input,int delta)throws SlickException{
		if(input.isKeyDown(Input.KEY_W)){
			player1.setRotation(0);
			if(map.checkCollision(player1)){
				map.newDraw(player1);
				player1.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_S)){
			player1.setRotation(180);
			if(map.checkCollision(player1)){
				map.newDraw(player1);
				player1.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_A)){
			player1.setRotation(270);
			if(map.checkCollision(player1)){
				map.newDraw(player1);
				player1.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_D)){
			player1.setRotation(90);
			if(map.checkCollision(player1)){
				map.newDraw(player1);
				player1.move();
			}
		}
	}
	
	void updatePlayer2(Input input,int delta)throws SlickException{
		if(input.isKeyDown(Input.KEY_UP)){
			player2.setRotation(0);
			if(map.checkCollision(player2)){
				map.newDraw(player2);
				player2.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN)){
			player2.setRotation(180);
			if(map.checkCollision(player2)){
				map.newDraw(player2);
				player2.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_LEFT)){
			player2.setRotation(270);
			if(map.checkCollision(player2)){
				map.newDraw(player2);
				player2.move();
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT)){
			player2.setRotation(90);
			if(map.checkCollision(player2)){
				map.newDraw(player2);
				player2.move();
			}
		}
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();
		updatePlayer1(input,arg1);
		updatePlayer2(input,arg1);
	}
	
	public static void main(String[] args) {
	    try {
	      ShooterMapGame game = new ShooterMapGame("Shooter");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(width,height, false);
	      appgc.setTargetFrameRate(60);
	      //appgc.setMinimumLogicUpdateInterval(1000/30);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }
	
}
