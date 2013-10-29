package firstdeliverable;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Panel extends JPanel implements ActionListener{

	private JLabel title;
	
	public Panel(){
		makeComponents();
		makeLayout();
	}
	
	public void makeComponents(){
		title = new JLabel("Prototype Demonstration I");
		title.setFont(new Font("Times", Font.BOLD, 40));
		title.setBounds(310, 10, 510, 45);
	}
	
	public void makeLayout(){
		setLayout(null);
		add(title);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}