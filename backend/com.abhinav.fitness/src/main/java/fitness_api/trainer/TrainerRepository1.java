package fitness_api.trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fitness_api.trainee.Trainee;

@Repository
public class TrainerRepository1 {

	@Autowired
	TrainerRepository2 trainerRepository2= new TrainerRepository2();
	
	public List<Trainer> getAllTrainers() {
		return trainerRepository2.getAllTrainers();
	}

	public Trainer getTrainer(int trainerId) {
		return trainerRepository2.getTrainer(trainerId);
	}

	public void addTrainer(Trainer trainer) {
		trainerRepository2.addTrainer(trainer);		
	}

	public void updateTrainer(Trainer trainer, int trainerId) {
		trainerRepository2.updateTrainer(trainer,trainerId);		
	}

	public void deleteTrainer(int trainerId) {
		trainerRepository2.deleteTrainer(trainerId);		
	}

}
