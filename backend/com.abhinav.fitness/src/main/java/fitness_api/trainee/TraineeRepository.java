package fitness_api.trainee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public class TraineeRepository {
	private List<Trainee> traineeList = populateTrainees();
	
	public List<Trainee> getAllTrainees() {
		return traineeList;
	}

	public Trainee getTrainee(int traineeId) {
		return traineeList.stream().filter(t->t.getTraineeId()==traineeId).findFirst().get();
	}

	public void addTrainee(Trainee trainee) {
		traineeList.add(trainee);		
	}

	public void updateTrainee(Trainee trainee, int traineeId) {
		for(int i=0;i<traineeList.size();i++) {
			Trainee t = traineeList.get(i);
			if(t.getTraineeId()+1 == traineeId) {
				traineeList.set(i, t);
				return;
			}
		}	
	}

	public void deleteTrainee(int traineeId) {
		traineeList.removeIf(t->t.getTraineeId() == traineeId);		
	}
	
	// Method to populate List of Trainees
		public List<Trainee> populateTrainees(){
			traineeList = new ArrayList<>(Arrays.asList(
					new Trainee(1, "Utkarsh", 61.8f, 163f, 32),
					new Trainee(2, "Sudatt", 89.8f, 177f, 38),
					new Trainee(3, "Sharath", 67.8f, 165f, 31),
					new Trainee(4, "Chandrabhan", 71.8f, 164f, 37),
					new Trainee(5, "Gaurav", 87.8f, 180f, 36),
					new Trainee(6, "Diptanu", 61.8f, 156f, 31)
					));		
			return traineeList;
		}
}
