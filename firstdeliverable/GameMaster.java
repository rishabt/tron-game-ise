/**
 * @author Geoffrey Long
 */
package firstdeliverable;


import java.awt.Color;

import javax.swing.Timer;


public class GameMaster {
	public int gameDifficulty;
	public Map map;
	public Color colorPOne;
	public Color colorPTwo;
	public MapPanel mapPanel;
	static Timer timer;
	
	public GameMaster(int gameDifficulty, Map map, Color colorPOne, Color colorPTwo){
		this.gameDifficulty = gameDifficulty;
		this.map = map;
		this.colorPOne = colorPOne;
		this.colorPTwo = colorPTwo;
	}
	
	public void gameInit(){

//NOTER:: May want some sort of score panel here
		mapPanel= Frame.start(map);
	}
	
	public void gameStart(){
		timer = new Timer(50, new GameTimer(mapPanel));
		timer.start();
	}
	public static void gameEnd(){
		timer.stop();
	}
	
	
}
