package states;

import Building.Building;
import elevator.Elevator;

public interface ElevatorState {
	
    //Going up from the current floor to destination
    public void up(Building building, Elevator elevator, int destination);
    
    //Going down from the current floor to destination 
	public void down(Building building, Elevator elevator, int destination);
		
	// elevator can only resting at the first and last floor
	public void rest(Building building, Elevator elevator);
	
}
