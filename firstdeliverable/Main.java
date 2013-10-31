package firstdeliverable;

import java.awt.Toolkit;

import javax.swing.*;

public class Main{
	public static void main(String[] args){ 
		Panel panel = new Panel();
		SampleFrame frame = new SampleFrame();
		SampleFrame.addPanel(panel);
	}
}