/**
 * @author Geoffrey Long
 */
package firstdeliverable;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameTimer implements ActionListener{
	MapPanel mapPanel;
	int counter = 0;
	
	public GameTimer(MapPanel mapPanel) {
		this.mapPanel = mapPanel;
	}
	
	public void actionPerformed(ActionEvent evt){
		//if (counter >= 4){
			mapPanel.updatePlayer();
		/*	counter = 0;
		}
		else{
			mapPanel.updateMap();
			counter++;
		}*/
	}
}