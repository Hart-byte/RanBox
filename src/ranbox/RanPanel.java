package ranbox;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

public class RanPanel extends JPanel {
	private Inputs inputs;
	private ArrayList<Rect> rects = new ArrayList<Rect>();
	private int xPos = 0, yPos = 0, speed;
	int[] dirs = { -1, 1 };
	int frames = 0;
	long lastCheck = 0;

	Random random;

	public RanPanel() {
		inputs = new Inputs(this);
		random = new Random();
		addMouseListener(inputs);
	}

	public void updatePos() {
		for (Rect r : rects)
			changePos(r);
	}

	public void changePos(Rect r) {

		r.y += r.yDir;
		r.x += r.xDir;

		if (r.x == (600 - r.width) || r.x == 0) {
			r.xDir *= -1; // reverse direction
			r.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}

		if (r.y == (600 - r.height) || r.y == 0) {
			r.yDir *= -1; // reverse direction
			r.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
		}
	}

	public void spawnRect(int x, int y) {
		int size = random.nextInt(60);
		float xDir = dirs[random.nextInt(2)];
		float yDir = dirs[random.nextInt(2)];
		System.out.println("XDir: " + xDir);
		System.out.println("Ydir: " + yDir);

		rects.add(new Rect(x, y, size, size, new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255))));
		rects.get(rects.size() - 1).setXYDir(xDir, yDir);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Rect r : rects) {
			g.setColor(r.color);
			g.fillRect((int) r.x, (int) r.y, r.width, r.height);
		}
		updatePos();

		frames++;
		if (System.currentTimeMillis() - lastCheck >= 1000) {
			lastCheck = System.currentTimeMillis();
			System.out.println("FPS: " + frames);
			frames = 0;
		}
	}

	class Rect {
		int x, y, width, height, speed;
		float xDir, yDir;
		Color color;

		Rect(int x, int y, int width, int height, Color color) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.color = color;
		}

		void setColor(Color color) {
			this.color = color;
		}

		void setXYDir(float xDir, float yDir) {
			this.xDir = xDir;
			this.yDir = yDir;
		}
	}
}
