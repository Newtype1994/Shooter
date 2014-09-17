import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ShooterGame extends BasicGame{
	
	private Player player1;
	private Player player2;
	private Bullet[] bullet1 = new Bullet[3];
	private Bullet[] bullet2 = new Bullet[3];

	public ShooterGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player1.draw();
		player2.draw();
		for(int i = 0 ; i < 3 ; i++){
			bullet1[i].draw();
			bullet2[i].draw();
		}
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player1 = new Player(0,239);
		player2 = new Player(607,239);
		for(int i = 0 ; i < 3 ; i++){
			bullet1[i] = new Bullet(-100,-100);
			bullet2[i] = new Bullet(-100,-100);
		}
	}
	
	@Override
	public void keyPressed (int key , char c){
		if(key == Input.KEY_G){
			player1.shoot(bullet1);
		}
		if(key == Input.KEY_ENTER){
			player2.shoot(bullet2);
		}
	}
	
	boolean playerCollision(int x1,int y1,int x2,int y2){
		if(Math.abs(x1-x2)<32&&Math.abs(y1-y2)<32){
			return false;
		}
		return true;
	}
	
	void updatePlayer1Movement(Input input,int delta){
		if(input.isKeyDown(Input.KEY_W)){
			if(playerCollision(player1.getX(),player1.getY()-1,player2.getX(),player2.getY())){
				player1.move(0,-1);
			}
			if(playerCollision(player1.getX(),player1.getY()-1,player2.getX(),player2.getY())){
				player1.move(0,-1);
			}
			player1.setRotation(0);
		}
		else if(input.isKeyDown(Input.KEY_S)){
			if(playerCollision(player1.getX(),player1.getY()+1,player2.getX(),player2.getY())){
				player1.move(0,1);
			}
			if(playerCollision(player1.getX(),player1.getY()+1,player2.getX(),player2.getY())){
				player1.move(0,1);
			}
			player1.setRotation(180);
		}
		else if(input.isKeyDown(Input.KEY_A)){
			if(playerCollision(player1.getX()-1,player1.getY(),player2.getX(),player2.getY())){
				player1.move(-1,0);
			}
			if(playerCollision(player1.getX()-1,player1.getY(),player2.getX(),player2.getY())){
				player1.move(-1,0);
			}
			player1.setRotation(270);
		}
		else if(input.isKeyDown(Input.KEY_D)){
			if(playerCollision(player1.getX()+1,player1.getY(),player2.getX(),player2.getY())){
				player1.move(1,0);
			}
			if(playerCollision(player1.getX()+1,player1.getY(),player2.getX(),player2.getY())){
				player1.move(1,0);
			}
			player1.setRotation(90);
		}
	}
	
	void updatePlayer2Movement(Input input,int delta) throws SlickException{
		if(input.isKeyDown(Input.KEY_UP)){
			if(playerCollision(player1.getX(),player1.getY(),player2.getX(),player2.getY()-1)){
				player2.move(0,-1);
			}
			if(playerCollision(player1.getX(),player1.getY(),player2.getX(),player2.getY()-1)){
				player2.move(0,-1);
			}
			player2.setRotation(0);
		}
		else if(input.isKeyDown(Input.KEY_DOWN)){
			if(playerCollision(player1.getX(),player1.getY(),player2.getX(),player2.getY()+1)){
				player2.move(0,1);
			}
			if(playerCollision(player1.getX(),player1.getY(),player2.getX(),player2.getY()+1)){
				player2.move(0,1);
			}
			player2.setRotation(180);
		}
		else if(input.isKeyDown(Input.KEY_LEFT)){
			if(playerCollision(player1.getX(),player1.getY(),player2.getX()-1,player2.getY())){
				player2.move(-1,0);
			}
			if(playerCollision(player1.getX(),player1.getY(),player2.getX()-1,player2.getY())){
				player2.move(-1,0);
			}
			player2.setRotation(270);
		}
		else if(input.isKeyDown(Input.KEY_RIGHT)){
			if(playerCollision(player1.getX(),player1.getY(),player2.getX()+1,player2.getY())){
				player2.move(1,0);
			}
			if(playerCollision(player1.getX(),player1.getY(),player2.getX()+1,player2.getY())){
				player2.move(1,0);
			}
			player2.setRotation(90);
		}
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updatePlayer1Movement(input,delta);
		updatePlayer2Movement(input,delta);
		for(int i=0;i<3;i++){
			bullet1[i].update();
			bullet2[i].update();
		}
	}
	
	public static void main(String[] args) {
	    try {
	      ShooterGame game = new ShooterGame("Flappy Dot");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(640,480, false);
	      appgc.setTargetFrameRate(60);
	      //appgc.setMinimumLogicUpdateInterval(1000/30);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}