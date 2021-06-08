package java_assignment_1;

import java.util.*;

public class Checkout {
	
	private double tax = 8.25;
	ArrayList<DessertItem> cheque;
	
	public Checkout() {
		this.cheque = new ArrayList<DessertItem>();
	}
	
	public void clearList() {
		this.cheque.clear();
	}
	
	public void addItem(DessertItem d) {
		this.cheque.add(d);
	}
	
	public void setTax(double vartax) {
		this.tax = vartax;
	}
	
	public double getTax() {
		return tax;
	}
	
	public int beforeTax(){
		int beforetaxcost = 0; 
		for (DessertItem o : cheque) {
			beforetaxcost += o.getCost();
		}
		return beforetaxcost; 
	}
	
	public int totalTax(){
		double totalTax = beforeTax() * getTax() * 0.01;
		int totalTaxInt = (int) Math.round(totalTax);
		return totalTaxInt;
	}
	
	public int totalAmount() {
		return beforeTax() + totalTax();
	}
	
	private String insertSpace(int tspace) {
		String s = "";
		for (int i = 0; i < tspace; i++){
			s += " ";
		}
		return s;
	}
	
	public String toString() {
		
		int count = 0;
		String billItems = "";
		billItems += insertSpace(33) + "-----------------------------\n";
		billItems += insertSpace(34) + "Dessert Items Cash Register\n";
		billItems += insertSpace(33) + "-----------------------------\n\n";
		billItems += insertSpace(8) + "Item Name" + insertSpace(20) + "Quantity" + insertSpace(14) + "Price" +  insertSpace(13) + "Amount\n";
		billItems += insertSpace(7) + "-----------" + insertSpace(18) + "----------" + insertSpace(12) + "--------" +  insertSpace(10) + "--------\n";
		
		for (DessertItem d : cheque) {
			count++;
			if(d instanceof Candy) {
				int space1 = 35 - d.getName().length() - String.valueOf(count).length();
				int space2 = 20 - ((Candy)d).getCandyQuantity().length();
				int space3 = 19 - ((Candy)d).getCandyPrice().length();
				billItems += " " + count + ". " + d.getName() + insertSpace(space1) + ((Candy)d).getCandyQuantity() + insertSpace(space2) + "$" + ((Candy)d).getCandyPrice() + insertSpace(space3) + "$" + CentToDollar.centToDollars(d.getCost()) + "\n";
			}
			else if(d instanceof Cookie) {
				int space1 = 35 - d.getName().length() - String.valueOf(count).length();
				int space2 = 20 - ((Cookie)d).getCookieQuantity().length();
				int space3 = 19 - ((Cookie)d).getCookiePrice().length();
				billItems += " " + count + ". " + d.getName() + insertSpace(space1) + ((Cookie)d).getCookieQuantity() + insertSpace(space2) + "$" + ((Cookie)d).getCookiePrice() + insertSpace(space3) + "$" + CentToDollar.centToDollars(d.getCost()) + "\n";
			}
			else if(d instanceof Sundae) {
				int space1 = 32 - d.getName().length() - ((Sundae)d).getSundaeName().length() - String.valueOf(count).length();
				int space2 = 20 - ((Sundae)d).getSundaeQuantity().length();
				int space3 = 19 - ((Sundae)d).getSundaePrice().length();
				billItems += " " + count + ". " + d.getName() + " (" +((Sundae)d).getSundaeName() + ")" + insertSpace(space1) + ((Sundae)d).getSundaeQuantity() + insertSpace(space2) + "$" + ((Sundae)d).getSundaePrice() + insertSpace(space3) + "$" + CentToDollar.centToDollars(d.getCost()) + "\n";
			}
			else if(d instanceof IceCream) {
				int space1 = 35 - d.getName().length() - String.valueOf(count).length();
				int space2 = 20 - ((IceCream)d).getIceCreamQuantity().length();
				int space3 = 19 - ((IceCream)d).getIceCreamPrice().length();
				billItems += " " + count + ". " + d.getName() + insertSpace(space1) + ((IceCream)d).getIceCreamQuantity() + insertSpace(space2) + "$" + ((IceCream)d).getIceCreamPrice() + insertSpace(space3) + "$" + CentToDollar.centToDollars(d.getCost()) + "\n";
			}
			else {
				billItems += billItems;
			}
		}
		
		billItems += "\n-------------------------------------------------------------------------------------------\n\n";
		billItems += insertSpace(62) + "Total Items:      " + count + "\n";
		billItems += insertSpace(62) + "Sub-Total:      $" + CentToDollar.centToDollars(beforeTax()) + "\n";
		billItems += insertSpace(62) + "Tax @" + getTax() + "%:     $"  + CentToDollar.centToDollars(totalTax()) + "\n";
		billItems += insertSpace(60) + "---------------------------\n";
		billItems += insertSpace(62) + "Total Amount:   $" + CentToDollar.centToDollars(totalAmount()) + "\n";
		billItems += insertSpace(60) + "---------------------------\n";
		billItems += "\n-------------------------------------------------------------------------------------------\n\n";
		
		return billItems;
	}

	public static void main(String[] args) {

		Checkout c1 = new Checkout();
		
		c1.addItem(new IceCream("Strawberry IceCream", 2, 159));
		c1.addItem(new Sundae("Vanilla Ice Cream", 3, 100, "Caramel", 20));
		c1.addItem(new Candy("Gummy Worms", 7.34, 89));
		c1.addItem(new Cookie("Chocolate Chip Cookies", 26, 399));
		c1.addItem(new Sundae("Chocolate IceCream", 1, 90, "Vanilla", 30));
		System.out.println(c1);
		
		c1.clearList();
		
		c1.setTax(18.5);
		c1.addItem(new IceCream("Strawberry IceCream", 2, 159));
		c1.addItem(new Sundae("Vanilla Ice Cream", 3, 100, "Caramel", 20));
		c1.addItem(new Candy("Gummy Worms", 7.34, 89));
		c1.addItem(new Cookie("Chocolate Chip Cookies", 26, 399));
		c1.addItem(new Sundae("Chocolate IceCream", 1, 90, "Vanilla", 30));
		System.out.println(c1);
		
		c1.clearList();
		
	}

}
