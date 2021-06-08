package java_assignment_1;

public class Cookie extends DessertItem {

	private int quantity, centperdozen;
	
	public Cookie() {
		super();
		quantity = 0;
		centperdozen = 0;
	}
	
	public Cookie(String name, int quant, int price) {
		super(name);
		quantity = quant;
		centperdozen = price;
	}
	
	@Override
	public int getCost() {
		int costInt = 0;
		double cost = 0;
		if(quantity>0 && centperdozen>0) {
			cost = centperdozen / 12.0 *quantity;
			costInt = (int) Math.round(cost);
		}
		return costInt;
	}
	
	public String getCookieQuantity() {
		String candyquantity;
		candyquantity = quantity + " pc";
		return candyquantity;
	}
	
	public String getCookiePrice() {
		String candyprice;
		candyprice = CentToDollar.centToDollars(centperdozen) + "/dozen";
		return candyprice;
	}
	
	public String toString() {
		return name + " " + quantity + " " + centperdozen;
	}
	
}
