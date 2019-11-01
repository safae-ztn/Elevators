package states;

import Building.Building;
import elevator.Elevator;

public class RestingState implements ElevatorState{

	@Override
	public void up(Building building, Elevator elevator, int destination) {
		elevator.setState(new GoingUpState());
		elevator.getState().up(building, elevator, destination);
	}

	@Override
	public void down(Building building, Elevator elevator, int destination) {
		elevator.setState(new GoingDownState());
		elevator.getState().down(building, elevator, destination);
	}

	@Override
	public void rest(Building building, Elevator elevator) {
		System.out.println("the elevator is in resting state ");
	}

}
