package fitness_api.trainer;

import java.util.List;

import fitness_api.trainee.Trainee;

public class Trainer {
	int trainerId;
	String trainerName;
	int trainerTotalExperience;
	List<Trainee> traineeList;
	
	public Trainer(int trainerId, String trainerName, int trainerTotalExperience, List<Trainee> traineeList) {
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerTotalExperience = trainerTotalExperience;
		this.traineeList = traineeList;
	}
	
	public List<Trainee> getTraineeList() {
		return traineeList;
	}
	public void setTraineeList(List<Trainee> traineeList) {
		this.traineeList = traineeList;
	}
	public int getTrainerId() {
		return trainerId;
	}
	
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public int getTrainerTotalExperience() {
		return trainerTotalExperience;
	}
	public void setTrainerTotalExperience(int trainerTotalExperience) {
		this.trainerTotalExperience = trainerTotalExperience;
	}
}
