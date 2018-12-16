package tp.chinesecheckers.klient;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RamkaPlanszy extends JFrame {

	private static final long serialVersionUID = 1L;

	public RamkaPlanszy() {
		super("Program obrazkowy");

		JPanel plansza = new Plansza();

		add(plansza);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
