/**
 * @author Geoffrey Long
 */
package firstdeliverable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MapPanel extends JPanel implements KeyListener{
	PlayerControl cont;
	Cycle[] cycles;
	Cycle curCycle;
	private int[][] map;
	private int xSize;
	private int ySize;
	private int xPosOne;
	private int yPosOne;
	private int xPosTwo;
	private int yPosTwo;
	private int playerNum;
	private int theSize = 5;
	private boolean gameStart = true;
	private int lastDirOne = 1;
	private int lastDirTwo = 0;
	private boolean isAliveOne = true;
	private boolean isAliveTwo = true;
	private int explosionCount = 0;
	private Timer explosionTimer;
	
	public MapPanel(Map map){
		this.map = map.getMap();
		this.xSize = map.getXSize();
		this.ySize = map.getYSize();
		
		setVisible(true);
		
		addKeyListener(this);
		
		Cycle cycleOne = new Cycle(200, 400, 1, 1, true);
		Cycle cycleTwo = new Cycle(400, 400, 0, 2, true);
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
			playerNum = cycle.getPlayerNum();
			int curDir;
			if (playerNum ==1){
				curDir = lastDirOne;
			}
			else{
				curDir = lastDirTwo;
			}
			//UML:: could make curHeading an enum in the cycle class
			//this would make it much nicer in this switch statement
			//It would make it way more understandable instead of this number crap
			
			switch (curDir){
				case 0:
					cycle.setXPos(cycle.getXPos()-1);
					break;
				case 1:
					cycle.setXPos(cycle.getXPos()+1);
					break;
				case 2:
					cycle.setYPos(cycle.getYPos()+1);
					break;
				case 3:
					cycle.setYPos(cycle.getYPos()-1);
					break;
				default:
					//NOTER:: add a default exception throw
			}
			//UML:: this next part could be its own method
			if (map[cycle.getXPos()][cycle.getYPos()]!=0){
				GameMaster.gameEnd();
				if (playerNum == 1){
					isAliveOne = false;
				}
				if (playerNum == 2){
					isAliveTwo = false;
				}
				explosion();
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
				paintImmediately(xPosOne,yPosOne,theSize,theSize);
				map[xPosOne][yPosOne]=1;
				paintImmediately(xPosTwo,yPosTwo,theSize,theSize);
				map[xPosTwo][yPosTwo]=1;
			}
			
		}
	}
	public void updatePlayer(){
		this.setFocusable(true);
        this.requestFocusInWindow();
		for (Cycle cycle : cycles){
			int curDir = cycle.getCurHeading();
			
			playerNum = cycle.getPlayerNum();
			if (playerNum ==1){
				lastDirOne = curDir;
			}
			else{
				lastDirTwo = curDir;
			}
			//UML:: could make curHeading an enum in the cycle class
			//this would make it much nicer in this switch statement
			//It would make it way more understandable instead of this number crap
			
			switch (curDir){
				case 0:
					cycle.setXPos(cycle.getXPos()-5);
					break;
				case 1:
					cycle.setXPos(cycle.getXPos()+5);
					break;
				case 2:
					cycle.setYPos(cycle.getYPos()+5);
					break;
				case 3:
					cycle.setYPos(cycle.getYPos()-5);
					break;
				default:
					//NOTER:: add a default exception throw
			}
			//UML:: this next part could be its own method
			if (map[cycle.getXPos()][cycle.getYPos()]!=0){
				GameMaster.gameEnd();
				if (playerNum == 1){
					isAliveOne = false;
				}
				if (playerNum == 2){
					isAliveTwo = false;
				}
				explosion();
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
				paintImmediately(xPosOne,yPosOne,theSize,theSize);
				map[xPosOne][yPosOne]=1;
				paintImmediately(xPosTwo,yPosTwo,theSize,theSize);
				map[xPosTwo][yPosTwo]=1;
			}
			
		}
	}

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if (isAliveOne && isAliveTwo){
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
		else{
			if (explosionCount<30){
				g.setColor(Color.ORANGE);
				if(!isAliveOne){
					for (int i = explosionCount/2; i>0; i--){
						int color = (int) (20*Math.random());
						if (i<explosionCount/8){
							if (color>18){
								g.setColor(Color.BLACK);
							}
							else{
								g.setColor(Color.GRAY);
							}
						}
						if (i<explosionCount/6 && i>explosionCount/8){
							if (color>15){
								g.setColor(Color.ORANGE);
							}
							if (color<15 && color<10){
								g.setColor(Color.BLACK);
							}
							if (color<10){
								g.setColor(Color.GRAY);
							}
						}
						if (i<explosionCount/4 && i>explosionCount/6){
							if (color>15){
								g.setColor(Color.ORANGE);
							}
							if (color<15 && color<10){
								g.setColor(Color.BLACK);
							}
							if (color<10){
								g.setColor(Color.RED);
							}
						}
						if (i<explosionCount/2 && i>explosionCount/4){
							if (color>19){
								g.setColor(Color.BLACK);
							}
							if (color<19 && color>15){
								g.setColor(Color.ORANGE);
							}
							if (color<10){
								g.setColor(Color.RED);
							}
						}
						g.fillOval(xPosOne-((int)(i)), yPosOne-((int)(i)), i*2, i*2);
					}
					
				}
				if(!isAliveTwo){
					for (int i = 0; i<explosionCount; i++){
						int iOffset = Math.abs(i-explosionCount/2);
						for (int j=0; j<explosionCount; j++){
							int color = (int) (20*Math.random());
							int jOffset = Math.abs(j-explosionCount/2);
							if (!((iOffset+jOffset)>explosionCount/5)){
								if (color<15){
									if (iOffset > explosionCount/6 || jOffset > explosionCount/6){
										g.setColor(Color.BLACK);
									}
									else{
										g.setColor(Color.RED);
									}
								}
								if (color>=15){
									if (iOffset > explosionCount/6 || jOffset > explosionCount/6){
										g.setColor(Color.GRAY);
									}
									else{
										g.setColor(Color.ORANGE);
									}
								}
								g.fillOval(xPosTwo-((int)(explosionCount/2))+(int)(j*Math.random())+(int)(i*Math.random()), yPosTwo-((int)(explosionCount/2))+(int)(j*Math.random())+(int)(i*Math.random()), (int)(i*Math.random())+(int)(j/2*Math.random()), (int)(i/1.5*Math.random())+(int)(j*Math.random()));
							}
						}
					}
				}
			}
			else{
				explosionTimer.stop();
			}
		}
	}
	
	/*
	 else{
				if (explosionCount<50){
					if(!isAliveTwo){
						for (int i = 0; i < 30; i++){
							for (int j=0; j<30; j++){
								float opacity = (float) (((50-explosionCount)/50)*Math.random());
								Color myColor = new Color(255, 255, 255, 10);
								g.setColor(myColor);
								g.fillOval(xPosTwo, yPosTwo, 15-j/2, 15-i/2);
							}
						}
					}
					if(!isAliveOne){
						for (int i = 0; i < 30; i++){
							for (int j=0; j<30; j++){
								float opacity = (float) (((50-explosionCount)/50)*Math.random());
								Color myColor = new Color(255, 255, 255, 10);
								g.setColor(myColor);
								g.fillOval(xPosOne, yPosOne, 15-j/2, 15-i/2);
							}
						}
					}
				}
	 */
	
	private void explosion(){
		explosionTimer = new Timer(33, new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					explosionCount++;
					if(!isAliveOne){
						paintImmediately(xPosOne-((int)(explosionCount/2)), yPosOne-((int)(explosionCount/2)), (int)(explosionCount*1.5), (int)(explosionCount*1.5));
					}
					if(!isAliveTwo){
						paintImmediately(xPosTwo-((int)(explosionCount/2)), yPosTwo-((int)(explosionCount/2)), (int)(explosionCount*1.5), (int)(explosionCount*1.5));
					}
				}
		});
		explosionTimer.start();
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