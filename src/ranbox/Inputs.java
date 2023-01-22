package ranbox;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Inputs implements MouseListener {
	private RanPanel ranPanel;

	public Inputs(RanPanel ranPanel) {
		this.ranPanel = ranPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ranPanel.spawnRect(e.getX(), e.getY());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
