import java.awt.*;
import javax.swing.*;

class TabbedPane extends JFrame
{
	public JTabbedPane tabbedPane;
	private JPanel	panel1;
	private	JPanel	panel2;


	public TabbedPane()
	{
		setTitle( "Fordons Firma" );
		setSize( 800, 800 );
		setBackground( Color.gray );

		JPanel topPanel = new JPanel();
		topPanel.setLayout( new BorderLayout() );
		getContentPane().add( topPanel );

		// Create the tab pages
		createCarsTab();
		createMotorCycleTab();

		// Create a tabbed pane
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab( "Bilar", panel1 );
		tabbedPane.addTab( "MotorCycklar", panel2 );
		
		topPanel.add( tabbedPane, BorderLayout.CENTER );

	}

	public void createCarsTab()
	{		CarFrame car = new CarFrame();
	;
		panel1 = new JPanel();
		panel1.setLayout( null );
		//hämtar car contentpane
		panel1.add(car.getContentPane());
		this.setVisible(true);
		
	

	}

	public void createMotorCycleTab()
	{
		panel2 = new JPanel();
		panel2.setLayout( new BorderLayout() );
		MotorCycleFrame motor = new MotorCycleFrame();
		//hämtar montorcykel contentpane
		panel2.add(motor.getContentPane());

	}

}