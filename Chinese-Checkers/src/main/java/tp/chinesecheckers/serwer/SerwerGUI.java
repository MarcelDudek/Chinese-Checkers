package tp.chinesecheckers.serwer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SerwerGUI {

  private JFrame frmChineseCheckersSerwer;
  private JTextField textField_port;
  private JTextField textField_iloscGraczy;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          SerwerGUI window = new SerwerGUI();
          window.frmChineseCheckersSerwer.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public SerwerGUI() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmChineseCheckersSerwer = new JFrame();
    frmChineseCheckersSerwer.setTitle("Chinese Checkers Serwer");
    frmChineseCheckersSerwer.setResizable(false);
    frmChineseCheckersSerwer.setBounds(100, 100, 450, 300);
    frmChineseCheckersSerwer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmChineseCheckersSerwer.getContentPane().setLayout(null);
    
    JLabel lblIloGraczy = new JLabel("Ilo\u015B\u0107 graczy");
    lblIloGraczy.setBounds(10, 11, 96, 25);
    frmChineseCheckersSerwer.getContentPane().add(lblIloGraczy);
    
    JLabel lblPort = new JLabel("Port");
    lblPort.setBounds(122, 16, 49, 14);
    frmChineseCheckersSerwer.getContentPane().add(lblPort);
    
    textField_port = new JTextField();
    textField_port.setBounds(122, 48, 96, 20);
    frmChineseCheckersSerwer.getContentPane().add(textField_port);
    textField_port.setColumns(10);
    
    JButton btnUruchomSerwer = new JButton("Uruchom serwer");
    btnUruchomSerwer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Serwer serwer = new Serwer(Integer.parseInt(textField_port.getText()), Integer.parseInt(textField_iloscGraczy.getText()));
        Thread thr = new Thread(serwer);
        thr.start();
      }
    });
    btnUruchomSerwer.setBounds(274, 47, 89, 23);
    frmChineseCheckersSerwer.getContentPane().add(btnUruchomSerwer);
    
    textField_iloscGraczy = new JTextField();
    textField_iloscGraczy.setColumns(10);
    textField_iloscGraczy.setBounds(10, 47, 96, 20);
    frmChineseCheckersSerwer.getContentPane().add(textField_iloscGraczy);
  }
}
