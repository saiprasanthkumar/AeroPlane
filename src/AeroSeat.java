
public class AeroSeat {
	

	private String seatNo;
	private Integer compartmentNo;
	private Integer rowNo;
	private Integer columnNo;
	private Boolean isOccupaid;
	private SeatType seatType;
	private Passenger passenger;
	
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}
	public Boolean getIsOccupaid() {
		return isOccupaid;
	}
	public void setIsOccupaid(Boolean isOccupaid) {
		this.isOccupaid = isOccupaid;
	}
	public SeatType getSeatType() {
		return seatType;
	}
	public void setSeatType(SeatType seatType) {
		this.seatType = seatType;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Integer getCompartmentNo() {
		return compartmentNo;
	}
	public void setCompartmentNo(Integer compartmentNo) {
		this.compartmentNo = compartmentNo;
	}
	public Integer getRowNo() {
		return rowNo;
	}
	public void setRowNo(Integer rowNo) {
		this.rowNo = rowNo;
	}
	public Integer getColumnNo() {
		return columnNo;
	}
	public void setColumnNo(Integer columnNo) {
		this.columnNo = columnNo;
	}
	
}
