/**
 * @author Rishabh Tandon
 */

package firstdeliverable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{

	private JLabel title;
	private JLabel description;
	private JButton start;
	
	public Panel(){
		makeComponents();
		makeLayout();
	}
	public Dimension getPreferredSize() {
		return new Dimension(Frame.getXSize(),Frame.getYSize());
	}
	public void makeComponents(){
		title = new JLabel("Prototype Demonstration I");
		title.setFont(new Font("Times", Font.BOLD, 37));
		title.setBounds(310, 10, 510, 45);
		
		start = new JButton("Start Game");
		start.setBounds(440, 166, 200, 60);
		start.addActionListener(this);
		
		description = new JLabel("� Copyright of Group 7, ECSE 321, McGill University");
		description.setFont(new Font("Times", Font.BOLD, 10));
		description.setBounds(100, 500, 510, 45);
	}
	public void makeLayout(){
		setLayout(null);
		add(title);
		add(start);
		add(description);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		if(e.getActionCommand()=="Start Game"){
			Map map = new Map();
			map.setDefaultMap();
			GameMaster game = new GameMaster(5, map, Color.RED, Color.BLUE);
			game.gameInit();
			game.gameStart();
		}*/
	}
	
}