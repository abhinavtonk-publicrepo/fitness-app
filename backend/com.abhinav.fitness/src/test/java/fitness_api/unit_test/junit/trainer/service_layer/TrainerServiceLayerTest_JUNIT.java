package fitness_api.unit_test.junit.trainer.service_layer;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.testng.Assert;

import fitness_api.trainer.Trainer;
import fitness_api.trainer.TrainerRepository;
import fitness_api.trainer.TrainerService;

//@RunWith(MockitoJUnitRunner.class)
public class TrainerServiceLayerTest_JUNIT {
	
	@Mock
	TrainerRepository trainerRepository;
	
	@InjectMocks
	TrainerService trainerService;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@Tag("unit-tests")
	public void testGetAllTrainer() {
		List<Trainer> expectedList = mockResponseGetAllTrainers();
		System.out.println("expectedList = " + expectedList.size());
		
		when(trainerRepository.getAllTrainers()) // Whichever object you use inside when() is basically annotated with @Mock
		.thenReturn(expectedList);
		
//		doReturn(expectedList).when(trainerRepository).getAllTrainers();
		
		List<Trainer> actualList = trainerService.getAllTrainers();
		
		Assert.assertEquals(actualList.get(0).getTrainerId(), 1);
		
	}
	
	@Test
	public void testParticularTrainer() {
		Trainer t1 = new Trainer(1, "Mock Trainer 1", 1, null);
		
		when(trainerRepository.getTrainer(1)).thenReturn(t1);
		
		Trainer actualTrainer = trainerService.getTrainer(1);
		Assert.assertEquals(actualTrainer.getTrainerId(), 1);
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
