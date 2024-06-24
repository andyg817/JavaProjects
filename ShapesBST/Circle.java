/*
 * Written by Andrew Garcia
 */
public class Circle extends Shape
{
	private double radius;
	private double area;
	public Circle()
	{
		super();
		this.radius = 1.0;
		this.area = 1.0;
	}
	public Circle(double aR)
	{
		this.setArea();
		this.setRadius(aR);
	}
	public double getRadius()
	{
		return this.radius;
	}
	public double getArea()
	{
		return this.area;
	}
	public void setRadius(double aR)
	{
		if(aR > 0.0)
			this.radius = aR;
		else
			this.radius = 1.0;
	}
	public void setArea()
	{
		if(this.radius > 0.0)
			this.area = Math.PI * this.radius * this.radius;
		else 
			this.area = 1.0;
	}
	public String toString()
	{
		return super.toString()+ " Radius: "+ this.radius + " Area: " + this.area;
	}
}
