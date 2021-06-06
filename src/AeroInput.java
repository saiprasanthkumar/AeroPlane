import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AeroInput {
	
	public static Integer passengerCount = 0;
	
	public static SeatType setSeatTypeCornerCompartment(int k, int lastColumn , String compartment) {
		if((k == 0 && compartment.equals("first")) || (k == lastColumn && compartment.equals("last"))) {
			return SeatType.WINDOW;
		} else if(k != 0 && k != lastColumn) {
			return SeatType.MIDDLE;
		}
		return SeatType.AISLE;
	}
	
	public static SeatType setSeatTypeForMiddleCompartment(int k, int lastColumn) {
		if(k != 0 && k != lastColumn) {
			return SeatType.MIDDLE;
		}
		return SeatType.AISLE;
	}
	
	public static List<AeroSeat> getSeatInfo() {
		Scanner sc= new Scanner(System.in);
		List<AeroSeat> aeroSeats = new ArrayList<>();
		System.out.println("Enter the total number of passenger : ");
		passengerCount = sc.nextInt();
		System.out.println("Enter the total number of compartments : ");
		int compartmentCount = sc.nextInt();
		for (int i = 0; i < compartmentCount; i++) {
			System.out.println("Enter the total row and column for compartment : " + (i + 1));
			int rowNo = sc.nextInt();
			int columnNo = sc.nextInt();
			for (int j = 0; j < rowNo; j++) {
				for (int k = 0; k < columnNo; k++) {
					AeroSeat aeroSeat = new AeroSeat();
					aeroSeat.setSeatNo(i + ""+ j+ "" + k);
					aeroSeat.setCompartmentNo(i + 1 );
					aeroSeat.setRowNo( j + 1 );
					aeroSeat.setColumnNo( k + 1 );
					if( i == 0 || i == compartmentCount - 1) {
						aeroSeat.setSeatType(setSeatTypeCornerCompartment(k, columnNo -1, i == 0 ? "first" : "last"));
						aeroSeat.setIsOccupaid(false);
					} else {
						aeroSeat.setSeatType(setSeatTypeForMiddleCompartment(k, columnNo -1));
						aeroSeat.setIsOccupaid(false);
					}
					aeroSeats.add(aeroSeat);
				}
			}
		}
		return aeroSeats;
	}
	
	public static void allocateSeatForpassenger(List<AeroSeat> aeroSeats) {
		for (int i = 1; i < passengerCount; i++) {
			setPassengerToSeat(aeroSeats, SeatType.AISLE, i);
			setPassengerToSeat(aeroSeats, SeatType.WINDOW, i);
			setPassengerToSeat(aeroSeats, SeatType.MIDDLE, i);
		}
	}
	
	public static void setPassengerToSeat(List<AeroSeat> aeroSeats , SeatType seatType , int passNo) {
		Passenger passenger = new Passenger();
		passenger.setPassengerId(passNo);
		aeroSeats.stream().filter(aeroSeat -> aeroSeat.getSeatType() == seatType)
		.forEach(aeroSeat -> {
			aeroSeat.setIsOccupaid(true);
			aeroSeat.setPassenger(passenger);
		});
	}
	
	public static void main(String[] args) {
		List<AeroSeat> aeroSeats = getSeatInfo();
		aeroSeats.sort((AeroSeat s1, AeroSeat s2) -> {
			int i = 0;
			if(i == 0) {
				i = s1.getRowNo().compareTo(s2.getRowNo());
			}
			if(i == 0) {
				i = s1.getCompartmentNo().compareTo(s2.getCompartmentNo());
			}
			if(i == 0) {
				i = s1.getColumnNo().compareTo(s2.getColumnNo());
			}
			return i;
		});
		allocateSeatForpassenger(aeroSeats);
		for (AeroSeat aeroSeat : aeroSeats) {
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
			System.out.println("Seat No : " + aeroSeat.getSeatNo() + " Seat type is : " + aeroSeat.getSeatType() + "Passenger No: " + aeroSeat.getPassenger().getPassengerId());
			System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		}
	}
}
