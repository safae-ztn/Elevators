package elevator;

import Building.Building;
import states.ElevatorState;

public class Elevator {
	
	private String name;
	private int currentFloor;
	private ElevatorState state;
	private Building building;
	
	public Elevator(String name, int currentFloor, ElevatorState state, Building building) {
		super();
		this.name = name;
		this.currentFloor = currentFloor;
		this.state = state;
		this.building = building;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}
	public ElevatorState getState() {
		return state;
	}
	public void setState(ElevatorState state) {
		this.state = state;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	@Override
	public String toString() {
		return "Elevator [name=" + name + ", currentFloor=" + currentFloor + ", state=" + state + "]";
	}
	
	public void serve(int floor) {
		if(currentFloor > floor) {//down
			state.down(building, this, floor);
			
		}else if(currentFloor < floor){//up
			state.up(building, this, floor);
		}
	}

}
