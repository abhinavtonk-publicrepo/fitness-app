package fitness_api.trainee;

public class Trainee {
	int traineeId;
	String traineeName;
	float traineeWeight;
	float traineeHeight;
	int traineeAge;
	
	public Trainee(int traineeId, String traineeName, float traineeWeight, float traineeHeight, int traineeAge) {
		this.traineeId = traineeId;
		this.traineeName = traineeName;
		this.traineeWeight = traineeWeight;
		this.traineeHeight = traineeHeight;
		this.traineeAge = traineeAge;
	}
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public float getTraineeWeight() {
		return traineeWeight;
	}
	public void setTraineeWeight(float traineeWeight) {
		this.traineeWeight = traineeWeight;
	}
	public float getTraineeHeight() {
		return traineeHeight;
	}
	public void setTraineeHeight(float traineeHeight) {
		this.traineeHeight = traineeHeight;
	}
	public int getTraineeAge() {
		return traineeAge;
	}
	public void setTraineeAge(int traineeAge) {
		this.traineeAge = traineeAge;
	}
}
