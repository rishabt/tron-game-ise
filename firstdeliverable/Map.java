package firstdeliverable;

public class Map {
	private int[][] map;
	private int DEFAULT_MAP_SIZE = 500;
	private int xSize;
	private int ySize;
	
	public int[][] getMap(){
		return map;
	}
	public int[][] getMap(int i){
		setMap(i);
		return map;
	}
	
	public int[][] getMap(int i, int height, int width){
		return map;
	}
	private void setMap(int i){
		
		if (i == 1){
		}
		
	}
	private void setBorder(int height, int width){
		for (int i = 0; i<height; i++){
			for (int j = 0; j<width; j++){
				if (i==0 || j==0){
					map[i][j] = 1;
				}
				else{
					map[i][j] = 0;
				}
			}
		}
	}
	public void setDefaultMap(){
		map = new int[DEFAULT_MAP_SIZE][DEFAULT_MAP_SIZE];
		setBorder(DEFAULT_MAP_SIZE, DEFAULT_MAP_SIZE);
		this.xSize = DEFAULT_MAP_SIZE;
		this.ySize = DEFAULT_MAP_SIZE;
	}
	public void customMap(int[][] map){
		this.map = map;
	}
	public int getXSize(){
		return this.xSize;
	}
	public int getYSize(){
		return this.ySize;
	}
}
