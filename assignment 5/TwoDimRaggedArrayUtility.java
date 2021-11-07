import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;


public class TwoDimRaggedArrayUtility {
	
	public TwoDimRaggedArrayUtility()
	{	
	}
	
	public static double getAverage(double[][] data)
	{
		double total = 0.0;
		double count = 0.0;
	    for (int i =0; i< data.length; i++)
	    {
	        for(int j=0; j<data[i].length; j++)
	        {
	            count++;
	            total += data[i][j];
	            
	        }
	    }
	    return total / count;
	}
	public static double getTotal(double[][] data)
	{
		double total = 0;
		 for (int i =0; i< data.length; i++)
		    {
		        for(int j=0; j<data[i].length; j++)
		        {
		            total += data[i][j];
		            
		        }
		    }
		 return total;
	}
	public static double getColumnTotal(double[][] data, int col)
	{
		double total =0.0;
	    for (int i =0; i< data.length; i++)
	    {
	        try {
	            total += data[i][col];
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	           continue;
	        }	           
        }
	    return total;
	
	}
	public static double getHighestInArray(double[][] data)
	{
		double max = data[0][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j < data[i].length; j++)
			{
				if (data[i][j] > max)
					max = data[i][j];
			}
		}
		return max;
	}
	
	public static double getHighestInColumn(double[][] data, int col)
	{
		double max = data[0][col];
		for (int i =0; i< data.length; i++)
		{
			try {
				if (max < data[i][col])
					max = data[i][col];
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	           continue;
	        }
			
		}
		return max;
	}
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		int a =0;
		double max = data[0][col];
		for (int i =0; i< data.length; i++)
		{
			try {
				if (max < data[i][col])
				{
					max = data[i][col];
					a = i;
				}
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	           continue;
	        }
			
		}
		return a;
	}
	public static double getHighestInRow(double[][] data, int row)
	{
		double max = data[row][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j< data[i].length; j++)
			{
				try {
					if (max < data[row][j])
						max = data[row][j];
		        }
		        catch (ArrayIndexOutOfBoundsException e) 
		        {
		           continue;
		        }
			}
			
			
		}
		return max;
	}
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		int a =0;
		double max = data[row][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j< data[i].length; j++)
			{
				try {
					if (max < data[row][j])
					{
						a = j;
						max = data[row][j];
					}
		        }
		        catch (ArrayIndexOutOfBoundsException e) 
		        {
		           continue;
		        }
			}
			
			
		}
		return a;
	}
	public static double getLowestInArray(double[][] data)
	{
		double min = data[0][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j < data[i].length; j++)
			{
				if (data[i][j] < min)
					min = data[i][j];
			}
		}
		return min;
	}
	public static double getLowestInColumn(double[][] data, int col)
	{
		double min = data[0][col];
		for (int i =0; i< data.length; i++)
		{
			try {
				if (min > data[i][col])
					min = data[i][col];
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	           continue;
	        }
			
		}
		return min;
	}
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		double min = data[0][col];
		int a =0;
		for (int i =0; i< data.length; i++)
		{
			try {
				if (min > data[i][col])
				{
					min = data[i][col];
					a = i;
				}
				
	        }
	        catch (ArrayIndexOutOfBoundsException e) 
	        {
	           continue;
	        }
			
		}
		return a;
	}
	public static double getLowestInRow(double[][] data, int row)
	{
		double min = data[row][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j< data[i].length; j++)
			{
				try {
					if (min > data[row][j])
						min = data[row][j];
		        }
		        catch (ArrayIndexOutOfBoundsException e) 
		        {
		           continue;
		        }
			}
			
			
		}
		return min;
	}
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		int a =0;
		double min = data[row][0];
		for (int i =0; i< data.length; i++)
		{
			for (int j =0; j< data[i].length; j++)
			{
				try {
					if (min > data[row][j])
					{
						min = data[row][j];
						a = j;
					}
		        }
		        catch (ArrayIndexOutOfBoundsException e) 
		        {
		           continue;
		        }
			}
			
			
		}
		return a;
	}
	public static double getRowTotal(double[][] data, int row)
	{
		double total = 0;
		for (int i =0; i< data.length; i++)
		{
		    try 
		    {
		        total += data[row][i];
		    }
		    catch (ArrayIndexOutOfBoundsException e)
		    {
		        continue;
		    }
		}
		return total;
	}
	public static double[][] readFile(java.io.File outputFile) throws java.io.FileNotFoundException
	{       
		double[][] data = new double[6][];        
		String l;        
		int i = 0;    
		
		try{            
			
			Scanner sc = new Scanner(outputFile); 
			
			while (null != (l = sc.nextLine()))
			{  	
				String[] temp = l.split(" ");                 
				int size = temp.length;                
				data[i] = new double[size];     
	
				for (int j = 0; j < size; j++)
				{   
					data[i][j] = Double.parseDouble(temp[j]);                 
				}            
				i++;            
			}            
				sc.close();        
			}        
		catch (Exception e)
		{                
		}        
		return data;   
		
	}
	public static void writeToFile(double[][] data, File outputFile) throws IOException
	{
		FileWriter writer = new FileWriter(outputFile.toString());
			for (int i =0; i < data.length; i++)
			{
				for(int j =0; j< data[i].length; j++)
				{
					writer.write(data[i][j] + " ");
				}
				writer.write("\n");
			}
			writer.close();
	}


}

