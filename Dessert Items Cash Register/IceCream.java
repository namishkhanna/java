package java_assignment_1;

public class IceCream extends DessertItem {
	
	protected int cost;
	protected int quantity;
	
	public IceCream() {
		super();
		cost = 0;
		quantity = 0;
	}
	
	public IceCream(String name, int quant, int icecost) {
		super(name);
		cost = icecost;
		quantity = quant;
	}

	@Override
	public int getCost() {
		return cost * quantity;
	}
	
	public String getIceCreamQuantity() {
		String icecreamquantity;
		icecreamquantity = quantity + " pc";
		return icecreamquantity;
	}
	
	public String getIceCreamPrice() {
		String icecreamprice;
		icecreamprice = CentToDollar.centToDollars(cost) + "/pc";
		return icecreamprice;
	}
	
	public String toString() {
		return name + " " + getCost();
	}

}
