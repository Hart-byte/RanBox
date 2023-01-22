package ranbox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.ArrayList;

public class LightVersion extends JFrame {

	Panel panel;
	JButton start;
	boolean started = false, stopped = false;

	public LightVersion() {
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Light Version");
		setLocationRelativeTo(null);
		add(new Panel());
		setVisible(true);
	}

	class Panel extends JPanel {
		ArrayList<Box> boxes = new ArrayList<Box>();
		int directions[] = { -1, 1 };
		Random random;

		int dir1 = 1, dir2 = 1;

		Panel() {
			random = new Random();
			start = new JButton("start");
			start.setPreferredSize(new Dimension(100, 30));
			start.setFocusable(false);
			start.addActionListener(new Ears());
			spawnBox();
			add(start);
		}

		void spawnBox() {
			boxes.add(new Box(50, 100, 100));
			for (Box b : boxes) {
				b.x *= directions[random.nextInt(1)];
			}
		}

		void update() {

			for (Box b : boxes) {
				b.x += dir1;
				b.y += dir1;

				if (b.x > 400 || b.x < 0) {
					dir1 *= -1;
				}
				if (b.y > 400 || b.y < 0) {
					dir1 *= -1;
				}
			}

		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			for (Box b : boxes) {
				g.fillRect(b.x, b.y, b.size, b.size);
			}

			update();
			repaint();
		}
	}

	class Ears extends JButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton) e.getSource();
			if (started)
				started = false;
			else
				started = true;

			if (btn.getText().equals("start"))
				btn.setText("stop");
			else
				btn.setText("start");
		}
	}

	class Box {
		int size;
		int x, y;

		Box(int size, int x, int y) {
			this.size = size;
			this.x = x;
			this.y = y;
		}

		int getSize() {
			return size;
		}

		int getX() {
			return x;
		}

		int getY() {
			return y;
		}

	}

	public static void main(String[] args) {
		new LightVersion();
	}

}
