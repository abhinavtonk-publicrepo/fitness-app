package fitness_api.trainer;

public class Trainer {
	int trainerId;
	String trainerName;
	int trainerTotalExperience;
	//	List<Trainee> traineeList;
	
	public int getTrainerId() {
		return trainerId;
	}
	public Trainer(int trainerId, String trainerName, int trainerTotalExperience) {
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.trainerTotalExperience = trainerTotalExperience;
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
