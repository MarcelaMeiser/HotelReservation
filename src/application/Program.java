package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/mm/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), formatter);
		System.out.print("Check-out date (dd/mm/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), formatter);
		
		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation + "\n");
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			LocalDate updatedCheckIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			LocalDate updatedCheckOut = LocalDate.parse(sc.next(), formatter);
			
			LocalDate now = LocalDate.now();
			
			if (updatedCheckIn.isBefore(now) || updatedCheckOut.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			
			else if (!updatedCheckOut.isAfter(updatedCheckIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
			reservation.updateDates(updatedCheckIn, updatedCheckOut);
			System.out.println(reservation + "\n");
			}
		
		sc.close();
		}
	}
}
