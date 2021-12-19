import enums.SIZE;
import enums.TYPE;

public class Smoothie extends Beverage {
	private int fruitCount;
	private boolean powder;
	private final double addProtein = 1.50;
	private final double addFruit = 0.50;
	
	public Smoothie(String n, SIZE s, int f, boolean p) {
		super(n, TYPE.SMOOTHIE, s);
		this.fruitCount = f;
		this.powder = p;
		
	}

	@Override 
	public String toString()
	{
		return (this.getBevName() + " " + this.getSize() 
				+ " " + this.powder + " " + this.fruitCount 
				+ this.calcPrice());
	}

	public boolean equals(Smoothie s)
	{
		if (super.equals(s) == true && this.fruitCount == s.fruitCount && this.powder == s.powder)
			return true;
		return false;
	}
	@Override
	public double calcPrice() {
		double total = super.BASE;
		if (super.getSize().equals(SIZE.MEDIUM))
			total += (super.SIZE_PRICE);
		if (super.getSize().equals(SIZE.LARGE))
			total += (2 * super.SIZE_PRICE);
		total += (this.fruitCount * addFruit);
		if(this.powder == true)
			total += addProtein;
		return total;	
	}
	public void setNumOfFruits(int a)
	{
		this.fruitCount = a;
	}
	public int getNumOfFruits()
	{
		return this.fruitCount;
	}

	public boolean getAddProtien() {
		return powder;
	}
	
	
}