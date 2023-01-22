package ranbox;

import javax.swing.JFrame;
import java.awt.Color;

public class Ranbox extends JFrame implements Runnable {
	Thread ranThread;
	private final int FPS_SET = 120;
	RanPanel ranPanel;
	int frames = 0;
	long lastCheck = 0;

	public Ranbox() {
		setSize(600, 600);
		setTitle("ranbox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ranPanel = new RanPanel();
		add(ranPanel);
		setVisible(true);
		startLoop();
	}

	public void startLoop() {
		ranThread = new Thread(this);
		ranThread.start();
	}

	@Override
	public void run() {
		long now = System.nanoTime();
		double timePerFrame = 1000000000.0 / FPS_SET;
		long lastFrame = System.nanoTime();

		while (true) {
			now = System.nanoTime();
			if (now - lastFrame >= timePerFrame) {
				ranPanel.repaint();
				lastFrame = now;
			}

		}

	}
}
