import enums.DAY;
import enums.SIZE;
import enums.TYPE;

import java.util.ArrayList; 
import java.util.Random; 

public class Order {
	int orderNum;
	static int latestOrderNum = 0;
	
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> order = new ArrayList<Beverage>();
	

	public Order( int time, DAY d, Customer c) {

		orderDay =d;
		orderTime = time;
		customer = new Customer(c.getName(), c.getAge());
		latestOrderNum++;
		orderNum = latestOrderNum;
		
	}

	private int genRan()
	{
		Random r = new Random();
		return (r.nextInt(80000) + 10000);
	}
	
	//if beverage added is coffee
	public void addNewBeverage(String s, SIZE sz, boolean b, boolean c) {
		Coffee a = new Coffee(s, sz, b, c);
		order.add( a);
	}

	//if beverage added is alcohol
	public void addNewBeverage(String s, SIZE sz) {
		Alcohol a = new Alcohol(s, sz);
		order.add(a);
	}

	//if beverage added is smoothie
	public void addNewBeverage(String s, SIZE sz, int i, boolean c) {
		Smoothie a = new Smoothie(s,sz,i,c);
		order.add(a);
	}

	public Beverage getBeverage(int i) {
		return order.get(i);
	}

	public int getTotalItems() {
		return order.size();
	}

	public boolean isWeekend() {
		if (this.orderDay == DAY.SATURDAY || this.orderDay == DAY.SUNDAY)
			return true;
		return false;
	}

	public double calcOrderTotal() {
		double total =0.0;;
		for (int i =0; i <order.size(); i++)
		{
			total += order.get(i).calcPrice();
			if (this.isWeekend()== true && order.get(i).getType() == TYPE.ALCOHOL)
				total += 0.60;
		}
		return total;
	}

	public int findNumOfBeveType(TYPE t) {
		int count =0;
		for (int i =0; i <order.size(); i++)
		{
			if (order.get(i).getType() == t)
				count++;
		}
		return count;
	}
	
	@Override
	public String toString()
	{ 
		return(this.orderNum + " " + this.orderDay + " " 
				+ this.customer.getName() + " " 
				+ this.customer.getAge() + " " + order + " " + this.calcOrderTotal());
	}

	public int getOrderNo() {
		return orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public int getAge()
	{
		return customer.getAge();
	}

	public int getOrderTime() {
		return this.orderTime;
	}

	public DAY getOrderDay() {
		return this.orderDay;
	}
	

	
	
}