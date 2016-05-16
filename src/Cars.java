
public class Cars extends Fordon {
	private String fuelType;
	private String size;

	public Cars() {
		this.fuelType = "";
		this.size = "";
	}
	
	public Cars(String brand, int prodYear, int price,String regNr,String fuelType, String size)
	{
		super(brand,prodYear,price,regNr);
		this.fuelType = fuelType;
		this.size = size;
	}
	

	public String getFuelType()
	{
		return fuelType;
	}



	public String setFuelType(String fuelType)
	{
		return this.fuelType = fuelType;
	}



	public String getSize()
	{
		return size;
	}



	public String setSize(String size)
	{
		return this.size = size;
	}



	@Override
	public String toStringSpec()
	{
		return this.fuelType + "," + this.size;
	}

}
