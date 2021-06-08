package java_assignment_1;

public class Sundae extends IceCream {

	private String sundaename;
	private int sundaecost;
	
	public Sundae() {
		super();
		sundaename = "";
		sundaecost = 0;
	}
	
	public Sundae(String icecreamname, int icecreamquant, int icecreamcost, String sname, int scost) {
		super(icecreamname, icecreamquant, icecreamcost);
		sundaename = sname;
		sundaecost = scost;
		
	}
	
	public int getPerPiece() {
		int perPieceCost = super.cost + sundaecost;
		return perPieceCost;
	}
	
	public int getCost() {
		int total = super.getCost() + sundaecost * super.quantity;
		return total;
	}
	
	public String getSundaeName() {
		return sundaename;
	}
	
	public String getSundaeQuantity() {
		String sundaequantity;
		sundaequantity = super.quantity + " pc";
		return sundaequantity;
	}
	
	public String getSundaePrice() {
		String sundaeprice;
		sundaeprice = CentToDollar.centToDollars(getPerPiece()) + "/pc";
		return sundaeprice;
	}
	
	public String toString() {
		return super.name + " " + super.getCost() + " " + sundaename + " " + sundaecost;
	}
	
}
