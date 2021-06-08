package java_assignment_1;

public class CentToDollar {
	
	public static String centToDollars(int cents) {
		String s = "";
	     
	    if (cents < 0) {
	      s += "-";
	      cents *= -1;
	    }
	    
	    int dollars = cents/100;
	    cents = cents % 100;
	    
	    if (dollars > 0) {
	    	s += dollars;
	    }
	    	
	    else {
	    	s += "0";
	    }  	
	    
	    s +=".";
	      
	    if (cents < 10) {
	    	s += "0";
	    }
	      
	    s += cents;
	    return s;
	}

}
