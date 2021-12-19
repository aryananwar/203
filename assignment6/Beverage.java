import enums.SIZE;
import enums.DAY;
import enums.TYPE;

public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	private DAY day;
	public final double BASE = 2.0;
	public final double SIZE_PRICE = 1.0;
	
	public Beverage(String n, TYPE t, SIZE s)
	{
		this.name = n;
		this.type = t;
		this.size = s;
	}
	
	abstract double calcPrice();
	
	@Override
	public String toString()
	{
		return(this.name + " " + this.size);
	}
	
	public boolean equals(Beverage b)
	{
		if (b.name.equals(this.name) && this.type.equals(b.type) && this.size.equals(b.size))
			return true;
		return false;
	}
	
	
	public String getBevName()
	{
		return this.name;
	}
	public void setBevName(String n)
	{
		this.name = n;
	}
	
	public TYPE getType()
	{
		return this.type;
	}
	public void setType(TYPE t)
	{
		this.type = t;
	}
	
	public SIZE getSize()
	{
		return this.size;
	}
	public void setSize(SIZE s)
	{
		this.size = s;
	}
	
	public double getBasePrice() {
		return BASE;
	}
	
	public DAY getDay()
	{
		return this.day;
	}
	
	public void setDay(DAY d)
	{
		day =d;
	}

}
