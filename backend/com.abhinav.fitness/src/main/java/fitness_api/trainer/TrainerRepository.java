package fitness_api.trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TrainerRepository {

	private List<Trainer> trainerList = populateTrainers();
	
	public List<Trainer> getAllTrainers() {
		return trainerList;
	}

	public Trainer getTrainer(int trainerId) {
		return trainerList.stream().filter(t->t.getTrainerId()==trainerId).findFirst().get();
	}

	public void addTrainer(Trainer trainer) {
		trainerList.add(trainer);		
	}

	public void updateTrainer(Trainer trainer, int trainerId) {
		for(int i=0;i<trainerList.size();i++) {
			Trainer t = trainerList.get(i);
			if(t.getTrainerId()+1 == trainerId) {
				trainerList.set(i, t);
				return;
			}
		}
	}

	public void deleteTrainer(int trainerId) {
		trainerList.removeIf(t->t.getTrainerId() == trainerId);		
	}
	
	// Method to populate List of Trainers
	public List<Trainer> populateTrainers(){
		trainerList = new ArrayList<>(Arrays.asList(
				new Trainer(1, "Abhinav", 12),
				new Trainer(2, "Roshan", 10),
				new Trainer(3, "Umakant", 11),
				new Trainer(4, "Ravi", 8),
				new Trainer(5, "Veer", 7),
				new Trainer(6, "John", 4)
				));		
		return trainerList;
	}

}
