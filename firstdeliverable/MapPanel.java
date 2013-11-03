/**
 * @author Geoffrey Long
 */
package firstdeliverable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.InputMap;
import javax.swing.JPanel;

public class MapPanel extends JPanel implements KeyListener{
	PlayerControl cont;
	Cycle[] cycles;
	Cycle curCycle;
	private int[][] map;
	private int xSize;
	private int ySize;
	public int xPosOne;
	public int yPosOne;
	public int xPosTwo;
	public int yPosTwo;
	private int playerNum;
	private int theSize = 5;
	private boolean gameStart = true;
	private int lastDirOne = -1;
	private int lastDirTwo = -1;
	
	public MapPanel(Map map){
		this.map = map.getMap();
		this.xSize = map.getXSize();
		this.ySize = map.getYSize();
		
		setVisible(true);
		
		addKeyListener(this);
		
		Cycle cycleOne = new Cycle(200, 400, 1, 1);
		Cycle cycleTwo = new Cycle(400, 400, 0, 2);
		cont = new PlayerControl(cycleOne, cycleTwo);
		cycles = new Cycle[]{cycleOne, cycleTwo};
	}
	
	public Dimension getPreferredSize() {
        return new Dimension(Frame.getXSize(),Frame.getYSize());
}
	public void updateMap(){
		this.setFocusable(true);
        this.requestFocusInWindow();
		for (Cycle cycle : cycles){
			int curDir = cycle.getCurHeading();
			playerNum = cycle.getPlayerNum();
			//UML:: could make curHeading an enum in the cycle class
			//this would make it much nicer in this switch statement
			//It would make it way more understandable instead of this number crap
			
			//NOTER:: can make this "better" by putting last dir in the cycle class
			int incrementation = 1;
			if (playerNum == 1 && curDir != lastDirOne){
				incrementation = 5;
			}
			if (playerNum == 2 && curDir != lastDirTwo){
				incrementation = 5;
			}
			switch (curDir){
				case 0:
					cycle.setXPos(cycle.getXPos()-incrementation);
					break;
				case 1:
					cycle.setXPos(cycle.getXPos()+incrementation);
					break;
				case 2:
					cycle.setYPos(cycle.getYPos()+incrementation);
					break;
				case 3:
					cycle.setYPos(cycle.getYPos()-incrementation);
					break;
				default:
					//NOTER:: add a default exception throw
			}
			//UML:: this next part could be its own method
			if (map[cycle.getXPos()][cycle.getYPos()]!=0){
				//Noter:: explosion method
				GameMaster.gameEnd();
			}
			else{
				if (playerNum == 1){
					xPosOne = cycle.getXPos();
					yPosOne = cycle.getYPos();
				}
				else{
					xPosTwo = cycle.getXPos();
					yPosTwo = cycle.getYPos();
				}
			}
			
		}
		paintImmediately(xPosOne,yPosOne,theSize,theSize);
		map[xPosOne][yPosOne]=1;
		paintImmediately(xPosTwo,yPosTwo,theSize,theSize);
		map[xPosTwo][yPosTwo]=1;
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		if (gameStart){
			for (int i=0; i<xSize; i++){
				for (int j=0; j<ySize; j++){
					if (map[i][j]==1){
						g.fillRect(i, j, 5, 5);
					}
				}
			}
			gameStart=false;
		}
		else{
			g.setColor(Color.RED);
			g.fillRect(xPosOne, yPosOne, theSize, theSize);
			g.setColor(Color.BLUE);
			g.fillRect(xPosTwo, yPosTwo, theSize, theSize);
		}
	}
	
	private void paintTrails(Graphics g, int xPos, int yPos){
		super.paintComponents(g);
	}
	
	private void explosion(Graphics g){
		super.paintComponents(g);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		cont.setHeading(e.getKeyCode());
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub	
	}
}