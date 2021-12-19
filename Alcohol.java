import enums.SIZE;
import enums.DAY;
import enums.TYPE;

public class Alcohol extends Beverage{

	public boolean isWeekend;
	private final double ADDITIONAL = 0.60;
	
	public Alcohol(String n, SIZE s, boolean iW) {
		super(n, TYPE.ALCOHOL, s);
		isWeekend =iW;
	}
	public Alcohol(String n, SIZE s) {
		super(n, TYPE.ALCOHOL, s);
	}
	
	@Override
	public double calcPrice() {
		double total = super.BASE;
		if (super.getSize().equals(SIZE.MEDIUM))
			total += (super.SIZE_PRICE);
		if (super.getSize().equals(SIZE.LARGE))
			total += (2 * super.SIZE_PRICE);
		if (super.getDay() == DAY.SUNDAY || super.getDay() == DAY.SATURDAY)
			total += ADDITIONAL;
		
		return total;	
	}
	
	@Override
	public String toString()
	{
		return (super.getBevName() + " " + super.getSize() + " " 
				+ super.getType() + " " + this.isWeekend +  " " + this.calcPrice());
	}
	
	public boolean equals(Alcohol a)
	{
		if(super.equals(a) == true && this.isWeekend == a.isWeekend)
			return true;
		return false;
	}
	
}
