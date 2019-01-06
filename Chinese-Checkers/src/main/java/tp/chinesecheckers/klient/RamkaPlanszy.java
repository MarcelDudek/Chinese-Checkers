package tp.chinesecheckers.klient;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import com.sun.javafx.scene.paint.GradientUtils.Point;

public class RamkaPlanszy extends JFrame {

	private static final long serialVersionUID = 1L;

	Plansza plansza = new Plansza();
	 
	
	public RamkaPlanszy() {
		super("Program obrazkowy");

		plansza.ilu.doDziela();
		

		add(plansza);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

}
