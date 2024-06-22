/*
 * Written by Andrew Garcia
 */
public class Prize {
	private String name;
	private double price;
	public Prize()
	{
		this.name = "none";
		this.price = 0.0;
	}
	public Prize(String aName, double aPrice)
	{
		this.setName(aName);
		this.setPrice(aPrice);
	}
	public String getName()
	{
		return this.name;
	}
	public Double getPrice()
	{
		return price;
	}
	public void setName(String aName)
	{
		if(aName != null)
			this.name  = aName;
		else
			this.name = "none";
	}
	public void setPrice(double aPrice)
	{
		if(aPrice > 0.0)
			this.price = aPrice;
		else
			this.price = 0.0;
	}
	public String toString()
	{
		return "Name: "+this.name;
	}
	public boolean equals(Prize aPrize)
	{
		return aPrize != null && this.name.equals(aPrize.getName()) && this.price == aPrize.getPrice();
	}
}
