package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.reservation;

public class program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Roo number: ");
		Integer number = sc.nextInt();
		System.out.print("Check-in: (dd/MM/yyyy: ");
		Date checkin = sdf.parse(sc.next());
		System.out.print("Check-Out: (dd/MM/yyyy: ");
		Date checkount = sdf.parse(sc.next());

		if (!checkount.after(checkin)) {
			System.out.print("Error in reservation: Reservation dates for update must be future dates");
		}

		else {
			reservation reser = new reservation(number, checkin, checkount);
			System.out.print("Reservation:" + reser);

			System.out.println();

			System.out.println(" Enter data to update the reservation: ");
			System.out.print("Check-in: (dd/MM/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.print("Check-Out: (dd/MM/yyyy): ");
			checkount = sdf.parse(sc.next());

			String error = reser.updateDates(checkin, checkount);

			if (error != null) {

				System.out.print("Error in reservation:"  + error);

			} 
			
			else {

				System.out.print("Reservation:" + reser);
			}

		}

		sc.close();
	}

}
