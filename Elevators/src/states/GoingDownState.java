package states;

import Building.Building;
import elevator.Elevator;

public final class GoingDownState implements ElevatorState {

	@Override
	public void up(Building building, Elevator elevator, int destination) {
		System.out.println("wait until the elavator go to the top floor !!");
	}
	
	@Override
	public void down(Building building, Elevator elevator, int destination) {
		if(elevator.getCurrentFloor() != destination ) {
			elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
			down(building, elevator, destination);
		}else {
			this.rest(building, elevator);
		}	
	}

	@Override
	public void rest(Building building, Elevator elevator) {
		elevator.setState(new RestingState());
		if(elevator.getCurrentFloor() != 1) {
			//if not in the first floor it will continue going down
			elevator.setState(this);
		}else {
			//the elevator is in the first floor so should be switch his direction
			elevator.setState(new GoingUpState());
		}
	}
	
}
