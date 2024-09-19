package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/mm/yyyy): ");
			LocalDate checkIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			LocalDate checkOut = LocalDate.parse(sc.next(), formatter);
		
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation + "\n");
		
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/mm/yyyy): ");
			checkIn = LocalDate.parse(sc.next(), formatter);
			System.out.print("Check-out date (dd/mm/yyyy): ");
			checkOut = LocalDate.parse(sc.next(), formatter);

			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation + "\n");
		
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Unexpected error!");
		}
		
		sc.close();
	}
}
