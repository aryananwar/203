import java.util.ArrayList;

import enums.DAY;
import enums.SIZE;

public class BevShop
{
	public final int MAX_ALCOHOL = 3;
	public final int MIN_AGE = 21;
	private final int MAX_FRUIT = 5;	
	
	
	private int currentAlcohol;
	private int time;
	private DAY day;
	private Customer customer;


	private ArrayList<Order> allOrders = new ArrayList<Order>();
	
	public boolean validTime(int t)
	{
		if (t >= 8 && t<= 23)
			return true;
		return false;
	}
	public boolean eligibleForMore()
	{
		if (this.currentAlcohol < 3)
			return true;
		return false;
	}
	
	public boolean validAge(int a)
	{
		if (a > MIN_AGE)
			return true;
		return false;
	}
	
	public void startNewOrder(int time, DAY day, String customerName, int customerAge)
	{
		customer = new Customer(customerName, customerAge);
		allOrders.add(new Order(time, day, customer));
		currentAlcohol = 0;
	}
	
	public void processCoffeeOrder( String bevName, SIZE size, boolean extraShot, boolean extraSyrup )
	{
		allOrders.get(allOrders.size() -1).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void  processAlcoholOrder( String bevName, SIZE size )
	{
		allOrders.get(allOrders.size()-1).addNewBeverage(bevName, size);
		currentAlcohol++;
	}
	
	public void processSmoothieOrder( String bevName, SIZE size, int numOfFruits, boolean addProtien)
	{
		allOrders.get(allOrders.size()-1).addNewBeverage(bevName, size, numOfFruits, addProtien);
	}
	
	public int findOrder(int orderNo)
	{
		for (int i =0; i < allOrders.size(); i ++)
		{
			if (allOrders.get(i).getOrderNo() == orderNo)
			{
				return i;
			}
		}
		return -1;
	}
	
	public double totalOrderPrice(int orderNo)
	{
		int k = findOrder(orderNo);
		return allOrders.get(k).calcOrderTotal();
	}
	
	public double totalMonthlySale()
	{
		double total = 0.0;
		for (int i =0; i <allOrders.size(); i ++)
		{
			total+=allOrders.get(i).calcOrderTotal();
		}
		return total;
	}
	
	public  void sortOrders()
	{
		for (int i = 0; i < allOrders.size(); i++) {
	   
			int pos = i;
	            for (int j = i; j < allOrders.size(); j++) {
	                if (allOrders.get(j).getOrderNo() < allOrders.get(pos).getOrderNo())
	                    pos = j;
	            }
	            Order min = allOrders.get(pos);
	            allOrders.set(pos, allOrders.get(i));
	            allOrders.set(i, min);
	        } 
	}
	
	@Override
	public String toString()
	{
		String a = "";
		double total = 0.0;
		for (int i =0; i < allOrders.size(); i++)
		{
			a+= allOrders.get(i).toString();
			total+=allOrders.get(i).calcOrderTotal();
			
		}
		a+= " " + total; 
		return a;
	}
	
	public Order getOrderAtIndex(int index)
	{
		return allOrders.get(index);
	}
	public Order getCurrentOrder() {
		return(allOrders.get(allOrders.size() -1 ));
	}
	public int getNumOfAlcoholDrink() {
		return currentAlcohol;
	}
	public int totalNumOfMonthlyOrders() {
		return allOrders.size() ;
	}
	public boolean isMaxFruit(int i) {
		return i > MAX_FRUIT;
	}
	
	
}