package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class reservation {

	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public long duration() {
		long diff = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public String updateDates(Date checkin, Date checkout) {
		
		Date now = new Date();
		
		if (checkin.before(now) || checkout.before(now)) {

			return "Error in reservation: Reservation dates for update must be future dates";

		} else if (!checkout.after(checkin)) {

			return "Error in reservation: Reservation dates ";

		}

		this.checkin = checkin;
		this.checkout = checkout;
		
         return null;
	}

	@Override
	public String toString() {
		return "Room " 
	            + roomNumber 
	            + ", check-in: " 
	            + sdf.format(checkin) 
	            + ", check-out: " 
	            + sdf.format(checkout)
				+ ", " 
	            + duration() 
	            + " nights";

	}
}
