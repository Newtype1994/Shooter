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
	private Object wall;
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
		wall.draw();
		arg1.drawString(player2.vX()+" "+player2.vY(),player2.getX(),player2.getY());
		/*for(int i = 0 ; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				if( map.getMap(j, i) != 0){
					arg1.drawString("|",j,i);
				}
			}
		}*/
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		map = new Map(width,height);
		player1 = new Object(1);
		player1.setPosition(1,height/2);
		map.drawAll(player1);
		player2 = new Object(2);
		player2.setPosition(width-1-player2.getWidth(),height/2);
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
		wall = new Object(4);
		wall.setPosition(width/2,height/2);
		map.drawAll(wall);
	}
	
	void updatePlayer1(Input input,int delta)throws SlickException{
		if(input.isKeyDown(Input.KEY_W)){
			player1.setRotation(0);
			if(map.checkCollision(player1)==0){
				map.eraseAll(player1);
				player1.move();
				map.drawAll(player1);
			}
		}
		else if(input.isKeyDown(Input.KEY_S)){
			player1.setRotation(180);
			if(map.checkCollision(player1)==0){
				map.eraseAll(player1);
				player1.move();
				map.drawAll(player1);
			}
		}
		else if(input.isKeyDown(Input.KEY_A)){
			player1.setRotation(270);
			if(map.checkCollision(player1)==0){
				map.eraseAll(player1);
				player1.move();
				map.drawAll(player1);
			}
		}
		else if(input.isKeyDown(Input.KEY_D)){
			player1.setRotation(90);
			if(map.checkCollision(player1)==0){
				map.eraseAll(player1);
				player1.move();
				map.drawAll(player1);
			}
		}
	}
	
	void updatePlayer2(Input input,int delta)throws SlickException{
		if(input.isKeyDown(Input.KEY_UP)){
			player2.setRotation(0);
			if(map.checkCollision(player2)==0){
				map.eraseAll(player2);
				player2.move();
				map.drawAll(player2);
			}
		}
		else if(input.isKeyDown(Input.KEY_DOWN)){
			player2.setRotation(180);
			if(map.checkCollision(player2)==0){
				map.eraseAll(player2);
				player2.move();
				map.drawAll(player2);
			}
		}
		else if(input.isKeyDown(Input.KEY_LEFT)){
			player2.setRotation(270);
			if(map.checkCollision(player2)==0){
				map.eraseAll(player2);
				player2.move();
				map.drawAll(player2);
			}
		}
		else if(input.isKeyDown(Input.KEY_RIGHT)){
			player2.setRotation(90);
			if(map.checkCollision(player2)==0){
				map.eraseAll(player2);
				player2.move();
				map.drawAll(player2);
			}
		}
	}
	
	public void updateBullet(){
		for(int i = 0 ; i < bulletNum ; i++){
			if(bullet1[i].getX() != -100){
				if(map.checkCollision(bullet1[i])==0){
					map.eraseAll(bullet1[i]);
					bullet1[i].move();
					map.drawAll(bullet1[i]);
				}
				else{
					map.eraseAll(bullet1[i]);
					bullet1[i].setPosition(-100,-100);
				}
			}
			if(bullet2[i].getX() != -100){
				if(map.checkCollision(bullet2[i])==0){
					map.eraseAll(bullet2[i]);
					bullet2[i].move();
					map.drawAll(bullet2[i]);
				}
				else{
					map.eraseAll(bullet2[i]);
					bullet2[i].setPosition(-100,-100);
				}
			}
		}
	}
	
	@Override
	public void keyPressed (int key , char c){
		if(key == Input.KEY_G){
			for(int i = 0 ; i < bulletNum ; i++){
				if(bullet1[i].getX() == -100){
					bullet1[i].setRotation(player1.getRotation());
					bullet1[i].setPosition(player1.centerX()-bullet1[i].getWidth()/2+player1.getWidth()/2*player1.vX(),player1.centerY()-bullet1[i].getHeight()/2+player1.getHeight()/2*player1.vY());
					map.drawAll(bullet1[i]);
					break;
				}
			}
		}
		if(key == Input.KEY_ENTER){
			for(int i = 0 ; i < bulletNum ; i++){
				if(bullet2[i].getX() == -100){
					bullet2[i].setRotation(player2.getRotation());
					bullet2[i].setPosition(player2.centerX()-bullet2[i].getWidth()/2+player2.getWidth()/2*player2.vX(),player2.centerY()-bullet2[i].getHeight()/2+player2.getHeight()/2*player2.vY());
					map.drawAll(bullet2[i]);
					break;
				}
			}
		}
	}
	
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input input = arg0.getInput();
		updatePlayer1(input,arg1);
		updatePlayer2(input,arg1);
		updateBullet();
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
