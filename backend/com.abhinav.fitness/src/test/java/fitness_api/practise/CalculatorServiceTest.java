package fitness_api.practise;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorServiceTest {
	@Mock
	Calculator calculator;
	
	@InjectMocks
	CalculatorService calculatorService;
	
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void testSumOperation() throws Exception {
//		when(calculator.calculateSum(any(Integer.class), any(Integer.class)))
//		.thenReturn(5);
		when(calculator.calculateSum(2, 3))
		.thenReturn(5);
		
		int res = calculatorService.operation(2, 3, "Sum");
		
		Assert.assertEquals(5, res);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void testSumExceptionFlow() throws Exception {
		calculatorService.operation(2, 3, "Junk");
	}

}
