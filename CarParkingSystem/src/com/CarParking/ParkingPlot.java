package com.CarParking;

public class ParkingPlot {
	int slotNumber;
	String plateNumber;
	String carColor;
	
	public ParkingPlot() {
		System.out.println("In Plot");
	}

	public ParkingPlot(int slotNumber, String plateNumber, String carColor) {
		this.slotNumber = slotNumber;
		this.plateNumber = plateNumber;
		this.carColor = carColor;
		
	}

	public int getSlotNumber() {
		return slotNumber;
	}

	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}
	
	
	
}
