
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;



public class MotorCycleFrame extends JFrame {

	private class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String buttonText = e.getActionCommand();
			switch(buttonText)
			{
			case "Lägg till":
				addCar();
			break;
			case ">>":
				showNextCar();
				break;
			case "<<":
				showPrevCar();
				break;
			case "Rensa":
				clearTextFields();
				break;
			case "Ta Bort":
				remove();
				break;
			case "Ändra":
			change();
			break;
			case "Spara":
			saveToFile();
			break;
			case "Läsa":
				readFromFile();
				break;
			
				
			}
			
		}


	}
	private JTextField brandTextField;
	private JTextField prodYearTextField;
	private JTextField priceTextField;
	private JTextField regNrTextField;
	private JTextField cylinderSizeTextField;
	public JList <String> MotorCycleList;
	private Container contentPane;
	private FordonManager motorcycle;
	private int current;
	
	
	public MotorCycleFrame()
	{
		
		intiateInstanceVariables();
		cofigureFrame();
		addComponents();
		addMenu();
	}



	public void readFromFile()
	{
        JFileChooser fileChooser = new JFileChooser("C:/temp/");
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try
				{
					this.motorcycle.readMcFromTextFile(file.getAbsolutePath());
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				this.MotorCycleList.setListData(this.motorcycle.getAllMotorCyclesAsStrings());
				if(this.motorcycle.getNrOfCars() > 0){
				        this.current = 0;
				        this.MotorCycleList.setSelectedIndex(this.current);
				        //Visa aktuell persons uppgifter i textfälten
				}
        }
		
	}



	private void saveToFile(){
        JFileChooser fileChooser = new JFileChooser("C:/temp/");
        int result = fileChooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                        this.motorcycle.saveMcOnTextFile(file.getAbsolutePath());      
                }
                catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(this, "Kan inte läsa filen");
                }
        }
       
}



	public void change()
	{
		String brand = this.brandTextField.getText();
		String prodYear = this.prodYearTextField.getText();
		String price = this.priceTextField.getText();
		String regNr = this.regNrTextField.getText();
		String cylinderSize = this.cylinderSizeTextField.getText();
		
		this.motorcycle.ChangeMotorCycleBrandAt(this.current, brand);
		this.motorcycle.ChangeMotorCycleProdYear(this.current, prodYear);
		this.motorcycle.ChangeMotorCyclePriceAt(this.current, price);
		this.motorcycle.ChangeMotorCycleRegNrAt(this.current, regNr);
		this.motorcycle.ChangeMotorCylinderSizeAt(this.current, cylinderSize);
		
		

		
		this.brandTextField.setText(brand);
		this.prodYearTextField.setText(prodYear);
		this.priceTextField.setText(price);
		this.regNrTextField.setText(regNr);
		this.cylinderSizeTextField.setText(cylinderSize);
		
		this.MotorCycleList.setListData(this.motorcycle.getAllMotorCyclesAsStrings());
		
	}



	public void remove()
	{
		  int pos = MotorCycleList.getSelectedIndex();
          motorcycle.removeMotorCycleAt(pos);
          MotorCycleList.setListData(motorcycle.getAllMotorCyclesAsStrings());
		
	}



	public void showPrevCar()
	{
		this.current--;
		if (this.current == -1)
		{
			this.current = this.motorcycle.getNrOfMotorCycles()-1;
	
		}

		this.brandTextField.setText(this.motorcycle.MotorCycleBrand(this.current));
		this.prodYearTextField.setText(String.valueOf(this.motorcycle.MotorCycleProdYear(this.current)));
		this.priceTextField.setText(String.valueOf(this.motorcycle.MotorCyclePrice(this.current)));
		this.regNrTextField.setText(this.motorcycle.MotorCycleRegNr(this.current));
		this.cylinderSizeTextField.setText(String.valueOf(this.motorcycle.MotorCycleCylinderSize(this.current)));
		this.MotorCycleList.setSelectedIndex(this.current);
	}

	public void showNextCar()
	{
		this.current = (this.current+1)%this.motorcycle.getNrOfMotorCycles();
		this.brandTextField.setText(this.motorcycle.MotorCycleBrand(this.current));
		this.prodYearTextField.setText(String.valueOf(this.motorcycle.MotorCycleProdYear(this.current)));
		this.priceTextField.setText(String.valueOf(this.motorcycle.MotorCyclePrice(this.current)));
		this.regNrTextField.setText(this.motorcycle.MotorCycleRegNr(this.current));
		this.cylinderSizeTextField.setText(String.valueOf(this.motorcycle.MotorCycleCylinderSize(this.current)));
		// extra
		this.MotorCycleList.setSelectedIndex(this.current);
		
	}

	public void addCar()
	{
		String brand = this.brandTextField.getText();
		String prodYear = this.prodYearTextField.getText();
		String price = this.priceTextField.getText();
		String regNr = this.regNrTextField.getText();
		String CylinderSize = this.cylinderSizeTextField.getText();
		//kontrollera att det finns text för alla string variablerna

		this.motorcycle.addMotorCycle(brand, prodYear, price, regNr, CylinderSize);
		this.current = this.motorcycle.getNrOfMotorCycles()-1;
		clearTextFields();
		this.MotorCycleList.setListData(this.motorcycle.getAllMotorCyclesAsStrings());
	}

	private void clearTextFields()
	{
		this.brandTextField.setText("");
		this.prodYearTextField.setText("");
		this.priceTextField.setText("");
		this.regNrTextField.setText("");
		this.cylinderSizeTextField.setText("");
	}

	private void addMenu()
	{
		// TODO Auto-generated method stub
		
	}
	

	private void addComponents()
	{
		JPanel carPanel = new JPanel();
		carPanel.setLayout(null);

		carPanel.setBorder(BorderFactory.createTitledBorder("Motorcykel Information"));
		carPanel.add(this.brandTextField);
		carPanel.add(this.prodYearTextField);
		carPanel.add(this.priceTextField);
		carPanel.add(this.regNrTextField);
		carPanel.add(this.cylinderSizeTextField);
		
		JPanel aPanel = buildButtonPanel();
		carPanel.add(aPanel);
		
		this.contentPane.add(carPanel);
		this.contentPane.add(this.MotorCycleList);
		
	}

	private JPanel buildButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,3,10,10)); // 2 rader ,3 kolumner  10 avstånd melln rutorna.
		buttonPanel.setBounds(20,500,260,100);
		String[] buttonText = {"Lägg till", "<<", ">>", "Rensa", "Ändra", "Ta Bort", "Spara", "Läsa"};
		JButton button = null;
		ButtonListener buttList = new ButtonListener();
		for (int i = 0; i<buttonText.length; i++)
		{
			button = new JButton(buttonText[i]);
			button.addActionListener(buttList);
			buttonPanel.add(button);
			
		}
		return buttonPanel;
	}

	private void cofigureFrame()
	{

		this.setTitle("Title");
		this.setSize(800,800);
		this.setLocationRelativeTo(null); //centrerars på bildskärmen
		this.setResizable(false);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}

	private void intiateInstanceVariables()
	{
		
		this.brandTextField = new JTextField();
		this.brandTextField.setBounds(20,30,260,50);
		this.brandTextField.setBorder(BorderFactory.createTitledBorder("Brand"));
		
		this.prodYearTextField = new JTextField();
		this.prodYearTextField.setBounds(20,110,260,50);
		this.prodYearTextField.setBorder(BorderFactory.createTitledBorder("Production Year"));
		
		this.priceTextField = new JTextField();
		this.priceTextField.setBounds(20,190,260,50);
		this.priceTextField.setBorder(BorderFactory.createTitledBorder("Price"));
		
		this.regNrTextField = new JTextField();
		this.regNrTextField.setBounds(20,270,260,50);
		this.regNrTextField.setBorder(BorderFactory.createTitledBorder("regNR"));
		
		this.cylinderSizeTextField = new JTextField();
		this.cylinderSizeTextField.setBounds(20,350,260,50);
		this.cylinderSizeTextField.setBorder(BorderFactory.createTitledBorder("cylinderSize"));
				
		this.MotorCycleList = new JList<>();
		this.MotorCycleList.setBorder(BorderFactory.createTitledBorder("Motorcyklar"));
		
		this.contentPane = this.getContentPane();
		// Set Layout
		this.contentPane.setLayout(new GridLayout(1,2)); //1 rad och 2 kolumner
		
		this.current = -1;
		this.motorcycle = new FordonManager();
		   
		this.pack();
		
	}
		    

}
