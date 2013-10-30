package firstdeliverable;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class SampleFrame extends JFrame{
	private static int xSize;
	private static int ySize;
	
	public SampleFrame(){
		Toolkit tk = Toolkit.getDefaultToolkit();  
		xSize = ((int) tk.getScreenSize().getWidth());  
		ySize = ((int) tk.getScreenSize().getHeight());  
		setBounds(0,0,xSize,ySize);  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static int getXSize(){
		return xSize;
	}
	public static int getYSize(){
		return ySize;
	}
}

