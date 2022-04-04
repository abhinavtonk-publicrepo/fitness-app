package fitness_api.trainer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainerService {

	@Autowired
	TrainerRepository trainerRepository;
	
	public List<Trainer> getAllTrainers() {
		return trainerRepository.getAllTrainers();
	}

	public Trainer getTrainer(int trainerId) {
		return trainerRepository.getTrainer(trainerId);
	}

	public void addTrainer(Trainer trainer) {
		trainerRepository.addTrainer(trainer);		
	}

	public void updateTrainer(Trainer trainer, int trainerId) {
		trainerRepository.updateTrainer(trainer,trainerId);		
	}

	public void deleteTrainer(int trainerId) {
		trainerRepository.deleteTrainer(trainerId);		
	}

}
