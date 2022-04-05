package fitness_api.trainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import fitness_api.trainee.Trainee;

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
		Trainee t1 = new Trainee(1, "Utkarsh", 61.8f, 163f, 32);
		Trainee t2 = new Trainee(2, "Sudatt", 89.8f, 177f, 38);
		Trainee t3 = new Trainee(3, "Sharath", 67.8f, 165f, 31);
		Trainee t4 = new Trainee(4, "Chandrabhan", 71.8f, 164f, 37);
		Trainee t5 = new Trainee(5, "Gaurav", 87.8f, 180f, 36);
		Trainee t6 = new Trainee(6, "Diptanu", 61.8f, 156f, 31);
		
		trainerList = new ArrayList<>(Arrays.asList(
				new Trainer(1, "Abhinav", 12, new ArrayList<>(Arrays.asList(t1))),
				new Trainer(2, "Roshan", 10, new ArrayList<>(Arrays.asList(t2,t3))),
				new Trainer(3, "Umakant", 11, null),
				new Trainer(4, "Ravi", 8, new ArrayList<>(Arrays.asList(t4))),
				new Trainer(5, "Veer", 7, null),
				new Trainer(6, "John", 4, new ArrayList<>(Arrays.asList(t5,t6)))
				));		
		return trainerList;
	}

}
