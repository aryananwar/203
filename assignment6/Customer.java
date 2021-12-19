
public class Customer {
	private int age;
	private String name;
	
	public Customer(String n, int a)
	{
		age = a;
		name =n;
	}
	
	public Customer(Customer c)
	{
		Customer copy = new Customer(c.getName(), c.getAge());
		this.setAge(copy.getAge());
		this.setName(copy.getName());
	}
	
	public String toString()
	{
		return (this.name + " " + this.age);
	}
	
	public void setAge(int a)
	{
		this.age = a;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setName(String n)
	{
		this.name = n;
	}
	public String getName()
	{
		return this.name;
	}
	
}
