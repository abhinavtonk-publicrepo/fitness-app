package fitness_api.practise;

public class Calculator {
	
	public int calculateSum(int a, int b) {
		int sum = a+b;
		
		if(sum>0) {
			System.out.println("Positive Sum");
		}		
		else if(sum<0) {
			System.out.println("Negative Sum");
		}
		else {
			System.out.println("Sum is Zero");
		}
		
		return sum;
	}
	
	public int calculateProduct(int a, int b) {
		int p = a*b;
		
		if(p>0) {
			System.out.println("Positive Product");
		}		
		else if(p<0) {
			System.out.println("Negative Product");
		}
		else {
			System.out.println("Product is Zero");
		}
		
		return p;
	}
}
