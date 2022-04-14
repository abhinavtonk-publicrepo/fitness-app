package fitness_api.practise;

public class CalculatorService {
	Calculator calc = new Calculator();
	int result;
	
	public int operation(int a, int b, String operator) throws Exception {
		if(operator.equals("Sum")) {
			result = calc.calculateSum(a, b);
		}
		else if (operator.equals("Product")) {
			result = calc.calculateProduct(a, b);
		}
		else {
			throw new Exception();
//			System.out.println("Invalid Operator Provided");
			
		}
		return result;
	}
}
