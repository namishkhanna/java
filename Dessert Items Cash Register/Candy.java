package java_assignment_1;

public class Candy extends DessertItem {
	
	private int centperlb;
	private double lb;
	
	public Candy() {
		super();
		lb = 0;
		centperlb = 0;
	}
	
	public Candy(String name, double candylb, double candycentperlb) {
		super(name);
		lb = candylb;
		centperlb = (int)candycentperlb;
	}

	@Override
	public int getCost() {
		int costInt = 0;
		double cost = 0;
		
		if(lb>0 && centperlb>0) {
			cost = centperlb * lb;
			costInt = (int) Math.round(cost);
		}
		return costInt;
	}
	
	public String getCandyQuantity() {
		String candyquantity;
		candyquantity = lb + " lb";
		return candyquantity;
	}
	
	public String getCandyPrice() {
		String candyprice;
		candyprice = CentToDollar.centToDollars(centperlb) + "/lb";
		return candyprice;
	}
	
	public String toString() {
		return name + " " + lb + " " + centperlb;
	}

}
