
public class Map {
	
	private int Height;
	private int Width;
	private int[][] map;
	
	public Map(int x,int y){
		this.Height = y;
		this.Width = x;
		map = new int[x][y];
	}
	
	public int getMap(int x,int y){
		return map[x][y];
	}
	
	public boolean checkCollision(Object object){
		if(object.centerX()+object.getWidth()/2*object.vX()+object.vX() < 0 || object.centerX()+object.getWidth()/2*object.vX()+object.vX() >= Width){
			return false;
		}
		if(object.centerY()+object.getHeight()/2*object.vY()+object.vY() < 0 || object.centerY()+object.getHeight()/2*object.vY()+object.vY() >= Height){
			return false;
		}
		return true;
	}
	
	public void drawAll(Object object){
		if(object.getX()<0)return;
		for(int i = 0 ; i < object.getHeight() ; i++){
			for(int j = 0 ; j < object.getWidth() ; j++){
				map[i+object.getY()][j+object.getX()] = object.getType();
			}
		}
	}
	
	public void newDraw(Object object){
		
	}
	
	public void eraseAll(Object object){
		for(int i = 0 ; i < +object.getHeight() ; i++){
			for(int j = 0 ; j < +object.getWidth() ; j++){
				map[i+object.getY()][j+object.getX()] = 0;
			}
		}
	}
	
}
