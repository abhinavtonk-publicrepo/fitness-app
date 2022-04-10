package fitness_api.unit_test.testng.trainer.service_layer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import fitness_api.trainer.Trainer;
import fitness_api.trainer.TrainerRepository;
import fitness_api.trainer.TrainerService;

public class TrainerServiceLayerTest{
	@InjectMocks
	TrainerService trainerService;
	
	@Mock
	TrainerRepository trainerRepository;
		
	@BeforeMethod
	public void beforeMethod() {
		MockitoAnnotations.openMocks(this);// Initializes the mock object annotated with @Mock, @InjectMock; Fresh initialization reqd before running each tests
//		MockitoAnnotations.initMocks(this);
	}
	
//	@AfterMethod
//	public void afterMethod() { // reset() is required when we are not using openMocks() before each test
//		Mockito.reset(trainerRepository); // Very Important to reset Mock ref variable if openMocks() not used before every tests, 
//										  // or else when you will run your tests as a suite, it will Fail weirdly
//		
//		//Smart Mockito users hardly use this feature because they know it could be a sign of poor tests.Normally, you don't need to reset your mocks, just create new mocks for each test method.
//	}
	
	@Test
	public void testGetAllTrainer() {
		List<Trainer> expectedList = mockResponseGetAllTrainers();
		System.out.println("expectedList = " + expectedList.size());
		
		when(trainerRepository.getAllTrainers()) // Whichever object you use inside when() is basically annotated with @Mock
		.thenReturn(expectedList);
		
		List<Trainer> actualList = trainerService.getAllTrainers();
		
		Assert.assertEquals(actualList.get(0).getTrainerId(), 1);
		
	}
	
	@Test
	public void testGetTrainerWithinIndex() {
		Trainer expectedTrainer = new Trainer(1, "Mock Trainer 1", 1, null);
		when(trainerRepository.getTrainer(any(Integer.class))).thenReturn(expectedTrainer);
		
		Trainer actualTrainer = trainerService.getTrainer(1);
		
		Assert.assertEquals(actualTrainer.getTrainerId(), 1);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void testGetTrainerOutsideIndexBound() {
		when(trainerRepository.getTrainer(any(Integer.class))).thenThrow(Exception.class);
		
		trainerService.getTrainer(12);
	}
	
	@Test
	public void testAddTrainer() {
		Trainer expectedTrainer = new Trainer(1, "Mock Trainer 1", 1, null);
		doNothing().when(trainerRepository).addTrainer(isA(Trainer.class)); // Unit Testing void method
		
		trainerService.addTrainer(expectedTrainer);
	}
	
	@Test(expectedExceptions = Exception.class)
	public void testAddTrainerForNullParam() {
		doThrow(Exception.class).when(trainerRepository).addTrainer(isNull()); // Unit Testing void method
		
		trainerService.addTrainer(null);
	}
	
	public List<Trainer> mockResponseGetAllTrainers(){
		Trainer t1 = new Trainer(1, "Mock Trainer 1", 1, null);
		Trainer t2 = new Trainer(2, "Mock Trainer 2", 2, null);
		List<Trainer> list = new ArrayList<Trainer>();
		list.add(t1);
		list.add(t2);
		
		return list;
	}
	

}
