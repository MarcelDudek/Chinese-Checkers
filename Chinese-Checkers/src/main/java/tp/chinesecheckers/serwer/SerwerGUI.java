package tp.chinesecheckers.serwer;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import tp.chinesecheckers.Zawodnik;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;

public class SerwerGUI {

  private JFrame frmChineseCheckersSerwer;
  private JTextField textField_port;
  private JComboBox comboBox_iloscGraczy;
  private JButton btnWylaczSerwer;
  private JButton btnUzupelnijBotami;

  //Serwer zmienne
  Serwer serwer = null;
  Thread thr = null;
  private JTextPane lista_graczy;
  private JButton btnUruchomSerwer;
  
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
    
    btnUruchomSerwer = new JButton("Uruchom serwer");
    btnUruchomSerwer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        int port = 0;
        try {
          port = Integer.parseInt(textField_port.getText());
        } catch(NumberFormatException ex) {
          return;
        }
        
        btnUruchomSerwer.setEnabled(false);
        comboBox_iloscGraczy.setEnabled(false);
        textField_port.setEnabled(false);
        btnWylaczSerwer.setEnabled(true);
        btnUzupelnijBotami.setEnabled(true);
        
        serwer = new Serwer(port, Integer.parseInt(comboBox_iloscGraczy.getSelectedItem().toString()));
        thr = new Thread(serwer);
        thr.start();
      }
    });
    btnUruchomSerwer.setBounds(250, 41, 153, 34);
    frmChineseCheckersSerwer.getContentPane().add(btnUruchomSerwer);
    
    comboBox_iloscGraczy = new JComboBox();
    comboBox_iloscGraczy.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "6"}));
    comboBox_iloscGraczy.setMaximumRowCount(4);
    comboBox_iloscGraczy.setBounds(10, 47, 96, 22);
    frmChineseCheckersSerwer.getContentPane().add(comboBox_iloscGraczy);
    
    btnUzupelnijBotami = new JButton("Uzupe\u0142nij botami");
    btnUzupelnijBotami.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        if(serwer != null) {
          serwer.uzupelnijGreBotami();
        }
      }
    });
    btnUzupelnijBotami.setEnabled(false);
    btnUzupelnijBotami.setBounds(250, 161, 153, 22);
    frmChineseCheckersSerwer.getContentPane().add(btnUzupelnijBotami);
    
    btnWylaczSerwer = new JButton("Wy\u0142\u0105cz serwer");
    btnWylaczSerwer.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        serwer.zamknijSerwer();
        serwer = null;
        
        btnUruchomSerwer.setEnabled(true);
        comboBox_iloscGraczy.setEnabled(true);
        textField_port.setEnabled(true);
        btnWylaczSerwer.setEnabled(false);
        btnUzupelnijBotami.setEnabled(false);
      }
    });
    btnWylaczSerwer.setEnabled(false);
    btnWylaczSerwer.setBounds(250, 79, 153, 34);
    frmChineseCheckersSerwer.getContentPane().add(btnWylaczSerwer);
    
    JLabel lblPodczeniGracze = new JLabel("Pod\u0142\u0105czeni gracze");
    lblPodczeniGracze.setBounds(10, 93, 167, 19);
    frmChineseCheckersSerwer.getContentPane().add(lblPodczeniGracze);
    
    lista_graczy = new JTextPane();
    lista_graczy.setEditable(false);
    lista_graczy.setBounds(10, 123, 220, 129);
    frmChineseCheckersSerwer.getContentPane().add(lista_graczy);
    
    AkutalizatorListyGraczy aktualizator = new AkutalizatorListyGraczy(this);
    Thread th = new Thread(aktualizator);
    th.start();
  }
  public JComboBox getComboBox_iloscGraczy() {
    return comboBox_iloscGraczy;
  }
  public JButton getBtnWylaczSerwer() {
    return btnWylaczSerwer;
  }
  public JButton getBtnUzupelnijBotami() {
    return btnUzupelnijBotami;
  }
  public JTextPane getLista_graczy() {
    return lista_graczy;
  }
  
  public void aktualizujListeGraczy() {
    lista_graczy.setText("");
    if(serwer != null) {
      List<String> lista = serwer.podajListePolaczen();
      String tekst = "";
      for(String nazwa: lista) {
        tekst += nazwa + "\n";
      }
      lista_graczy.setText(tekst);
    }
  }
  public JButton getBtnUruchomSerwer() {
    return btnUruchomSerwer;
  }
}

class AkutalizatorListyGraczy implements Runnable {

  private SerwerGUI gui;
  
  public AkutalizatorListyGraczy(SerwerGUI gui){
    this.gui = gui;
  }
  
  @Override
  public void run() {
    while(true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      gui.aktualizujListeGraczy();
    }
  }
  
}
