package fitness_api.trainer;

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
public class TrainerController {

	@Autowired
	TrainerService trainerService;
	
//	@GetMapping(path = "/trainers" , produces = {MediaType.APPLICATION_JSON_VALUE})
	@GetMapping(path = "/trainers")
	public List<Trainer> getAllTrainers(){
		return trainerService.getAllTrainers();
	}
	
	@GetMapping(path = "/trainers/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Trainer getTrainer(@PathVariable("id") int trainerId) {
		return trainerService.getTrainer(trainerId);
	}
	
	@PostMapping(path = "/trainers" , consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void addTrainer(@RequestBody Trainer trainer) {
		trainerService.addTrainer(trainer);
	}
	
	@PutMapping(path = "/trainers/{trainerId}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
	public void updateTrainer(@RequestBody Trainer trainer, @PathVariable int trainerId) {
		trainerService.updateTrainer(trainer, trainerId);
	}
	
	@DeleteMapping(path = "/trainers/{trainerId}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public void deleteTrainer(@PathVariable int trainerId) {
		trainerService.deleteTrainer(trainerId);
	}
}
