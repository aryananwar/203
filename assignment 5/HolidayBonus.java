
public class HolidayBonus {
	
	public HolidayBonus()
	{
	}
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		double bonus[] = new double[data.length];
		for (int i =0; i < data.length; i++)
		{
			for (int j = 0; j < data[i].length; j++)
			{
				if (data[i][j] < 0)
				{
					continue;
				}
				if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j))
				{
					bonus[i]+=high;
					continue;
				}
				if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j))
				{
					bonus[i]+=low;
					continue;
				}
					bonus[i] += other;
			}
	
		}
		return bonus;
	}
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] a = calculateHolidayBonus(data, high, low, other);
		double total =0;
		for (int i =0; i < a.length; i++)
		{
				total += a[i];
		}
			return total;
	}
	
	
}
