package firstdeliverable;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SampleFrame{
	private static int xSize;
	private static int ySize;
	static JFrame frame;
	
	public SampleFrame(){
		frame = new JFrame();
		Toolkit tk = Toolkit.getDefaultToolkit();  
		xSize = ((int) tk.getScreenSize().getWidth());  
		ySize = ((int) tk.getScreenSize().getHeight());  
		frame.setBounds(0,0,xSize,ySize);  
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static int getXSize(){
		return xSize;
	}
	public static int getYSize(){
		return ySize;
	}
	public static void addPanel(JPanel panel){
		frame.add(panel);
		frame.pack();
		frame.validate();
	}
	public static void removePanel(JPanel panel){
		frame.remove(panel);
		frame.repaint();
	}
	public static void removeAll(){
		frame.getContentPane().removeAll();
		frame.repaint();
	}
	public static void repaint(){
		frame.invalidate();
		frame.repaint();
		frame.revalidate();
	}
	public static MapPanel start(Map map){
		frame.getContentPane().removeAll();
		MapPanel mapPanel = new MapPanel(map);
		frame.add(mapPanel);
		frame.revalidate();
		frame.repaint();
		return mapPanel;
	}
}
