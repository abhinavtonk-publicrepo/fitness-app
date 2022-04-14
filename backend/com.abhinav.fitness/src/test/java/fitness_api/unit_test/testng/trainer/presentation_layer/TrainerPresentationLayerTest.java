package fitness_api.unit_test.testng.trainer.presentation_layer;

import static org.mockito.Mockito.when;

import java.awt.print.Printable;
import java.util.ArrayList;
import java.util.List;

import org.apache.juneau.json.JsonSerializer;
import org.apache.juneau.serializer.SerializeException;
import org.json.simple.JSONArray;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ch.qos.logback.core.status.Status;
import fitness_api.trainer.Trainer;
import fitness_api.trainer.TrainerController;
import fitness_api.trainer.TrainerService;
import fitness_api.utils.JsonUtils;

// MockMvc test the Presentation Layer without actually starting the server. So it's basically a Unit Testing

//@WebMvcTest(TrainerController.class)
@WebMvcTest
@ContextConfiguration(classes= {TrainerController.class})
@TestExecutionListeners(listeners = {MockitoTestExecutionListener.class})
public class TrainerPresentationLayerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private TrainerService trainerService;
	
	JsonUtils jsonUtils = new JsonUtils();
	
//	private MockMvc mockMvc;
	
//	@Mock
//	private TrainerService trainerService;
//	
//	@InjectMocks
//	TrainerController trainerController;
//	
//	@BeforeMethod
//	public void beforeMethod() {
//		mockMvc = MockMvcBuilders.standaloneSetup(trainerController)
//                .build();
//	}
	
	@Test
	public void testGetAllTrainers() throws Exception {
		List<Trainer> expectedTrainer = mockResponseGetAllTrainers();
		when(trainerService.getAllTrainers()).thenReturn(expectedTrainer);
		
		String jsonString = convertListToJsonString(expectedTrainer);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/trainers"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(jsonString));
	}

	public List<Trainer> mockResponseGetAllTrainers(){
		Trainer t1 = new Trainer(1, "Mock Trainer 1", 1, null);
		Trainer t2 = new Trainer(2, "Mock Trainer 2", 2, null);
		List<Trainer> list = new ArrayList<Trainer>();
		list.add(t1);
		list.add(t2);		
		return list;
	}
	
	public String getJsonString(Object pojo) {
		JsonSerializer js = JsonSerializer.DEFAULT_READABLE;
		String jsonString = null;
		try {
			jsonString = js.serialize(pojo);
		} catch (SerializeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonString;
	}
	
	public <T> String convertListToJsonString(List<T> list) {
		String jsonString = JSONArray.toJSONString(list);
		
		return jsonString;
		
	}
	
	@Test
	public void test() {
		List<Trainer> expectedTrainer = mockResponseGetAllTrainers();
		String jsonString = jsonUtils.convertObjectToJsonString(expectedTrainer);
		System.out.println(jsonString);
	}
}
