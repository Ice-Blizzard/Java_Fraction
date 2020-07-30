package rs418393;

public class Ulamek {

	private int numerator, determinator;
	
	// Euclid's algorithm
    // recursive implementation
    private static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
	
    public Ulamek(int p, int q) {
        if (q == 0)
            throw new ArithmeticException("You cannot divide by zero");
        else {
        	// negative q
            if (q < 0) {
                q = q * (-1);
                p = p * (-1);
            }
            numerator = p;
            determinator = q;
            int gcd = gcd(Math.abs(p), q);
            if (numerator < 0) {
            	numerator = numerator * (-1);
            	numerator = numerator / gcd;
            	numerator = numerator * (-1);        	
            }
            else {
            	numerator = numerator / gcd;
            }
            determinator = determinator / gcd;
        }
    }
    
    public static Ulamek plus(Ulamek first, Ulamek second) {
      Ulamek result = new Ulamek(1, 1);
      
      result.determinator = first.determinator;
      first.numerator = first.numerator * second.determinator;
      first.determinator = first.determinator * second.determinator;
      second.numerator = second.numerator * result.determinator;
      second.determinator = second.determinator * result.determinator;
      
      result.numerator = first.numerator + second.numerator;
      result.determinator = first.determinator;
      
      if (result.determinator < 0) {
    	  result.determinator = result.determinator * (-1);
    	  result.numerator = result.numerator * (-1);
      }
      
      int gcd = gcd(Math.abs(result.numerator), result.determinator);
      if (result.numerator < 0) {
      result.numerator = result.numerator * (-1);
      result.numerator = result.numerator / gcd;
      result.numerator = result.numerator * (-1);
      	
      }
      else {
    	  result.numerator = result.numerator / gcd;
      }
            result.determinator = result.determinator / gcd;
      
      return result;
    }
    
    public static Ulamek minus(Ulamek first, Ulamek second) {
    	second.numerator = second.numerator * (-1);
    	return plus(first, second);
    }
    
    public static Ulamek multiplication(Ulamek first, Ulamek second) {
    	Ulamek result = new Ulamek(first.numerator * second.numerator,
    			first.determinator * second.determinator);  
        return result;
    }
    
    public static Ulamek divide(Ulamek first, Ulamek second) {
        if (second.numerator == 0)
            throw new ArithmeticException("You cannot divide by zero");
        else {
        	Ulamek new_second = new Ulamek(1, 1);
        	
        	new_second.numerator = second.determinator;
        	new_second.determinator = second.numerator;
        	
        	return multiplication(first, new_second);
        }
    }
    
    public static void show(Ulamek first) {
    	System.out.print("Wanted Ulamek is ");
    	Ulamek copy = new Ulamek (first.numerator, first.determinator);
    	if (first.numerator == 0) {
    		System.out.println("0");
    	}
    	else {
    		if (first.numerator < 0) {
    			first.numerator = first.numerator * (-1);
    			
    			System.out.print("-");
    			if (first.numerator % first.determinator == 0) {
        			System.out.print(first.numerator/first.determinator);
        			System.out.print("+");
        			first.numerator = 0;		
    			}
    			else {
    			System.out.print(first.numerator/first.determinator + 1);
    			System.out.print("+");
    			
    			first.numerator = first.numerator - (first.determinator *
    					(first.numerator/first.determinator));
    			first.numerator = first.determinator - first.numerator;
    			}
    			
    		}
    		else {
    			System.out.print(first.numerator/first.determinator);
    			System.out.print("+");
    			
    			first.numerator = first.numerator - (first.determinator *
    					(first.numerator/first.determinator));
    		}
    		
			System.out.print(first.numerator);
			System.out.print("/");
			System.out.println(first.determinator);
			first.numerator = copy.numerator;
			first.determinator = copy.determinator;
    	}
    }
}
