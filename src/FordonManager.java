import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;


public class FordonManager {
	private ArrayList<Cars> Car;
	private ArrayList<MotorCycle> MotorCycle;


public FordonManager()
{
	this.Car = new ArrayList<Cars>();
	this.MotorCycle = new ArrayList<MotorCycle>();
}

//CarS
public void addCars(String brand, String prodYear, String price,String regNr,String fuelType, String size)
{
	this.Car.add(new Cars(brand,Integer.parseInt(prodYear),Integer.parseInt(price),regNr,fuelType,size));
}

public String carBrand(int pos)
{
	String result = null;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getBrand();
	}
	return result;
}

//GETTERS
public String fuelType(int pos)
{
	String result = null;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getFuelType();
	}
	return result;
}

public int carPrice(int pos)
{
	int result = 0;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getPrice();
	}
	return result;
}

public int carProdYear(int pos)
{
	int result = 0;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getProdYear();
	}
	return result;
}

public String carRegNr(int pos)
{
	String result = "";
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getRegNr();
	}
	return result;
}

public String carSize(int pos)
{
	String result = "";
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).getSize();
	}
	return result;
}

//Setters

public String ChangeCarBrandAt(int pos, String brand)
{
	String result = null;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setBrand(brand);;
	}
	return result;
}

public String ChangeCarfuelTypeAt(int pos, String fuelType)
{
	String result = null;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setFuelType(fuelType);
	}
	return result;
}

public int ChangeCarPriceAt(int pos, String price)
{
	int result = 0;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setPrice(Integer.parseInt(price));
	}
	return result;
}

public int ChangeCarProdYear(int pos,String prodYear)
{
	int result = 0;
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setProdYear(Integer.parseInt(prodYear));
	}
	return result;
}

public String ChangeCarRegNrAt(int pos, String regNr)
{
	String result = "";
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setRegNr(regNr);
	}
	return result;
}

public String ChangeCarSizeAt(int pos, String Size)
{
	String result = "";
	if (pos < this.Car.size())
	{
		result = this.Car.get(pos).setSize(Size);
	}
	return result;
}

public boolean removeCarAt(int pos)
{
	return this.Car.remove(pos) != null;
}

public String getCarAsString(int pos)
{
	String result = null;
	if (pos > -1 && pos < this.Car.size())
	{
		result = this.Car.get(pos).toString();
	}
	return result;
}

public String[] getAllCarsAsStrings()
{
	String[] persAsStrings = new String[this.Car.size()];
	for (int i=0; i<this.Car.size(); i++)
	{
		persAsStrings[i] = this.Car.get(i).toString();
	}
	return persAsStrings;
}

public int getNrOfCars()
{
	return this.Car.size();
}

public void saveOnTextFile(String filename) throws FileNotFoundException 
{
	PrintWriter output = null;
	output = new PrintWriter(filename);
    for(int j = 0; j<Car.size(); j++)
    {
		Cars tempObject = Car.get(j);
	      output.println(tempObject.getBrand());
	      output.println(tempObject.getProdYear());
	      output.println(tempObject.getPrice());
	      output.println(tempObject.getRegNr());
	      output.println(tempObject.getFuelType());
	      output.println(tempObject.getSize());
    }
	output.close();
	
}

public void readFromTextFile(String filename) throws FileNotFoundException
{
	
	Scanner in = new Scanner(new File(filename));

	while (in.hasNextLine()) {
		Cars tempObject = new Cars();

		tempObject.setBrand(in.nextLine());
		tempObject.setProdYear(Integer.parseInt(in.nextLine()));
		tempObject.setPrice(Integer.parseInt(in.nextLine()));
		tempObject.setRegNr(in.nextLine());
		tempObject.setFuelType(in.nextLine());
		tempObject.setSize(in.nextLine());
		
		Car.add(tempObject);

		}
	
	in.close();
}



//MotorCycleS
public void addMotorCycle(String brand, String prodYear, String price,String regNr,String CylinderSize)
{
	this.MotorCycle.add(new MotorCycle(brand,Integer.parseInt(prodYear),Integer.parseInt(price),regNr,Integer.parseInt(CylinderSize)));
}

public String MotorCycleBrand(int pos)
{
	String result = null;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).getBrand();
	}
	return result;
}



public int MotorCyclePrice(int pos)
{
	int result = 0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).getPrice();
	}
	return result;
}

public int MotorCycleProdYear(int pos)
{
	int result = 0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).getProdYear();
	}
	return result;
}

public String MotorCycleRegNr(int pos)
{
	String result = "";
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).getRegNr();
	}
	return result;
}

public int MotorCycleCylinderSize(int pos)
{
	int result = 0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).getCylinderSize();
	}
	return result;
}


public boolean removeMotorCycleAt(int pos)
{
	return this.MotorCycle.remove(pos) != null;
}

public String getMotorCycleAsString(int pos)
{
	String result = null;
	if (pos > -1 && pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).toString();
	}
	return result;
}

public String[] getAllMotorCyclesAsStrings()
{
	String[] persAsStrings = new String[this.MotorCycle.size()];
	for (int i=0; i<this.MotorCycle.size(); i++)
	{
		persAsStrings[i] = this.MotorCycle.get(i).toString();
	}
	return persAsStrings;
}

public int getNrOfMotorCycles()
{
	return this.MotorCycle.size();
}

//SETTERS

public String ChangeMotorCycleBrandAt(int pos, String brand)
{
	String result = null;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).setBrand(brand);;
	}
	return result;
}

public int ChangeMotorCylinderSizeAt(int pos, String cylinderSize)
{
	int result = 0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).setCylinderSize(Integer.parseInt(cylinderSize));
	}
	return result;
}

public int ChangeMotorCyclePriceAt(int pos, String price)
{
	int result =0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).setPrice(Integer.parseInt(price));
	}
	return result;
}

public int ChangeMotorCycleProdYear(int pos,String prodYear)
{
	int result = 0;
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).setProdYear(Integer.parseInt(prodYear));;
	}
	return result;
}

public String ChangeMotorCycleRegNrAt(int pos, String regNr)
{
	String result = "";
	if (pos < this.MotorCycle.size())
	{
		result = this.MotorCycle.get(pos).setRegNr(regNr);
	}
	return result;
}



public void saveMcOnTextFile(String filename) throws FileNotFoundException 
{
	PrintWriter output = null;
	output = new PrintWriter(filename);
    for(int j = 0; j<MotorCycle.size(); j++)
    {
		MotorCycle tempObject = MotorCycle.get(j);
	     output.println(tempObject.getBrand());
	     output.println(tempObject.getProdYear());
	     output.println(tempObject.getPrice());
	     output.println(tempObject.getRegNr());
	     output.println(tempObject.getCylinderSize());
	     
    }
	output.close();
	
}

public void readMcFromTextFile(String filename) throws FileNotFoundException
{
	
	Scanner in = new Scanner(new File(filename));
	while (in.hasNextLine()) {
		
		MotorCycle tempObject = new MotorCycle();
		tempObject.setBrand(in.nextLine());
		tempObject.setProdYear(Integer.parseInt(in.nextLine()));
		tempObject.setPrice(Integer.parseInt(in.nextLine()));
		tempObject.setRegNr(in.nextLine());
		tempObject.setCylinderSize(Integer.parseInt(in.nextLine()));
		MotorCycle.add(tempObject);
		}
	
	in.close();
}
	


}