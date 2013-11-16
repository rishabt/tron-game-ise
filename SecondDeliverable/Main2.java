
import javax.swing.*;

public class Main2 extends JFrame{
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		LoginGUI panel = new LoginGUI();
		frame.add(panel);
		frame.setBounds(0, 0, 600, 600);
		frame.setVisible(true);
	}

}
