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
	public int xPos;
	public int yPos;
	
	public MapPanel(Map map){
		this.map = map.getMap();
		this.xSize = map.getXSize();
		this.ySize = map.getYSize();
		
		setPreferredSize(null);
		
		addKeyListener(this);
		Cycle cycleOne = new Cycle(200, 400, 1);
		Cycle cycleTwo = new Cycle(400, 400, 0);
		cycles = new Cycle[]{cycleOne, cycleTwo};
		cont = new PlayerControl(cycleOne, cycleTwo);
		paintMap();
	}
	
	private void paintMap(){
		for (int i=0; i<xSize; i++){
			for (int j=0; j<ySize; j++){
				if (map[i][j]!=1){
					
					invalidate();
					SampleFrame.repaint();
				}
			}
		}
	}
	
	public Dimension getPreferredSize() {
	        return new Dimension(SampleFrame.getXSize(),SampleFrame.getYSize());
	}
	public void updateMap(){
		for (Cycle cycle : cycles){
			int curDir = cycle.getCurHeading();
			//UML:: could make curHeading an enum in the cycle class
			//this would make it much nicer in this switch statement
			//It would make it way more understandable instead of this number crap
			switch (curDir){
			case 0:
				cycle.setXPos(cycle.getXPos()-1);
			case 1:
				cycle.setXPos(cycle.getXPos()+1);
			case 2:
				cycle.setXPos(cycle.getYPos()+1);
			case 3:
				cycle.setXPos(cycle.getYPos()-1);
			default:
				//NOTER:: add a default exception throw
			}
			
			//UML:: this next part could be its own method
			if (map[cycle.getXPos()][cycle.getYPos()]!=0){
				//Noter:: explosion method
				GameMaster.gameEnd();
				
			}
			else{
				
			}
			
		}
	}

	public void paintComponent(Graphics g){
		System.out.println("jea");
		super.paintComponent(g);
		
		//NOTER:: the size will be the size of one grid		
		int theSize = 10;
				
		int xStart = xPos*theSize;
		int yStart = yPos*theSize;
		g.setColor(Color.BLACK);
		g.drawRect(xStart, yStart, theSize, theSize);
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