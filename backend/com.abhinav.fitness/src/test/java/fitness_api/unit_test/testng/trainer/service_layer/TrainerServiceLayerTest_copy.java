package fitness_api.unit_test.testng.trainer.service_layer;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import fitness_api.trainer.Trainer;
import fitness_api.trainer.TrainerRepository;
import fitness_api.trainer.TrainerRepository1;
import fitness_api.trainer.TrainerRepository2;
import fitness_api.trainer.TrainerService;

//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
public class TrainerServiceLayerTest_copy{ //extends AbstractTestNGSpringContextTests{
	@InjectMocks
	TrainerService trainerService;
	
	@Mock
//	@InjectMocks
	TrainerRepository1 trainerRepository1;
	
//	@Mock(answer=Answers.RETURNS_DEEP_STUBS)
	@Mock
	TrainerRepository2 trainerRepository2;
//	
//	TrainerService trainerService = Mockito.mock(TrainerService.class);
//	TrainerRepository trainerRepository = Mockito.mock(TrainerRepository.class);
	
	@BeforeClass
	public void beforeClass() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTrainer() {
		List<Trainer> expectedList = mockResponseGetAllTrainers();
		System.out.println("expectedList = " + expectedList.size());
		
		when(trainerRepository2.getAllTrainers()) // Whichever object you use inside when() is basically annotated with @Mock
		.thenReturn(expectedList);
		
		when(trainerRepository1.getAllTrainers())
		.thenReturn(expectedList);
		
		List<Trainer> actualList = trainerService.getAllTrainers();
		
		Assert.assertEquals(actualList.get(0).getTrainerId(), 1);
		
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
