package assignment4;

public class Plot {

    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    /**
     *
     * @param p
     */
    public Plot(Plot p) {
        this.x = p.x;
        this.y = p.x;
        this.width = p.width;
        this.depth = p.depth;

    }

    /**
     *
     * @param x
     * @param y
     * @param width
     * @param depth
     */
    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }


	public boolean overlaps(Plot plot) {

		
		 if (this.x + this.width <= plot.getX())
	            return false;
	        if (this.x >= plot.getX() + plot.getWidth())
	            return false;
	        if (this.y + this.depth <= plot.getY())
	            return false;
	        if (this.y >= plot.getY() + plot.getDepth())
	            return false;
	        return true;
	      
   }

    public  boolean encompasses(Plot plot) {
        if (plot.getX() >= this.x &&
                ((plot.getX()+plot.getWidth()) <= (this.x+this.width)) &&
                ((plot.getX()-plot.getDepth()) >= (this.x-this.depth)) &&
                ((plot.getX()+plot.getWidth()-plot.getDepth() ) >= (this.x+this.width-this.depth))
        ) {
           return true;
        }
        else
            return false;
    }

    public void setX(int x)
	{
		this.x = x;
	}
	
	public int  getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	
	public int  getDepth()
	{
		return depth;
	}

	public String toString()
	{
		return ("Upper left: ("+x+","+ y+ "); Width: " + width + " Depth: " + depth );
	}


}