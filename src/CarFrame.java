import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;




public class CarFrame extends JFrame {

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
				readToFile();
				break;
				
			}
			
		}


	}
	private JTextField brandTextField;
	private JTextField prodYearTextField;
	private JTextField priceTextField;
	private JTextField regNrTextField;
	private JTextField fuelTypeTextField;
	private JTextField sizeTextField;
	public JList<String> carList;
	private Container contentPane;
	private FordonManager cars;
	private int current;
	
	
	public CarFrame()
	{


		intiateInstanceVariables();
		cofigureFrame();
		addComponents();
	}







	public void change()
	{
		String brand = this.brandTextField.getText();
		String prodYear = this.prodYearTextField.getText();
		String price = this.priceTextField.getText();
		String regNr = this.regNrTextField.getText();
		String fuelType = this.fuelTypeTextField.getText();
		String size = this.sizeTextField.getText();
		
		this.cars.ChangeCarBrandAt(this.current, brand);
		this.cars.ChangeCarProdYear(this.current,prodYear);
		this.cars.ChangeCarPriceAt(this.current, price);
		this.cars.ChangeCarRegNrAt(this.current, regNr);
		this.cars.ChangeCarfuelTypeAt(this.current, fuelType);
		this.cars.ChangeCarSizeAt(this.current, size);
		

		
		this.brandTextField.setText(brand);
		this.prodYearTextField.setText(prodYear);
		this.priceTextField.setText(price);
		this.regNrTextField.setText(regNr);
		this.fuelTypeTextField.setText(fuelType);
		this.sizeTextField.setText(size);
		
		this.carList.setListData(this.cars.getAllCarsAsStrings());
		
	}



	public void remove()
	{
		  int pos = carList.getSelectedIndex();
          cars.removeCarAt(pos);
          carList.setListData(cars.getAllCarsAsStrings());
		
	}



	public void showPrevCar()
	{
		this.current--;
		if (this.current == -1)
		{
			this.current = this.cars.getNrOfCars()-1;
	
		}

		this.brandTextField.setText(this.cars.carBrand(this.current));
		this.prodYearTextField.setText(String.valueOf(this.cars.carProdYear(this.current)));
		this.priceTextField.setText(String.valueOf(this.cars.carPrice(this.current)));
		this.regNrTextField.setText(this.cars.carRegNr(this.current));
		this.fuelTypeTextField.setText(this.cars.fuelType(this.current));
		this.sizeTextField.setText(this.cars.carSize(this.current));
		this.carList.setSelectedIndex(this.current);
	}

	public void showNextCar()
	{
		this.current = (this.current+1)%this.cars.getNrOfCars();
		this.brandTextField.setText(this.cars.carBrand(this.current));
		this.prodYearTextField.setText(String.valueOf(this.cars.carProdYear(this.current)));
		this.priceTextField.setText(String.valueOf(this.cars.carPrice(this.current)));
		this.regNrTextField.setText(this.cars.carRegNr(this.current));
		this.fuelTypeTextField.setText(this.cars.fuelType(this.current));
		this.sizeTextField.setText(this.cars.carSize(this.current));

		// extra
		this.carList.setSelectedIndex(this.current);
		
	}

	public void addCar()
	{
		String brand = this.brandTextField.getText();
		String prodYear = this.prodYearTextField.getText();
		String price = this.priceTextField.getText();
		String regNr = this.regNrTextField.getText();
		String fuelType = this.fuelTypeTextField.getText();
		String size = this.sizeTextField.getText();
		//kontrollera att det finns text för alla string variablerna
		
		

		this.cars.addCars(brand, prodYear,price, regNr, fuelType, size);
		this.current = this.cars.getNrOfCars()-1;
		clearTextFields();
		this.carList.setListData(this.cars.getAllCarsAsStrings());
	}

	private void clearTextFields()
	{
		this.brandTextField.setText("");
		this.prodYearTextField.setText("");
		this.priceTextField.setText("");
		this.regNrTextField.setText("");
		this.fuelTypeTextField.setText("");
		this.sizeTextField.setText("");
	}



	private void saveToFile(){
        JFileChooser fileChooser = new JFileChooser("C:/temp/");
        int result = fileChooser.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try {
                        this.cars.saveOnTextFile(file.getAbsolutePath());       
                }
                catch (FileNotFoundException e) {
                        JOptionPane.showMessageDialog(this, "Kan inte läsa filen");
                }
        }
       
}

    private void readToFile(){
    	

        JFileChooser fileChooser = new JFileChooser("C:/temp/");
        int result = fileChooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                try
				{
					this.cars.readFromTextFile(file.getAbsolutePath());
				} catch (FileNotFoundException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
					
				

        }
		this.carList.setListData(this.cars.getAllCarsAsStrings());
		if(this.cars.getNrOfCars() > 0){
	        this.current = 0;
	        this.carList.setSelectedIndex(this.current);
	        //Visa aktuell persons uppgifter i textfälten
	}

       
}


	

	private void addComponents()
	{
		JPanel carPanel = new JPanel();
		carPanel.setLayout(null);

		carPanel.setBorder(BorderFactory.createTitledBorder("Bil Information"));
		carPanel.add(this.brandTextField);
		carPanel.add(this.prodYearTextField);
		carPanel.add(this.priceTextField);
		carPanel.add(this.regNrTextField);
		carPanel.add(this.fuelTypeTextField);
		carPanel.add(this.sizeTextField);
		
		JPanel aPanel = buildButtonPanel();
		carPanel.add(aPanel);
		
		this.contentPane.add(carPanel);
		this.contentPane.add(this.carList);
		
	}

	private JPanel buildButtonPanel()
	{
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,3,10,10)); // 2 rader ,3 kolumner  10 avstånd melln rutorna.
		buttonPanel.setBounds(20,500,260,100);
		String[] buttonText = {"Lägg till", "<<", ">>", "Rensa", "Ändra", "Ta Bort", "Spara","Läsa"};
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
		
		this.fuelTypeTextField = new JTextField();
		this.fuelTypeTextField.setBounds(20,350,260,50);
		this.fuelTypeTextField.setBorder(BorderFactory.createTitledBorder("FuelType"));
		
		this.sizeTextField= new JTextField();
		this.sizeTextField.setBounds(20,430,260,50);
		this.sizeTextField.setBorder(BorderFactory.createTitledBorder("Car Size"));
		
		
		this.carList = new JList<>();
		this.carList.setBorder(BorderFactory.createTitledBorder("Bilar"));
		
		this.contentPane = this.getContentPane();
		// Set Layout
		this.contentPane.setLayout(new GridLayout(1,2)); //1 rad och 2 kolumner
		
		this.current = -1;
		this.cars = new FordonManager();
		this.pack();
		
	}
		    
		 
	


}
