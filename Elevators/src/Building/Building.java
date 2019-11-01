package Building;

import java.util.ArrayList;
import java.util.List;

import elevator.Distributor;
import elevator.Elevator;

public class Building {
	
	private String name;
	private int NumberFloors;
	private List<Elevator> elevators = new ArrayList<Elevator>();
	private Distributor distributor;
	
	public Building(String name, int numberFloors, List<Elevator> elevators) {
		super();
		this.name = name;
		NumberFloors = numberFloors;
		this.elevators = elevators;
	}
	/*
	 * An elevator is requested by default from top floor.
	*/
	public String requestElevator() {
		Elevator elevator = distributor.findElevator(elevators, NumberFloors);
		elevator.serve(NumberFloors);
		return elevator.getName();
	}
	
	/*
	 * request elevator on specific floor
	*/
	public String requestElevator(int floor) {
		Elevator elevator = distributor.findElevator(elevators, floor);
        elevator.serve(floor);
		return elevator.getName();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberFloors() {
		return NumberFloors;
	}
	public void setNumberFloors(int numberFloors) {
		NumberFloors = numberFloors;
	}
	public List<Elevator> getElevators() {
		return elevators;
	}
	public void setElevators(List<Elevator> elevators) {
		this.elevators = elevators;
	}
	@Override
	public String toString() {
		return "Building [name=" + name + ", NumberFloors=" + NumberFloors + ", elevators=" + elevators + "]";
	}
	
	

}
