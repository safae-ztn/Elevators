package states;

import Building.Building;
import elevator.Elevator;

public class GoingUpState implements ElevatorState {

	@Override
	public void up(Building building, Elevator elevator, int destination) {
		if(elevator.getCurrentFloor() != destination ) {
			elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
			up(building, elevator, destination);
		}else {
			this.rest(building, elevator);
		}
	}

	@Override
	public void down(Building building, Elevator elevator, int destination) {
		System.out.print("wait until the elevator go to the first floor ");
	}

	@Override
	public void rest(Building building, Elevator elevator) {
		elevator.setState(new RestingState());
		//if not in the top floor it will continue going up
		if(elevator.getCurrentFloor() != building.getNumberFloors()) {
			elevator.setState(this);
		}else {
			// switch his direction
			elevator.setState(new GoingDownState());
		}
	}	
}
