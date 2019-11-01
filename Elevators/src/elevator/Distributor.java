package elevator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import states.GoingDownState;
import states.GoingUpState;

public class Distributor {
	
	private List<Elevator> elevators;
	private Elevator minGoingDown, minGoingUp, minElevator;
	
	//in the first floor
	public Elevator findElevator(List<Elevator> elevators) {
		return findElevator(elevators, 0);
    }
	public Elevator findElevator(List<Elevator> elevators, int requestFloor) {
		
		//sort all elevators that they going down and going up
		List<Elevator> goingUpElevators = elevators.stream().filter(elevator -> elevator.getState() instanceof GoingUpState).collect(Collectors.toList());
		minGoingUp = goingUpElevators.stream().min(Comparator.comparing(elevator -> Math.abs(requestFloor - elevator.getCurrentFloor()))).get();
		
		List<Elevator> goingDownElevators = elevators.stream().filter(elevator -> elevator.getState() instanceof GoingDownState).collect(Collectors.toList());
		minGoingDown = goingDownElevators.stream().min(Comparator.comparing(elevator -> Math.abs(elevator.getCurrentFloor() - requestFloor))).get();
		
		minElevator = (Math.abs(requestFloor - minGoingUp.getCurrentFloor()) > Math.abs(minGoingDown.getCurrentFloor() - requestFloor)) ? minGoingDown : minGoingUp;
	    return minElevator;
	}

}
