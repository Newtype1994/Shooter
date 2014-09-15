import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ShooterGame extends BasicGame{
	
	private Player player1;
	private Player player2;

	public ShooterGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		player1.draw();
		player2.draw();
		
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		player1 = new Player(0,240);
		player2 = new Player(608,240);
		
	}
	
	void updatePlayerMovement(Input input,int delta){
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		Input input = container.getInput();
		updatePlayerMovement(input,delta);
	}
	
	public static void main(String[] args) {
	    try {
	      ShooterGame game = new ShooterGame("Flappy Dot");
	      AppGameContainer appgc = new AppGameContainer(game);
	      appgc.setDisplayMode(640,480, false);
	      appgc.setMinimumLogicUpdateInterval(1000/30);
	      appgc.start();
	    } catch (SlickException e) {
	      e.printStackTrace();
	    }
	  }

}