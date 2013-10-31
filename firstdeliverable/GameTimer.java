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
	
	public GameTimer(MapPanel mapPanel) {
		this.mapPanel = mapPanel;
	}
	
	public void actionPerformed(ActionEvent evt){
		mapPanel.updateMap();
	}
}