/*
 * Written by Andrew Garcia
 */
public class RightTriangle extends Shape
{
	private double side1;
	private double side2;
	private double area;
	public RightTriangle()
	{
		super();
		this.side1 = 1.0;
		this.side2 = 1.0;
		this.area = 1.0;
	}
	public RightTriangle(double s1, double s2)
	{
		this.setArea();
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
	public double getArea()
	{
		return this.area;
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
	public void setArea()
	{
		if(this.side1 > 0.0 && this.side2 > 0.0)
			this.area = 0.5 * this.side1 * this.side2;
		else 
			this.area = 1.0;
	}
	public String toString()
	{
		return super.toString()+" Side 1: "+ this.side1 + " Side 2: " + this.area + " Area: "+ this.area;
	}
}