package assignment4;

public class ManagementCompany {

	//declaring fields
	private final int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private Property properties[];
	private String taxID;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	
	//constructor, sets all values to their default values
	public ManagementCompany()
	{
	      mgmFeePer = 0;

	        name = taxID = "";

	        properties = new Property[MAX_PROPERTY];

	        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//overloaded constructor, takes name, taxID, and mgmFee paramaters
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY];
        plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	
	//overloaded constructor, takes name, taxID, mgmFee, x, y, width, and depth paramaters
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(x, y, width, depth);
	}
	
	//copy constructor for ManagementCompany, deep copies all fields of otherCompany onto whatever ManagementCompany object is called onto
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.name = otherCompany.getName();
		this.taxID = otherCompany.getTaxID();
		this.mgmFeePer = otherCompany.getMgmFeePer();
		this.plot = new Plot(otherCompany.getPlot());
		for (int i =0; i< MAX_PROPERTY; i++)
		{
			if (otherCompany.properties[i] != null)
				this.properties[i] = otherCompany.properties[i];
		}
		
	}
	
	//adds a property object onto properties array
	public int addProperty(Property property)
	{
		if(property == null)
			return -2;
		
		if  ( !(plot.encompasses(property.getPlot()) ))
			return -3;
		
		for (int i =0; i <MAX_PROPERTY; i++)
		{
			if (properties[i] != null) 
				if (property.getPlot().overlaps(properties[i].getPlot()))
					return -4;
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}
	
	//creates new property object and adds it onto properties array
	public int addProperty(String name, String city, double rent, String owner)
	{
		Property property = new Property(name, city, rent, owner);
		
		if(property == null)
			return -2;
		if ( plot.encompasses(property.getPlot()) ) 
			return -3;
		for (int i =0; i <MAX_PROPERTY; i++)
		{
			if (plot.overlaps(properties[i].getPlot()))
				return -4;
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}
	
	//creates a new property object as well as a plot object related to property object. adds that object to properties array
	public int addProperty(String name,String city,double rent,String owner,int x,int y,int width,int depth)
	{
		Property property = new Property(name, city, rent, owner, x, y, width, depth);
		
		if(property == null)
			return -2;
		if  ( !plot.encompasses(property.getPlot() ))
			return -3;
		
		for (int i =0; i <MAX_PROPERTY; i++)
		{
			if (plot.overlaps(properties[i].getPlot()))
				return -4;
			if (properties[i] == null)
			{
				properties[i] = property;
				return i;
			}
		}
		return -1;
	}
	

	//looks thorugh all indices in properties, returns the max rent amount
	public double maxRentProp()
	{
		double max = properties[0].getRentAmount();
		for (int i = 0; i <MAX_PROPERTY; i ++)
		{
			if (properties[i] != null)
				if (max < properties[i].getRentAmount())
					max = properties[i].getRentAmount();
		}
		return max;
	}
	
	//adds all rent amounts of objects in properties list and returns that value
	public double totalRent()
	{
		double total =0;
		for (int i =0; i <MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
				total += properties[i].getRentAmount();
		}
		return total;
	}
	
	//displays information about a property at any indice i
	public String displayPropertyAtIndex(int i)
	{
		return( "Property Name: " + properties[i].getPropertyName() + 
				"\n Located In: " + properties[i].getCity() + "\n Belonging To: " 
				+ properties[i].getOwner() + "\n Rent Amount: " + properties[i].getRentAmount() 
				+ "\n MGM FEE: " + mgmFeePer*this.totalRent());
	}
	
	//displays all information about every Property in properties array
	public String toString()
	{
		String ret = "";
		for (int i =0; i<MAX_PROPERTY; i++)
		{
			if (properties[i] != null)
				ret +=( " List of the properties for " + name + ", taxID: " + taxID +
						"\n Property Name: " + properties[i].getPropertyName() + "\n Located In: " 
						+ properties[i].getCity() + "\n Belonging To: " + properties[i].getOwner() + "\n Rent Amount: " 
						+ properties[i].getRentAmount() + "\n MGM FEE : " + (mgmFeePer/100)*this.totalRent() + "\n");
		}
		return ret;
	}
	
	//accessors
	
	//returns plot value
	public Plot getPlot()
	{
		return plot;
	}
	
	//returns name value
	public String getName()
	{
		return name;
	}
	
	//returns taxID value
	public String getTaxID()
	{
		return taxID;
	}

	private double getMgmFeePer() {
		return mgmFeePer;
	}
	//returns max property
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
}
