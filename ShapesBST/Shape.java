/*
 * Written by Andrew Garcia
 */
public class Shape implements Comparable<Shape>
{
	private double area;
	private String type;
	public Shape()
	{
		this.area = 1.0;
		this.type = "circle";
	}
	public Shape(double aA, String aT)
	{
		this.setType(aT);
		this.setArea(aA);
	}
	public double getArea()
	{
		return this.area;
	}
	public String getType()
	{
		return this.type;
	}
	public void setArea(double aA)
	{
		if(aA >0.0)
			this.area = aA;
		else 
			this.area = 1.0;
	}
	public void setType(String aT)
	{
		if(aT != null && (aT.equalsIgnoreCase("circle") || aT.equalsIgnoreCase("rectangle") || aT.equalsIgnoreCase("right triangle")))
		{
			this.type = aT;
		}
		else
			this.type = "circle";
	}
	public String toString()
	{
		return this.type + " " + this.area;
	}
	public int compareTo(Shape aShape)
	{
		if(aShape == null)
			return -1;
		if(this.area < aShape.getArea())
			return -1;
		else if(this.area > aShape.getArea())
			return 1;
		else return this.type.compareTo(aShape.getType());
	}
}
