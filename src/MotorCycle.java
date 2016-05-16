
public class MotorCycle extends Fordon {
	private int cylinderSize;

	public MotorCycle() {
		this.cylinderSize = 0;

	}
	
	public MotorCycle(String brand,int prodYear, int price,String regNr,int cylinderSize)
	{
		super(brand,prodYear,price,regNr);
		this.cylinderSize = cylinderSize;
	}
	

	public int getCylinderSize()
	{
		return cylinderSize;
	}

	public int setCylinderSize(int cylinderSize)
	{
		return this.cylinderSize = cylinderSize;
	}

	@Override
	public String toStringSpec()
	{
		return Integer.toString(this.cylinderSize);
	}

}
