
public abstract class Fordon {
	private String brand;
	private int prodYear;
	private int price;
	private String regNr;
	public Fordon()
	{
		this.brand = "";
		this.prodYear = 0;
		this.price = 0;
		this.regNr = "";
	}
	
	public Fordon(String brand, int prodYear, int price, String regNr)
	{
		this.brand = brand;
		this.prodYear = prodYear;
		this.price = price;	
		this.regNr = regNr;
	}


	
	public String getBrand()
	{
		return brand;
	}




	public String setBrand(String brand)
	{
		return this.brand = brand;
	}




	public int getProdYear()
	{
		return prodYear;
	}




	public int setProdYear(int prodYear)
	{
		return this.prodYear = prodYear;
	}




	public int getPrice()
	{
		return price;
	}




	public int setPrice(int price)
	{
		return this.price = price;
	}
	
	
	public String getRegNr()
	{
		return regNr;
	}

	public String setRegNr(String regNr)
	{
		return this.regNr = regNr;
	}

	public abstract String toStringSpec();
	
	@Override
	public String toString()
	{
		return this.brand + "," + this.prodYear + "," + this.price + " kr" + "," + this.regNr + ","
				+ toStringSpec();
	}
	
	

}
