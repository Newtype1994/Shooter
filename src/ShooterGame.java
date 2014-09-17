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
	private int[][] map = new int[640][480];

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
		player1 = new Player(0,240);
		for(int i=0;i<32;i++){
			for(int j=240;j<272;j++){
				map[i][j] = 1;
			}
		}
		player2 = new Player(608,240);
		for(int i=608;i<640;i++){
			for(int j=240;j<272;j++){
				map[i][j] = 1;
			}
		}
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
	
	void updatePlayer1Movement(Input input,int delta){
		if(input.isKeyDown(Input.KEY_W)){
			player1.move(0,-1);
		}
		else if(input.isKeyDown(Input.KEY_S)){
			player1.move(0,1);
		}
		else if(input.isKeyDown(Input.KEY_A)){
			player1.move(-1,0);
		}
		else if(input.isKeyDown(Input.KEY_D)){
			player1.move(1,0);
		}
	}
	
	void updatePlayer2Movement(Input input,int delta) throws SlickException{
		if(input.isKeyDown(Input.KEY_UP)){
			player2.move(0,-1);
		}
		else if(input.isKeyDown(Input.KEY_DOWN)){
				player2.move(0,1);
		}
		else if(input.isKeyDown(Input.KEY_LEFT)){
				player2.move(-1,0);
		}
		else if(input.isKeyDown(Input.KEY_RIGHT)){
				player2.move(1,0);
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