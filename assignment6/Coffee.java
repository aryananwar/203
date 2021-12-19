import enums.SIZE;
import enums.TYPE;

public class Coffee extends Beverage {
	private boolean containsShot;
	private boolean containsSyrup;
	private final double EXTRA = 0.5;
	
	public Coffee(String n, SIZE s, boolean shot, boolean syrup) {
		super(n, TYPE.COFFEE, s);
		this.containsShot = shot;
		this.containsSyrup = syrup;
	}

	@Override
	public double calcPrice() {
		double total = super.BASE;
		if (super.getSize().equals(SIZE.MEDIUM))
			total += (super.SIZE_PRICE);
		if (super.getSize().equals(SIZE.LARGE))
			total += (2 * super.SIZE_PRICE);
		if (this.containsShot == true)
			total +=EXTRA;
		if (this.containsSyrup == true)
			total +=EXTRA;
		
		return total;	
	}
	
	@Override
	public String toString()
	{
		return (super.getBevName() + " " + super.getSize() + " " 
				+ super.getType() + " " + this.containsShot + " " 
				+ this.containsSyrup + " " + this.calcPrice());
	}
	
	
	public boolean equals(Coffee c)
	{
		if (super.equals(c) == true && 
				this.containsShot == c.containsShot && 
				this.containsSyrup == c.containsSyrup &&
				this.calcPrice() == c.calcPrice())
			return true;
		return false;
	}
	
	public boolean getExtraSyrup()
	{
		return this.containsSyrup;
	}
	
	public void setExtraSyrup(boolean b)
	{
		containsSyrup = b;
	}
	
	public boolean getExtraShot()
	{
		return this.containsShot;
	}
	
	public void setExtraShot(boolean b)
	{
		containsShot = b;
	}

	
}
