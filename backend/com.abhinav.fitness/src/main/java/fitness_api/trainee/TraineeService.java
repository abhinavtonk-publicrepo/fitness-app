package fitness_api.trainee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TraineeService {
	@Autowired
	TraineeRepository traineeRepository;

	public List<Trainee> getAllTrainees() {
		return traineeRepository.getAllTrainees();
	}

	public Trainee getTrainee(int traineeId) {
		return traineeRepository.getTrainee(traineeId);
	}

	public void addTrainee(Trainee trainee) {
		traineeRepository.addTrainee(trainee);
	}

	public void updateTrainee(Trainee trainee, int traineeId) {
		traineeRepository.updateTrainee(trainee,traineeId);	
	}

	public void deleteTrainee(int traineeId) {
		traineeRepository.deleteTrainee(traineeId);
	}

}
