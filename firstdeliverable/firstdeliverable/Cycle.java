/**
 * @author Rishabh Tandon
 */

package firstdeliverable;

public class Cycle {
	private int xPos;
	private int yPos;
	private int curHeading;
	private int playerNum;
	//0-> left
	//1 -> right
	//2 -> up
	//3 -> down
	
	
	public Cycle(int xPos, int yPos, int curHeading, int playerNum){
		this.xPos = xPos;
		this.yPos = yPos;
		this.curHeading = curHeading;
		this.playerNum = playerNum;
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
	public int getPlayerNum(){
		return playerNum;
	}
}
