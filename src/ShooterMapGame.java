import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;


public class ShooterMapGame extends BasicGame{
	
	private Object player1;
	private Object player2;
	private Object player3;
	private int bulletNum = 3;
	private Object[] bullet1;
	private Object[] bullet2;
	private Object[] bullet3;
	private Object[] wall1;
	private Object[] wall2;
	private Object[] wall3;
	private static int height = 480;
	private static int width = 640;
	private Map map;
	private int dead = 3;
	
	public ShooterMapGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		player1.draw();
		player2.draw();
		player3.draw();
		for(int i = 0 ; i < bulletNum ; i++){
			bullet1[i].draw();
			bullet2[i].draw();
			bullet3[i].draw();
			wall1[i].draw();
			wall2[i].draw();
			wall3[i].draw();
		}
		//arg1.drawString(player2.vX()+" "+player2.vY(),player2.getX(),player2.getY());
		if(dead >= 2){
			arg1.drawString("Press Esc to start",width/3,height/4);
			arg1.drawString("Player 1\nW Up\nS Down\nA Left\nD Right\nG Shoot",width/5,height/2);
			arg1.drawString("Player 2\nArrow Up\nArrow Down\nArrow Left\nArrow Right\nEnter Shoot",2*width/5,height/2);
			arg1.drawString("Player 3\nI Up\nK Down\nJ Left\nL Right\nP Shoot",3*width/5,height/2);
		}
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
		player1.setPosition(-100,-100);
		player2 = new Object(2);
		player2.setPosition(-100,-100);
		player3 = new Object(3);
		player3.setPosition(-100,-100);
		bullet1 = new Object[bulletNum];
		bullet2 = new Object[bulletNum];
		bullet3 = new Object[bulletNum];
		wall1 = new Object[3];
		wall2 = new Object[3];
		wall3 = new Object[3];
		for(int i = 0 ; i < bulletNum ; i++){
			bullet1[i] = new Object(5);
			bullet1[i].setPosition(-100,-100);
			bullet2[i] = new Object(5);
			bullet2[i].setPosition(-100,-100);
			bullet3[i] = new Object(5);
			bullet3[i].setPosition(-100,-100);
			wall1[i] = new Object(6);
			wall1[i].setPosition(width/4,height-wall1[i].getHeight()-(i*200));
			wall2[i] = new Object(6);
			wall2[i].setPosition(width/2,height-wall2[i].getHeight()-(i*200));
			wall3[i] = new Object(6);
			wall3[i].setPosition(3*width/4,height-wall3[i].getHeight()-(i*200));
		}
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
	
	void updatePlayer3(Input input,int delta)throws SlickException{
		if(input.isKeyDown(Input.KEY_I)){
			player3.setRotation(0);
			if(map.checkCollision(player3)==0){
				map.eraseAll(player3);
				player3.move();
				map.drawAll(player3);
			}
		}
		else if(input.isKeyDown(Input.KEY_K)){
			player3.setRotation(180);
			if(map.checkCollision(player3)==0){
				map.eraseAll(player3);
				player3.move();
				map.drawAll(player3);
			}
		}
		else if(input.isKeyDown(Input.KEY_J)){
			player3.setRotation(270);
			if(map.checkCollision(player3)==0){
				map.eraseAll(player3);
				player3.move();
				map.drawAll(player3);
			}
		}
		else if(input.isKeyDown(Input.KEY_L)){
			player3.setRotation(90);
			if(map.checkCollision(player3)==0){
				map.eraseAll(player3);
				player3.move();
				map.drawAll(player3);
			}
		}
	}
	
	public void updateBullet(){
		int collision;
		for(int i = 0 ; i < bulletNum ; i++){
			collision = map.checkCollision(bullet1[i]);
			if(bullet1[i].getX() != -100){
				if(collision == 0){
					map.eraseAll(bullet1[i]);
					bullet1[i].move();
					map.drawAll(bullet1[i]);
				}
				else{
					map.eraseAll(bullet1[i]);
					bullet1[i].setPosition(-100,-100);
				}
				if(collision == 2){
					map.eraseAll(player2);
					player2.setPosition(-100,-100);
					dead++;
				}
				else if(collision == 3){
					map.eraseAll(player3);
					player3.setPosition(-100,-100);
					dead++;
				}
			}
			collision = map.checkCollision(bullet3[i]);
			if(bullet3[i].getX() != -100){
				if(collision==0){
					map.eraseAll(bullet3[i]);
					bullet3[i].move();
					map.drawAll(bullet3[i]);
				}
				else{
					map.eraseAll(bullet3[i]);
					bullet3[i].setPosition(-100,-100);
				}
				if(collision == 1){
					map.eraseAll(player1);
					player1.setPosition(-100,-100);
					dead++;
				}
				else if(collision == 2){
					map.eraseAll(player2);
					player2.setPosition(-100,-100);
					dead++;
				}
			}
			collision = map.checkCollision(bullet2[i]);
			if(bullet2[i].getX() != -100){
				if(collision==0){
					map.eraseAll(bullet2[i]);
					bullet2[i].move();
					map.drawAll(bullet2[i]);
				}
				else{
					map.eraseAll(bullet2[i]);
					bullet2[i].setPosition(-100,-100);
				}
				if(collision == 1){
					map.eraseAll(player1);
					player1.setPosition(-100,-100);
					dead++;
				}
				else if(collision == 3){
					map.eraseAll(player3);
					player3.setPosition(-100,-100);
					dead++;
				}
			}
		}
	}
	
	public void start(){
		map.eraseAll(player1);
		player1.setPosition(1,height/2);
		map.drawAll(player1);
		map.eraseAll(player2);
		player2.setPosition(width-1-player2.getWidth(),height/2);
		map.drawAll(player2);
		map.eraseAll(player3);
		player3.setPosition(width/2,1);
		map.drawAll(player3);
		for(int i = 0 ; i < bulletNum ; i++){
			bullet1[i].setPosition(-100,-100);
			map.drawAll(bullet1[i]);
			bullet2[i].setPosition(-100,-100);
			map.drawAll(bullet2[i]);
			bullet3[i].setPosition(-100,-100);
			map.drawAll(bullet3[i]);
			map.drawAll(wall1[i]);
			map.drawAll(wall2[i]);
			map.drawAll(wall3[i]);
		}
		dead = 0;
	}
	
	@Override
	public void keyPressed (int key , char c){
		if(key == Input.KEY_ESCAPE && dead >= 2){
			start();
		}
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
		if(key == Input.KEY_P){
			for(int i = 0 ; i < bulletNum ; i++){
				if(bullet3[i].getX() == -100){
					bullet3[i].setRotation(player3.getRotation());
					bullet3[i].setPosition(player3.centerX()-bullet3[i].getWidth()/2+player3.getWidth()/2*player3.vX(),player3.centerY()-bullet3[i].getHeight()/2+player3.getHeight()/2*player3.vY());
					map.drawAll(bullet3[i]);
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
		updatePlayer1(input,arg1);
		updatePlayer2(input,arg1);
		updatePlayer3(input,arg1);
		updatePlayer3(input,arg1);
		updateBullet();
		updateBullet();
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
