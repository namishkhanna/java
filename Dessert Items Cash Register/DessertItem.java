package java_assignment_1;

public abstract class DessertItem {

	  protected String name;

	  public DessertItem() {
	    this("");
	  }

	  public DessertItem(String name) {
	      this.name = name;
	      }

	  public final String getName() {
	    return name;
	  }

	  public abstract int getCost();

	}