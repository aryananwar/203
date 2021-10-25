package assignment4;

public class Property {

	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	
	public Property() {
		
		propertyName = "";
		city = "";
		rentAmount = 0;
		owner = "";
		plot = new Plot();
	}
	public Property(String p, String c, double r, String o)
	{
		plot = new Plot();
		propertyName = p;
		city = c;
		rentAmount = r;
		owner = o;
	}
	public Property(String p, String c, double r, String o, int x, int y, int width, int depth)
	{ 
		
		propertyName = p;
		city = c;
		rentAmount = r;
		owner = o;
		plot = new Plot(x,y,width,depth);
	}
	
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		plot = new Plot (p.plot.getX(), p.plot.getY(), p.plot.getWidth(), p.plot.getDepth());
	}
	
	public String getCity()
	{
		return this.city;
	}
	
	public String getOwner()
	{
		return this.owner;
	}
	
	public String getPropertyName()
	{
		return this.propertyName;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot.setX(x);
		plot.setY(y);
		plot.setWidth(width);
		plot.setDepth(depth);
		return plot;
	}
	public Plot getPlot() 
	{ 
		return plot;
	}
	
	public String toString()
	{
		return ("Property Name: " + this.propertyName + "\n Located in " + "\n Belonging to " + this.owner + "\n Rent Amount: " + this.rentAmount);
	}
	
	
	
	
}
