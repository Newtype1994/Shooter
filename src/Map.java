
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
	
	public boolean ifX(Object object){
		if(object.centerX()+object.getWidth()/2*object.vX()+object.vX() < 0 || object.centerX()+object.getWidth()/2*object.vX()+object.vX() >= Width){
			return true;
		}
		return false;
	}
	
	public boolean ifY(Object object){
		if(object.centerY()+object.getHeight()/2*object.vY()+object.vY() < 0 || object.centerY()+object.getHeight()/2*object.vY()+object.vY() >= Height){
			return true;
		}
		return false;
	}
	
	public boolean checkCollision(Object object){
		if(ifX(object)){
			return false;
		}
		if(ifY(object)){
			return false;
		}
		if(object.vX() == 0){
			int i = object.centerX()+object.getWidth()/2;
			int j = object.centerY()+object.getHeight()/2*object.vY()+object.vY();
			if( (map[i][j] != 0 && map[i][j] != object.getType()) || (map[i-object.getWidth()][j] != 0 && map[i-object.getWidth()][j] != object.getType())){
				return false;
			}
		}
		if(object.vY() == 0){
			int i = object.centerX()+object.getWidth()/2*object.vX()+object.vX();
			int j = object.centerY()+object.getHeight()/2;
			if( (map[i][j] != 0 && map[i][j] != object.getType()) || (map[i][j-object.getHeight()] != 0 && map[i][j-object.getHeight()] != object.getType())){
				return false;
			}
		}
		return true;
	}
	
	public void drawAll(Object object){
		if(object.getX()<0)return;
		for(int i = 0 ; i < object.getHeight() ; i++){
			for(int j = 0 ; j < object.getWidth() ; j++){
				map[j+object.getX()][i+object.getY()] = object.getType();
			}
		}
	}
	
	public void eraseAll(Object object){
		for(int i = 0 ; i < +object.getHeight() ; i++){
			for(int j = 0 ; j < +object.getWidth() ; j++){
				map[j+object.getX()][i+object.getY()] = 0;
			}
		}
	}
	
}
