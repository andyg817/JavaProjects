/*
 * Written by Andrew Garcia
 */
public class Rectangle extends Shape
{
	private double side1;
	private double side2;
	public Rectangle()
	{
		super();
		this.side1 = 1.0;
		this.side2 = 1.0;
		super.setArea(side1*side2);
	}
	public Rectangle(double s1, double s2)
	{
		this.setSide1(s1);
		this.setSide2(s2);
	}
	public double getSide1()
	{
		return this.side1;
	}
	public double getSide2()
	{
		return this.side2;
	}
	public void setSide1(double s1)
	{
		if(s1 > 0.0)
			this.side1 = s1;
		else
			this.side1 = 1.0;
	}
	public void setSide2(double s2)
	{
		if(s2 > 0.0)
			this.side1 = s2;
		else
			this.side1 = 1.0;
	}
	@Override
	public String toString()
	{
		return super.toString()+" Side 1: "+ this.side1 + " Side 2: " + this.side2 + " Area: "+ this.getArea();
	}
}
