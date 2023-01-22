package ranbox;

import javax.swing.JFrame;
import java.awt.Color;

public class Window extends JFrame {

	public Window() {
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		add(new RanPanel());
		setVisible(true);
	}
}
