package chinskie.warcaby;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ObrazRamka extends JFrame  {

	public ObrazRamka() {
		super("Program obrazkowy");

		JPanel Obraz = new Obrazek();
		add(Obraz);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
}
