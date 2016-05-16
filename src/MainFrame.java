
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
 
   public MainFrame(){ 

      JPanel jpanel = new JPanel();
      jpanel.setLayout(new GridLayout(1,2));
      //bilder
      ImageIcon Cars = new ImageIcon("img/car.png");
      ImageIcon MotorCycle = new ImageIcon("img/motorcycle.png");     
      //sätter bilder som knappar
      JButton CarsButton = new JButton(Cars);
      JButton MotorCycleButton = new JButton(MotorCycle);
      //lägger de i jpanel
      jpanel.add(CarsButton);
      jpanel.add(MotorCycleButton);
      //skapar listener funktioner
      CarsButton.addActionListener(new carListener());
      MotorCycleButton.addActionListener(new motorCycleListener());      
      //skapar namepanel till fordon med jlabel, fixar font och sätter de i namepanel.
      JPanel namePanel = new JPanel();
      namePanel.setLayout(new GridLayout(1,2));
      JLabel carLabel = new JLabel("Bilar");
      JLabel MCLabel = new JLabel("MotorCyklar");   
      

      carLabel.setHorizontalAlignment(JLabel.CENTER);
      carLabel.setFont(carLabel.getFont().deriveFont(18.0f));      
      
      MCLabel.setHorizontalAlignment(JLabel.CENTER);
      MCLabel.setFont(MCLabel.getFont().deriveFont(18.0f));      
      
      
      namePanel.add(carLabel);
      namePanel.add(MCLabel);

     
   
      //Layout
      JPanel panel = new JPanel(new BorderLayout());
      panel.add(jpanel, BorderLayout.NORTH);
      panel.add(namePanel, BorderLayout.CENTER);
      getContentPane().add(panel);
   }
   
   public class carListener implements ActionListener {
	      
public void actionPerformed(ActionEvent e){
  TabbedPane lol = new TabbedPane();
	    	  
	    	  lol.tabbedPane.setSelectedIndex(0);
	    	  lol.setVisible(true);
	    	  lol.setLocationRelativeTo(null);

	      }
	   }
	   
	  public class motorCycleListener implements ActionListener {
	      
	      public void actionPerformed(ActionEvent e){
	    	  
	    	  TabbedPane lol = new TabbedPane();
	    	  
	    	  lol.tabbedPane.setSelectedIndex(1);
	    	  lol.setVisible(true);
	    	  lol.setLocationRelativeTo(null);

	      }
	   }
   
}