package fitness_api.trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TraineeController {
	@Autowired
	TraineeService traineeService;
	
	@GetMapping(path = "/trainees" , produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Trainee> getAllTrainees(){
		return traineeService.getAllTrainees();
	}
	
	@GetMapping(path = "/trainees/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Trainee getTrainee(@PathVariable("id") int traineeId) {
		return traineeService.getTrainee(traineeId);
	}
	
	@PostMapping(path = "/trainees" , consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void addTrainee(@RequestBody Trainee trainee) {
		traineeService.addTrainee(trainee);
	}
	
	@PutMapping(path = "/trainees/{traineeId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void updateTrainee(@RequestBody Trainee trainee, @PathVariable int traineeId) {
		traineeService.updateTrainee(trainee, traineeId);
	}
	
	@DeleteMapping(path = "/trainees/{traineeId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteTrainee(@PathVariable int traineeId) {
		traineeService.deleteTrainee(traineeId);
	}
}
