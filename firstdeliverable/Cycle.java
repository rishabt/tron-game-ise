package firstdeliverable;



public class Cycle {
	private int xPos;
	private int yPos;
	private int curHeading;
	//0-> left
	//1 -> right
	//2 -> up
	//3 -> down
	
	//NOTER should make curHeading an enum if possible
	
	
	public Cycle(int xPos, int yPos, int curHeading){
		this.xPos = xPos;
		this.yPos = yPos;
		this.curHeading = curHeading;
	}
	
	public void setXPos(int i){
		xPos = i;
	}
	public int getXPos(){
		return xPos;
	}
	public void setYPos(int i){
		yPos = i;
	}
	public int getYPos(){
		return yPos;
	}
	public void setCurHeading(int i){
		curHeading = i;
	}
	public int getCurHeading(){
		return curHeading;
	}
}
