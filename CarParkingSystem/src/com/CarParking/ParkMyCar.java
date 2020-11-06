package com.CarParking;

import java.io.*;


public class ParkMyCar {

	static int maxSlot = 0;
	static ParkingPlot parkingPlotList[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Hello world");
		while (true) {
			String cmd[] = br.readLine().split(" ");
			switch (cmd[0]) {
			case "create_parking_lot": // create parking lot
				if (parkingPlotList == null) {
					maxSlot = Integer.parseInt(cmd[1]);
					parkingPlotList = new ParkingPlot[maxSlot];
					System.out.println("Created a parking lot with " + maxSlot + " slots");
				} else {
					System.out.println("Parking lot already exists");
				}
				break;

			case "park": // allocate parking slot
				if (cmd.length != 3) {
					System.out.println("Invalid Input");
					break;
				}
				System.out.println(allocateAvailableParkingSlot(parkingPlotList.length, cmd[1], cmd[2]));
				break;

			case "leave": //leave parking slot
				if (cmd.length != 2) {
					System.out.println("Invalid Input");
					break;
				}
				if (parkingPlotList[Integer.parseInt(cmd[1]) - 1] == null) {
					System.out.println("Invalid Input");
					break;
				}
				removeParkingSlot(Integer.parseInt(cmd[1]));
				System.out.println("Slot number" + cmd[1] + " is free");
				break;

			case "status": // get current status of parkinglot
				System.out.println("Slot No.\t Registration No.\t Colour");
				displayStatus();
				break;

			case "registration_numbers_for_cars_with_colour": //plate number with given color
				if (cmd.length != 2) {
					System.out.println("Invalid Input");
					break;
				}
				displayParkingPlotWithGivenColour(cmd[1]);
				break;

			case "slot_numbers_for_cars_with_colour": // slot number with given color
				if (cmd.length != 2) {
					System.out.println("Invalid Input");
					break;
				}
				displaySlotNumberWithGivenColour(cmd[1]);
				break;

			case "slot_number_for_registration_number": // slot number with plate number
				if (cmd.length != 2) {
					System.out.println("Invalid Input");
					break;
				}
				displaySlotNumberWithGivenPlateNumber(cmd[1]);
				break;

			case "exit": //terminate process
				System.exit(0);

			default:
				System.out.println("InValid Command");
			}

		}
	}

	public static boolean isParkingSlotFull(int size) {
		if ((size) >= maxSlot) {
			return false;
		}
		return true;
	}

	public static String allocateAvailableParkingSlot(int size, String plateNumber, String carColor) {
		int slot = -1;
		for (int i = 0; i < parkingPlotList.length; i++) {
			if (parkingPlotList[i] == null) {
				slot = i;
				break;
			}
		}
		if (slot == -1) {
			return "Sorry, parking lot is full";
		}
		ParkingPlot parkingPlot = new ParkingPlot(slot, plateNumber, carColor);
		parkingPlotList[slot] = parkingPlot;
		return "Allocated slot number: " + (slot + 1);
	}

	public static void removeParkingSlot(int SlotNumber) {
		parkingPlotList[--SlotNumber] = null;
	}

	public static void displayStatus() {
		for (int i = 0; i < parkingPlotList.length; i++) {
			if (parkingPlotList[i] != null) {
				System.out.println(parkingPlotList[i].getSlotNumber() + 1 + "\t" + parkingPlotList[i].getPlateNumber()
						+ "\t" + parkingPlotList[i].getCarColor());
			}
		}
	}

	public static void displayParkingPlotWithGivenColour(String colour) {
		boolean isPresent = false;
		for (int i = 0; i < parkingPlotList.length; i++) {
			if (parkingPlotList[i] != null && parkingPlotList[i].getCarColor().equals(colour)) {
				System.out.print(parkingPlotList[i].getPlateNumber() + ", ");
				isPresent = true;
			}
		}
		if (!isPresent)
			System.out.println("Not Found");
	}

	public static void displaySlotNumberWithGivenColour(String colour) {
		boolean isPresent = false;
		for (int i = 0; i < parkingPlotList.length; i++) {
			if (parkingPlotList[i] != null && parkingPlotList[i].getCarColor().equals(colour)) {
				System.out.print(parkingPlotList[i].getSlotNumber() + 1 + ", ");
				isPresent = true;
			}
		}
		if (!isPresent)
			System.out.println("Not Found");
	}

	public static void displaySlotNumberWithGivenPlateNumber(String PlateNumber) {
		boolean isPresent = false;
		for (int i = 0; i < parkingPlotList.length; i++) {
			if (parkingPlotList[i] != null && parkingPlotList[i].getPlateNumber().equals(PlateNumber)) {
				System.out.print(parkingPlotList[i].getSlotNumber() + 1);
				isPresent = true;
			}
		}
		if (!isPresent)
			System.out.println("Not Found");
	}
}
